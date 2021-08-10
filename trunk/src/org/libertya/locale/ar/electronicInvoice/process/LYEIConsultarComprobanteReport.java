package org.libertya.locale.ar.electronicInvoice.process;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.libertya.locale.ar.electronicInvoice.process.LYEIElectronicClosing;
import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.JasperReport.DataSource.WSFEConsultarComprobanteDataSource;
import org.openXpertya.model.MDocType;
import org.openXpertya.model.MOrg;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MProcess;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.TimeUtil;
import org.openXpertya.util.Util;

public class LYEIConsultarComprobanteReport extends LYEIElectronicClosing {

	/** Todos los Documentos recuperados */
	private ArrayList<HashMap<String, String>> documents;
	
	/** Tipo de Documento actual */
	private int posNumber = 0;
	
	/** Organización */
	private int orgID = 0;
	
	/** Compañía */
	private int clientID = 0;
	
	public LYEIConsultarComprobanteReport() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Retorna la fecha correspondiente al parámetro en el formato el formato yyyyMMdd
     * @param date
     * @return
     */
    public Date getDateParsed(String dateFormatted) {
    	Date date = null;
    	try {
    		date = lyeiDateFormatter.parse(dateFormatted);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return date;
    }
	
    /**
	 * Compara una fecha si es menor o es el mismo día a otra
	 * 
	 * @param baseDate    fecha base
	 * @param compareDate fecha de comparación
	 * @return true si baseDate menor o igual a compareDate, false caso contrario
	 */
    public static boolean isBeforeEqual(Timestamp baseDate, Timestamp compareDate) {
    	return baseDate.before(compareDate) || TimeUtil.isSameDay(baseDate, compareDate);
    }
    
	/**
	 * @return Fecha desde parámetro
	 */
	protected Timestamp getDateFromParam() {
		return (Timestamp)getParametersValues().get("DATE");
	}
	
	/**
	 * @return Fecha hasta parámetro
	 */
	protected Timestamp getDateToParam() {
		return (Timestamp)getParametersValues().get("DATE_TO");
	}
	
	/**
	 * @return Organización parámetro
	 */
	protected Integer getOrgParam() {
		return (Integer)getParametersValues().get("AD_ORG_ID");
	}
	
	@Override
	protected void initialize() throws Exception {
		setDocuments(new ArrayList<HashMap<String,String>>());
		if(!Util.isEmpty(getPOSID(), true)) {
			setPos(new MPOS(getCtx(), getPOSID(), get_TrxName()));
			setPOSNumber(getPos().getPOSNumber());
			setClientID(getPos().getAD_Client_ID());
			setOrgID(Util.isEmpty(getOrgParam(), true) ? Env.getAD_Org_ID(getCtx()) : getOrgParam());
			setLYEIProvider();
		}
	}
	
	@Override
	protected Integer getExtremeDocumentNos(String function, Integer docTypeID) {
		String sql = "select " + function + "(numerocomprobante) "
				+ "from c_invoice where c_doctypetarget_id = " + docTypeID
				+ " and dateacct::date >= '" + Env.getDateFormatted(getDateFromParam()) + "'::date "
				+ " and dateacct::date <= '" + Env.getDateFormatted(getDateToParam()) + "'::date "
				+ (Util.isEmpty(getOrgParam(), true)?"":" and ad_org_id = "+getOrgParam())
				+ " and cae is not null ";
		return DB.getSQLValue(get_TrxName(), sql, true);
	}
	
	@Override
	protected boolean validateDocument(HashMap<String, String> document) {
		boolean validate = true;
		Date docDate = getDateParsed(document.get("CbteFch"));
		if(docDate == null) {
			log.severe("Fecha no parseable "+document.get("CbteFch"));
			return false;
		}
		Timestamp docTimestamp = new Timestamp(docDate.getTime());
		// Verificar si la fecha del comprobante se encuentra dentro del rango de fechas
		// del informe 
		validate = isBeforeEqual(getDateFromParam(), docTimestamp)
				&& isBeforeEqual(docTimestamp, getDateToParam());
		return validate;
	}
	
	@Override
	protected void processDocument(HashMap<String, String> document) throws Exception {
		getDocuments().add(document);
	}
	
	@Override
	protected void endProcess() throws Exception {
		WSFEConsultarComprobanteDataSource ds = new WSFEConsultarComprobanteDataSource(getDocuments());
		
		try {
			ds.loadData();
		} catch (RuntimeException e) {
			throw new RuntimeException("No se pueden cargar los datos del informe: " + e.getMessage(), e);
		}
		
		// Determinar JasperReport para wrapper, tabla y registro actual
		ProcessInfo base_pi = getProcessInfo();
		int AD_Process_ID = base_pi.getAD_Process_ID();
		MProcess proceso = MProcess.get(Env.getCtx(), AD_Process_ID);
		if (proceso.isJasperReport() != true)
			throw new Exception ("No es informe Jasper");
		MJasperReport jasperwrapper = new MJasperReport(getCtx(), proceso.getAD_JasperReport_ID(), get_TrxName());
		
		jasperwrapper.addParameter("DateFrom", getDateFromParam());
		jasperwrapper.addParameter("DateTo", getDateToParam());
		if(!Util.isEmpty(getOrgParam(), true)) {
			MOrg org = MOrg.get(getCtx(), getOrgParam());
			jasperwrapper.addParameter("AD_Org_ID", getOrgParam());
			jasperwrapper.addParameter("OrgValue", org.getValue());
			jasperwrapper.addParameter("OrgName", org.getName());
		}
		if(!Util.isEmpty(getPOSID(), true)) {
			jasperwrapper.addParameter("C_POS_ID", getPOSID());
			jasperwrapper.addParameter("POSNumber", getPOSNumber());
		}
		
		try {
			jasperwrapper.fillReport(ds);
			jasperwrapper.showReport(getProcessInfo());
		} catch (RuntimeException e) {
			throw new RuntimeException("No se ha podido rellenar el informe: " + e.getMessage(), e);
		}
	}

	protected ArrayList<HashMap<String, String>> getDocuments() {
		return documents;
	}

	protected void setDocuments(ArrayList<HashMap<String, String>> documents) {
		this.documents = documents;
	}
	
	@Override
	protected MDocType getDocType(ResultSet rs) throws Exception {
		if(getPOSNumber() == 0 || getPOSNumber() != rs.getInt("posnumber")) {
			int posNumber = Util.isEmpty(getPOSNumber(), true) || getPOSNumber() != rs.getInt("posnumber") ? Integer.parseInt(rs.getString("posnumber"))
					: getPOSNumber();
			setPOSNumber(posNumber);
			setClientID(rs.getInt("ad_client_id"));
			setOrgID(Util.isEmpty(getOrgParam(), true) ? rs.getInt("ad_org_id") : getOrgParam());
			setLYEIProvider();
		}
		return new MDocType(getCtx(), rs.getInt("c_doctype_id"), get_TrxName());
	}

	protected void setPOSNumber(int posNumber) {
		this.posNumber = posNumber;
	}
	
	@Override
	protected int getPOSNumber() {
		return this.posNumber;
	}
	
	@Override
	protected int getClientID() {
		return this.clientID;
	}
	
	protected void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	@Override
	protected int getOrgID() {
		return this.orgID;
	}
	
	protected void setOrgID(int orgID) {
		this.orgID = orgID;
	}
	
	protected String getMsg() {
		return "";
	}
}
