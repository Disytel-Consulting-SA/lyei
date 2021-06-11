package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import org.libertya.locale.ar.electronicInvoice.model.LP_AD_Sequence;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIConstants;
import org.libertya.locale.ar.electronicInvoice.utils.LYEITools;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSAA;
import org.openXpertya.model.MDocType;
import org.openXpertya.process.SvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceLocator;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub;

public class LYEICAEACheckSequences extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
	
		// A partir de la configuracion del PV electronico, iterar por los tipos de documentos y para cada uno validar inicio de secuencia
		MLYEIElectronicPOSConfig posConfig = new MLYEIElectronicPOSConfig(getCtx(), getRecord_ID(), null);
		if (!posConfig.getCAEMethod().equals(LP_C_LYEIElectronicPOSConfig.CAEMETHOD_CAEA)) {
			throw new Exception("Este proceso es exclusivo para puntos de venta CAEA");
		}
		MLYEIElectronicInvoiceConfig genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
		
		StringBuffer retValue = new StringBuffer("Recuperando secuencias de tipos de documento electronicos para punto de venta ").append(posConfig.getPOS()).append("\n");
		PreparedStatement pstmt = DB.prepareStatement(
							" select * " +
							" from c_doctype " +
							" where ad_client_id = " + getAD_Client_ID() +
							" and substring(doctypekey from length(doctypekey)-3 for 4) = LPAD('" + posConfig.getPOS() + "',4,'0') " +
							" and iselectronic = 'Y' " +
							" and docsubtypeinv = 'EL' " +
							" and isfiscaldocument = 'Y' " + 
							" order by name ");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			MDocType docType = new MDocType(getCtx(), rs, null);
			LP_AD_Sequence sequence = new LP_AD_Sequence(getCtx(), docType.getDocNoSequence_ID(), null);
			retValue.append("=== Documento: ").append(docType.getName()).append(" === \n");
			
			// Check para Homologacion
			checkCAEASequences(genConfig, posConfig, docType, sequence, LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo, retValue);
			// Check para Produccion			
			checkCAEASequences(genConfig, posConfig, docType, sequence, LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod, retValue);
			retValue.append("\n");
		}			
		return retValue.toString();
	}

	/** Valida la secuencia contra AFIP para el doumento y ambiente dado */
	protected void checkCAEASequences(MLYEIElectronicInvoiceConfig genConfig, MLYEIElectronicPOSConfig posConfig, MDocType docType, LP_AD_Sequence sequence, String env, StringBuffer retValue) {

		try {
			String suffix = (env.equals(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod)?"Prod":"Homo");
			retValue.append(suffix).append(": ");
			if (!LP_C_LYEIElectronicPOSConfig.PRODUCTIONCRTSTATUS_ValidCRT.equals((env.equals(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod)?posConfig.getProductionCRTStatus():posConfig.getTestCRTStatus()))) {
				retValue.append("Omitiendo. El CRT debe ser valido \n");
				return;
			}
			
			// Pedir WSAA
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, posConfig.getCtx(), env);
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// Auth
			AuthRequestType auth = new AuthRequestType();
			auth.setCuitRepresentada(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
			auth.setSign(sign);
			auth.setToken(token);
					
			// Config de conexion al WS
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, env);		
			MTXCAServiceLocator locator = new MTXCAServiceLocator();
			locator.setMTXCAServiceHttpSoap11EndpointEndpointAddress(endPoint);
			MTXCAServicePortType caeaService = locator.getMTXCAServiceHttpSoap11Endpoint();
			((MTXCAServiceSoap11BindingStub)caeaService).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, env));

			// Info de tipo de comprobante y punto de venta
			ConsultaUltimoComprobanteAutorizadoRequestType cuca = new ConsultaUltimoComprobanteAutorizadoRequestType();
			cuca.setCodigoTipoComprobante(Short.parseShort(docType.getdocsubtypecae()));
			cuca.setNumeroPuntoVenta(posConfig.getPOS());

			// Invocar al servicio
			ConsultarUltimoComprobanteAutorizadoRequestType parameters = new ConsultarUltimoComprobanteAutorizadoRequestType();
			parameters.setAuthRequest(auth);
			parameters.setConsultaUltimoComprobanteAutorizadoRequest(cuca);
			ConsultarUltimoComprobanteAutorizadoResponseType response = caeaService.consultarUltimoComprobanteAutorizado(parameters);
			
			// Errores?
			if (response.getArrayErrores()!=null && response.getArrayErrores().length>0) {
				retValue.append("Omitiendo. Respuesta de AFIP: ");
				for (CodigoDescripcionType error : response.getArrayErrores()) {
					retValue.append(error.getDescripcion()).append(". ");
				}
				retValue.append("\n");
				return;
			}
			
			// Todo OK?
			Long localCbteNro = getOldNroCbte(sequence, suffix); 
			Long afipCbteNro = response.getNumeroComprobante();

			// Si son iguales omitir 
			if (localCbteNro!=null && afipCbteNro!=null && localCbteNro.equals(afipCbteNro)) {
				retValue.append("Omitiendo. Valor local y AFIP coinciden: ").append(localCbteNro).append(". \n");
				return;
			}
			
			// Si hay discrepancia notificar 
			if (localCbteNro!=null && afipCbteNro!=null && !localCbteNro.equals(afipCbteNro)) {
				retValue.append("Omitiendo. DISCREPANCIA!. Valor local: ").append(localCbteNro).append(", Valor AFIP: ").append(afipCbteNro).append(". Valide manualmente. \n");
				return;
			}
			
			// Si valor actual no definido y recibimos un valor de AFIP, entonces asignarlo en la secuencia
			sequence.setLYEICurrentNextCAEAHomo(new BigDecimal(afipCbteNro));
			if (!sequence.save()) {
				retValue.append("Error al guardar en secuencia: ").append(CLogger.retrieveErrorAsString()).append(".");
			} else {
				retValue.append("Valor especificado en secuencia OK (").append(afipCbteNro).append(").");
			}
			retValue.append("\n");
		
		} catch (Exception e) {
			retValue.append("Excepcion en el procesamiento: ").append(e.getMessage()).append("\n");
		}
		
	}
	
	/** Dada una secuencia y un ambiente retorna el actual valor de nro cbte CAEA */
	protected Long getOldNroCbte(LP_AD_Sequence sequence, String suffix) {
		try {
			return ((BigDecimal)sequence.get_Value("LYEICurrentNextCAEA"+suffix)).longValue();
		} catch (Exception e) {
			return null;
		}
	}
	
}
