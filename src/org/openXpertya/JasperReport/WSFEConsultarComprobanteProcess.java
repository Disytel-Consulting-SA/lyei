package org.openXpertya.JasperReport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
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
import org.openXpertya.util.Util;

import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.ServiceLocator;
import FEV1.dif.afip.gov.ar.ServiceSoap;
import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceLocator;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub;
import fexv1.dif.afip.gov.ar.ClsFEXAuthRequest;
import fexv1.dif.afip.gov.ar.ClsFEXGetCMP;
import fexv1.dif.afip.gov.ar.FEXGetCMPResponse;

public class WSFEConsultarComprobanteProcess extends SvrProcess {

	/** Etiquta token dentro del archivo */
	public static final String TA_TAG_TOKEN = "token";
	/** Etiquta sign dentro del archivo */
	public static final String TA_TAG_SIGN  = "sign";
	
	/** Nomina de comprobantes recuperados.  En cada posicion de la lista hay una map con todos los datos, o bien ERROR_KEY si no se pudo recuperar */
	private ArrayList<HashMap<String, String>> retrievedDocuments = new ArrayList<HashMap<String, String>>();

	/** Numero de reintentos por documento */
	public static final int RETRY_MAX = 3;
	/** Numero de documentos a consultar por ejecucion */
	public static final int MAX_DOCS = 100;
	
	/** Mapeo entre tipos de documentos con los tipos definidos por AFIP */
	public static HashMap<String, Integer> docTypeMap = new HashMap<String, Integer>();

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

	/** Numero de comprobante (desde) */
	private long cbteNroFrom = -1;
	/** Numero de comprobante (hasta) */
	private long cbteNroTo = -1;
	/** Recuperacion un CAE en particular: punto de venta */
	private int ptoVta = -1;
	/** Recuperacion un CAE en particular: tipo de comprobante */
	private int cbteTipo = -1;
	/** Tipo de documento (nombre) */
	private String cbteTipoNombre = "";
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** Tipo de documento sobre el cual consultar */
	private MDocType aDocType;
	
	/** DataSource para interaccion con Jasper */ 
	protected WSFEConsultarComprobanteDataSource ds;

	/** Contexto local */
	private Properties localCtx;
	
