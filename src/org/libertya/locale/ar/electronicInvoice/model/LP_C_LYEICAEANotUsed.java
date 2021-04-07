/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEICAEANotUsed
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-04-07 12:33:42.554 */
public class LP_C_LYEICAEANotUsed extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEICAEANotUsed (Properties ctx, int C_LYEICAEANotUsed_ID, String trxName)
{
super (ctx, C_LYEICAEANotUsed_ID, trxName);
/** if (C_LYEICAEANotUsed_ID == 0)
{
setC_LYEICAEANotUsed_ID (0);
setC_LYEICAEARequest_ID (0);
}
 */
}
/** Load Constructor */
public LP_C_LYEICAEANotUsed (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEICAEANotUsed");

/** TableName=C_LYEICAEANotUsed */
public static final String Table_Name="C_LYEICAEANotUsed";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEICAEANotUsed");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEICAEANotUsed[").append(getID()).append("]");
return sb.toString();
}
/** Set C_LYEICAEANotUsed_ID */
public void setC_LYEICAEANotUsed_ID (int C_LYEICAEANotUsed_ID)
{
set_ValueNoCheck ("C_LYEICAEANotUsed_ID", new Integer(C_LYEICAEANotUsed_ID));
}
/** Get C_LYEICAEANotUsed_ID */
public int getC_LYEICAEANotUsed_ID() 
{
Integer ii = (Integer)get_Value("C_LYEICAEANotUsed_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEICAEARequest_ID */
public void setC_LYEICAEARequest_ID (int C_LYEICAEARequest_ID)
{
set_Value ("C_LYEICAEARequest_ID", new Integer(C_LYEICAEARequest_ID));
}
/** Get C_LYEICAEARequest_ID */
public int getC_LYEICAEARequest_ID() 
{
Integer ii = (Integer)get_Value("C_LYEICAEARequest_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEIElectronicPOSConfig_ID */
public void setC_LYEIElectronicPOSConfig_ID (int C_LYEIElectronicPOSConfig_ID)
{
if (C_LYEIElectronicPOSConfig_ID <= 0) set_Value ("C_LYEIElectronicPOSConfig_ID", null);
 else 
set_Value ("C_LYEIElectronicPOSConfig_ID", new Integer(C_LYEIElectronicPOSConfig_ID));
}
/** Get C_LYEIElectronicPOSConfig_ID */
public int getC_LYEIElectronicPOSConfig_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicPOSConfig_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set Detail */
public void setDetail (String Detail)
{
if (Detail != null && Detail.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
Detail = Detail.substring(0,2147483647);
}
set_Value ("Detail", Detail);
}
/** Get Detail */
public String getDetail() 
{
return (String)get_Value("Detail");
}
public static final int ENVIRONMENT_AD_Reference_ID = MReference.getReferenceID("CurrentEnvironmentOptions");
/** Homo = H */
public static final String ENVIRONMENT_Homo = "H";
/** Prod = P */
public static final String ENVIRONMENT_Prod = "P";
/** Set Environment */
public void setEnvironment (String Environment)
{
if (Environment == null || Environment.equals("H") || Environment.equals("P") || ( refContainsValue("LYEI-AD_Reference-1010328", Environment) ) );
 else throw new IllegalArgumentException ("Environment Invalid value: " + Environment + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010328") );
if (Environment != null && Environment.length() > 1)
{
log.warning("Length > 1 - truncated");
Environment = Environment.substring(0,1);
}
set_Value ("Environment", Environment);
}
/** Get Environment */
public String getEnvironment() 
{
return (String)get_Value("Environment");
}
public static final int STATUS_AD_Reference_ID = MReference.getReferenceID("LYEICAEANotUsedStatus");
/** Rechazado = R */
public static final String STATUS_Rechazado = "R";
/** Aprobado = A */
public static final String STATUS_Aprobado = "A";
/** Set Status */
public void setStatus (String Status)
{
if (Status == null || Status.equals("R") || Status.equals("A") || ( refContainsValue("LYEI-AD_Reference-20210405124008448-931862", Status) ) );
 else throw new IllegalArgumentException ("Status Invalid value: " + Status + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-20210405124008448-931862") );
if (Status != null && Status.length() > 1)
{
log.warning("Length > 1 - truncated");
Status = Status.substring(0,1);
}
set_Value ("Status", Status);
}
/** Get Status */
public String getStatus() 
{
return (String)get_Value("Status");
}
}
