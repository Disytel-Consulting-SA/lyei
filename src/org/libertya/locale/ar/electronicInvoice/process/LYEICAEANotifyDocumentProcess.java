package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_Invoice;
import org.libertya.locale.ar.electronicInvoice.model.LP_M_Product;
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
import org.openXpertya.model.MPreference;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MProduct;
import org.openXpertya.model.MTax;
import org.openXpertya.model.MUOM;
import org.openXpertya.model.X_C_DocType;
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
	
	/** Preferencia con el codigo predeterminado para el campo CodigoMtx */
	public static final String LYEI_CODIGO_MTX_PREDETERMINADO_PREFERENCE = "LYEI_CODIGO_MTX_PREDETERMINADO";
	
	/** Preferencia con el codigo predeterminado para el campo CodigoUOMFE */
	public static final String LYEI_CODIGO_UOM_PREDETERMINADO_PREFERENCE = "LYEI_CODIGO_UOM_PREDETERMINADO";
	
	/** El documento fue aprobado */
	public static final String DOC_STATUS_APROBADO = "APROBADO";
	/** El documento fue observado */
	public static final String DOC_STATUS_OBSERVADO = "OBSERVADO";
	/** El documento fue rechazado */
	public static final String DOC_STATUS_RECHAZADO = "RECHAZADO";
	
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
			MDocType docType = new MDocType(getCtx(), anInvoice.getC_DocTypeTarget_ID(), null);
			result.append(" Informando ").append(docType.getName()).append(" ").append(anInvoice.getDocumentNo()).append(": ");
			try {
				String status = notifyInvoice(anInvoice, docType);	
				result.append(status).append(". \n<br>");
				// Solo sumar a OK si fue aceptado u observado
				if (status!=null && (status.startsWith(DOC_STATUS_APROBADO) || status.startsWith(DOC_STATUS_OBSERVADO))) {
					ok++;
				} else {
					ko++;
				}
			} catch (Exception e) {
				result.append(e.getMessage()).append(". \n<br>");
				ko++;				
			}
		}
		String retValue = 
				" Finalizado. Detalle: \n<br> " +
				" \n<br>" +
				result.toString() +
				" \n<br> " +
				" Total informadas OK:" + ok + ", total KO:" + ko;
		System.out.println(retValue.replace("<br>", ""));
		return retValue;
	}

	/** Recupera los documentos a informar */
	protected String getDocumentsQuery() {
		return 	" SELECT * " +
				" FROM C_Invoice i " +
				" WHERE AD_Client_ID = " + clientID +
				" AND lyeicaeainformed IN ('" + LP_C_Invoice.LYEICAEAINFORMED_Pendiente + "', '" + LP_C_Invoice.LYEICAEAINFORMED_Rechazado + "') " +
				(orgID > 0 ? " AND AD_Org_ID 		= " + orgID : "") +
				(invID > 0 ? " AND C_Invoice_ID 	= " + invID : "") +
				(pos   > 0 ? " AND puntodeventa 	= " + pos : "") +
				(!Util.isEmpty(caea)? " AND cae 	= '" + caea + "'" : "") +
				" ORDER BY documentno ASC ";
	}
	
	/** Efectiviza la notificacion a AFIP 
	 * @return el estado de la notificacion, que puede ser Aprobado, Observado o Rechazado
	 * @throws excepcion ante algun error de configuración, comunicación, etc.
	 * */
	protected String notifyInvoice(LP_C_Invoice inv, MDocType docType) throws Exception {
		try {
			// EC 
			MBPartner partner = new MBPartner(getCtx(), inv.getC_BPartner_ID(), null);
			// Moneda de la factura
			MCurrency currency = new MCurrency(getCtx(), inv.getC_Currency_ID(), null);
			
			// Obtener la configuracion de FE segun la factura
			posConfig = MLYEIElectronicPOSConfig.get(inv.getPuntoDeVenta(), inv.getAD_Org_ID(), inv.getCtx(), null);
			
			// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
			if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()==0) {
				throw new Exception("Configuracion de punto de venta electronico nulo o no inicializado correctamente para punto de venta " + inv.getPuntoDeVenta());		
			}
			genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
	
			// Pedir WSAA segun la factura
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, posConfig.getCtx(), posConfig.getCurrentEnvironment());
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
			
			/* Fecha de vencimiento del código de autorización (Opcional) Si se informa, debe coincidir con la Fecha Hasta del CAEA */	
			// comp.setFechaVencimiento(LYEICommons.getFechaVtoDate(inv));
			
			/* Código de documento del receptor del comprobante. Los posibles valores pueden ser consultados en el método consultarTiposDocumento */
			comp.setCodigoTipoDocumento((short)LYEICommons.getDocTipo(partner));
			
			/* Número de documento del receptor del comprobante */
			comp.setNumeroDocumento(LYEICommons.getDocNro(partner, inv));
						
			/* Código de la moneda en que se emite el comprobante. */
			comp.setCodigoMoneda(LYEICommons.getMonId(currency));
			
			/* Tipo de cambio Total de dígitos 10 (4 enteros y 6 decimales) Mayor a cero. Máximo permitido: 9999.999999 */
			comp.setCotizacionMoneda(LYEICommons.getMonCotiz(inv, getCtx()));
			
			/* Concepto incluido en el comprobante. Valores permitidos: 1: Productos 2: Servicios 3: Productos y Servicios */
			comp.setCodigoConcepto((short)LYEICommons.getConcepto(inv.getC_Invoice_ID()));
			
			/* Array. Detalle de los ítems que componen el comprobante. */
			comp.setArrayItems(getArrayItems(inv, docType));
			
			/* Array. Detalle de las Alícuotas de IVA e importes de IVA liquidados en el comprobante */
			SubtotalIVAType[] iva = getArraySubtotalesIVA(inv);
			BigDecimal impIva = getImpIVA(iva);
			if (iva!=null && iva.length>0) {
				comp.setArraySubtotalesIVA(iva);	
			}
						
			/* Array. Detalle de los tributos alistados en el comprobante. */
			OtroTributoType[] otrosTrib = getArrayOtrosTributos(inv);
			if (otrosTrib!=null && otrosTrib.length>0) {
				comp.setArrayOtrosTributos(otrosTrib);
				BigDecimal impOtrosTrib = getImpOtrosTrib(otrosTrib);				
				/* Importe total de Otros Tributos */
				comp.setImporteOtrosTributos(impOtrosTrib);	
			}

			/* Importe neto total de conceptos gravados */
			comp.setImporteGravado(LYEICommons.getImpNetoBigDecimal(impIva, docType, inv));
			
			/* Importe total de conceptos no gravados. */
			comp.setImporteNoGravado(LYEICommons.getImpTotConcBigDecimal(inv.getC_Invoice_ID()));
			
			/* Importe total de conceptos exentos */
			comp.setImporteExento(LYEICommons.getImpOpExBigDecimal(inv.getC_Invoice_ID()));
			
			/* Importe subtotal del comprobante */
			comp.setImporteSubtotal(getImporteSubtotal(impIva, docType, inv));
			
			/* Importe total del comprobante */
			comp.setImporteTotal(LYEICommons.getImpTotalBigDecimal(inv));			
			
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
				return DOC_STATUS_RECHAZADO + ": " + errors;
			}
			
			// Fue Observado?			
			if (LP_C_Invoice.LYEICAEAINFORMED_Observado.equals(response.getResultado().getValue())) {
				String obs = stringFromArray(response.getArrayObservaciones());
				inv.setLYEICAEAInformed(LP_C_Invoice.LYEICAEAINFORMED_Observado);
				inv.setLYEICAEAInformedDetail(obs);
				inv.save();
				return DOC_STATUS_OBSERVADO + ": " + obs;
			} 
			
			// Fue Aprobado
			if (LP_C_Invoice.LYEICAEAINFORMED_Aprobado.equals(response.getResultado().getValue())) {
				inv.setLYEICAEAInformed(LP_C_Invoice.LYEICAEAINFORMED_Aprobado);
				inv.setLYEICAEAInformedDetail("APROBADO");
				// Si antes fue rechazado u observador, elimina el mensaje de error anterior
				inv.save();
				return DOC_STATUS_APROBADO;
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
	protected SubtotalIVAType[] getArraySubtotalesIVA(LP_C_Invoice inv) throws Exception {
		ArrayList<SubtotalIVAType> alicsIva = new ArrayList<SubtotalIVAType>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(inv.getCtx(), invoiceTax.getC_Tax_ID(), inv.get_TrxName());
			// Las percepciones van aparte 
			if (tax.isPercepcion())
				continue;
			// Esta configurado el wsfecode?
			if (tax.getWSFECode()<=0)
				throw new Exception("Debe definir el codigo wsfecode del impuesto " + tax.getName());
			// Solo codigos 4 5 o 6. De informar otras alicuotas se presenta error: Codigo de Alicuota Invalido. Valores permitidos 4, 5 o 6.
			if (tax.getWSFECode()<4 || tax.getWSFECode()>6)
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
			tributo.setBaseImponible(invoiceTax.getTaxBaseAmt());
			tributo.setImporte(invoiceTax.getTaxAmt().setScale(2, BigDecimal.ROUND_HALF_UP));
			tributo.setDescripcion(tax.getName());
			tributos.add(tributo);
		}
		return tributos.toArray(new OtroTributoType[tributos.size()]);
	}
	
	
	/** Total impuestos */
	protected BigDecimal getImpIVA(SubtotalIVAType[] alicsIva) {
		BigDecimal total = BigDecimal.ZERO;
		for (SubtotalIVAType alicIva : alicsIva)
			total = total.add(alicIva.getImporte());
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	/** Total otros tributos */
	protected BigDecimal getImpOtrosTrib(OtroTributoType[] alicsOT) {
		BigDecimal total = BigDecimal.ZERO;
		for (OtroTributoType otroTrib : alicsOT)
			total = total.add(otroTrib.getImporte());
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/** Importe gravado + no gravado + exento */
	protected BigDecimal getImporteSubtotal(BigDecimal impIva, MDocType docType, MInvoice inv) throws Exception{
		return LYEICommons.getImpNetoBigDecimal(impIva, docType, inv).add(LYEICommons.getImpTotConcBigDecimal(inv.getC_Invoice_ID())).add(LYEICommons.getImpOpExBigDecimal(inv.getC_Invoice_ID()));
	}
	
	/** Items de la factura */
	protected ItemType[] getArrayItems(LP_C_Invoice inv, MDocType docType) throws Exception {
		
		ArrayList<ItemType> items = new ArrayList<ItemType>();
		
		for (MInvoiceLine line : inv.getLines()) {
			LP_M_Product aProduct = new LP_M_Product(inv.getCtx(), line.getM_Product_ID(), inv.get_TrxName());
			MTax aTax = new MTax(inv.getCtx(), line.getC_Tax_ID(), inv.get_TrxName());
			MUOM aUOM = new MUOM(inv.getCtx(), line.getC_UOM_ID(), inv.get_TrxName());
			
			// Nueva entrada
			ItemType item = new ItemType();
			
			/* Cantidad */
			item.setCantidad(line.getQtyInvoiced());
			
			/* Código interno asignado por la empresa (Importante: NO es necesario completar con espacios) (Opcional) */
			if (aProduct.getM_Product_ID()>0) {
				item.setCodigo(aProduct.getValue());
			}
			
			/* Codigo de IVA. Para obtener los posibles valores consultar método consultarCondicionesIVA 
			   1: No gravado, 2: Exento, 3: 0%, 4: 10,5%, 5: 21%, 6: 27% */
			item.setCodigoCondicionIVA((short)aTax.getWSFECode());
			
			/* Unidad de medida. Consultar método consultarUnidadesMedida 
			   0: " ", 1: Kilogramos, 2: metros, etc... */
			
			// dREHER, informar si no se configuro codigo de unidad de medida
			String defaultCodigoUOM = null;
			if (!Util.isEmpty(MPreference.GetCustomPreferenceValue(LYEI_CODIGO_UOM_PREDETERMINADO_PREFERENCE))) {
				defaultCodigoUOM = MPreference.GetCustomPreferenceValue(LYEI_CODIGO_UOM_PREDETERMINADO_PREFERENCE);
			}
			if (Util.isEmpty(aUOM.getUOMCodeFE())) {
				if(Util.isEmpty(defaultCodigoUOM))
						throw new Exception("Es obligatorio informar Codigo de Unidad de Medida. Especificarlo en la tabla de unidades de Medida, campo 'Codigo UOM FE'");
			}else
				defaultCodigoUOM = aUOM.getUOMCodeFE();
			
			item.setCodigoUnidadMedida(Short.parseShort(defaultCodigoUOM));
			
			/* Descripción del Producto (Importante: NO es necesario completar con espacios) */
			item.setDescripcion(getItemDescription(line, aProduct));
			
			/* Importe Descuento o Bonificación*/
			// item.setImporteBonificacion(BigDecimal.ZERO);	// No es obligatorio
			
			/* Importe total del ítem e Importe IVA. El Importe IVA del ítem no debe informarse para Tipos de Comprobante B (6, 7 u 8) */
			if (!X_C_DocType.DOCSUBTYPECAE_FacturasB.equals(docType.getdocsubtypecae())
					&& !X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoB.equals(docType.getdocsubtypecae())
					&& !X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoB.equals(docType.getdocsubtypecae())) {
				
				/* Importe IVA según codigoCondicionIVA indicado. */
				item.setImporteIVA(line.getTaxAmt());
				
			}
			
			/* Importe total del ítem */
			item.setImporteItem((line.getLineNetAmount().add(line.getTaxAmt())).setScale(2, BigDecimal.ROUND_HALF_UP));
		
			/* Precio Unitario. Para comprobantes clase A no debe incluir el IVA, en cambio para los clase B si debe incluir IVA. */
			if ("B".equals(inv.getLetra())) {
				
				
				// Esta linea suma precion ingresado+precio unitario+impuestos
				// item.setPrecioUnitario(line.getPriceEnteredNet().add(line.getUnityAmt(line.getTaxAmt()))); 
				
				// dREHER
				// NETO / Cantidad
				item.setPrecioUnitario((line.getLineNetAmt().divide(line.getQtyEntered(), 2)).setScale(2, BigDecimal.ROUND_HALF_UP));
				
			} else {
				item.setPrecioUnitario(line.getPriceEnteredNet());
			}

			/* Unidad de Referencia del código Producto/Servicio. Cuando la comercialización de los productos se realice en presentaciones distintas a la unidad de consumo
			 *	minorista o presentación al consumidor final, a la que hace referencia la codificación del producto, se deberán indicar las cantidades de unidades de consumo 
			 *	minoristas contenidas en la presentación que se comercializa. En caso que el producto ya se encuentre individualizado en su unidad de consumo minorista, 
			 *	la unidad de referencia deberá ser igual a UNO (1) 
			 *  Es opcional si <codigoUnidadMedida> es 99 (bonificacion) ó 97 (seña), para el resto de los casos es obligatorio. */
			item.setUnidadesMtx(aProduct.getM_Product_ID()>0 && aProduct.getLYEIUnidadesMtx()>0 ? aProduct.getLYEIUnidadesMtx() : 1);	
			
			/* Código de Producto/Servicio.  Deberán corresponder a la estructura provista por la ASOCIACION ARGENTINA DE CODIFICACION DE PRODUCTOS COMERCIALES — CODIGO—, 
			 * códigos GTIN 13, GTIN 12 y GTIN 8, correspondientes a la unidad de consumo minorista o presentación al consumidor final
			 * Es opcional si <codigoUnidadMedida> es 99 ó 97, para el resto de los casos es obligatorio. */
			// SEGUN: http://www.afip.gov.ar/genericos/guiavirtual/consultas_detalle.aspx?id=14553833. 
			// Por ejemplo: 7790001001054 = Ventas varias.
			String defaultCodigoMxt = null;
			if (!Util.isEmpty(MPreference.GetCustomPreferenceValue(LYEI_CODIGO_MTX_PREDETERMINADO_PREFERENCE))) {
				defaultCodigoMxt = MPreference.GetCustomPreferenceValue(LYEI_CODIGO_MTX_PREDETERMINADO_PREFERENCE);
			}
			String codigoMtx = (aProduct.getM_Product_ID()>0 && !Util.isEmpty(aProduct.getLYEICodigoMtx()) ? aProduct.getLYEICodigoMtx() : defaultCodigoMxt);
			if (Util.isEmpty(codigoMtx)) {
				throw new Exception("Es obligatorio informar CodigoMtx. Especificarlo en el campo 'Codigo unidad minorista' del articulo o de manera general como valor predeterminado: LYEI_CODIGO_MTX_PREDETERMINADO");
			}
			item.setCodigoMtx(codigoMtx);
			
			// Incorporar item a la nomina de items
			items.add(item);
		}
		return items.toArray(new ItemType[items.size()]);
	}
	
	/** Retorna la descripcion de la linea */
	protected String getItemDescription(MInvoiceLine line, MProduct aProduct) {
		StringBuffer result = new StringBuffer();
		result.append(line.getLine())
			.append(". ")
			.append(Util.isEmpty(aProduct.getDescription()) ? "" : aProduct.getDescription())
			.append(Util.isEmpty(line.getDescription()) ? "" : line.getDescription());
		return result.toString();
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
			// El campo cuit es opcional.  Se comenta para evitar error 804: no corresponde enviar el campo cuit para el tipo de comprobante asociado indicado
	        //asoc.setCuit(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
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
	public static final String CAEA_NOTIFY_DOCUMENT_PROCESS_UID	= 	"LYEI-AD_Process-20210423095016716-372957";
	
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
			} else if (arg.toLowerCase().startsWith(PARAM_INV)) {
				invoiceID = Integer.parseInt(arg.substring(PARAM_INV.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_POS)) {
				pos = Integer.parseInt(arg.substring(PARAM_POS.length()));
			} else if (arg.toLowerCase().startsWith(PARAM_CAEA)) {
				caea = arg.substring(PARAM_CAEA.length());				
			} else {
				showHelp("ERROR: Argumento " + arg + " no reconocido");
				System.exit(1);
			}
		}
		
		// Argumentos de invocacion
		System.out.println("[Client] Argumentos: " + Arrays.toString(args));
		
	  	// OXP_HOME seteada?
	  	String oxpHomeDir = System.getenv("OXP_HOME"); 
	  	if (oxpHomeDir == null)
	  		showHelp("ERROR: La variable de entorno OXP_HOME no está seteada ");

	  	// Cargar el entorno basico
	  	System.setProperty("OXP_HOME", oxpHomeDir);
	  	if (!OpenXpertya.startupEnvironment( false ))
	  		showHelp("ERROR: Error al iniciar el ambiente cliente.  Revise la configuración");
	  	System.out.println("[Client] Host: " + DB.getDatabaseInfo());
	  	
	  	// Configuracion
	  	if (clientID == -1 || orgID == -1)
	  		showHelp("ERROR: Debe especificar ID compañía y ID de organizacion (la cual puede ser 0)");
	  	Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
	  	Env.setContext(Env.getCtx(), "#AD_Org_ID", orgID);
	  	
	  	// Moneda de la compañía
	  	int currencyID = DB.getSQLValue(null, "select c_currency_id from c_acctschema where ad_client_id = " + clientID);
	  	if (currencyID<=0) {
	  		showHelp("No se pudo determinar la moneda de la compañia desde el esquema contable");
	  	}
	  	Env.setContext(Env.getCtx(), "$C_Currency_ID", currencyID);
	  	
	  	// Invocacion
	  	try {
			// Recuperar ID del proceso 
			int processID = DB.getSQLValue(null, " SELECT AD_PROCESS_ID FROM AD_PROCESS WHERE AD_ComponentObjectUID = '" + CAEA_NOTIFY_DOCUMENT_PROCESS_UID + "' ");
			if (processID<=0) {
				showHelp("No se ha podido recuperar la informacion del proceso de notificacion de comprobante CAEA");
			}
			ProcessInfo pi = new ProcessInfo("CAEA Notify Document", processID);
			
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
		return 	" Informar comprobante CAEA \n\n" +
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
