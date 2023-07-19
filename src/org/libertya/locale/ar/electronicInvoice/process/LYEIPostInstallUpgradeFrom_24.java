package org.libertya.locale.ar.electronicInvoice.process;

import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.process.PluginPostInstallProcess;
import org.openXpertya.utils.JarHelper;

public class LYEIPostInstallUpgradeFrom_24 extends PluginPostInstallProcess {

	/** UID del Reporte de DDJJ presentadas */
	// TODO: verificar UID del jasper y actualizar la linea de abajo
	protected final static String LYEI_DDJJ_JASPER_REPORT_UID = "LYEI-AD_JasperReport-20210622152634885-593436";
	protected final static String LYEI_DDJJ_JASPER_REPORT_FILENAME = "DDJJ.jasper";
	
	@Override
	protected String doIt() throws Exception {
		super.doIt();
		
		// Reporte de DDJJ presentadas
		MJasperReport
			.updateBinaryData(
					get_TrxName(),
					getCtx(),
					LYEI_DDJJ_JASPER_REPORT_UID,
					JarHelper
							.readBinaryFromJar(
									jarFileURL,
									getBinaryFileURL(LYEI_DDJJ_JASPER_REPORT_FILENAME)));
		
		return "";
	}

}
