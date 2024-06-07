package org.libertya.locale.ar.electronicInvoice.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axis.AxisProperties;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_ExternalService;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceLog;
import org.openXpertya.model.MPreference;
import org.openXpertya.model.PO;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS;
import ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMSServiceLocator;
import ar.gov.afip.wsaa.ws.services.LoginCms.LoginCmsSoapBindingStub;

public class LYEIWSAA {
	
	/** Token del TA */
	public static final String TA_TOKEN = "token";
	/** Sign del TA */
	public static final String TA_SIGN = "sign";
	
	/** ServiceName - dREHER */
	public static String ServiceName = null;
	
	/** Guardar compatibilidad con todas las llamadas existentes */
	// dREHER
	//public static synchronized HashMap<String, String> getTokenAndSign(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv) throws Exception {
		//return getTokenAndSign(aConfig, ctx, targetEnv, null);
	//}
	
	
	/** 
	 * Recupera el TA actual y lo devuelve.  Si está vencido, obtiene uno nuevo
	 * @throws Exception en caso de error
	 */
	public static synchronized HashMap<String, String> getTokenAndSign(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv) throws Exception {
		
		// dREHER
		ServiceName = null;
		
		// Recuperar el TA actual
		byte[] ta = getTA(aConfig, ctx, targetEnv);
		
		// Valores de retorno
		HashMap<String, String> retValue = new HashMap<String, String>();
		
		// Parse del TA.xml
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(ta));

		// Token
		NodeList tokenNodes = doc.getElementsByTagName("token");
		retValue.put(TA_TOKEN, (tokenNodes.item(0).getFirstChild().getNodeValue()));
		
		// Sign
		NodeList signNodes = doc.getElementsByTagName("sign");
		retValue.put(TA_SIGN, (signNodes.item(0).getFirstChild().getNodeValue()));
		
