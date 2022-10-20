package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSDDJJ;


public class ERUploader implements IElectronicReportUploaderStrategy {

	@Override
	public String uploadER(String archivoPresentacion) {
		
		LYEIWSDDJJ ddjjService = new LYEIWSDDJJ();
//		String res = ddjjService.dummy();
		String res = ddjjService.uploadToAFIP(archivoPresentacion);
		
		return res;
	}

	
	

}
