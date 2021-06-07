package org.libertya.locale.ar.electronicInvoice.process;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.DB;

public class LYEICAEAPendingDocumentsReport extends SvrProcess {
		     
	/** Compañía */
	protected int clientID = -1;
	/** Organizacion */
	protected int orgID = -1;
	/** Periodo */
	protected int periodo = -1;
	/** Orden */
	protected int orden = -1;
	/** Punto de venta */
	protected int ptoVta = -1;
	/** Ambiente (Homo/Prod) */ 
	protected String env = "H";
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
        for( int i = 0;i < para.length;i++ ) {
	        String name = para[ i ].getParameterName();
	        if (para[ i ].getParameter() == null) ;
	        else if( name.equalsIgnoreCase( "AD_Client_ID" ))
	        	clientID = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "AD_Org_ID" ))
	        	orgID = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "Periodo" ))
	        	periodo = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "Orden" ))
	        	orden = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "PtoVta" ))
	        	ptoVta = para[ i ].getParameterAsInt();	        
	        else if( name.equalsIgnoreCase( "Ambiente" ))
	        	env = (String)para[ i ].getParameter();	        
        }
	}

	@Override
	protected String doIt() throws Exception {
		
		// delete all rows older than a week
		DB.executeUpdate("DELETE FROM t_caea_pending_documents WHERE CREATED < ('now'::text)::timestamp(6) - interval '7 days'");
		// delete all rows in table with the given ad_pinstance_id
		DB.executeUpdate("DELETE FROM t_caea_pending_documents WHERE AD_PInstance_ID = " + getAD_PInstance_ID());
		
		// Recuperar registros
		PreparedStatement pstmt = DB.prepareStatement(
				" select * " +
				" from v_caea_pending_documents(" +
				clientID + ", " +
				(orgID>0 	? orgID		:"null") + "," + 
				(periodo>0	? periodo	:"null") + "," +
				(orden>0	? orden		:"null") + "," +
				(ptoVta>0	? ptoVta	:"null") + "," +
				"	'"+env+ "') ");
		ResultSet rs = pstmt.executeQuery();
		
		// Generar SQL resultante
		StringBuilder query = new StringBuilder("");
		int cant = 0;
		while (rs.next()) {
			cant++;
			query.append("INSERT INTO t_caea_pending_documents (" +
					"	created, " +
					"	ad_pinstance_id, " +
					"	ad_client_id, " +
					"	ad_org_id, " +
					"	ambiente, " +
					"	periodo, " +
					"	orden, " +
					"	c_doctype_id, " +
					"	c_invoice_id, " +
					"	documentno, " +
					"	ptovta, " +
					"	dateinvoiced, " +
					"	grandtotal, " +
					"	c_bpartner_id, " +
					"	lyeicaeainformed, " +
					"	lyeicaeainformeddetail) " +
					" VALUES ( ")
					.append("now(), ")
					.append(getAD_PInstance_ID()).append(", ")
					.append(rs.getInt("ad_client_id")).append(", ")
					.append(rs.getInt("ad_org_id")).append(", ")
					.append("'").append(rs.getString("ambiente")).append("', ")
					.append(rs.getInt("periodo")).append(", ")
					.append(rs.getInt("orden")).append(", ")
					.append(rs.getInt("c_doctype_id")).append(", ")
					.append(rs.getInt("c_invoice_id")).append(", ")
					.append("'").append(rs.getString("documentno")).append("', ")
					.append(rs.getInt("ptovta")).append(", ")
					.append("'").append(rs.getString("dateinvoiced")).append("', ")
					.append(rs.getBigDecimal("grandtotal")).append(", ")
					.append(rs.getInt("c_bpartner_id")).append(", ")
					.append("'").append(rs.getString("lyeicaeainformed")).append("', ")
					.append(rs.getString("lyeicaeainformeddetail")==null ? "null" : ("'"+rs.getString("lyeicaeainformeddetail").replace("'", "")+"'") )
					.append("); ");
		}
		
		// Impactar en tabla temporal
		if (cant>0)
			DB.executeUpdate(query.toString());
		return "";
	}

}
