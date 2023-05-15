package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import org.openXpertya.JasperReport.WSFEConsultarComprobanteProcess;
import org.openXpertya.apps.ADialog;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MUser;
import org.openXpertya.model.X_C_Currency;
import org.openXpertya.model.X_C_DocType;
import org.openXpertya.model.X_C_Invoice;
import org.openXpertya.reflection.CallResult;
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

		StringBuffer sb = new StringBuffer();
		
		// Recuperar la factura
		MInvoice anInvoice = new MInvoice(getCtx(), getRecord_ID(), get_TrxName());
		MDocType invoiceDocType = new MDocType(getCtx(), anInvoice.getC_DocTypeTarget_ID(), get_TrxName());
		if (!invoiceDocType.iselectronic()) {
			throw new Exception("La factura seleccionada no es de tipo electronica");
		}
		
		boolean isMasivo = ADialog.ask(0, null, "Gestionar TODOS los comprobantes del punto de venta " + anInvoice.getPuntoDeVenta() + " ?");
		ArrayList<Integer> InvoicesIds = new ArrayList<Integer>(); 
		if(!isMasivo)
			InvoicesIds.add(anInvoice.getC_Invoice_ID());
		else
			InvoicesIds = getInvoicedIDs(invoiceDocType.getC_DocType_ID());
		
		for(Integer InvoiceID : InvoicesIds) {
			
			anInvoice = new MInvoice(getCtx(), InvoiceID, get_TrxName());
			log.info("Va a gestionar CAE comprobante=" + anInvoice.getDocumentNo());

			/**
			 * Verificar que el comprobante inmediatamente anterior a este
			 * NO necesite gestionar CAE, caso contrario devuelvo excepcion al usuario
			 * 
			 * 
			 * dREHER
			 */
			MInvoice before = anInvoice.getBeforeInvoice();
			if(before!=null)
				if( (before.getcae()==null || before.getcae().isEmpty()) ||
						(before.getvtocae()==null)) {
					return "Debe gestionar el comprobante anterior! - Comprobante nro:" + before.getDocumentNo();
				}
					
			// Tenemos una factura en LY completada y con cae con igual tipo y nro de documento? 
			String exists = checkIfAlreadyExistsInLY(anInvoice, invoiceDocType);
			if (exists!=null) { 
				sb.append(exists + "\n");
				continue;
			}
			
			log.info("Supero instancias de controles Libertya, comienza gestion AFIP...");

			// Cargar la configuracion inicial para poder usar la superclase
			requestData(anInvoice, invoiceDocType);

			// Algun error en conexion o procesamiento?
			String resultado = checkForErrors();

			// Modificar la factura segun corresponda
			sb.append(anInvoice.getDocumentNo() + " " + handleResponse(resultado, anInvoice) + "\n");
			
			log.info("Gestiono comprobante Ok...");

		}
		
		if(sb.length()==0)
			sb.append("No se encontraron comprobantes para gestionar!");
		
		return sb.toString();
		
	}
	
	/**
	 * 
	 * TODO: el filtro de la fecha mejorarlo con alguna configurarion...
	 * 
	 * @param invoiceDocType
	 * @return
	 * 
	 * dREHER
	 */
	private ArrayList<Integer> getInvoicedIDs(int invoiceDocType) {
		ArrayList<Integer>ids = new ArrayList<Integer>();
		String sql = "SELECT C_Invoice_ID FROM C_Invoice" +
					" WHERE C_DocTypeTarget_ID=?" + 
					" AND cae ISNULL" + 
					" AND IsActive='Y'" +
					" AND DateInvoiced::DATE > '2023-05-01'::DATE" +
					" ORDER BY NumeroComprobante";
		ResultSet rs = null;
		PreparedStatement stmt = DB.prepareStatement(sql, get_TrxName());
		try {
			
			stmt.setInt(1, invoiceDocType);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt("C_Invoice_ID"));
			}
			
		}catch(Exception ex) {
			log.warning("Se produjo un error al leer comprobante a gestionar! Error:" + ex.toString());
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ids;
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
					"Elimine la factura " + (!anInvoice.getDocStatus().equals("CO")?"o vuelva a completarla":"") + " para obtener un nuevo nro. de comprobante y CAE";
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
				//dREHER
				retMsg = "Validacion de factura satisfactoria. CAE: " + cae + "  asignado. " + (!anInvoice.getDocStatus().equals("CO")?"Proceda a completar la factura.":"");
			} else {
				// Los datos de LY no coinciden con los de AFIP
				anInvoice.setSkipIPNoCaeValidation(true);
				//dREHER
				retMsg = "Los datos verificados en AFIP no coinciden con los datos registrados en la factura. Elimine la factura " + (!anInvoice.getDocStatus().equals("CO")?"o vuelva a completarla":"") + " para obtener un nuevo nro. de comprobante y CAE";
			}
		} else {
			
			// dREHER, se completo y no se genero CAE porque el comprobante anterior tampoco se habia gestionado CAE
			// .getDocStatus().equals("CO") 
			if(anInvoice.isProcessed()) {

				MInvoice mInvoice = (MInvoice)anInvoice;
				CallResult callResult = mInvoice.doCAEGeneration(mInvoice.getNumeroComprobante());
				if (callResult.isError()) {
					mInvoice.setcaeerror(callResult.getMsg());
					log.log(Level.SEVERE, callResult.getMsg());
					retMsg = callResult.getMsg();
				}else {
					mInvoice.setSkipIPNoCaeValidation(true);
					mInvoice.save();
					retMsg = "Se genero el CAE correspondiente: CAE= " + mInvoice.getcae();
				}
				
				
			}else {
				// No se encuentra registrada en AFIP
				anInvoice.setcae(null);
				anInvoice.setvtocae(null);
				anInvoice.setSkipIPNoCaeValidation(true);
				retMsg = "Documento no encontrado. Intente completar/Gestionar CAE nuevamente el documento a fin de obtener el CAE. (Respuesta de AFIP: " + resultado + ")";
			}
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
		X_C_Currency aCurrency = new X_C_Currency(anInvoice.getCtx(), anInvoice.getC_Currency_ID(), null);
		
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
