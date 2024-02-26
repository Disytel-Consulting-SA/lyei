package org.libertya.locale.ar.electronicInvoice.process;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_ExternalService;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.openXpertya.model.MExternalService;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MPOSJournal;
import org.openXpertya.model.MTable;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

public class LYEIValidateCRTProcess extends SvrProcess {

	/** Recuperacion un CUIT en particular: punto de venta */
	private int ptoVta = 0;
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** ID de la compañía */
	Integer clientID = null;
	/** ID de la organización */
	Integer orgID = null;
	
	@Override
	protected void prepare() {

		clientID = Env.getAD_Client_ID(getCtx());
		orgID = Env.getAD_Org_ID(getCtx());
	}

	@Override
	protected String doIt() throws Exception {
		String check = "";
		
		/**
		 * Detecto la tabla para saber si se esta validando desde configuracion de factura electronica o desde servicio externo
		 * 
		 * dREHER
		 */
		if(MExternalService.Table_ID!=getTable_ID()) {

			MLYEIElectronicPOSConfig posConfig = new MLYEIElectronicPOSConfig(getCtx(), getRecord_ID(), get_TrxName());
			MLYEIElectronicInvoiceConfig aConfig = new MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());

			// Validaciones previas
			checkPreconditions(posConfig);

			// Realizar validación
			check = validateCRT(aConfig, posConfig);
		}else {
			LP_C_ExternalService es = new LP_C_ExternalService(Env.getCtx(), getRecord_ID(), get_TrxName());
			// Validaciones previas
			checkPreconditions(es);
			
			loadInitialValues();
			
			// Realizar validación
			if(genConfig!=null)
				check = validateCRT(genConfig, es);
		}

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
	
	/** Validar si es factible realizar la validacion sobre entidades externas 
	 * 
	 * dREHER
	 * */
	protected void checkPreconditions(LP_C_ExternalService esConfig) throws Exception {
		if (esConfig.getProductionCRT() == null && esConfig.getTestCRT() == null)
			throw new Exception("Debe cargar algun CRT previo a su validacion");
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
	
	/** Verifica si el CRT es valido o no */
	protected String validateCRT(MLYEIElectronicInvoiceConfig aConfig, LP_C_ExternalService esConfig) throws Exception {
		
		StringBuffer result = new StringBuffer();
		String serviceName = LYEIWSAA.getServiceFromClaveSE(esConfig.getValue());
		
		// Validar test
		try {
			LYEIWSAA.newTA(posConfig, getCtx(), LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo, serviceName);
			esConfig.setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_ValidCRT);
		} catch (Exception e) {
			result.append("Error en validación certificado homologación: ").append(e).append(". ");
			esConfig.setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_InvalidCRT);
		}
		
		// Validar prod
		try {
			LYEIWSAA.newTA(posConfig, getCtx(), LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod, serviceName);
			esConfig.setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_ValidCRT);
		} catch (Exception e) {
			result.append("Error en validación certificado produccion: ").append(e).append(". ");			
			esConfig.setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_InvalidCRT);
		}
			
		// Guardar status
		esConfig.save();

		// Retornar resultado de la validacion
		return result.toString();
	}
	
	
	// ------------------------------------------------------------------------------------------------------------------- leer configuracion electronica por defecto
	
	/** 
	 * Carga inicial 
	 * Sobrecarga para poder enviar el punto de venta correspondiente
	 * dREHER
	 * */
	public void loadInitialValues() throws Exception {
		
		if (MPOSJournal.isActivated() && Util.isEmpty(ptoVta, true) ) {
			MPOSJournal caja = MPOSJournal.get(Env.getCtx(), 
												Env.getAD_User_ID(getCtx()), 
												Env.getDate(), 
												new String[]{"IP"}, 
												get_TrxName());
			if(caja!=null) {
				MPOS pos = caja.getPOS();
				if(pos!=null)
					ptoVta = pos.getPOSNumber();
				else
					this.addLog(0, null, null, "No se encontro punto de venta en la caja abierta de este usuario!");
			}else
				this.addLog(0, null, null, "No se encontro una caja abierta para este usuario!");
			
		}
		
		loadInitialValues(ptoVta);
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:0), getOrgID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + (ptoVta>0?ptoVta:0)
					+ " y la organizacion del tipo de documento (" + getOrgID() + ")");
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar configuracion de fac electronica " + getClientID() + ". " + ex.getMessage());
		}
	}
	
	public Integer getClientID() {
		return clientID;
	}
	
	public Integer getOrgID() {
		return orgID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}

}
