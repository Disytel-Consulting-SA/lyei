package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openXpertya.JasperReport.WSFEConsultarComprobanteProcess;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MUser;
import org.openXpertya.model.X_C_Currency;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.model.X_C_Invoice;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

public class LYEIManageElectronicInvoiceProcess extends WSFEConsultarComprobanteProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
	
		// Recuperar la factura
		MInvoice anInvoice = new MInvoice(getCtx(), getRecord_ID(), get_TrxName());
		MDocType invoiceDocType = new MDocType(getCtx(), anInvoice.getC_DocTypeTarget_ID(), get_TrxName());
		if (!invoiceDocType.iselectronic()) {
			throw new Exception("La factura seleccionada no es de tipo electronica");
		}
		
		// Tenemos una factura en LY completada y con cae con igual tipo y nro de documento? 
		String exists = checkIfAlreadyExistsInLY(anInvoice, invoiceDocType);
		if (exists!=null) 
			return exists;
		
		// Cargar la configuracion inicial para poder usar la superclase
		requestData(anInvoice, invoiceDocType);
								
		// Algun error en conexion o procesamiento?
		String resultado = checkForErrors();
		
		// Modificar la factura segun corresponda
		return handleResponse(resultado, anInvoice);
	}
	
	
	/** Valida si ya existe una factura en LY con iguales caracteristicas */
	protected String checkIfAlreadyExistsInLY(X_C_Invoice anInvoice, X_C_DocType aDocType) throws Exception {
		// Ya hay una factura en LY registrada con la información en cuestión?
		String alreadyExists = alreadyExists(anInvoice, aDocType);
		if (alreadyExists!=null) {
			// Si existe marcar para omitir la validacion
			anInvoice.setSkipIPNoCaeValidation(true);
			if (!anInvoice.save()) {
				throw new Exception("Error al gestionar factura: " + CLogger.retrieveErrorAsString());
			}
			return  "Ya existe una factura en Libertya con los mismos datos (numero de comprobante, tipo de documento, etc.) y con CAE registrado: " + alreadyExists + ". " + 
					"Elimine la factura o vuelva a completarla para obtener un nuevo nro. de comprobante y CAE";
		}
		return null;
	}
	
	
	/**
	 * Verifica si ya existe una factura en LY igual a la que se desea gestionar
	 * @return null si no existe o informacion relevante de la existente en caso contrario
	 */
	protected String alreadyExists(X_C_Invoice anInvoice, X_C_DocType aDocType) {
		// Se debe verificar que no exista en Libertya otro comprobante con el mismo Tipo de Documento, 
		// Punto de Venta y número, en estado completo y que posea CAE y Vto. CAE seteados.
		String retValue = DB.getSQLValueString(null, 	" SELECT 'Numero:' || documentno || '. Fecha:' || dateacct || '. Total:' || grandtotal || '. CAE:' || cae " +
														" FROM C_Invoice " +
														" WHERE docstatus IN ('CO', 'CL') " +
														" AND cae IS NOT NULL " +
														" AND vtocae IS NOT NULL " +
														" AND C_Invoice_ID <> ? " + 
														" AND documentno = ? " +
														" AND C_DocType_ID = ? " +
														" AND AD_Client_ID = ? "
														, anInvoice.getC_Invoice_ID(), anInvoice.getDocumentNo(), anInvoice.getC_DocType_ID(), anInvoice.getAD_Client_ID());
		return retValue;
	}
	
	
	/** 
	 * Carga la configuracion inicial para poder apoyarse en la superclase 
	 */
	protected void requestData(X_C_Invoice anInvoice, MDocType aDocType) throws Exception {
		// Configuracion basica para consulta
		setaDocType(aDocType);
		setClientID(getaDocType().getAD_Client_ID());
		setOrgID(getaDocType().getAD_Org_ID());
		
		// Solo se requiere consultar por un comprobante
		setCbteNroFrom(anInvoice.getNumeroComprobante());
		setCbteNroTo(anInvoice.getNumeroComprobante());
		setPtoVta(anInvoice.getPuntoDeVenta());
		setCbteTipo(getCbteTipo(aDocType));
		
		// Carga la configuracion de PV electronico
		loadInitialValues();
		
		// Consultar por la factura en cuestion
		queryInvoices();
	}
	
	/** 
	 * Verifica la informacion resultante obtenida
	 * @throws Exception en caso de encontrar algun error
	 */
	protected String checkForErrors() throws Exception {
		// Error general?
		if (getRetrievedDocuments() == null || getRetrievedDocuments().size() == 0) {
			throw new Exception("Error en validacion. Reintente.");
		}
		String resultado = getRetrievedDocuments().get(0).get("Resultado");
		// Error de conexion?
		if (resultado==null || resultado.toLowerCase().startsWith("error de conex")) {
			throw new Exception("Error en consulta: " + resultado);
		}
		return resultado;
		
	}
	
	/** Gestion la factura según corresponda en funcion de los datos obtenidos */
	protected String handleResponse(String resultado, X_C_Invoice anInvoice) throws Exception {
		String retMsg = null;
		// Está registrada?
		if ("A".equalsIgnoreCase(resultado)) {

			
			// Coinciden los datos de LY con los de AFIP?
			if (dataMatches(anInvoice)) {
				String cae = getRetrievedDocuments().get(0).get("CodAutorizacion");
				String vtoCae = getRetrievedDocuments().get(0).get("FchVto");
				anInvoice.setcae(cae);
				anInvoice.setvtocae(parseVtoCae(vtoCae));
				anInvoice.setcaeerror("Factura electronica editada manualmente por " + (MUser.get(getCtx(), Env.getAD_User_ID(getCtx()))).getName() );
				retMsg = "Validacion de factura satisfactoria. CAE: " + cae + "  asignado. Proceda a completar la factura.";
			} else {
				// Los datos de LY no coinciden con los de AFIP
				anInvoice.setSkipIPNoCaeValidation(true);
				retMsg = "Los datos verificados en AFIP no coinciden con los datos registrados en la factura. Elimine la factura o vuelva a completarla para obtener un nuevo nro. de comprobante y CAE";
			}
		} else {
			// No se encuentra registrada en AFIP
			anInvoice.setcae(null);
			anInvoice.setvtocae(null);
			anInvoice.setSkipIPNoCaeValidation(true);
			retMsg = "Documento no encontrado. Intente completar nuevamente el documento a fin de obtener el CAE. (Respuesta de AFIP: " + resultado + ")";			
		}
		
		// Intentar persistir
		if (!anInvoice.save()) {
			throw new Exception("Error al gestionar factura: " + CLogger.retrieveErrorAsString());
		}
		return retMsg;
	}
	
	/** Valida si los datos locales de la factura coinciden con los datos recibidos por parte de AFIP */
	protected boolean dataMatches(X_C_Invoice anInvoice) {
		// Codigo de AFIP para Moneda de la factura
		// (en instancias viejas pueden no tenerlo configurado, en ese caso se omite la validacion por este dato)
		X_C_Currency aCurrency = new X_C_Currency(Env.getCtx(), anInvoice.getC_Currency_ID(), null);
		
		// Informacion recibida desde AFIP
		// IMPORTANTE: Si bien se podría consultar por mas criterios bajo WSFE, para los casos donde  
		// el servicio a consultar es WSFEX (facturas de exportacion), tenemos menos campos disponibles. 
		String cbteFch = getRetrievedDocuments().get(0).get("CbteFch");
		String grandTotal = getRetrievedDocuments().get(0).get("ImpTotal");
		String moneda = getRetrievedDocuments().get(0).get("MonId");
		
		return (getCbteFch(anInvoice).equals(cbteFch) && 									// Fecha de comprobante
				anInvoice.getGrandTotal().compareTo(new BigDecimal(grandTotal)) == 0 &&		// Monto total
				(aCurrency.getWSFECode()==null || aCurrency.getWSFECode().equals(moneda))); // Moneda: Solo si no es null (puede no estar configurado)
	}
	
	/** Interpreta el vtoCae recibido y lo convierte a Timestamp */
	protected Timestamp parseVtoCae(String vtoCae) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = dateFormat.parse(vtoCae);
		return new Timestamp(date.getTime());
	}
	
	
	/** Fecha de la factura */
	protected String getCbteFch(X_C_Invoice inv) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(inv.getDateAcct().getTime());
        return dateFormat.format(date);
	}

}
