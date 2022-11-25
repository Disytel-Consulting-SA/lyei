package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;

//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportDownloaderStrategy;
//import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportUploaderStrategy;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportDownloaderFactory;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportUploaderFactory;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIDDJJPresentada;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFE;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public class ElectronicReportHandler {

	private String fechaInicio;
	private String fechaFin;
	private IElectronicReportDownloaderStrategy	downloader;
	private IElectronicReportUploaderStrategy uploader;
	protected String c_pos_id; //a partir de c_pos_id en tabla c_pos obtengo posnumber
	protected int posnumber = -1; //posnumber == lyeipos
	protected int lyeicom = -1;
	
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
		this.posnumber = this.getPosNumber(c_pos_id);
		if(this.posnumber == -1)
			return "Error al intentar obtener POSNumber, verificar que este correctamente configurado en la impresora fiscal";
		this.lyeicom = this.getCom(posnumber);
		if(this.lyeicom == -1)
			return "Error al intentar obtener COM, verificar que este correctamente configurado en la impresora fiscal";
		
		//invocacion al proceso de descarga desde impresora fiscal
		boolean downloaded = downloader.downloadER(fechaInicio, fechaFin, lyeicom);
		
		//si lograron descargarse los archivos, se debe invocar la subida de los mismos
		if(!downloaded) {
			return "No se pudieron obtener los archivos de presentacion";
		}
		
		//a partir del c_pos_id (punto de venta) podemos obtener el id
		//de la posConfig a utilizar dentro del upload
		uploader.setPosConfig(this.getPosConfigID(posnumber));
		
		ArrayList<String> archivosPresentacion = downloader.getArchivosPresentacion();
		
		
//		Se invoca el proceso de presentacion (upload) por cada archivo (F8011 y F8012)
//		Luego se determina si la presentacion fue exitosa o no y se almacena un registro
//		En la tabla c_lyeiddjjpresentada por cada archivo, con el trx_number si fue exitoso o errorMsg si fallo
		String output = "";
		for(String archivoPresentacion : archivosPresentacion) {
			String trxNumber = null;
			String errorMsg = null;
			String uploadoutput = "";
			String nombreArchivoPresentacion = new File(archivoPresentacion).getName();
						
			System.out.println("[INFO] Invocando presentacion ddjj de archivo: " + archivoPresentacion);
			String wsResponse = uploader.uploadER(archivoPresentacion);
			if(wsResponse == null || wsResponse.substring(0, 7).equalsIgnoreCase("[Error]")) {
//				fail en upload
				errorMsg = wsResponse;
				uploadoutput = nombreArchivoPresentacion + "<br/>" + wsResponse + "<br/>";
			}else {
//				success upload
				trxNumber = wsResponse;
				uploadoutput = nombreArchivoPresentacion + "<br/> [Success] Archivo presentado, numero de transaccion: ["+trxNumber+"] <br/>";
			}
			output += uploadoutput + "<br/>";
			
			this.saveDDJJPresentada(nombreArchivoPresentacion, trxNumber, errorMsg);
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
		
		System.out.println("lyeicom = " + res);
		
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
			
		System.out.println("C_POS_ID = " + c_pos_id);
			
		rs = pstmt.executeQuery();
		rs.next();
		res = rs.getInt(1);
		System.out.println("posnumber = " + res);
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
	 */
	
	private int getControladorFiscalID() {
		
		PreparedStatement pstmt = 
				DB.prepareStatement(	"SELECT c_controlador_fiscal_id " +
										"FROM c_controlador_fiscal " +
										"WHERE lyeipos = " + this.posnumber);
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
	
	private boolean saveDDJJPresentada(String fileName, String trxNumber, String errorMsg) {
		
		LP_C_LYEIDDJJPresentada ddjjPresentada = new LP_C_LYEIDDJJPresentada(Env.getCtx(), 0, null);
//		--asociacion con la impresora fiscal correspondiente c_controlador_fiscal_id integer
		ddjjPresentada.setC_Controlador_Fiscal_ID(this.getControladorFiscalID());
//		-- posConfig utilizada para la operacion c_lyeielectronicposconfig_id int
		ddjjPresentada.setC_LYEIElectronicPOSConfig_ID(this.getPosConfigID(posnumber));
//		-- Usuario que ejecutó el proceso ad_user_id integer
		ddjjPresentada.setAD_User_ID(Env.getAD_User_ID(Env.getCtx()));
//		-- Fecha y hora de presentación fyh_presentacion timestamp
		ddjjPresentada.setfyh_presentacion(Env.getTimestamp());
//		-- Nombre del archivo filename varchar(256)
		ddjjPresentada.setFileName(fileName);
//		-- Número de transacción (si se presentó OK) trx_number integer
		if(trxNumber != null) {			
			ddjjPresentada.settrx_number(trxNumber);
		}
//		-- rango de fechas para las cuales se realiza la presentacion (datefrom date dateto date)
		ddjjPresentada.setDateFrom(getTimestampDateFormat(fechaInicio));
		ddjjPresentada.setDateTo(getTimestampDateFormat(fechaFin));
//		-- Mensaje de error (si falló) error_msg varchar
		if(errorMsg != null) {
			ddjjPresentada.seterror_msg(errorMsg);
		}

		return ddjjPresentada.save();
	}
	
	/*
	 * dada una fecha en formato aaMMdd, ej: 221013 (13/10/2022)
	 * La convierte a formato 2022-10-13
	 */
	private Timestamp getTimestampDateFormat(String date) {
		String res = "";
		
		//anio (2022-)
		res += "20" + date.substring(0, 2) + "-";
		//+mes (2022-10-)
		res += date.substring(2, 4) + "-";
		//+dia (2022-10-13)
		res += date.substring(4, 6);
		//(2022-10-13 00:00:00.000)
		res += " 00:00:00.000";
		
		return Timestamp.valueOf(res);
	}

}
