package org.libertya.locale.ar.electronicInvoice.utils;

import java.io.File;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisProperties;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.openXpertya.db.CConnection;
import org.openXpertya.util.CLogMgt;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Ini;
import org.openXpertya.util.Secure;

import sr.puc.server.ws.soap.a5.PersonaReturn;
import sr.puc.server.ws.soap.a5.PersonaServiceA5_PortType;
import sr.puc.server.ws.soap.a5.PersonaServiceA5_ServiceLocator;
import sr.puc.server.ws.soap.a5.PersonaServiceA5SoapBindingStub;

/**
 * Clase que permite interactuar con el servicio web de AFIP para obtener informacion de inscripcion de un contribuyente
 * a partir de su CUIT
 * 
 * dREHER
 */

public class LYEIWSCI {
	
	private static final String SERVICE = "ws_sr_padron_a5";
	/** Request XML	 */
	protected String requestXML = null;
	/** Response XML */
	protected String responseXML = null;
	
	
	protected LP_C_LYEIElectronicPOSConfig posConfig;
	private String qNameURL = "https://awshomo.afip.gov.ar/sr-padron/webservices/personaServiceA5";
	
	public LYEIWSCI(LP_C_LYEIElectronicPOSConfig posConfig) {
		this.posConfig = posConfig;
	}
	private void debug(String s) {
		System.out.println("LYEIWSCI." + s);
	}
	
	public PersonaReturn consultaFromAFIP(Long CUIT) {
		
		PersonaReturn persona = null;
		QName SERVICE_NAME = new QName(qNameURL, "getPersona_v2");
		
		PersonaServiceA5_PortType port = null;
		try {
			
			// Forzar TLS 1.2 si es que existe el factory correspondiente
			try {
				Class.forName("org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
				AxisProperties.setProperty("axis.socketSecureFactory", "org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
			} catch (Exception e) { /* Nada por hacer. Utilizar la version de SSL por defecto */}
			
			//se obtiene el endpoint mediante LYEITools dependiendo del environment actual (homologacion/produccion)
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSCI_PREFIX, posConfig.getCurrentEnvironment());
			
			debug("endPoint: " + endPoint + " serviceName: " + SERVICE_NAME);
			
			PersonaServiceA5_ServiceLocator locator = new PersonaServiceA5_ServiceLocator();
			port = locator.getPersonaServiceA5Port();
	
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getNewTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment(), SERVICE);

			
			// HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment(), "ws_sr_padron_a5");
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			// cuit
			String representado_cuit = getCUITfromPOSConfig(posConfig);
			
			//Log de actividad
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSCI.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, "Consultando CUIT: " + CUIT);
			
			//invocacion afip
			System.out.println("representado_cuit=" + Long.parseLong(representado_cuit) + " CUIT:" + CUIT);
			
			persona = port.getPersona_v2(token, sign, Long.parseLong(representado_cuit), CUIT);
			System.out.println("PersonaReturn.result[" + persona + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSCI.class, Level.SEVERE, null, posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, null, "Error en consulta de CUIT: " + e.getMessage());
			logXMLRequestResponse(port);
		}
		
