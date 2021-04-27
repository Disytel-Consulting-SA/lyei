package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_Invoice;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEICommons;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFE;
import org.openXpertya.OpenXpertya;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MCurrency;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MInvoiceLine;
import org.openXpertya.model.MInvoiceTax;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MProduct;
import org.openXpertya.model.MTax;
import org.openXpertya.model.MUOM;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;
import org.openXpertya.process.ProcessInfoUtil;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType;
import ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEARequestType;
import ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.ItemType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceLocator;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub;
import ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType;
import ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType;

public class LYEICAEANotifyDocumentProcess extends SvrProcess {

	/** Compañía */
	protected int clientID = -1;
	/** Organización */
	protected int orgID = -1;
	/** Factura a notificar */
	protected int invID = -1;
	/** PtoVta a notificar */
	protected int pos = -1;
	/** CAEA a notificar */
	protected String caea = null;
	
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	
	/** Detalle de la ejecucion */
	protected StringBuffer result = new StringBuffer();
	
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
	        else if( name.equalsIgnoreCase( "C_Invoice_ID" ))
	        	invID = para[ i ].getParameterAsInt();
	        else if( name.equalsIgnoreCase( "POS" ))
	        	pos = para[ i ].getParameterAsInt(); 
	        else if( name.equalsIgnoreCase( "CAEA" ))
	        	caea = (String)para[ i ].getParameter();	        
        }
	}

	@Override
	protected String doIt() throws Exception {
		int ok = 0, ko = 0;
		PreparedStatement pstmt = DB.prepareStatement(getDocumentsQuery(), null);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			LP_C_Invoice anInvoice = new LP_C_Invoice(getCtx(), rs, null);
			result.append(" Informando ").append(anInvoice.getDocumentNo()).append("... ");
			try {
				String status = notifyInvoice(anInvoice);	
				result.append(status).append(". \n");
				ok++;
			} catch (Exception e) {
				result.append(e.getMessage());
				ko++;				
			}
		}
		return  " Finalizado. \n " +
				" \n" +
				result.toString() +
				" \n " +
				" Total informadas OK:" + ok + ", total KO:" + ko;
	}

	/** Recupera los documentos a informar */
	protected String getDocumentsQuery() {
		return 	" SELECT * " +
				" FROM C_Invoice i " +
				" WHERE AD_Client_ID = " + clientID +
				" AND lyeicaeainformed IN ('P', 'E') " +
				(orgID > 0 ? "AND AD_Org_ID 	= " + orgID : "") +
				(invID > 0 ? "AND C_Invoice_ID 	= " + invID : "") +
				(pos   > 0 ? "AND puntodeventa 	= " + pos : "") +
				(caea!=null? "AND cae 			= '" + caea : "'");			
	}
	
	/** Efectiviza la notificacion a AFIP 
	 * @return el estado de la notificacion, que puede ser Aprobado, Observado o Rechazado
	 * @throws excepcion ante algun error de configuración, comunicación, etc.
	 * */
	protected String notifyInvoice(LP_C_Invoice inv) throws Exception {
		try {
			// Tipo de documento
			MDocType docType = new MDocType(getCtx(), inv.getC_DocTypeTarget_ID(), null);
			// EC 
			MBPartner partner = new MBPartner(getCtx(), inv.getC_BPartner_ID(), null);
			// Moneda de la factura
			MCurrency currency = new MCurrency(getCtx(), inv.getC_Currency_ID(), null);
			
			// Obtener la configuracion de FE segun la factura
			posConfig = MLYEIElectronicPOSConfig.get(inv.getPuntoDeVenta(), inv.getAD_Org_ID(), inv.getCtx(), null);
			
			// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
			if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()==0) {
				throw new Exception("Configuracion de punto de venta electronico nulo o no inicializado correctamente");		
			}
			genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
	
			// Pedir WSAA segun la factura
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, Env.getCtx(), posConfig.getCurrentEnvironment());
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// Auth
			AuthRequestType auth = new AuthRequestType();
			auth.setCuitRepresentada(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
			auth.setSign(sign);
			auth.setToken(token);
	
			// Cargar la info
			ComprobanteType comp = new ComprobanteType();
	
			/* Tipo de comprobante. Para consultar los posibles valores ver método: consultarTiposComprobante */
			comp.setCodigoTipoComprobante((short)LYEICommons.getCbteTipo(docType));
			
			/* Número del punto de venta por el cual se emite el comprobante */
			comp.setNumeroPuntoVenta(inv.getPuntoDeVenta());
			
			/* Número del comprobante */
			comp.setNumeroComprobante(inv.getNumeroComprobante());
			
			/* Fecha de emisión del comprobante */
			comp.setFechaEmision(LYEICommons.getCbteFchDate(inv));
			
			/* Indica el tipo del código de autorización. Ej. E: CAE (Código de Autorización Electrónico) A: CAEA (Código de Autorización Electrónico Anticipado) */
			comp.setCodigoTipoAutorizacion((!Util.isEmpty(inv.getLYEICAEAInformed()) ? new CodigoTipoAutorizacionSimpleType("A") : new CodigoTipoAutorizacionSimpleType("C")));
			
			/* Código de autorización (Código de Autorización Electrónico o Código de Autorización Electrónico Anticipado, según lo indique el campo codigoTipoAutorizacion) */
			comp.setCodigoAutorizacion(Long.parseLong(inv.getcae()));
			
			/* Fecha de vencimiento del código de autorización */
			comp.setFechaVencimiento(LYEICommons.getFechaVtoDate(inv));
			
			/* Código de documento del receptor del comprobante. Los posibles valores pueden ser consultados en el método consultarTiposDocumento */
			comp.setCodigoTipoDocumento((short)LYEICommons.getDocTipo(partner));
			
			/* Número de documento del receptor del comprobante */
			comp.setNumeroDocumento(LYEICommons.getDocNro(partner, inv));
			
			/* Importe total del comprobante */
			comp.setImporteTotal(new BigDecimal(LYEICommons.getImpTotal(inv)));
			
			/* Código de la moneda en que se emite el comprobante. */
			comp.setCodigoMoneda(LYEICommons.getMonId(currency));
			
			/* Tipo de cambio Total de dígitos 10 (4 enteros y 6 decimales) Mayor a cero. Máximo permitido: 9999.999999 */
			comp.setCotizacionMoneda(new BigDecimal(LYEICommons.getMonCotiz(inv, getCtx())));
			
			/* Concepto incluido en el comprobante. Valores permitidos: 1: Productos 2: Servicios 3: Productos y Servicios */
			comp.setCodigoConcepto((short)LYEICommons.getConcepto());
			
			/* Array. Detalle de los ítems que componen el comprobante. */
			comp.setArrayItems(getArrayItems(inv));
			
			/* Array. Detalle de las Alícuotas de IVA e importes de IVA liquidados en el comprobante */
			SubtotalIVAType[] iva = getArraySubtotalesIVA(inv);
			double impIva = getImpIVA(iva);
			comp.setArraySubtotalesIVA(iva);
			
			/* Array. Detalle de los tributos alistados en el comprobante. */
			OtroTributoType[] otrosTrib = getArrayOtrosTributos(inv);
			double impOtrosTrib = getImpOtrosTrib(otrosTrib);		
			comp.setArrayOtrosTributos(otrosTrib);
					
			/* Importe neto total de conceptos gravados */
			comp.setImporteGravado(new BigDecimal(LYEICommons.getImpNeto(impIva, docType, inv)));
			
			/* Importe total de conceptos no gravados. */
			comp.setImporteNoGravado(new BigDecimal(LYEICommons.getImpTotConc()));
			
			/* Importe total de conceptos exentos */
			comp.setImporteExento(new BigDecimal(LYEICommons.getImpOpEx()));
			
			/* Importe subtotal del comprobante */
			comp.setImporteSubtotal(getImporteSubtotal(impIva, docType, inv));
			
			/* Importe total de Otros Tributos */
			comp.setImporteOtrosTributos(new BigDecimal(impOtrosTrib));
			
			/* Array. Detalle de los datos adicionales incluidos en el comprobante con sus respectivos valores */
			//comp.setArrayDatosAdicionales(getArrayDatosAdicionales());  No es obligatorio
			
			/* Array. Detalle de los compradores incluidos en el comprobante para respaldar las operaciones de venta de bienes muebles registrables a un conjunto de adquirentes */
			//comp.setArrayCompradores(getArrayCompradores());		No es obligatorio
			
			/* Fecha desde del servicio */
			//comp.setFechaServicioDesde(getFechaServicioDesde());  No es obligatorio
			
			/* Fecha hasta del servicio */
			//comp.setFechaServicioHasta(getFechaServicioHasta());  No es obligatorio
			
			/* Fecha de vencimiento para el pago. */
			// comp.setFechaVencimientoPago(getFechaVencimientoPago()); No es obligatorio 
			
			/* Fecha/Hora de generación, formato AAAA-MM-DDTHH:MM:SS Campo exclusivo para comprobantes emitidos con puntos de venta CAEA por Contingencia */
			//comp.setFechaHoraGen(getFechaHoraGen());				No es obligatorio
		
			/* Observaciones comerciales (Importante: NO es necesario completar con espacios) */
			//comp.setObservaciones(getObservaciones()); 			No es obligatorio
			
			/* Array. Detalle de los comprobantes asociados al comprobante que se solicita autorizar. */
			ComprobanteAsociadoType[] asocs = getArrayComprobantesAsociados(inv, genConfig);
			if (asocs!=null) {
				comp.setArrayComprobantesAsociados(asocs);
			}
			
			/* Detalle del periodo de los comprobantes asociados al comprobante que se solicita autorizar */
			//	comp.setPeriodoComprobantesAsociados()  TODO: Pending
			
			// Conectar con AFIP
			InformarComprobanteCAEARequestType iccr = new InformarComprobanteCAEARequestType();
			iccr.setAuthRequest(auth);
			iccr.setComprobanteCAEARequest(comp);
			
			// Efectivizar la invocacion
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment());		
			MTXCAServiceLocator locator = new MTXCAServiceLocator();
			locator.setMTXCAServiceHttpSoap11EndpointEndpointAddress(endPoint);
			MTXCAServicePortType caeaService = locator.getMTXCAServiceHttpSoap11Endpoint();
			((MTXCAServiceSoap11BindingStub)caeaService).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment()));
			
			// Invocacion a la operacion
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getCAEANotifyDocumentLog(inv, endPoint));
			InformarComprobanteCAEAResponseType response = caeaService.informarComprobanteCAEA(iccr);
			
			/* === Procesar la respuesta === */
			// Hubo respuesta?
			if (response==null) {
				throw new Exception("Sin respuesta por parte de AFIP");
			}
	
			// Pending de adaptar MTXCAServiceSoap11BindingStub para dar soporte a XMLRequest/Response. Ver revision r10 de LYEI
			// String requestXML = ((MTXCAServiceSoap11BindingStub)caeaService).getCallRequestXML();
			// String responseXML = ((MTXCAServiceSoap11BindingStub)caeaService).getCallResponseXML();	
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getCAEANotifyDocumentResponseLog(inv, response));
			
			// Fue rechazado?			 
			if (LP_C_Invoice.LYEICAEAINFORMED_Rechazado.equals(response.getResultado().getValue())) {
				// Recuperar nomina de erorres a guarda en la factura
				String errors = stringFromArray(response.getArrayErrores());
				inv.setLYEICAEAInformed(LP_C_Invoice.LYEICAEAINFORMED_Rechazado);
				inv.setLYEICAEAInformedDetail(errors);
				inv.save();
				return ("RECHAZADO: " + errors);
			}
			
			// Fue Observado?			
			if (LP_C_Invoice.LYEICAEAINFORMED_Observado.equals(response.getResultado().getValue())) {
				String obs = stringFromArray(response.getArrayObservaciones());
				inv.setLYEICAEAInformed(LP_C_Invoice.LYEICAEAINFORMED_Observado);
				inv.setLYEICAEAInformedDetail(obs);
				inv.save();
				return ("OBSERVADO: " + obs);
			} 
			
			// Fue Aprobado
			if (LP_C_Invoice.LYEICAEAINFORMED_Aprobado.equals(response.getResultado().getValue())) {
				inv.setLYEICAEAInformed(LP_C_Invoice.LYEICAEAINFORMED_Aprobado);
				inv.save();
				return ("APROBADO");
			}
			
			// No es A, O o R?
			throw new Exception ("Respuesta inesperada por parte de AFIP, resultado: " + response.getResultado().getValue());
		}
		catch (Exception e) {
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getCAEANotifyDocumentErrorLog(inv, e));
			throw e;
		}
	}
		
	/** Impuestos */
	protected SubtotalIVAType[] getArraySubtotalesIVA(LP_C_Invoice inv) {
		ArrayList<SubtotalIVAType> alicsIva = new ArrayList<SubtotalIVAType>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(inv.getCtx(), invoiceTax.getC_Tax_ID(), inv.get_TrxName());
			// Las percepciones van aparte 
			if (tax.isPercepcion())
				continue;
			// Crear nueva entradda
			SubtotalIVAType alicIva = new SubtotalIVAType();
			alicIva.setCodigo((short)tax.getWSFECode());
			alicIva.setImporte(invoiceTax.getTaxAmt().setScale(2, BigDecimal.ROUND_HALF_UP));
			alicsIva.add(alicIva);
		}
		return alicsIva.toArray(new SubtotalIVAType[alicsIva.size()]);
	}
	
	
	/** Percepciones */
	protected OtroTributoType[] getArrayOtrosTributos(LP_C_Invoice inv) {
		ArrayList<OtroTributoType> tributos = new ArrayList<OtroTributoType>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(inv.getCtx(), invoiceTax.getC_Tax_ID(), inv.get_TrxName());
			// Solo las percepciones deben contemplarse 
			if (!tax.isPercepcion())
				continue;
			// Crear nueva entrada
			OtroTributoType tributo = new OtroTributoType();
			tributo.setCodigo((short)tax.getWSFECode());
			tributo.setBaseImponible(LYEICommons.getTaxBaseAmt(invoiceTax.getTaxBaseAmt(), inv.getGrandTotal(), inv.getTaxesAmt()));
			tributo.setImporte(invoiceTax.getTaxAmt().setScale(2, BigDecimal.ROUND_HALF_UP));
			tributo.setDescripcion(tax.getName());
			tributos.add(tributo);
		}
		return tributos.toArray(new OtroTributoType[tributos.size()]);
	}
	
	
	/** Total impuestos */
	protected double getImpIVA(SubtotalIVAType[] alicsIva) {
		BigDecimal total = BigDecimal.ZERO;
		for (SubtotalIVAType alicIva : alicsIva)
			total = total.add(alicIva.getImporte());
		return total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Total otros tributos */
	protected double getImpOtrosTrib(OtroTributoType[] alicsOT) {
		BigDecimal total = BigDecimal.ZERO;
		for (OtroTributoType otroTrib : alicsOT)
			total = total.add(otroTrib.getImporte());
		return total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/** Importe gravado + no gravado + exento */
	protected BigDecimal getImporteSubtotal(double impIva, MDocType docType, MInvoice inv) {
		return new BigDecimal (LYEICommons.getImpNeto(impIva, docType, inv) + LYEICommons.getImpTotConc() + LYEICommons.getImpOpEx());
	}
	
	/** Items de la factura */
	protected ItemType[] getArrayItems(LP_C_Invoice inv) {
		
		ArrayList<ItemType> items = new ArrayList<ItemType>();
		
		for (MInvoiceLine line : inv.getLines()) {
			MProduct aProduct = new MProduct(inv.getCtx(), line.getM_Product_ID(), inv.get_TrxName());
			MTax aTax = new MTax(inv.getCtx(), line.getC_Tax_ID(), inv.get_TrxName());
			MUOM aUOM = new MUOM(inv.getCtx(), line.getC_UOM_ID(), inv.get_TrxName());
			
			// Nueva entrada
			ItemType item = new ItemType();
			
			/* Cantidad */
			item.setCantidad(line.getQtyInvoiced());
			
			/* Código interno asignado por la empresa (Importante: NO es necesario completar con espacios) */
			item.setCodigo(aProduct.getValue());
			
			/* Codigo de IVA. Para obtener los posibles valores consultar método consultarCondicionesIVA 
			   1: No gravado, 2: Exento, 3: 0%, 4: 10,5%, 5: 21%, 6: 27% */
			item.setCodigoCondicionIVA((short)aTax.getWSFECode());
			
			/* Unidad de medida. Consultar método consultarUnidadesMedida 
			   0: " ", 1: Kilogramos, 2: metros, etc... */
			item.setCodigoUnidadMedida(Short.parseShort(aUOM.getUOMCodeFE()));
			
			/* Descripción del Producto (Importante: NO es necesario completar con espacios) */
			item.setDescripcion(aProduct.getDescription());
			
			/* Importe Descuento o Bonificación*/
			// item.setImporteBonificacion(BigDecimal.ZERO);	// No es obligatorio
			
			/* Importe total del ítem */
			item.setImporteItem(line.getLineNetAmt().add(line.getTaxAmt()));
			
			/* Importe IVA según codigoCondicionIVA indicado */
			item.setImporteIVA(line.getTaxAmt());
			
			/* Precio Unitario. Para comprobantes clase A no debe incluir el IVA, en cambio para los clase B si debe incluir IVA. */
			if ("B".equals(inv.getLetra())) {
				item.setPrecioUnitario(line.getPriceEntered());
			} else {
				item.setPrecioUnitario(line.getPriceEnteredNet());
			}

			/* Unidad de Referencia del código Producto/Servicio. Cuando la comercialización de los productos se realice en presentaciones distintas a la unidad de consumo
			 *	minorista o presentación al consumidor final, a la que hace referencia la codificación del producto, se deberán indicar las cantidades de unidades de consumo 
			 *	minoristas contenidas en la presentación que se comercializa. En caso que el producto ya se encuentre individualizado en su unidad de consumo minorista, 
			 *	la unidad de referencia deberá ser igual a UNO (1) */
			// item.setUnidadesMtx(unidadesMtx);		No es obligatorio
			
			/* Código de Producto/Servicio.  Deberán corresponder a la estructura provista por la ASOCIACION ARGENTINA DE CODIFICACION DE PRODUCTOS COMERCIALES — CODIGO—, 
			 * códigos GTIN 13, GTIN 12 y GTIN 8, correspondientes a la unidad de consumo minorista o presentación al consumidor final */
			// item.setCodigoMtx(codigoMtx);				No es obligatorio
			
			// Incorporar item a la nomina de items
			items.add(item);
		}
		return items.toArray(new ItemType[items.size()]);
	}
	
	/** Comprobante asociado al documento */
	protected ComprobanteAsociadoType[] getArrayComprobantesAsociados(LP_C_Invoice inv, MLYEIElectronicInvoiceConfig genConfig) {
		ComprobanteAsociadoType[] retValue = null;
		int cant=0;
		
		ArrayList<ComprobanteAsociadoType> asociados = new ArrayList<ComprobanteAsociadoType>();
		if (inv.getC_Invoice_Orig_ID()>0) {
			MInvoice origInv = new MInvoice(inv.getCtx(), inv.getC_Invoice_Orig_ID(), inv.get_TrxName());
			MDocType origInvDT = new MDocType(inv.getCtx(), origInv.getC_DocTypeTarget_ID(), inv.get_TrxName());
			
			int tipo = Integer.parseInt(origInvDT.getdocsubtypecae());
	        Date date = new Date(origInv.getDateAcct().getTime());
			
	        ComprobanteAsociadoType asoc = new ComprobanteAsociadoType();
			asoc.setCodigoTipoComprobante((short)tipo);
	        asoc.setCuit(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
	        asoc.setFechaEmision(date);
	        asoc.setNumeroComprobante(origInv.getNumeroComprobante());
	        asoc.setNumeroPuntoVenta(origInv.getPuntoDeVenta());
			cant++;
			asociados.add(asoc);
		}
		
		if (cant>0) {
			retValue = new ComprobanteAsociadoType[cant];
			asociados.toArray(retValue);
		}
		
		return retValue;		
	}
	
	/** Retorna el array como un String */
	protected String stringFromArray(CodigoDescripcionType[] array) {
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
	
	/** Log actividad de notificacion de CAEA */
	protected String getCAEANotifyDocumentLog(LP_C_Invoice inv, String endPoint) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Iniciando CAEA Informar para factura ")
				.append(inv.getDocumentNo()).append(" en ")
				.append(endPoint);
		return retValue.toString();
	}
	
	/** Respuesta en notificacion CAEA */
	protected String getCAEANotifyDocumentResponseLog(LP_C_Invoice inv, InformarComprobanteCAEAResponseType response) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Respuesta CAEA Informar para factura ")
				.append(inv.getDocumentNo()).append(": ")
				.append(response.getResultado().getValue());
		return retValue.toString();
	}
	
	/** Error en notificacion CAEA */
	protected String getCAEANotifyDocumentErrorLog(LP_C_Invoice inv, Exception e) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Error CAEA Informar para factura ")
				.append(inv.getDocumentNo()).append(": ")
				.append(e.toString());
		return retValue.toString();
	}
		

	
	// ------------------------ INVOCACION DESDE TERMINAL -------------------------

	/** UID del proceso sincronizador */
	public static final String CAEA_NOTIFY_DOCUMENT_PROCESS_UID	= 	""; // TODO: PENDING;  TODO: Crear el proceso
	
	/** Parametro ayuda */
	static final String PARAM_HELP			 			=	"-help";
	/** Parametro compañía */
	static final String PARAM_CLIENT					=	"-client";
	/** Parametro compañía */
	static final String PARAM_ORG						=	"-org";
	/** Parametro Notificar factura en particular */
	static final String PARAM_INV						=	"-inv";
	/** Parametro Notificar PtoVta en particular */
	static final String PARAM_POS						=	"-pos";
	/** Parametro Notificar CAEA en particular */
	static final String PARAM_CAEA						=	"-caea";
	
	
	public static void main(String[] args) {

		int clientID = -1;
		int orgID = -1;
		Integer invoiceID = -1;
		Integer pos = -1;
		String caea = null;
		
		for (String arg : args) {
			if (arg.toLowerCase().startsWith(PARAM_HELP)) {
				showHelp(getHelpMessage());
			} else if (arg.toLowerCase().startsWith(PARAM_CLIENT)) {
				clientID = Integer.parseInt(arg.substring(PARAM_CLIENT.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_ORG)) {
				orgID = Integer.parseInt(arg.substring(PARAM_ORG.length()));
			} else if (arg.toLowerCase().equals(PARAM_INV)) {
				invoiceID = Integer.parseInt(arg.substring(PARAM_INV.length()));
			} else if (arg.toLowerCase().equals(PARAM_POS)) {
				pos = Integer.parseInt(arg.substring(PARAM_POS.length()));
			} else if (arg.toLowerCase().equals(PARAM_CAEA)) {
				caea = arg.substring(PARAM_CAEA.length());				
			} else {
				showHelp("ERROR: Argumento " + arg + " no reconocido");
				System.exit(1);
			}
		}
		
	  	// OXP_HOME seteada?
	  	String oxpHomeDir = System.getenv("OXP_HOME"); 
	  	if (oxpHomeDir == null)
	  		showHelp("ERROR: La variable de entorno OXP_HOME no está seteada ");

	  	// Cargar el entorno basico
	  	System.setProperty("OXP_HOME", oxpHomeDir);
	  	if (!OpenXpertya.startupEnvironment( false ))
	  		showHelp("ERROR: Error al iniciar el ambiente cliente.  Revise la configuración");
	  	
	  	// Configuracion
	  	if (clientID == -1 || orgID == -1)
	  		showHelp("ERROR: Debe especificar ID compañía y ID de organizacion (la cual puede ser 0)");
	  	Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
	  	Env.setContext(Env.getCtx(), "#AD_Org_ID", orgID);

	  	// Invocacion
	  	try {
			// Recuperar ID del proceso de sincronización con tienda nube a partir del UID 
			int processID = DB.getSQLValue(null, " SELECT AD_PROCESS_ID FROM AD_PROCESS WHERE AD_ComponentObjectUID = '" + CAEA_NOTIFY_DOCUMENT_PROCESS_UID + "' ");
			if (processID<=0) {
				showHelp("No se ha podido recuperar la informacion del proceso de notificacion");
			}
			ProcessInfo pi = new ProcessInfo("CAEA Request", processID);
			
			// Parametros: cia
			addProcessParam(pi, "AD_Client_ID", clientID);
			// Parametros: org
			addProcessParam(pi, "AD_Org_ID", orgID);
			// Parametros: factura
			addProcessParam(pi, "C_Invoice_ID", invoiceID>0?invoiceID:null);
			// Parametros: pos
			addProcessParam(pi, "POS", pos>0?pos:null);
			// Parametros: caea
			addProcessParam(pi, "CAEA", caea!=null?caea:null);			
			
			// Invocar al proceso
			MProcess process = new MProcess(Env.getCtx(), processID, null);
			MProcess.execute(Env.getCtx(), process, pi, null);
	  	} catch (Exception e) {	  		
	  		e.printStackTrace();
	  	}	  	
	}

	/** Incorporar un nuevo parametro para la ejecucion del proceso */
	protected static void addProcessParam(ProcessInfo pi, String paramName, Object paramValue) {
		ProcessInfoParameter aParam = new ProcessInfoParameter(paramName, paramValue, null, null, null);
		pi.setParameter(ProcessInfoUtil.addToArray(pi.getParameter(), aParam));	
	}
	
	
	/** Ayuda al usuario */
	protected static void showHelp(String message)
	{
		System.out.println(message);
		System.exit(1);
	}
	
	/** Mesajes de ayuda al usuario */
	protected static String getHelpMessage() {
		return 	" Pedido de CAEA \n\n" +
				" Argumentos: \n" +
				"   " + PARAM_HELP 				+ " muestra esta ayuda \n" + 
				"   " + PARAM_CLIENT 			+ " AD_Client_ID (obligatorio) \n" +
				"   " + PARAM_ORG 				+ " AD_Org_ID (obligatorio, puede ser 0) \n" +				
				"   " + PARAM_INV 				+ " informar una factura (C_Invoice_ID) en particular (opcional) \n" +
				"   " + PARAM_POS		 		+ " informar un punto de venta en particular (opcional) \n" +
				"   " + PARAM_CAEA		 		+ " informar un CAEA en particular (opcional) \n" +				
				" \n" +
				" El nombre de argumento y su correspondiente valor no deben tener espacios!";
	}
}
