package org.libertya.locale.ar.electronicInvoice.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MCurrency;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.util.Env;

public class LYEICommons {

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
        Date date = null;
        // El campo FchVtoPago debe ser posterior o igual a la fecha de emision (CbteFch) o fecha de presentacion (fecha actual), la que sea posterior.
        if (inv.isVoidProcess()) { 
        	date = inv.getFechaVto();
        	Date currDate = new Date();
        	if (date == null || currDate.compareTo(date) > 0) { 
        		date = currDate;
        	}
        // Si no es una anulacion...
        } else {  
        	date = new Date(inv.getFechaVto().getTime());
        } 
        return date;
	}
	
	/** Fecha de vencimiento de la factura */
	public static String getFechaVtoString(MInvoice inv) throws Exception {
        return dateToString(getFechaVtoDate(inv));
	}

	/** Tipo de documento segun el cliente es CF o no */
	public static int getDocTipo(MBPartner partner) {
		return partner.isConsumidorFinal() ? 
					LYEIConstants.WSFE_BPARTNER_ES_CONSUMIDOR_FINAL : 
					LYEIConstants.WSFE_BPARTNER_NO_ES_CONSUMIDOR_FINAL;
	}
	
	/** CUIT del cliente */
	public static Long getDocNro(MBPartner partner, MInvoice inv) {
		if (partner.isConsumidorFinal()) 
			return 1L;
		return Long.parseLong(inv.getCUIT().replace("-", "").replace(" ", ""));
	}

	
	/** Neto de la factura */
	public static double getImpNeto(double impIva, MDocType docType, MInvoice inv) {
		// Para facturas C no se discrimina IVA. Se considera neto+iva-tributos como neto
		if (X_C_DocType.DOCSUBTYPECAE_FacturasC.equals(docType.getdocsubtypecae())) {
			return inv.getNetAmount().add(new BigDecimal(impIva)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return inv.getNetAmount().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/** Moneda de la factura */
	public static String getMonId(MCurrency currency) throws Exception {
		if (currency.getWSFECode()==null || currency.getWSFECode().length()==0)
			throw new Exception("No se ha configurado el codigo de la moneda");
		return currency.getWSFECode();
	}
	
	/** Cotizacion de la moneda */
	public static double getMonCotiz(MInvoice inv, Properties ctx) {
		BigDecimal cotizacion = 
				MCurrency.currencyConvert(	Env.ONE,
											inv.getC_Currency_ID(), 
											Env.getContextAsInt(ctx, "$C_Currency_ID"), 
											inv.getDateAcct(), 
											0,
											ctx);
		return cotizacion.doubleValue();
	}
	
	/** Concepto de la FE segun existan productos y/o servicios en la misma */
	public static int getConcepto() {
		// TODO: VERIFICAR CORRECTITUD DE USO DE PRODUCTOS
		return LYEIConstants.WSFE_CONCEPTO_PRODUCTOS;
	}
	
	/** Total de la factura */
	public static double getImpTotal(MInvoice inv) {
		return inv.getGrandTotal().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Obtine el taxBaseAmt (segun WsfeV1) */
	public static BigDecimal getTaxBaseAmt(BigDecimal taxBaseAmt, BigDecimal grandTotal, BigDecimal taxesAmt) {
		if ((Math.abs((grandTotal.subtract(taxesAmt).subtract(taxBaseAmt)).doubleValue()) >= 0.01) && (Math.abs((grandTotal.subtract(taxesAmt).subtract(taxBaseAmt)).doubleValue()) <= 0.03)){
			return (grandTotal.subtract(taxesAmt));
		}
		return taxBaseAmt;
	}
	
	/** Importe neto no gravado */
	public static double getImpTotConc() {
		// TODO: Pending
		return 0.0;
	}
	
	/** Importe exento */ 
	public static double getImpOpEx() {
		// TODO: Pending
		return 0.0;
	}
	
	
}
