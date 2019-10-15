package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.ProcessInfoUtil;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;

public class LYEICreatePOSProcess extends SvrProcess {

	/** Organización indicada como argumento */
	protected int orgID;
	
	/** Numero de punto de venta a generar */
	protected int posNumber;
	
	/** Nombre de los tipos de documento creados (en función de retorn */
	protected String[] docTypeNames;
	
	/** Ya se habían creado los tipos de documento? */
	protected boolean docTypesAlreadyCreated = false;
	
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("AD_Org_ID")) {
				orgID = para[i].getParameterAsInt();
			} else if (name.equalsIgnoreCase("POSNumber")) {
				posNumber =  para[i].getParameterAsInt();
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		
		LP_C_LYEIElectronicInvoiceConfig aConfig = new LP_C_LYEIElectronicInvoiceConfig(getCtx(), getRecord_ID(), get_TrxName());
		
		// Validar si estan dadas las condiciones
		checkPreconditions(aConfig);
		
		// Crear los nuevos tipos de documento 
		createPOSDocTypes();
		
		// Configura los tipos de documento
		configurePOSDocTypes();
		
		// Crea una entrada en POSConfig 
		createPOSConfig(aConfig);
		
		String retValue = "Finalizado.  Tipos de documento electrónicos generados."; 
		
		if (docTypesAlreadyCreated)
			retValue = "Finalizado.  Tipos de documento electrónicos ya existentes.";
		
		return retValue;
	}
	
	
	/** Validaciones preliminares */
	protected void checkPreconditions(LP_C_LYEIElectronicInvoiceConfig aConfig) throws Exception {
		// Si la Configuración es para Organización * entonces permite elegir * o cualquier Organización Concreta
		// Si la Organización de la Configuración es Concreta, solo se puede elegir esa Organización para el Punto de Venta.
		if (aConfig.getAD_Org_ID() > 0 && aConfig.getAD_Org_ID() != orgID) {
			throw new Exception("Debe indicar misma organizacion que la especificada en la configuración");
		}
		// El numero de pto venta debe se entre 1 y 9999
		if (posNumber < 1 || posNumber > 9999) {
			throw new Exception("El punto de venta debe ser un valor entre 1 y 9999");
		}
		
	}
	
	/** Creacion de los tipos de documento */
	protected void createPOSDocTypes() throws Exception {
		
		// Recuperar ID de proceso "PoSDocTypesCreate"
		int processID = DB.getSQLValue(null, "SELECT AD_Process_ID FROM AD_Process WHERE AD_ComponentObjectUID = 'CORE-AD_Process-1000161'");
		ProcessInfo pi = new ProcessInfo("PoSDocTypesCreate", processID);

		// Argumento organizacion
		ProcessInfoParameter paramOrg = new ProcessInfoParameter("AD_Org_ID", new BigDecimal(orgID), null, null, null);
		pi.setParameter(ProcessInfoUtil.addToArray(pi.getParameter(), paramOrg));
		// Argumento numero de Pto de Venta
		ProcessInfoParameter paramPOSNro = new ProcessInfoParameter("POSNumber", new BigDecimal(posNumber), null, null, null);
		pi.setParameter(ProcessInfoUtil.addToArray(pi.getParameter(), paramPOSNro));

		// Ejecutar la creación
		MProcess process = new MProcess(getCtx(), processID, get_TrxName());
    	MProcess.execute(getCtx(), process, pi, get_TrxName());
    	
    	// Hubo un error en la ejecucion?
    	if (pi.isError()) {
       		// Si ese no es el error, entonces elevar el error
   			throw new Exception("Error al crear tipos de documentos: " + pi.getSummary());
    	}
    	
		// ¿El mensaje es que los tipos de documentos ya habian sido creados previamente?
		if (pi.getSummary().contains("Los tipos de documentos para el punto de venta seleccionado ya estaban creados")) {
			docTypesAlreadyCreated = true;
			return;
		}
    	
    	// Parsear el resultado de la ejecución y guardarme los nombres de los tipos de documento
    	String retMsg = pi.getSummary();
    	int from = retMsg.indexOf("[");
    	int to = retMsg.indexOf("]");
    	if (from == -1 || to == -1) 
    		throw new Exception("Error al crear tipos de documentos: " + pi.getSummary());
    	retMsg = retMsg.substring(from+1, to).trim();
    	docTypeNames = retMsg.split(",");
	}
	
	/** Configura los tipos de documento */
	protected void configurePOSDocTypes() throws Exception {

		// Si los documentos ya habian sido creado nuevamente, no se tocan
		if (docTypesAlreadyCreated)
			return;
		
		// Configurar a los tipos de documento como electronicos
		int[] docTypeIDs = PO.getAllIDs("C_DocType", getDocTypeNamesWhereClause() , get_TrxName());
		for (int docTypeID : docTypeIDs) {
			MDocType aDocType = new MDocType(getCtx(), docTypeID, get_TrxName());
			aDocType.setdocsubtypeinv(X_C_DocType.DOCSUBTYPEINV_Electronico);
			aDocType.setdocsubtypecae(getDocSubTypeCAE(aDocType));
			aDocType.setIsFiscalDocument(true);
			aDocType.setiselectronic(true);
			// Si no hay un tipo de documento electronico asociado, desactivar el doctype
			if (getDocSubTypeCAE(aDocType) == null)
				aDocType.setIsActive(false);
			if (!aDocType.save()) {
				throw new Exception("Error al actualizar el tipo de documento creado: " + CLogger.retrieveErrorAsString());
			}
		}
		
		// Desactiva los que no son necesarios segun la configuracion Letra Acepta IVA
    	// TODO: Pendiente de implementar
		
		
	}
	
	
	/** Crea una nueva entrada en POSConfig */
	protected void createPOSConfig(LP_C_LYEIElectronicInvoiceConfig aConfig) throws Exception {
		// Recuperar el posConfig o crear uno nuevo
		int posConfigID = DB.getSQLValue(get_TrxName(), " SELECT C_LYEIElectronicPOSConfig_ID " +
														" FROM C_LYEIElectronicPOSConfig " +
														" WHERE AD_Org_ID = " + orgID + 
														" AND POS = " + posNumber); 
		if (posConfigID==-1)
			posConfigID=0;
		MLYEIElectronicPOSConfig posConfig = new MLYEIElectronicPOSConfig(getCtx(), posConfigID, get_TrxName());
		posConfig.setC_LYEIElectronicInvoiceConfig_ID(aConfig.getC_LYEIElectronicInvoiceConfig_ID());
		posConfig.setPOS(posNumber);
		posConfig.setClientOrg(aConfig.getAD_Client_ID(), orgID);
		posConfig.setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_NoCRT);
		posConfig.setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_NoCRT);
		posConfig.setProductionCRT(null);
		posConfig.setTestCRT(null);
		posConfig.setCurrentEnvironment(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo);
		if (!posConfig.save()) {
			throw new Exception("Error al crear la configuracion de Punto de Venta " + posNumber + ": " + CLogger.retrieveErrorAsString());
		}
	}
	
	
	/** Retorna la clausula por la cual recuperar los tipos de documento a partir de su nombre */
	protected String getDocTypeNamesWhereClause() throws Exception {
		StringBuffer retValue = new StringBuffer();
		retValue.append( " AD_Org_ID = ").append(orgID);
		retValue.append( " AND Name IN (");
		for (String docTypeName : docTypeNames) 
			retValue.append("'").append(docTypeName.trim()).append("',");
		retValue.append( "'' )");
		return retValue.toString();
		
	}
	
	/** Retorna el DocSubTypeCAE segun el tipo de documento*/
	protected String getDocSubTypeCAE(MDocType aDocType) throws Exception {
		// Comprobantes A
		if (aDocType.getDocTypeKey().startsWith("CIA"))
			return X_C_DocType.DOCSUBTYPECAE_FacturasA;
		if (aDocType.getDocTypeKey().startsWith("CCNA"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoA;  
		if (aDocType.getDocTypeKey().startsWith("CDNA"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoA;  
		// Comprobantes B
		if (aDocType.getDocTypeKey().startsWith("CIB"))
			return X_C_DocType.DOCSUBTYPECAE_FacturasB;
		if (aDocType.getDocTypeKey().startsWith("CCNB"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoB;
		if (aDocType.getDocTypeKey().startsWith("CDNB"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoB;
		// Comprobantes C
		if (aDocType.getDocTypeKey().startsWith("CIC"))
			return X_C_DocType.DOCSUBTYPECAE_FacturasC;
		if (aDocType.getDocTypeKey().startsWith("CCNC"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoC;
		if (aDocType.getDocTypeKey().startsWith("CDNC"))
			return X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoC;
		// Comprobantes E
		if (aDocType.getDocTypeKey().startsWith("CIE"))
			return X_C_DocType.DOCSUBTYPECAE_FacturaDeExportaciónE;
		if (aDocType.getDocTypeKey().startsWith("CCNE"))
			return X_C_DocType.DOCSUBTYPECAE_NotaDeCréditoPorOperacionesEnElExterior;
		if (aDocType.getDocTypeKey().startsWith("CDNE"))
			return X_C_DocType.DOCSUBTYPECAE_NotaDeDébitoPorOperacionesEnElExterior;		
		return null;
	}

	
}
