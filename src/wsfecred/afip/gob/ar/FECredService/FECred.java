package wsfecred.afip.gob.ar.FECredService;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFECRED;
import org.openXpertya.model.MBPartner;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MPOSJournal;
import org.openXpertya.model.MPreference;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;


/**
 * Clase que permite validar si una EC tiene que facturar miPyme y porque valor minimo
 *  
 * dREHER
 */


public class FECred {
	
	/** ID de la compañía */
	Integer clientID = null;
	/** ID de la organización */
	Integer orgID = null;
	/** CUIT de la compañía */
	Long cuit = null;	
	/** Recuperacion un CUIT en particular: punto de venta */
	private int ptoVta = 0;
	/** Configuracion del POS asociado a la factura */
	protected MLYEIElectronicPOSConfig posConfig;
	/** Configuracion general asociado al POS de la factura */
	protected MLYEIElectronicInvoiceConfig genConfig;
	/** CUIT del tercero a consultar */
	private Long CUIT = 0L; // para probar 30506730038
	private Date fecha = new Date();
	/** Contexto local */
	private Properties localCtx;
	/** Nombre de transacción local */
	private String localTrxName;
	
	private BigDecimal amount = Env.ZERO;
	private boolean isMiPyme = false;
	private Timestamp Updated = Env.getDate();
	
	/** Preference de tolerancia de horas para determinar la fecha  */
	public static String HOUR_TOLERANCE_PREFERENCE_NAME = "POSJournalHourTolerance";

	public FECred() {
		clientID = Env.getAD_Client_ID(getCtx());
		orgID = Env.getAD_Org_ID(getCtx());
	}
	
	/** Genera la consulta al WS de AFIP por el CUIT dado */
	public HashMap<String, String> consultarCUIT(long cuit, Date fecha) throws Exception {
		
		// Seteo datos iniciales
		setCUIT(cuit);
		setFecha(fecha);
		
		debug("consultarCUIT. cuit=" + getCUIT() + " fecha=" + getFecha());
		
		// Validaciones preliminares
		checkPreconditions();
		// Carga de valores iniciales
		loadInitialValues();

		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		HashMap<String, String> retValues = new HashMap<String, String>(); 
		retValues.put("CUIT", 	"" + cuit);
		
		LYEIWSFECRED wsfecred = new LYEIWSFECRED(posConfig);
		ConsultarMontoObligadoRecepcionReturnType re = wsfecred.consultaFromAFIP(CUIT, fecha);
		if(re!=null) {
			BigDecimal montoDesde = re.getMontoDesde();
			SiNoSimpleType sino = re.getObligado();
			String yes = sino.getValue();

			// En este punto se supone valores recibidos conformes a un CUIT encontrado
			retValues.put("Monto Minimo",			"" + (montoDesde!=null?montoDesde:"0.00"));
			retValues.put("Corresponde",			"" + (yes.equals("S")?"Si":"No"));
			
			
			setAmount(montoDesde);
			setMiPyme(yes.equals("S"));
			
			debug("Corresponde miPyme:" + (isMiPyme?"Si":"No") + " Monto minimo:" + montoDesde);
			
		}else
			debug("consultarCUIT. Se produjo un error!");
		
		return retValues; 
	}
	
	private void debug(String string) {
		System.out.println("==> FECred." + string);
	}

	/** Validaciones preliminares */
	protected void checkPreconditions() throws Exception {
		if (CUIT < 99999999)
			throw new Exception("CUIT no valido!");
		
		debug("Valido CUIT");
	}
	
	/** 
	 * Carga inicial 
	 * Sobrecarga para poder enviar el punto de venta correspondiente
	 * dREHER
	 * */
	public void loadInitialValues() throws Exception {
		
		if (MPOSJournal.isActivated() && Util.isEmpty(ptoVta, false) ) {  // dREHER ptoVta==0 debe considerarse para leer config desde Organizacion y no desde caja abierta
			MPOSJournal caja = MPOSJournal.get(Env.getCtx(), 
												Env.getAD_User_ID(getCtx()), 
												Env.getDate(), 
												new String[]{"IP"}, 
												get_TrxName());
			if(caja!=null) {
				MPOS pos = caja.getPOS();
				if(pos!=null)
					ptoVta = pos.getPOSNumber();
				else
					throw new Exception("No se encontro punto de venta en la caja abierta de este usuario!");
			}else
				throw new Exception("No se encontro una caja abierta para este usuario!");
			
		}else if (MPOSJournal.isActivated()) {
			MPOSJournal caja = getPOSJournal(Env.getCtx(), 
					Env.getAD_Org_ID(getCtx()), 
					null,
					Env.getDate(), 
					new String[]{"IP"}, 
					get_TrxName());
			
			if(caja!=null) {
				MPOS pos = caja.getPOS();
				if(pos!=null)
					ptoVta = pos.getPOSNumber();
				else
					throw new Exception("No se encontro punto de venta en la caja abierta de esta sucursal!");
			}else
				throw new Exception("No se encontro una caja abierta para esta sucursal!");
		}
		
		// TODO: ver de que manera determinar que nos encontramos en ambiente de Homolagacion o Produccion
		// podria ser mediante una preferencia... asi tomamos una config electronica que cumpla con esa 
		// condicion y listo
		
		loadInitialValues(ptoVta);
		
		debug("Carga datos inciales de configuracion..." + ptoVta);
	}
	
