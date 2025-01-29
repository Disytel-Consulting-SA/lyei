package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

import org.openXpertya.JasperReport.WSFEConsultarComprobanteProcess;
import org.openXpertya.model.MControladorFiscalClosingInfo;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MPOS;
import org.openXpertya.print.fiscal.FiscalClosingResponseDTO;
import org.openXpertya.process.AbstractSvrProcess;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

public class LYEIElectronicClosing extends AbstractSvrProcess {

	/**
	 * Cantidad de comprobantes a tomar desde el primero del día hacia atrás y desde
	 * el último del día hacia adelante. AFIP no presenta operaciones para consultar
	 * por fechas, por lo que se decidió que al primer comprobante del día se le
	 * reste un número X y al último del día también como para arrastrar también
	 * posibles no registrados. Luego, en la devolución, se descartan los
	 * comprobantes que no son del día.
	 */
	private static final int DELTA_DAYS = 10;
	
	/** Configuración de TPV parámetro */
	private MPOS pos;
	
	/** Cierre Electrónico del Día para el punto de venta */
	private FiscalClosingResponseDTO result = null;
	
	/** El provider que realiza la consulta de los comprobantes */
	private WSFEConsultarComprobanteProcess wsfeProvider = null;

	/** Formateo de fechas de yyyyMMdd */
	protected DateFormat lyeiDateFormatter = new SimpleDateFormat("yyyyMMdd");
	
	/** Fecha parámetro en string */
	private String dateParamStr;
	
	// dREHER
	private BigDecimal totalAmt = Env.ZERO;
	private BigDecimal totalCreditAmt = Env.ZERO;
	
	/**
	 * @return Fecha parámetro
	 */
	protected Timestamp getDateParam() {
		return (Timestamp)getParametersValues().get("DATE");
	}
	
	/**
	 * @return Fecha parámetro
	 */
	protected Date getDateParamAsDATE() {
		return new Date( ((Timestamp) getParametersValues().get("DATE")).getTime() );
	}
	
	/**
	 * @return config de TPV parámetro
	 */
	protected Integer getPOSID() {
		return (Integer)getParamValueAsInt("C_POS_ID");
	}
	
	/**
	 * Inicialización de datos
	 * @throws Exception
	 */
	protected void initialize() throws Exception {
		setPos(new MPOS(getCtx(), getPOSID(), get_TrxName()));
		setResult(new FiscalClosingResponseDTO());
		dateParamStr = lyeiDateFormatter.format(getDateParam());
	}
	
	@Override
	protected String doIt() throws Exception {
		// Inicialización de datos
		initialize();

		// Inicializar los datos del proveedor de servicios
		setLYEIProvider(0);
		
		// Realizar la consulta de los datos
		requestData(0);
		
		// Guardar el cierre electrónico para el punto de venta y fecha parámetro
		endProcess(0);
		
		/**
		 * Si este punto de venta tiene configurado un punto de venta de contingencia, realizar el cierre del mismo
		 *  
		 * dREHER
		 */
		int ptoVtaCont = getContingencyPOSNumber(); 
		if( ptoVtaCont > 0) {
			
			// Inicializo totales
			getResult().creditnoteamt = Env.ZERO;
			getResult().creditnotetaxamt = Env.ZERO;
			getResult().creditnoteperceptionamt = Env.ZERO;
			getResult().fiscaldocumentamt = Env.ZERO;
			getResult().fiscaldocumenttaxamt = Env.ZERO;
			getResult().fiscaldocumentperceptionamt = Env.ZERO;
			
			/**
			 * Esta opcion hace lo mismo que CAE, pero trayendo la info de los comprobantes desde los CAEAs informados a AFIP
			 * 
			 * dREHER
			 */
			
			// Inicializar los datos del proveedor de servicios
			setLYEIProvider(ptoVtaCont);
		
			// Realizar la consulta de los datos
			requestData(ptoVtaCont);
		
			// Guardar el cierre electrónico para el punto de venta y fecha parámetro
			endProcess(ptoVtaCont);
			 
			
			/**
				Este metodo lee los comprobantes CAEA desde C_Invoice validando que sean de un punto de venta de contingencia y
				que ademas el CAE del Invoice se corresponda con alguna CAEA solicitado el ultimo mes.
				Util si se presenta CAEA una sola vez por quincena y se requiere que los cierres electronicos cotejen CAEA Local vs Ventas
			
				// Realizar la consulta de los datos
				requestDataCont(ptoVtaCont);
			
				dREHER
			
			*/
				
			// Guardar el cierre electrónico para el punto de venta y fecha parámetro
			endProcess(ptoVtaCont);
			
		}
		
		return getMsg(ptoVtaCont);
	}
	
	

