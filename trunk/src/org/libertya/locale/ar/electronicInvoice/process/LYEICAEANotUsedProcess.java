package org.libertya.locale.ar.electronicInvoice.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEICAEANotUsed;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEICAEARequest;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEICommons;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFE;
import org.openXpertya.OpenXpertya;
import org.openXpertya.model.MProcess;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.ProcessInfoUtil;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceLocator;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub;

public class LYEICAEANotUsedProcess extends SvrProcess {

	/** Compañía */
	protected int clientID = -1;
	/** Organización */
	protected int orgID = -1;
	/** CAEA a notificar */
	protected String caea = null;
	/** Ambiente de produccion? */
	protected boolean prodEnv;
	
	/** Detalle de la ejecucion */
	protected StringBuffer result = new StringBuffer();
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
        for( int i = 0;i < para.length;i++ ) {
	        String name = para[ i ].getParameterName();
	        if (para[ i ].getParameter() == null) ;
	        else if( name.equalsIgnoreCase( "AD_Client_ID" ))
	        	clientID = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "AD_Org_ID" ))
	        	orgID = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "CAEA" ))
	        	caea = (String)para[ i ].getParameter();	
	        else if( name.equalsIgnoreCase( "ProdEnv" ))
	        	prodEnv = "P".equals((String)para[ i ].getParameter());	        
        }
	}

	@Override
	protected String doIt() throws Exception {
		PreparedStatement pstmt = DB.prepareStatement(getPtosVtasQuery(), null);
		ResultSet rs = pstmt.executeQuery();
		result.append("CAEA no utilizado a informar: ").append(getTargetCAEA()).append(". \n");
		while (rs.next()) {
			// ID Configuracion Pto Vta electronico
			int posConfigID = rs.getInt("C_LYEIElectronicPOSConfig");
			// Punto de venta
			int pos = rs.getInt("pos");
			// Cantidad emitidos
			int cant = rs.getInt("cantidad");
			
			
			// Si se emitieron comprobantes para el punto de venta en cuestion, saltear
			if (cant > 0) {
				result.append(" Ptovta ").append(pos).append(" con comprobantes, omitiendo. \n");
				continue;
			}
			
			// verificar si ya existe la entrada en c_lyeicaeanotused 
			if (alreadyNotifiedNotUsed(posConfigID)) {
				result.append(" Ptovta ").append(pos).append(" no utilizado ya informado, omitiendo. \n");
			}
			
			// Notificar CAEA no utilizado
			try {
				result.append(" Ptovta ").append(pos).append(" sin comprobantes, informando... ");
				String status = notifyPosNotUsed(pos);
				result.append(status).append(". \n");
			} catch (Exception e) {
				result.append(e.getMessage()).append(". \n");
			}
			
		}
		return "Finalizado. \n " +
				" \n" +
				result.toString();
	}
	
	
	/** Invocaion al WS para notificacion de CAEA no utilizado por PtoVta */
	protected String notifyPosNotUsed(int pos) throws Exception {
		
		// Obtener la configuracion de FE segun la factura
		MLYEIElectronicPOSConfig posConfig = MLYEIElectronicPOSConfig.get(pos, orgID, getCtx(), null);
		
		// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
		if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()==0) {
			throw new Exception("Configuracion de punto de venta electronico nulo o no inicializado correctamente");		
		}
		MLYEIElectronicInvoiceConfig genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);

		// WSAA -> token & sign
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment());
		String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
		String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);

		// Auth
		AuthRequestType auth = new AuthRequestType();
		auth.setCuitRepresentada(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
		auth.setSign(sign);
		auth.setToken(token);
		
		// Conectar al endpoint
		String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment());		
		MTXCAServiceLocator locator = new MTXCAServiceLocator();
		locator.setMTXCAServiceHttpSoap11EndpointEndpointAddress(endPoint);
		MTXCAServicePortType caeaService = locator.getMTXCAServiceHttpSoap11Endpoint();
		((MTXCAServiceSoap11BindingStub)caeaService).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment()));

		// Invocacion a la operacion
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getCAEANotifyNotUsedLog(pos, endPoint));
		InformarCAEANoUtilizadoPtoVtaRequestType request = new InformarCAEANoUtilizadoPtoVtaRequestType(); 
		
		request.setAuthRequest(auth);
		request.setNumeroPuntoVenta(pos);
		request.setCAEA(Long.parseLong(getTargetCAEA()));
		
		InformarCAEANoUtilizadoPtoVtaResponseType response = caeaService.informarCAEANoUtilizadoPtoVta(request);
		
		/* === Procesar la respuesta === */
		// Hubo respuesta?
		if (response==null) {
			throw new Exception("Sin respuesta por parte de AFIP");
		}
		
		// Pending de adaptar MTXCAServiceSoap11BindingStub para dar soporte a XMLRequest/Response. Ver revision r10 de LYEI
		// String requestXML = ((MTXCAServiceSoap11BindingStub)caeaService).getCallRequestXML();
		// String responseXML = ((MTXCAServiceSoap11BindingStub)caeaService).getCallResponseXML();
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getCAEANotifyNotUsedResponseLog(pos, response));

		// Nueva entrada en CAEAs no utilizados
		LP_C_LYEICAEANotUsed notUsed = new LP_C_LYEICAEANotUsed(getCtx(), 0, null);
		
		// Compañía / organizacion
		notUsed.setClientOrg(clientID, orgID);
		
		// Ambiente: homo o prod
		notUsed.setEnvironment(prodEnv?LP_C_LYEICAEANotUsed.ENVIRONMENT_Prod:LP_C_LYEICAEANotUsed.ENVIRONMENT_Homo);
		
		// Configuracion Punto de Venta asociado 
		notUsed.setC_LYEIElectronicPOSConfig_ID(posConfig.getC_LYEIElectronicPOSConfig_ID());
		
		// Respuesta por parte de AFIP: A o R
		notUsed.setStatus(response.getResultado().getValue());
		
		// Nomina de erorres
		String errors = LYEICommons.stringFromArray(response.getArrayErrores());
		if (errors!=null) {
			notUsed.setDetail(errors);
		}
		
		// Persistir entrada
		if (notUsed.save()) {
			throw new Exception("Error almacenando entra en CAEA no utilizados: " + CLogger.retrieveErrorAsString());
		}
		
		// Retorna el valor devuelto por AFIP
		return response.getResultado().getValue();
	}
	
	
	/** Recupera el query que informa para cada punto de venta, el numero de facturas generadas con el CAEA en cuestion */
	protected String getPtosVtasQuery() throws Exception {
		// Pos - Cantidad de facturas
		return 	" SELECT pc.C_LYEIElectronicPOSConfig_id, " +
				"		 pc.pos, " +
				"		 (	SELECT COUNT(1) " +
				" 			FROM C_INVOICE " +
				" 			WHERE ad_client_id = " + clientID +
				(orgID > 0 ? " AND AD_Org_ID = " + orgID : "") +
				"			AND puntodeventa = pc.pos " +
				"			AND CAE = '" + getTargetCAEA() + "' " + 
				" 			AND lyeicaeainformed IS NOT NULL" +
				"		) as cantidad " +
				" FROM C_LYEIElectronicPOSConfig pc" +
				" WHERE pc.ad_client_id = " + clientID + 
				(orgID > 0 ? " AND pc.AD_Org_ID = " + orgID : "") +
				" AND pc.isactive = 'Y' " +
				" AND pc.currentenvironment = '" + (prodEnv?LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod:LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo) + "' " +
				" AND pc.caemethod = 'A' ";			
	}
	
	
	/** Obtiene el CAEA sobre el cual informar */
	protected String getTargetCAEA() throws Exception {
		// Se forzó un caea?
		if (!Util.isEmpty(caea)) {
			return caea;
		}
	
		// Se obtiene el caea con fechahasta vencido mas reciente. 
		caea = DB.getSQLValueString(	null, 
										" SELECT CAEA " +
										" FROM c_lyeicaearequest " +
										" WHERE AD_Client_ID = ? " +
										(orgID > 0 ? " AND AD_Org_ID = " + orgID : "") +
										" AND fechahasta < now()::date " +
										" AND environment = '" + (prodEnv?LP_C_LYEICAEARequest.ENVIRONMENT_Prod:LP_C_LYEICAEARequest.ENVIRONMENT_Homo) + "' " +
										" ORDER BY fechahasta DESC " +
										" LIMIT 1",
										clientID);
		
		// Se pudo recuperar uno?
		if (Util.isEmpty(caea))
			throw new Exception("No se ha podido recuperar un CAEA del historico de solicitudes.");
		
		return caea;
	}
	
	/** Retorna true si ya fue notificado un ptovta para un CAEA en particular */
	protected boolean alreadyNotifiedNotUsed(int posConfigID) throws Exception {
		int cant = DB.getSQLValue(null, 	" SELECT COUNT(1) " +
											" FROM c_lyeicaeanotused nu " +
											" INNER JOIN c_lyeicaearequest r ON nu.c_lyeicaearequest_id = r.c_lyeicaearequest_id " + 
											" WHERE nu.C_LYEIElectronicPOSConfig = " + posConfigID +
											" AND r.caea = '" + getTargetCAEA() + "'" );
		return cant>0;
	}
	
	/** Log actividad de notificacion de CAEA no usado */
	protected String getCAEANotifyNotUsedLog(int pos, String endPoint) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Iniciando CAEA no usado para ptovta ")
				.append(pos).append(" en ")
				.append(endPoint);
		return retValue.toString();
	}	
	
	/** Respuesta en notificacion CAEA no usado */
	protected String getCAEANotifyNotUsedResponseLog(int pos, InformarCAEANoUtilizadoPtoVtaResponseType response) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Respuesta CAEA no usado para ptovta ")
				.append(pos).append(": ")
				.append(response.getResultado().getValue());
		return retValue.toString();
	}
	
	/** Error en notificacion CAEA no usado */
	protected String getCAEANotifyNotUsedErrorLog(int pos, Exception e) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Error CAEA no usado para ptovta ")
				.append(pos).append(": ")
				.append(e.toString());
		return retValue.toString();
	}
	
	// ------------------------ INVOCACION DESDE TERMINAL -------------------------
	
	/** UID del proceso sincronizador */
	public static final String CAEA_NOTIFY_NOT_USED_PROCESS_UID	= 	"LYEI-AD_Process-20210430114308069-545287";
	
	/** Parametro ayuda */
	static final String PARAM_HELP			 			=	"-help";
	/** Parametro compañía */
	static final String PARAM_CLIENT					=	"-client";
	/** Parametro compañía */
	static final String PARAM_ORG						=	"-org";
	/** Parametro ambiente (H o P) */
	static final String PARAM_ENV						= 	"-env";
	/** Parametro Notificar CAEA en particular */
	static final String PARAM_CAEA						=	"-caea";

	public static void main(String[] args) {

		int clientID = -1;
		int orgID = -1;
		boolean prodEnv = true;
		String caea = null;
		
		for (String arg : args) {
			if (arg.toLowerCase().startsWith(PARAM_HELP)) {
				showHelp(getHelpMessage());
			} else if (arg.toLowerCase().startsWith(PARAM_CLIENT)) {
				clientID = Integer.parseInt(arg.substring(PARAM_CLIENT.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ORG)) {
				orgID = Integer.parseInt(arg.substring(PARAM_ORG.length()));
			} else if (arg.toLowerCase().equals(PARAM_ENV)) {
				prodEnv = "P".equalsIgnoreCase(arg.substring(PARAM_ENV.length()));
			} else if (arg.toLowerCase().equals(PARAM_CAEA)) {
				caea = arg.substring(PARAM_CAEA.length());				
			} else {
				showHelp("ERROR: Argumento " + arg + " no reconocido");
				System.exit(1);
			}
		}
		
	  	// OXP_HOME seteada?
	  	String oxpHomeDir = System.getenv("OXP_HOME"); 
	  	if (oxpHomeDir == null)
	  		showHelp("ERROR: La variable de entorno OXP_HOME no está seteada ");

	  	// Cargar el entorno basico
	  	System.setProperty("OXP_HOME", oxpHomeDir);
	  	if (!OpenXpertya.startupEnvironment( false ))
	  		showHelp("ERROR: Error al iniciar el ambiente cliente.  Revise la configuración");
	  	
	  	// Configuracion
	  	if (clientID == -1 || orgID == -1)
	  		showHelp("ERROR: Debe especificar ID compañía y ID de organizacion (la cual puede ser 0)");
	  	Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
	  	Env.setContext(Env.getCtx(), "#AD_Org_ID", orgID);

	  	// Invocacion
	  	try {
			// Recuperar ID del proceso 
			int processID = DB.getSQLValue(null, " SELECT AD_PROCESS_ID FROM AD_PROCESS WHERE AD_ComponentObjectUID = '" + CAEA_NOTIFY_NOT_USED_PROCESS_UID + "' ");
			if (processID<=0) {
				showHelp("No se ha podido recuperar la informacion del proceso de notificacion de CAEA no utilizado");
			}
			ProcessInfo pi = new ProcessInfo("CAEA Notify Not Used", processID);
			
			// Parametros: cia
			addProcessParam(pi, "AD_Client_ID", clientID);
			// Parametros: org
			addProcessParam(pi, "AD_Org_ID", orgID);
			// Parametros: prodEnv
			addProcessParam(pi, "ProdEnv", prodEnv);
			// Parametros: caea
			addProcessParam(pi, "CAEA", caea!=null?caea:null);			
			
			// Invocar al proceso
			MProcess process = new MProcess(Env.getCtx(), processID, null);
			MProcess.execute(Env.getCtx(), process, pi, null);
	  	} catch (Exception e) {	  		
	  		e.printStackTrace();
	  	}	  	
	}

	/** Incorporar un nuevo parametro para la ejecucion del proceso */
	protected static void addProcessParam(ProcessInfo pi, String paramName, Object paramValue) {
		ProcessInfoParameter aParam = new ProcessInfoParameter(paramName, paramValue, null, null, null);
		pi.setParameter(ProcessInfoUtil.addToArray(pi.getParameter(), aParam));	
	}
	
	
	/** Ayuda al usuario */
	protected static void showHelp(String message)
	{
		System.out.println(message);
		System.exit(1);
	}
	
	/** Mesajes de ayuda al usuario */
	protected static String getHelpMessage() {
		return 	" Informar CAEA no usado \n\n" +
				" Argumentos: \n" +
				"   " + PARAM_HELP 				+ " muestra esta ayuda \n" + 
				"   " + PARAM_CLIENT 			+ " AD_Client_ID (obligatorio) \n" +
				"   " + PARAM_ORG 				+ " AD_Org_ID (obligatorio, puede ser 0) \n" +				
				"   " + PARAM_ENV 				+ " ambiente (H)omologacio o (P)roduccion (obligatorio) \n" +
				"   " + PARAM_CAEA		 		+ " informar un CAEA no utilizado en particular (opcional). De no informarse se toma el CAEA vencido más reciente. \n" +				
				" \n" +
				" El nombre de argumento y su correspondiente valor no deben tener espacios!";
	}
}
