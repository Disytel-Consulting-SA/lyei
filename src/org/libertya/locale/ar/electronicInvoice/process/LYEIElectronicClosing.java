package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.openXpertya.JasperReport.WSFEConsultarComprobanteProcess;
import org.openXpertya.model.MControladorFiscalClosingInfo;
import org.openXpertya.model.MDocType;
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
	
	/**
	 * @return Fecha parámetro
	 */
	protected Timestamp getDateParam() {
		return (Timestamp)getParametersValues().get("DATE");
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
		// Inicializar los datos del proveedor de servicios
		setLYEIProvider();
	}
	
	@Override
	protected String doIt() throws Exception {
		// Inicialización de datos
		initialize();
		
		// Realizar la consulta de los datos
		requestData();
		
		// Guardar el cierre electrónico para el punto de venta y fecha parámetro
		endProcess();
		
		return getMsg();
	}

	/**
	 * Realizar la consulta a AFIP con la info de punto de venta y fecha
	 */
	protected void requestData() throws Exception {
		// Iterar por todos los tipos de documento del punto de venta
		PreparedStatement ps = DB.prepareStatement(getDocumentsQuery(), get_TrxName());
		ResultSet rs = ps.executeQuery();
		MDocType dt;
		int min, max;
		while(rs.next()) {
			// Setear el tipo de documento al wccp
			dt = getDocType(rs);
			getWsfeProvider().setaDocType(dt);
			getWsfeProvider().setCbteTipoNombre(dt.getName());
			getWsfeProvider().setCbteTipo(getWsfeProvider().getCbteTipo(dt));
			// Consultar el mínimo anterior a la fecha actual, restando 10 por las dudas
			min = getExtremeDocumentNos("min", dt.getID());
			// Consultar el máximo de la fecha actual, agregando 10 por las dudas
			max = getExtremeDocumentNos("max", dt.getID());
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
	 */
	protected void endProcess() throws Exception {
		// Crear el registro o busco el de la fecha
		MControladorFiscalClosingInfo cinfo = getFiscalClosing();
		
		cinfo.setAD_Org_ID(getPos().getAD_Org_ID());
		cinfo.setPOSName(getPos().getName());
		cinfo.setPuntoDeVenta(getPos().getPOSNumber());
		cinfo.setFiscalClosingType("Z");
		cinfo.setFiscalClosingDate(getDateParam());
		int cid = getControladorFiscalID();
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
	}
	
	/**
	 * @return el cierre electrónico para ese punto de venta y fecha, null caso que
	 *         no exista
	 */
	private MControladorFiscalClosingInfo getControladorFiscalClosingInfo() {
		MControladorFiscalClosingInfo cinfo = null;
		int cInfoID = DB.getSQLValue(get_TrxName(),
				"select c_controlador_fiscal_closing_info_id from c_controlador_fiscal_closing_info where ad_client_id = "
						+ getPos().getAD_Client_ID() + " AND puntodeventa = " + getPos().getPOSNumber()
						+ " AND fiscalclosingdate = '" + Env.getDateFormatted(getDateParam()) + "'::date ", true);
		if(cInfoID > 0) {
			cinfo = new MControladorFiscalClosingInfo(getCtx(), cInfoID, get_TrxName());
		}
		return cinfo;
	}

	/**
	 * @return ID de la impresora fiscal asociada a los tipos de documento del punto
	 *         de venta
	 */
	protected Integer getControladorFiscalID() {
		return DB.getSQLValue(get_TrxName(), "select c_controlador_fiscal_id " + 
											"from c_doctype " + 
											"where doctypekey ilike '%"+getPos().getPOSNumber()+"%' and c_controlador_fiscal_id is not null and isactive = 'Y' " + 
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
	 * @return proveedor de consulta de comprobantes
	 */
	protected void setLYEIProvider() throws Exception {
		WSFEConsultarComprobanteProcess wccp = new WSFEConsultarComprobanteProcess(getCtx(), getClientID(), getOrgID(),
				get_TrxName());
		wccp.setPtoVta(getPOSNumber());
		wccp.loadInitialValues();
		setWsfeProvider(wccp);
	}
	
	/**
	 * @return consulta que determina los tipos de documento a consultar
	 */
	protected String getDocumentsQuery() {
		return "select *, substring(doctypekey from (length(doctypekey)-3) for 4) as posnumber " + 
				"from c_doctype " + 
				"where isactive = 'Y' and ad_client_id = "+ getAD_Client_ID() +
				(Util.isEmpty(getPOSNumber(), true)?"":" and doctypekey ilike '%" + getPOSNumber() + "%' ") +
				" and iselectronic = 'Y' " +
				" order by doctypekey ";
	}
	
	/**
	 * Procesamiento de documentos
	 */
	protected void processDocuments() throws Exception {
		for (HashMap<String, String> document : getWsfeProvider().getRetrievedDocuments()) {
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
		BigDecimal compAmt = new BigDecimal(document.get("ImpTotal")).multiply(monCotiz);
		BigDecimal taxAmt = (document.get("ImpIVA") == null ? BigDecimal.ZERO : new BigDecimal(document.get("ImpIVA")))
				.multiply(monCotiz);
		BigDecimal tribAmt = (document.get("ImpTrib") == null ? BigDecimal.ZERO : new BigDecimal(document.get("ImpTrib")))
				.multiply(monCotiz);
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
	 */
	protected MControladorFiscalClosingInfo getFiscalClosing() {
		MControladorFiscalClosingInfo cinfo = getControladorFiscalClosingInfo();
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
	 */
	protected boolean validateDocument(HashMap<String, String> document) {
		return dateParamStr.equals(document.get("CbteFch"));
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
	 * @return mensaje final
	 */
	protected String getMsg() {
		return "@ProcessOK@";
	}
}
