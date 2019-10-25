/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEIElectronicInvoiceConfig
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2019-10-24 10:55:11.354 */
public class LP_C_LYEIElectronicInvoiceConfig extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEIElectronicInvoiceConfig (Properties ctx, int C_LYEIElectronicInvoiceConfig_ID, String trxName)
{
super (ctx, C_LYEIElectronicInvoiceConfig_ID, trxName);
/** if (C_LYEIElectronicInvoiceConfig_ID == 0)
{
setApplicant (null);
setApplicantChanged (false);
setC_LYEIElectronicInvoiceConfig_ID (0);
setConfigType (null);	// C
setCUIT (null);
setCuitChanged (false);
setName (null);
setNameChanged (false);
setProcessed (false);
}
 */
}
/** Load Constructor */
public LP_C_LYEIElectronicInvoiceConfig (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEIElectronicInvoiceConfig");

/** TableName=C_LYEIElectronicInvoiceConfig */
public static final String Table_Name="C_LYEIElectronicInvoiceConfig";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEIElectronicInvoiceConfig");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEIElectronicInvoiceConfig[").append(getID()).append("]");
return sb.toString();
}
/** Set AliasEmisor */
public void setAliasEmisor (String AliasEmisor)
{
if (AliasEmisor != null && AliasEmisor.length() > 100)
{
log.warning("Length > 100 - truncated");
AliasEmisor = AliasEmisor.substring(0,100);
}
set_Value ("AliasEmisor", AliasEmisor);
}
/** Get AliasEmisor */
public String getAliasEmisor() 
{
return (String)get_Value("AliasEmisor");
}
/** Set Applicant */
public void setApplicant (String Applicant)
{
if (Applicant == null) throw new IllegalArgumentException ("Applicant is mandatory");
if (Applicant.length() > 100)
{
log.warning("Length > 100 - truncated");
Applicant = Applicant.substring(0,100);
}
set_Value ("Applicant", Applicant);
}
/** Get Applicant */
public String getApplicant() 
{
return (String)get_Value("Applicant");
}
/** Set ApplicantChanged */
public void setApplicantChanged (boolean ApplicantChanged)
{
set_Value ("ApplicantChanged", new Boolean(ApplicantChanged));
}
/** Get ApplicantChanged */
public boolean isApplicantChanged() 
{
Object oo = get_Value("ApplicantChanged");
if (oo != null) 
{
 if (oo instanceof Boolean) return ((Boolean)oo).booleanValue();
 return "Y".equals(oo);
}
return false;
}
/** Set CBUEmisor */
public void setCBUEmisor (String CBUEmisor)
{
if (CBUEmisor != null && CBUEmisor.length() > 100)
{
log.warning("Length > 100 - truncated");
CBUEmisor = CBUEmisor.substring(0,100);
}
set_Value ("CBUEmisor", CBUEmisor);
}
/** Get CBUEmisor */
public String getCBUEmisor() 
{
return (String)get_Value("CBUEmisor");
}
/** Set CleanCSR */
public void setCleanCSR (String CleanCSR)
{
if (CleanCSR != null && CleanCSR.length() > 1)
{
log.warning("Length > 1 - truncated");
CleanCSR = CleanCSR.substring(0,1);
}
set_Value ("CleanCSR", CleanCSR);
}
/** Get CleanCSR */
public String getCleanCSR() 
{
return (String)get_Value("CleanCSR");
}
/** Set CleanKey */
public void setCleanKey (String CleanKey)
{
if (CleanKey != null && CleanKey.length() > 1)
{
log.warning("Length > 1 - truncated");
CleanKey = CleanKey.substring(0,1);
}
set_Value ("CleanKey", CleanKey);
}
/** Get CleanKey */
public String getCleanKey() 
{
return (String)get_Value("CleanKey");
}
/** Set C_LYEIElectronicInvoiceConfig_ID */
public void setC_LYEIElectronicInvoiceConfig_ID (int C_LYEIElectronicInvoiceConfig_ID)
{
set_ValueNoCheck ("C_LYEIElectronicInvoiceConfig_ID", new Integer(C_LYEIElectronicInvoiceConfig_ID));
}
/** Get C_LYEIElectronicInvoiceConfig_ID */
public int getC_LYEIElectronicInvoiceConfig_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicInvoiceConfig_ID");
if (ii == null) return 0;
return ii.intValue();
}
public static final int CONFIGTYPE_AD_Reference_ID = MReference.getReferenceID("LYEIConfigType");
/** Necesito generar el certificado CSR = C */
public static final String CONFIGTYPE_NecesitoGenerarElCertificadoCSR = "C";
/** Ya cuento con el certificado CSR = S */
public static final String CONFIGTYPE_YaCuentoConElCertificadoCSR = "S";
/** Set ConfigType */
public void setConfigType (String ConfigType)
{
if (ConfigType.equals("C") || ConfigType.equals("S") || ( refContainsValue("LYEI-AD_Reference-1010329", ConfigType) ) );
 else throw new IllegalArgumentException ("ConfigType Invalid value: " + ConfigType + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010329") );
if (ConfigType == null) throw new IllegalArgumentException ("ConfigType is mandatory");
if (ConfigType.length() > 1)
{
log.warning("Length > 1 - truncated");
ConfigType = ConfigType.substring(0,1);
}
set_Value ("ConfigType", ConfigType);
}
/** Get ConfigType */
public String getConfigType() 
{
return (String)get_Value("ConfigType");
}
/** Set ConfirmConfiguration */
public void setConfirmConfiguration (String ConfirmConfiguration)
{
if (ConfirmConfiguration != null && ConfirmConfiguration.length() > 1)
{
log.warning("Length > 1 - truncated");
ConfirmConfiguration = ConfirmConfiguration.substring(0,1);
}
set_Value ("ConfirmConfiguration", ConfirmConfiguration);
}
/** Get ConfirmConfiguration */
public String getConfirmConfiguration() 
{
return (String)get_Value("ConfirmConfiguration");
}
/** Set CreateElectronicPOS */
public void setCreateElectronicPOS (String CreateElectronicPOS)
{
if (CreateElectronicPOS != null && CreateElectronicPOS.length() > 1)
{
log.warning("Length > 1 - truncated");
CreateElectronicPOS = CreateElectronicPOS.substring(0,1);
}
set_Value ("CreateElectronicPOS", CreateElectronicPOS);
}
/** Get CreateElectronicPOS */
public String getCreateElectronicPOS() 
{
return (String)get_Value("CreateElectronicPOS");
}
/** Set CUIT */
public void setCUIT (String CUIT)
{
if (CUIT == null) throw new IllegalArgumentException ("CUIT is mandatory");
if (CUIT.length() > 20)
{
log.warning("Length > 20 - truncated");
CUIT = CUIT.substring(0,20);
}
set_Value ("CUIT", CUIT);
}
/** Get CUIT */
public String getCUIT() 
{
return (String)get_Value("CUIT");
}
public KeyNamePair getKeyNamePair() 
{
return new KeyNamePair(getID(), getCUIT());
}
/** Set CuitChanged */
public void setCuitChanged (boolean CuitChanged)
{
set_Value ("CuitChanged", new Boolean(CuitChanged));
}
/** Get CuitChanged */
public boolean isCuitChanged() 
{
Object oo = get_Value("CuitChanged");
if (oo != null) 
{
 if (oo instanceof Boolean) return ((Boolean)oo).booleanValue();
 return "Y".equals(oo);
}
return false;
}
/** Set EditConfiguration */
public void setEditConfiguration (String EditConfiguration)
{
if (EditConfiguration != null && EditConfiguration.length() > 1)
{
log.warning("Length > 1 - truncated");
EditConfiguration = EditConfiguration.substring(0,1);
}
set_Value ("EditConfiguration", EditConfiguration);
}
/** Get EditConfiguration */
public String getEditConfiguration() 
{
return (String)get_Value("EditConfiguration");
}
/** Set ElectronicInvoiceBaseDir */
public void setElectronicInvoiceBaseDir (String ElectronicInvoiceBaseDir)
{
if (ElectronicInvoiceBaseDir != null && ElectronicInvoiceBaseDir.length() > 255)
{
log.warning("Length > 255 - truncated");
ElectronicInvoiceBaseDir = ElectronicInvoiceBaseDir.substring(0,255);
}
set_Value ("ElectronicInvoiceBaseDir", ElectronicInvoiceBaseDir);
}
/** Get ElectronicInvoiceBaseDir */
public String getElectronicInvoiceBaseDir() 
{
return (String)get_Value("ElectronicInvoiceBaseDir");
}
/** Set Name.
Alphanumeric identifier of the entity */
public void setName (String Name)
{
if (Name == null) throw new IllegalArgumentException ("Name is mandatory");
if (Name.length() > 100)
{
log.warning("Length > 100 - truncated");
Name = Name.substring(0,100);
}
set_Value ("Name", Name);
}
/** Get Name.
Alphanumeric identifier of the entity */
public String getName() 
{
return (String)get_Value("Name");
}
/** Set NameChanged */
public void setNameChanged (boolean NameChanged)
{
set_Value ("NameChanged", new Boolean(NameChanged));
}
/** Get NameChanged */
public boolean isNameChanged() 
{
Object oo = get_Value("NameChanged");
if (oo != null) 
{
 if (oo instanceof Boolean) return ((Boolean)oo).booleanValue();
 return "Y".equals(oo);
}
return false;
}
/** Set Processed.
The document has been processed */
public void setProcessed (boolean Processed)
{
set_Value ("Processed", new Boolean(Processed));
}
/** Get Processed.
The document has been processed */
public boolean isProcessed() 
{
Object oo = get_Value("Processed");
if (oo != null) 
{
 if (oo instanceof Boolean) return ((Boolean)oo).booleanValue();
 return "Y".equals(oo);
}
return false;
}
/** Set RSACsr */
public void setRSACsr (byte[] RSACsr)
{
set_Value ("RSACsr", RSACsr);
}
/** Get RSACsr */
public byte[] getRSACsr() 
{
return (byte[])get_Value("RSACsr");
}
/** Set RSAKey */
public void setRSAKey (byte[] RSAKey)
{
set_Value ("RSAKey", RSAKey);
}
/** Get RSAKey */
public byte[] getRSAKey() 
{
return (byte[])get_Value("RSAKey");
}
/** Set SetEnvironment */
public void setSetEnvironment (String SetEnvironment)
{
if (SetEnvironment != null && SetEnvironment.length() > 1)
{
log.warning("Length > 1 - truncated");
SetEnvironment = SetEnvironment.substring(0,1);
}
set_Value ("SetEnvironment", SetEnvironment);
}
/** Get SetEnvironment */
public String getSetEnvironment() 
{
return (String)get_Value("SetEnvironment");
}
}
