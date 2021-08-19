package org.libertya.locale.ar.electronicInvoice.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.axis.AxisProperties;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.openXpertya.electronicInvoice.ElectronicInvoiceInterface;
import org.openXpertya.model.MClientInfo;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MInvoiceLine;
import org.openXpertya.model.MUOM;
import org.openXpertya.util.Util;

import fexv1.dif.afip.gov.ar.ClsFEXAuthRequest;
import fexv1.dif.afip.gov.ar.ClsFEXRequest;
import fexv1.dif.afip.gov.ar.ClsFEX_LastCMP;
import fexv1.dif.afip.gov.ar.Cmp_asoc;
import fexv1.dif.afip.gov.ar.FEXResponseAuthorize;
import fexv1.dif.afip.gov.ar.FEXResponseLast_CMP;
import fexv1.dif.afip.gov.ar.Item;
import fexv1.dif.afip.gov.ar.Opcional;
import fexv1.dif.afip.gov.ar.Permiso;
import fexv1.dif.afip.gov.ar.ServiceLocator;
import fexv1.dif.afip.gov.ar.ServiceSoap;
import fexv1.dif.afip.gov.ar.ServiceSoapStub;

public class LYEIWSFEX extends LYEIWSFE implements ElectronicInvoiceInterface {

	public LYEIWSFEX(MInvoice inv) {
		super(inv);
	}

