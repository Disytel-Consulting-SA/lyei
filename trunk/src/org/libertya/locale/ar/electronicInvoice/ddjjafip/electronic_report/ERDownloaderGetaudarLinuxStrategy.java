package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.openXpertya.util.DB;

public class ERDownloaderGetaudarLinuxStrategy extends ERDownloaderGetaudarStrategy {

	public ERDownloaderGetaudarLinuxStrategy() {
	}

	@Override
	public boolean downloadER(String fechaInicio, String fechaFin) {
		//directorio base donde se encuentra la herramienta
		String baseDir = getFormattedPath(getAD_PreferenceGetaudar());
		Runtime runtime = Runtime.getRuntime();
		try {
			//se invoca la herramienta externa para descargar afip.zip de impresora fiscal
//			executeGetaudar(baseDir, fechaInicio, fechaFin);
			
			//Una vez obtenido el .zip desde la impresora fiscal es necesario
			//guardar su contenido en un directorio particular, descomprimir y
			//obtener los nombres de los archivos a presentar F8011... y F8012... (F8010 NO SE PRESENTA)
			
			//crear nuevo directorio especifico para la fecha de hoy
			String newDir = fechaInicio + "_" + fechaFin + "_" + getRandomInt(1, 1000);
			String newDirAbsolute = baseDir + newDir;
			File newDirectory = new File(newDirAbsolute);
			newDirectory.mkdirs();
			
			//mover afip.zip al nuevo directorio especifico
			String[] mvCommand = {"/bin/sh", "-c", "mv " + baseDir + "afip.zip " + newDirAbsolute}; 
			Process mv = runtime.exec(mvCommand);
			mv.waitFor();
			
			//descomprimir zip y obtener archivos de interes
			String[] unzipCommand = {"/bin/unzip","-qq", getFormattedPath(newDirAbsolute)+"afip.zip", "-d", getFormattedPath(newDirAbsolute)};
			Process unzip = runtime.exec(unzipCommand);
			//se debe esperar a que finalice el proceso, de lo contrario puede haber fallos
			unzip.waitFor();
			
			//obtener a partir del nuevo directorio los archivos necesarios para presentacion y los seteamos
			this.setArchivosPresentacion(getArchivosPresentacionFromDir(newDirAbsolute));
//			for(int i=0; i < this.archivosPresentacion.size() ; i++) {
//				System.out.println("[ARCHIVO " + i +"] " + this.archivosPresentacion.get(i));
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	protected boolean isSpoolerStopped() {
		return false;
	}

	@Override
	protected boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin){
		//obtener parametros para ejecucion del script/herramienta externa
		String params = "getaudar -p 3 -i serial -a";
		//ej: ubicacion/de/herramienta/getaudar -p 3 -i serial -a 200101 200331
		String command = baseDir + params + " " + fechaInicio + " " + fechaFin;
		//ejecutamos comando para obtener afip.zip
		Runtime runtime = Runtime.getRuntime();
		Process proc;
		try {
			proc = runtime.exec(command);
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private ArrayList<String> getArchivosPresentacionFromDir(String dir) {
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
	
	private String getFormattedPath(String path) {
		String res = path;
		//si el path no termina con / se le agrega
		if(!path.substring(path.length() - 1).equals("/") ) {
			res = path + "/";
		}
		return res;
	}
	
	private int getRandomInt(int min, int max) {
		int range = max - min;
		return (int)(Math.random() * range) + min;
	}
	
	private String getProcessOutput(Process proc) throws IOException {
		String res = "";
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		String output = null;
		
		//Leer output del comando
		while ((output = stdInput.readLine()) != null) {
			res += output;
		}
		res += "\n\n";
		//Leer errores del comando
		while ((output = stdError.readLine()) != null) {
			res += output;
		}
		return res;
	}
	
	private String getAD_PreferenceGetaudar() {
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
