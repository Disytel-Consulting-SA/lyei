package sr.puc.server.ws.soap.a5;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicInvoiceConfig;
import org.libertya.locale.ar.electronicInvoice.model.MLYEIElectronicPOSConfig;
import org.libertya.locale.ar.electronicInvoice.utils.LYEIWSCI;
import org.openXpertya.model.MPOS;
import org.openXpertya.model.MPOSJournal;
import org.openXpertya.util.Env;
import org.openXpertya.util.Util;

/**
 * Clase que permite comunicarse a AFIP servicio ws_persona_a5 y traer informacion
 * asociada a un determinado CUIT
 * dREHER
 */

public class WSCI {
	
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

	/** Contexto local */
	private Properties localCtx;
	
	/** Nombre de transacción local */
	private String localTrxName;

	
	public WSCI() {
		clientID = Env.getAD_Client_ID(getCtx());
		orgID = Env.getAD_Org_ID(getCtx());
	}
	
	/** Genera la consulta al WS de AFIP por el CUIT dado */
	public LinkedHashMap<String, String> consultarCUIT(long cuit) throws Exception {
		
		// Seteo datos iniciales
		setCUIT(cuit);
		// Validaciones preliminares
		checkPreconditions();
		// Carga de valores iniciales
		loadInitialValues();
		
		// Valores minimos a retornar, bien sea error o no (numero de documento, tipo de comprobante y punto de venta)
		LinkedHashMap<String, String> retValues = new LinkedHashMap<String, String>(); 
		retValues.put("CUIT", 	"" + cuit);

		LYEIWSCI wsci = new LYEIWSCI(posConfig);
		PersonaReturn persona = wsci.consultaFromAFIP(CUIT);
		if(persona==null)
			return retValues;
				
		// Error recibido desde WSCI de AFIP
		if (persona.getErrorConstancia() != null && persona.getErrorConstancia().getError().length > 0) {
			StringBuffer completeErrorStr = new StringBuffer();
			for (String error : persona.getErrorConstancia().getError()) {
				StringBuffer errorStr = new StringBuffer();
				errorStr.append(error);
				completeErrorStr.append(errorStr);
			}
			retValues.put("Resultado", "Error: " + completeErrorStr.toString());
			System.out.println("[WSFECI] Error para CUIT " + cuit + ": " + completeErrorStr.toString());
			return retValues;
		}
		
		// En este punto se supone valores recibidos conformes a un CUIT encontrado
		
		retValues.put("DatosMetadata",			"");
		Metadata md = persona.getMetadata();
		if(md!=null) {
			Calendar cal = md.getFechaHora();
			Date fecha = cal.getTime();
			retValues.put("MD		Fecha y Hora",		"" + fecha);
			retValues.put("MD		Servidor",		"" + md.getServidor());
			retValues.put("------------------------","---------------------------");
		}
		
		retValues.put("DatosGenerales","");
		DatosGenerales dg = persona.getDatosGenerales();
		if(dg!=null) {
			retValues.put("DG		Nombre",	"" + dg.getNombre());
			retValues.put("DG		Apellido",		"" + dg.getApellido());
			retValues.put("DG		Sucesion",		"" + dg.getEsSucesion());
			retValues.put("DG		Estado Clave",	"" + dg.getEstadoClave());
			retValues.put("DG		Razon Social",	"" + dg.getRazonSocial());
			retValues.put("DG		Tipo Clave",	"" + dg.getTipoClave());
			retValues.put("DG		Tipo Persona",	"" + dg.getTipoPersona());
			retValues.put("DG		Id Persona",	"" + dg.getIdPersona());
			retValues.put("DG		Mes cierre",	"" + dg.getMesCierre());
			retValues.put("DG		Domicilio fiscal",	"");
			Domicilio d = dg.getDomicilioFiscal();
			if(d!=null) {
				retValues.put("DF			Domicilio",	"" + d.getTipoDomicilio());
				retValues.put("DF			Direccion",	"" + d.getDireccion());
				retValues.put("DF			Cod Postal",	"" + d.getCodPostal());
				retValues.put("DF			Localidad",	"" + d.getLocalidad());
				retValues.put("DF			Provincia",	"" + d.getDescripcionProvincia());
				retValues.put("DF			Dato Adicional",	"" + d.getTipoDatoAdicional());
			}
			retValues.put("------------------------","---------------------------");
			
			retValues.put("DRG Caracterizaciones", "");
			Caracterizacion[] cars = dg.getCaracterizacion();
			if(cars!=null) {
				int i = 0;
				for(Caracterizacion a: cars) {
					i++;
					retValues.put("DRG-CA" + i +"	Id Caracterizacion",		"" + a.getIdCaracterizacion());
					retValues.put("DRG-CA" + i +"	Descripcion",		"" + a.getDescripcionCaracterizacion());
					retValues.put("DRG-CA" + i +"	Periodo",		"" + a.getPeriodo());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}
			
		}
		
		retValues.put("------------------------","---------------------------");
		
		
		retValues.put("DatosRegimenGeneral","");
		DatosRegimenGeneral drg = persona.getDatosRegimenGeneral();
		if(drg!=null) {

			Actividad[] act = drg.getActividad();
			retValues.put("DRG Actividad", "");
			if(act!=null) {
				int i = 0;
				for(Actividad a: act) {
					i++;
					retValues.put("DRG-A" + i +"	Descripcion",		"" + a.getDescripcionActividad());
					retValues.put("DRG-A" + i +"	Periodo",		"" + a.getPeriodo());
					retValues.put("DRG-A" + i +"	Orden",		"" + a.getOrden());
					retValues.put("DRG-A" + i +"	Nomenclador",		"" + a.getNomenclador());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}
			
			retValues.put("DRG Categoria autonomo",	"");
			Categoria cat = drg.getCategoriaAutonomo();
			if(cat!=null) {
				retValues.put("DRG-CA		Id Categoria",		"" + cat.getIdCategoria());
				retValues.put("DRG-CA		Id Impuesto",		"" + cat.getIdImpuesto());
				retValues.put("DRG-CA		Categoria",		"" + cat.getDescripcionCategoria());
				retValues.put("DRG-CA		Periodo",		"" + cat.getPeriodo());
				retValues.put("------------------------","---------------------------");
			}
			
			retValues.put("DRG Regimen",	"");
			Regimen[] regs = drg.getRegimen();
			if(regs!=null) {
				int x = 0;
				for(Regimen reg: regs) {
					x++;
					retValues.put("DRG-RE" + x + " Id Regimen",		"" + reg.getIdRegimen());
					retValues.put("DRG-RE" + x + " Tipo Regimen",		"" + reg.getTipoRegimen());
					retValues.put("DRG-RE" + x + " Id Impuesto",		"" + reg.getIdImpuesto());
					retValues.put("DRG-RE" + x + " Categoria",		"" + reg.getDescripcionRegimen());
					retValues.put("DRG-RE" + x + " Periodo",		"" + cat.getPeriodo());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}
			
			Impuesto[] i = drg.getImpuesto();
			retValues.put("DRG IM Impuesto", "");
			if(i!=null) {
				int x = 0;
				for(Impuesto imp: i) {
					x++;
					retValues.put("I-I" + x + "	Descripcion",		"" + imp.getDescripcionImpuesto());
					retValues.put("I-I" + x + "	Estado",		"" + imp.getEstadoImpuesto());
					retValues.put("I-I" + x + "	Id",		"" + imp.getIdImpuesto());
					retValues.put("I-I" + x + "	Motivo",		"" + imp.getMotivo());
					retValues.put("I-I" + x + "	Periodo",		"" + imp.getPeriodo());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}
			
		}
		
		DatosMonotributo m = persona.getDatosMonotributo();
		if(m!=null) {
			retValues.put("DM Datos Monotributo",	"");
			retValues.put("DM		Categoria Monotributo",		"");
			Categoria cat = m.getCategoriaMonotributo();
			if(cat!=null) {
				retValues.put("DM-CA		Id Categoria",		"" + cat.getIdCategoria());
				retValues.put("DM-CA		Id Impuesto",		"" + cat.getIdImpuesto());
				retValues.put("DM-CA		Descripcion",		"" + cat.getDescripcionCategoria());
				retValues.put("DM-CA		Periodo",		"" + cat.getPeriodo());
				retValues.put("------------------------","---------------------------");
			}
			
			retValues.put("DM		Actividad Monotributo",		"");
			Actividad am = m.getActividadMonotributista();
			if(am!=null) {
				retValues.put("DM-AM		Descripcion",		"" + am.getDescripcionActividad());
				retValues.put("DM-AM		Periodo",		"" + am.getPeriodo());
				retValues.put("DM-AM		Orden",		"" + am.getOrden());
				retValues.put("DM-AM		Nomenclador",		"" + am.getNomenclador());
				retValues.put("------------------------","---------------------------");
			}

			Actividad[] a = m.getActividad();
			retValues.put("DM-A Actividad", "");
			if(a!=null) {
				int i = 0;
				for(Actividad act: a) {
					i++;
					retValues.put("DM-AC" + i + "	Descripcion",		"" + act.getDescripcionActividad());
					retValues.put("DM-AC" + i + "	Periodo",		"" + act.getPeriodo());
					retValues.put("DM-AC" + i + "	Orden",		"" + act.getOrden());
					retValues.put("DM-AC" + i + "	Nomenclador",		"" + act.getNomenclador());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}

			Relacion[] r = m.getComponenteDeSociedad();
			retValues.put("RS Relacion de Sociedad", "");
			if(r!=null) {
				int i = 0;
				for(Relacion act: r) {
					i++;
					retValues.put("RS-R" + i + "	Nombre",		"" + act.getNombrePersonaAsociada());
					retValues.put("RS-R" + i + "	Apellido",		"" + act.getApellidoPersonaAsociada());
					retValues.put("RS-R" + i + "	Razon Social",		"" + act.getRazonSocialPersonaAsociada());
					retValues.put("RS-R" + i + "	Id Socio",		"" + act.getIdPersonaAsociada());
					retValues.put("RS-R" + i + "	Tipo Componente",		"" + act.getTipoComponente());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}

			Impuesto[] i = m.getImpuesto();
			retValues.put("I Impuesto", "");
			if(i!=null) {
				int x = 0;
				for(Impuesto act: i) {
					x++;
					retValues.put("I-I" + x + "	Descripcion",		"" + act.getDescripcionImpuesto());
					retValues.put("I-I" + x + "	Estado",		"" + act.getEstadoImpuesto());
					retValues.put("I-I" + x + "	Id",		"" + act.getIdImpuesto());
					retValues.put("I-I" + x + "	Motivo",		"" + act.getMotivo());
					retValues.put("I-I" + x + "	Periodo",		"" + act.getPeriodo());
					retValues.put("------------------------","---------------------------");
				}
				retValues.put("------------------------","---------------------------");
			}
		}
		
		return retValues; 
	}
	
	/** Validaciones preliminares */
	protected void checkPreconditions() throws Exception {
		if (CUIT < 99999999)
			throw new Exception("CUIT no valido!");
	}
	
	/** 
	 * Carga inicial 
	 * Sobrecarga para poder enviar el punto de venta correspondiente
	 * dREHER
	 * */
	public void loadInitialValues() throws Exception {
		
		if (MPOSJournal.isActivated() && Util.isEmpty(ptoVta, true) ) {
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
			
		}
		
		loadInitialValues(ptoVta);
	}
	
	/** Carga inicial */
	public void loadInitialValues(int ptoVta) throws Exception {
		// Token & Sign
		posConfig = MLYEIElectronicPOSConfig.get((ptoVta>0?ptoVta:0), getOrgID(), getCtx(), null);
		if (posConfig==null) 
			throw new Exception("No se ha encontrado configuracion electronica para el punto de venta " + (ptoVta>0?ptoVta:0)
					+ " y la organizacion del tipo de documento (" + getOrgID() + ")");
		
		/**
		HashMap<String, String> tokenAndSign = LYEIWSAA.getTokenAndSign(posConfig, getCtx(), posConfig.getCurrentEnvironment());
		token = tokenAndSign.get(LYEIWSAA.TA_TOKEN);
		sign = tokenAndSign.get(LYEIWSAA.TA_SIGN);
		
		El token de autenticacion lo obtiene el mismo servicio, no hace falta llamar		
				
		*/
		// Cuit
		try {
			genConfig = new  MLYEIElectronicInvoiceConfig(getCtx(), posConfig.getC_LYEIElectronicInvoiceConfig_ID(), get_TrxName());
			cuit = Long.parseLong(genConfig.getCUIT());
		} catch (Exception ex) {
			throw new Exception ("Error al recuperar CUIT de la BBDD de compañía " + getClientID() + ". " + ex.getMessage());
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
	
}
