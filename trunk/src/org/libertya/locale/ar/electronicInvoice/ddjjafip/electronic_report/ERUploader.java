package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSDDJJ;


public class ERUploader implements IElectronicReportUploaderStrategy {
	protected LP_C_LYEIElectronicPOSConfig posConfig;
	
	public ERUploader() {
	}

	@Override
	public String uploadER(String archivoPresentacion) {
		
		LYEIWSDDJJ ddjjService = new LYEIWSDDJJ(this.posConfig);
//		String res = ddjjService.dummy();
		String res = ddjjService.uploadToAFIP(archivoPresentacion);
		
		return res;
	}

	@Override
	public LP_C_LYEIElectronicPOSConfig getPosConfig() {
		return this.posConfig;
	}

	@Override
	public void setPosConfig(int c_lyeielectronicPosConfig_id) {
		this.posConfig = new LP_C_LYEIElectronicPOSConfig(null, c_lyeielectronicPosConfig_id, null);
	}

	
	

}
