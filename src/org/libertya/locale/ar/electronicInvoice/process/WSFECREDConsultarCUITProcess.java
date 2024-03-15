package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openXpertya.model.MBPartner;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.Env;

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
				if(para[i].getParameter()!=null && para[i].getParameter()!="")
					setCUIT((new BigDecimal(para[i].getParameter().toString()).longValue()));
			}
			else if (name.equalsIgnoreCase("Fecha")) {
				setFecha(((Date)para[i].getParameter()));
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		
		Valid();

		FECred fc = new FECred();
		HashMap<String, String> resp = fc.consultarCUIT(getCUIT(), getFecha());
		if(resp!=null) {
			
			for (Map.Entry<String, String> entry : resp.entrySet()) {
				System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
				this.addLog(0, null, null, entry.getKey() + " " + entry.getValue());
			}

			if(getCUIT()!=0L && getRecord_ID() > 0) {
				MBPartner bp = new MBPartner(Env.getCtx(), getRecord_ID(), get_TrxName());
				bp.set_Value("IsMiPyme", fc.isMiPyme());
				bp.set_Value("MiPymeUpdated", fc.getUpdated());
				bp.set_Value("MiPymeAmount", fc.getAmount());
				
				if(bp.save())
					System.out.println("Guardo data en el cliente CUIT:" + getCUIT());
			}
			
			return "MiPyme actualizado: " + getCUIT();

		}else
			return "Error al validar CUIT para miPyme";
		
	}
	
	private void Valid() throws Exception {
		
		if(getCUIT()==0L && getRecord_ID() > 0) {
			
			MBPartner bp = new MBPartner(Env.getCtx(), getRecord_ID(), get_TrxName());
			String cuit = bp.getTaxID();
			
			setCUIT((new BigDecimal(cuit)).longValue());
		}
			
		if(getCUIT()==0L)
			throw new Exception("Debe indicar el CUIT a consultar!");
		
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
