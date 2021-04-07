/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEIElectronicPOSConfig
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-04-05 13:13:06.518 */
public class LP_C_LYEIElectronicPOSConfig extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEIElectronicPOSConfig (Properties ctx, int C_LYEIElectronicPOSConfig_ID, String trxName)
{
super (ctx, C_LYEIElectronicPOSConfig_ID, trxName);
/** if (C_LYEIElectronicPOSConfig_ID == 0)
{
setCAEMethod (null);	// C
setC_LYEIElectronicInvoiceConfig_ID (0);
setC_LYEIElectronicPOSConfig_ID (0);
setCurrentEnvironment (null);
setPOS (0);
setPOSService (null);	// N
}
 */
}
/** Load Constructor */
public LP_C_LYEIElectronicPOSConfig (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEIElectronicPOSConfig");

/** TableName=C_LYEIElectronicPOSConfig */
public static final String Table_Name="C_LYEIElectronicPOSConfig";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEIElectronicPOSConfig");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEIElectronicPOSConfig[").append(getID()).append("]");
return sb.toString();
}
public static final int CAEMETHOD_AD_Reference_ID = MReference.getReferenceID("LYEICAEMethod");
/** CAE = C */
public static final String CAEMETHOD_CAE = "C";
/** CAEA = A */
public static final String CAEMETHOD_CAEA = "A";
/** Set CAEMethod */
public void setCAEMethod (String CAEMethod)
{
if (CAEMethod.equals("C") || CAEMethod.equals("A") || ( refContainsValue("LYEI-AD_Reference-20210405120640022-010708", CAEMethod) ) );
 else throw new IllegalArgumentException ("CAEMethod Invalid value: " + CAEMethod + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-20210405120640022-010708") );
if (CAEMethod == null) throw new IllegalArgumentException ("CAEMethod is mandatory");
if (CAEMethod.length() > 1)
{
log.warning("Length > 1 - truncated");
CAEMethod = CAEMethod.substring(0,1);
}
set_Value ("CAEMethod", CAEMethod);
}
/** Get CAEMethod */
public String getCAEMethod() 
{
return (String)get_Value("CAEMethod");
}
/** Set C_LYEIElectronicInvoiceConfig_ID */
public void setC_LYEIElectronicInvoiceConfig_ID (int C_LYEIElectronicInvoiceConfig_ID)
{
set_Value ("C_LYEIElectronicInvoiceConfig_ID", new Integer(C_LYEIElectronicInvoiceConfig_ID));
}
/** Get C_LYEIElectronicInvoiceConfig_ID */
public int getC_LYEIElectronicInvoiceConfig_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicInvoiceConfig_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEIElectronicPOSConfig_ID */
public void setC_LYEIElectronicPOSConfig_ID (int C_LYEIElectronicPOSConfig_ID)
{
set_ValueNoCheck ("C_LYEIElectronicPOSConfig_ID", new Integer(C_LYEIElectronicPOSConfig_ID));
}
/** Get C_LYEIElectronicPOSConfig_ID */
public int getC_LYEIElectronicPOSConfig_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicPOSConfig_ID");
if (ii == null) return 0;
return ii.intValue();
}
public static final int CURRENTENVIRONMENT_AD_Reference_ID = MReference.getReferenceID("CurrentEnvironmentOptions");
/** Homo = H */
public static final String CURRENTENVIRONMENT_Homo = "H";
/** Prod = P */
public static final String CURRENTENVIRONMENT_Prod = "P";
/** Set CurrentEnvironment */
public void setCurrentEnvironment (String CurrentEnvironment)
{
if (CurrentEnvironment.equals("H") || CurrentEnvironment.equals("P") || ( refContainsValue("LYEI-AD_Reference-1010328", CurrentEnvironment) ) );
 else throw new IllegalArgumentException ("CurrentEnvironment Invalid value: " + CurrentEnvironment + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010328") );
if (CurrentEnvironment == null) throw new IllegalArgumentException ("CurrentEnvironment is mandatory");
if (CurrentEnvironment.length() > 1)
{
log.warning("Length > 1 - truncated");
CurrentEnvironment = CurrentEnvironment.substring(0,1);
}
set_Value ("CurrentEnvironment", CurrentEnvironment);
}
/** Get CurrentEnvironment */
public String getCurrentEnvironment() 
{
return (String)get_Value("CurrentEnvironment");
}
/** Set HomoTA.
TA de Homologacion */
public void setHomoTA (byte[] HomoTA)
{
set_Value ("HomoTA", HomoTA);
}
/** Get HomoTA.
TA de Homologacion */
public byte[] getHomoTA() 
{
return (byte[])get_Value("HomoTA");
}
/** Set POS */
public void setPOS (int POS)
{
set_Value ("POS", new Integer(POS));
}
/** Get POS */
public int getPOS() 
{
Integer ii = (Integer)get_Value("POS");
if (ii == null) return 0;
return ii.intValue();
}
public KeyNamePair getKeyNamePair() 
{
return new KeyNamePair(getID(), String.valueOf(getPOS()));
}
public static final int POSSERVICE_AD_Reference_ID = MReference.getReferenceID("LYEIPOSService");
/** Facturacion Nacional = N */
public static final String POSSERVICE_FacturacionNacional = "N";
/** Facturacion Exportacion = X */
public static final String POSSERVICE_FacturacionExportacion = "X";
/** Set POSService */
public void setPOSService (String POSService)
{
if (POSService.equals("N") || POSService.equals("X") || ( refContainsValue("LYEI-AD_Reference-1010330", POSService) ) );
 else throw new IllegalArgumentException ("POSService Invalid value: " + POSService + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010330") );
if (POSService == null) throw new IllegalArgumentException ("POSService is mandatory");
if (POSService.length() > 1)
{
log.warning("Length > 1 - truncated");
POSService = POSService.substring(0,1);
}
set_Value ("POSService", POSService);
}
/** Get POSService */
public String getPOSService() 
{
return (String)get_Value("POSService");
}
/** Set ProdTA.
TA de produccion */
public void setProdTA (byte[] ProdTA)
{
set_Value ("ProdTA", ProdTA);
}
/** Get ProdTA.
TA de produccion */
public byte[] getProdTA() 
{
return (byte[])get_Value("ProdTA");
}
/** Set ProductionCRT */
public void setProductionCRT (byte[] ProductionCRT)
{
set_Value ("ProductionCRT", ProductionCRT);
}
/** Get ProductionCRT */
public byte[] getProductionCRT() 
{
return (byte[])get_Value("ProductionCRT");
}
public static final int PRODUCTIONCRTSTATUS_AD_Reference_ID = MReference.getReferenceID("CRT Status");
/** No CRT = X */
public static final String PRODUCTIONCRTSTATUS_NoCRT = "X";
/** Validation Pending = P */
public static final String PRODUCTIONCRTSTATUS_ValidationPending = "P";
/** Invalid CRT  = I */
public static final String PRODUCTIONCRTSTATUS_InvalidCRT = "I";
/** Valid CRT = V */
public static final String PRODUCTIONCRTSTATUS_ValidCRT = "V";
/** Set ProductionCRTStatus */
public void setProductionCRTStatus (String ProductionCRTStatus)
{
if (ProductionCRTStatus == null || ProductionCRTStatus.equals("X") || ProductionCRTStatus.equals("P") || ProductionCRTStatus.equals("I") || ProductionCRTStatus.equals("V") || ( refContainsValue("LYEI-AD_Reference-1010277", ProductionCRTStatus) ) );
 else throw new IllegalArgumentException ("ProductionCRTStatus Invalid value: " + ProductionCRTStatus + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010277") );
if (ProductionCRTStatus != null && ProductionCRTStatus.length() > 1)
{
log.warning("Length > 1 - truncated");
ProductionCRTStatus = ProductionCRTStatus.substring(0,1);
}
set_Value ("ProductionCRTStatus", ProductionCRTStatus);
}
/** Get ProductionCRTStatus */
public String getProductionCRTStatus() 
{
return (String)get_Value("ProductionCRTStatus");
}
/** Set TestCRT */
public void setTestCRT (byte[] TestCRT)
{
set_Value ("TestCRT", TestCRT);
}
/** Get TestCRT */
public byte[] getTestCRT() 
{
return (byte[])get_Value("TestCRT");
}
public static final int TESTCRTSTATUS_AD_Reference_ID = MReference.getReferenceID("CRT Status");
/** No CRT = X */
public static final String TESTCRTSTATUS_NoCRT = "X";
/** Validation Pending = P */
public static final String TESTCRTSTATUS_ValidationPending = "P";
/** Invalid CRT  = I */
public static final String TESTCRTSTATUS_InvalidCRT = "I";
/** Valid CRT = V */
public static final String TESTCRTSTATUS_ValidCRT = "V";
/** Set TestCRTStatus */
public void setTestCRTStatus (String TestCRTStatus)
{
if (TestCRTStatus == null || TestCRTStatus.equals("X") || TestCRTStatus.equals("P") || TestCRTStatus.equals("I") || TestCRTStatus.equals("V") || ( refContainsValue("LYEI-AD_Reference-1010277", TestCRTStatus) ) );
 else throw new IllegalArgumentException ("TestCRTStatus Invalid value: " + TestCRTStatus + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010277") );
if (TestCRTStatus != null && TestCRTStatus.length() > 1)
{
log.warning("Length > 1 - truncated");
TestCRTStatus = TestCRTStatus.substring(0,1);
}
set_Value ("TestCRTStatus", TestCRTStatus);
}
/** Get TestCRTStatus */
public String getTestCRTStatus() 
{
return (String)get_Value("TestCRTStatus");
}
/** Set ValidateCRT */
public void setValidateCRT (String ValidateCRT)
{
if (ValidateCRT != null && ValidateCRT.length() > 1)
{
log.warning("Length > 1 - truncated");
ValidateCRT = ValidateCRT.substring(0,1);
}
set_Value ("ValidateCRT", ValidateCRT);
}
/** Get ValidateCRT */
public String getValidateCRT() 
{
return (String)get_Value("ValidateCRT");
}
}
