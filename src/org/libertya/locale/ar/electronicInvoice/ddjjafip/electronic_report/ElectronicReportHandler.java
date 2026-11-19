package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportDownloaderFactory;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.factory.ElectronicReportUploaderFactory;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIDDJJPresentada;
import org.openXpertya.util.CLogger;
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
	
	// dREHER
	protected String tcip = "";
	private static CLogger log = CLogger.getCLogger(ElectronicReportHandler.class);
	
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
		if(this.lyeicom <= 0) { // dREHER puerto CERO tambien rompe...
			
			// dREHER se agrega posibilidad de utilizar TCIP corro la verificacion al final de los controles
			// return "Error al intentar obtener COM, verificar que este correctamente configurado en la impresora fiscal";
			
			/**
			 * Si el puerto COM llega en CERO, leo la IP desde la configuracion de la impresora
			 * 
			 * dREHER
			 */
			this.tcip = getHost(posnumber);
		}

		// dREHER
		if(this.lyeicom <= 0 && this.tcip==null)
			return "Error al intentar obtener puerto COM/IP, verificar que este correctamente configurado en la impresora fiscal";
		
		//invocacion al proceso de descarga desde impresora fiscal
		log.info("Invoca a la descarga de la auditoria fiscal!");
		boolean downloaded = downloader.downloadER(fechaInicio, fechaFin, lyeicom, tcip);
		log.info("Volvio e la descarga de la auditoria fiscal! Resultado=" + downloaded);
		
		//si lograron descargarse los archivos, se debe invocar la subida de los mismos
		if(!downloaded) {
			return "No se pudieron obtener los archivos de presentacion";
		}
		
		//a partir del c_pos_id (punto de venta) podemos obtener el id
		//de la posConfig a utilizar dentro del upload
		uploader.setPosConfig(this.getPosConfigID(posnumber));
		
		ArrayList<String> archivosPresentacion = downloader.getArchivosPresentacion();
		
		log.info("Comienza con la lectura de la info para la DDJJ");
		
//		Se invoca el proceso de presentacion (upload) por cada archivo (F8010, F8011 y F8012; dREHER OP 8582: desde 01/01/2026 se presenta tambien el F8010)
//		Luego se determina si la presentacion fue exitosa o no y se almacena un registro
//		En la tabla c_lyeiddjjpresentada por cada archivo, con el trx_number si fue exitoso o errorMsg si fallo
		StringBuilder output = new StringBuilder();
		output.append("Archivos para DDJJ: <b>" + archivosPresentacion.size() + "</b><br>");
		int omitidos = 0;
		for(String archivoPresentacion : archivosPresentacion) {
			String trxNumber = null;
			String errorMsg = null;
			String uploadoutput = "";
			String nombreArchivoPresentacion = new File(archivoPresentacion).getName();
			
			// dREHER 19 de Nov de 2026 - OP 8582: si para este periodo (mismo tipo de archivo, misma impresora y mismas fechas)
			// ya figura presentado OK en el log (c_lyeiddjjpresentada), no se vuelve a presentar. Solo se intenta lo que no figura.
			String trxPrevio = getTrxYaPresentado(nombreArchivoPresentacion);
			if(trxPrevio != null) {
				omitidos++;
				log.info("[INFO] Se omite " + nombreArchivoPresentacion + ": ya presentado para este periodo, trx=" + trxPrevio);
				output.append(nombreArchivoPresentacion + "<br/> [Omitido] Ya figura presentado para este periodo, numero de transaccion: [" + trxPrevio + "] <br/><br/>");
				continue;
			}
						
			log.info("[INFO] Invocando presentacion ddjj de archivo: " + archivoPresentacion);
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
			output.append(uploadoutput + "<br/>");
			
			this.saveDDJJPresentada(nombreArchivoPresentacion, trxNumber, errorMsg);
		}
		
		if(omitidos > 0)
			output.append("Archivos omitidos por estar ya presentados en este periodo: <b>" + omitidos + "</b><br>");
		
		return output.toString();
	}
	
	/**
	 * dREHER 19 de Nov de 2026 - OP 8582
	 * Busca en el log de presentaciones (c_lyeiddjjpresentada) si el archivo ya fue presentado OK para este periodo.
	 * Coincide por: cliente del entorno, registro activo con numero de transaccion (presentacion exitosa), mismo rango de
	 * fechas (datefrom/dateto), mismo tipo de archivo (F8010/F8011/F8012) y misma impresora (serie del nombre del archivo).
	 * No se compara el nombre completo porque getaudar genera un GUID distinto en cada descarga.
	 * Las presentaciones con error (sin trx_number) NO cuentan: se reintentan. Para forzar una nueva presentacion basta
	 * desactivar el registro del log (isactive='N').
	 * Nombre esperado: F8011.CUIT.SERIE.AAAAMMDD.GUID.pem
	 * @return numero de transaccion de la presentacion previa, o null si no figura (o ante cualquier error de lectura)
	 */
	private String getTrxYaPresentado(String nombreArchivo) {
		String[] partes = nombreArchivo.split("\\.");
		if(partes.length < 4)
			return null;
		String tipo = partes[0].toUpperCase();
		String serie = partes[2];
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(
					"SELECT trx_number FROM c_lyeiddjjpresentada " +
					"WHERE isactive = 'Y' AND ad_client_id = ? AND trx_number IS NOT NULL " +
					"AND datefrom = ? AND dateto = ? " +
					"AND upper(split_part(filename, '.', 1)) = ? AND split_part(filename, '.', 3) = ? " +
					"ORDER BY fyh_presentacion DESC");
			pstmt.setInt(1, Env.getAD_Client_ID(Env.getCtx()));
			pstmt.setDate(2, new java.sql.Date(getTimestampDateFormat(fechaInicio).getTime()));
			pstmt.setDate(3, new java.sql.Date(getTimestampDateFormat(fechaFin).getTime()));
			pstmt.setString(4, tipo);
			pstmt.setString(5, serie);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch (Exception e) {
			log.warning("No se pudo verificar si " + nombreArchivo + " ya fue presentado, se intenta presentar: " + e.toString());
		} finally {
			DB.close(rs, pstmt);
		}
		return null;
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

	private String getHost(int lyeipos) {
		
		PreparedStatement pstmt = 
				DB.prepareStatement(	"SELECT host " +
										"FROM c_controlador_fiscal " +
										"WHERE lyeipos = " + lyeipos);
		ResultSet rs = null;
		String res = null;
		try {
			rs = pstmt.executeQuery();
			if(rs.next())
				res = rs.getString(1);

			log.info("host = " + res);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
		}
		return res;
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
			if(rs.next())
				res = rs.getInt(1);

			log.info("lyeicom = " + res);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
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
			if(rs.next())
				res = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
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

			log.info("C_POS_ID = " + c_pos_id);

			rs = pstmt.executeQuery();
			if(rs.next())
				res = rs.getInt(1);
			log.info("posnumber = " + res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
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
			if(rs.next());
				res = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmt);
		}
		return res;
	}

	private boolean saveDDJJPresentada(String fileName, String trxNumber, String errorMsg) {
		boolean isOk = false;
		
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

		log.info("Guarda informacion de la DDJJ");
		isOk = ddjjPresentada.save();
		if(!isOk)
			log.warning("No se pudo guardar la informacion de DDJJ");
		
		return isOk;
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
