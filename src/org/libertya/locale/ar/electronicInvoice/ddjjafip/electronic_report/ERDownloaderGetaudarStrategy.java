package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openXpertya.model.MPreference;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public abstract class ERDownloaderGetaudarStrategy implements IElectronicReportDownloaderStrategy{
	
	/**
	 * dREHER 19 de Nov de 2026 - OP 8582
	 * Preferencia (AD_Preference) para NO presentar el F8012. Desde la RG ARCA 5801/2025 (periodo enero 2026) el F8012
	 * (duplicados electronicos) dejo de ser obligatorio. Por defecto (sin preferencia o con otro valor) se sigue presentando;
	 * solo se omite si la preferencia existe, esta activa y vale 'Y'.
	 */
	public static final String PREFERENCE_NO_PRESENTAR_F8012 = "DDJJ_NoPresentarF8012";
	private static CLogger log = CLogger.getCLogger(ERDownloaderGetaudarStrategy.class);

	//En este atributo se setean los archivos que deben presentarse ante AFIP como ddjj una vez descargados
	ArrayList<String> archivosPresentacion = new ArrayList<String>();
	
	public ERDownloaderGetaudarStrategy() {
		
	}

	public ArrayList<String> getArchivosPresentacion() {
		return archivosPresentacion;
	}
	
	public void setArchivosPresentacion(ArrayList<String> archivosPresentacion) {
		this.archivosPresentacion = archivosPresentacion;
	}

	protected abstract boolean isSpoolerStopped();

	protected abstract boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin, int lyeicom, String tcip);
	
	protected int getRandomInt(int min, int max) {
		int range = max - min;
		return (int)(Math.random() * range) + min;
	}
	
	protected ArrayList<String> getArchivosPresentacionFromDir(String dir) {
		ArrayList<String> archivosPresentacionString = new ArrayList<String>();
		String[] pathnames;
        File f = new File(dir);
        pathnames = f.list();
        // dREHER 19 de Nov de 2026 - OP 8582: desde el 01/01/2026 ARCA exige presentar tambien el F8010
        // (getaudar genera F8010, F8011 y F8012). Antes solo se presentaban F8011 y F8012.
        if(pathnames == null)
        	return archivosPresentacionString;
        // orden fijo: F8010, F8011, F8012
        java.util.Arrays.sort(pathnames);
        boolean noPresentarF8012 = isNoPresentarF8012();
        for (String pathname : pathnames) {
        	if(pathname.length() < 5)
        		continue;
        	// solo los .pem que genera getaudar son los que se presentan en ARCA (se ignoran .xml, afip.zip, afip.85, etc.)
        	if(!pathname.toLowerCase().endsWith(".pem"))
        		continue;
        	String substring = pathname.substring(0, 5);
        	if(substring.equalsIgnoreCase("F8012") && noPresentarF8012) {
        		log.info("No se presenta el F8012 (preferencia " + PREFERENCE_NO_PRESENTAR_F8012 + " activa): " + pathname);
        		continue;
        	}
        	if(substring.equalsIgnoreCase("F8010") || substring.equalsIgnoreCase("F8011") || substring.equalsIgnoreCase("F8012")) {
        		//establece el archivo con su ruta absoluta
        		archivosPresentacionString.add(getFormattedPath(dir) + pathname);
        	}
        }
		return archivosPresentacionString;
	}
	
	protected abstract String getFormattedPath(String path);
	
	/**
	 * dREHER 19 de Nov de 2026 - OP 8582
	 * @return true solo si la preferencia DDJJ_NoPresentarF8012 esta definida (para el cliente del entorno) con valor 'Y'.
	 * Se lee sin cache para que el cambio rija en la proxima presentacion. Ante cualquier error se asume false (se presenta).
	 */
	protected boolean isNoPresentarF8012() {
		try {
			String v = MPreference.GetCustomPreferenceValue(PREFERENCE_NO_PRESENTAR_F8012, Env.getAD_Client_ID(Env.getCtx()), null, null, true);
			return v != null && v.trim().equalsIgnoreCase("Y");
		} catch (Exception e) {
			log.warning("No se pudo leer la preferencia " + PREFERENCE_NO_PRESENTAR_F8012 + ", se presenta el F8012: " + e.toString());
			return false;
		}
	}
	
	protected String getAD_PreferenceGetaudar() {
		PreparedStatement pstmtMLA = 
				DB.prepareStatement(	"SELECT value " +
										"FROM ad_preference " +
										"WHERE attribute = 'Getaudar'");
		ResultSet rs = null;
		String res = null;
		try {
			rs = pstmtMLA.executeQuery();
			if(rs.next())
				res = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // dREHER
			DB.close(rs, pstmtMLA);
		}
		return res;
	}
}
