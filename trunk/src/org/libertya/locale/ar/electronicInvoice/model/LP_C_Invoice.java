/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_Invoice
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2022-07-19 10:56:55.99 */
public class LP_C_Invoice extends org.openXpertya.model.MInvoice
{
/** Constructor estándar */
public LP_C_Invoice (Properties ctx, int C_Invoice_ID, String trxName)
{
super (ctx, C_Invoice_ID, trxName);
/** if (C_Invoice_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_C_Invoice (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_Invoice[").append(getID()).append("]");
return sb.toString();
}
public static final int LYEICAEAINFORMED_AD_Reference_ID = MReference.getReferenceID("LYEICAEAInformed");
/** Pendiente = P */
public static final String LYEICAEAINFORMED_Pendiente = "P";
/** Aprobado = A */
public static final String LYEICAEAINFORMED_Aprobado = "A";
/** Observado = O */
public static final String LYEICAEAINFORMED_Observado = "O";
/** Rechazado = R */
public static final String LYEICAEAINFORMED_Rechazado = "R";
/** Error = E */
public static final String LYEICAEAINFORMED_Error = "E";
/** Set LYEICAEAInformed */
public void setLYEICAEAInformed (String LYEICAEAInformed)
{
if (LYEICAEAInformed == null || LYEICAEAInformed.equals("P") || LYEICAEAInformed.equals("A") || LYEICAEAInformed.equals("O") || LYEICAEAInformed.equals("R") || LYEICAEAInformed.equals("E") || ( refContainsValue("LYEI-AD_Reference-20210405114701197-533455", LYEICAEAInformed) ) );
 else throw new IllegalArgumentException ("LYEICAEAInformed Invalid value: " + LYEICAEAInformed + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-20210405114701197-533455") );
if (LYEICAEAInformed != null && LYEICAEAInformed.length() > 1)
{
log.warning("Length > 1 - truncated");
LYEICAEAInformed = LYEICAEAInformed.substring(0,1);
}
set_Value ("LYEICAEAInformed", LYEICAEAInformed);
}
/** Get LYEICAEAInformed */
public String getLYEICAEAInformed() 
{
return (String)get_Value("LYEICAEAInformed");
}
/** Set LYEICAEAInformedDetail */
public void setLYEICAEAInformedDetail (String LYEICAEAInformedDetail)
{
if (LYEICAEAInformedDetail != null && LYEICAEAInformedDetail.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
LYEICAEAInformedDetail = LYEICAEAInformedDetail.substring(0,2147483647);
}
set_Value ("LYEICAEAInformedDetail", LYEICAEAInformedDetail);
}
/** Get LYEICAEAInformedDetail */
public String getLYEICAEAInformedDetail() 
{
return (String)get_Value("LYEICAEAInformedDetail");
}
/** Set LYEIManageElectronicInvoiceProcess */
public void setLYEIManageElectronicInvoiceProcess (String LYEIManageElectronicInvoiceProcess)
{
if (LYEIManageElectronicInvoiceProcess != null && LYEIManageElectronicInvoiceProcess.length() > 1)
{
log.warning("Length > 1 - truncated");
LYEIManageElectronicInvoiceProcess = LYEIManageElectronicInvoiceProcess.substring(0,1);
}
set_Value ("LYEIManageElectronicInvoiceProcess", LYEIManageElectronicInvoiceProcess);
}
/** Get LYEIManageElectronicInvoiceProcess */
public String getLYEIManageElectronicInvoiceProcess() 
{
return (String)get_Value("LYEIManageElectronicInvoiceProcess");
}
/** Set LYEIPeriodFrom */
public void setLYEIPeriodFrom (Timestamp LYEIPeriodFrom)
{
set_Value ("LYEIPeriodFrom", LYEIPeriodFrom);
}
/** Get LYEIPeriodFrom */
public Timestamp getLYEIPeriodFrom() 
{
return (Timestamp)get_Value("LYEIPeriodFrom");
}
/** Set LYEIPeriodTo */
public void setLYEIPeriodTo (Timestamp LYEIPeriodTo)
{
set_Value ("LYEIPeriodTo", LYEIPeriodTo);
}
/** Get LYEIPeriodTo */
public Timestamp getLYEIPeriodTo() 
{
return (Timestamp)get_Value("LYEIPeriodTo");
}
protected String getAdditionalParamNames() 
{
 return ",LYEIManageElectronicInvoiceProcess,LYEICAEAInformed,LYEICAEAInformedDetail,LYEIPeriodFrom,LYEIPeriodTo,";
 }
 
protected String getAdditionalParamMarks() 
{
 return ",?,?,?,?,?,";
 }
 
protected void skipAdditionalNullValues(String sql) 
{
 		 if (getLYEIManageElectronicInvoiceProcess() == null) sql = sql.replaceFirst("LYEIManageElectronicInvoiceProcess,","").replaceFirst("\\?,", "");
 		 if (getLYEICAEAInformed() == null) sql = sql.replaceFirst("LYEICAEAInformed,","").replaceFirst("\\?,", "");
 		 if (getLYEICAEAInformedDetail() == null) sql = sql.replaceFirst("LYEICAEAInformedDetail,","").replaceFirst("\\?,", "");
 		 if (getLYEIPeriodFrom() == null) sql = sql.replaceFirst("LYEIPeriodFrom,","").replaceFirst("\\?,", "");
 		 if (getLYEIPeriodTo() == null) sql = sql.replaceFirst("LYEIPeriodTo,","").replaceFirst("\\?,", "");
  }
 
protected int setAdditionalInsertValues(int col, PreparedStatement pstmt) throws Exception 
{
 		 if (getLYEIManageElectronicInvoiceProcess() != null) pstmt.setString(col++, getLYEIManageElectronicInvoiceProcess());
		 if (getLYEICAEAInformed() != null) pstmt.setString(col++, getLYEICAEAInformed());
		 if (getLYEICAEAInformedDetail() != null) pstmt.setString(col++, getLYEICAEAInformedDetail());
		 if (getLYEIPeriodFrom() != null) pstmt.setTimestamp(col++, getLYEIPeriodFrom());
		 if (getLYEIPeriodTo() != null) pstmt.setTimestamp(col++, getLYEIPeriodTo());
 
 return col;
 }
 
}
