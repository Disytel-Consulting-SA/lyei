/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEIDDJJPresentada
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2022-11-23 13:29:49.592 */
public class LP_C_LYEIDDJJPresentada extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEIDDJJPresentada (Properties ctx, int C_LYEIDDJJPresentada_ID, String trxName)
{
super (ctx, C_LYEIDDJJPresentada_ID, trxName);
/** if (C_LYEIDDJJPresentada_ID == 0)
{
setC_LYEIDDJJPresentada_ID (0);
}
 */
}
/** Load Constructor */
public LP_C_LYEIDDJJPresentada (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEIDDJJPresentada");

/** TableName=C_LYEIDDJJPresentada */
public static final String Table_Name="C_LYEIDDJJPresentada";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEIDDJJPresentada");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEIDDJJPresentada[").append(getID()).append("]");
return sb.toString();
}
/** Set User/Contact.
User within the system - Internal or Business Partner Contact */
public void setAD_User_ID (int AD_User_ID)
{
if (AD_User_ID <= 0) set_Value ("AD_User_ID", null);
 else 
set_Value ("AD_User_ID", new Integer(AD_User_ID));
}
/** Get User/Contact.
User within the system - Internal or Business Partner Contact */
public int getAD_User_ID() 
{
Integer ii = (Integer)get_Value("AD_User_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_Controlador_Fiscal_ID */
public void setC_Controlador_Fiscal_ID (int C_Controlador_Fiscal_ID)
{
if (C_Controlador_Fiscal_ID <= 0) set_Value ("C_Controlador_Fiscal_ID", null);
 else 
set_Value ("C_Controlador_Fiscal_ID", new Integer(C_Controlador_Fiscal_ID));
}
/** Get C_Controlador_Fiscal_ID */
public int getC_Controlador_Fiscal_ID() 
{
Integer ii = (Integer)get_Value("C_Controlador_Fiscal_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set C_LYEIDDJJPresentada_ID */
public void setC_LYEIDDJJPresentada_ID (int C_LYEIDDJJPresentada_ID)
{
set_ValueNoCheck ("C_LYEIDDJJPresentada_ID", new Integer(C_LYEIDDJJPresentada_ID));
}
/** Get C_LYEIDDJJPresentada_ID */
public int getC_LYEIDDJJPresentada_ID() 
{
Integer ii = (Integer)get_Value("C_LYEIDDJJPresentada_ID");
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
/** Set Date From.
Starting date for a range */
public void setDateFrom (Timestamp DateFrom)
{
set_Value ("DateFrom", DateFrom);
}
/** Get Date From.
Starting date for a range */
public Timestamp getDateFrom() 
{
return (Timestamp)get_Value("DateFrom");
}
/** Set Date To.
End date of a date range */
public void setDateTo (Timestamp DateTo)
{
set_Value ("DateTo", DateTo);
}
/** Get Date To.
End date of a date range */
public Timestamp getDateTo() 
{
return (Timestamp)get_Value("DateTo");
}
/** Set error_msg */
public void seterror_msg (String error_msg)
{
if (error_msg != null && error_msg.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
error_msg = error_msg.substring(0,2147483647);
}
set_Value ("error_msg", error_msg);
}
/** Get error_msg */
public String geterror_msg() 
{
return (String)get_Value("error_msg");
}
/** Set File Name.
Name of the local file or URL */
public void setFileName (String FileName)
{
if (FileName != null && FileName.length() > 256)
{
log.warning("Length > 256 - truncated");
FileName = FileName.substring(0,256);
}
set_Value ("FileName", FileName);
}
/** Get File Name.
Name of the local file or URL */
public String getFileName() 
{
return (String)get_Value("FileName");
}
/** Set fyh_presentacion */
public void setfyh_presentacion (Timestamp fyh_presentacion)
{
set_Value ("fyh_presentacion", fyh_presentacion);
}
/** Get fyh_presentacion */
public Timestamp getfyh_presentacion() 
{
return (Timestamp)get_Value("fyh_presentacion");
}
/** Set trx_number */
public void settrx_number (String trx_number)
{
if (trx_number != null && trx_number.length() > 20)
{
log.warning("Length > 20 - truncated");
trx_number = trx_number.substring(0,20);
}
set_Value ("trx_number", trx_number);
}
/** Get trx_number */
public String gettrx_number() 
{
return (String)get_Value("trx_number");
}
}
