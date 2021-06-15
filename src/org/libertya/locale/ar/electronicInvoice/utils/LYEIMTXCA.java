package org.libertya.locale.ar.electronicInvoice.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEICAEARequest;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.openXpertya.model.MInvoice;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

import ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceLocator;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType;
import ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub;
import ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEARequestType;
import ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.SolicitudCAEAType;

public class LYEIMTXCA {

	/** Factura asociada a la invocacion (si es que existe) */
	protected MInvoice inv = null;
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig = null;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig = null;
	/** Periodo destino para el cual hacer el request */
	protected Integer periodo = null;
	/** Orden destino para el cual hacer el request */
	protected Short orden = null;
	/** Registro con el CAEA obtenido */
	LP_C_LYEICAEARequest currentCAEA = null;
	/** Contexto */
	protected Properties ctx = null;
	/** Recuperamos un CAEA ya solicitado? */
	protected boolean cachedCAEA = false;
	
	/** Instanciar CAEA a partir de compañía/organizacion 
	 *  Se utiliza cuando se desea obtener un CAEA sin estar completando una factura (proceso croneado por ejemplo).
	 *  El posConfig a recuperar sera alguno disponible para que tenga certificado valido para el ambiente (homo / prod)
	 *  El periodo y orden se toman a partir de la fecha actual, a menos que se fuerce a uno distinto mediante los argumentos
	 *	@param clientID compañía
	 *	@param orgID organizacion
	 *  @param prodEnv si es el ambiente de produccion. si es falso sera el de homo
	 *  @param currentPeriod periodo actual o siguiente?
	 *  @param nombre de la transaccion, si corresponde
	 */
	public LYEIMTXCA(int clientID, int orgID, boolean prodEnv, boolean currentPeriod, Properties ctx) throws Exception {
		this.ctx = ctx;
		setPeriodoOrden(currentPeriod, null);
		posConfig = getPosConfig(clientID, orgID, prodEnv);
	}
		
	/** Obtener CAEA a partir de factura. 
	 *  Se utiliza cuando se desea obtener un CAEA al momento de estar emitiendo una factura
	 *  El posConfig a recuperar estara determinado por el punto de venta de la factura 
	 *  El periodo y orden se toman a partir de la fecha de la factura
	 *  @param currentPeriod periodo actual o siguiente?
	 */
	public LYEIMTXCA(MInvoice inv) {
		this.ctx = inv.getCtx();
		setPeriodoOrden(true, inv);
		posConfig = MLYEIElectronicPOSConfig.get(inv.getPuntoDeVenta(), inv.getAD_Org_ID(), inv.getCtx(), null);
	}
	
	/**
	 * Asigna el periodo y orden segun la informacion suministrada
	 * Si se recibe una factura, toma la fecha de la factura como fecha base.
	 * Si no se recibe una factura, toma la fecha actual
	 * @param currentPeriod permite especificar si debe obtenerse para el periodo actual (a partir de la fecha base) o bien para el siguiente periodo.
	 */
	protected void setPeriodoOrden(boolean currentPeriod, MInvoice invoice) {
		/* Fecha de base es la fecha actual? */
		String trxName = null;
		String baseTime = "now()";
		String clause = "";
		if (invoice!=null) {
			/* Fecha de base es la fecha de la factura */
			trxName = invoice.get_TrxName();
			baseTime = "dateinvoiced";
			clause   = "from c_invoice where c_invoice_id = " + invoice.getC_Invoice_ID();
		}
		
		/* Asignacion de periodo: YYYYMM */
		periodo = DB.getSQLValue(trxName, "select (date_part('year', "+baseTime+")::varchar || lpad(date_part('month', "+baseTime+")::varchar, 2, '0'))::int " + clause);

		/* Asignacion de orden: 1 o 2. */ 
		// "Habrá dos quincenas, la primera abarca desde el primero hasta el quince de cada mes y la segunda desde el dieciséis hasta el último día del mes"
		orden = (short)DB.getSQLValue(trxName, "select case when date_part('day', "+baseTime+") <= 15 then 1 else 2 end " + clause);
		
		// Debe pedirse para el siguiente periodo? YYYYMMPP puede pasar a YYYY MM P+1 o YYYY MM+1 P-1 o YYYY+1 01 1
		// Ejemplos: 202112-1 -> 202112-2  //  202112-2 -> 202201-1
		if (!currentPeriod) {
			// Siguiente periodo implica actualizar el orden de la quincena: YYYY MM 1 -> YYYY MM 2
			if (orden == 1) {
				orden = 2;
			} else {
				// El orden era 2? Vuelve a ser uno  YYYY MM 2 -> YYYY MM+1 1 
				orden = 1;
				// Llegamos al final del año? YYYY 12 2 -> YYYY+1 01 1
				if (periodo.toString().endsWith("12")) {
					periodo = periodo + 89;
				} else {
					// No llegamos a fin de año, simplemente incrementar uno  YYYY MM 2 -> YYYY MM+1 1
					periodo = periodo + 1;
				}
			}
		}
	}
	
