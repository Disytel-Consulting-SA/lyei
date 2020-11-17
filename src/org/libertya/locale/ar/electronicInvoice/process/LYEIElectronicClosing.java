package org.libertya.locale.ar.electronicInvoice.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	}
	
	@Override
	protected String doIt() throws Exception {
		// Inicialización de datos
		initialize();
		
		// Realizar la consulta de los datos
		requestData();
		
		// Guardar el cierre electrónico para el punto de venta y fecha parámetro
		saveClosingInfo();
		
		return "ProcessOK";
	}

	/**
	 * Realizar la consulta a AFIP con la info de punto de venta y fecha
	 */
	protected void requestData() throws Exception {
		// Inicializar sus datos
		WSFEConsultarComprobanteProcess wccp = new WSFEConsultarComprobanteProcess(getCtx(), getPos().getAD_Client_ID(), getPos().getAD_Org_ID(), get_TrxName());
		wccp.setPtoVta(getPos().getID());
		wccp.loadInitialValues();
		// Iterar por todos los tipos de documento del punto de venta
		PreparedStatement ps = DB.prepareStatement("select * " + 
													"from c_doctype " + 
													"where doctypekey ilike '%" + getPos().getPOSNumber() + "%' and isactive = 'Y' and ad_client_id = "
													+ getPos().getAD_Client_ID(), get_TrxName());
		ResultSet rs = ps.executeQuery();
		MDocType dt;
		int min, max;
		BigDecimal sign = BigDecimal.ZERO;
		while(rs.next()) {
			// Setear el tipo de documento al wccp
			dt = new MDocType(getCtx(), rs, get_TrxName());
			wccp.setaDocType(dt);
			wccp.setCbteTipoNombre(dt.getName());
			wccp.setCbteTipo(wccp.getCbteTipo(dt));
			// Consultar el mínimo anterior a la fecha actual, restando 10 por las dudas
			min = getExtremeDocumentNos("min", dt.getID());
			min = (min - DELTA_DAYS) < 0?0:min - DELTA_DAYS;
			// Consultar el máximo de la fecha actual, agregando 10 por las dudas
			max = getExtremeDocumentNos("max", dt.getID());
			max = max + DELTA_DAYS;
			// Consultar los datos en la iteración de facturas del wccp
			wccp.setCbteNroFrom(min);
			wccp.setCbteNroTo(max);
			wccp.queryInvoices(); 
			sign = new BigDecimal(dt.getsigno_issotrx());
			BigDecimal taxAmt, compAmt, tribAmt;
			for (HashMap<String, String> invoices : wccp.getRetrievedDocuments()) {
				// Traerme los datos y sumar al objeto DTO del Fiscal Close
				// Si es crédito va para lo que es creditnote y lo que es debito va para fiscal
				compAmt = new BigDecimal(invoices.get("ImpTotal"));
				taxAmt = invoices.get("ImpIVA") == null?BigDecimal.ZERO:new BigDecimal(invoices.get("ImpIVA"));
				tribAmt = invoices.get("ImpTrib") == null?BigDecimal.ZERO:new BigDecimal(invoices.get("ImpTrib"));
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
		}
		rs.close();
		ps.close();
	}
	
	/**
	 * Guardar el cierre electrónico del punto de venta
	 */
	protected void saveClosingInfo() throws Exception {
		// Crear el registro o busco el de la fecha
		MControladorFiscalClosingInfo cinfo = getFiscalClosing();
		
		cinfo.setAD_Org_ID(getPos().getAD_Org_ID());
		cinfo.setPOSName(getPos().getName());
		cinfo.setFiscalClosingType("Z");
		cinfo.setFiscalClosingDate(getDateParam());
		cinfo.setC_Controlador_Fiscal_ID(getControladorFiscalID());
		
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
						+ " AND fecha = '" + Env.getDateFormatted(getDateParam()) + "'::date ");
		cInfoID = cInfoID < 0 ? 0 : cInfoID; 
		cinfo = new MControladorFiscalClosingInfo(getCtx(), cInfoID, get_TrxName());
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
		return DB.getSQLValue(get_TrxName(),
				"select " + function + "(numerocomprobante) "
				+ "from c_invoice where c_doctypetarget_id = " + docTypeID
						+ " and cae is not null");
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
}
