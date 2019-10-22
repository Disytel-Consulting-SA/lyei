package org.openXpertya.JasperReport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.openXpertya.JasperReport.DataSource.WSFEConsultarComprobanteDataSource;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.Env;

import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.ServiceLocator;
import FEV1.dif.afip.gov.ar.ServiceSoap;

public class WSFEConsultarComprobanteProcess extends SvrProcess {

	/** Etiquta token dentro del archivo */
	public static final String TA_TAG_TOKEN = "token";
	/** Etiquta sign dentro del archivo */
	public static final String TA_TAG_SIGN  = "sign";
	
	/** Nomina de comprobantes recuperados.  En cada posicion de la lista hay una map con todos los datos, o bien ERROR_KEY si no se pudo recuperar */
	protected ArrayList<HashMap<String, String>> retrievedDocuments = new ArrayList<HashMap<String, String>>();

	/** Numero de reintentos por documento */
	public static final int RETRY_MAX = 3;
	/** Numero de documentos a consultar por ejecucion */
	public static final int MAX_DOCS = 100;
	
	/** Mapeo entre tipos de documentos con los tipos definidos por AFIP */
	public static HashMap<String, Integer> docTypeMap = new HashMap<String, Integer>();

	/** ID de la compañía */
	Integer clientID = null;
	/** CUIT de la compañía */
	Long cuit = null;	
	/** Sign de acceso a WS de AFIP */
	String sign = null;
	/** Token de acceso a WS de AFIP */
	String token = null;

	/** Numero de comprobante (desde) */
	protected long cbteNroFrom = -1;
	/** Numero de comprobante (hasta) */
	protected long cbteNroTo = -1;
	/** Recuperacion un CAE en particular: punto de venta */
	protected int ptoVta = -1;
	/** Recuperacion un CAE en particular: tipo de comprobante */
	protected int cbteTipo = -1;
	/** Tipo de documento (nombre) */
	protected String cbteTipoNombre = "";
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** Tipo de documento sobre el cual consultar */
	protected MDocType aDocType;
	
