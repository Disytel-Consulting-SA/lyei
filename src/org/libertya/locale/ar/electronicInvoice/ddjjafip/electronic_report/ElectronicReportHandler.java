package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.util.ArrayList;

//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportDownloaderStrategy;
//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportUploaderStrategy;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportDownloaderFactory;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportUploaderFactory;

public class ElectronicReportHandler {

	private String fechaInicio;
	private String fechaFin;
	private IElectronicReportDownloaderStrategy	downloader;
	private IElectronicReportUploaderStrategy uploader;
	
	public ElectronicReportHandler(String fechaInicio, String fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}


	public String execute() throws Exception {
		setAttributes();
		
		boolean downloaded = downloader.downloadER(fechaInicio, fechaFin);
		
		//si lograron descargarse los archivos, se debe invocar la subida de los mismos
		if(!downloaded) {
			return "No se pudieron obtener los archivos de presentacion";
		}
		
		ArrayList<String> archivosPresentacion = downloader.getArchivosPresentacion();
		for(String archivoPresentacion : archivosPresentacion) {
			//System.out.println("File: " + archivoPresentacion);
			//String output = uploader.uploadER();
		}
		
		return "OK";
	}
	
	//instancia downloader y uploader necesarios
	private void setAttributes() throws Exception {
		String os = getOS();
		ElectronicReportDownloaderFactory downloaderFactory = ElectronicReportDownloaderFactory.getInstance();
		ElectronicReportUploaderFactory uploaderFactory = ElectronicReportUploaderFactory.getInstance(); 
		
		if(os.equalsIgnoreCase("windows")) {
			//setear downloader para windows
			setDownloader(downloaderFactory.getERDownloaderGetaudarWindowsStrategy());
			
		}else if(os.equalsIgnoreCase("linux")) {
			//setear downloader para linux
			setDownloader(downloaderFactory.getERDownloaderGetaudarLinuxStrategy());
		}
		
		//setear uploader
		setUploader(uploaderFactory.getElectronicReportUploader());
	}
	
	private String getOS() throws Exception {
		
		String osName = System.getProperty("os.name");
		if (osName==null)
			throw new Exception("Imposible determinar os.name");
		//windows
		if(osName.toLowerCase().contains("windows")){
			return "windows";
		}
		//otro OS
		return "linux";
	}

	public IElectronicReportDownloaderStrategy getDownloader() {
		return downloader;
	}

	public void setDownloader(IElectronicReportDownloaderStrategy downloader) {
		this.downloader = downloader;
	}

	public IElectronicReportUploaderStrategy getUploader() {
		return uploader;
	}

	public void setUploader(IElectronicReportUploaderStrategy uploader) {
		this.uploader = uploader;
	}

}
