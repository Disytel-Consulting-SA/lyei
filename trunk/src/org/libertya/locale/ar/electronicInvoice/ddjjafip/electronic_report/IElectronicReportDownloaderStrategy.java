package org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report;

import java.util.ArrayList;

public interface IElectronicReportDownloaderStrategy {
	
	public boolean downloadER(String fechaInicio, String fechaFin, int lyeicom);
	
	ArrayList<String> getArchivosPresentacion();
	
	void setArchivosPresentacion(ArrayList<String> archivosPresentacion);
	
}
