package org.libertya.locale.ar.electronicInvoice.process;

import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.openXpertya.model.CalloutInvoiceExt;
import org.openXpertya.model.MAttachment;
import org.openXpertya.model.MClientInfo;
import org.openXpertya.model.MOrgInfo;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;

public class LYEIConfirmConfigurationProcess extends SvrProcess {

	protected boolean previousConfigExists = false;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}	
	
	@Override
	protected String doIt() throws Exception {
		
		LP_C_LYEIElectronicInvoiceConfig aConfig = new LP_C_LYEIElectronicInvoiceConfig(getCtx(), getRecord_ID(), get_TrxName());
		
		// Si el usuario ya tiene los certificados no hay mucho más para hacer
		if (LP_C_LYEIElectronicInvoiceConfig.CONFIGTYPE_YaCuentoConElCertificadoCSR.equals(aConfig.getConfigType())) {
			
			// El usuario cargó los archivos?
			if (aConfig.getRSACsr() == null || aConfig.getRSACsr().length == 0)
				throw new Exception ("Imposible confirmar: No se ha cargado el certificado CSR");
			if (aConfig.getRSAKey() == null || aConfig.getRSAKey().length == 0)
				throw new Exception ("Imposible confirmar: No se ha cargado la clave privada");
			
			// Marcar como procesado y actualizar
			aConfig.setProcessed(true);
			aConfig.save();
			
			// El adjunto no tiene utilidad bajo esta configuracion
			LYEITools.deleteElectronicConfigAttachment(getRecord_ID());
			
			return "Finalizado";
		}
		
		// Validar precondiciones
		checkPreconditions(aConfig);
		
		// Genera los CSR
		generateCSR(aConfig);

		StringBuffer retValue = new StringBuffer("Finalizado. ");
		if (previousConfigExists) {
			retValue.append("Modificaciones contempladas: ");
			if (aConfig.isCuitChanged())
				retValue.append("Cambio de CUIT. ");
			if (aConfig.isNameChanged())
				retValue.append("Cambio de Nombre. ");
			if (aConfig.isApplicantChanged())
				retValue.append("Cambio de Solicitante. ");
			if (aConfig.isCuitChanged() || aConfig.isNameChanged() || aConfig.isApplicantChanged()) {
				retValue.append("Fue necesario generar nuevo CSR y KEY! Los mismos se encuentran adjuntos (requiere reabrir la ventana). ");
			}
			else {
				retValue.append("Ninguna. No fue necesario generar un nuevo CSR. ");
			}
		} else {
			retValue.append("El certificado (CSR) y la clave privada (KEY) se encuentran adjuntos en el presente registro (requiere reabrir la ventana). ");
		}
		
		// Actualizar estado del registro
		aConfig.setProcessed(true);
		aConfig.setNameChanged(false);
		aConfig.setCuitChanged(false);
		aConfig.setApplicantChanged(false);
		aConfig.save();
		
		return retValue.toString();
	}
	
	
	/**
	 * Valida el CUIT y la existencia de la Categoría de IVA
	 *  (si el usuario no la configuró actualmente en la ventana Organización / Compañía 
	 *  debe indicar un error y avisarle que es necesario configurarla).
	 */
	protected void checkPreconditions(LP_C_LYEIElectronicInvoiceConfig aConfig) throws Exception {
		// CUIT valido?
		if (aConfig.getCUIT()==null || aConfig.getCUIT().length()==0 || !CalloutInvoiceExt.ValidarCUIT(aConfig.getCUIT()))
			throw new Exception("Debe especificar un CUIT valido");
		
		// Categoría IVA valido?
		if (aConfig.getAD_Org_ID() == 0) {
			if (MClientInfo.get(getCtx(), aConfig.getAD_Client_ID()).getC_Categoria_Iva_ID()==0) {
				throw new Exception("Debe especificar una Categoríade IVA válida en la configuración de la compañía");
			}
		} else {
			if (MOrgInfo.get(getCtx(), aConfig.getAD_Org_ID()).getC_Categoria_IVA_ID()==0) {
				throw new Exception("Debe especificar una Categoríade IVA válida en la configuración de la organización especificada");
			}
		}
	}
	
	
	/** Genera el .key y el .csr necesarios para luego obtener el crt
	 *  Retorna true si generó uno nuevo o false si no fue necesario.
	 *  Eleva una excepcion en caso de error.
	 */
	protected boolean generateCSR(LP_C_LYEIElectronicInvoiceConfig aConfig) throws Exception {
	
		// Ya existía un certificado?
		int csrPrevio = DB.getSQLValue(null,	
							" SELECT count(1) FROM AD_Attachment " +
							" WHERE AD_Table_ID = " + LP_C_LYEIElectronicInvoiceConfig.Table_ID + 
							" AND Record_ID = " + getRecord_ID());
		previousConfigExists = (csrPrevio > 0);
		
		// Si se esta confirmando la configuracion por segunda vez (o tercera, etc...); entonces
		// hay que validar si efectivamente se realizó algun cambio que requiera regenerar el CSR
		if (previousConfigExists && !aConfig.isCuitChanged() && !aConfig.isNameChanged() && !aConfig.isApplicantChanged()) {
			return false;
		}
		
		// Creacion key para produccion y copia a test
		LYEITools.executeCommand("creacion " + getKEYName(aConfig), getKEYCommandLine(aConfig));
		
		// Creacion del CSR para produccion.  Posteriormente copialo a test
		// Se utiliza un archivo por lotes en donde se almacenan los comandos dado que la invocacion 
		// directa desde Java arrojaba errores varios en el uso de openssl con opcion -subj
		String csrGeneratorFileName = "csrGenerator" + LYEITools.getBatchFileExt();	
		PrintWriter out = new PrintWriter(csrGeneratorFileName);
		out.println(getCSRCommandLine(aConfig));
		out.close();
		
		setExecPermission(csrGeneratorFileName);
		LYEITools.executeCommand("creacion CSR", getCSRCommandLine(csrGeneratorFileName));
		
		// Adjuntar los CSR en el registro
		attachCSR(aConfig);
		return true;
	}

	
	/** Retorna la linea de comandos necesaria a ejecutar para la creacion del Key */
	protected String getKEYCommandLine(LP_C_LYEIElectronicInvoiceConfig aConfig) {
		return 
				LYEITools.getOpenSSLBaseDir() + LYEITools.getOpenSSLFileName() + " genrsa " +
				" -out " + getKEYName(aConfig) + " 2048";
	}
	
	/** Retorna la linea de comandos necesaria a ejecutar para la creacion del CSR */
	protected String getCSRCommandLine(LP_C_LYEIElectronicInvoiceConfig aConfig) {
		return
				LYEITools.getOpenSSLBaseDir() + LYEITools.getOpenSSLFileName() + " req -new " +
				" -key "    + getKEYName(aConfig) + 
				" -out "    + getCSRName(aConfig) + 
				" -config " + getAfipCnf() +   
				" -subj "	+ getOpenSSLSubj(aConfig);
	} 
		
	/** Retorna la ubicacion */
	protected String getAfipCnf() {
		return "\"" + System.getProperty("user.home") + File.separator + "afip-openssl.cnf" + "\"";
	}
	
	/** Genera el snippet para evitar prompt interactivo por parte de openssl */
	protected String getOpenSSLSubj(LP_C_LYEIElectronicInvoiceConfig aConfig) {
		StringBuffer retValue = new StringBuffer();

		retValue.append("\"");
		retValue.append("/countryName=").append("AR"); 		// Este argumento por el momento es fijo
		retValue.append("/organizationName=").append(aConfig.getName());
		retValue.append("/commonName=").append(aConfig.getApplicant());
		retValue.append("/serialNumber=").append(aConfig.getCUIT());
		retValue.append("\"");
		
		return retValue.toString();
	}
	
	/** Modifica las propiedades para ejecucion bajo Linux */
	protected void setExecPermission(String fileName) throws Exception {
		if (System.getProperty("os.name").equals("Linux")) {
			LYEITools.executeCommand("creacion geneador CSR", "chmod ugo+x " + fileName);
		}
	}

	protected String getCSRCommandLine(String fileName) throws Exception {
		String retValue = fileName;
		// Para linux se especifica directorio local dado que puede no estar especificado en el PATH
		if (System.getProperty("os.name").equals("Linux")) {
			retValue = "./" + fileName;
		}
		return retValue;
	}
	
	/** Adjunta el CSR (test y prod) */
	protected void attachCSR(LP_C_LYEIElectronicInvoiceConfig aConfig) throws Exception {
		// Eliminar eventual viejo adjunto
		LYEITools.deleteElectronicConfigAttachment(getRecord_ID());
		// Adjuntar CSR para que el usuario pueda descargarlo
		File csr = new File(getCSRName(aConfig));
		File key = new File(getKEYName(aConfig));
		MAttachment anAttachment = new MAttachment(getCtx(), LP_C_LYEIElectronicInvoiceConfig.Table_ID, getRecord_ID(), get_TrxName());
		anAttachment.addEntry(csr);
		anAttachment.addEntry(key);
		if (!anAttachment.save()) {
			throw new Exception("Error adjuntando CSR: " + CLogger.retrieveErrorAsString());
		}
		// Almacenar además el CSR y el KEY en el registro
		aConfig.setRSACsr(FileUtils.readFileToByteArray(csr));
		aConfig.setRSAKey(FileUtils.readFileToByteArray(key));
		if (!aConfig.save()) {
			throw new Exception("Error almacenando CSR/KEY: " + CLogger.retrieveErrorAsString());
		}
		csr.delete();
		key.delete();
	}

	/** Retorna el nombre del CSR basado en los datos de la compañía */
	protected String getCSRName(LP_C_LYEIElectronicInvoiceConfig aConfig) {
		return aConfig.getName().replace(" ", "") + "_" + aConfig.getCUIT() + ".csr";
	}

	/** Retorna el nombre del KEY basado en los datos de la compañía */
	protected String getKEYName(LP_C_LYEIElectronicInvoiceConfig aConfig) {
		return aConfig.getName().replace(" ", "") + "_" + aConfig.getCUIT() + ".key";
	}
}
