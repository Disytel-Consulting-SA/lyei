package org.libertya.locale.ar.electronicInvoice.process;

import java.util.Arrays;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIMTXCA;
import org.openXpertya.OpenXpertya;
import org.openXpertya.model.MProcess;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.ProcessInfoUtil;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public class LYEICAEARequestProcess extends SvrProcess {


	/** Compañía */
	protected int clientID;
	/** Organización */
	protected int orgID;
	/** Ambiente de produccion? */
	protected boolean prodEnv;
	/** Pedir para el periodo actual o para el siguiente */
	protected boolean currentPeriod;


	
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
	        else if( name.equalsIgnoreCase( "Environment" ))
	        	prodEnv = "P".equals((String)para[ i ].getParameter());
	        else if( name.equalsIgnoreCase( "CurrentPeriod" ))
	        	currentPeriod = "Y".equals((String)para[ i ].getParameter());	        
        }
	}
	
	@Override
	protected String doIt() throws Exception {
		LYEIMTXCA mtxca = null;
		try {
			// Recuperar CAEA
			mtxca = new LYEIMTXCA(clientID, orgID, prodEnv, currentPeriod, getCtx());
			mtxca.requestCAEA();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		if (mtxca==null || mtxca.currentCAEA()==null) {
			String err = "No fue posible recuperar un CAEA. Verifique la informacion de los logs. ";
			System.out.println(err);
			throw new Exception(err);
		} else {
			String val = "CAEA obtenido/recuperado: " + mtxca.currentCAEA().getCAEA();
			System.out.println(val);
			return val;
		}
	}

	
	// ------------------------ INVOCACION DESDE TERMINAL -------------------------

	
	/** UID del proceso sincronizador */
	public static final String CAEA_REQUEST_PROCESS_UID	= 	"LYEI-AD_Process-20210423093156401-074898";
	
	
	/** Parametro ayuda */
	static final String PARAM_HELP			 			=	"-help";
	/** Parametro compañía */
	static final String PARAM_CLIENT					=	"-client";
	/** Parametro compañía */
	static final String PARAM_ORG						=	"-org";
	/** Parametro ambiente (H o P) */
	static final String PARAM_ENV						= 	"-env";
	/** Parametro ambiente periodo actual */
	static final String PARAM_CURRENT_PERIOD			= 	"-current";
	
	
	
	public static void main(String[] args) {

		/** Compañía */
		int clientID = -1;
		/** Organización */
		int orgID = -1;
		/** Ambiente (H o P) */
		String env = LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo;
		/** Periodo actual o siguiente inmediato? */
		boolean currentPeriod = true;
		
		for (String arg : args) {
			if (arg.toLowerCase().startsWith(PARAM_HELP)) {
				showHelp(getHelpMessage());
			} else if (arg.toLowerCase().startsWith(PARAM_CLIENT)) {
				clientID = Integer.parseInt(arg.substring(PARAM_CLIENT.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ORG)) {
				orgID = Integer.parseInt(arg.substring(PARAM_ORG.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ENV)) {
				env = arg.substring(PARAM_ENV.length());
			} else if (arg.toLowerCase().startsWith(PARAM_CURRENT_PERIOD)) {
				currentPeriod = "Y".equalsIgnoreCase(arg.substring(PARAM_CURRENT_PERIOD.length()));
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
			int processID = DB.getSQLValue(null, " SELECT AD_PROCESS_ID FROM AD_PROCESS WHERE AD_ComponentObjectUID = '" + CAEA_REQUEST_PROCESS_UID + "' ");
			if (processID<=0) {
				showHelp("No se ha podido recuperar la informacion del proceso de pedido de CAEA");
			}
			ProcessInfo pi = new ProcessInfo("CAEA Request", processID);
			
			// Parametros: cia
			addProcessParam(pi, "AD_Client_ID", clientID);
			// Parametros: org
			addProcessParam(pi, "AD_Org_ID", orgID);
			// Parametros: prod o homo
			addProcessParam(pi, "Environment", env);
			// Parametros: periodo actual o siguiente
			addProcessParam(pi, "CurrentPeriod", currentPeriod?"Y":"N");
			
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
		return 	" Pedido de CAEA \n\n" +
				" Argumentos: \n" +
				"   " + PARAM_HELP 				+ " muestra esta ayuda \n" + 
				"   " + PARAM_CLIENT 			+ " AD_Client_ID (obligatorio) \n" +
				"   " + PARAM_ORG 				+ " AD_Org_ID (obligatorio, puede ser 0) \n" +				
				"   " + PARAM_ENV 				+ " ambiente (H)omologacio o (P)roduccion. Si no se especifica, se supone homologacion \n" +
				"   " + PARAM_CURRENT_PERIOD 	+ " periodo actual? (Y/N) Si no es actual pide por el siguiente. Si no se especifica, se supone el actual \n" +				
				" \n" +
				" El AD_Client_ID y el AD_Org_ID se utilizan para determinar la configuración utilizar.\n" +
				" El nombre de argumento y su correspondiente valor no deben tener espacios!";
	}


}
