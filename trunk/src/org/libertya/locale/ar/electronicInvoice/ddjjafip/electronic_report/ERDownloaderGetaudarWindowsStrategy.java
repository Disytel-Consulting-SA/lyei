package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

public class ERDownloaderGetaudarWindowsStrategy extends ERDownloaderGetaudarStrategy {

	public ERDownloaderGetaudarWindowsStrategy() {
	}

	@Override
	public boolean downloadER(String fechaInicio, String fechaFin) {
		return true;
	}

	@Override
	protected boolean isSpoolerStopped() {
		return false;
	}

	@Override
	protected boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin) {
		return true;
	}


}