	/**
	 * Realizar la consulta de facturas de contingencia CAEA de punto de venta y fecha
	 * @param ptoVta default
	 * dREHER
	 */
	protected void requestDataCont(int ptoVta) throws Exception {
		
		String sql = "select i.C_Invoice_ID, i.dateacct::date as fiscalclosingdate, puntodeventa, p.name as posname, amount as ventas, c_doctypetarget_id AS C_DocType_ID\n"
				+ "	from v_dailysales_invoices_filtered(\n"
				+ "	    ?::integer,\n"
				+ "	    -1::integer,\n"
				+ "	    -1::integer,\n"
				+ "	    ?::date,\n"
				+ "	    ?::date,\n"
				+ "	    null::date,\n"
				+ "	    null::date,\n"
				+ "	    false::boolean) as ds\n"
				+ "	join c_invoice i on i.c_invoice_id = ds.c_invoice_id\n"
				+ "	join c_pos p on p.c_pos_id = ds.c_pos_id\n"
				+ "	where puntodeventa=? AND i.cae IN (SELECT cr.caea FROM C_LYEICAEARequest cr WHERE cr.fechaDesde >= ?::date-interval '2 month')";

	
		// Iterar por todos los tipos de documento del punto de venta
		PreparedStatement ps = DB.prepareStatement(sql, get_TrxName());
		ps.setInt(1, getOrgID());
		ps.setDate(2, getDateParamAsDATE());
		ps.setDate(3, getDateParamAsDATE());
		ps.setInt(4, ptoVta);
		ps.setTimestamp(5, getDateParam());
		
		ResultSet rs = ps.executeQuery();
		MDocType dt;

		while(rs.next()) {
			// Setear el tipo de documento 
			try {
				dt = getDocType(rs);
			} catch(Exception e) {
				log.warning(e.getMessage());
				continue;
			}
			
			int C_Invoice_ID = rs.getInt("C_Invoice_ID");
			MInvoice inv = MInvoice.get(getCtx(), C_Invoice_ID, get_TrxName());
			if(inv!=null) {
				
				BigDecimal sign = new BigDecimal(dt.getsigno_issotrx());
				if(sign.compareTo(BigDecimal.ZERO) < 0) {
					getResult().creditnoteamt = getResult().creditnoteamt.add(inv.getGrandTotal());
					getResult().creditnotetaxamt = getResult().creditnotetaxamt.add(inv.getTaxesAmt());
					getResult().creditnoteperceptionamt = getResult().creditnoteperceptionamt.add(inv.getPercepcionesTotalAmt());
				}else {
					getResult().fiscaldocumentamt = getResult().fiscaldocumentamt.add(inv.getGrandTotal());
					getResult().fiscaldocumenttaxamt = getResult().fiscaldocumenttaxamt.add(inv.getTaxesAmt());
					getResult().fiscaldocumentperceptionamt = getResult().fiscaldocumentperceptionamt.add(inv.getPercepcionesTotalAmt());
				}
			}
			
		}
		rs.close();
		ps.close();
	}
	
	
	/**
	 * Realizar la consulta a AFIP con la info de punto de venta y fecha
	 */
	protected void requestData(int ptoVta) throws Exception {
		// Iterar por todos los tipos de documento del punto de venta
		PreparedStatement ps = DB.prepareStatement(getDocumentsQuery(ptoVta), get_TrxName());
		ResultSet rs = ps.executeQuery();
		MDocType dt;
		int min, max;
		while(rs.next()) {
			// Setear el tipo de documento al wccp
			try {
				dt = getDocType(rs);
				System.out.println("--> LYEIELectronicClosing. Tipo de Doc leido:" + dt.getName()); // dREHER
			} catch(Exception e) {
				log.warning(e.getMessage());
				continue;
			}
			getWsfeProvider().setaDocType(dt);
			getWsfeProvider().setCbteTipoNombre(dt.getName());
			getWsfeProvider().setCbteTipo(getWsfeProvider().getCbteTipo(dt));
			// Consultar el mínimo anterior a la fecha actual, restando 10 por las dudas
			min = getExtremeDocumentNos("min", dt.getID());
			// Consultar el máximo de la fecha actual, agregando 10 por las dudas
			max = getExtremeDocumentNos("max", dt.getID());
			
			System.out.println("--> LYEIELectronicClosing. Recorre comprobantes - min:" + min + " max:" + max); // dREHER
			
			if(min <= 0 && max <= 0) continue; 
			// Al menos un mínimo y máximo existen
			min = (min - DELTA_DAYS) < 0?0:min - DELTA_DAYS;
			max = max + DELTA_DAYS;
			// Consultar los datos en la iteración de facturas del wccp
			getWsfeProvider().setCbteNroFrom(min);
			getWsfeProvider().setCbteNroTo(max);
			getWsfeProvider().setRetrievedDocuments(new ArrayList<HashMap<String,String>>());
			getWsfeProvider().queryInvoices();
			processDocuments();
		}
		rs.close();
		ps.close();
	}
	
