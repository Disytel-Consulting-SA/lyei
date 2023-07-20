package org.libertya.locale.ar.electronicInvoice.process;

import org.openXpertya.process.PluginPostInstallProcess;

public class LYEIPostInstallUpgradeFrom_24 extends PluginPostInstallProcess {

	/** UID del Reporte de DDJJ presentadas */
	// TODO: verificar UID del jasper y actualizar la linea de abajo
	protected final static String LYEI_DDJJ_JASPER_REPORT_UID = "LYEI-AD_JasperReport-20230720153726659-059622";
	protected final static String LYEI_DDJJ_JASPER_REPORT_FILENAME = "DDJJPresentadas.jasper";
	
	@Override
	protected String doIt() throws Exception {
		super.doIt();
		
		// Reporte de DDJJ presentadas
		/**
		MJasperReport
			.updateBinaryData(
					get_TrxName(),
					getCtx(),
					LYEI_DDJJ_JASPER_REPORT_UID,
					JarHelper
							.readBinaryFromJar(
									jarFileURL,
									getBinaryFileURL(LYEI_DDJJ_JASPER_REPORT_FILENAME)));
		
		* Se trata de un reporte dinamico cuya query esta dentro del mismo jasper
		* dREHER
		*/
		
		updateReport(LYEI_DDJJ_JASPER_REPORT_UID, LYEI_DDJJ_JASPER_REPORT_FILENAME);
		
		return "";
	}

}
