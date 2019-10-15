package org.libertya.locale.ar.electronicInvoice.model;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public class MLYEIElectronicInvoiceLog extends LP_C_LYEIElectronicInvoiceLog {

	static CLogger log = CLogger.get();
	
	public MLYEIElectronicInvoiceLog(Properties ctx,
			int C_LYEIElectronicInvoiceLog_ID, String trxName) {
		super(ctx, C_LYEIElectronicInvoiceLog_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MLYEIElectronicInvoiceLog(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
	/** Registra actividad en el log (console / DB) */
	public static void logActivity(Class<?> clazz, Level level, Integer invoiceID, Integer posConfigID, Integer genConfigID, String activity) {
		// Eliminacion entradas antiguas en el log.  TODO: Desharcode de 5 dias hacia preferencia de configuracion
		DB.executeUpdate("DELETE FROM C_LYEIElectronicInvoiceLog WHERE age(now(), created) > '5 days'");
		
		// Registracion de log
		StringBuffer msg = new StringBuffer();
		LP_C_LYEIElectronicInvoiceLog dbLog = new LP_C_LYEIElectronicInvoiceLog(Env.getCtx(), 0, null);
		
		// Si hay factura incluirla en el log
		if (invoiceID!=null) {
			msg.append(" [").append(invoiceID).append("] ");
			dbLog.setC_Invoice_ID(invoiceID);
		}
		
		// Configuracion de POS?
		if (posConfigID!=null)
			dbLog.setC_LYEIElectronicPOSConfig_ID(posConfigID);
		// Configuracion gral?
		if (genConfigID!=null)
			dbLog.setC_LYEIElectronicInvoiceConfig_ID(genConfigID);
		
		msg.append(activity);
		
		// Console Log
		log.log(level, msg.toString());
		// DB Log
		dbLog.setActivity(msg.toString());
		dbLog.save();
	}

}
