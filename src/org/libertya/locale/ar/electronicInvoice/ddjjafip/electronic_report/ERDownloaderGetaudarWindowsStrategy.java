package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openXpertya.model.MPreference;
import org.openXpertya.util.Env;

public class ERDownloaderGetaudarWindowsStrategy extends ERDownloaderGetaudarStrategy {

	public ERDownloaderGetaudarWindowsStrategy() {
	}

	@Override
	public boolean downloadER(String fechaInicio, String fechaFin, int lyeicom, String tcip) {

		String unzipcommand = MPreference.GetCustomPreferenceValue("Unzip", Env.getAD_Client_ID(Env.getCtx()));
		if(unzipcommand== null || unzipcommand.isEmpty())
			unzipcommand = "C:\\Program Files\\WinRAR\\unrar.exe -x"; // TODO: Buscar alternativa como 7zip
		int exitCode = -1;
		
		//directorio base donde se encuentra la herramienta
		String baseDir = getFormattedPath(getAD_PreferenceGetaudar());
		Runtime runtime = Runtime.getRuntime();
		try {
			//se invoca la herramienta externa para descargar afip.zip de impresora fiscal executeGetaudar(baseDir, fechaInicio, fechaFin);
			boolean isok = executeGetaudar(baseDir, fechaInicio, fechaFin, lyeicom, tcip);
			if(!isok)
				return false;
			
			//Una vez obtenido el .zip desde la impresora fiscal es necesario
			//guardar su contenido en un directorio particular, descomprimir y
			//obtener los nombres de los archivos a presentar F8011... y F8012... (F8010 NO SE PRESENTA)
			
			//crear nuevo directorio especifico para la fecha de hoy
			String newDir = fechaInicio + "_" + fechaFin + "_" + getRandomInt(1, 1000);
			String newDirAbsolute = baseDir + newDir;
			File newDirectory = new File(newDirAbsolute);
			newDirectory.mkdirs();
			
			//mover afip.zip al nuevo directorio especifico
			String sourceFile = getFormattedSeparator(baseDir + "afip.zip");
			String targetFile = getFormattedSeparator(newDirAbsolute + File.separator + "afip.zip");
			
			/*
			String[] mvCommand = {"cmd ", "/c", " move " + addSurroundingQuotes(baseDir + "afip.zip") + " " + 
															addSurroundingQuotes(newDirAbsolute)}; 
			System.out.println("Mover archivo afip.zip: ");
			for(String s: mvCommand)
				System.out.print(s);
			
			Process mv = runtime.exec(mvCommand);
			exitCode = mv.waitFor();
			System.out.println("\nMovio el archivo afip.zip... exitCode=" + exitCode);
			if(exitCode != 0)
				return false;
			*/
			
			System.out.println("Copia archivo " + sourceFile.toString() + " a " + targetFile.toString());
			boolean success = FileCopy(sourceFile, targetFile);
			if(!success) {
				System.out.println("Se produjo un error al copiar el archivo a " + targetFile);
				return false;
			}
					
					
			//mover afip.85 al nuevo directorio especifico
			/*
			String[] mvCommand2 = {"cmd ", "/c", " move " + addSurroundingQuotes(baseDir + "afip.85") + " " + 
															addSurroundingQuotes(newDirAbsolute)};
			System.out.println("Mover archivo afip.85: ");
			for(String s: mvCommand2)
				System.out.print(s);
			
			Process mv2 = runtime.exec(mvCommand2);
			exitCode = mv2.waitFor();
			System.out.println("\nMovio el archivo afip.85... exitCode=" + exitCode);
			*/
			
			sourceFile = getFormattedSeparator(baseDir + "afip.85");
			targetFile = getFormattedSeparator(newDirAbsolute + File.separator + "afip.85");
			
			System.out.println("Copia archivo " + sourceFile.toString() + " a " + targetFile.toString());
			success = FileCopy(sourceFile, targetFile);
			if(!success) {
				System.out.println("Se produjo un error al copiar el archivo a " + targetFile);
				return false;
			}
    
			
			//descomprimir zip y obtener archivos de interes
			//cmd /c tar -xf "C:\path\to\afip.zip" -C "C:\path\to\"
			// dREHER tomar en cuenta que tar.exe solo viene disponible desde Windows 10 en adelante
			
			String[] unzipCommand = {"cmd ", "/c ", addSurroundingQuotes(unzipcommand) + " " + addSurroundingQuotes(getFormattedPath(newDirAbsolute) + "afip.zip")};
					// + 
					// " " + "-C " + addSurroundingQuotes(newDirAbsolute)};
			
			System.out.println("Descomprimir archivo afip.zip: ");
			for(String s: unzipCommand)
				System.out.print(s);
			
			Process unzip = runtime.exec(unzipCommand);
			//se debe esperar a que finalice el proceso, de lo contrario puede haber fallos
			exitCode = unzip.waitFor();
			System.out.println("\nDescomprimio archivo afip.zip... exitCode=" + exitCode);
			if(exitCode != 0)
				return false;
			
			
			//obtener a partir del nuevo directorio los archivos necesarios para presentacion y los seteamos
			this.setArchivosPresentacion(getArchivosPresentacionFromDir(newDirAbsolute));
			
//			for(int i=0; i < this.archivosPresentacion .size() ; i++) {
//				System.out.println("[ARCHIVO " + i +"] " + this.archivosPresentacion.get(i));
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	private String getFormattedSeparator(String string) {
		String res = string;
		try {
			res = string.replaceAll("\\", "\\\\");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	protected boolean isSpoolerStopped() {
		return false;
	}

	@Override
	protected boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin, int lyeicom, String tcip) {
		//obtener parametros para ejecucion del script/herramienta externa
		String tool = "cmd /c " + addSurroundingQuotes(getFormattedPath(baseDir) + "getaudar.exe");
		String params = " -p " + lyeicom + " -i serial -a";
		
		/**
		 * Si llega con puerto COM en cero, quiere decir que es por TCP
		 * dREHER
		 */
		if(tcip!=null) {
			params = " -p " + tcip + " -i tcp -a";
		}
		
		//ej COM: ubicacion/de/herramienta/getaudar -p 3 -i serial -a 200101 200331
		//ej TCIP: ubicacion/de/herramienta/getaudar -p 10.100.45.117 -i tcp -a 200101 200331
		
		String command = tool + params + " " + fechaInicio + " " + fechaFin;
		
		System.out.println("Windows.Ejecuta el comando: " + command);
		
		//ejecutamos comando para obtener afip.zip
		Runtime runtime = Runtime.getRuntime();
		Process proc;
		try {
			proc = runtime.exec(command);
						
			// Lee la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Espera a que el proceso termine
            int exitCode = proc.waitFor();
            System.out.println("Código de salida: " + exitCode);
			if(exitCode!=0)
				return false;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Windows.Termino de ejecutar el comando: " + command);
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
	
	/**
	 * Copia un archivo en otro
	 *  
	 * @param sourceFilePath
	 * @param targetFilePath
	 * @return true= copio ok, false= no pudo copiar
	 * 
	 * dREHER
	 */
	public boolean FileCopy(String sourceFilePath, String targetFilePath) {
		boolean isCopied = false;

		File sourceFile = new File(sourceFilePath);
		File targetFile = new File(targetFilePath);

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);

			byte[] buffer = new byte[1024];
			int bytesRead;

			while ((bytesRead = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, bytesRead);
			}

			isCopied = true;
			System.out.println("El archivo se copió exitosamente.");
		} catch (IOException e) {
			System.out.println("Error al copiar el archivo: " + e.getMessage());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar los streams: " + e.getMessage());
			}
		}

		return isCopied;
	}
	
}
