package org.libertya.locale.ar.electronicInvoice.model;

import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.plugin.MPluginDocAction;
import org.openXpertya.plugin.MPluginStatus;
import org.openXpertya.plugin.MPluginStatusDocAction;
import org.openXpertya.plugin.MPluginStatusPO;
import org.openXpertya.process.DocAction;
import org.openXpertya.util.DB;

public class MInvoice extends MPluginDocAction {

	public MInvoice(PO po, Properties ctx, String trxName, String aPackage) {
		super(po, ctx, trxName, aPackage);
	}
	
	@Override
	public MPluginStatusDocAction preCompleteIt(DocAction document) {
		// Periodo desde y periodo hasta mandatorios?
		if (isPeriodRequired( (LP_C_Invoice)document )) {
			status_docAction.setContinueStatus(MPluginStatus.STATE_FALSE);
			status_docAction.setDocStatus(org.openXpertya.model.X_C_Invoice.DOCSTATUS_Invalid);
			status_docAction.setProcessMsg("Para facturas electronicas que incluyan articulos de tipo servicio se debe informar Periodo Hasta y Periodo Desde");
			return status_docAction;
		}
		status_docAction.setContinueStatus(MPluginStatusPO.STATE_TRUE_AND_CONTINUE);
		return status_docAction;
	}
	
	
	/** Valida si Periodo Desde y Periodo Hasta deben informarse a AFIP obligatoriamente en caso de contener servicios */
	protected boolean isPeriodRequired(LP_C_Invoice inv) {
		int concept = getInvoiceConcept(inv.getC_Invoice_ID());
		X_C_DocType dt = new X_C_DocType(m_ctx, inv.getC_DocTypeTarget_ID(), null);

		return	( dt.iselectronic() ) && 
				( LYEIConstants.WSFE_CONCEPTO_SERVICIOS == concept || LYEIConstants.WSFE_CONCEPTO_PRODUCTOS_Y_SERVICIOS == concept ) &&
				( inv.getLYEIPeriodFrom()==null || inv.getLYEIPeriodTo()==null ); 
	}
	
	
	/** Retorna el concepto a informar segun tabla de AFIP: 
	 * 1: Productos (PRODUCTTYPE_Item)
	 * 2: Servicios (PRODUCTTYPE_Service)
	 * 3: Productos y servicios */
	public static int getInvoiceConcept(int invoiceID) {
		// Para versiones posteriores a postgres 9.5, no debe existir en BDD el aggregate incorporado para versiones anteriores de postgres. 
		// En ese caso se debe ejecutar: drop aggregate libertya.array_agg(anyelement)
		return DB.getSQLValue(null,   
						"	select case " + 
						"		when foo.tipos = '{I}' then 1 " + 	// WSFE_CONCEPTO_PRODUCTOS
						"		when foo.tipos = '{S}' then 2 " + 	// WSFE_CONCEPTO_SERVICIOS
						"		when foo.tipos = '{I,S}' then 3 " + // WSFE_CONCEPTO_PRODUCTOS_Y_SERVICIOS
						"		else 1 " + 
						"	end " + 
						"	from ( " + 
						"		select array_agg(distinct producttype) as tipos " + 
						"		from c_invoiceline ci " + 
						"		inner join m_product p on ci.m_product_id = p.m_product_id " + 
						"		where c_invoice_id = " + invoiceID + 
						"		and producttype in ('I', 'S')" + 
						"	) as foo"
					);
	}

}