	/**
	 * Efectiviza la solicitud de un CAEA.
	 * Primeramente valida si ya existe un CAEA solicitado para el periodo en cuestion
	 * @throws Exception en caso de encontrarse con algun error
	 */
	public void requestCAEA() throws Exception {
				
		try {
			// Configuracion electronica general asociada al pto vta. De no existir luego se eleva excepcion
			if (posConfig==null || posConfig.getC_LYEIElectronicPOSConfig_ID()==0) {
				throw new Exception("Configuracion de punto de venta electronico nulo o no inicializado correctamente");		
			}
			genConfig = new MLYEIElectronicInvoiceConfig(posConfig.getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
	
			// El periodo fue asignado?
			if (periodo==null)
				throw new Exception("Periodo especificado incorrectamente");
			// El orden fue asignado?
			if (orden==null)
				throw new Exception("Orden especificado incorrectamente");
			
			// Ya existe el CAEA para el periodo y ambiente en cuestion? Dejarlo cargado para su uso 
			currentCAEA = findCAEA();
			if (currentCAEA!=null && currentCAEA.getC_LYEICAEARequest_ID()>0 && !Util.isEmpty(currentCAEA.getCAEA())) {
				cachedCAEA = true;
				return;
			}
			
			// No existe localmente, pedir nuevo CAEA
			MLYEIElectronicInvoiceLog.logActivity(LYEIMTXCA.class, Level.INFO, inv!=null?inv.getC_Invoice_ID():null, posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Obteniendo nuevo CAEA. Periodo:" + periodo + ". Orden:" + orden);
			
			// token & sign
			HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, posConfig.getCtx(), posConfig.getCurrentEnvironment());
			String token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
			String sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
			
			// Auth
			AuthRequestType auth = new AuthRequestType();
			auth.setCuitRepresentada(Long.parseLong(genConfig.getCUIT().replace("-", "").replace(" ", "")));
			auth.setSign(sign);
			auth.setToken(token);
			
			// Solicitud
			SolicitudCAEAType solicitud = new SolicitudCAEAType();
			solicitud.setPeriodo(periodo);
			solicitud.setOrden(orden);
			
			// Armar el Request
			SolicitarCAEARequestType requestParams = new SolicitarCAEARequestType();
			requestParams.setSolicitudCAEA(solicitud);
			requestParams.setAuthRequest(auth);
			
			// Efectivizar la invocacion
			String endPoint = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment());
			// Conexion al servicio		
			MTXCAServiceLocator locator = new MTXCAServiceLocator();
			locator.setMTXCAServiceHttpSoap11EndpointEndpointAddress(endPoint);
			MTXCAServicePortType caeaService = locator.getMTXCAServiceHttpSoap11Endpoint();
			((MTXCAServiceSoap11BindingStub)caeaService).setTimeout(LYEITools.getTimeout(LYEIConstants.EXTERNAL_SERVICE_MTXCA_PREFIX, posConfig.getCurrentEnvironment()));
			// Invocacion a la operacion
			SolicitarCAEAResponseType response = caeaService.solicitarCAEA(requestParams);
	
			/* === Procesar la respuesta === */
			// Hubo respuesta?
			if (response==null) {
				throw new Exception("Sin respuesta por parte de AFIP");
			}
			
			// Hubo errores?
			String errors = LYEICommons.stringFromArray(response.getArrayErrores()); 
			if (errors!=null) {
				throw new Exception(errors);
			}
			
			// Hubo CAEResponse?			
			if (response.getCAEAResponse()==null) {
				throw new Exception("Sin CAEResponse por parte de AFIP");
			}

			// CAEA Recupearado ok
			MLYEIElectronicInvoiceLog.logActivity(LYEIMTXCA.class, Level.INFO, inv!=null?inv.getC_Invoice_ID():null, posConfig.getC_LYEIElectronicPOSConfig_ID(), genConfig.getC_LYEIElectronicInvoiceConfig_ID(), "CAEA obtenido: " + response.getCAEAResponse().getCAEA());
			
			// Almacenar en el historico de CAEAs aceptados
			currentCAEA = new LP_C_LYEICAEARequest(posConfig.getCtx(), 0, null); 
			// Compañía y organizacion
			currentCAEA.setClientOrg(Env.getAD_Client_ID(posConfig.getCtx()), Env.getAD_Org_ID(posConfig.getCtx()));
			// CAEA Obtenido
			currentCAEA.setCAEA(""+response.getCAEAResponse().getCAEA());
			// Periodo correspondiente
			currentCAEA.setPeriodo(response.getCAEAResponse().getPeriodo());
			// Orden correspondiente		
			currentCAEA.setOrden(response.getCAEAResponse().getOrden());
			// CAEA valido desde Fecha
			currentCAEA.setFechaDesde(new Timestamp(response.getCAEAResponse().getFechaDesde().getTime()));
			// CAEA valido hasta Fecha		
			currentCAEA.setFechaHasta(new Timestamp(response.getCAEAResponse().getFechaHasta().getTime()));
			// Fecha limite para informar documentos con este CAEA		
			currentCAEA.setFechaTopeInforme(new Timestamp(response.getCAEAResponse().getFechaTopeInforme().getTime()));
			// Ambiente de ejecucion (homo o prod)
			currentCAEA.setEnvironment(posConfig.getCurrentEnvironment());
			// Posibles observaciones
			String obs = LYEICommons.stringFromArray(response.getCAEAResponse().getArrayObservaciones());
			if (obs!=null) {
				currentCAEA.setObservaciones(obs);
			}
			// Persistir
			if (!currentCAEA.save()) {
				throw new Exception("Error al persistir registro de CAEARequest para el CAEA obtenido: " + CLogger.retrieveErrorAsString());
			}
		} catch (Exception e) {
			MLYEIElectronicInvoiceLog.logActivity(LYEIMTXCA.class, Level.SEVERE, inv!=null?inv.getC_Invoice_ID():null, posConfig!=null?posConfig.getC_LYEIElectronicPOSConfig_ID():null, genConfig!=null?genConfig.getC_LYEIElectronicInvoiceConfig_ID():null, e.getMessage());
			throw e;
		}
	}
	