		return persona;
	}
	
	/** Log de XML request/response */
	protected void logXMLRequestResponse(PersonaServiceA5_PortType port) {
		if (port==null) {
			return;
		}
		requestXML = ((PersonaServiceA5SoapBindingStub) port).getCallRequestXML();
		responseXML = ((PersonaServiceA5SoapBindingStub) port).getCallResponseXML();
		StringBuffer content = new StringBuffer();
		content.append(requestXML!=null?" RequestXML: "+requestXML:"")
				.append(responseXML!=null?" ResponseXML: "+responseXML:"");
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSCI.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, content.toString());
	}
	
	private String getCUITfromPOSConfig(LP_C_LYEIElectronicPOSConfig posConfig) {
		
		int posConfigID = posConfig.getC_LYEIElectronicPOSConfig_ID();
		String sql = "select cuit " +
				"from c_lyeielectronicinvoiceconfig " +
				"where c_lyeielectronicinvoiceconfig_id = ( " +
												"select c_lyeielectronicinvoiceconfig_id " +
												"from c_lyeielectronicposconfig " +
												"where c_lyeielectronicposconfig_id = " + posConfigID +
												");";
		
		PreparedStatement pstmt = 
				DB.prepareStatement(sql);
		ResultSet rs = null;
		String res = null;
		try {
			rs = pstmt.executeQuery();
			if(rs.next())
				res = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
		}
		
		System.out.println("Obtiene el CUIT de la empresa desde sql=\n" + sql + " cuit:" + res);
		
		return res;
	}

	/** Log de XML request/response */
	protected String getXMLRequestResponse() {
		StringBuffer retValue = new StringBuffer();
		retValue.append(requestXML!=null?" RequestXML: "+requestXML:"")
				.append(responseXML!=null?" ResponseXML: "+responseXML:"");
		return retValue.toString();
	}
	
	
	// ==============================================================================
	
	static String dbHost, dbPort, dbName, dbUser, dbPass;
	static Integer posConfigID, clientID, orgID;
	static Long CUIT;
	
	
	public static void main(String args[]) throws Exception {
		if (args.length<9) {
			System.err.println("Se requiere dbHost, dbPort, dbName, dbUser, dbPass, clientID, orgID, LP_C_LYEIElectronicPOSConfig_ID, CUIT");
			System.exit(1);
		}
		dbHost 		= args[0];
		dbPort 		= args[1];
		dbName 		= args[2];
		dbUser 		= args[3];
		dbPass 		= args[4];
		clientID 	= Integer.parseInt(args[5]);
		orgID 		= Integer.parseInt(args[6]);
		posConfigID = Integer.parseInt(args[7]);
		CUIT 		= Long.parseLong(args[8]);
		
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}	

		LP_C_LYEIElectronicPOSConfig posConfig = new LP_C_LYEIElectronicPOSConfig(Env.getCtx(), posConfigID, null);
		LYEIWSCI ciService = new LYEIWSCI(posConfig);
		// String res = ciService.dummy();
		// String res = ddjjService.uploadToAFIP(fileName);
		// System.out.println(res);
	}
	
		
    /**
     * Realiza la configuración inicial a partir de la información recibida
     * @throws Exception en caso de error o rechazo
     */
    public static void init() throws Exception
    {
        setConnection();
        startupEnvironment();
    }

    protected static void setConnection() {
        Ini.getProperties().put(Ini.P_CONNECTION,
                Secure.CLEARTEXT +
                        "CConnection["
                        + "name=localhost{DEVELOPMENT-DEVELOPMENT},"
                        + "AppsHost=localhost,"
                        + "AppsPort=1099,"
                        + "RMIoverHTTP=false,"
                        + "type=PostgreSQL,"
                        + "DBhost="+dbHost+","
                        + "DBport="+dbPort+","
                        + "DBname="+dbName+","
                        + "BQ=false,"
                        + "FW=false,"
                        + "FWhost=,"
                        + "FWport=0,"
                        + "UID="+dbUser+","
                        + "PWD="+dbPass+"]");
    }

    /**
     * Configura en entorno inicial
     * @throws Exception en caso de error
     */
    protected static void startupEnvironment() throws Exception
    {
        Env.setContext(Env.getCtx(), "#AD_Language", "es_AR");
        Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
        Env.setContext(Env.getCtx(), "#AD_Org_ID", orgID);
        if (!setup())
            throw new Exception ("Error al iniciar entorno (Hay conexión a Base de Datos?) ");
    }

    protected static boolean setup() {
        if (DB.isConnected())
            return true;
        // La gestion de log corre por cuenta del aspect EventLogAspect
        CLogMgt.shutdown();
        // Gestion server-side
        Ini.setClient(false);
        // Conectar a BDD
        CConnection cc = CConnection.get();
        DB.setDBTarget(cc);
        return DB.isConnected();
    }
	
	
	
}
