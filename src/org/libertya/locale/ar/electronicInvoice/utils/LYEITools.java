package org.libertya.locale.ar.electronicInvoice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

public class LYEITools {

	/** Ejecuta un comando por terminal.  Si el exitValue es mayor a cero eleva una excepcion */
	public static void executeCommand(String activity, String command) throws Exception {
		executeCommand(activity, command, new File(System.getProperty("user.dir")));
	}
	
	/** Ejecuta un comando por terminal en un directorio dado.  Si el exitValue es mayor a cero eleva una excepcion */
	public static void executeCommand(String activity, String command, File directory) throws Exception {
		Process p = null;
		System.out.println("Ejecuta " + command + " en directorio:" + directory);
		p = Runtime.getRuntime().exec(command, null, directory);
		p.waitFor();
		if (p.exitValue() != 0) {
			throw new Exception("Command:" + command + " - Exit code " + p.exitValue() + " en actividad " + activity + ": " + getProcessError(p));
		}
	}
	
	
	/** Recupera el mensaje de error al ejecutar un comando */
	public static String getProcessError(Process p) throws Exception {
		StringBuffer retValue = new StringBuffer();
		String s ;
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		while ((s = stdError.readLine()) != null) {
		    retValue.append(s).append(" \n");
		}
		return retValue.toString();
	}
	
	
	/**
	 * Retorna la ubicacion de openssl según la variable del sistema {@link LYEIConstants.ENV_OPENSSL_HOME}<br>
	 * En caso contrario retorna una cadena vacia.<br>
	 * En caso estar definida la variable, se estima que el usuario amplio el PATH para incluir el directorio openssl
	 */
	public static String getOpenSSLBaseDir() {
		if (System.getenv(LYEIConstants.ENV_OPENSSL_HOME)!=null)
			return System.getenv(LYEIConstants.ENV_OPENSSL_HOME) + File.separator;
		return "";
	}
	
	/**
	 * Extension del archivo
	 */
	public static String getOpenSSLFileName() {
		String osName = System.getProperty("os.name");
		if(osName.equals("Linux")){
			return "openssl";
		} else {
			return "openssl.exe";
		}
	}
	
	
	/** Retorna la extension de un archivo por lotes segun la plataforma */
	public static String getBatchFileExt() {
		return System.getProperty("os.name").equals("Linux") ? ".sh" : ".bat";
	}
	
	/**
	 * Dado un servicio (wsaa/wsfe/wsfex) y un ambiente de aplicacion (homo/prod) retorna la url de conexion.
	 * Obtiene la informacion desde la configuracion de Servicio Externo
	 */
	public static String getEndPointAddress(String prefix, String targetEnv) throws Exception {
		String value = getExternalServiceValue(prefix, targetEnv);
		// Recuperar la URL
		String retValue = DB.getSQLValueString(null, "SELECT url FROM C_ExternalService WHERE value = ?", value);
		if (Util.isEmpty(retValue))
			throw new Exception("Servicio externo con clave " + value + " no encontrado.  Verifique la configuracion de servicios externos. ");
		return retValue;
	}
	
	/**
	 * Dado un servicio (wsaa/wsfe/wsfex) y un ambiente de aplicacion (homo/prod) retorna el timeout de conexion.
	 * Obtiene la informacion desde la configuracion de Servicio Externo
	 */
	public static int getTimeout(String prefix, String targetEnv) throws Exception {
		String value = getExternalServiceValue(prefix, targetEnv);
		// Recuperar la URL
		int retValue = DB.getSQLValue(null, "SELECT timeout FROM C_ExternalService WHERE value = ?", value);
		if (Util.isEmpty(retValue))
			throw new Exception("Servicio externo con clave " + value + " no encontrado.  Verifique la configuracion de servicios externos. ");
		return retValue;
	}
	
	/**
	 * Dado un servicio (wsaa/wsfe/wsfex) y un ambiente de aplicacion (homo/prod) retorna el value del criterio de seleccion de servicio
	 */
	protected static String getExternalServiceValue(String prefix, String targetEnv) {
		// HOMO o PROD?
		String env = (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? LYEIConstants.EXTERNAL_SERVICE_HOMOLOGACION_SUFFIX : LYEIConstants.EXTERNAL_SERVICE_PRODUCCION_SUFFIX);
		String value = prefix+"_"+env;
		return value;
	}
	
	
	/** Elimina eventual adjunto de un registro de la tabla de configuracion */
	public static int deleteElectronicConfigAttachment(int recordID) {
		return DB.executeUpdate(	" DELETE FROM AD_Attachment " +
									" WHERE AD_Table_ID = " + LP_C_LYEIElectronicInvoiceConfig.Table_ID + 
									" AND Record_ID = " + recordID);
	}

	
}