	/** Recupera un posConfig que se encuentre activo y tenga el certificado valido */
	protected MLYEIElectronicPOSConfig getPosConfig(int clientID, int orgID, boolean prodEnv) throws Exception {
		// Buscar un pto de venta electronico activo, valido y correctamente configurado para el ambiente destino
		PreparedStatement pstmt = DB.prepareStatement(		
										" SELECT pc.* " +
										" FROM C_LYEIElectronicPOSConfig pc " +
										" INNER JOIN C_LYEIElectronicInvoiceConfig ic ON pc.C_LYEIElectronicInvoiceConfig_ID = ic.C_LYEIElectronicInvoiceConfig_ID " +
										" WHERE pc.AD_Client_ID = " + clientID +
										(orgID>0? " AND pc.AD_Org_ID = " + orgID : "") +
										" AND pc.isactive = 'Y' " +
										" AND pc.caemethod = 'A' " + // Debe ser de tipo CAEA
										" AND pc." + (prodEnv?"production":"test") + "crtstatus = 'V' " + // Debe tener el certificado valido
										" LIMIT 1"
									);
		ResultSet rs = pstmt.executeQuery();
		
		// Tenemos algun resultado?
		if (!rs.next()) 
			throw new Exception("No se ha encontrado un punto de venta electronico de tipo CAEA activo con certificado valido en " + (prodEnv?"produccion":"homologacion") + " para la organizacion y compañía especificados.");
		return new MLYEIElectronicPOSConfig(ctx, rs, null);
	}
	
	
	/** Busca un caea ya requerido para el periodo y orden configurados */
	protected LP_C_LYEICAEARequest findCAEA() throws Exception {
		PreparedStatement pstmt = DB.prepareStatement(		
									" SELECT * " +
									" FROM C_LYEICAEAREQUEST " +
									" WHERE ad_client_id = " + Env.getAD_Client_ID(ctx) +
									" AND isactive = 'Y' " +
									" AND environment = '" + posConfig.getCurrentEnvironment() + "' " +  
									" AND periodo = " + periodo +
									" AND orden = " + orden);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return new LP_C_LYEICAEARequest(ctx, rs, null);
		return null;
	}
	
	/** Retorna el potencial CAEA Request previamente recuperado */
	public LP_C_LYEICAEARequest currentCAEA() {
		return currentCAEA;
	}

	public boolean isCachedCAEA() {
		return cachedCAEA;
	}
	
}

