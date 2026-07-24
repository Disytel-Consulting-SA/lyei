package org.libertya.locale.ar.electronicInvoice.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Properties;

import org.libertya.locale.ar.electronicInvoice.model.LP_C_LYEIElectronicPOSConfig;
import org.openXpertya.model.MClient;
import org.openXpertya.model.MPreference;
import org.openXpertya.model.MSocialConversation;
import org.openXpertya.model.MSocialMessage;
import org.openXpertya.model.ModelValidationEngine;
import org.openXpertya.model.ModelValidator;
import org.openXpertya.model.PO;
import org.openXpertya.reflection.CallResult;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;

public class LYEICRTAboutToExpireValidator implements ModelValidator {


	/** Contexto */
	Properties m_ctx = new Properties();
	
	/** Static Logger */
    private static CLogger	log	= CLogger.getCLogger(LYEICRTAboutToExpireValidator.class);
	
    /** Subject del mensaje de aviso al usuario */
    protected static final String WARNING_SUBJECT = "Certificados RECE proximos a vencer!";
    
    /** Preferencia: dias proxima a expirar para notificar. Si es menor a 0, no se realizan notificaciones */
    protected static final String WARNING_WINDOW_DAYS_PREFERENCE = "LYEI_RECE_WARNING_WINDOW_DAYS";
    
    /** Valor por defecto: días próximo a expirar para notificar */
    protected static final Integer WARNING_WINDOW_DAYS_DEFAULT = 10;
    
    /** Ventana de tiempo de antelacion en dias a considerar para notificar */
    protected Integer warningWindowDays = null;
    
	@Override
	public String docValidate(PO po, int timing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		setAD_Client_ID(client.getID());
		try {
		warningWindowDays = Integer.parseInt(MPreference.GetCustomPreferenceValue(WARNING_WINDOW_DAYS_PREFERENCE));
		} catch (Exception e) {
			warningWindowDays = WARNING_WINDOW_DAYS_DEFAULT;
		}
	}

	@Override
	public CallResult login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		setAD_Org_ID(AD_Org_ID);
		setAD_User_ID(AD_User_ID);
		checkForNearExpirations(getAD_Client_ID(), AD_Org_ID, AD_User_ID);
		return null;
	}
	
	@Override
	public String loginString(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		setAD_Org_ID(AD_Org_ID);
		setAD_User_ID(AD_User_ID);
		checkForNearExpirations(getAD_Client_ID(), AD_Org_ID, AD_User_ID);
		return null;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAD_Client_ID() {
		try {
			return (Integer)m_ctx.get("#AD_Client_ID");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getAD_Org_ID() {
		try {
			return (Integer)m_ctx.get("#AD_Org_ID");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getAD_User_ID() {
		try {
			return (Integer)m_ctx.get("#AD_User_ID");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public void setAD_Client_ID(int clientID) {
		m_ctx.put("#AD_Client_ID", clientID);
	}
	
	public void setAD_Org_ID(int orgID) {
		m_ctx.put("#AD_Org_ID", orgID);
	}
	
	public void setAD_User_ID(int userID) {
		m_ctx.put("#AD_User_ID", userID);
	}
	

    private void checkForNearExpirations( int AD_Client_ID,int AD_Org_ID,int AD_User_ID ) {
    	
		// Recuperar todos los POSConfigIDs con igual CRT en busca de uno con TA no expirado
		int[] posConfigIDs = PO.getAllIDs(LP_C_LYEIElectronicPOSConfig.Table_Name, 
								" ad_client_id = 1010016 " +
								" and isactive = 'Y' ",
							null);

		Long daysLeft = null;
		StringBuffer content = new StringBuffer();
		for (int curPosConfigID : posConfigIDs) {
			LP_C_LYEIElectronicPOSConfig curPOSConfig = new LP_C_LYEIElectronicPOSConfig(m_ctx, curPosConfigID, null);
			if (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Homo.equals(curPOSConfig.getCurrentEnvironment())) {
				daysLeft = LYEIWSAA.daysUntilExpirationCRT(curPOSConfig.getTestCRT());
			} else if (LP_C_LYEIElectronicPOSConfig.CURRENTENVIRONMENT_Prod.equals(curPOSConfig.getCurrentEnvironment())) { 
				daysLeft = LYEIWSAA.daysUntilExpirationCRT(curPOSConfig.getProductionCRT());
			}
			
			if (daysLeft!=null && warningWindowDays >= 0 && daysLeft >= 0 && daysLeft <= warningWindowDays) {
				content.append("PtoVta " + curPOSConfig.getPOS() + " vence en " + daysLeft + " días. ");
			}
		}
		if (content.length()>0) {
			warning(content.toString());
		}
		
	}
     	
    protected void warning(String content) {
    	try {
    		// Validar si el usuario ya tiene una notificacion previa sobre certificados proximos a vencer
    		// En caso afirmativo, se reutiliza la misma notificacion
    		PreparedStatement ps = DB.prepareStatement(
    				" SELECT sc.C_SocialConversation_ID " + 
    				" FROM C_SocialConversation sc " +
    				" INNER JOIN C_SocialSubscription ss USING (C_SocialConversation_ID) " +
    				" WHERE sc.AD_Client_ID = " + getAD_Client_ID() + 
    				" AND ss.AD_User_ID = " + getAD_User_ID() +
    				" AND sc.subject = '" + WARNING_SUBJECT + "'");
    		ResultSet rs = ps.executeQuery();
    		int scID = 0;
    		if (rs.next()) {
    			scID = rs.getInt(1);
    		}
    		
    		// Nueva/actualizar conversacion
			MSocialConversation conversation = new MSocialConversation( m_ctx, scID,null ); 
			conversation.setClientOrg( getAD_Client_ID(), getAD_Org_ID());
			conversation.setStartedBy( getAD_User_ID() );
			conversation.setSubject( WARNING_SUBJECT );
			
			// Si ya se notificó en el día de hoy para una conversacion existente, no volver a hacerlo
			LocalDate today = LocalDate.now();
			LocalDate lastWarning = conversation.getUpdated().toLocalDateTime().toLocalDate();
			if (conversation.getID() > 0 && (today.isEqual(lastWarning))) {
				return;
			}
						
			if( !conversation.save()) {
			    log.warning( "No se pudo iniciar la conversacion" );
			    return;
			}
			
			// Suscripcion
			conversation.subscribe(getAD_User_ID(), false, false);
			conversation.markAsReadNotRead(getAD_User_ID(), false);
			  
			// Mensaje
			MSocialMessage message = new MSocialMessage( m_ctx,0,null );
			message.setClientOrg( getAD_Client_ID(), getAD_Org_ID());
			message.setC_SocialConversation_ID( conversation.getC_SocialConversation_ID());
			message.setSentBy( getAD_User_ID() );
			message.setMsgContent( content );
			
			if( !message.save()) {
			    log.warning( "No se pudo crear el mensaje" );
			}    	
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
   

}
