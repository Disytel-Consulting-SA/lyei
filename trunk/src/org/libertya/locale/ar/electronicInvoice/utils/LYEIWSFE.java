package org.libertya.locale.ar.electronicInvoice.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.openXpertya.electronicInvoice.ElectronicInvoiceInterface;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MBPartnerLocation;
import org.openXpertya.model.MClientInfo;
import org.openXpertya.model.MCurrency;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MInvoiceTax;
import org.openXpertya.model.MLocation;
import org.openXpertya.model.MOrgInfo;
import org.openXpertya.model.MTax;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import FEV1.dif.afip.gov.ar.AlicIva;
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
	protected X_C_DocType docType;
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
		// Configuracion electronica adecuada segun el punto de venta de la factura
		posConfig = MLYEIElectronicPOSConfig.get(inv.getPuntoDeVenta(), inv.getAD_Org_ID(), ctx, null);
		// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
		if (posConfig!=null)
			genConfig = new MLYEIElectronicInvoiceConfig(ctx, posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
		// Tipo de documento
		docType = new X_C_DocType(ctx, inv.getC_DocTypeTarget_ID(), null);
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
			locator.setServiceSoapEndpointAddress(endPoint);
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
			FECAECabRequest cabReq = new FECAECabRequest(1, inv.getPuntoDeVenta(), getCbteTipo());
			
			// Comprobante - Detalle
			FECAEDetRequest detReq = new FECAEDetRequest();
			// Nro. de comprobante desde y hasta
			long cbteNro = getSigCbteNro(wsfe, auth);
			detReq.setCbteDesde(cbteNro);
			// Nro. de comprobante hasta
			detReq.setCbteHasta(cbteNro);
			// Concepto de la factura. Valores permitidos: 01 Productos. 02 Servicios. 03 Productos y Servicios.
			detReq.setConcepto(getConcepto());
			// Código   de   documento   identificatorio   del	comprador
			detReq.setDocTipo(getDocTipo());
			// Nro.  de identificación del comprador
			detReq.setDocNro(getDocNro());
			// Fecha del comprobante  (yyyymmdd). Si  no  se envía la	fecha del comprobante se   
			// asignará la fecha de proceso
			detReq.setCbteFch(getCbteFch());
			// Código de  moneda  del comprobante. Consultar método FEParamGetTiposMonedas para valores posibles
			detReq.setMonId(getMonId());
			// Cotizacion de  la  moneda  informada.  Para PES, pesos argentinos  la misma debe ser 1
			detReq.setMonCotiz(getMonCotiz());
			// Impuestos.  No deben ser enviados para comprobantes de tipo C
			AlicIva[] iva = getIva();
			double impIva = getImpIVA(iva);
			if (!X_C_DocType.DOCSUBTYPECAE_FacturasC.equals(docType.getdocsubtypecae())) {
				// Array  para  informar  las  alícuotas  y  sus importes   asociados   a   un   comprobante <AlicIva>
				detReq.setIva(iva);
				// Suma de los importes del array de IVA
				detReq.setImpIVA(impIva);
			}
			// Otros tributos
			Tributo[] tributos = getTributos();
			if (tributos!=null && tributos.length>0) {
				// Array  para  informar  los  tributos  asociados a  un  comprobante  <Tributo>.
				detReq.setTributos(tributos);
				// Suma de los importes del array de tributos
				detReq.setImpTrib(getImpTrib(tributos));
			}
			// Importe  neto    gravado.  Debe  ser  menor  o igual a Importe total y no puede ser menor a cero.
			detReq.setImpNeto(getImpNeto(impIva)); 
			// Importe total  del comprobante, Debe ser igual  a  Importe  neto  no  gravado  +  Importe 
			// exento + Importe neto gravado + todos los campos  de  IVA    al  XX%  +  Importe  de	tributos
			detReq.setImpTotal(getImpTotal());
			// Importe neto no gravado. Debe ser menor o igual a Importe total y no puede ser menor a cero. 
			// No  puede  ser  mayor  al  Importe  total  de  la operación ni menor a cero (0)
			detReq.setImpTotConc(getImpTotConc());
			// Importe  exento.  Debe  ser  menor  o  igual  a Importe total y no puede ser menor a cero
			detReq.setImpOpEx(getImpOpEx());
			
			// Invocar CAESolicitar
			FECAERequest caeReq = new FECAERequest(cabReq, new FECAEDetRequest[] {detReq});
			serviceInvoked = true;
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getSolicitarCAEActivityLog());
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getDataToBeSent(caeReq));
			FECAEResponse resp = wsfe.FECAESolicitar(auth, caeReq);
	
			// No obtuvimos respuesta alguna?
			if (resp==null) {
				throw new Exception ("No se ha obtenido unar respuesta por parte del WS de AFIP.");
			}
			
			// Obtuvimos errores?
			StringBuffer retErrors = null;
			if (resp.getErrors()!=null && resp.getErrors().length > 0) {
				retErrors = new StringBuffer("ERR: ");
				for (Err error : resp.getErrors()) {
					retErrors.append(error.getCode()).append(" ").append(error.getMsg()).append("; ");
				}
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
			setErrorByException(serviceInvoked, e);
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.SEVERE, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getErrSolicitarCAEActivityLog());
		}
		// Retornar eventuales mensajes de error (similar a version original Wsfe)
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getFinSolicitarCAEActivityLog());
		return electronicInvoiceCaeError.toString();
	}
	
	/** Retorna el siguiente valor al ultimo comprobante registrado */
	protected long getSigCbteNro(ServiceSoap wsfe, FEAuthRequest auth) throws Exception {
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Invocando a RECompUltimoAutorizado");
		FERecuperaLastCbteResponse ult = wsfe.FECompUltimoAutorizado(auth, inv.getPuntoDeVenta(), getCbteTipo());
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "RECompUltimoAutorizado obtenido " + ult.getCbteNro());
		return ult.getCbteNro() + 1L;
	}
	
	/** Retorna el numero de comprobante */
	protected long getCbteNro() {
		return inv.getNumeroComprobante();
	}
	
	/** Codigo preestablecido de AFIP segun el tipo de documento. */
	protected int getCbteTipo() throws Exception {
		int tipo = -1;
		try {
			tipo = Integer.parseInt(docType.getdocsubtypecae());
		} catch (Exception e) {
			throw new Exception ("Error al obtener el cbteTipo.  DocSubTypeCAE no especificado o incorrecto.");
		}
		return tipo;
	}

	/** Tipo de documento segun el cliente es CF o no */
	protected int getDocTipo() {
		return partner.isConsumidorFinal() ? 
					LYEIConstants.WSFE_BPARTNER_ES_CONSUMIDOR_FINAL : 
					LYEIConstants.WSFE_BPARTNER_NO_ES_CONSUMIDOR_FINAL;
	}
	
	/** Concepto de la FE segun existan productos y/o servicios en la misma */
	protected int getConcepto() {
		// TODO: VERIFICAR CORRECTITUD DE USO DE PRODUCTOS
		return LYEIConstants.WSFE_CONCEPTO_PRODUCTOS;
	}
	
	/** CUIT del cliente */
	protected long getDocNro() {
		if (partner.isConsumidorFinal()) 
			return 1L;
		return Long.parseLong(inv.getCUIT().replace("-", "").replace(" ", ""));
	}
	
	/** Fecha de la factura */
	protected String getCbteFch() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(inv.getDateAcct().getTime());
        return dateFormat.format(date);
	}
	
	/** Moneda de la factura */
	protected String getMonId() throws Exception {
		if (currency.getWSFECode()==null || currency.getWSFECode().length()==0)
			throw new Exception("No se ha configurado el codigo de la moneda");
		return currency.getWSFECode();
	}
	
	/** Cotizacion de la moneda */
	protected double getMonCotiz() {
		BigDecimal cotizacion = 
				MCurrency.currencyConvert(	Env.ONE,
											inv.getC_Currency_ID(), 
											Env.getContextAsInt(ctx, "$C_Currency_ID"), 
											inv.getDateAcct(), 
											0,
											ctx);
		return cotizacion.doubleValue();
	}
	
	/** Total de la factura */
	protected double getImpTotal() {
		return inv.getGrandTotal().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Neto de la factura */
	protected double getImpNeto(double impIva) {
		// Para facturas C no se discrimina IVA. Se considera neto+iva-tributos como neto
		if (X_C_DocType.DOCSUBTYPECAE_FacturasC.equals(docType.getdocsubtypecae())) {
			return inv.getNetAmount().add(new BigDecimal(impIva)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return inv.getNetAmount().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/** Importe exento */ 
	protected double getImpOpEx() {
		// TODO: VER QUE VALOR PASAR!
		return 0.0;
	}
	
	/** Importe neto no gravado */
	protected double getImpTotConc() {
		// TODO: VER QUE VALOR PASAR!
		return 0.0;
	}
	
	/** Impuestos */
	protected AlicIva[] getIva() {
		ArrayList<AlicIva> alicsIva = new ArrayList<AlicIva>();
		// Recorrer todos los impuestos de la factura
		for (MInvoiceTax invoiceTax : inv.getTaxes(false)){
			MTax tax = MTax.get(ctx, invoiceTax.getC_Tax_ID(), trx);
			// Las percepciones van aparte 
			if (tax.isPercepcion())
				continue;
			// Crear nueva entradda
			AlicIva alicIva = new AlicIva();
			alicIva.setId(tax.getWSFECode());
			alicIva.setBaseImp(getTaxBaseAmt(invoiceTax.getTaxBaseAmt(), inv.getGrandTotal(), inv.getTaxesAmt()).doubleValue());
			alicIva.setImporte(invoiceTax.getTaxAmt().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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
			// Crear nueva entradda
			Tributo tributo = new Tributo();
			tributo.setId((short)tax.getWSFECode());
			tributo.setBaseImp(getTaxBaseAmt(invoiceTax.getTaxBaseAmt(), inv.getGrandTotal(), inv.getTaxesAmt()).doubleValue());
			tributo.setImporte(invoiceTax.getTaxAmt().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			tributo.setAlic(invoiceTax.getRate().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
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
		double total = 0.0;
		for (Tributo tributo : tributos)
			total+=tributo.getImporte();
		return total;		
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
	
	/** Obtine el taxBaseAmt (segun WsfeV1) */
	protected BigDecimal getTaxBaseAmt(BigDecimal taxBaseAmt, BigDecimal grandTotal,	BigDecimal taxesAmt) {
		if ((Math.abs((grandTotal.subtract(taxesAmt).subtract(taxBaseAmt)).doubleValue()) >= 0.01) && (Math.abs((grandTotal.subtract(taxesAmt).subtract(taxBaseAmt)).doubleValue()) <= 0.02)){
			return (grandTotal.subtract(taxesAmt));
		}
		return taxBaseAmt;
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
				.append(electronicInvoiceCaeError);
		return retValue.toString();
	}
	
	/** Log de error en actividad de solicitud de CAE */
	protected String getErrSolicitarCAEActivityLog() {
		StringBuffer retValue = new StringBuffer();
		retValue.append("Error en FECAESolicitar para factura ")
				.append(inv.getDocumentNo()).append(" ")
				.append(electronicInvoiceCaeError);
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
}