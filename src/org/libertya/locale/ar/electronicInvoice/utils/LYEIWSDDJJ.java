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

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.openXpertya.db.CConnection;
import org.openXpertya.util.CLogMgt;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Ini;
import org.openXpertya.util.Secure;

import gov.afip.osiris.seti.presentacion.domain.PresentacionFileB2B;
import gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService;
import gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadLocator;
import gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadSoapBindingStub;

public class LYEIWSDDJJ {
	
	/** Request XML	 */
	protected String requestXML = null;
	/** Response XML */
	protected String responseXML = null;
	
	
	protected LP_C_LYEIElectronicPOSConfig posConfig;
	private String qNameURL = "http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/";
	
	public LYEIWSDDJJ(LP_C_LYEIElectronicPOSConfig posConfig) {
		this.posConfig = posConfig;
	}
	
	public String uploadToAFIP(String archivoPresentacion) {
		
		String uploadResponse = null;
		QName SERVICE_NAME = new QName(qNameURL, "upload");
		String nombreArchivoPresentacion = new File(archivoPresentacion).getName();
		
		PresentacionProcessorMTOMService port = null;
		try {
			//se obtiene el endpoint mediante LYEITools dependiendo del environment actual (homologacion/produccion)
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSDDJJ_PREFIX, posConfig.getCurrentEnvironment());
			
			UploadLocator locator = new UploadLocator(endPoint, SERVICE_NAME);
			port = locator.getPresentacionProcessorMTOMImplPort();
//			((SOAPBinding)((BindingProvider)port).getBinding()).setMTOMEnabled(true); //este metodo estuvo dando problemas en ejecución
//			Binding asd = ((BindingProvider)port).getBinding();
//			BindingProvider bprovider = (BindingProvider) port; //no se puede castear
//			SOAPBinding soapbinding = (SOAPBinding) bprovider.getBinding();
//			soapbinding.setMTOMEnabled(true);
			//UploadSoapBindingStub usbs = (UploadSoapBindingStub) port;
			//usbs._getCall().setProperty(Call.ATTACHMENT_ENCAPSULATION_FORMAT, Call.ATTACHMENT_ENCAPSULATION_FORMAT_MTOM);
			
			//Configuracion para archivo de presentacion
			File aFile = new File(archivoPresentacion);
			PresentacionFileB2B _upload_presentacion = new PresentacionFileB2B();
			byte[] fileContent = Files.readAllBytes(aFile.toPath());
			
			//dataHandler to byte[]
//			final InputStream in = new DataHandler( new FileDataSource(aFile) ).getInputStream();
//			byte[] byteArray=org.apache.commons.io.IOUtils.toByteArray(in);
			
//			_upload_presentacion.setPresentacionDataHandler( new DataHandler( new FileDataSource(aFile) ) );
//			_upload_presentacion.setPresentacionDataHandler(byteArray); 
			_upload_presentacion.setPresentacionDataHandler(fileContent);
			_upload_presentacion.setFileName(nombreArchivoPresentacion);
			
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment());
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			// cuit
			String representado_cuit = getCUITfromPOSConfig(posConfig);
			
			//Log de actividad
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSDDJJ.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, "Presentando DDJJ: " + nombreArchivoPresentacion);
			
			//invocacion afip
			long _upload__return = port.upload(token, sign, representado_cuit, _upload_presentacion);
			uploadResponse = String.valueOf(_upload__return);;
			System.out.println("upload.result[" + _upload__return + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSDDJJ.class, Level.SEVERE, null, posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, null, "Error en Presentacion DDJJ: " + e.getMessage());
			uploadResponse = "[Error] " + e.getMessage();
		} finally {
			requestXML = ((UploadSoapBindingStub) port).getCallRequestXML();
			responseXML = ((UploadSoapBindingStub) port).getCallResponseXML();
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSDDJJ.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, "RequestXML: " + requestXML);
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSDDJJ.class, Level.INFO, null, posConfig.getC_LYEIElectronicPOSConfig_ID(), null, "ResponseXML: " + responseXML);
		}
		
		return uploadResponse;
	}
	
	public String dummy() {
		
		String dummyResponse = null;
		QName SERVICE_NAME = new QName(qNameURL, "upload");
		try {
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSDDJJ_PREFIX, posConfig.getCurrentEnvironment());
			//URL, QName
			UploadLocator locator = new UploadLocator(endPoint, SERVICE_NAME);
			PresentacionProcessorMTOMService port = locator.getPresentacionProcessorMTOMImplPort();
			
			//invocacion dummy
			gov.afip.osiris.seti.presentacion.domain.DummyReturn _dummy__return = port.dummy();
			dummyResponse = "dummy.result[appserver=" + _dummy__return.getAppserver() + ", authserver=" +
					_dummy__return.getAuthserver() + ", dbserver=" + _dummy__return.getDbserver();
		
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (gov.afip.osiris.seti.presentacion.domain.Exception e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dummyResponse;
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
	
	static String dbHost, dbPort, dbName, dbUser, dbPass, fileName;
	static Integer posConfigID, clientID, orgID;
	
	
	public static void main(String args[]) throws Exception {
		if (args.length<9) {
			System.err.println("Se requiere dbHost, dbPort, dbName, dbUser, dbPass, clientID, orgID, LP_C_LYEIElectronicPOSConfig_ID, fileName");
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
		fileName 	= args[8];
		
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}	

		LP_C_LYEIElectronicPOSConfig posConfig = new LP_C_LYEIElectronicPOSConfig(Env.getCtx(), posConfigID, null);
		LYEIWSDDJJ ddjjService = new LYEIWSDDJJ(posConfig);
		//String res = ddjjService.dummy();
		String res = ddjjService.uploadToAFIP(fileName);
		System.out.println(res);
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