	/**
	 * Guardar el cierre electrónico del punto de venta
	 * @param ptoVta default
	 * dREHER
	 */
	protected void endProcess(int ptoVta) throws Exception {
		// Crear el registro o busco el de la fecha
		MControladorFiscalClosingInfo cinfo = getFiscalClosing(ptoVta);
		
		cinfo.setAD_Org_ID(getPos().getAD_Org_ID());
		cinfo.setPOSName(getPos().getName());
		cinfo.setPuntoDeVenta((ptoVta>0?ptoVta:getPos().getPOSNumber()));
		cinfo.setFiscalClosingType("Z");
		cinfo.setFiscalClosingDate(getDateParam());
		int cid = getControladorFiscalID(ptoVta);
		cid = cid < 0?0:cid;
		cinfo.setC_Controlador_Fiscal_ID(cid);
		
		cinfo.setCreditNoteAmt(getResult().creditnoteamt);
		cinfo.setCreditNotePerceptionAmt(getResult().creditnoteperceptionamt);
		cinfo.setCreditNoteTaxAmt(getResult().creditnotetaxamt);

		cinfo.setFiscalDocumentAmt(getResult().fiscaldocumentamt);
		cinfo.setFiscalDocumentPerceptionAmt(getResult().fiscaldocumentperceptionamt);
		cinfo.setFiscalDocumentTaxAmt(getResult().fiscaldocumenttaxamt);
		cinfo.setProcessed(true);
		
		if(!cinfo.save()){
			throw new Exception(CLogger.retrieveErrorAsString());
		}
		
		System.out.println("LYEIElectronicClosing.Final del cierre electronico: DocumentAmt:" + getResult().fiscaldocumentamt +
				" CreditNoteAmt:" + getResult().creditnoteamt);
		
		totalAmt = totalAmt.add(getResult().fiscaldocumentamt);
		totalCreditAmt = totalCreditAmt.add(getResult().creditnoteamt);
	}
	
