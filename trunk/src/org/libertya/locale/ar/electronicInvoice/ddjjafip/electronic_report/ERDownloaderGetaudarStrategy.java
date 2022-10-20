package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.util.ArrayList;

public abstract class ERDownloaderGetaudarStrategy implements IElectronicReportDownloaderStrategy{
	
	//En este atributo se setean los archivos que deben presentarse ante AFIP como ddjj una vez descargados
	ArrayList<String> archivosPresentacion = new ArrayList<String>();
	
	public ERDownloaderGetaudarStrategy() {
		
	}

	public ArrayList<String> getArchivosPresentacion() {
		return archivosPresentacion;
	}
	
	public void setArchivosPresentacion(ArrayList<String> archivosPresentacion) {
		this.archivosPresentacion = archivosPresentacion;
	}

	protected abstract boolean isSpoolerStopped();

	protected abstract boolean executeGetaudar(String baseDir, String fechaInicio, String fechaFin);
}