		return retValue;
	}
	
	/** 
	 * Recupera el TA actual y lo devuelve.  Si está vencido, obtiene uno nuevo
	 * @throws Exception en caso de error
	 * 
	 * 
	 * dREHER - siempre genera un nuevo TA para el servicio especificado...
	 */
	public static synchronized HashMap<String, String> getNewTokenAndSign(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv, String serviceName) throws Exception {

		ServiceName = serviceName;
		
		// Valores de retorno
		HashMap<String, String> retValue = new HashMap<String, String>();
		
		// newTA(aConfig, ctx, targetEnv);
		// TODO: el CRT de Servicio Externo, debe ser validado al igual que los de facturacion electronica para guardar el CRT correspondiente
		
		
		// Recuperar el TA actual
		byte[] ta = getTA(aConfig, ctx, targetEnv, ServiceName);
		
		
		// Parse del TA.xml
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		System.out.println("TA: " + ta);
		Document doc = builder.parse(new ByteArrayInputStream(ta));

		// Token
		NodeList tokenNodes = doc.getElementsByTagName("token");
		retValue.put(TA_TOKEN, (tokenNodes.item(0).getFirstChild().getNodeValue()));
		
		// Sign
		NodeList signNodes = doc.getElementsByTagName("sign");
		retValue.put(TA_SIGN, (signNodes.item(0).getFirstChild().getNodeValue()));
		
		return retValue;
	}
	
	/** Intenta utilizar el TA actual, si no sirve, genera uno nuevo basado en Servicio Externo NO configuracion factura electronica 
	 *  dREHER
	 * 
	 */
	public static synchronized byte[] getTA(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv, String serviceName) throws Exception {
		String clave = getClaveSE(serviceName, targetEnv);
		byte[] ta = null;
		
		// Recuperar el TA actual
		LP_C_ExternalService es = getExternalService(clave);
		if(es!=null) 
			ta = (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv)?es.getHomoTA():es.getProdTA());
		
		// Ya expiró?
		if (requiresNewTA(ta)) {
			// Verificar si existe otros POSConfig con igual CRT que no tenga el TA expirado
			// ta = findTA(aConfig, ctx, targetEnv);
			// Si no se encontró un TA no expirado, obtener uno nuevo
			System.out.println("Expiro TA, requiere uno nuevo!");
			// if (ta == null)
			ta = newTA(aConfig, ctx, targetEnv, serviceName);
		}
		
		return ta;
	}
	
	/** Intenta utilizar el TA actual, si no sirve, genera uno nuevo */
	public static synchronized byte[] getTA(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv) throws Exception {
		// Recuperar el TA actual
		byte[] ta = LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? aConfig.getHomoTA() : aConfig.getProdTA();
		// Ya expiró?
		if (requiresNewTA(ta)) {
			// Verificar si existe otros POSConfig con igual CRT que no tenga el TA expirado
			ta = findTA(aConfig, ctx, targetEnv);
			// Si no se encontró un TA no expirado, obtener uno nuevo
			if (ta == null)
				ta = newTA(aConfig, ctx, targetEnv);
		}
		return ta;
	}
	
	/** Busca la existencia de un TA que todavía no expiró entre los */
	public static synchronized byte[] findTA(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv) throws Exception {
		// Recuperar todos los POSConfigIDs con igual CRT en busca de uno con TA no expirado
		int[] posConfigIDs = PO.getAllIDs(LP_C_LYEIElectronicPOSConfig.Table_Name, 
											" C_LYEIElectronicInvoiceConfig_ID =  " + aConfig.getC_LYEIElectronicInvoiceConfig_ID() + 
											" AND C_LYEIElectronicPOSConfig_ID <> " + aConfig.getC_LYEIElectronicPOSConfig_ID() +
											" AND CAEMethod = '" + aConfig.getCAEMethod() + "'" +
											" AND " + getCRTColumnName(targetEnv) + " IS NOT NULL " + 
											" AND " + getCRTColumnName(targetEnv) + " = (select " + getCRTColumnName(targetEnv) + 
											" 											 from C_LYEIElectronicPOSConfig " +
											"											 where C_LYEIElectronicPOSConfig_ID = " + aConfig.getC_LYEIElectronicPOSConfig_ID() +
											"											)",
										null);
		// No hubo suerte?
		if (posConfigIDs==null)
			return null;
		
		// Iterar hasta encontrar uno con TA no expirado, bajo el ambiente actual. IMPORTANTE: DEBE COINCIDIR EL CRT
		for (int curPosConfigID : posConfigIDs) {
			LP_C_LYEIElectronicPOSConfig curPOSConfig = new LP_C_LYEIElectronicPOSConfig(ctx, curPosConfigID, null);
			// Comparación bajo ambiente de homologación 
			if (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv)  && aConfig.getPOSService().equals(curPOSConfig.getPOSService()))  {
				if (!requiresNewTA(curPOSConfig.getHomoTA())) {
					aConfig.setHomoTA(curPOSConfig.getHomoTA());
					aConfig.save();
					return aConfig.getHomoTA();
				}
			} 
			// Comparación bajo ambiente de producción 
			if (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod.equals(targetEnv)  && aConfig.getPOSService().equals(curPOSConfig.getPOSService()))  {
				if (!requiresNewTA(curPOSConfig.getProdTA())) {
					aConfig.setProdTA(curPOSConfig.getProdTA());
					aConfig.save();
					return aConfig.getProdTA();
				}
			}
		}
		return null;
	}
	
	/**
	 * Obtiene un nuevo TA valido para acceso a servicios de Factura Electronica para un TPV dado. 
	 * El mismo queda almacenado en el registro de POSconfiguración para su utilización cuando sea necesario 
	 * @return el TA obtenido
	 * @throws exception en caso de error
	 */
	public static synchronized byte[] newTA(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv) throws Exception {
		return newTA(aConfig, ctx, targetEnv, null);
	}
	
	/**
	 * Obtiene un nuevo TA valido para acceso a servicios de Factura Electronica para un TPV dado. 
	 * El mismo queda almacenado en el registro de POSconfiguración para su utilización cuando sea necesario 
	 * @return el TA obtenido
	 * @throws exception en caso de error
	 * 
	 * dREHER sobrecargo para poder indicar el servicio a validar
	 */
	public static synchronized byte[] newTA(LP_C_LYEIElectronicPOSConfig aConfig, Properties ctx, String targetEnv, String serviceName) throws Exception {
		String requestXML = null;
		String responseXML = null;
		LoginCMS login = null;
		try {
			
			ServiceName = serviceName;
			
			// Forzar TLS 1.2 si es que existe el factory correspondiente
			try {
				Class.forName("org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
				AxisProperties.setProperty("axis.socketSecureFactory", "org.libertya.locale.ar.electronicInvoice.utils.TLS12SocketFactory");
			} catch (Exception e) { /* Nada por hacer. Utilizar la version de SSL por defecto */}
			
			// Conectar al servicio WSAA (homo o prod segun corresponda)
			String endPointAddress = LYEITools.getEndPointAddress(LYEIConstants.EXTERNAL_SERVICE_WSAA_PREFIX, targetEnv);
			LoginCMSServiceLocator locator = new LoginCMSServiceLocator();
			locator.setLoginCmsEndpointAddress(endPointAddress);

			System.out.println("newTA. ServiceName=" + ServiceName + " endPointAddress:" + endPointAddress);
			
			// Obtener un TA valido
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSAA.class, Level.INFO, null, aConfig.getC_LYEIElectronicPOSConfig_ID(), aConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Invocando a loginCms para POS " + aConfig.getPOS() + " en " + endPointAddress);
			login = locator.getLoginCms();
			String response = login.loginCms(generateTRABase64(aConfig, ctx, targetEnv));
			if (response==null) 
				throw new Exception("Sin respuesta desde WSAA");

			// dREHER evalua donde guardar el TA obtenido
			if(ServiceName==null) {
				// Almacenar en el registro correspondiente al punto de venta el TA (homo o prod)
				if (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv))
					aConfig.setHomoTA(response.getBytes());
				else
					aConfig.setProdTA(response.getBytes());
				if (!aConfig.save()) {
					throw new Exception ("Error al almacenar el TA: " + CLogger.retrieveErrorAsString());
				}
			}else {
				// dREHER
				/** guarda en el servicio externo para evitar tener que configurar uno por cada punto de venta */
				if(!saveTA2SE(ServiceName, targetEnv, response.getBytes()))
					throw new Exception ("Error al almacenar el TA en Servicio Externo: " + ServiceName + " " + targetEnv + " " + CLogger.retrieveErrorAsString());
			}

			// Ademas de almacenarlo, retornarlo
			return response.getBytes();
		} catch (Exception e) {
			if (login!=null) {
				requestXML = ((LoginCmsSoapBindingStub)login).getCallRequestXML();
				responseXML = ((LoginCmsSoapBindingStub)login).getCallResponseXML();
			}
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSAA.class, Level.INFO, null, aConfig.getC_LYEIElectronicPOSConfig_ID(), aConfig.getC_LYEIElectronicInvoiceConfig_ID(), "Error al obtener nuevo TA. " + e.toString() + (requestXML!=null?" RequestXML: "+requestXML:"") + (responseXML!=null?" ResponseXML: "+responseXML:""));
			throw new Exception("Error al obtener nuevo TA. " + e.toString());
		}
	}
	
	/**
	 * 
	 * @param serviceName2
	 * @param targetEnv
	 * @return clave del servicio externo segun nombre de servicio y entorno
	 * dREHER
	 */
	protected static String getClaveSE(String serviceName2, String targetEnv) {
		String clave = "";

		if(serviceName2.equals(LYEIConstants.AFIP_SERVICE_WSCI)) {
			clave = "WSCI_";
		}else if(serviceName2.equals(LYEIConstants.AFIP_SERVICE_WSFECRED)) {
			clave = "WSFECRED_";
		}
		if(targetEnv.equals("H"))
			clave += "HOMO";
		else
			clave += "PROD";
		
		return clave;
	}
	
	/**
	 * 
	 * @param serviceName2
	 * @param targetEnv
	 * @return clave del servicio externo segun nombre de servicio y entorno
	 * dREHER
	 */
	public static String getServiceFromClaveSE(String clave) {
		String serviceName = "";

		if(clave.equals("WSCI_HOMO") || clave.equals("WSCI_PROD"))
				serviceName = LYEIConstants.AFIP_SERVICE_WSCI;
		else if(clave.equals("WSFECRED_HOMO") || clave.equals("WSFECRED_PROD"))
				serviceName = LYEIConstants.AFIP_SERVICE_WSFECRED;
		
		return serviceName;
	}
	
	/**
	 * Devuelve el servicio externo correspondiente al servicio y entorno correspondiente
	 * @param clave
	 * @return
	 * dREHER
	 */
	protected static LP_C_ExternalService getExternalService(String clave) {
		int C_ExternalService_ID = DB.getSQLValue(null, "SELECT C_ExternalService_ID FROM C_ExternalService WHERE Value=? AND isActive='Y'", clave);
		if(C_ExternalService_ID > 0) 
			return new LP_C_ExternalService(Env.getCtx(), C_ExternalService_ID, null);
		else
			return null;
	}
	
	/**
	 * 
	 * @param serviceName2 wsfecred / ws_sr_padron_a5
	 * @param targetEnv
	 * @param bytes
	 * @return true -> save OK!
	 * dREHER
	 * @throws Exception 
	 */
	protected static boolean saveTA2SE(String serviceName2, String targetEnv, byte[] bytes) throws Exception {
		String clave = getClaveSE(serviceName2, targetEnv);
		
		LP_C_ExternalService es = getExternalService(clave);
		if(es!=null) {
			if(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv))
				es.setHomoTA(bytes);
			else
				es.setProdTA(bytes);
			
			System.out.println("Guarda TA en Servicio Externo=" + serviceName2 + " " + targetEnv);
			
			return es.save();
		}else
			throw new Exception("No se encontro servicio externo clave: " + clave);
	}

	/** 
	 * A partir del TA recibido como argumento, verifica si es necesario requerir un nuevo TA
	 */
	protected static boolean requiresNewTA(byte[] ta) {
		try {
			// Es nulo el TA obtenido?
			if (ta==null)
				return true;
			
			// Si no es nulo, buscar el expirationTime y comparar con la fecha actual 
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			System.out.println("requiresNewTA. TA:" + ta);
			
			Document doc = builder.parse(new ByteArrayInputStream(ta));
			NodeList signNodes = doc.getElementsByTagName("expirationTime"); 
			String expStr = (signNodes.item(0).getFirstChild().getNodeValue());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			Date exp = df.parse(expStr.substring(0, expStr.length()-6));
			Date now = new Date();
			
			System.out.println("Vto token:" + exp + " hoy:" + now);
			
			return (exp.compareTo(now)<0);
		} catch (Exception e) {
			return true;
		}
	}
	
	/** Retorna el nombre de la columna CRT dependiendo del ambiente */
	protected static String getCRTColumnName(String targetEnv) {
		return LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? "testcrt" : "productioncrt";
	}
	
	/** Retorna el nombre de la columna CRT dependiendo del ambiente */
	protected static String getFormatCRTColumnName(String targetEnv) {
		return LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? "TestCRT" : "ProductionCRT";
	}
	
	/**
	 * Retorna el TRA utilizado para recuperar el TA desde AFIP
	 */
	protected static String getTicketRequest(LP_C_LYEIElectronicPOSConfig aConfig) {
		Date now = new Date();
		return
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<loginTicketRequest version=\"1.0\">"+
				"<header><uniqueId>"+Math.abs((int)System.currentTimeMillis())+"</uniqueId><generationTime>"+getGenTime("yyyy-MM-dd'T'HH:mm:ss.SSS", now)+"</generationTime><expirationTime>"+getExpireTime("yyyy-MM-dd'T'HH:mm:ss.SSS", now)+"</expirationTime>"+
				"</header>"+
				"<service>" + (ServiceName==null?getServiceName(aConfig):ServiceName) + "</service>"+ // dREHER si viene preconfigurado el servicio, lamar ese servicio...		
				"</loginTicketRequest>";
	}
	
	/**
	 * Retorna el nombre del servicio contra el cual recuperar el TA
	 * @return
	 */
	protected static String getServiceName(LP_C_LYEIElectronicPOSConfig aConfig) {
		// Si es CAEA se toma directo de ahi
		if (LP_C_LYEIElectronicPOSConfig.CAEMETHOD_CAEA.equals(aConfig.getCAEMethod()))
			return LYEIConstants.serviceMapper.get(aConfig.getCAEMethod());
		// Si es CAE dependera de nacional o exportacion
		return LYEIConstants.serviceMapper.get(aConfig.getPOSService());
	}
	
	/**
	 * Fecha de generacion del TRA.
	 * Se resta un número de segundos (por defecto -120, pero configurable en la preferencia) 
	 * a la fecha actual de manera preventiva dado que bajo ciertos casos en donde el equipo  
	 * cliente tenia un pequeño desfazaje horario se podía llegar a obtener el error:
	 * 	generationTime posee formato o dato inválido (ej: en el futuro o más de 24 horas de antigüedad)
	 */
    public static String getGenTime(String format, Date date) {
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.SECOND, getGenTimeShift(-120)); 
	    Date genDate = cal.getTime();
	    DateFormat dateFormat = new SimpleDateFormat(format);
	    return dateFormat.format(genDate);
    }
	
	/**
	 * Peticion de expire en 23 horas a partir de la fecha recibida
	 * Se suman 23 horas (o las horas definidas en la preferencia) 
	 * en lugar de 24, dado que bajo ciertos casos en donde el 
	 * equipo cliente tenia un pequeño desfazaje horario
	 * y ya se obtenía un error: 
	 * 	expirationTime posee formato o dato inválido (ej: vencimiento en más de 24 horas)
	 */
	protected static String getExpireTime(String format, Date date) {
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.HOUR_OF_DAY, getExpireTimeShift(23)); 
	    Date expDate = cal.getTime();
	    DateFormat dateFormat = new SimpleDateFormat(format);
	    return dateFormat.format(expDate);
	}
	
	/**
	 * Genera el TRA encriptado y codificado
	 */
	protected static String generateTRABase64(LP_C_LYEIElectronicPOSConfig aPOSConfig, Properties ctx, String targetEnv) throws Exception {

		// Gen config
		LP_C_LYEIElectronicInvoiceConfig aConfig = new LP_C_LYEIElectronicInvoiceConfig(ctx, aPOSConfig.getC_LYEIElectronicInvoiceConfig_ID(), null);
		
		// dREHER
		byte[] crt = null;
		
		
		// Validaciones
		// dREHER
		if(ServiceName==null) {
			if (aPOSConfig.getTestCRT()==null) {
				throw new Exception("El CRT en la configuracion del punto de venta " + aPOSConfig.getPOS() + " no se encuentra cargado");
			}
			
			crt = LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? aPOSConfig.getTestCRT() : aPOSConfig.getProductionCRT();
			
		}else {
			String clave = getClaveSE(ServiceName, targetEnv);
			LP_C_ExternalService es = getExternalService(clave);
			if(es!=null) {
				if(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv)) {
					if(es.getTestCRT()==null)
						throw new Exception("El CRT en la configuracion del servicio externo " + clave + " HOMOLOGACION no se encuentra cargado");
					else
						crt = es.getTestCRT();
				}else {
					if(es.getProductionCRT()==null)
						throw new Exception("El CRT en la configuracion del servicio externo " + clave + " PRODUCCION no se encuentra cargado");
					else
						crt = es.getProductionCRT();
				}
			}else
				throw new Exception("No se encuentra configuracion de servicio externo para el servicio:" + ServiceName + " - clave:" + clave);
			
			
			
		}
		
		if (aConfig.getRSAKey()==null)
			throw new Exception("El KEY en la configuracion general para el punto de venta " + aPOSConfig.getPOS() + " no se encuentra cargado");

		// Filenames 
		String crtFileName = "crt"+aPOSConfig.getC_LYEIElectronicPOSConfig_ID()+".crt";
		String keyFileName = "key"+aPOSConfig.getC_LYEIElectronicPOSConfig_ID()+".key";
		String traFileName = "tra"+aPOSConfig.getC_LYEIElectronicPOSConfig_ID()+".xml";
		String t64FileName = "ticket"+aPOSConfig.getC_LYEIElectronicPOSConfig_ID()+".xml.cms";
		
		try {
			// Recuperar el CRT del TPV
			FileOutputStream fos = new FileOutputStream(crtFileName);
			// fos.write(LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(targetEnv) ? aPOSConfig.getTestCRT() : aPOSConfig.getProductionCRT());

			// dREHER
			fos.write(crt);
			fos.close();
			
			// Recuperar el KEY de la config gral del client
			byte[] key = aConfig.getRSAKey();
			fos = new FileOutputStream(keyFileName);
			fos.write(key);
			fos.close();
			
			// Crear el TRA
			fos = new FileOutputStream(traFileName);
			String ticketRequest = getTicketRequest(aPOSConfig);
			MLYEIElectronicInvoiceLog.logActivity(LYEIWSAA.class, Level.INFO, null, aPOSConfig.getC_LYEIElectronicPOSConfig_ID(), aPOSConfig.getC_LYEIElectronicInvoiceConfig_ID(), "TicketRequest: " + ticketRequest);
			fos.write(ticketRequest.getBytes());
			fos.close();
		
			// Generar el TA firmado
			LYEITools.executeCommand(
					"Obtencion TA", 
						LYEITools.getOpenSSLBaseDir() + LYEITools.getOpenSSLFileName() + 
						" smime -sign -signer "+crtFileName+" -inkey "+keyFileName+" -in "+traFileName+" -out "+t64FileName+" -outform PEM -nodetach", 
					new File(System.getProperty("user.dir"))
			); 
		
			// Una vez obtenido el ticket, quitar encabezado y devolver
			BufferedReader br = new BufferedReader(new FileReader(t64FileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			String pemString = sb.toString();
			pemString = pemString.replaceAll("-----BEGIN PKCS7-----", "");
			pemString = pemString.replaceAll("-----END PKCS7-----", "");
			return pemString;
		} catch (Exception e) {
			throw e;
		} finally {
			// Eliminar archivos innecesarios
			new File(crtFileName).delete();
			new File(keyFileName).delete();
			new File(traFileName).delete();
			new File(t64FileName).delete();
		}
	}
	

	/** Corrimiento preventivo del genTime o expireTime segun preferencia, expresado en segundos */
	protected static int getGenTimeShift(int defaultValueSecs) {
		int value = defaultValueSecs;
		try {
			String pref = MPreference.GetCustomPreferenceValue("LYEI_GEN_TIME_SHIFT_SECS");
			if (pref!=null && pref.length()>0) {
				value = Integer.parseInt(pref);
			}
		} catch (Exception e) {}
		return value;
	}

	/** Corrimiento adicional del expireTime segun preferencia */
	protected static int getExpireTimeShift(int defaultValueHours) {
		int value = defaultValueHours;
		try {
			String pref = MPreference.GetCustomPreferenceValue("LYEI_EXP_TIME_SHIFT_HOURS");
			if (pref!=null && pref.length()>0) {
				value = Integer.parseInt(pref);
			}
		} catch (Exception e) {}
		return value;
	}

}