	/**
	 * @param ptoVta default
	 * @return el cierre electrónico para ese punto de venta y fecha, null caso que
	 *         no exista
	 * dREHER
	 */
	private MControladorFiscalClosingInfo getControladorFiscalClosingInfo(int ptoVta) {
		MControladorFiscalClosingInfo cinfo = null;
		int cInfoID = DB.getSQLValue(get_TrxName(),
				"select c_controlador_fiscal_closing_info_id from c_controlador_fiscal_closing_info where ad_client_id = "
						+ getPos().getAD_Client_ID() + " AND puntodeventa = " + (ptoVta>0?ptoVta:getPos().getPOSNumber())
						+ " AND fiscalclosingdate = '" + Env.getDateFormatted(getDateParam()) + "'::date ", true);
		if(cInfoID > 0) {
			cinfo = new MControladorFiscalClosingInfo(getCtx(), cInfoID, get_TrxName());
		}
		return cinfo;
	}

	/**
	 * ptoVta default
	 * @return ID de la impresora fiscal asociada a los tipos de documento del punto
	 *         de venta
	 * dREHER
	 */
	protected Integer getControladorFiscalID(int ptoVta) {
		return DB.getSQLValue(get_TrxName(), "select c_controlador_fiscal_id " + 
											"from c_doctype " + 
											"where doctypekey ilike '%"+(ptoVta>0?ptoVta:getPos().getPOSNumber())+"%' and c_controlador_fiscal_id is not null and isactive = 'Y' " + 
											"order by updated desc " +
											"limit 1 ");
	}

	/**
	 * Obtiene el número de comprobante min o max de un tipo de documento específico
	 * 
	 * @param function  min o max
	 * @param docTypeID id de tipo de documento
	 * @return el número de comprobante específico para la función y tipo de
	 *         documento parámetro
	 */
	protected Integer getExtremeDocumentNos(String function, Integer docTypeID) {
		String sql = "select " + function + "(numerocomprobante) "
				+ "from c_invoice where c_doctypetarget_id = " + docTypeID
				+ " and dateacct::date = '" + Env.getDateFormatted(getDateParam()) + "'::date "
				+ " and cae is not null ";
		return DB.getSQLValue(get_TrxName(), sql, true);
	}
	
	
	/**
	 * Sobrecargo por compatibilidad
	 * 
	 * @throws Exception
	 * dREHER
	 */
	protected void setLYEIProvider() throws Exception {
		setLYEIProvider(0);
	}
	
	/**
	 * @param ptoVtaDefault - trabaja con el punto de venta parametrizado
	 * @return proveedor de consulta de comprobantes
	 * 
	 * Agrego parametro para poder trabajar con un punto de venta especifico
	 * dREHER
	 */
	protected void setLYEIProvider(int ptoVtaDefault) throws Exception {
		WSFEConsultarComprobanteProcess wccp = new WSFEConsultarComprobanteProcess(getCtx(), getClientID(), getOrgID(),
				get_TrxName());
		if(ptoVtaDefault > 0)
			wccp.setPtoVta(ptoVtaDefault);
		else
			wccp.setPtoVta(getPOSNumber());
		
		wccp.loadInitialValues(ptoVtaDefault);
		setWsfeProvider(wccp);
	}
	
	/**
	 * @return consulta que determina los tipos de documento a consultar
	 */
	protected String getDocumentsQuery(int ptoVta) {
		return "select *, substring(doctypekey from (length(doctypekey)-3) for 4) as posnumber " + 
				"from c_doctype " + 
				"where isactive = 'Y' and ad_client_id = "+ getAD_Client_ID() +
				(Util.isEmpty(getPOSNumber(), true) && ptoVta == 0?"":" and doctypekey ilike '%" + (ptoVta>0?ptoVta:getPOSNumber()) + "%' ") +
				" and iselectronic = 'Y' " +
				" order by doctypekey ";
	}
	
