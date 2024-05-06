package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.Util;

import sr.puc.server.ws.soap.a5.WSCI;

public class WSCIConsultarCUITProcess extends SvrProcess {

	/** CUIT de la compañía */
	Long cuit = null;	

	/** CUIT del tercero a consultar */
	private Long CUIT = 0L; // para probar 30506730038


	public WSCIConsultarCUITProcess() {}
		
	public WSCIConsultarCUITProcess(Properties ctx, Integer clientID, Integer orgID, String trxName) {
	}
		
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();

			if (para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("CUIT")) {
				try {
					setCUIT(((BigDecimal)para[i].getParameter()).longValue());
				}catch(Exception ex) {
					String cuit = (String)para[i].getParameter();
					setCUIT(new BigDecimal(cuit).longValue());
				}
			}
		}
	}
	
	
	@Override
	protected String doIt() throws Exception {

		if(getCUIT()==0L)
			throw new Exception("El cliente NO tiene registrado el numero de identificacion!");
		
		
		WSCI w = new WSCI();
		// Consulta de CUIT
		HashMap<String, String> resp = w.consultarCUIT(getCUIT());
		for (Map.Entry<String, String> entry : resp.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    this.addLog(0, null, null, entry.getKey() + " " + entry.getValue());
		}
		
		return "Ok Cuit consultado: " + getCUIT();
	}


	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cuit) {
		this.CUIT = cuit;
	}

}
