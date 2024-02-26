package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import wsfecred.afip.gob.ar.FECredService.FECred;

public class WSFECREDConsultarCUITProcess extends SvrProcess {

	/** CUIT del tercero a consultar */
	private Long CUIT = 0L; // para probar 30506730038
	
	private Date fecha = new Date();

	public WSFECREDConsultarCUITProcess() {}
		
	public WSFECREDConsultarCUITProcess(Properties ctx, Integer clientID, Integer orgID, String trxName) {
	}
		
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();

			if (para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("CUIT")) {
				setCUIT(((BigDecimal)para[i].getParameter()).longValue());
			}
			else if (name.equalsIgnoreCase("Fecha")) {
				setFecha(((Date)para[i].getParameter()));
			}
		}
	}

	@Override
	protected String doIt() throws Exception {

		FECred fc = new FECred();
		HashMap<String, String> resp = fc.consultarCUIT(getCUIT(), getFecha());
		if(resp!=null) {
			for (Map.Entry<String, String> entry : resp.entrySet()) {
				System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
				this.addLog(0, null, null, entry.getKey() + " " + entry.getValue());
			}

			return "Ok Cuit consultado: " + getCUIT();

		}else
			return "Error al validar CUIT para miPyme";
		
	}
	
	private void setFecha(Date date) {
		fecha = date;
	}

	private Date getFecha() {
		return fecha;
	}

	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cuit) {
		this.CUIT = cuit;
	}

}