	/**
	 * Procesamiento de documentos
	 */
	protected void processDocuments() throws Exception {
		for (HashMap<String, String> document : getWsfeProvider().getRetrievedDocuments()) {
			
			System.out.println("--> LYEIELectronicClosing. Documento:" +
									document.get("CbteDesde") + " - ImpTotal: " + document.get("ImpTotal"));
			
			if(document.get("ImpTotal") == null) continue;
			
			// Verificar que la fecha del comprobante sea la fecha parámetro, sino no es de
			// la misma fecha
			if(!validateDocument(document)) continue;
			
			// Traerme los datos y sumar al objeto DTO del Fiscal Close
			// Si es crédito va para lo que es creditnote y lo que es debito va para fiscal
			processDocument(document);
		}
	}
	
	/**
	 * Procesamiento de un documento de toda la nómina
	 * 
	 * @param document documento a procesar
	 * @throws Exception
	 */
	protected void processDocument(HashMap<String, String> document) throws Exception {
		BigDecimal sign = new BigDecimal(getWsfeProvider().getaDocType().getsigno_issotrx());
		BigDecimal monCotiz = new BigDecimal(document.get("MonCotiz"));

		// dREHER 5.0
		if(Util.isEmpty(monCotiz, true))
			monCotiz = Env.ONE;
		
		BigDecimal compAmt = new BigDecimal(document.get("ImpTotal")).multiply(monCotiz);
		BigDecimal taxAmt = (document.get("ImpIVA") == null ? BigDecimal.ZERO : new BigDecimal(document.get("ImpIVA")))
				.multiply(monCotiz);
		
		// dREHER - en CAEA comprobantes B pueden venir con el campo ImpTrib="null"
		String tmp = document.get("ImpTrib");
		BigDecimal tribAmt = (tmp == null || tmp.equals("null") || tmp.isEmpty() ? BigDecimal.ZERO : new BigDecimal(tmp))
				.multiply(monCotiz);
		
		System.out.println("--> LYEIELectronicClosing. processDocument:" +
				document.get("CbteDesde") + " - NC ?: " + ((sign.compareTo(BigDecimal.ZERO) < 0)?"Si":"No") +
				" - compAmt:" + compAmt + 
				" - taxAmt:" + taxAmt +
				" - monCotiz:" + monCotiz); // dREHER
		
		if(sign.compareTo(BigDecimal.ZERO) < 0) {
			getResult().creditnoteamt = getResult().creditnoteamt.add(compAmt);
			getResult().creditnotetaxamt = getResult().creditnotetaxamt.add(taxAmt);
			getResult().creditnoteperceptionamt = getResult().creditnoteperceptionamt.add(tribAmt);
		}
		else {
			getResult().fiscaldocumentamt = getResult().fiscaldocumentamt.add(compAmt);
			getResult().fiscaldocumenttaxamt = getResult().fiscaldocumenttaxamt.add(taxAmt);
			getResult().fiscaldocumentperceptionamt = getResult().fiscaldocumentperceptionamt.add(tribAmt);
		}
		
		System.out.println("--> LYEIELectronicClosing. processDocument Totales hasta el comprobante:" +
				document.get("CbteDesde") + 
				" - fiscaldocumentamt:" + getResult().fiscaldocumentamt + 
				" - fiscaldocumenttaxamt:" + getResult().fiscaldocumenttaxamt); // dREHER
	}
	
	/**
	 * Obtiene el tipo de documento actual
	 * 
	 * @param rs resultado de la query
	 * @return tipo de documento actual
	 */
	protected MDocType getDocType(ResultSet rs) throws Exception {
		return new MDocType(getCtx(), rs.getInt("C_DocType_ID"), get_TrxName());
	}
	
	protected MPOS getPos() {
		return pos;
	}

	protected void setPos(MPOS pos) {
		this.pos = pos;
	}

	protected FiscalClosingResponseDTO getResult() {
		return result;
	}

