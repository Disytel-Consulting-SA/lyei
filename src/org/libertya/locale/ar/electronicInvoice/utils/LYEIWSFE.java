package org.libertya.locale.ar.electronicInvoice.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.axis.AxisProperties;
import org.jfree.util.Log;
import org.libertya.locale.ar.electronicInvoice.model.LP_AD_Sequence;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_Invoice;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.openXpertya.electronicInvoice.ElectronicInvoiceInterface;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MBPartnerLocation;
import org.openXpertya.model.MClientInfo;
import org.openXpertya.model.MCurrency;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MInvoiceTax;
import org.openXpertya.model.MLocation;
import org.openXpertya.model.MOrgInfo;
import org.openXpertya.model.MPreference;
import org.openXpertya.model.MSequence;
import org.openXpertya.model.MTax;
import org.openXpertya.model.MTaxCategory;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.model.X_C_Invoice;
import org.openXpertya.reflection.CallResult;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Util;

import FEV1.dif.afip.gov.ar.Actividad;
import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.CbteAsoc;
import FEV1.dif.afip.gov.ar.Comprador;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import FEV1.dif.afip.gov.ar.Obs;
import FEV1.dif.afip.gov.ar.Opcional;
import FEV1.dif.afip.gov.ar.ServiceLocator;
import FEV1.dif.afip.gov.ar.ServiceSoap;
import FEV1.dif.afip.gov.ar.ServiceSoapStub;
import FEV1.dif.afip.gov.ar.Tributo;

public class LYEIWSFE implements ElectronicInvoiceInterface {

	/** Factura a la cual registrar electronicamente */
	protected MInvoice inv;
	/** Entidad comercial de la factura */
	protected MBPartner partner; 
	/** Tipo de documento de la factura */
	protected MDocType docType;
	/** Moneda de la factura */
	protected MCurrency currency;
	/** Info de la compañía asociada a la factura */
	MClientInfo clientInfo;
	/** Info de la organizacion asociada a la factura */
	MOrgInfo orgInfo;
	/** BPartnerLocation de la EC de la factura */ 
	MBPartnerLocation bpLocation;
	/** Location de la EC de la factura */
	MLocation location;
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** Contexto */
	protected Properties ctx;
	/** Transaccion */
	protected String trx;
	/** CAE obtenido */
	protected String electronicInvoiceCae;
	/** Vencimiento del CAE */
	protected Timestamp electronicInvoiceVtoCae;
	/** Numero de comprobante obtenido */
	protected String electronicInvoiceNroCbte;
	/** Error(es) al obtener el CAE */ 
	protected StringBuffer electronicInvoiceCaeError = new StringBuffer();
	/** Request XML	 */
	protected String requestXML = null;
	/** Response XML */
	protected String responseXML = null;
	/** Punto de Venta */
	protected int puntoDeVenta = 0;
	
