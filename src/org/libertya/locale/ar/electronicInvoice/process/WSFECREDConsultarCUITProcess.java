package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openXpertya.model.MBPartner;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

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
				if(para[i].getParameter()!=null && !Util.isEmpty(para[i].getParameter().toString(), true)) {
					// setCUIT((new BigDecimal(para[i].getParameter().toString()).longValue()));
					
					try {
						setCUIT(((BigDecimal)para[i].getParameter()).longValue());
					}catch(Exception ex) {
						String cuit = (String)para[i].getParameter();
						setCUIT(new BigDecimal(cuit).longValue());
					}
					
				}
				
				
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
			
			int i = 0;
			
			/* El orden no se puede manejar, queda mas prolijo mostrarlo de manera ordenada...
			for (Map.Entry<String, String> entry : resp.entrySet()) {
				System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
				i++;
				this.addLog(i, null, null, entry.getKey() + ": " + entry.getValue());
			}
			*/
			
			this.addLog(++i, null, null, "CUIT: " + resp.get("CUIT"));
			this.addLog(++i, null, null, "Corresponde FC MiPyme: " + resp.get("Corresponde"));
			this.addLog(++i, null, null, "Monto Minimo: " + resp.get("Monto Minimo"));
			

			if(getCUIT()!=0L && getRecord_ID() > 0 && this.getTable_ID()==MBPartner.Table_ID) {
				
				MBPartner bp = new MBPartner(Env.getCtx(), getRecord_ID(), get_TrxName());
				bp.set_Value("IsMiPyme", fc.isMiPyme());
				bp.set_Value("MiPymeUpdated", fc.getUpdated());
				bp.set_Value("MiPymeAmount", fc.getAmount());
				
				if(bp.save())
					System.out.println("Guardo data en el cliente CUIT:" + getCUIT());
				else {
					String up = "UPDATE C_BPartner SET IsMiPyme='" + (fc.isMiPyme()?"Y":"N") + "', " +
							" MiPymeUpdated='" + fc.getUpdated() + "', " +
							" MiPymeAmount= " + fc.getAmount() + ", " +
							" Updated=now(), " +
							" UpdatedBy=" + Env.getAD_User_ID(getCtx()) + " " +
							" WHERE C_BPartner_ID=" + bp.getC_BPartner_ID();
					System.out.println("Se actualiza por BDD - cliente CUIT:" + up);
					int ups = DB.executeUpdate(up, get_TrxName());
					if(ups==-1)
						return "No pudo actualizar cliente CUIT:" + getCUIT();
				}
			}
			
			return "MiPyme actualizado: " + getCUIT();

		}else
			return "Error al validar CUIT para miPyme";
		
	}
	
	private void Valid() throws Exception {
		
		if(getCUIT()==0L && getRecord_ID() > 0) {
			
			MBPartner bp = new MBPartner(Env.getCtx(), getRecord_ID(), get_TrxName());
			String cuit = bp.getTaxID();
			if(Util.isEmpty(cuit, true))
				throw new Exception("El cliente NO tiene registrado el numero de identificacion!");
			
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
