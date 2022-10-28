package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;

public interface IElectronicReportUploaderStrategy {
	
	//posConfig
	LP_C_LYEIElectronicPOSConfig getPosConfig();
	void setPosConfig(int c_lyeiElectronicPosConfig_id);
	
	public String uploadER(String archivoPresentacion);
}

