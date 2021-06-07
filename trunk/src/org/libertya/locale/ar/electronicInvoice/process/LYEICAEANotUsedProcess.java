package org.libertya.locale.ar.electronicInvoice.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
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
	/** Request asociado al caea */
	protected LP_C_LYEICAEARequest targetRequest = null;
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
	        else if( name.equalsIgnoreCase( "Environment" ))
	        	prodEnv = "P".equals((String)para[ i ].getParameter());	        
        }
	}

	@Override
	protected String doIt() throws Exception {
		
		try {
			// Cargar el request asociado al caea especificado (si es que se especifo uno)
			loadTargetRequestCAEA();
			
			// Recorrer puntos de venta
			PreparedStatement pstmt = DB.prepareStatement(getPtosVtasQuery(), null);
			ResultSet rs = pstmt.executeQuery();
			result.append("CAEA no utilizado a informar: ").append(caea).append(". \n<br>");
			while (rs.next()) {
				// ID Configuracion Pto Vta electronico
				int posConfigID = rs.getInt("C_LYEIElectronicPOSConfig_ID");
				// Punto de venta
				int pos = rs.getInt("pos");
				// Cantidad emitidos
				int cant = rs.getInt("cantidad");
							
				// Si se emitieron comprobantes para el punto de venta en cuestion, saltear
				if (cant > 0) {
					result.append(" Ptovta ").append(pos).append(" con comprobantes, omitiendo. \n<br>");
					continue;
				}
				
				// verificar si ya existe la entrada en c_lyeicaeanotused 
				if (alreadyNotifiedNotUsed(posConfigID)) {
					result.append(" Ptovta ").append(pos).append(" no utilizado ya informado, omitiendo. \n<br>");
					continue;
				}
				
				// Notificar CAEA no utilizado
				try {
					result.append(" Ptovta ").append(pos).append(" sin comprobantes, informando... ");
					String status = notifyPosNotUsed(pos);
					result.append(status).append(". \n<br>");
				} catch (Exception e) {
					result.append(e.getMessage()).append(". \n<br>");
				}
				
			}
			String retValue =
					"Finalizado. Detalle: \n<br> " +
					" \n<br>" +
					result.toString();
			System.out.println(retValue.replace("<br>", ""));
			return retValue;
		} catch (Exception e) {
			String err = "Error: " + e.getMessage();
			System.out.println(err);
			throw e;
		}
	}
	
	
	/** Invocaion al WS para notificacion de CAEA no utilizado por PtoVta */
	protected String notifyPosNotUsed(int pos) throws Exception {
		
		// Obtener la configuracion de FE segun la factura
		MLYEIElectronicPOSConfig posConfig = MLYEIElectronicPOSConfig.get(pos, getCtx(), null);
		
		// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
		if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()==0) {
			throw new Exception("Configuracion de punto de venta electronico nulo o no inicializado correctamente");		
		}
		MLYEIElectronicInvoiceConfig genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);

		// WSAA -> token & sign
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, posConfig.getCtx(), posConfig.getCurrentEnvironment());
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
		request.setCAEA(Long.parseLong(caea));
		
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

		// Nueva entrada en CAEAs no utilizados o actualizar una existente
		int id = DB.getSQLValue(null, 		" SELECT C_LYEICAEANotUsed_ID " +
											" FROM C_LYEICAEANotUsed " +
											" WHERE C_LYEICAEARequest_ID = " + targetRequest.getC_LYEICAEARequest_ID() + 
											" AND C_LYEIElectronicPOSConfig_ID = " + posConfig.getC_LYEIElectronicPOSConfig_ID() +
											" AND environment = '" + (prodEnv?LP_C_LYEICAEANotUsed.ENVIRONMENT_Prod:LP_C_LYEICAEANotUsed.ENVIRONMENT_Homo) + "'");
		LP_C_LYEICAEANotUsed notUsed = new LP_C_LYEICAEANotUsed(getCtx(), (id<0?0:id), null);
		
		// Compañía / organizacion
		notUsed.setClientOrg(clientID, orgID);
		
		// Request asociado
		notUsed.setC_LYEICAEARequest_ID(targetRequest.getC_LYEICAEARequest_ID());
		
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
		if (!notUsed.save()) {
			throw new Exception("Error almacenando entrada en CAEA no utilizados: " + CLogger.retrieveErrorAsString());
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
				"			AND CAE = '" + caea + "' " + 
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
	protected LP_C_LYEICAEARequest loadTargetRequestCAEA() throws Exception {
		// Se forzó un caea?
		if (targetRequest!=null) {
			return targetRequest;
		}
	
		// Se obtiene el caea con fechahasta vencido mas reciente.
		// Si se especifica un caea en los parametros de invocacion, no se consideran las fechas 
		PreparedStatement pstmt = DB.prepareStatement(
										" SELECT * " +
										" FROM c_lyeicaearequest " +
										" WHERE AD_Client_ID = " + clientID + 
										(orgID > 0 ? " AND AD_Org_ID = " + orgID : "") +
										(Util.isEmpty(caea) ? " AND fechahasta::date <= now()::date " : "") +
										(Util.isEmpty(caea) ? " AND fechatopeinforme::date >= now()::date " : "") +
										" AND environment = '" + (prodEnv?LP_C_LYEICAEARequest.ENVIRONMENT_Prod:LP_C_LYEICAEARequest.ENVIRONMENT_Homo) + "' " +
										(!Util.isEmpty(caea) ? " AND caea = '" + caea + "' " : "") +  
										" ORDER BY fechahasta DESC " +
										" LIMIT 1", null, true);
		ResultSet rs = pstmt.executeQuery();
		// Se pudo recuperar uno?
		if (!rs.next()) {
			String detail = !Util.isEmpty(caea) ? ("para el CAEA ingresado: " + caea) : " donde la fecha actual se encuentre entre la fecha hasta y la fecha tope informe";
			throw new Exception("No se ha podido recuperar un CAEA a informar del historico de solicitudes " + detail);
		}
		
		targetRequest = new LP_C_LYEICAEARequest(getCtx(), rs, null);
		// Se asigna para los casos en que no se especificó 
		caea = targetRequest.getCAEA();
		
		rs.close();
		pstmt.close();
		
		return targetRequest;
	}
	
	/** Retorna true si ya fue notificado y aceptado un ptovta para un CAEA en particular */
	protected boolean alreadyNotifiedNotUsed(int posConfigID) throws Exception {
		int cant = DB.getSQLValue(null, 	" SELECT COUNT(1) " +
											" FROM c_lyeicaeanotused nu " +
											" INNER JOIN c_lyeicaearequest r ON nu.c_lyeicaearequest_id = r.c_lyeicaearequest_id " + 
											" WHERE nu.C_LYEIElectronicPOSConfig_ID = " + posConfigID +
											" AND r.caea = '" + caea + "'" +
											" AND nu.status = 'A'");
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

		/** Compañía */
		int clientID = -1;
		/** Organización */
		int orgID = -1;
		/** Ambiente (H o P) */
		String env = LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo;
		/** Indicar un CAEA en particular */
		String caea = null;
		
		for (String arg : args) {
			if (arg.toLowerCase().startsWith(PARAM_HELP)) {
				showHelp(getHelpMessage());
			} else if (arg.toLowerCase().startsWith(PARAM_CLIENT)) {
				clientID = Integer.parseInt(arg.substring(PARAM_CLIENT.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ORG)) {
				orgID = Integer.parseInt(arg.substring(PARAM_ORG.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ENV)) {
				env = arg.substring(PARAM_ENV.length());
			} else if (arg.toLowerCase().startsWith(PARAM_CAEA)) {
				caea = arg.substring(PARAM_CAEA.length());				
			} else {
				showHelp("ERROR: Argumento " + arg + " no reconocido");
				System.exit(1);
			}
		}
		
		// Argumentos de invocacion
		System.out.println("[Client] Argumentos: " + Arrays.toString(args));
		
	  	// OXP_HOME seteada?
	  	String oxpHomeDir = System.getenv("OXP_HOME"); 
	  	if (oxpHomeDir == null)
	  		showHelp("ERROR: La variable de entorno OXP_HOME no está seteada ");

	  	// Cargar el entorno basico
	  	System.setProperty("OXP_HOME", oxpHomeDir);
	  	if (!OpenXpertya.startupEnvironment( false ))
	  		showHelp("ERROR: Error al iniciar el ambiente cliente.  Revise la configuración");
	  	System.out.println("[Client] Host: " + DB.getDatabaseInfo());
	  	
	  	// Configuracion
	  	if (clientID == -1 || orgID == -1)
	  		showHelp("ERROR: Debe especificar ID compañía y ID de organizacion (la cual puede ser 0)");
	  	Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
	  	Env.setContext(Env.getCtx(), "#AD_Org_ID", orgID);
	  	
	  	// Moneda de la compañía
	  	int currencyID = DB.getSQLValue(null, "select c_currency_id from c_acctschema where ad_client_id = " + clientID);
	  	if (currencyID<=0) {
	  		showHelp("No se pudo determinar la moneda de la compañia desde el esquema contable");
	  	}
	  	Env.setContext(Env.getCtx(), "$C_Currency_ID", currencyID);

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
			// Parametros: Environment
			addProcessParam(pi, "Environment", env);
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
				"   " + PARAM_ENV 				+ " ambiente (H)omologacio o (P)roduccion. Si no se especifica, se supone homologacion \n" +
				"   " + PARAM_CAEA		 		+ " informar un CAEA no utilizado en particular (opcional). De no informarse se toma el CAEA vencido más reciente. \n" +				
				" \n" +
				" El nombre de argumento y su correspondiente valor no deben tener espacios!";
	}
}

