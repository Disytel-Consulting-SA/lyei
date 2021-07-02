package org.libertya.locale.ar.electronicInvoice.reportProvider;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.PO;
import org.openXpertya.plugin.report.ReportProviderInterface;

public class LaunchInvoice implements ReportProviderInterface {

	@Override
	public void addReportParametersToLaunch(MJasperReport report, PO po) {
		// Agregar los parámetros de CBU y Alias para el punto de venta de la config de FE
		MInvoice invoice = (MInvoice)po;
		MLYEIElectronicPOSConfig posConfig = MLYEIElectronicPOSConfig.get(invoice.getPuntoDeVenta(),
				invoice.getAD_Org_ID(), invoice.getCtx(), null);
		if(posConfig != null) {
			MLYEIElectronicInvoiceConfig genConfig = new MLYEIElectronicInvoiceConfig(invoice.getCtx(),
					posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
			report.addParameter("LYECTN_CBU", genConfig.getCBUEmisor());
			report.addParameter("LYECTN_ALIAS", genConfig.getAliasEmisor());
		}
	}
}
