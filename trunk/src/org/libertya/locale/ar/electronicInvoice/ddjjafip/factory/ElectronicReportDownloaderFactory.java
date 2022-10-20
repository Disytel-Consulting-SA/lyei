package org.libertya.locale.ar.electronicInvoice.ddjjafip.factory;

import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.ERDownloaderGetaudarLinuxStrategy;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.ERDownloaderGetaudarWindowsStrategy;
import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.IElectronicReportDownloaderStrategy;

public class ElectronicReportDownloaderFactory {

	private static ElectronicReportDownloaderFactory instance = null;
	
	//constructor privado para singleton
	private ElectronicReportDownloaderFactory() {
	}

	//patron singleton
	public static ElectronicReportDownloaderFactory getInstance() {
		if(instance == null)
			instance = new ElectronicReportDownloaderFactory();
		return instance;
	}
	
	
	public IElectronicReportDownloaderStrategy getERDownloaderGetaudarWindowsStrategy() {
		return new ERDownloaderGetaudarWindowsStrategy();
	}
	
	public IElectronicReportDownloaderStrategy getERDownloaderGetaudarLinuxStrategy() {
		return new ERDownloaderGetaudarLinuxStrategy();
	}


}