	protected void setResult(FiscalClosingResponseDTO result) {
		this.result = result;
	}
	
	/**
	 * Buscar el dto para este punto de venta y fecha
	 * @param ptoVta default
	 * dREHER
	 */
	protected MControladorFiscalClosingInfo getFiscalClosing(int ptoVta) {
		MControladorFiscalClosingInfo cinfo = getControladorFiscalClosingInfo(ptoVta);
		if(cinfo == null) {
			cinfo = new MControladorFiscalClosingInfo(getCtx(), 0, get_TrxName());
		}
		return cinfo;
	}

	protected WSFEConsultarComprobanteProcess getWsfeProvider() {
		return wsfeProvider;
	}

	protected void setWsfeProvider(WSFEConsultarComprobanteProcess wsfeProvider) {
		this.wsfeProvider = wsfeProvider;
	}
	
	/**
	 * Realizar las validaciones de cada documento
	 * 
	 * @param document documento
	 * @return true si cumple con las especificaciones para que el documento sea
	 *         candidato para procesamiento, false caso contrario
	 * @throws ParseException 
	 */
	protected boolean validateDocument(HashMap<String, String> document) {
		String cbteFech = document.get("CbteFch");
		
		if(cbteFech==null) {
			System.out.println("--> LYEIELectronicClosing. Documento.CbteFch: NULA, no valido!"); // dREHER
			return false;
		}
		
		try {
			if(cbteFech.length() > 8)
				cbteFech = lyeiDateFormatter.format(document.get("CbteFch"));
		}catch(Exception ex) {
			cbteFech = DB.getSQLValueString(get_TrxName(), "SELECT TO_CHAR(?::date, 'yyyymmdd');", document.get("CbteFch"));
		}
		
		System.out.println("--> LYEIELectronicClosing. Valida fechas- Documento.CbteFch: " + cbteFech + " Parametro fecha:" + dateParamStr); // dREHER
		return dateParamStr.equals(cbteFech);
	}
	
	 /**
     * Convert an Object to a Timestamp.
     */
    public java.sql.Timestamp toTimestamp( Object value ) throws ParseException
    {
        if( value == null ) return null;        
        if( value instanceof java.sql.Timestamp ) return (java.sql.Timestamp)value;
        if( value instanceof String )
        {
            if( "".equals( (String)value ) ) return null;
            return new java.sql.Timestamp( lyeiDateFormatter.parse( (String)value ).getTime() );
        }
                
        return new java.sql.Timestamp( lyeiDateFormatter.parse( value.toString() ).getTime() );
    }
	
	/**
	 * @return Compañía actual
	 */
	protected int getClientID() {
		return getPos().getAD_Client_ID();
	}
	
	/**
	 * @return Organización actual
	 */
	protected int getOrgID() {
		return getPos().getAD_Org_ID();
	}
	
	/**
	 * @return Punto de venta actual
	 */
	protected int getPOSNumber() {
		return getPos().getPOSNumber();
	}
	
	/**
	 * @return Punto de venta de contingencia
	 * Utilizado para trabajar con CAEA
	 * dREHER
	 */
	protected int getContingencyPOSNumber() {
		Object ptoVtaCont = getPos().get_Value("PtoVtaContingencia");
		if(ptoVtaCont==null)
			ptoVtaCont = 0;
		
		return (Integer)ptoVtaCont;
	}
	
	/**
	 * @return mensaje final
	 * @param ptoVta default
	 * dREHER
	 */
	protected String getMsg(int ptoVta) {
		String ret = "@ProcessOK@ <br>" +
		"Se realizo cierre del Pto.Vta.: " + getPOSNumber() + "<br>" +
		(ptoVta>0?"Se realizo cierre del Pto.Vta. de Contingencia: " + ptoVta:"") +
		"<br>Total Debitos: <b>" + totalAmt + "</b> " +
			" Total Creditos: <b>" + totalCreditAmt + "</b> ";
		
		return ret;
	}
}
