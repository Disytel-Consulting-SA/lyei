/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEIElectronicInvoiceLog
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2017-10-31 11:18:49.549 */
public class LP_C_LYEIElectronicInvoiceLog extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEIElectronicInvoiceLog (Properties ctx, int C_LYEIElectronicInvoiceLog_ID, String trxName)
{
super (ctx, C_LYEIElectronicInvoiceLog_ID, trxName);
/** if (C_LYEIElectronicInvoiceLog_ID == 0)
{
setC_LYEIElectronicInvoiceLog_ID (0);
}
 */
}
/** Load Constructor */
public LP_C_LYEIElectronicInvoiceLog (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEIElectronicInvoiceLog");

/** TableName=C_LYEIElectronicInvoiceLog */
public static final String Table_Name="C_LYEIElectronicInvoiceLog";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEIElectronicInvoiceLog");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEIElectronicInvoiceLog[").append(getID()).append("]");
return sb.toString();
}
/** Set Activity */
public void setActivity (String Activity)
{
if (Activity != null && Activity.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
Activity = Activity.substring(0,2147483647);
}
set_Value ("Activity", Activity);
}
/** Get Activity */
public String getActivity() 
{
return (String)get_Value("Activity");
}
/** Set Invoice.
Invoice Identifier */
public void setC_Invoice_ID (int C_Invoice_ID)
{
if (C_Invoice_ID <= 0) set_Value ("C_Invoice_ID", null);
 else 
set_Value ("C_Invoice_ID", new Integer(C_Invoice_ID));
}
/** Get Invoice.
Invoice Identifier */
public int getC_Invoice_ID() 
{
Integer ii = (Integer)get_Value("C_Invoice_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEIElectronicInvoiceConfig_ID */
public void setC_LYEIElectronicInvoiceConfig_ID (int C_LYEIElectronicInvoiceConfig_ID)
{
if (C_LYEIElectronicInvoiceConfig_ID <= 0) set_Value ("C_LYEIElectronicInvoiceConfig_ID", null);
 else 
set_Value ("C_LYEIElectronicInvoiceConfig_ID", new Integer(C_LYEIElectronicInvoiceConfig_ID));
}
/** Get C_LYEIElectronicInvoiceConfig_ID */
public int getC_LYEIElectronicInvoiceConfig_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicInvoiceConfig_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEIElectronicInvoiceLog_ID */
public void setC_LYEIElectronicInvoiceLog_ID (int C_LYEIElectronicInvoiceLog_ID)
{
set_ValueNoCheck ("C_LYEIElectronicInvoiceLog_ID", new Integer(C_LYEIElectronicInvoiceLog_ID));
}
/** Get C_LYEIElectronicInvoiceLog_ID */
public int getC_LYEIElectronicInvoiceLog_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIElectronicInvoiceLog_ID");
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
}
