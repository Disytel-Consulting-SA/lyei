package org.libertya.locale.ar.electronicInvoice.utils;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.axis.AxisProperties;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.openXpertya.db.CConnection;
import org.openXpertya.util.CLogMgt;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Ini;
import org.openXpertya.util.Secure;

import wsfecred.afip.gob.ar.FECredService.AuthRequestType;
import wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType;
import wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionRequestType;
import wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType;
import wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType;
import wsfecred.afip.gob.ar.FECredService.FECredServiceLocator;
import wsfecred.afip.gob.ar.FECredService.FECredServicePortType;
import wsfecred.afip.gob.ar.FECredService.SiNoSimpleType;
import wsfecred.afip.gob.ar.FECredService.FECredServiceSOAPStub;

/**
 * Clase que permite interactuar con el servicio web de AFIP para obtener informacion de factura miPyme (credito)
 * a partir de su CUIT
 * 
 * dREHER
 */

public class LYEIWSFECRED {
	

	private static final String SERVICE = "wsfecred";
	
	/** Request XML	 */
	protected String requestXML = null;
	/** Response XML */
	protected String responseXML = null;
	
	private String qNameURL = "http://ar.gob.afip.wsfecred/FECredService/";
	
	protected LP_C_LYEIElectronicPOSConfig posConfig;
	
	public LYEIWSFECRED(LP_C_LYEIElectronicPOSConfig posConfig) {
		this.posConfig = posConfig;
	}
	private void debug(String s) {
		System.out.println("LYEIWSFECRED." + s);
	}
	
	public ConsultarMontoObligadoRecepcionReturnType consultaFromAFIP(Long CUIT, Date fecha) {
		
		ConsultarMontoObligadoRecepcionResponseType mo = null;
		BigDecimal montoDesde = null;
		FECredServicePortType port = null;
		ConsultarMontoObligadoRecepcionReturnType re = null;
		try {
			
			// Forzar TLS 1.2 si es que existe el factory correspondiente
			try {
				Class.forName("org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
				AxisProperties.setProperty("axis.socketSecureFactory", "org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
			} catch (Exception e) { /* Nada por hacer. Utilizar la version de SSL por defecto */}
			
			//se obtiene el endpoint mediante LYEITools dependiendo del environment actual (homologacion/produccion)
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSFECRED_PREFIX, posConfig.getCurrentEnvironment());
			
			FECredServiceLocator locator = new FECredServiceLocator();
			
			// dREHER - indicar al locator el endPoint correspondiente segun configuracion
			locator.setFECredServiceSOAPEndpointAddress(endPoint);
			
			port = locator.getFECredServiceSOAP();
			
			debug("endPoint: " + endPoint + " serviceName: " + locator.getServiceName());
	
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getNewTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment(), SERVICE);

			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// String token = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiB1bmlxdWVfaWQ9IjU3OTgxMTIxMCIgZ2VuX3RpbWU9IjE3MTc3Nzc0ODgiIGV4cF90aW1lPSIxNzE3ODIwNzQ4Ii8+CiAgICA8b3BlcmF0aW9uIHR5cGU9ImxvZ2luIiB2YWx1ZT0iZ3JhbnRlZCI+CiAgICAgICAgPGxvZ2luIGVudGl0eT0iMzM2OTM0NTAyMzkiIHNlcnZpY2U9IndzZmVjcmVkIiB1aWQ9IlNFUklBTE5VTUJFUj1DVUlUIDMzNTA0NDg3MTE5LCBDTj12aWVkbWEiIGF1dGhtZXRob2Q9ImNtcyIgcmVnbWV0aG9kPSIyMiI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24ga2V5PSIzMzUwNDQ4NzExOSIgcmVsdHlwZT0iNCIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgo=";
			// String sign = "PtGlxwEwkjSVqi2yRNO9wsFTSul/RU3WdoD8UdzkrtBpSKVuBOqd/++a3QlSH7dOurlpc5ykoUEvN4dn1ES1A4I3XW4vvse7r5rjUFQIJbWyRiFY7k0bfk+12tzQigzIG1m0+gqeOIJRnUK7arU/bsxuhr3qYXKan+S+aTjKFTY=";
			
			
			// cuit
			String representado_cuit = getCUITfromPOSConfig(posConfig);
			
			//Log de actividad
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFECRED.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, "Consultando CUIT: " + CUIT);
			
			//invocacion afip
			ConsultarMontoObligadoRecepcionRequestType mor = new ConsultarMontoObligadoRecepcionRequestType();
			AuthRequestType art = new AuthRequestType(token, sign, Long.parseLong(representado_cuit));
			mor.setAuthRequest(art);
			mor.setCuitConsultada(CUIT);
			mor.setFechaEmision(fecha);
			
			mo = port.consultarMontoObligadoRecepcion(mor);
			re = mo.getConsultarMontoObligadoRecepcionReturn();
			montoDesde = re.getMontoDesde();
			SiNoSimpleType sino = re.getObligado();
			String yes = sino.getValue();
			
			CodigoDescripcionType[] cdt = re.getArrayErrores();
			if(cdt!=null) {
				System.out.println("Errores funcionales:");
				for(CodigoDescripcionType c: cdt)
					System.out.println("Errores: " + c.getCodigo() + " " + c.getDescripcion());
			}else
				System.out.println("Sin errores funcionales!");

			cdt = re.getArrayObservacion();
			if(cdt!=null) {
				System.out.println("Observaciones funcionales:");
				for(CodigoDescripcionType c: cdt)
					System.out.println("Errores: " + c.getCodigo() + " " + c.getDescripcion());
			}else
				System.out.println("Sin observaciones funcionales!");

			System.out.println("Obligado.result[" + yes + " Desde : " + montoDesde + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFECRED.class, Level.SEVERE, null, posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, null, "Error en consulta de CUIT: " + e.getMessage());
			logXMLRequestResponse(port);
		}
		
		return re;
	}
	
	/** Log de XML request/response */
	protected void logXMLRequestResponse(FECredServicePortType port) {
		if (port==null) {
			return;
		}

		requestXML = ((FECredServiceSOAPStub) port).getCallRequestXML();
		responseXML = ((FECredServiceSOAPStub) port).getCallResponseXML();
		
		StringBuffer content = new StringBuffer();
		content.append(requestXML!=null?" RequestXML: "+requestXML:"")
				.append(responseXML!=null?" ResponseXML: "+responseXML:"");
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFECRED.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, content.toString());
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
		LYEIWSFECRED ciService = new LYEIWSFECRED(posConfig);
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