	/**
	 * Constructor para servicio WSFEV1 de AFIP
	 * @param inv factura
	 * @param ctx contexto LY
	 * @param trx transaccion
	 */
	public LYEIWSFE(MInvoice inv) {
		this.inv = inv;
		this.ctx = inv.getCtx();
		this.trx = inv.get_TrxName();
		
		puntoDeVenta = inv.getPuntoDeVenta();
		
		// Configuracion electronica adecuada segun el punto de venta de la factura
		posConfig = MLYEIElectronicPOSConfig.get(inv.getPuntoDeVenta(), inv.getAD_Org_ID(), ctx, null);
		// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
		if (posConfig!=null)
			genConfig = new MLYEIElectronicInvoiceConfig(ctx, posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
		
		// Tipo de documento
		docType = new MDocType(ctx, inv.getC_DocTypeTarget_ID(), null);
		// Entidad Comercial de la factura
		partner = new MBPartner(ctx, inv.getC_BPartner_ID(), null);
		// Moneda de la factura 
		currency = new MCurrency(ctx, inv.getC_Currency_ID(), null);
		// ClientInfo de la factura
		clientInfo = MClientInfo.get(ctx, inv.getAD_Client_ID());
		// OrgInfo de la factura
		orgInfo = MOrgInfo.get(ctx, inv.getAD_Org_ID());
		// BPLocation asociado a la EC
		bpLocation = new MBPartnerLocation(ctx, inv.getC_BPartner_Location_ID(), null);
		// Location asociado a la EC
		if (bpLocation!=null)
			location = new MLocation(ctx, bpLocation.getC_Location_ID(), null);
	}
	
	/**
	 * Registra una factura electronica en el site de AFIP mediante WSFEV1
	 */
	public synchronized String generateCAE() {
		return generateCAE(0);
	}
	
	/**
	 * Registra una factura electronica en el site de AFIP mediante WSFEV1
	 */
	public synchronized String generateCAE(long nroComprobante) {
		
		String totales = "";
		
		/**
		 * Cuando se llama el metodo sin haber configurado el punto de venta, genera excepcion y el TPV queda colgado...
		 * dREHER
		 */
		if(posConfig==null)
			return "NO existe una configuracion de factura electronica para el punto de venta " + puntoDeVenta;
		
		// El punto de venta electronico usa CAEA?
		if (LP_C_LYEIElectronicPOSConfig.CAEMETHOD_CAEA.equals(posConfig.getCAEMethod())) {
			try {
				MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Solicitando CAE mediante CAEA");
				
				// Recupear el caea para el periodo y orden actual, ya sea online o en la "cache" de CAEARequests
				LYEIMTXCA mtxca = new LYEIMTXCA(inv);
				mtxca.requestCAEA();
				if (mtxca.currentCAEA()==null)
					throw new Exception("No se encuentra un lote de CAEA asociado ");
				
				// CAEA obtenido
				electronicInvoiceCae = mtxca.currentCAEA().getCAEA();
				// CAE Vto
				electronicInvoiceVtoCae = mtxca.currentCAEA().getFechaHasta(); 
				// Sin errores
				electronicInvoiceCaeError = null;
				// Numero de comprobante... 
				electronicInvoiceNroCbte = generateNroComprobanteCAEA(); 
				
				// dREHER si llega con un numero de comprobante, respetarlo
				if(nroComprobante > 0)
					electronicInvoiceNroCbte = String.valueOf(nroComprobante);
				
				
				// La factura debe marcarse como pendiente a informar
				inv.set_Value("LYEICAEAInformed", LP_C_Invoice.LYEICAEAINFORMED_Pendiente);
				return "";
			} catch (Exception e) {
				// No se pudo obtener CAE desde CAEA, elevar la excepción
				MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.SEVERE, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, "Error en obtencion CAEA: " + e.getMessage());
				electronicInvoiceCae = null;
				electronicInvoiceVtoCae = null;
				electronicInvoiceNroCbte = null;
				return e.toString();
			}
		}
		
		// Forzar TLS 1.2 si es que existe el factory correspondiente
		try {
			Class.forName("org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
			AxisProperties.setProperty("axis.socketSecureFactory", "org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
		} catch (Exception e) { /* Nada por hacer. Utilizar la version de SSL por defecto */}
		
		// En caso de existir un error, se dio durante la preparacion de los datos o luego de invocar al ws de afip? 
		boolean serviceInvoked = false;
		try {
			// Preliminares
			validarPreliminares();

			// Log nueva factura
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSFEV1_PREFIX, posConfig.getCurrentEnvironment());
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getIniSolicitarCAEActivityLog(endPoint));
			
			// Conexion a WSFEV1
			ServiceLocator locator = new ServiceLocator();
			locator.setServiceSoapEndpointAddress(endPoint); // <= IMPORTANTE esta linea setea la URL del servicio, dependiendo del entorno (Homologacion/Produccion)
			ServiceSoap wsfe = locator.getServiceSoap(); 
			((ServiceSoapStub)wsfe).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_WSFEV1_PREFIX, posConfig.getCurrentEnvironment()));
			
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, ctx, posConfig.getCurrentEnvironment());
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// AuthRequest
			FEAuthRequest auth = new FEAuthRequest();
			auth.setCuit(Long.parseLong(genConfig.getCUIT())); 	// CUIT del emisor de la factura						
			auth.setToken(token);
			auth.setSign(sign);
	
			// Comprobante - Cabecera
			FECAECabRequest cabReq = new FECAECabRequest(1, inv.getPuntoDeVenta(), LYEICommons.getCbteTipo(docType));
			
			
			/**
			 * Se modifica obtencion del siguiente numero basandose en la secuencia Libertya
			 * correspondiente al tipo de comprobante y su punto de venta
			 *   
			 * dREHER  
			 */
						
			// Comprobante - Detalle
			FECAEDetRequest detReq = new FECAEDetRequest();
			
			// Nro. de comprobante desde y hasta desde AFIP
			long cbteNroAFIP = getSigCbteNro(wsfe, auth);
			
			// dREHER trae el numero segun secuencia Libertya			
			long cbteNro = 0L; 
				
			// TODO: ver bien que pasa cuando un comprobante queda en proceso ... la secuencia ya se incremento ?
			// en ese caso cuando se quiere completar se pasa a la siguiente secuencia y queda defazado de AFIP
			// por eso siempre verificar si la factura tiene numero de comprobante (por ahora solo cuando se carga manualmente)
			if(nroComprobante == 0 && !inv.isTPVInstance())
				nroComprobante = inv.getNumeroComprobante();
			
			// Si viene de gestionar CAE desde ventana, debe venir con el numero de comprobante a gestionar, sino siguiente secuencia...
			if(nroComprobante > 0)
				cbteNro = nroComprobante;
			else {
				cbteNro = getSigCbteNro(cbteNroAFIP); // chequear la secuencia en este punto
				/**
				 * 
				 * EN ESTE PUNTO NO HACER NADA CON LA SECUENCIA
				 * dREHER
				 * 
				if(cbteNro > cbteNroAFIP && cbteNro > getLastFEIssued(inv.getCtx(), inv.getDocTypeID(), 0, inv.get_TrxName())) {
					
					// Verifica si la secuencia debe ser actualizada
					CallResult r = inv.doSequenceControls();
					// Si tuvo que actualizar y dio error al hacerlo, cortar aca el proceso...
					if(r.isError()) {
						throw new Exception ("ERROR: " + r.getMsg());
					}
					
					// Tomar el siguiente numero desde la secuencia
					MSequence seq = new MSequence(inv.getCtx(), inv.getAD_Sequence_ID(), inv.get_TrxName());
					cbteNro = seq.getCurrentNext().intValue();
				}
				*/
			}
			
			detReq.setCbteDesde(cbteNro);
			// Nro. de comprobante hasta
			detReq.setCbteHasta(cbteNro);
			// Concepto de la factura. Valores permitidos: 01 Productos. 02 Servicios. 03 Productos y Servicios.
			int concepto = LYEICommons.getConcepto(inv.getC_Invoice_ID());
			detReq.setConcepto(concepto);
			// En caso de que se informe servicio, debe informarse el periodo desde y hasta
			if (concepto > LYEIConstants.WSFE_CONCEPTO_PRODUCTOS) {
				detReq.setFchServDesde(LYEICommons.setFchServDesde(inv));
				detReq.setFchServHasta(LYEICommons.setFchServHasta(inv));
			}
			// Código   de   documento   identificatorio   del	comprador
			detReq.setDocTipo(LYEICommons.getDocTipo(partner));
			// Nro.  de identificación del comprador
			detReq.setDocNro(LYEICommons.getDocNro(partner, inv));
			
			// dREHER Condicion de IVA del receptor
			detReq.setCondicionIvaReceptorId(LYEICommons.getCondIva(partner));
			
			
			// Fecha del comprobante  (yyyymmdd). Si  no  se envía la	fecha del comprobante se   
			// asignará la fecha de proceso
			detReq.setCbteFch(LYEICommons.getCbteFchString(inv));
			
			// Fecha vencimiento pago. Si el tipo de comprobante que está autorizando es MiPyMEs (FCE) tipos 201/206/211 (Factura A/B/C), es obligatorio informar FchVtoPago.
			detReq.setFchVtoPago(LYEICommons.getFechaVtoString(inv));
			
			// Código de  moneda  del comprobante. Consultar método FEParamGetTiposMonedas para valores posibles
			detReq.setMonId(LYEICommons.getMonId(currency));
			// Cotizacion de  la  moneda  informada.  Para PES, pesos argentinos  la misma debe ser 1
			detReq.setMonCotiz(LYEICommons.getMonCotiz(inv, ctx).doubleValue());
			// Impuestos.  No deben ser enviados para comprobantes de tipo C
			AlicIva[] iva = getIva();
			double impIva = getImpIVA(iva);
			if (!X_C_DocType.DOCSUBTYPECAE_FacturasC.equals(docType.getdocsubtypecae())
					&& !X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoC.equals(docType.getdocsubtypecae())
					&& !X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoC.equals(docType.getdocsubtypecae())) {
				
				// Array  para  informar  las  alícuotas  y  sus importes   asociados   a   un   comprobante <AlicIva>
				if(iva.length>0) {
					detReq.setIva(iva);
					// Suma de los importes del array de IVA
					detReq.setImpIVA(impIva);
				}
			}
			// Otros tributos
			double tmpV = 0.00;
			Tributo[] tributos = getTributos();
			if (tributos!=null && tributos.length>0) {
				// Array  para  informar  los  tributos  asociados a  un  comprobante  <Tributo>.
				detReq.setTributos(tributos);
				// Suma de los importes del array de tributos
				detReq.setImpTrib(getImpTrib(tributos));
				tmpV = detReq.getImpTrib();
			}
			
			Double valor = 0.00;
			BigDecimal bigValor = LYEICommons.getImpNeto(impIva, docType, inv);
			if(bigValor == null)
				throw new Exception("Error al leer NETO del comprobante!");
			else
				valor = bigValor.doubleValue();
			
			/** 
			 * 20230506
			 * En las anulaciones de NC desde la ventana de facturas de clientes
			 * la ND generada como reversion, el metodo getImpNeto devuelve cero
			 * en ese caso tomarlo desde el neto de la reversion ND
			 * 
			 * TODO: Si se obtiene IVA o Tributos y el Neto obtenido es CERO
			 * leer el Neto desde el propio comprobante
			 * 
			 * dREHER
			 */ 
			
			// CDA-2671 Si llega hasta aca SIN importe de IVA, no enviar valor NETO
			if(valor==0.00 && impIva > 0) {
				if(impIva > 0 || detReq.getImpTrib() > 0) {
					bigValor = inv.getNetAmount();
					valor = bigValor.doubleValue();
				}
			}
			
			// Importe  neto    gravado.  Debe  ser  menor  o igual a Importe total y no puede ser menor a cero.
			detReq.setImpNeto(valor);
			totales += " Neto=" + valor;

			bigValor = LYEICommons.getImpTotal(inv);
			if(bigValor == null)
				throw new Exception("Error al leer TOTAL del comprobante!");
			else
				valor = bigValor.doubleValue();
			// Importe total  del comprobante, Debe ser igual  a  Importe  neto  no  gravado  +  Importe 
			// exento + Importe neto gravado + todos los campos  de  IVA    al  XX%  +  Importe  de	tributos
			detReq.setImpTotal(valor);
			totales += " Total=" + valor;
			
			bigValor = LYEICommons.getImpTotConc(inv.getC_Invoice_ID());
			if(bigValor == null)
				throw new Exception("Error al leer NO GRAVADO del comprobante!");
			else
				valor = bigValor.doubleValue();			
			// Importe neto no gravado. Debe ser menor o igual a Importe total y no puede ser menor a cero. 
			// No  puede  ser  mayor  al  Importe  total  de  la operación ni menor a cero (0)
			detReq.setImpTotConc(valor);
			totales += " NO gravado=" + valor;
			
			bigValor = LYEICommons.getImpOpEx(inv.getC_Invoice_ID());
			if(bigValor == null)
				throw new Exception("Error al leer EXCENTO del comprobante!");
			else
				valor = bigValor.doubleValue();
			// Importe  exento.  Debe  ser  menor  o  igual  a Importe total y no puede ser menor a cero
			detReq.setImpOpEx(valor);
			totales += " Excento=" + valor;
			
			totales += " Otr Tributos=" + tmpV;
			
			totales += " IVA=" + impIva;
			
			// Opcionales
			Opcional[] opcionales = getOpcionales();
			if (opcionales!=null && opcionales.length>0) { 
				detReq.setOpcionales(opcionales);
			}

			CbteAsoc[] asociados = getAsociados();
			if (asociados!=null && asociados.length>0) { 
				detReq.setCbtesAsoc(asociados);
			}
			
			Actividad[] actividades = getActividades();
			if (actividades!=null && actividades.length>0) { 
				detReq.setActividades(actividades);
			}
			
			// Invocar CAESolicitar
			FECAERequest caeReq = new FECAERequest(cabReq, new FECAEDetRequest[] {detReq});
			serviceInvoked = true;
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getSolicitarCAEActivityLog());
			// System.out.println(getSolicitarCAEActivityLog());
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getDataToBeSent(caeReq));
			FECAEResponse resp = wsfe.FECAESolicitar(auth, caeReq);
			
			// No obtuvimos respuesta alguna?
			if (resp==null) {
				throw new Exception ("No se ha obtenido una respuesta por parte del WS de AFIP.");
			}
			
			requestXML = ((ServiceSoapStub)wsfe).getCallRequestXML();
			responseXML = ((ServiceSoapStub)wsfe).getCallResponseXML();
			
			System.out.println("--> LYEIWSFE.requestXML: \n" + requestXML);
			
			// Obtuvimos errores?
			StringBuffer retErrors = null;
			if (resp.getErrors()!=null && resp.getErrors().length > 0) {
				retErrors = new StringBuffer("ERR: ");
				for (Err error : resp.getErrors()) {
					retErrors.append(error.getCode()).append(" ").append(error.getMsg()).append("; ");
				}
				if(cbteNroAFIP > 0)
					retErrors.append("Prox # AFIP:" + cbteNroAFIP).append("; ");
					retErrors.append("Prox # Libertya:" + cbteNro).append("; ");
			}
			
			// Obtuvimos observaciones?
			StringBuffer retObs = null;
			if (resp.getFeDetResp()!=null && resp.getFeDetResp().length > 0 && resp.getFeDetResp()[0].getObservaciones() != null && resp.getFeDetResp()[0].getObservaciones().length > 0) {
				retObs = new StringBuffer("OBS: ");
				for (Obs ob : resp.getFeDetResp()[0].getObservaciones()) {
					retObs.append(ob.getCode()).append(" ").append(ob.getMsg()).append("; ");
				}
			}
			
			// Procesar resultado
			
			if(electronicInvoiceCaeError==null)
				electronicInvoiceCaeError = new StringBuffer();
			
			electronicInvoiceCaeError.append(retErrors!=null?retErrors:"").append(retObs!=null?retObs:"");
			if (resp.getFeDetResp()!=null && resp.getFeDetResp().length>0 && !Util.isEmpty(resp.getFeDetResp()[0].getCAE())) {
				// CAE RECIBIDO
				electronicInvoiceCae = resp.getFeDetResp()[0].getCAE();
				// FECHA VTO RECIBIDO
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			    Date parsedDate = dateFormat.parse(resp.getFeDetResp()[0].getCAEFchVto());
			    electronicInvoiceVtoCae = new java.sql.Timestamp(parsedDate.getTime());
				// NRO COMPROBANTE
				electronicInvoiceNroCbte = ""+resp.getFeDetResp()[0].getCbteDesde();
			}
			
		} catch (Exception e) {
			System.out.println("Error generando CAE: " + e.toString());
			setErrorByException(serviceInvoked, e);
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.SEVERE, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getErrSolicitarCAEActivityLog());
		}
		// Retornar eventuales mensajes de error (similar a version original Wsfe)
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getFinSolicitarCAEActivityLog());
		
		if(electronicInvoiceCaeError.length()>0) {
			System.out.println("Error al procesar comprobante electronico, Importes: " + 
					totales);
		}
		
		
		return electronicInvoiceCaeError.toString();
	}
	
	/**
	 * 
	 * @param ctx
	 * @param docTypeID
	 * @param excludedInvoiceID
	 * @param trxName
	 * @return maximo numero de comprobante utilizado para este tipo de documento
	 * dREHER
	 */
	protected int getLastFEIssued(
			Properties ctx, Integer docTypeID, Integer excludedInvoiceID,
			String trxName) {
		String sql = "select max(i.NumeroComprobante) "
				+ "from c_invoice i "
				+ "inner join c_doctype dt on dt.c_doctype_id = i.c_doctypetarget_id "
				+ "where i.c_doctypetarget_id = " + docTypeID
				+ "			and dt.iselectronic = 'Y' "
				+ "			and i.docstatus in ('CO','CL','VO','RE') "
				+ "			and i.cae is not null "
				+ "			and length(trim(i.cae)) > 0 "
				+ (Util.isEmpty(excludedInvoiceID, true) ? "" : " AND i.c_invoice_id <> " + excludedInvoiceID);
		
		return DB.getSQLValue(trxName, sql);
	}
	
	/** 
	 * Retorna el siguiente numero registrado en la secuencia 
	 * correspondiente al tipo de documento 
	 * 
	 *  dREHER
	 * */
	protected long getSigCbteNro(long sigNroAFIP) throws Exception {
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Lee numero de comprobante segun secuencia, correspondiente al tipo de comprobante C_DocType: " + docType.getName());
		LP_AD_Sequence seq = new LP_AD_Sequence(ctx, docType.getDocNoSequence_ID(), trx);
		long siguiente = 2L;
		
		String sigNumber = seq.getCurrentNext().toString();
		if(sigNumber.length() > 8) 
			sigNumber = sigNumber.substring(sigNumber.length() - 8);
		try {
			if(sigNumber!=null && !sigNumber.isEmpty()) {
				siguiente = Long.parseLong(sigNumber);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Numero Libertya: " + siguiente + " - nro AFIP: " + sigNroAFIP);
		return siguiente;
	}

	
	/** Retorna el siguiente valor al ultimo comprobante registrado */
	protected long getSigCbteNro(ServiceSoap wsfe, FEAuthRequest auth) throws Exception {
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Invocando a RECompUltimoAutorizado");
		FERecuperaLastCbteResponse ult = wsfe.FECompUltimoAutorizado(auth, inv.getPuntoDeVenta(), LYEICommons.getCbteTipo(docType));
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "RECompUltimoAutorizado obtenido " + ult.getCbteNro());
		
		System.out.println("===> LYEIWSFE.getSigCbteNro. Ultimo numero autorizado en AFIP=" + ult.getCbteNro());
		
		return ult.getCbteNro() + 1L;
	}
	
	/** Retorna el numero de comprobante */
	protected long getCbteNro() {
		return inv.getNumeroComprobante();
	}
	
	/** Retorna true si el tipo de documento es Factura MiPyme (A/B/C) o false en caso contrario */
	protected boolean isFacturaMiPyME() {
		return (X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEA.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEB.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_FacturasMiPyMEC.equals(docType.getdocsubtypecae()));
	}
	
	/** Retorna true si el tipo de documento es NC/ND MiPyme (A/B/C) o false en caso contrario */
	protected boolean isNCNDMiPyME() {
		return (X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEA.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEB.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_NotasDeCreditoMiPyMEC.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEA.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEB.equals(docType.getdocsubtypecae()) ||
				X_C_DocType.DOCSUBTYPECAE_NotasDeDebitoMiPyMEC.equals(docType.getdocsubtypecae()));
	}
		
	/** Impuestos */
	protected AlicIva[] getIva() {
		ArrayList<AlicIva> alicsIva = new ArrayList<AlicIva>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(ctx, invoiceTax.getC_Tax_ID(), trx);
			MTaxCategory taxCategory = new MTaxCategory(ctx, tax.getC_TaxCategory_ID(), trx);
			// Se debe generar únicamente en el caso de ser una alícuota de IVA (0, 10.5, 21 o 27)
			// TODO: Ejecutar el Generate Model para utilizar el método tax.isNoGravado()

			// dREHER - validar contenido nulo de isNoGravado...
			boolean isNoGravado = false;
			Object obj = tax.get_Value("IsNoGravado");
			if(obj!=null)
				isNoGravado = (Boolean)obj;

			if (taxCategory.isManual() || tax.isPercepcion() || tax.isTaxExempt() || isNoGravado)
				continue;
			// Crear nueva entrada
			AlicIva alicIva = new AlicIva();
			alicIva.setId(tax.getWSFECode());
			alicIva.setBaseImp(invoiceTax.getTaxBaseAmt().doubleValue());
			alicIva.setImporte(invoiceTax.getTaxAmt().doubleValue());
			alicsIva.add(alicIva);
		}
		return alicsIva.toArray(new AlicIva[alicsIva.size()]);
	}
	
	/** Percepciones */
	protected Tributo[] getTributos() {
		ArrayList<Tributo> tributos = new ArrayList<Tributo>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(ctx, invoiceTax.getC_Tax_ID(), trx);
			// Solo las percepciones deben contemplarse 
			if (!tax.isPercepcion())
				continue;
			// Crear nueva entrada
			Tributo tributo = new Tributo();
			tributo.setId((short)tax.getWSFECode());
			tributo.setBaseImp(invoiceTax.getTaxBaseAmt().doubleValue());
			tributo.setImporte(invoiceTax.getTaxAmt().doubleValue());
			tributo.setAlic(invoiceTax.getRate().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			tributo.setDesc(tax.getName());
			tributos.add(tributo);
		}
		return tributos.toArray(new Tributo[tributos.size()]);
	}
	
	/** Total impuestos */
	protected double getImpIVA(AlicIva[] alicsIva) {
		BigDecimal total = BigDecimal.ZERO;
		for (AlicIva alicIva : alicsIva)
			total = total.add(new BigDecimal(alicIva.getImporte()));
		return total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Total percepciones */
	protected double getImpTrib(Tributo[] tributos) {
		BigDecimal total = BigDecimal.ZERO;
		for (Tributo tributo : tributos)
			total = total.add(new BigDecimal(tributo.getImporte()));
		return total.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Punto de venta */
	protected short getPtoVta() {
		return (short)inv.getPuntoDeVenta();
	}
	
	/** Nombre o Razon Social del Cliente */
	protected String getCliente() {
		return partner.getName();
	}
	
	/** Retorna el domicilio del cliente */
	protected String getDomicilioCliente() {
		return inv.getInvoice_Adress();
	}
	
	/**  
	 * Retorna nro de identificacion de cliente
	 * dREHER
	 */
	protected String getNroIdentificacion() {
		return inv.getNroIdentificCliente();
	}

	/** Nomina de opcionales a enviar, si es que corresponde */ 
	protected Opcional[] getOpcionales() throws Exception {
		Opcional[] retValue = null;
		int cant=0;
		// Por el momento la especificacion de opcionales se requiere para MiPyME unicamente.
		if (!docType.isMiPyME())
			return retValue;
		
		ArrayList<Opcional> options = new ArrayList<Opcional>();
		// Opcional anulacion. Si el tipo de comprobante que está autorizando es MiPyMEs (FCE), Factura (201,206, 211), no informar Código de Anulación
		if (docType.isMiPyME() && isNCNDMiPyME()) {
			cant++;
			Opcional opcionalAnulacion = new Opcional();
			opcionalAnulacion.setId(""+LYEIConstants.WSFE_OPCIONALES_ANULACION_CODIGO);
			opcionalAnulacion.setValor((inv.isVoidProcess() || inv.get_ValueAsString("HTS_CreditNoteReason").equals("V")) ?"S":"N");
			options.add(opcionalAnulacion);
		}

		// Opcional CBU/Alias emisor. Si el tipo de comprobante que está autorizando es MiPyMEs (FCE), Debito (202, 207, 212) o Crédito (203, 208, 213) No informar CBU y ALIAS.
		if (docType.isMiPyME() && isFacturaMiPyME()) {

			// CBU
			if (!Util.isEmpty(genConfig.getCBUEmisor())) {
				cant++;
				Opcional opcionalCBU = new Opcional();
				opcionalCBU.setId(""+LYEIConstants.WSFE_OPCIONALES_CBU_EMISOR_CODIGO);
				opcionalCBU.setValor(genConfig.getCBUEmisor());
				options.add(opcionalCBU);
			}
			
			// Alias
			if (!Util.isEmpty(genConfig.getAliasEmisor())) {
				cant++;
				Opcional opcionalAlias = new Opcional();
				opcionalAlias.setId(""+LYEIConstants.WSFE_OPCIONALES_ALIAS_EMISOR_CODIGO);
				opcionalAlias.setValor(genConfig.getAliasEmisor());
				options.add(opcionalAlias);
			}
			
			// Se debe informar para evitar OBS 10216 Si informa comprobante MiPyMEs (FCE) del tipo Factura, es obligatorio informar por RG con ID 27 y su valor correspondiente.
			// Valores esperados: SCA = 'Sistema de Circulación Abierta' o ADC = 'Agentes de Depósito Colectivo'
			if (docType.isMiPyME() && isFacturaMiPyME()) {
				// Buscar la preferencia a nivel compañía
				String cod27 = MPreference.GetCustomPreferenceValue(LYEIConstants.WSFE_OPCIONALES_MIPYME_SCA_O_ADC_PREFERENCE, inv.getAD_Client_ID());
				if (cod27==null || cod27.length()==0) {
					// Buscar la preferencia a nivel sistema
					cod27 = MPreference.GetCustomPreferenceValue(LYEIConstants.WSFE_OPCIONALES_MIPYME_SCA_O_ADC_PREFERENCE);
					// Si la preferencia no esta definida indicar el error
					if (cod27==null || cod27.length()==0) {	
						throw new Exception ("Para comprobante MiPyMEs (FCE) del tipo Factura debe especificar SCA (Sistema de Circulación Abierta) o ADC (Agentes de Depósito Colectivo) mediante una preferencia con nombre: LYEI_WSFE_OPCIONALES_MIPYME_SCA_O_ADC");
					}
				}
				cant++;
				Opcional opcionalAlias = new Opcional();
				opcionalAlias.setId(""+LYEIConstants.WSFE_OPCIONALES_MIPYME_SCA_O_ADC_CODIGO);
				opcionalAlias.setValor(cod27);
				options.add(opcionalAlias);
			}
		}
		
		if (cant>0) {
			retValue = new Opcional[cant];
			options.toArray(retValue);
		}
		return retValue;
	}

	/** Nomina de asociados a enviar, si es que corresponde */
	protected CbteAsoc[] getAsociados() {
		CbteAsoc[] retValue = null;
		int cant=0;
		
		// Se comenta por error 10197
		// Por el momento la especificacion de asociados se requiere para MiPyME unicamente.
		/*if (!docType.isMiPyME())
			return retValue;*/
		
		ArrayList<CbteAsoc> asociados = new ArrayList<CbteAsoc>();
		// Se comenta por error 10197
		// Solo informar si estoy registrando NC/ND MiPyME
		//if (isNCNDMiPyME() && inv.getC_Invoice_Orig_ID()>0) {
		if (invioceHasOriginalDocument()) {
			int tipoCbteOrig = -1;
			int nroCbteOrig = -1 ;
			int ptoVtaCbteOrig = -1;
			String fechaCbteOrig = "";
			
			// Se especificó referencia directa a un comprobante?
			if (inv.getOrigInvFecha()!=null &&
					inv.getOrigInvNro()>0 && 
					inv.getOrigInvPtoVta()>0 &&
					!Util.isEmpty(inv.getOrigInvTipo())) {
				// Se especificó referencia manual mediante los 4 campos
		        nroCbteOrig = inv.getOrigInvNro();
		        ptoVtaCbteOrig = inv.getOrigInvPtoVta();
		        fechaCbteOrig = new SimpleDateFormat("yyyyMMdd").format(new Date(inv.getOrigInvFecha().getTime()));
		        tipoCbteOrig = Integer.parseInt(inv.getOrigInvTipo());
			} else {
				MInvoice origInv = new MInvoice(ctx, inv.getC_Invoice_Orig_ID(), trx);
				MDocType origInvDT = new MDocType(ctx, origInv.getC_DocTypeTarget_ID(), trx);
				String subType = origInvDT.getdocsubtypecae();
				if(subType==null || subType.isEmpty()) {
					System.out.println("Documento original=" + origInvDT.getName() + " " + origInv.getDocumentNo() + " - El tipo de documento asociado NO esta correctamente configurado. DocSubTypeCAE=null");
					return null;
				}
					
				int tipo = Integer.parseInt(subType);
					        
		        nroCbteOrig = origInv.getNumeroComprobante();
		        ptoVtaCbteOrig = origInv.getPuntoDeVenta();
		        fechaCbteOrig = new SimpleDateFormat("yyyyMMdd").format(new Date(origInv.getDateAcct().getTime()));
		        tipoCbteOrig = tipo;
			}
			CbteAsoc asoc = new CbteAsoc();
			asoc.setCuit(genConfig.getCUIT());
			asoc.setNro(nroCbteOrig);
			asoc.setPtoVta(ptoVtaCbteOrig);
			asoc.setCbteFch(fechaCbteOrig);
			asoc.setTipo(tipoCbteOrig);
			cant++;
			asociados.add(asoc);
		}
		
		if (cant>0) {
			retValue = new CbteAsoc[cant];
			asociados.toArray(retValue);
		}
		
		return retValue;
	}
	
	/** La factura tiene una referencia al documento original? (ya sea mediante c_invoice_orig_id o bien mediante los 4 campos de referencia original */
	protected boolean invioceHasOriginalDocument() {
		return 
			(
				inv.getC_Invoice_Orig_ID()>0 || 
				(
					inv.getOrigInvFecha()!=null &&
					inv.getOrigInvNro()>0 && 
					inv.getOrigInvPtoVta()>0 &&
					!Util.isEmpty(inv.getOrigInvTipo())
				)
			);
	}
	
	
	
	/** Crea el nro comprobante para el nuevo tipo de documento */
	protected String generateNroComprobanteCAEA() throws Exception {
		LP_AD_Sequence seq = new LP_AD_Sequence(ctx, docType.getDocNoSequence_ID(), trx);
		boolean prodEnv = LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod.equalsIgnoreCase(posConfig.getCurrentEnvironment()); 
		BigDecimal next = null;	
		
		// Recuperar current seq CAEA (homo / prod)
		if (prodEnv) {
			next = seq.getLYEICurrentNextCAEAProd();
		} else {
			next = seq.getLYEICurrentNextCAEAHomo();
		}

		// Incrementar next. Si next es 0 o null, setearlo a 1
		if (next==null || next.compareTo(BigDecimal.ONE)<0) {
			next = BigDecimal.ONE;
		} else {
			next = next.add(BigDecimal.ONE);
		}
		
		// Actualizar current seq CAEA (homo / prod)
		if (prodEnv) {
			seq.setLYEICurrentNextCAEAProd(next);
		} else {
			seq.setLYEICurrentNextCAEAHomo(next);
		}
		
		// Persistir y retornar
		if (!seq.save()) {
			throw new Exception ("Error al gestionar secuencia CAEA: " + CLogger.retrieveErrorAsString());
		}		
		return next.toString();
	}
	
	public String getCAE() {
		return electronicInvoiceCae;
	}


	public Timestamp getDateCae() {
		return electronicInvoiceVtoCae;
	}


	public String getErrorMsg() {
		return electronicInvoiceCaeError.toString();
	}
	
	
	public String getNroCbte() {
		return electronicInvoiceNroCbte;
	}
	
	/** Mensaje de error a devolver al usuario en caso de encontrar un problema */
	protected void setErrorByException(boolean serviceInvoked, Exception e) {
		electronicInvoiceCaeError
			.append("Error al ").append(serviceInvoked?"preparar":"registrar").append(" la factura. ")
			.append(serviceInvoked?"Verifique en AFIP la registracion de la misma.":"")
			.append(e);
	}

	/** Log de inicio actividad de solicitud de CAE */
	protected String getIniSolicitarCAEActivityLog(String endPoint) {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Iniciando FECAESolicitar para factura ")
				.append(inv.getDocumentNo()).append(" en ")
				.append(endPoint);
		return retValue.toString();
	}
	
	/** Log de actividad de conexion solicitud de CAE */
	protected String getSolicitarCAEActivityLog() {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Invocando a FECAESolicitar para factura ")
				.append(inv.getDocumentNo());
		return retValue.toString();
	}
	
	/** Log de fin actividad de solicitud de CAE */
	protected String getFinSolicitarCAEActivityLog() {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Finalizada FECAESolicitar para factura ")
				.append(inv.getDocumentNo()).append(" ")
				.append((electronicInvoiceNroCbte!=null?"NRO:"+electronicInvoiceNroCbte:"")).append(" ")
				.append((electronicInvoiceCae!=null?"CAE:"+electronicInvoiceCae:"")).append(" ")
				.append(electronicInvoiceCaeError)
				.append(getXMLRequestResponse());
		return retValue.toString();
	}
	
	/** Log de error en actividad de solicitud de CAE */
	protected String getErrSolicitarCAEActivityLog() {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Error en FECAESolicitar para factura ")
				.append((inv.getDocumentNo()!=null?inv.getDocumentNo():" Sin Nro de Comprobante aun!")).append(" ")
				.append((electronicInvoiceCaeError!=null?electronicInvoiceCaeError : " - "))
				.append(getXMLRequestResponse());
		return retValue.toString();
	}
	
	/** Log de XML request/response */
	protected String getXMLRequestResponse() {
		StringBuffer retValue = new StringBuffer();
		retValue.append(requestXML!=null?" RequestXML: "+requestXML:"")
				.append(responseXML!=null?" ResponseXML: "+responseXML:"");
		return retValue.toString();
	}
	
	/** Existe la POS/GEN configuration? */
	protected void validarPreliminares() throws Exception {
		if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()<=0)
			throw new Exception("Punto de venta sin configuracion electronica. Se requiere realizar la configuracion correspondiente.");
		if (genConfig==null || posConfig.getC_LYEIElectronicInvoiceConfig_ID()<=0)
			throw new Exception("Configuracion general de factura electronica incorrecta. Se requiere realizar la configuracion correspondiente.");	
	}

	/** Presenta la informacion a enviar al servicio completamente detallada. */
	protected String getDataToBeSent(FECAERequest caeReq) {
		StringBuffer data = new StringBuffer();

		try {
			// Cabecera
			if (caeReq.getFeCabReq()!=null) {
				data.append("FeCabReq:")
					.append(" cantReg=").append(caeReq.getFeCabReq().getCantReg()).append(",")
					.append(" cbteTipo=").append(caeReq.getFeCabReq().getCbteTipo()).append(",")
					.append(" cbtePtoVta=").append(caeReq.getFeCabReq().getPtoVta()).append("\n");
			}
			// Lineas
			if (caeReq!=null) {
				int i = 0;
				for (FECAEDetRequest req : caeReq.getFeDetReq()) {
					i++;
					if (req==null) 
						continue;
					// Detalle de linea				
					data.append("FeDetReq_").append(i).append(":")
						.append(" cbteDesde=").append(req.getCbteDesde()).append(",")
						.append(" cbteFch=").append(req.getCbteFch()).append(",")
						.append(" cbteHasta=").append(req.getCbteHasta()).append(",")
						.append(" concepto=").append(req.getConcepto()).append(",")
						.append(" docNro=").append(req.getDocNro()).append(",")
						.append(" docTipo=").append(req.getDocTipo()).append(",")
						.append(" fchServDesde=").append(req.getFchServDesde()).append(",")
						.append(" fchServHasta=").append(req.getFchServHasta()).append(",")
						.append(" fchVtoPago=").append(req.getFchVtoPago()).append(",")
						.append(" impIVA=").append(req.getImpIVA()).append(",")
						.append(" ImpNeto=").append(req.getImpNeto()).append(",")
						.append(" ImpOpEx=").append(req.getImpOpEx()).append(",")
						.append(" ImpTotal=").append(req.getImpTotal()).append(",")
						.append(" ImpTotConc=").append(req.getImpTotConc()).append(",")
						.append(" ImpTrib=").append(req.getImpTrib()).append(",")
						.append(" MonCotiz=").append(req.getMonCotiz()).append(",")
						.append(" MonId=").append(req.getMonId()).append("\n");
					
					// Alicuota de iva
					if (req.getIva()!=null) {
						int j = 0;
						for (AlicIva iva : req.getIva()) {
							j++;
							if (iva==null)
								continue;
							data.append(" AlicIva_").append(j).append(":")
								.append(" baseImp=").append(iva.getBaseImp()).append(",")
								.append(" id=").append(iva.getId()).append(",")
								.append(" importe=").append(iva.getImporte()).append("\n");
						}
					}
					
					// Tributos
					if (req.getTributos()!=null) {
						int k = 0;
						for (Tributo trib : req.getTributos()) {
							k++;
							if (trib==null)
								continue;
							data.append(" Tributo_").append(k).append(":")
								.append(" baseImp=").append(trib.getBaseImp()).append(",")
								.append(" id=").append(trib.getId()).append(",")
								.append(" importe=").append(trib.getImporte()).append(",")
								.append(" desc=").append(trib.getDesc()).append(",")
								.append(" alic=").append(trib.getAlic()).append("\n");
						}
					}
					
					// Opcionales
					if (req.getOpcionales()!=null) {
						int m = 0;
						for (Opcional opc : req.getOpcionales()) {
							m++;
							if (opc==null)
								continue;
							data.append(" Opcional_").append(m).append(":")
								.append(" id=").append(opc.getId()).append(",")
								.append(" valor=").append(opc.getValor()).append("\n");
						}
					}
					
					// Compradores
					if (req.getCompradores()!=null) {
						int n = 0;
						for (Comprador comp : req.getCompradores()) {
							n++;
							if (comp==null)
								continue;
							data.append(" Comprador_").append(n).append(":")
								.append(" docNro=").append(comp.getDocNro()).append(",")
								.append(" docTipo=").append(comp.getDocTipo()).append(",")
								.append(" porcentaje=").append(comp.getPorcentaje()).append("\n");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			data.append(" [Info incompleta por error inesperado en getDataToBeSent] ").append(e);
		}
		return data.toString();
	}
	
	/** Nomina de actividades a enviar, si es que corresponde */ 
	protected Actividad[] getActividades() throws Exception {
		Actividad[] retValue = null;
		int cant=0;
		ArrayList<Actividad> options = new ArrayList<Actividad>();
		
		// Solo se informa actividad por propiedad si 
		// dREHER se agrega validacion para el caso de que inv.getOrigInvTipo() sea nulo...
		// X_C_Invoice.ORIGINVTIPO_RemitoElectronicoCarnico = 995
		if (invioceHasOriginalDocument() && (inv.getOrigInvTipo()!=null?inv.getOrigInvTipo():"").compareTo("995") == 0) {
			String actividadCarnicaStr = MPreference.GetCustomPreferenceValue(LYEIConstants.WSFE_ACTIVIDADES_ACTIVIDAD_CARNICA, inv.getAD_Client_ID());
			if (actividadCarnicaStr == null || actividadCarnicaStr.length() == 0) {	
				throw new Exception ("Para comprobantes con Remito Cárnico Asociado debe configuar la actividad cárnica utilizando la preferencia LYEI_WSFE_ACTIVIDADES_ACTIVIDAD_CARNICA");
			}
			cant++;
			Actividad actividadCarnica = new Actividad();
			actividadCarnica.setId(Long.valueOf(actividadCarnicaStr).longValue());
			options.add(actividadCarnica);
		}
		
		if (cant>0) {
			retValue = new Actividad[cant];
			options.toArray(retValue);
		}
		return retValue;
	}
}