	public synchronized String generateCAE() {

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
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSFEXV1_PREFIX, posConfig.getCurrentEnvironment());
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getIniSolicitarCAEActivityLog(endPoint));

			// Conexion a WSFEXV1
			ServiceLocator locator = new ServiceLocator();
			locator.setServiceSoapEndpointAddress(endPoint);
			ServiceSoap wsfex = locator.getServiceSoap();
			((ServiceSoapStub)wsfex).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_WSFEXV1_PREFIX, posConfig.getCurrentEnvironment()));
			
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, ctx, posConfig.getCurrentEnvironment());
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// Auth request
			ClsFEXAuthRequest auth = new ClsFEXAuthRequest();
			auth.setCuit(Long.parseLong(genConfig.getCUIT())); 	// CUIT del emisor de la factura	
			auth.setToken(token);
			auth.setSign(sign);
			
			// Comprobante - Cabecera
			ClsFEXRequest cmp = new ClsFEXRequest();
			// Identificador del requerimiento. TODO: La política de uso de un identificador podría definirse según configuración (usar c_invoice_id? currentTimeMillis? Una secuencia ad_hoc?, etc)
			cmp.setId(System.currentTimeMillis());  
			// Tipo de comprobante
			cmp.setCbte_Tipo((short)LYEICommons.getCbteTipo(docType)); // 19 (facturas de exportacion), 20 (ND Exportacion) o 21 (NC Exportacion)
			// Fecha Comprobante
			cmp.setFecha_cbte(LYEICommons.getCbteFchString(inv));
			// Fecha de Pago
			// Para comprobantes tipo “19 - Facturas de Exportación” es obligatoria y debe ser igual o posterior a la del comprobante.
			// Para los que no son de tipo “19 - Facturas de Exportación” omitir la fecha de pago
			if (Integer.parseInt(MDocType.DOCSUBTYPECAE_FacturaDeExportaciónE) == LYEICommons.getCbteTipo(docType)) {
				cmp.setFecha_pago(LYEICommons.getFechaVtoString(inv));
			}
			// Forma de Pago
			cmp.setForma_pago(LYEICommons.getFormaPago(inv));
			// Punto de venta
			cmp.setPunto_vta(getPtoVta());
			// Numero de comprobante que se solicta
			cmp.setCbte_nro(getSigCbteNro(wsfex, token, sign));
			// Tipo de exportacion. 1=exportacion definitiva de bienes. 2=servicios. 4=otros
			cmp.setTipo_expo(getTipoExpo());
			// Indica si se posee documento aduanero de exportación (permiso de embarque). Valores: S, N, NULL (vacío)
			cmp.setPermiso_existente(getPermisoExistente(getTipoExpo()));
			// Pais de destino del comprobante. 
			cmp.setDst_cmp(getDstCmp());
			// Apellido y nombre o Razon Social del comprador
			cmp.setCliente(getCliente());
			// Domicilio comercial del cliente
			cmp.setDomicilio_cliente(getDomicilioCliente());
			// Clave de identificacion tributaria del comprador
			cmp.setId_impositivo(getIdImpositivo()); 
			// Codigo de moneda
			cmp.setMoneda_Id(LYEICommons.getMonId(currency));
			// Cotizacion de moneda
			cmp.setMoneda_ctz(LYEICommons.getMonCotiz(inv, ctx));
			// Importe total
			cmp.setImp_total(LYEICommons.getImpTotal(inv));
			// Idioma comprobante. 1=español. 2=ingles. 3=portugues
			cmp.setIdioma_cbte(getIdiomaCbte());
			
			// Items
			cmp.setItems(getItems());
			
			// Invocar a la generacion de CAE
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), getSolicitarCAEActivityLog());
			serviceInvoked = true;
			FEXResponseAuthorize resp = wsfex.FEXAuthorize(auth, cmp);

			// No obtuvimos respuesta alguna?
			if (resp==null) {
				throw new Exception ("No se ha obtenido unar respuesta por parte del WS de AFIP.");
			}
			requestXML = ((ServiceSoapStub)wsfex).getCallRequestXML();
			responseXML = ((ServiceSoapStub)wsfex).getCallResponseXML();
			
			
			// Obtuvimos errores?
			StringBuffer retErrors = null;
			if (resp.getFEXErr()!=null) {
				retErrors = new StringBuffer();
				if (0 != resp.getFEXErr().getErrCode() || !"OK".equalsIgnoreCase(resp.getFEXErr().getErrMsg()))
					retErrors.append("ERR: ").append(resp.getFEXErr().getErrCode()).append(" ").append(resp.getFEXErr().getErrMsg()).append(". ");
			}

			// Obtuvimos observaciones?
			StringBuffer retObs = null;
			if (resp.getFEXResultAuth()!=null && resp.getFEXResultAuth().getMotivos_Obs()!=null && resp.getFEXResultAuth().getMotivos_Obs().length()>0) {
				retObs = new StringBuffer();
				retObs.append("OBS: ").append(resp.getFEXResultAuth().getMotivos_Obs());
			}
			
			// Procesar resultado
			electronicInvoiceCaeError.append(retErrors!=null?retErrors:"").append(retObs!=null?retObs:"");
			if (resp.getFEXResultAuth()!=null) {
				// CAE recibido
				electronicInvoiceCae = resp.getFEXResultAuth().getCae();
				// FECHA VTO RECIBIDO
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			    Date parsedDate = dateFormat.parse(resp.getFEXResultAuth().getFch_venc_Cae());
				electronicInvoiceVtoCae = new java.sql.Timestamp(parsedDate.getTime());
				// NRO COMPROBANTEresp.getFEXResultAuth().getFch_venc_Cae()
				electronicInvoiceNroCbte = ""+resp.getFEXResultAuth().getCbte_nro();
			}

		} catch (Exception e) {
			setErrorByException(serviceInvoked, e);
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.SEVERE, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getErrSolicitarCAEActivityLog());
		}
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, getFinSolicitarCAEActivityLog());
		return electronicInvoiceCaeError.toString();
	}
	
	/** Retorna el siguiente valor al ultimo comprobante registrado */	
	protected long getSigCbteNro(ServiceSoap wsfex, String token, String sign) throws Exception {
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Invocando a ClsFEX_LastCMP");
		ClsFEX_LastCMP auth = new ClsFEX_LastCMP(token, sign, Long.parseLong(genConfig.getCUIT()), getPtoVta(), (short)LYEICommons.getCbteTipo(docType));		
		FEXResponseLast_CMP resp = wsfex.FEXGetLast_CMP(auth);
		MLYEIElectronicInvoiceLog.logActivity(LYEIWSFE.class, Level.INFO, inv.getC_Invoice_ID(), posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "ClsFEX_LastCMP obtenido " + resp.getFEXResult_LastCMP().getCbte_nro());
		return resp.getFEXResult_LastCMP().getCbte_nro() + 1;
	}
	
	
	/** Retorna el tipo de exportacion. Basado en WsfexV1 */
	protected short getTipoExpo() throws Exception {
		// Tiene la info la org de la factura?
		if(!Util.isEmpty(orgInfo.getExportTypeFE()))
			return Short.parseShort(orgInfo.getExportTypeFE());
		// Tiene la info la cia de la factura?
		if(!Util.isEmpty(clientInfo.getExportTypeFE()))
			return Short.parseShort(clientInfo.getExportTypeFE());
		// Elevar excepcion en cualquier otro caso
		throw new Exception("No se ha configurado el tipo de exportacion en la organizacion o la compañía");
	}
	
	/** Retorna permiso de exportacion.  Basado en WsfexV1 */
	protected String getPermisoExistente(short tipoExpo) {
		// “vacío” si el campo Cbte_Tipo es 20 ó 21 o si Cbte_Tipo es igual a 19 y el campo Tipo_expo es igual a 2 ó 4.
		// Si el tipo de exportación es "Exportación definitiva de Bienes" y el tipo de comprobante es Factura, entonces tomamos el valor de la configuración de Organización / Compañía
		if ((tipoExpo == Short.parseShort(MClientInfo.EXPORTTYPEFE_ExportaciónDefinitivaDeBienes)) && (docType.getdocsubtypecae().compareTo(MDocType.DOCSUBTYPECAE_FacturaDeExportaciónE) == 0)){
			/* Veo si la configuración es a nivel de organización. */
			if(!Util.isEmpty(orgInfo.getExportTypeFE())){
				return (orgInfo.isShipmentPermitFE() ? "S" : "N");
			}
			else{
				return (clientInfo.isShipmentPermitFE() ? "S" : "N");
			}	
		}
		return "";	
	}
	
	/** Codigo del pais destino */
	protected short getDstCmp() throws Exception {
		if (location==null || location.getCountry()==null || 
				location.getCountry().getCountryCodeFE()==null || 
				location.getCountry().getCountryCodeFE().length()==0) {
			throw new Exception("No se ha configurado el codigo de pais destino");
		}
		return Short.parseShort(location.getCountry().getCountryCodeFE());
	}
	
	/** Clave identificacion tributaria del comprador */
	protected String getIdImpositivo() {
		return partner.getTaxID();
				
	}
	
	/** Retorna el Idioma del comprobante */
	protected short getIdiomaCbte() {
		return LYEIConstants.WSFEX_IDIOMA_FACTURA_ESPANOL;
	}
	
	/** Retorna los items de detalle */
	protected Item[] getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		for (MInvoiceLine aLine : inv.getLines()) {
			MUOM uom = MUOM.get(ctx, aLine.getC_UOM_ID());
			Item item = new Item();
			item.setPro_ds(aLine.getProductName());
			item.setPro_qty(aLine.getQtyEntered());
			item.setPro_umed(Integer.parseInt(uom.getUOMCodeFE()));
			item.setPro_precio_uni(aLine.getPriceEntered());
			item.setPro_total_item(aLine.getLineTotalAmt());
			items.add(item);
		}
		return items.toArray(new Item[items.size()]);
	}
 
	/** Presenta la informacion a enviar al servicio completamente detallada. */
	protected String getDataToBeSent(ClsFEXRequest cmp) {
		StringBuffer data = new StringBuffer();
		
		try {
			// Comprobante
			data.append("ClsFEXRequest:")
				.append(" Cbte_nro=").append(cmp.getCbte_nro()).append(",")
				.append(" Cbte_Tipo=").append(cmp.getCbte_Tipo()).append(",")
				.append(" Cliente=").append(cmp.getCliente()).append(",")
				.append(" Cuit_Pais_cliente:").append(cmp.getCuit_pais_cliente()).append(",")
				.append(" Domicilio_cliente=").append(cmp.getDomicilio_cliente()).append(",")
				.append(" Dst_cmp=").append(cmp.getDst_cmp()).append(",")
				.append(" Fecha_cbte=").append(cmp.getFecha_cbte()).append(",")
				.append(" Forma_pago=").append(cmp.getForma_pago()).append(",")
				.append(" Id=").append(cmp.getId()).append(",")
				.append(" Id_impositivo=").append(cmp.getId_impositivo()).append(",")
				.append(" Idioma_cbte=").append(cmp.getIdioma_cbte()).append(",")
				.append(" Imp_total=").append(cmp.getImp_total()).append(",")
				.append(" Incoterms=").append(cmp.getIncoterms()).append(",")
				.append(" Incoterms_Ds=").append(cmp.getIncoterms_Ds()).append(",")
				.append(" Moneda_ctz=").append(cmp.getMoneda_ctz()).append(",")
				.append(" Moneda_Id=").append(cmp.getMoneda_Id()).append(",")
				.append(" Obs=").append(cmp.getObs()).append(",")
				.append(" Obs_comerciales=").append(cmp.getObs_comerciales()).append(",")
				.append(" Permiso_existente=").append(cmp.getPermiso_existente()).append(",")
				.append(" Punto_vta=").append(cmp.getPunto_vta()).append(",")
				.append(" Tipo_expo=").append(cmp.getTipo_expo()).append("\n");
			
			// Items
			if (cmp.getItems()!=null) {
				int i=0;
				for (Item item : cmp.getItems()) {
					i++;
					if (item==null)
						continue;
					data.append(" Item_").append(i).append(":")
						.append(" Pro_codigo=").append(item.getPro_codigo()).append(",")
						.append(" Pro_ds=").append(item.getPro_ds()).append(",")
						.append(" Pro_umed=").append(item.getPro_umed()).append(",")
						.append(" Pro_bonificacion=").append(item.getPro_bonificacion()).append(",")
						.append(" Pro_precio_uni=").append(item.getPro_precio_uni()).append(",")
						.append(" Pro_qty=").append(item.getPro_qty()).append(",")
						.append(" Pro_total_item=").append(item.getPro_total_item()).append("\n");
				}
			}
			
			// Cbtes asociados
			if (cmp.getCmps_asoc()!=null) {
				int i=0;
				for (Cmp_asoc asoc : cmp.getCmps_asoc()) {
					i++;
					if (asoc==null)
						continue;
					data.append(" Cmp_asoc_").append(i).append(":")
						.append(" Cbte_cuit=").append(asoc.getCbte_cuit()).append(",")
						.append(" Cbte_nro=").append(asoc.getCbte_nro()).append(",")
						.append(" Cbte_punto_vta=").append(asoc.getCbte_punto_vta()).append(",")
						.append(" Cbte_tipo=").append(asoc.getCbte_tipo()).append("\n");
				}
			}
			
			// Cbtes asociados
			if (cmp.getPermisos()!=null) {
				int i=0;
				for (Permiso perm : cmp.getPermisos()) {
					i++;
					if (perm==null)
						continue;
					data.append(" Cmp_asoc_").append(i).append(":")
						.append(" Dst_merc=").append(perm.getDst_merc()).append(",")
						.append(" Id_permiso=").append(perm.getId_permiso()).append("\n");
				}
			}
			
			// Opcionales
			if (cmp.getOpcionales()!=null) {
				int i=0;
				for (Opcional opc : cmp.getOpcionales()) {
					i++;
					if (opc==null)
						continue;
					data.append(" Opcional_").append(i).append(":")
						.append(" Id=").append(opc.getId()).append(",")
						.append(" Valor=").append(opc.getValor()).append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			data.append(" [Info incompleta por error inesperado en getDataToBeSent] ").append(e);
		}
		return data.toString();
	}

}