	/** DataSource para interaccion con Jasper */ 
	protected WSFEConsultarComprobanteDataSource ds;


	
	static {
		// === TIPOS DE DOCUMENTOS A CONTEMPLAR EN LA BUSQUEDA === 
		
		// Comprobantes tipo A 
		docTypeMap.put("CIA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasA));
		docTypeMap.put("CDNA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoA));
		docTypeMap.put("CCNA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoA));
		// Comprobantes tipo B		
		docTypeMap.put("CIB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasB));
		docTypeMap.put("CDNB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoB));
		docTypeMap.put("CCNB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoB));
		// Comprobantes tipo C		
		docTypeMap.put("CIC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasC));
		docTypeMap.put("CDNC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoC));
		docTypeMap.put("CCNC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoC));
		// Comprobantes tipo M		
		docTypeMap.put("CIM", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasM));
		docTypeMap.put("CDNM", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoM)); 
		docTypeMap.put("CCNM", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoM)); 
		// Comprobantes tipo MiPyME A 
		docTypeMap.put("CIMPA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEA));
		docTypeMap.put("CDNMPA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEA));
		docTypeMap.put("CCNMPA", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEA));
		// Comprobantes tipo BMiPyME B		
		docTypeMap.put("CIMPB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEB));
		docTypeMap.put("CDNMPB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEB));
		docTypeMap.put("CCNMPB", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEB));
		// Comprobantes tipo MiPyME C	
		docTypeMap.put("CIMPC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEC));
		docTypeMap.put("CDNMPC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEC));
		docTypeMap.put("CCNMPC", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEC));
	}
	
		
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();

			if (para[i].getParameter() == null)
				;
// Comentado: el punto de venta se determina a partir del tipo de documento			
//			else if (name.equalsIgnoreCase("PtoVta")) {
//				ptoVta = para[i].getParameterAsInt();
//			}
			else if (name.equalsIgnoreCase("C_DocType_ID")) {
				aDocType = new MDocType(getCtx(), para[i].getParameterAsInt(), get_TrxName());
				cbteTipo = getCbteTipo(aDocType);
				cbteTipoNombre = aDocType.getName();
				ptoVta = aDocType.getPosNumber(); 
			}
			else if (name.equalsIgnoreCase("NroCbte")) {
				cbteNroFrom = ((BigDecimal)para[i].getParameter()).longValue();
				cbteNroTo = ((BigDecimal)para[i].getParameter_To()).longValue();
			}
		}
	}
	
	
	@Override
	protected String doIt() throws Exception {

		// Validaciones preliminares
		checkPreconditions();
		// Carga de valores iniciales
		loadInitialValues();
		// Consulta de comprobantes
		queryInvoices();
		// Crear el informe
		createReport();
		
		return "";
	}

	
	/** Recupera el tipo de documento según AFIP a partir del tipo de la factura */
	protected static int getCbteTipo(String docTypeKey) throws Exception {
		int i=0;
		while (!Character.isDigit(docTypeKey.charAt(i))) i++;
		return docTypeMap.get(docTypeKey.substring(0, i));
	}
	
	
	/** Genera la consulta al WS de AFIP por el comprobante dado */
	protected HashMap<String, String> consultarCAE(long cbteNro, int cbteTipo, String cbeTipoDesc, int ptoVta) throws Exception {
		
		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("DocNro", 	"" + cbteNro);
		retValues.put("CbteTipo", 	"" + cbteTipo);
		retValues.put("PtoVta", 	"" + ptoVta);
		
		// Conexion a WSFEV1
		ServiceLocator locator = new ServiceLocator();
		String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSFEV1_PREFIX, posConfig.getCurrentEnvironment());
		locator.setServiceSoapEndpointAddress(endPoint);
		ServiceSoap wsfe = locator.getServiceSoap();
		
		FEAuthRequest auth = new FEAuthRequest();
		FECompConsultaReq consulta = new FECompConsultaReq();
		
		auth.setCuit(cuit);
		auth.setSign(sign);
		auth.setToken(token);
		
		consulta.setCbteNro(cbteNro);
		consulta.setCbteTipo(cbteTipo);
		consulta.setPtoVta(ptoVta);

		// Invocacion a la operacion
		FECompConsultaResponse response = null;
		int tryNo = 0;
		boolean endLoop = false;
		while (!endLoop) {
			try {
				tryNo++;
				response = wsfe.FECompConsultar(auth, consulta);
				response.toString();	// <-- NPE check
				endLoop = true;
			} catch (Exception e) {
				// Al capturar una excepción al RETRY_MAX intento, no continuar intentando
				if (tryNo == RETRY_MAX) {
					// Error al interactuar con WSFE de AFIP
					retValues.put("Resultado", "Error de conexión: " + e.toString());
					log.saveError("[WSFECC] Error de conexión: ", e.toString());
					return retValues;
				}
			}
		}
		
		// Error recibido desde WSFE de AFIP
		if (response.getErrors() != null && response.getErrors().length > 0) {
			StringBuffer completeErrorStr = new StringBuffer();
			for (Err error : response.getErrors()) {
				StringBuffer errorStr = new StringBuffer();
				errorStr.append(error.getCode()).append(". ").append(error.getMsg());
				completeErrorStr.append(errorStr);
			}
			retValues.put("Resultado", "Error: " + completeErrorStr.toString());
			log.saveError("[WSFECC] Error para cbteNro " + cbteNro + ", cbteTipo " + cbteTipo + ", ptoVta " + ptoVta + ": ", completeErrorStr.toString());
			return retValues;
		}
		
		// En este punto se supone valores recibidos conformes a un comprobante encontrado
		retValues.put("CbteDesde", 			"" + response.getResultGet().getCbteDesde());
		retValues.put("CbteFch", 			"" + response.getResultGet().getCbteFch());
		retValues.put("CbteHasta", 			"" + response.getResultGet().getCbteHasta());
		retValues.put("CbteTipo", 			"" + response.getResultGet().getCbteTipo());
		retValues.put("CodAutorizacion", 	"" + response.getResultGet().getCodAutorizacion());
		retValues.put("Concepto", 			"" + response.getResultGet().getConcepto());
		retValues.put("DocNro", 			"" + response.getResultGet().getDocNro());
		retValues.put("DocTipo", 			"" + response.getResultGet().getDocTipo());
		retValues.put("EmisionTipo", 		"" + response.getResultGet().getEmisionTipo());
		retValues.put("FchProceso", 		"" + response.getResultGet().getFchProceso());
		retValues.put("FchServDesde", 		"" + response.getResultGet().getFchServDesde());
		retValues.put("FchServHasta", 		"" + response.getResultGet().getFchServHasta());
		retValues.put("FchVto", 			"" + response.getResultGet().getFchVto());
		retValues.put("FchVtoPago", 		"" + response.getResultGet().getFchVtoPago());
		retValues.put("ImpIVA", 			"" + response.getResultGet().getImpIVA());
		retValues.put("ImpNeto", 			"" + response.getResultGet().getImpNeto());
		retValues.put("ImpOpEx", 			"" + response.getResultGet().getImpOpEx());
		retValues.put("ImpTotal", 			"" + response.getResultGet().getImpTotal());
		retValues.put("ImpTotConc", 		"" + response.getResultGet().getImpTotConc());
		retValues.put("ImpTrib", 			"" + response.getResultGet().getImpTrib());
		retValues.put("MonCotiz", 			"" + response.getResultGet().getMonCotiz());
		retValues.put("MonId", 				"" + response.getResultGet().getMonId());
		retValues.put("PtoVta", 			"" + response.getResultGet().getPtoVta());
		retValues.put("Resultado", 			"" + response.getResultGet().getResultado());
		
		return retValues; 
	}
	
	/**
	 * Retorna el tipo de comprobante segun la denominacion de AFIP a partir del doctype 
	 */
	protected int getCbteTipo(X_C_DocType aDocType) {
		try {
			StringBuffer type = new StringBuffer();
			for (int i = 0; i < aDocType.getDocTypeKey().length(); i++) {
				if (Character.isDigit(aDocType.getDocTypeKey().charAt(i)))
					break;
				type.append(aDocType.getDocTypeKey().charAt(i));
			}
			return docTypeMap.get(type.toString());
		} catch (Exception e) {
			return -1;
		}
	}

	/** Validaciones preliminares */
	protected void checkPreconditions() throws Exception {
		if (cbteNroFrom == -1 || cbteNroTo == -1 || cbteNroFrom > cbteNroTo)
			throw new Exception("Rango de comprobantes indicado invalido");
		if (cbteNroTo - cbteNroFrom > MAX_DOCS )
			throw new Exception("Rango de comprobantes a consultar muy extenso. Máximo por ejecución: " + MAX_DOCS);
		if (ptoVta == -1)
			throw new Exception("Punto de venta indicado invalido");
		if (cbteTipo == -1)
			throw new Exception("Tipo de documento indicado invalido");
	}
	
	
	/** Carga inicial */
	protected void loadInitialValues() throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get(ptoVta, aDocType.getAD_Org_ID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + ptoVta + " y la organizacion del tipo de documento (" + aDocType.getAD_Org_ID() + ")");
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, getCtx(), posConfig.getCurrentEnvironment());
		token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
		sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);		
		// ClientID
		clientID = getAD_Client_ID();
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + clientID + ". " + ex.getMessage());
		}
			

	}

	/** Consultar cada una de los comprobantes */
	protected void queryInvoices() throws Exception {
		// Consultar cada comprobante e incorporar a la nómina de resultados
		for (long i = cbteNroFrom; i <= cbteNroTo; i++)
			retrievedDocuments.add(consultarCAE(i, cbteTipo, "", ptoVta));
	}

	
	/** Genera y visuaiza el informe Jasper */
	protected void createReport() throws Exception {
		ds = new WSFEConsultarComprobanteDataSource(retrievedDocuments);
		
		try {
			ds.loadData();
		} catch (RuntimeException e) {
			throw new RuntimeException("No se pueden cargar los datos del informe: " + e.getMessage(), e);
		}
		
		// Determinar JasperReport para wrapper, tabla y registro actual
		ProcessInfo base_pi = getProcessInfo();
		int AD_Process_ID = base_pi.getAD_Process_ID();
		MProcess proceso = MProcess.get(Env.getCtx(), AD_Process_ID);
		if (proceso.isJasperReport() != true)
			throw new Exception ("No es informe Jasper");
		MJasperReport jasperwrapper = new MJasperReport(getCtx(), proceso.getAD_JasperReport_ID(), get_TrxName());
				
		jasperwrapper.addParameter("P_CBTE_FROM", cbteNroFrom);
		jasperwrapper.addParameter("P_CBTE_TO", cbteNroTo);
		jasperwrapper.addParameter("P_PTOVTA", ptoVta);
		jasperwrapper.addParameter("P_TIPO_CBTE", cbteTipoNombre);
		
		try {
			jasperwrapper.fillReport(ds);
			jasperwrapper.showReport(getProcessInfo());
		} catch (RuntimeException e) {
			throw new RuntimeException("No se ha podido rellenar el informe: " + e.getMessage(), e);
		}
	}
	
	
	/**
	 * Retorna true si es un comprobante de exportacion a partir de un tipoCbte según denominacion de AFIP 
	 */
	protected boolean isExportacion(int tipoCbte) {
		return (tipoCbte == Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturaDeExportaciónE) ||
				tipoCbte == Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotaDeCréditoPorOperacionesEnElExterior) ||
				tipoCbte == Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotaDeDébitoPorOperacionesEnElExterior) || 
				tipoCbte == Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturasDeExportacionSimplificado));
	}	
	 

	
}
