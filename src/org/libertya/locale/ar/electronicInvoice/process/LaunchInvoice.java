package org.libertya.locale.ar.electronicInvoice.process;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MInvoice;

public class LaunchInvoice extends org.openXpertya.JasperReport.LaunchInvoice {

	public LaunchInvoice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addReportParameter(MJasperReport jasperwrapper, MInvoice invoice, MBPartner bpartner) throws Exception{
		// Agregar los parámetros de CBU y Alias para el punto de venta de la config de FE
		MLYEIElectronicPOSConfig posConfig = MLYEIElectronicPOSConfig.get(invoice.getPuntoDeVenta(),
				invoice.getAD_Org_ID(), getCtx(), null);
		if(posConfig != null) {
			MLYEIElectronicInvoiceConfig genConfig = new MLYEIElectronicInvoiceConfig(getCtx(),
					posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
			jasperwrapper.addParameter("LYECTN_CBU", genConfig.getCBUEmisor());
			jasperwrapper.addParameter("LYECTN_ALIAS", genConfig.getAliasEmisor());
		}
	}
}
