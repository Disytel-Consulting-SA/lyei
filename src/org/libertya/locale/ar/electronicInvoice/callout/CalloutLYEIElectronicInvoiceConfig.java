package org.libertya.locale.ar.electronicInvoice.callout;

import java.util.Properties;

import org.openXpertya.model.MClient;
import org.openXpertya.model.MClientInfo;
import org.openXpertya.model.MField;
import org.openXpertya.model.MOrgInfo;
import org.openXpertya.model.MTab;
import org.openXpertya.model.X_AD_Org;
import org.openXpertya.model.X_AD_OrgInfo;
import org.openXpertya.plugin.CalloutPluginEngine;
import org.openXpertya.plugin.MPluginStatusCallout;

public class CalloutLYEIElectronicInvoiceConfig  extends CalloutPluginEngine {
	
	public MPluginStatusCallout postAD_Org_ID( Properties ctx,int WindowNo,MTab mTab,MField mField,Object value ) {

		// Asignar el nombre segun configuracion de organizacion
		setName(ctx, WindowNo, mTab, mField, value);
		
		return state;
	}
	

	/** 
	 * Asigna el nombre al registro según el siguiente criterio: 
	 * 		Si la Organización es * o no tiene CUIT entonces asigna el Nombre de la Compañía		
	 * 		Si la Organización no es * y tiene CUIT entonces asigna el Nombre de la Organización
	 */
	protected void setName(Properties ctx,int WindowNo,MTab mTab,MField mField,Object value ) {

		// Por defecto se supone organización 0 
		MClientInfo thisClientInfo = MClientInfo.get(ctx);
		String name = MClient.get(ctx).getName();
		String cuit = thisClientInfo.getCUIT() == null ? "" : thisClientInfo.getCUIT().replace("-", "").replace(" ", "");
		
		// Se especifico organizacion distinta a 0?
		int orgID = (Integer)mTab.getValue("AD_Org_ID");
		if (orgID != 0) {
			
			// No es posible utilizar organizaciones de tipo carpeta
			X_AD_Org anOrg = new X_AD_Org(ctx, orgID, null);
			if (anOrg.isSummary())
				return;
			
			X_AD_OrgInfo anOrgInfo = MOrgInfo.get(ctx, orgID);
			boolean hasCuit = (anOrgInfo.getCUIT()!=null && anOrgInfo.getCUIT().length()>0);
			boolean hasName = (anOrg.getName()!=null && anOrg.getName().length()>0);
			
			// Si la org (distinta a 0) tiene cuit (y nombre) entonces le asignamos el name
			if (hasCuit && hasName) {
				name = anOrg.getName();
				cuit = anOrgInfo.getCUIT().replace("-", "").replace(" ", "");
			}
		}
		
		// Asignar los valores
		mTab.setValue("Name", name);
		mTab.setValue("Cuit", cuit);
	}

}
