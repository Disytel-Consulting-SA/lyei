package org.libertya.locale.ar.electronicInvoice.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.openXpertya.model.MOrg;
import org.openXpertya.util.DB;

public class MLYEIElectronicInvoiceConfig extends
		LP_C_LYEIElectronicInvoiceConfig {

	public MLYEIElectronicInvoiceConfig(Properties ctx,
			int C_LYEIElectronicInvoiceConfig_ID, String trxName) {
		super(ctx, C_LYEIElectronicInvoiceConfig_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MLYEIElectronicInvoiceConfig(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave(boolean newRecord) {
		// No es posible asignar organización de tipo carpeta
		if (MOrg.get(getCtx(), getAD_Org_ID()).isSummary()) {
			log.saveError("Error", "Debe seleccionar una organizacion que no sea de tipo carpeta");
			return false;
		}
		
		// Si se está realizando una configuración con organización * (general), no deben existir otros registros
		if (getAD_Org_ID() == 0) {
			int cant = DB.getSQLValue(get_TrxName(), 	" SELECT count(1) " +
														" FROM C_LYEIElectronicInvoiceConfig " +
														" WHERE C_LYEIElectronicInvoiceConfig_ID != " + getC_LYEIElectronicInvoiceConfig_ID() +
														" AND AD_Client_ID = " + getAD_Client_ID());
			if (cant > 0) {
				log.saveError("Error", "Ya existen configuraciones de factura electronica. Solo puede existir una unica configuracion si se utilza la organizacion *");
				return false;
			}
		}
		
		if (getAD_Org_ID() > 0) {
			int cant = DB.getSQLValue(get_TrxName(), 	" SELECT count(1) " +
														" FROM C_LYEIElectronicInvoiceConfig " +
														" WHERE C_LYEIElectronicInvoiceConfig_ID != " + getC_LYEIElectronicInvoiceConfig_ID() +
														" AND (AD_Org_ID = 0 OR AD_Org_ID = " + getAD_Org_ID() + ") " +
														" AND AD_Client_ID = " + getAD_Client_ID());
			if (cant > 0) {
				log.saveError("Error", "Ya existen configuraciones de factura electronica para esta organizacion, o bien existe una configuracion con organizacion *. Solo puede existir una unica configuracion por organizacion");
				return false;
			}
		}
		
		// Se cargaron los archivos necesarios si el usuario especifico que ya cuenta con los certificados?
		if (LP_C_LYEIElectronicInvoiceConfig.CONFIGTYPE_YaCuentoConElCertificadoCSR.equals(getConfigType())) {
			setName("");
			setApplicant("");
			if (getRSACsr()==null || getRSACsr().length==0) {
				log.saveError("Error", "Debe cargar el certificado CSR");
				return false;
			}
			if (getRSAKey()==null || getRSAKey().length==0) {
				log.saveError("Error", "Debe cargar la clave privada (.key)");
				return false;
			}
		}
		
		// Verificar si se modificaron los valores bajo modalidad de generación de certificados
		if (LP_C_LYEIElectronicInvoiceConfig.CONFIGTYPE_NecesitoGenerarElCertificadoCSR.equals(getConfigType())) {
			// Han cambiado los valores?
			setNameChanged(is_ValueChanged("Name"));
			setCuitChanged(is_ValueChanged("CUIT"));
			setApplicantChanged(is_ValueChanged("Applicant"));
		}

		return true;
	};
	
	@Override
	protected boolean afterDelete(boolean success) {
		// Si es posible eliminar la cabecera, eliminar las lineas también 
		if (success) {
			DB.executeUpdate("DELETE FROM C_LYEIElectronicPOSConfig WHERE C_LYEIElectronicInvoiceConfig_ID = " + getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
		}
		return super.afterDelete(success);
	}


}
