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
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

import gov.afip.osiris.seti.presentacion.domain.PresentacionFileB2B;
import gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService;
import gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadLocator;

public class LYEIWSDDJJ {
	protected LP_C_LYEIElectronicPOSConfig posConfig;
	private String qNameURL = "http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/";
	
	public LYEIWSDDJJ(LP_C_LYEIElectronicPOSConfig posConfig) {
		this.posConfig = posConfig;
	}
	
	public String uploadToAFIP(String archivoPresentacion) {
		
		String uploadResponse = null;
		QName SERVICE_NAME = new QName(qNameURL, "upload");
		String nombreArchivoPresentacion = new File(archivoPresentacion).getName();
		
		try {
			//se obtiene el endpoint mediante LYEITools dependiendo del environment actual (homologacion/produccion)
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSDDJJ_PREFIX, posConfig.getCurrentEnvironment());
			
			UploadLocator locator = new UploadLocator(endPoint, SERVICE_NAME);
			PresentacionProcessorMTOMService port = locator.getPresentacionProcessorMTOMImplPort();
//			((SOAPBinding)((BindingProvider)port).getBinding()).setMTOMEnabled(true); //este metodo estuvo dando problemas en ejecución
//			Binding asd = ((BindingProvider)port).getBinding();
//			BindingProvider bprovider = (BindingProvider) port; //no se puede castear
//			SOAPBinding soapbinding = (SOAPBinding) bprovider.getBinding();
//			soapbinding.setMTOMEnabled(true);
			
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
		System.out.println("Obtiene el CUIT de la empresa desde sql=\n" + sql);
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
		return res;
	}

}
