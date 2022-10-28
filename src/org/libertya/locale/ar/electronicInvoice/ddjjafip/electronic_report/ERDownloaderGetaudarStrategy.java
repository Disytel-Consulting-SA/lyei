package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openXpertya.util.DB;

public abstract class ERDownloaderGetaudarStrategy implements IElectronicReportDownloaderStrategy{
	
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

	protected abstract boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin, int lyeicom);
	
	protected int getRandomInt(int min, int max) {
		int range = max - min;
		return (int)(Math.random() * range) + min;
	}
	
	protected ArrayList<String> getArchivosPresentacionFromDir(String dir) {
		ArrayList<String> archivosPresentacionString = new ArrayList<String>();
		String[] pathnames;
        File f = new File(dir);
        pathnames = f.list();
        for (String pathname : pathnames) {
        	String substring = pathname.substring(0, 5);
        	if(substring.equalsIgnoreCase("F8011") || substring.equalsIgnoreCase("F8012")) {
        		//establece el archivo con su ruta absoluta
        		archivosPresentacionString.add(getFormattedPath(dir) + pathname);
        	}
        }
		return archivosPresentacionString;
	}
	
	protected abstract String getFormattedPath(String path);
	
	protected String getAD_PreferenceGetaudar() {
		PreparedStatement pstmtMLA = 
				DB.prepareStatement(	"SELECT value " +
										"FROM ad_preference " +
										"WHERE attribute = 'Getaudar'");
		ResultSet rs = null;
		String res = null;
		try {
		rs = pstmtMLA.executeQuery();
		rs.next();
		res = rs.getString(1);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return res;
	}
}
