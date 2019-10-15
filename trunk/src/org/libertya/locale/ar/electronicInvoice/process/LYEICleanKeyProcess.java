package org.libertya.locale.ar.electronicInvoice.process;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicInvoiceConfig;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;

public class LYEICleanKeyProcess extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		LP_C_LYEIElectronicInvoiceConfig aConfig = new LP_C_LYEIElectronicInvoiceConfig(getCtx(), getRecord_ID(), get_TrxName());
		aConfig.setRSAKey(null);
		if (!aConfig.save()) {
			throw new Exception("Error al eliminar KEY: " + CLogger.retrieveErrorAsString());
		}
		return "Finalizado";	}

}
