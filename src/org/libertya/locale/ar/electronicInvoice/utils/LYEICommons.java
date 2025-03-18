package org.libertya.locale.ar.electronicInvoice.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_Invoice;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MCategoriaIva;
import org.openXpertya.model.MCurrency;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MPaymentTerm;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;

public class LYEICommons {

	public static int CONDICION_IVA_RECEPTOR_CONSFINAL = 5;
	
	/** Convierte una fecha a formato yyyyMMdd */
	public static String dateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}
	
	/** Codigo preestablecido de AFIP segun el tipo de documento. */
	public static int getCbteTipo(MDocType docType) throws Exception {
		int tipo = -1;
		try {
			tipo = Integer.parseInt(docType.getdocsubtypecae());
		} catch (Exception e) {
			throw new Exception ("Error al obtener el cbteTipo.  DocSubTypeCAE no especificado o incorrecto.");
		}
		return tipo;
	}
	
	/** Fecha de la factura */
	public static Date getCbteFchDate(MInvoice inv) {
        Date date = new Date(inv.getDateAcct().getTime());
        return date;
	}
	
	/** Fecha de la factura */
	public static String getCbteFchString(MInvoice inv) {
        return dateToString(getCbteFchDate(inv));
	}

	/** Fecha de vencimiento de la factura */
	public static Date getFechaVtoDate(MInvoice inv) throws Exception {
		
		// Si el concepto es 1, no lleva fecha de vencimiento.
		if(getConcepto(inv.getC_Invoice_ID()) == 1) {
			
			/**
			 * Verificar si es miPyme, en caso de que lo sea, informar fecha de vto de pago
			 * sin importar el concepto de la misma
			 * dREHER
			 */
			MDocType doct = new MDocType(Env.getCtx(), inv.getC_DocTypeTarget_ID(), null);
			if(!doct.isMiPyME() || (doct.isMiPyME() && doct.getsigno_issotrx().equals(MDocType.SIGNO_ISSOTRX__1)) )
				return null;
		}
		
		Date date = inv.getFechaVto();
		Date currDate = new Date();
		
		// La fecha de vencimiento no puede ser menor a la fecha actual
		if (date == null || currDate.compareTo(date) > 0) { 
			date = currDate;
		}			
		
        return date;
	}
	
	/** Fecha de vencimiento de la factura */
	public static String getFechaVtoString(MInvoice inv) throws Exception {
        return getFechaVtoDate(inv) != null ? dateToString(getFechaVtoDate(inv)) : null;
	}

	/** Tipo de documento segun el cliente es CF o no */
	public static int getDocTipo(MBPartner partner) {
		return partner.isConsumidorFinal() ? 
					LYEIConstants.WSFE_BPARTNER_ES_CONSUMIDOR_FINAL : 
					LYEIConstants.WSFE_BPARTNER_NO_ES_CONSUMIDOR_FINAL;
	}
	
	/** CUIT del cliente */
	public static Long getDocNro(MBPartner partner, MInvoice inv) {
		if (partner.isConsumidorFinal()) {
			// dREHER si en la factura se guardo el nro de identificacion tomarlo desde ahi, sino envia 1
			if(!Util.isEmpty(inv.getNroIdentificCliente(), true))
				return Long.parseLong(inv.getNroIdentificCliente().trim());
			else
				return 1L;
		}
		if (inv.getCUIT()==null) {
			throw new RuntimeException("La factura requiere el CUIT del cliente");
		}
		return Long.parseLong(inv.getCUIT().replace("-", "").replace(" ", ""));
	}

	/** Neto de la factura */
	public static BigDecimal getImpNeto(BigDecimal impIva, MDocType docType, MInvoice inv) throws Exception{
		return getImpNetoBigDecimal(impIva, docType, inv);
	}
	
	/** Neto de la factura */
	public static BigDecimal getImpNeto(double impIva, MDocType docType, MInvoice inv) throws Exception{
		return getImpNetoBigDecimal(new BigDecimal(impIva), docType, inv);
	}
	
	/** Neto de la factura */
	public static BigDecimal getImpNetoBigDecimal(BigDecimal impIva, MDocType docType, MInvoice inv) throws Exception{
		BigDecimal neto = DB.getSQLValueBD(null, 	" SELECT COALESCE(SUM(taxbaseamt), 0) " + 
													" FROM c_invoicetax it " + 
													" INNER JOIN c_tax t ON it.c_tax_id = t.c_tax_id " + 
													" INNER JOIN c_taxcategory tc ON tc.c_taxcategory_id = t.c_taxcategory_id " +
													" WHERE it.c_invoice_id = ? " +
														" AND t.istaxexempt = 'N' " + 
														" AND COALESCE(t.isnogravado,'N') = 'N' " +
														" AND COALESCE(t.ispercepcion, 'N') = 'N' " +
														" AND tc.ismanual = 'N'", inv.getC_Invoice_ID());
		
		// Para facturas C no se discrimina IVA. Se considera neto + iva - tributos como neto
		if (X_C_DocType.DOCSUBTYPECAE_FacturasC.equals(docType.getdocsubtypecae())) {
			return neto.add(impIva).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return neto;
	}

	/** Moneda de la factura */
	public static String getMonId(MCurrency currency) throws Exception {
		if (currency.getWSFECode()==null || currency.getWSFECode().length()==0)
			throw new Exception("No se ha configurado el codigo de la moneda");
		return currency.getWSFECode();
	}
	
	/** Cotizacion de la moneda */
	public static BigDecimal getMonCotiz(MInvoice inv, Properties ctx) {
		return getMonCotizBigDecimal(inv, ctx);
	}
	
	/** Cotizacion de la moneda */
	public static BigDecimal getMonCotizBigDecimal(MInvoice inv, Properties ctx) {
		BigDecimal cotizacion = 
				MCurrency.currencyConvert(	Env.ONE,
											inv.getC_Currency_ID(), 
											Env.getContextAsInt(ctx, "$C_Currency_ID"), 
											inv.getDateAcct(), 
											0,
											ctx);
		return cotizacion;
	}
	
	/** Concepto de la FE segun existan productos y/o servicios en la misma */
	public static int getConcepto(int invoiceID) {
		// Devuelve 1 si solo existen Items, 2 si solo existen servicios, 3 si existen ambos; o 1 por defecto en cualquier otro caso
		return org.libertya.locale.ar.electronicInvoice.model.MInvoice.getInvoiceConcept(invoiceID);
	}
	
	/** Periodo facturado del servicio: desde */
	public static String setFchServDesde(MInvoice inv) {
		// El campo es fecha/hora por posibles ampliaciones a futuro. por el momento solo se envía la fecha
		return inv.get_Value("LYEIPeriodFrom")==null ? (""+inv.getDateInvoiced()).substring(0, 10).replace("-", "") : (""+inv.get_Value("LYEIPeriodFrom")).substring(0, 10).replace("-", "");
	}
	
	/** Periodo facturado del servicio: hasta */
	public static String setFchServHasta(MInvoice inv) {
		// El campo es fecha/hora por posibles ampliaciones a futuro. por el momento solo se envía la fecha
		return inv.get_Value("LYEIPeriodTo")==null ? (""+inv.getDateInvoiced()).substring(0, 10).replace("-", "") : (""+inv.get_Value("LYEIPeriodTo")).substring(0, 10).replace("-", "");
	}

	/** Total de la factura */
	public static BigDecimal getImpTotal(MInvoice inv) {
		return getImpTotalBigDecimal(inv);
	}
	
	/** Total de la factura */
	public static BigDecimal getImpTotalBigDecimal(MInvoice inv) {
		return inv.getGrandTotal().setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	/** Importe neto no gravado */
	public static BigDecimal getImpTotConc(int invoiceID) throws Exception{
		return getImpTotConcBigDecimal(invoiceID);
	}
	
	/** Importe neto no gravado */
	public static BigDecimal getImpTotConcBigDecimal(int invoiceID) throws Exception{
		return 
				DB.getSQLValueBD(null, 	" SELECT COALESCE(SUM(taxbaseamt),0) " +
										" FROM c_invoicetax it " +
										" INNER JOIN c_tax t on it.c_tax_id = t.c_tax_id " +
										" WHERE t.isNoGravado = 'Y' " +
											" AND it.c_invoice_id = ?", invoiceID);  
	}

	/** Importe exento */ 
	public static BigDecimal getImpOpEx(int invoiceID) {
		return getImpOpExBigDecimal(invoiceID);
	}
	
	/** Importe exento */ 
	public static BigDecimal getImpOpExBigDecimal(int invoiceID) {
		return 
				DB.getSQLValueBD(null, 	" SELECT COALESCE(SUM(taxbaseamt),0) " +
										" FROM c_invoicetax it " +
										" INNER JOIN c_tax t on it.c_tax_id = t.c_tax_id " +
										" WHERE t.istaxexempt = 'Y' " +
											" AND it.c_invoice_id = ?", invoiceID);  
	}
	
	/** Retorna el array como un String */
	public static String stringFromArray(CodigoDescripcionType[] array) {
		// Ninguna entrada?
		if (array==null || array.length==0)
			return null;
		
		// Concatenarlas todas
		StringBuffer result = new StringBuffer(); 
		for (CodigoDescripcionType elem : array) {
			result.append(elem.getCodigo()).append(":").append(elem.getDescripcion()).append(". ");
		}
		return result.toString();
	}
	
	/**
	 * @return si la forma de pago es Efectivo, el valor de retorno es Contado. Caso
	 *         contrario, el nombre del esquema de vencimientos
	 */
	public static String getFormaPago(MInvoice inv) {
		return inv.getPaymentRule().equals(MInvoice.PAYMENTRULE_Cash) ? "Contado"
				: (new MPaymentTerm(inv.getCtx(), inv.getC_PaymentTerm_ID(), inv.get_TrxName()).getName());
	}

	/**
	 * Condicion de IVA del Receptor
	 * 
	 * Código	Descripción
		1	Responsable Inscripto
		2	Monotributista
		3	Sujeto Exento
		4	Consumidor Final
		5	Responsable No Inscripto
	 * 
	 * @param partner
	 * @return
	 * @author dREHER Feb 25
	 */
	public static int getCondIva(MBPartner partner) {
		int condIva = 0;
		
		if(partner.isConsumidorFinal())
			condIva = CONDICION_IVA_RECEPTOR_CONSFINAL;
		else {

			int cateIva = partner.getC_Categoria_Iva_ID();
			MCategoriaIva ci = new MCategoriaIva(Env.getCtx(), cateIva, partner.get_TrxName());
			int codConfig = 0;
			if(ci.get_Value("IVAReceptorID")!=null) {
				codConfig = (Integer)ci.get_Value("IVAReceptorID");
			}
			
			if(codConfig <=0) {
				if(ci.getCodigo() == 2 || ci.getCodigo() == 0 || ci.getCodigo() == 9) // Resp Incripto
					condIva = 1;
				else if(ci.getCodigo() == 4 || ci.getCodigo() == 15) // Exento / Iva No Alcanzado
					condIva = 4;
				else if(ci.getCodigo() ==  5 || ci.getCodigo() ==  10) // Monotributista
					condIva = 2;
				else if(ci.getCodigo() ==  3 || ci.getCodigo() ==  6 || ci.getCodigo() ==  8) // No responsable
					condIva = 6;
			}else
				condIva = codConfig;
		}

		// No categorizado, default CF
		if(condIva == 0)
			condIva = CONDICION_IVA_RECEPTOR_CONSFINAL;
		
		return condIva;
	}
	
	/**
	 * Nuevo parametro LYEIEX v 3.0
	 * @param inv
	 * @return S=Cancela en misma moneda, N=No cancela en misma moneda, default=N
	 * @author dREHER Mar 25
	 */
	public static String getCanMisMonExt(MInvoice inv) {
		String cancelaMismaMoneda = "N";
		if(inv.get_Value("IsCancelaMismaMoneda")!=null)
			if( ((String)inv.get_Value("IsCancelaMismaMoneda")).equals("Y"))
				cancelaMismaMoneda = "S";
		
		return cancelaMismaMoneda;
	}
}
