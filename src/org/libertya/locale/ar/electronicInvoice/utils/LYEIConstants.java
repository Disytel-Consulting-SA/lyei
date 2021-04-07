package org.libertya.locale.ar.electronicInvoice.utils;

import java.util.HashMap;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;

public class LYEIConstants {

	

	/** Variable de entorno del sistema para el home de openssl */
	public static final String ENV_OPENSSL_HOME = "OPENSSL_HOME";
		
	/** Nombre de la preferencia para especificar el directorio base de OpenSSL */
	public static final String PREF_WSFE_OPENSSL_BASE_DIR = "WSFE_OPENSSL_BASE_DIR";
		
	/** Prefijo servicio externo WSAA */
	public static final String EXTERNAL_SERVICE_WSAA_PREFIX = "WSAA";
	
	/** Prefijo servicio externo WSFEV1 */
	public static final String EXTERNAL_SERVICE_WSFEV1_PREFIX = "WSFEV1";
	
	/** Prefijo servicio externo WSFEXV1 */
	public static final String EXTERNAL_SERVICE_WSFEXV1_PREFIX = "WSFEXV1";

	/** Sufijo de Homologacion */
	public static final String EXTERNAL_SERVICE_HOMOLOGACION_SUFFIX = "HOMO";
	
	/** Sufijo de Produccion */
	public static final String EXTERNAL_SERVICE_PRODUCCION_SUFFIX = "PROD";
	
	/** Ubicacion del attachment del CSR en la config gral */ 
	public static final int ATTACHMENT_EI_CONFIG_CSR_ORDER = 0;

	/** Ubicacion del attachment del KEY en la config gral */
	public static final int ATTACHMENT_EI_CONFIG_KEY_ORDER = 1;
	
	/** Constante para WSFEV1. EC ES CONSUMIDOR FINAL */
	public static final int WSFE_BPARTNER_ES_CONSUMIDOR_FINAL = 96;
	
	/** Constante para WSFEV1. EC NO ES CONSUMIDOR FINAL */
	public static final int WSFE_BPARTNER_NO_ES_CONSUMIDOR_FINAL = 80;
	
	/** Constante para WSFEV1. CONCEPTO PRODUCTOS */
	public static final int WSFE_CONCEPTO_PRODUCTOS = 1;
	
	/** Constante para WSFEV1. CONCEPTO SERVICIOS */
	public static final int WSFE_CONCEPTO_SERVICIOS = 2;
	
	/** Constante para WSFEV1. CONCEPTO PRODUCTOS Y SERVICIOS */
	public static final int WSFE_CONCEPTO_PRODUCTOS_Y_SERVICIOS = 3;
	
	/** Codigo de opcional para indicar Anulacion */
	public static final int WSFE_OPCIONALES_ANULACION_CODIGO = 22;

	/** Codigo de opcional para indicar referencia comercial */
	public static final int WSFE_OPCIONALES_REFERENCIA_COMERCIAL_CODIGO = 23;
	
	/** Codigo de opcional para indicar CBU del emisor */
	public static final int WSFE_OPCIONALES_CBU_EMISOR_CODIGO = 2101;
	
	/** Codigo de opcional para indicar ALIAS del emisor */
	public static final int WSFE_OPCIONALES_ALIAS_EMISOR_CODIGO = 2102;
	
	/** Codigo de opcional para indicar SCA o ADC */
	public static final int WSFE_OPCIONALES_MIPYME_SCA_O_ADC_CODIGO = 27;
	
	/** Nombre de la preferencia para especificar SCA o ADC */
	public static final String WSFE_OPCIONALES_MIPYME_SCA_O_ADC_PREFERENCE = "LYEI_WSFE_OPCIONALES_MIPYME_SCA_O_ADC";
	
	/** Constante para WSFEXV1. IDIOMA FACTURA ESPANOL */
	public static final short WSFEX_IDIOMA_FACTURA_ESPANOL = 1;
	
	/** Constante para WSFEXV1. IDIOMA FACTURA INGLES */
	public static final short WSFEX_IDIOMA_FACTURA_INGLES = 2;
	
	/** Constante para WSFEXV1. IDIOMA FACTURA PORTUGUES */
	public static final short WSFEX_IDIOMA_FACTURA_PORTUGUES = 3;
	
	/** Servicio de facturacion nacional */
	public static final String AFIP_SERVICE_WSFE = "wsfe";
	
	/** Servicio de facturacion de exportacion */
	public static final String AFIP_SERVICE_WSFEX = "wsfex";
	
	/** Map posservice en configuracion de POS => nombre del servicio */
	public static HashMap<String, String> serviceMapper = new HashMap<String, String>();
	
	
	static {
		// Mapeo de servicios entre la configuracion y su nombre
		serviceMapper.put(LP_C_LYEIElectronicPOSConfig.POSSERVICE_FacturacionNacional, AFIP_SERVICE_WSFE);
		serviceMapper.put(LP_C_LYEIElectronicPOSConfig.POSSERVICE_FacturacionExportacion, AFIP_SERVICE_WSFEX);
	}
	

}
