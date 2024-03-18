package wsfecred.afip.gob.ar.FECredService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFECRED;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MPOSJournal;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;


/**
 * Clase que permite validar si una EC tiene que facturar miPyme y porque valor minimo
 *  
 * dREHER
 */


public class FECred {
	
	/** ID de la compañía */
	Integer clientID = null;
	/** ID de la organización */
	Integer orgID = null;
	/** CUIT de la compañía */
	Long cuit = null;	
	/** Recuperacion un CUIT en particular: punto de venta */
	private int ptoVta = 0;
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** CUIT del tercero a consultar */
	private Long CUIT = 0L; // para probar 30506730038
	private Date fecha = new Date();
	/** Contexto local */
	private Properties localCtx;
	/** Nombre de transacción local */
	private String localTrxName;
	
	private BigDecimal amount = Env.ZERO;
	private boolean isMiPyme = false;
	private Timestamp Updated = Env.getDate();

	public FECred() {
		clientID = Env.getAD_Client_ID(getCtx());
		orgID = Env.getAD_Org_ID(getCtx());
	}
	
	/** Genera la consulta al WS de AFIP por el CUIT dado */
	public HashMap<String, String> consultarCUIT(long cuit, Date fecha) throws Exception {
		
		// Seteo datos iniciales
		setCUIT(cuit);
		setFecha(fecha);
		
		debug("consultarCUIT. cuit=" + getCUIT() + " fecha=" + getFecha());
		
		// Validaciones preliminares
		checkPreconditions();
		// Carga de valores iniciales
		loadInitialValues();

		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("CUIT", 	"" + cuit);
		
		LYEIWSFECRED wsfecred = new LYEIWSFECRED(posConfig);
		ConsultarMontoObligadoRecepcionReturnType re = wsfecred.consultaFromAFIP(CUIT, fecha);
		if(re!=null) {
			BigDecimal montoDesde = re.getMontoDesde();
			SiNoSimpleType sino = re.getObligado();
			String yes = sino.getValue();

			// En este punto se supone valores recibidos conformes a un CUIT encontrado
			retValues.put("Corresponde",			"" + yes);
			retValues.put("Monto Minimo",			"" + (montoDesde!=null?montoDesde:""));
			
			setMiPyme(yes.equals("S"));
			setAmount(montoDesde);
			
			debug("Corresponde miPyme:" + (isMiPyme?"Si":"No") + " Monto minimo:" + montoDesde);
			
		}else
			debug("consultarCUIT. Se produjo un error!");
		
		return retValues; 
	}
	
	private void debug(String string) {
		System.out.println("==> FECred." + string);
	}

	/** Validaciones preliminares */
	protected void checkPreconditions() throws Exception {
		if (CUIT < 99999999)
			throw new Exception("CUIT no valido!");
		
		debug("Valido CUIT");
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
					throw new Exception("No se encontro punto de venta en la caja abierta de este usuario!");
			}else
				throw new Exception("No se encontro una caja abierta para este usuario!");
			
		}
		
		loadInitialValues(ptoVta);
		
		debug("Carga datos inciales de configuracion...");
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:0), getOrgID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + (ptoVta>0?ptoVta:0)
					+ " y la organizacion del tipo de documento (" + getOrgID() + ")");
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + getClientID() + ". " + ex.getMessage());
		}
	}
	
	/**
	 * Guarda la informacion de miPyme en la Entidad Comercial
	 * @param bp
	 * dREHER
	 */
	public void updatedBPMiPyme(MBPartner bp) {
		
		System.out.println("FECred.updatedBPMiPyme. Guarda la info de MiPyme en la EC CUIT=" + bp.getTaxID());
		
		bp.set_Value("IsMiPyme", isMiPyme());
		bp.set_Value("MiPymeUpdated", getUpdated());
		bp.set_Value("MiPymeAmount", getAmount());
		
		if(bp.save())
			System.out.println("FECred.updatedBPMiPyme. Guardo data en el cliente CUIT:" + bp.getTaxID());
		
	}
	
	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cuit) {
		this.CUIT = cuit;
	}

	public Properties getCtx() {
		if (localCtx != null) {
			return localCtx;
		} else {
			return Env.getCtx();
		}
	}
	
	public String get_TrxName() {
		if (!Util.isEmpty(localTrxName, true)) {
			return localTrxName;
		} else {
			return null;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isMiPyme() {
		return isMiPyme;
	}

	public void setMiPyme(boolean isMiPyme) {
		this.isMiPyme = isMiPyme;
	}

	public Timestamp getUpdated() {
		return Updated;
	}

	public void setUpdated(Timestamp updated) {
		Updated = updated;
	}

}
