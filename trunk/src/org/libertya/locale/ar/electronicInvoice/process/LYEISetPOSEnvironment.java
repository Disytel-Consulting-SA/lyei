package org.libertya.locale.ar.electronicInvoice.process;

/**
 * Especifica el ambiente de ejecucion de todos los puntos de venta que pertenecen a la configuracion en la que el usuario se encuentra ubicado
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;

public class LYEISetPOSEnvironment extends SvrProcess {

	String newEnvironment = null;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("Environment")) {
				newEnvironment = (String)para[i].getParameter();
			}
		}

	}

	@Override
	protected String doIt() throws Exception {
		PreparedStatement ps = DB.prepareStatement("SELECT * FROM C_LYEIElectronicPOSConfig WHERE C_LYEIElectronicInvoiceConfig_ID = " + getRecord_ID(), get_TrxName());
		ResultSet rs = ps.executeQuery();
		int i=0;
		while (rs.next()) {
			i++;
			LP_C_LYEIElectronicPOSConfig aConfig = new LP_C_LYEIElectronicPOSConfig(getCtx(), rs, get_TrxName());
			aConfig.setCurrentEnvironment(newEnvironment);
			if (!aConfig.save())
				throw new Exception("Error actualizando ambiente para el punto de venta " + aConfig.getPOS() + ". Error: " + CLogger.retrieveErrorAsString());
		}
		
		return i + " puntos de venta actualizados correctamente";
	}

}
