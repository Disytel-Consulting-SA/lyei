package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportDownloaderStrategy;
//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportUploaderStrategy;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportDownloaderFactory;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportUploaderFactory;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public class ElectronicReportHandler {

	private String fechaInicio;
	private String fechaFin;
	private IElectronicReportDownloaderStrategy	downloader;
	private IElectronicReportUploaderStrategy uploader;
	protected String c_pos_id; //a partir de c_pos_id en tabla c_pos obtengo posnumber
	
	public ElectronicReportHandler(String fechaInicio, String fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	//constructor para aceptar el pasaje de pos id para recuperacion de config
	public ElectronicReportHandler(String fechaInicio, String fechaFin, String c_pos_id) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.c_pos_id = c_pos_id;
	}


	public String execute() throws Exception {
		setAttributes();
		
		//COM es un parametro obtenido desde c_controlador_fiscal
		//especifica el puerto del fiscal para invocar a la herramienta getaudar
		int posnumber = this.getPosNumber(c_pos_id);
		int lyeicom = this.getCom(posnumber);
		
		boolean downloaded = downloader.downloadER(fechaInicio, fechaFin, lyeicom);
		
		//si lograron descargarse los archivos, se debe invocar la subida de los mismos
		if(!downloaded) {
			return "No se pudieron obtener los archivos de presentacion";
		}
		
		//a partir del c_pos_id (punto de venta) podemos obtener el id
		//de la posConfig a utilizar dentro del upload
		uploader.setPosConfig(this.getPosConfigID(posnumber));
		String output = "";
		
		ArrayList<String> archivosPresentacion = downloader.getArchivosPresentacion();
		for(String archivoPresentacion : archivosPresentacion) {
			//System.out.println("File: " + archivoPresentacion);
			//output += archivoPresentacion + uploader.uploadER() + "\n";
		}
		
		return output;
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
	
	private int getCom(int lyeipos) {
		
		PreparedStatement pstmt = 
				DB.prepareStatement(	"SELECT lyeicom " +
										"FROM c_controlador_fiscal " +
										"WHERE lyeipos = " + lyeipos);
		ResultSet rs = null;
		int res = -1;
		try {
		rs = pstmt.executeQuery();
		rs.next();
		res = rs.getInt(1);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return res;
	}
	
	public int getPosConfigID(int pos) {
		
		PreparedStatement pstmt = 
				DB.prepareStatement(	"SELECT c_lyeielectronicposconfig_id " +
										"FROM c_lyeielectronicposconfig " +
										"WHERE pos = " + pos);
		ResultSet rs = null;
		int res = -1;
		try {
		rs = pstmt.executeQuery();
		rs.next();
		res = rs.getInt(1);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return res;
	}
	
	public int getPosNumber(String c_pos_id) {
		
		PreparedStatement pstmt = 
				DB.prepareStatement(	"SELECT posnumber " +
										"FROM c_pos " +
										"WHERE c_pos_id = " + c_pos_id);
		ResultSet rs = null;
		int res = -1;
		try {
		rs = pstmt.executeQuery();
		rs.next();
		res = rs.getInt(1);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return res;
	}
	
	/*
	 * notacion: atributo(tabla)
	 * 
	 * obtengo posnumber(C_POS) del registro con id = C_POS_ID pasada por parametro
	 * 
	 * luego:
	 * 
	 * pos(c_lyeielectronicposconfig) == posnumber(C_POS) [match]
	 * lyeipos(C_ControladorFiscal) == posnumber(C_POS) [match]
	 * 
	 */

}
