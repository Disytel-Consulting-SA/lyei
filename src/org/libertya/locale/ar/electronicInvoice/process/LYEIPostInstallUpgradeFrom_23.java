package org.libertya.locale.ar.electronicInvoice.process;

import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.process.PluginPostInstallProcess;
import org.openXpertya.utils.JarHelper;

public class LYEIPostInstallUpgradeFrom_23 extends PluginPostInstallProcess {

	/** UID del Reporte de DDJJ presentadas */
	// TODO: verificar UID del jasper y actualizar la linea de abajo 
	protected final static String LYEI_DDJJ_JASPER_REPORT_UID = "LYEI-AD_Process-20230721101612939-083103";
																
																	// AL tratarse de un reporte adjunto, paso el UID del proceso y no del JasperReport
																	// "LYEI-AD_JasperReport-20230721103037826-509907";
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