	/**
	 * Busca una caja abierta para la sucursal actual
	 * @param ctx
	 * @param orgID
	 * @param posID
	 * @param date
	 * @param docStatus
	 * @param trxName
	 * @return
	 * dREHER
	 */
	public MPOSJournal getPOSJournal(Properties ctx, int orgID, Integer posID, Timestamp date, String[] docStatus, String trxName) {
		MPOSJournal journal = null;
		StringBuffer sql = new StringBuffer(); 
		sql.append("SELECT * ")
		   .append("FROM C_POSJournal ")
		   .append("WHERE AD_Org_ID = ? ")
		   .append(  "AND date_trunc('day',DateTrx) = date_trunc('day',?::date) ");
		if(!Util.isEmpty(posID, true)){
			sql.append(" AND c_pos_id = ").append(posID).append(" ");
		}
		
		// Filtro de los dosStatus
		if (docStatus != null && docStatus.length > 0) {
			sql.append( "AND DocStatus IN (");
			for (int i = 0; i < docStatus.length; i++) {
				String status = docStatus[i];
				sql.append("'").append(status).append("'");
				if (i < docStatus.length - 1) {
					sql.append(",");
				}
			}
			sql.append(") "); 
		}
		sql.append("ORDER BY Created DESC");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// Verificar si existe la preference para la tolerancia de horas
		String hourToleranceValue = MPreference.searchCustomPreferenceValue(
				HOUR_TOLERANCE_PREFERENCE_NAME, Env.getAD_Client_ID(ctx),
				Env.getAD_Org_ID(ctx), Env.getAD_User_ID(ctx), true);
		if(!Util.isEmpty(hourToleranceValue, true)){
			Integer hourTolerance = Integer.parseInt(hourToleranceValue);
			Calendar newDate = Calendar.getInstance();
			// Busco la fecha actual en la base
			Timestamp actualDate = DB.getDBTimestamp(trxName);
			// Seteo la fecha parámetro
			newDate.setTimeInMillis(actualDate.getTime());
			// Restar la cantidad de horas y tomar la fecha resultante para la
			// comparación
			newDate.add(Calendar.HOUR_OF_DAY, hourTolerance * -1);
			date = new Timestamp(newDate.getTimeInMillis());
		}
		
		try {
			pstmt = DB.prepareStatement(sql.toString(), trxName);
			pstmt.setInt(1, orgID);
			pstmt.setTimestamp(2, date);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				journal = new MPOSJournal(ctx, rs, trxName);
			}
			
		} catch (Exception e) {
			System.out.println("Error getting POS Journal. OrgID="
					+ orgID + ", Date=" + date);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) { }
		}
		return journal;
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:0), getOrgID(), getCtx(), null);
		if (posConfig==null) { 
		
			// Si no encontro una configuracion electronica para el punto de venta indicado, seguramente
			// estan trabajando con una caja de impresora fiscal, de todas maneras debe validar mipyme
			// y para ello requiere una configuracion de factura electronica activa y validada dentro
			// de la misma organizacion
			posConfig = MLYEIElectronicPOSConfig.get(getCtx(), null, getOrgID());
			if (posConfig==null)
				throw new Exception("No se ha encontrado configuracion electronica "
					+ " la organizacion del tipo de documento (" + getOrgID() + ")");
			
			this.ptoVta = posConfig.getPOS();
		}
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + getClientID() + ". " + ex.getMessage());
		}
	}
	
	/**
	 * Guarda la informacion de miPyme en la Entidad Comercial
	 * @param bp
	 * dREHER
	 */
	public void updatedBPMiPyme(MBPartner bp) {
		
		System.out.println("FECred.updatedBPMiPyme. Guarda la info de MiPyme en la EC CUIT=" + bp.getTaxID());
		
		bp.set_Value("IsMiPyme", isMiPyme());
		bp.set_Value("MiPymeUpdated", getUpdated());
		bp.set_Value("MiPymeAmount", getAmount());
		
		if(bp.save())
			System.out.println("FECred.updatedBPMiPyme. Guardo data en el cliente CUIT:" + bp.getTaxID());
		else {
			System.out.println("FECred.updatedBPMiPyme. No pudo guardar la actualizacion de info miPyme en el cliente CUIT:"+ bp.getTaxID());
			String up = "UPDATE C_BPartner SET IsMiPyme='" + (isMiPyme()?"Y":"N") + "', " +
					" MiPymeUpdated='" + getUpdated() + "', " +
					" MiPymeAmount= " + getAmount() + ", " +
					" Updated=now(), " +
					" UpdatedBy=" + Env.getAD_User_ID(getCtx()) + " " +
					" WHERE C_BPartner_ID=" + bp.getC_BPartner_ID();
			System.out.println("Se actualiza por BDD - cliente CUIT:" + up);
			int ups = DB.executeUpdate(up, get_TrxName());
			if(ups==-1)
				System.out.println("No pudo actualizar cliente CUIT:" + getCUIT());
		}
	}
	
	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cuit) {
		this.CUIT = cuit;
	}

	public Properties getCtx() {
		if (localCtx != null) {
			return localCtx;
		} else {
			return Env.getCtx();
		}
	}
	
	public String get_TrxName() {
		if (!Util.isEmpty(localTrxName, true)) {
			return localTrxName;
		} else {
			return null;
		}
	}
	
	public Integer getClientID() {
		return clientID;
	}
	
	public Integer getOrgID() {
		return orgID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		if(amount==null)
			amount = Env.ZERO;
		this.amount = amount;
	}

	public boolean isMiPyme() {
		return isMiPyme;
	}

	public void setMiPyme(boolean isMiPyme) {
		this.isMiPyme = isMiPyme;
	}

	public Timestamp getUpdated() {
		return Updated;
	}

	public void setUpdated(Timestamp updated) {
		Updated = updated;
	}

}