	/** Nombre de transacción local */
	private String localTrxName;
	
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
		// Comprobantes tipo E
		docTypeMap.put("CIE", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_FacturaDeExportaciónE));
		docTypeMap.put("CDNE", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotaDeDébitoPorOperacionesEnElExterior));
		docTypeMap.put("CCNE", Integer.parseInt(X_C_DocType.DOCSUBTYPECAE_NotaDeCréditoPorOperacionesEnElExterior));
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
	
	public WSFEConsultarComprobanteProcess() {}
		
	public WSFEConsultarComprobanteProcess(Properties ctx, Integer clientID, Integer orgID, String trxName) {
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
// Comentado: el punto de venta se determina a partir del tipo de documento			
//			else if (name.equalsIgnoreCase("PtoVta")) {
//				ptoVta = para[i].getParameterAsInt();
//			}
			else if (name.equalsIgnoreCase("C_DocType_ID")) {
				setaDocType(new MDocType(getCtx(), para[i].getParameterAsInt(), get_TrxName()));
				setCbteTipo(getCbteTipo(getaDocType()));
				setCbteTipoNombre(getaDocType().getName());
				setPtoVta(getaDocType().getPosNumber()); 
			}
			else if (name.equalsIgnoreCase("NroCbte")) {
				setCbteNroFrom(((BigDecimal)para[i].getParameter()).longValue());
				setCbteNroTo(((BigDecimal)para[i].getParameter_To()).longValue());
			}
		}
		clientID = getaDocType().getAD_Client_ID();
		orgID = getaDocType().getAD_Org_ID();
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
		
		System.out.println("--> WSFEConsultarComprobante. Resultado OK: " + 
				" CbteDesde:"+ response.getResultGet().getCbteDesde() +
				" - CbteFch:" + response.getResultGet().getCbteFch() +
				" - ImpTotal:" + response.getResultGet().getImpTotal() +
				" - MonCotiz:" + response.getResultGet().getMonCotiz() +
				" - MonId:" + response.getResultGet().getMonId());
		
		return retValues; 
	}
	
	/**
	 * Retorna el tipo de comprobante segun la denominacion de AFIP a partir del doctype 
	 */
	public int getCbteTipo(X_C_DocType aDocType) {
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
		if (getCbteNroFrom() == -1 || getCbteNroTo() == -1 || getCbteNroFrom() > getCbteNroTo())
			throw new Exception("Rango de comprobantes indicado invalido");
		if (getCbteNroTo() - getCbteNroFrom() > MAX_DOCS )
			throw new Exception("Rango de comprobantes a consultar muy extenso. Máximo por ejecución: " + MAX_DOCS);
		if (getPtoVta() == -1)
			throw new Exception("Punto de venta indicado invalido");
		if (getCbteTipo() == -1)
			throw new Exception("Tipo de documento indicado invalido");
	}
	
	
	/** 
	 * Carga inicial 
	 * Sobrecarga para poder enviar el punto de venta correspondiente
	 * dREHER
	 * */
	public void loadInitialValues() throws Exception {
		loadInitialValues(0);
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:getPtoVta()), getOrgID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + (ptoVta>0?ptoVta:getPtoVta())
					+ " y la organizacion del tipo de documento (" + getOrgID() + ")");
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, getCtx(), posConfig.getCurrentEnvironment());
		token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
		sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);		
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + getClientID() + ". " + ex.getMessage());
		}
	}

	/** Consultar cada una de los comprobantes */
	public void queryInvoices() throws Exception {
		// Consultar cada comprobante e incorporar a la nómina de resultados
		for (long i = getCbteNroFrom(); i <= getCbteNroTo(); i++) {
			// Comprobante CAEA (mtxca)?
			if (LP_C_LYEIElectronicPOSConfig.CAEMETHOD_CAEA.equals(posConfig.getCAEMethod())) {
				getRetrievedDocuments().add(consultarCAEA(i, getCbteTipo(), "", getPtoVta()));
				continue;
			}
			// Comprobante CAE (wsfe/wsfex)?
			if (!isExportacion(getCbteTipo())) {
				getRetrievedDocuments().add(consultarCAE(i, getCbteTipo(), "", getPtoVta()));
			}
			else {
				getRetrievedDocuments().add(consultarCAEX(i, getCbteTipo(), "", getPtoVta()));
			}
		}
	}

	
	/** Genera y visuaiza el informe Jasper */
	protected void createReport() throws Exception {
		ds = new WSFEConsultarComprobanteDataSource(getRetrievedDocuments());
		
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
				
		jasperwrapper.addParameter("P_CBTE_FROM", getCbteNroFrom());
		jasperwrapper.addParameter("P_CBTE_TO", getCbteNroTo());
		jasperwrapper.addParameter("P_PTOVTA", getPtoVta());
		jasperwrapper.addParameter("P_TIPO_CBTE", getCbteTipoNombre());
		
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
	 
	
	/** Genera la consulta al WS de AFIP por el comprobante dado */
	public HashMap<String, String> consultarCAEX(long cbteNro, int cbteTipo, String cbeTipoDesc, int ptoVta) throws Exception {
		
		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("DocNro", 	"" + cbteNro);
		retValues.put("CbteTipo", 	"" + cbteTipo);
		retValues.put("PtoVta", 	"" + ptoVta);
		
		// Recuperar el servicio
		fexv1.dif.afip.gov.ar.ServiceLocator locator = new fexv1.dif.afip.gov.ar.ServiceLocator();
 		// Se intenta recuperar preferencia indicando URL de consulta. En caso de no existir se toma valor por defecto (URL actual de producción)
		String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSFEXV1_PREFIX, posConfig.getCurrentEnvironment());
		locator.setServiceSoapEndpointAddress(endPoint);
		fexv1.dif.afip.gov.ar.ServiceSoap service = null;
		try {
			service = locator.getServiceSoap();
		} catch (Exception e) {
			retValues.put("Resultado", "Error acceso WSFEX: " + e.toString());
			log.saveError("[WSFEXCC] Error acceso WSFEX: ", e.toString());
			return retValues;
		}
		
		ClsFEXAuthRequest auth = new ClsFEXAuthRequest();
		ClsFEXGetCMP consulta = new ClsFEXGetCMP();
		
		auth.setCuit(cuit);
		auth.setSign(sign);
		auth.setToken(token);
		
		consulta.setCbte_nro(cbteNro);
		consulta.setCbte_tipo((short)cbteTipo);
		consulta.setPunto_vta((short)ptoVta);

		// Invocacion a la operacion
		FEXGetCMPResponse response = null;
		int tryNo = 0;
		boolean endLoop = false;
		while (!endLoop) {
			try {
				tryNo++;
				response = service.FEXGetCMP(auth, consulta);
				response.toString();	// <-- NPE check
				endLoop = true;
			} catch (Exception e) {
				// Al capturar una excepción al RETRY_MAX intento, no continuar intentando
				if (tryNo == RETRY_MAX) {
					// Error al interactuar con WSFE de AFIP
					retValues.put("Resultado", "Error de conexión: " + e.toString());
					log.saveError("[WSFEXCC] Error de conexión: ", e.toString());
					return retValues;
				}
			}
		}
		
		// Error recibido desde WSFEX de AFIP
		if (response.getFEXErr() != null && !"OK".equalsIgnoreCase(response.getFEXErr().getErrMsg())) {
			StringBuffer completeErrorStr = new StringBuffer();
			completeErrorStr.append(response.getFEXErr().getErrCode()).append(". ").append(response.getFEXErr().getErrMsg());
			retValues.put("Resultado", "Error: " + completeErrorStr.toString());
			log.saveError("[WSFEXCC] Error para cbteNro " + cbteNro + ", cbteTipo " + cbteTipo + ", ptoVta " + ptoVta + ": ", completeErrorStr.toString());
			return retValues;
		}
		
		// En este punto se supone valores recibidos conformes a un comprobante encontrado
		retValues.put("CbteDesde", 			"" + response.getFEXResultGet().getCbte_nro());
		retValues.put("CbteFch", 			"" + response.getFEXResultGet().getFecha_cbte());
		retValues.put("CbteHasta", 			"" + response.getFEXResultGet().getCbte_nro());
		retValues.put("CbteTipo", 			"" + response.getFEXResultGet().getCbte_tipo());
		retValues.put("CodAutorizacion", 	"" + response.getFEXResultGet().getCae());
		retValues.put("DocNro", 			"" + response.getFEXResultGet().getCbte_nro());
		retValues.put("DocTipo", 			"" + response.getFEXResultGet().getTipo_expo());
		retValues.put("FchVto", 			"" + response.getFEXResultGet().getFch_venc_Cae());
		retValues.put("ImpTotal", 			"" + response.getFEXResultGet().getImp_total());
		retValues.put("MonCotiz", 			"" + response.getFEXResultGet().getMoneda_ctz());
		retValues.put("MonId", 				"" + response.getFEXResultGet().getMoneda_Id());
		retValues.put("PtoVta", 			"" + response.getFEXResultGet().getPunto_vta());
		retValues.put("Resultado", 			"" + response.getFEXResultGet().getResultado());
		
		return retValues; 
	}

	
	/** Genera la consulta al WS de AFIP mtxca por el comprobante dado */
	public HashMap<String, String> consultarCAEA(long cbteNro, int cbteTipo, String cbeTipoDesc, int ptoVta) throws Exception {
	
		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("DocNro", 	"" + cbteNro);
		retValues.put("CbteTipo", 	"" + cbteTipo);
		retValues.put("PtoVta", 	"" + ptoVta);
		
		// Auth
		AuthRequestType auth = new AuthRequestType();
		auth.setCuitRepresentada(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
		auth.setSign(sign);
		auth.setToken(token);
				
		// Config de conexion al WS
		String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment());		
		MTXCAServiceLocator locator = new MTXCAServiceLocator();
		locator.setMTXCAServiceHttpSoap11EndpointEndpointAddress(endPoint);
		MTXCAServicePortType caeaService = locator.getMTXCAServiceHttpSoap11Endpoint();
		((MTXCAServiceSoap11BindingStub)caeaService).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment()));

		// Info de tipo de comprobante y punto de venta
		ConsultaComprobanteRequestType cc = new ConsultaComprobanteRequestType();
		cc.setCodigoTipoComprobante((short)cbteTipo);
		cc.setNumeroPuntoVenta(posConfig.getPOS());
		cc.setNumeroComprobante(cbteNro);

		// Invocar al servicio
		ConsultarComprobanteRequestType parameters = new ConsultarComprobanteRequestType();
		parameters.setAuthRequest(auth);
		parameters.setConsultaComprobanteRequest(cc);
		
		// Invocacion a la operacion
		ConsultarComprobanteResponseType response = null;
		int tryNo = 0;
		boolean endLoop = false;
		while (!endLoop) {
			try {
				tryNo++;
				response = caeaService.consultarComprobante(parameters);
				response.toString();	// <-- NPE check
				endLoop = true;
			} catch (Exception e) {
				// Al capturar una excepción al RETRY_MAX intento, no continuar intentando
				if (tryNo == RETRY_MAX) {
					// Error al interactuar con WSFE de AFIP
					retValues.put("Resultado", "Error de conexión: " + e.toString());
					log.saveError("[WSMTXCACC] Error de conexión: ", e.toString());
					return retValues;
				}
			}
		}
		
		// Error recibido desde WSMTXCA de AFIP
		if (response.getArrayErrores() != null && response.getArrayErrores().length>0) {
			StringBuffer completeErrorStr = new StringBuffer();
			for (CodigoDescripcionType error : response.getArrayErrores()) {
				completeErrorStr.append(error.getDescripcion()).append(". ");
			}
			retValues.put("Resultado", "Error: " + completeErrorStr.toString());
			log.saveError("[WSMTXCACC] Error para cbteNro " + cbteNro + ", cbteTipo " + cbteTipo + ", ptoVta " + ptoVta + ": ", completeErrorStr.toString());
			return retValues;
		}
				
		// En este punto se supone valores recibidos conformes a un comprobante encontrado
		retValues.put("CbteDesde", 			"" + response.getComprobante().getNumeroComprobante());
		retValues.put("CbteFch", 			"" + response.getComprobante().getFechaEmision());
		retValues.put("CbteHasta", 			"" + response.getComprobante().getNumeroComprobante());
		retValues.put("CbteTipo", 			"" + response.getComprobante().getCodigoTipoDocumento());
		retValues.put("CodAutorizacion", 	"" + response.getComprobante().getCodigoAutorizacion());
		retValues.put("Concepto", 			"" + response.getComprobante().getCodigoConcepto());
		retValues.put("DocNro", 			"" + response.getComprobante().getNumeroDocumento());
		retValues.put("DocTipo", 			"" + response.getComprobante().getCodigoTipoDocumento());
		//retValues.put("EmisionTipo", 		"" + response.getComprobante().get?);
		//retValues.put("FchProceso", 		"" + response.getComprobante().get?);
		retValues.put("FchServDesde", 		"" + response.getComprobante().getFechaServicioDesde());
		retValues.put("FchServHasta", 		"" + response.getComprobante().getFechaServicioHasta());
		retValues.put("FchVto", 			"" + response.getComprobante().getFechaVencimiento());
		retValues.put("FchVtoPago", 		"" + response.getComprobante().getFechaVencimientoPago());
		retValues.put("ImpIVA", 			"" + response.getComprobante().getImporteGravado());
		retValues.put("ImpNeto", 			"" + response.getComprobante().getImporteSubtotal());
		retValues.put("ImpOpEx", 			"" + response.getComprobante().getImporteExento());
		retValues.put("ImpTotal", 			"" + response.getComprobante().getImporteTotal());
		retValues.put("ImpTotConc", 		"" + response.getComprobante().getImporteNoGravado());
		retValues.put("ImpTrib", 			"" + response.getComprobante().getImporteOtrosTributos());
		retValues.put("MonCotiz", 			"" + response.getComprobante().getCotizacionMoneda());
		retValues.put("MonId", 				"" + response.getComprobante().getCodigoMoneda());
		retValues.put("PtoVta", 			"" + response.getComprobante().getNumeroPuntoVenta());
		//retValues.put("Resultado", 			"" + response.getComprobante().get?);
		
		return retValues;
	}

	public MDocType getaDocType() {
		return aDocType;
	}


	public void setaDocType(MDocType aDocType) {
		System.out.println("WSFEConsultarComprobanteProcess... setaDocType");
		this.aDocType = aDocType;
	}


	public int getCbteTipo() {
		return cbteTipo;
	}


	public void setCbteTipo(int cbteTipo) {
		this.cbteTipo = cbteTipo;
	}


	public int getPtoVta() {
		return ptoVta;
	}


	public void setPtoVta(int ptoVta) {
		this.ptoVta = ptoVta;
	}


	public String getCbteTipoNombre() {
		return cbteTipoNombre;
	}


	public void setCbteTipoNombre(String cbteTipoNombre) {
		this.cbteTipoNombre = cbteTipoNombre;
	}


	public long getCbteNroFrom() {
		return cbteNroFrom;
	}


	public void setCbteNroFrom(long cbteNroFrom) {
		this.cbteNroFrom = cbteNroFrom;
	}


	public long getCbteNroTo() {
		return cbteNroTo;
	}


	public void setCbteNroTo(long cbteNroTo) {
		this.cbteNroTo = cbteNroTo;
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
		if (!Util.isEmpty(clientID, true)) {
			return clientID;
		} else {
			return getaDocType().getAD_Client_ID();
		}
	}
	
	public Integer getOrgID() {
		if (!Util.isEmpty(orgID, true)) {
			return orgID;
		} else {
			return getaDocType().getAD_Org_ID();
		}
	}

	public ArrayList<HashMap<String, String>> getRetrievedDocuments() {
		return retrievedDocuments;
	}

	public void setRetrievedDocuments(ArrayList<HashMap<String, String>> retrievedDocuments) {
		this.retrievedDocuments = retrievedDocuments;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	
	
}
