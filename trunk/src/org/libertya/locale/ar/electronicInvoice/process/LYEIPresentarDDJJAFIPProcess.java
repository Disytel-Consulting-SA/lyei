package org.libertya.locale.ar.electronicInvoice.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.libertya.locale.ar.electronicInvoice.ddjjafip.electronic_report.ElectronicReportHandler;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;

public class LYEIPresentarDDJJAFIPProcess extends SvrProcess {
	//rango de fechas para pedir los reportes electrónicos
	String fechaInicio;
	String fechaFin;
	String pos;
	
	public LYEIPresentarDDJJAFIPProcess() {
	}

	@Override
	protected void prepare() {
		//obtener parametros de fecha
		ProcessInfoParameter[] params = getParameter();
		for( int i = 0;i < params.length;i++ ) {
			String param = params[ i ].getParameterName();
			if ( param.equalsIgnoreCase( "fechaInicio" )) {
				this.fechaInicio = params[ i ].getParameter().toString();
			}else
			if ( param.equalsIgnoreCase( "fechaFin" )) {
				this.fechaFin = params[ i ].getParameter().toString();
			}else
			if( param.equalsIgnoreCase( "pos" )) {
				this.pos = params[ i ].getParameter().toString();
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		validarFechas();
		
		return new ElectronicReportHandler(fechaInicio, fechaFin, pos).execute();
	}
	
	public void validarFechas() throws Exception {
		//las fechas no deben ser null
		if(this.fechaInicio == null || this.fechaFin == null) {
			throw new Exception("[ERR] Deben especificarse fechas válidas para la ejecución del proceso");
		}
		
		//Dar formato a las fechas
		this.fechaInicio = getFormattedDate(this.fechaInicio);
		this.fechaFin = getFormattedDate(this.fechaFin);
		
		//la fecha de inicio debe ser menor o igual a la fecha de fin
		if(compararFechas(fechaInicio, fechaFin) == -1) {
			throw new Exception("[ERR] Fechas inválidas");
		}
		
		//la fecha de fin debe ser menor o igual a HOY
		if(!fechaValida(fechaFin)) {
			throw new Exception("[ERR] Fechas inválidas");
		}
		
	}

	//metodos para validación de fechas
	
	//transforma una date a un formato específico para invocarlo como parametro en terminal
		//formato AAMMDD (Año en dos dígitos, mes, día).
		//ej: 2022-09-08 00:00:00.0 se transforma en 220908
		public String getFormattedDate(String date) {
			String formattedDate = date.split(" ")[0]; //2022-09-08
			String[] aux = formattedDate.split("-"); //[2022] [09] [08]
			aux[0] = aux[0].substring(2, 4);
			formattedDate = aux[0] + aux[1] + aux[2]; //220908
			
			return formattedDate;
		}
		
		/*
		 * Compara dos fechas en el formato establecido
		 * devuelve -1 si la fechaInicio es mayor
		 * devuelve 1 si la fechaFin es mayor
		 * devuelve 0 si las fechas son iguales
		 */
		public int compararFechas(String fechaInicio, String fechaFin) {
			
			int anioInicio = Integer.valueOf(fechaInicio.substring(0, 2));
			int anioFin = Integer.valueOf(fechaFin.substring(0, 2));
			if(anioInicio < anioFin) {
				return 1;
			}else if(anioFin < anioInicio) {
				return -1;
			}
			
			int mesInicio = Integer.valueOf(fechaInicio.substring(2, 4));
			int mesFin = Integer.valueOf(fechaFin.substring(2, 4));
			if(mesInicio < mesFin) {
				return 1;
			}else if(mesFin < mesInicio) {
				return -1;
			}
			
			int diaInicio = Integer.valueOf(fechaInicio.substring(4, 6));
			int diaFin = Integer.valueOf(fechaFin.substring(4, 6));
			if(diaInicio < diaFin) {
				return 1;
			}else if(diaFin < diaInicio) {
				return -1;
			}
			
			return 0;
		}
		
		/*
		 * devuelve true si la fecha especificada es menor o igual a HOY
		 */
		public boolean fechaValida(String fecha) {
			SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");  
		    Date date = new Date();  
		    String[] aux = formatter.format(date).split("/");
		    String fechaHoy = aux[0] + aux[1] + aux[2];
			
		    if(compararFechas(fecha, fechaHoy) == -1) {
		    	return false;
		    }

			return true;
		}

}
