package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.io.IOException;

public class ERDownloaderGetaudarWindowsStrategy extends ERDownloaderGetaudarStrategy {

	public ERDownloaderGetaudarWindowsStrategy() {
	}

	@Override
	public boolean downloadER(String fechaInicio, String fechaFin, int lyeicom) {
		//directorio base donde se encuentra la herramienta
		String baseDir = getFormattedPath(getAD_PreferenceGetaudar());
		Runtime runtime = Runtime.getRuntime();
		try {
			//se invoca la herramienta externa para descargar afip.zip de impresora fiscal executeGetaudar(baseDir, fechaInicio, fechaFin);
			
			//Una vez obtenido el .zip desde la impresora fiscal es necesario
			//guardar su contenido en un directorio particular, descomprimir y
			//obtener los nombres de los archivos a presentar F8011... y F8012... (F8010 NO SE PRESENTA)
			
			//crear nuevo directorio especifico para la fecha de hoy
			String newDir = fechaInicio + "_" + fechaFin + "_" + getRandomInt(1, 1000);
			String newDirAbsolute = baseDir + newDir;
			File newDirectory = new File(newDirAbsolute);
			newDirectory.mkdirs();
			
			//mover afip.zip al nuevo directorio especifico
			String[] mvCommand = {"cmd", "/c", "move " + addSurroundingQuotes(baseDir + "afip.zip") + " " + 
															addSurroundingQuotes(newDirAbsolute)}; 
			Process mv = runtime.exec(mvCommand);
			mv.waitFor();
			
			//mover afip.85 al nuevo directorio especifico
			String[] mvCommand2 = {"cmd", "/c", "move " + addSurroundingQuotes(baseDir + "afip.85") + " " + 
															addSurroundingQuotes(newDirAbsolute)}; 
			Process mv2 = runtime.exec(mvCommand2);
			mv2.waitFor();
			
			//descomprimir zip y obtener archivos de interes
			//cmd /c tar -xf "C:\path\to\afip.zip" -C "C:\path\to\"
			String[] unzipCommand = {"cmd", "/c", "tar -xf " + addSurroundingQuotes(getFormattedPath(newDirAbsolute) + "afip.zip") + 
					" " + "-C " + addSurroundingQuotes(newDirAbsolute)};
			Process unzip = runtime.exec(unzipCommand);
			//se debe esperar a que finalice el proceso, de lo contrario puede haber fallos
			unzip.waitFor();
			
			//obtener a partir del nuevo directorio los archivos necesarios para presentacion y los seteamos
			this.setArchivosPresentacion(getArchivosPresentacionFromDir(newDirAbsolute));
			
//			for(int i=0; i < this.archivosPresentacion .size() ; i++) {
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
	protected boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin, int lyeicom) {
		//obtener parametros para ejecucion del script/herramienta externa
		String tool = addSurroundingQuotes(getFormattedPath(baseDir) + "getaudar.exe");
		String params = " -p " + lyeicom + " -i serial -a";
		//ej: ubicacion/de/herramienta/getaudar -p 3 -i serial -a 200101 200331
		String command = tool + params + " " + fechaInicio + " " + fechaFin;
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
	
	//agrega comillas a una ruta para evitar problemas con paths que contengan espacios
	private String addSurroundingQuotes(String path) {
		if(!path.substring(0, 1).equalsIgnoreCase("\"")) {			
			return "\"" + path + "\"";
		}
		return path;
	}
	
	protected String getFormattedPath(String path) {
		String res = path;
		//si el path no termina con \ se le agrega
		if(!path.substring(path.length() - 1).equals("\\") ) {
			res = path + "\\";
		}
		return res;
	}

}
