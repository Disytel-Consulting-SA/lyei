package org.libertya.locale.ar.electronicInvoice.process;

import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.process.PluginPostInstallProcess;
import org.openXpertya.utils.JarHelper;

public class LYEIPostInstallUpgradeFrom_22 extends PluginPostInstallProcess {

	/** UID del Reporte de Comprobantes Registrados Electrónicos */
	protected final static String LYEI_CCRE_JASPER_REPORT_UID = "LYEI-AD_JasperReport-20210622152634885-593436";
	protected final static String LYEI_CCRE_JASPER_REPORT_FILENAME = "LYEIConsultarComprobantesReport.jasper";
	
	@Override
	protected String doIt() throws Exception {
		super.doIt();
		
		// Reporte de Movimientos Valorizados Detallado
		MJasperReport
			.updateBinaryData(
					get_TrxName(),
					getCtx(),
					LYEI_CCRE_JASPER_REPORT_UID,
					JarHelper
							.readBinaryFromJar(
									jarFileURL,
									getBinaryFileURL(LYEI_CCRE_JASPER_REPORT_FILENAME)));
		
		return "";
	}

}
