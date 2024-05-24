package org.libertya.locale.ar.electronicInvoice.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.openXpertya.model.PO;

public class MLYEIElectronicPOSConfig extends LP_C_LYEIElectronicPOSConfig {

	public MLYEIElectronicPOSConfig(Properties ctx, int C_LYEIElectronicInvoiceConfig_ID, String trxName) {
		super(ctx, C_LYEIElectronicInvoiceConfig_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MLYEIElectronicPOSConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave(boolean newRecord) {
		// CRT de Produccion
		if (getProductionCRT() == null)
			setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_NoCRT);
		else if (is_ValueChanged("ProductionCRT"))
			setProductionCRTStatus(LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_ValidationPending);

		// CRT de Homologacion
		if (getTestCRT() == null)
			setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_NoCRT);
		else if (is_ValueChanged("TestCRT"))
			setTestCRTStatus(LP_C_LYEIElectronicPOSConfig.TESTCRTSTATUS_ValidationPending);
	
		return true;
	};
	
	/**
	 * Retorna una POSConfig a partir de un punto de venta y la organizacion
	 * @param pos
	 * @param orgID
	 * @return
	 */
	public static MLYEIElectronicPOSConfig get(int pos, int orgID, Properties ctx, String trxName) {
		// Segun la configuracion realizada, pueden darse los siguientes casos:
		//		1) Que en la configuracion se utilice la organizacion *, por lo tanto hay que buscar bajo AD_Org_ID = 0
		//		2) Que en la configuracion se utilicen distintas organizaciones, por lo tanto hay que buscar con la org recibida como argumente
		// En cualquier caso, no es factible tener una combinación de organizaciones y adicionalmente la organización * 
		return (MLYEIElectronicPOSConfig)PO.findFirst(ctx, LP_C_LYEIElectronicPOSConfig.Table_Name, "(AD_Org_ID = 0 OR AD_Org_ID = ?) AND POS = ?", new Object[]{orgID, pos}, null, trxName);
	}
	
	/**
	 * Retorna una POSConfig a partir de un punto de venta
	 * @param pos
	 * @return
	 */
	public static MLYEIElectronicPOSConfig get(int pos, Properties ctx, String trxName) {
		// Segun la configuracion realizada, pueden darse los siguientes casos:
		//		1) Que en la configuracion se utilice la organizacion *, por lo tanto hay que buscar bajo AD_Org_ID = 0
		//		2) Que en la configuracion se utilicen distintas organizaciones, por lo tanto hay que buscar con la org recibida como argumente
		// En cualquier caso, no es factible tener una combinación de organizaciones y adicionalmente la organización * 
		return (MLYEIElectronicPOSConfig)PO.findFirst(ctx, LP_C_LYEIElectronicPOSConfig.Table_Name, " POS = ? ", new Object[]{pos}, null, trxName);
	}
	
	/**
	 * Retorna una POSConfig dentro de la organizacion que tenga validado al certificado y este activa
	 * @param pos
	 * @return
	 */
	public static MLYEIElectronicPOSConfig get(Properties ctx, String trxName, int AD_Org_ID) {
		// Segun la configuracion realizada, pueden darse los siguientes casos:
		//		1) Que en la configuracion se utilice la organizacion *, por lo tanto hay que buscar bajo AD_Org_ID = 0
		//		2) Que en la configuracion se utilicen distintas organizaciones, por lo tanto hay que buscar con la org recibida como argumente
		// En cualquier caso, no es factible tener una combinación de organizaciones y adicionalmente la organización * 
		return (MLYEIElectronicPOSConfig)PO.findFirst(ctx, LP_C_LYEIElectronicPOSConfig.Table_Name,
				"(AD_Org_ID = 0 OR AD_Org_ID = ?) AND IsActive='Y' " +
				"AND ( (CurrentEnvironment='H' AND TestCRTStatus='V') " +
						" OR " +
				" (CurrentEnvironment='P' AND ProductionCRTStatus='V') " +
				" ) AND caemethod = 'C'", new Object[]{AD_Org_ID}, null, trxName);
	}
}
