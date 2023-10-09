package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.File;
import java.io.IOException;

public class ERDownloaderGetaudarLinuxStrategy extends ERDownloaderGetaudarStrategy {

	public ERDownloaderGetaudarLinuxStrategy() {
	}

	@Override
	public boolean downloadER(String fechaInicio, String fechaFin, int lyeicom, String tcip) {
		//directorio base donde se encuentra la herramienta
		String baseDir = getFormattedPath(getAD_PreferenceGetaudar());
		Runtime runtime = Runtime.getRuntime();
		try {
			//se invoca la herramienta externa para descargar afip.zip de impresora fiscal
			executeGetaudar(baseDir, fechaInicio, fechaFin, lyeicom, tcip);
			
			//Una vez obtenido el .zip desde la impresora fiscal es necesario
			//guardar su contenido en un directorio particular, descomprimir y
			//obtener los nombres de los archivos a presentar F8011... y F8012... (F8010 NO SE PRESENTA)
			
			//crear nuevo directorio especifico para la fecha de hoy
			String newDir = fechaInicio + "_" + fechaFin + "_" + getRandomInt(1, 1000);
			String newDirAbsolute = baseDir + newDir;
			File newDirectory = new File(newDirAbsolute);
			newDirectory.mkdirs();
			
			//mover afip.zip al nuevo directorio especifico
//			String[] mvCommand = {"/bin/sh", "-c", "mv " + baseDir + "afip.zip " + newDirAbsolute}; 
			String[] mvCommand = {"/bin/sh", "-c", "mv " + addSurroundingQuotes(baseDir + "afip.zip") + " " + 
					addSurroundingQuotes(newDirAbsolute)}; 
			Process mv = runtime.exec(mvCommand);
			mv.waitFor();
			
			//mover afip.85 al nuevo directorio especifico
//			String[] mvCommand2 = {"/bin/sh", "-c", "mv " + baseDir + "afip.85 " + newDirAbsolute}; 
			String[] mvCommand2 = {"/bin/sh", "-c", "mv " + addSurroundingQuotes(baseDir + "afip.85") + " " + 
					addSurroundingQuotes(newDirAbsolute)};
			Process mv2 = runtime.exec(mvCommand2);
			mv2.waitFor();			
			
			//descomprimir zip y obtener archivos de interes
			String[] unzipCommand = {"/bin/unzip","-qq", getFormattedPath(newDirAbsolute)+"afip.zip", "-d", getFormattedPath(newDirAbsolute)};
//			String[] unzipCommand = {"/bin/unzip", "-qq", addSurroundingQuotes(getFormattedPath(newDirAbsolute) + "afip.zip"), 
//					"-d", addSurroundingQuotes(getFormattedPath(newDirAbsolute))};
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
	protected boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin, int lyeicom, String tcip){
		//obtener parametros para ejecucion del script/herramienta externa
		String params = "getaudar -p " + lyeicom + " -i serial -a";
		/**
		 * Si llega con puerto COM en cero, quiere decir que es por TCP
		 * dREHER
		 
		if(tcip!=null) {
			params = " -p " + tcip + " -i tcp -a";
		}
		
		29/09/2023 SOLO FUNCIONA CON PUERTO SERIAL
		
		*/
		
		//ej COM: ubicacion/de/herramienta/getaudar -p 3 -i serial -a 200101 200331
		//ej TCIP: ubicacion/de/herramienta/getaudar -p 10.100.45.117 -i tcp -a 200101 200331
		
		String command = baseDir + params + " " + fechaInicio + " " + fechaFin;
		
		System.out.println("Linux.Ejecuta el comando: " + command);
		
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
		}finally {
			System.out.println("Linux.Termino de ejecutar el comando: " + command);
		}
		return true;
	}
	
	protected String getFormattedPath(String path) {
		String res = path;
		//si el path no termina con / se le agrega
		if(!path.substring(path.length() - 1).equals("/") ) {
			res = path + "/";
		}
		return res;
	}
	
	//agrega comillas a una ruta para evitar problemas con paths que contengan espacios
	private String addSurroundingQuotes(String path) {
		if(!path.substring(0, 1).equalsIgnoreCase("\"")) {			
			return "\"" + path + "\"";
		}
		return path;
	}

}
