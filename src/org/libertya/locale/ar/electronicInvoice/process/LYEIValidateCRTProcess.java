package org.libertya.locale.ar.electronicInvoice.process;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.openXpertya.process.SvrProcess;

public class LYEIValidateCRTProcess extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {

		MLYEIElectronicPOSConfig posConfig = new MLYEIElectronicPOSConfig(getCtx(), getRecord_ID(), get_TrxName());
		MLYEIElectronicInvoiceConfig aConfig = new MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
		
		// Validaciones previas
		checkPreconditions(posConfig);
		
		// Realizar validación
		String check = validateCRT(aConfig, posConfig);
		
		if (check.length() > 0)
			return check;
		
		return "Validacion finalizada sin haber detectado inconvenientes.";
		
	}
	
	
	/** Validar si es factible realizar la validacion */
	protected void checkPreconditions(MLYEIElectronicPOSConfig posConfig) throws Exception {
		if (posConfig.getProductionCRT() == null)
			throw new Exception("Debe cargar el CRT de produccion previo a su validacion");
		if (posConfig.getTestCRT() == null)
			throw new Exception("Debe cargar el CRT de homologacion previo a su validacion");
	}

		
	
	/** Verifica si el CRT es valido o no */
	protected String validateCRT(MLYEIElectronicInvoiceConfig aConfig, MLYEIElectronicPOSConfig posConfig) throws Exception {
		
		StringBuffer result = new StringBuffer();
		
		// Validar test
		try {
			LYEIWSAA.newTA(posConfig, getCtx(), LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo);
			posConfig.setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_ValidCRT);
		} catch (Exception e) {
			result.append("Error en validación certificado homologación: ").append(e).append(". ");
			posConfig.setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_InvalidCRT);
		}
		
		// Validar prod
		try {
			LYEIWSAA.newTA(posConfig, getCtx(), LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod);
			posConfig.setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_ValidCRT);
		} catch (Exception e) {
			result.append("Error en validación certificado produccion: ").append(e).append(". ");			
			posConfig.setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_InvalidCRT);
		}
			
		// Guardar status
		posConfig.save();

		// Retornar resultado de la validacion
		return result.toString();
	}

}
