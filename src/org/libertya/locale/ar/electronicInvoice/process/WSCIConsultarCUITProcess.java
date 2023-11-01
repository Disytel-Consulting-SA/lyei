package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSCI;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MPOSJournal;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import FEV1.dif.afip.gov.ar.FEAuthRequest;
import sr.puc.server.ws.soap.a5.PersonaReturn;

public class WSCIConsultarCUITProcess extends SvrProcess {

	/** Etiquta token dentro del archivo */
	public static final String TA_TAG_TOKEN = "token";
	/** Etiquta sign dentro del archivo */
	public static final String TA_TAG_SIGN  = "sign";
	
	/** Numero de reintentos por documento */
	public static final int RETRY_MAX = 3;
	/** Numero de documentos a consultar por ejecucion */
	public static final int MAX_DOCS = 100;
	
	/** ID de la compañía */
	Integer clientID = null;
	/** ID de la organización */
	Integer orgID = null;
	/** CUIT de la compañía */
	Long cuit = null;	
	/** Sign de acceso a WS de AFIP */
	String sign = null;
	/** Token de acceso a WS de AFIP */
	String token = null;

	/** Recuperacion un CUIT en particular: punto de venta */
	private int ptoVta = 0;

	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	
	/** CUIT del tercero a consultar */
	private Long CUIT = 0L;

	/** Contexto local */
	private Properties localCtx;
	
	/** Nombre de transacción local */
	private String localTrxName;

	public WSCIConsultarCUITProcess() {}
		
	public WSCIConsultarCUITProcess(Properties ctx, Integer clientID, Integer orgID, String trxName) {
		this.localCtx = ctx;
		this.localTrxName = trxName;
		this.clientID = clientID;
		this.orgID = orgID;
	}
		
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();

			if (para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("CUIT")) {
				setCUIT(((BigDecimal)para[i].getParameter()).longValue());
			}
		}
		clientID = Env.getAD_Client_ID(getCtx());
		orgID = Env.getAD_Org_ID(getCtx());
	}
	
	
	@Override
	protected String doIt() throws Exception {

		// Validaciones preliminares
		checkPreconditions();
		// Carga de valores iniciales
		loadInitialValues();
		// Consulta de CUIT
		consultarCUIT(getCUIT());
		
		return "";
	}

	/** Genera la consulta al WS de AFIP por el CUIT dado */
	protected HashMap<String, String> consultarCUIT(long cuit) throws Exception {
		
		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("CUIT", 	"" + cuit);
		
		// Conexion a WSCI 
		// TODO ver que debe validar contra el servicio de padron, sino se recibe un error del tipo:
		// Token recibido es para el servicio [wsfe], deberia ser para servicio [ws_sr_padron_a5,ws_sr_constancia_inscripcion].
		FEAuthRequest auth = new FEAuthRequest();
		
		auth.setCuit(cuit);
		auth.setSign(sign);
		auth.setToken(token);
		
		LYEIWSCI wsci = new LYEIWSCI(posConfig);
		PersonaReturn persona = wsci.consultaFromAFIP(CUIT);
				
		// Error recibido desde WSCI de AFIP
		if (persona.getErrorConstancia() != null && persona.getErrorConstancia().getError().length > 0) {
			StringBuffer completeErrorStr = new StringBuffer();
			for (String error : persona.getErrorConstancia().getError()) {
				StringBuffer errorStr = new StringBuffer();
				errorStr.append(error);
				completeErrorStr.append(errorStr);
			}
			retValues.put("Resultado", "Error: " + completeErrorStr.toString());
			log.saveError("[WSFECI] Error para CUIT " + cuit + ": ", completeErrorStr.toString());
			return retValues;
		}
		
		// En este punto se supone valores recibidos conformes a un CUIT encontrado
		retValues.put("DatosGenerales",			"" + persona.getDatosGenerales());
		retValues.put("DatosRegimenGeneral",	"" + persona.getDatosRegimenGeneral());
		retValues.put("DatosMonotributo",		"" + persona.getDatosMonotributo());
		retValues.put("DatosMetadata",			"" + persona.getMetadata());
			
		return retValues; 
	}
	
	/** Validaciones preliminares */
	protected void checkPreconditions() throws Exception {
		if (CUIT < 999999999)
			throw new Exception("CUIT no valido!");
	}
	
	/** 
	 * Carga inicial 
	 * Sobrecarga para poder enviar el punto de venta correspondiente
	 * dREHER
	 * */
	public void loadInitialValues() throws Exception {
		
		if (MPOSJournal.isActivated() && Util.isEmpty(ptoVta, true) ) {
			MPOSJournal caja = MPOSJournal.get(Env.getCtx(), 
												Env.getAD_User_ID(getCtx()), 
												Env.getDate(), 
												new String[]{"IP"}, 
												get_TrxName());
			if(caja!=null) {
				MPOS pos = caja.getPOS();
				if(pos!=null)
					ptoVta = pos.getPOSNumber();
				else
					this.addLog(0, null, null, "No se encontro punto de venta en la caja abierta de este usuario!");
			}else
				this.addLog(0, null, null, "No se encontro una caja abierta para este usuario!");
			
		}
		
		loadInitialValues(ptoVta);
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:0), getOrgID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + (ptoVta>0?ptoVta:0)
					+ " y la organizacion del tipo de documento (" + getOrgID() + ")");
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, getCtx(), posConfig.getCurrentEnvironment());
		token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
		sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);		
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + getClientID() + ". " + ex.getMessage());
		}
	}

	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cuit) {
		this.CUIT = cuit;
	}

	@Override
	public Properties getCtx() {
		if (localCtx != null) {
			return localCtx;
		} else {
			return super.getCtx();
		}
	}
	
	@Override
	public String get_TrxName() {
		if (!Util.isEmpty(localTrxName, true)) {
			return localTrxName;
		} else {
			return super.get_TrxName();
		}
	}
	
	public Integer getClientID() {
		return clientID;
	}
	
	public Integer getOrgID() {
		return orgID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	
}
