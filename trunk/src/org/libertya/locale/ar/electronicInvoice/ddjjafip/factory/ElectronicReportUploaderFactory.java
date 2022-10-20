package org.libertya.locale.ar.electronicInvoice.ddjjafip.factory;

import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.ERUploader;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportUploaderStrategy;

public class ElectronicReportUploaderFactory {

private static ElectronicReportUploaderFactory instance = null;
	
	//constructor privado para singleton
	private ElectronicReportUploaderFactory() {
	}

	//patron singleton
	public static ElectronicReportUploaderFactory getInstance() {
		if(instance == null)
			instance = new ElectronicReportUploaderFactory();
		return instance;
	}
	
	public IElectronicReportUploaderStrategy getElectronicReportUploader() {
		return new ERUploader();
	}

}
