package org.libertya.locale.ar.electronicInvoice.utils;

import java.io.File;
import java.nio.file.Files;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import gov.afip.osiris.seti.presentacion.domain.PresentacionFileB2B;
import gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService;
import gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadLocator;

public class LYEIWSDDJJ {

	public LYEIWSDDJJ() {
	}
	
	public String uploadToAFIP(String archivoPresentacion) {
		
		String uploadResponse = null;
		QName SERVICE_NAME = new
				QName("http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/", "upload");
		String nombreArchivoPresentacion = new File(archivoPresentacion).getName();
		
		try {
			UploadLocator locator = new UploadLocator("https://awshomo.afip.gov.ar/setiws/webservices/uploadPresentacionService?wsdl", SERVICE_NAME);
			PresentacionProcessorMTOMService port = locator.getPresentacionProcessorMTOMImplPort();
//			((SOAPBinding)((BindingProvider)port).getBinding()).setMTOMEnabled(true); //este metodo estuvo dando problemas en ejecución
			//Binding asd = ((BindingProvider)port).getBinding();
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
//			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, ctx, posConfig.getCurrentEnvironment());
//			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
//			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			String token = "token";
			String sign = "sign";
			//####### CUIT
			String representado_cuit = "123123123123";
			//####### FILE
			//PresentacionFileB2B presentacion = null;
					
			long _upload__return = port.upload(token, sign, representado_cuit, _upload_presentacion);
			uploadResponse = "upload.result[" + _upload__return + "]";
			
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uploadResponse;
	}
	
	public String dummy() {
		
		String dummyResponse = null;
		QName SERVICE_NAME = new
				QName("http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/", "upload");
		try {
			//URL, QName
			UploadLocator locator = new UploadLocator("https://awshomo.afip.gov.ar/setiws/webservices/uploadPresentacionService?wsdl", SERVICE_NAME);
			PresentacionProcessorMTOMService port = locator.getPresentacionProcessorMTOMImplPort();
//			((SOAPBinding)((BindingProvider)port).getBinding()).setMTOMEnabled(true);
//			System.out.println("port address = " + locator.getPresentacionProcessorMTOMImplPortAddress());
//			System.out.println("service name = " + locator.getPresentacionProcessorMTOMImplPortWSDDServiceName());
			gov.afip.osiris.seti.presentacion.domain.DummyReturn _dummy__return = port.dummy();
			
			dummyResponse = "dummy.result[appserver=" + _dummy__return.getAppserver() + ", authserver=" +
					_dummy__return.getAuthserver() + ", dbserver=" + _dummy__return.getDbserver();
		
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (gov.afip.osiris.seti.presentacion.domain.Exception e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return dummyResponse;
	}

}
