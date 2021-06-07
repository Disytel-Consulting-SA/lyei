/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por T_CAEA_Pending_Documents
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-06-03 10:50:29.705 */
public class LP_T_CAEA_Pending_Documents extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_T_CAEA_Pending_Documents (Properties ctx, int T_CAEA_Pending_Documents_ID, String trxName)
{
super (ctx, T_CAEA_Pending_Documents_ID, trxName);
/** if (T_CAEA_Pending_Documents_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_T_CAEA_Pending_Documents (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("T_CAEA_Pending_Documents");

/** TableName=T_CAEA_Pending_Documents */
public static final String Table_Name="T_CAEA_Pending_Documents";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"T_CAEA_Pending_Documents");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_T_CAEA_Pending_Documents[").append(getID()).append("]");
return sb.toString();
}
/** Set Process Instance.
Instance of the process */
public void setAD_PInstance_ID (int AD_PInstance_ID)
{
if (AD_PInstance_ID <= 0) set_Value ("AD_PInstance_ID", null);
 else 
set_Value ("AD_PInstance_ID", new Integer(AD_PInstance_ID));
}
/** Get Process Instance.
Instance of the process */
public int getAD_PInstance_ID() 
{
Integer ii = (Integer)get_Value("AD_PInstance_ID");
if (ii == null) return 0;
return ii.intValue();
}
public static final int AMBIENTE_AD_Reference_ID = MReference.getReferenceID("CurrentEnvironmentOptions");
/** Homo = H */
public static final String AMBIENTE_Homo = "H";
/** Prod = P */
public static final String AMBIENTE_Prod = "P";
/** Set Ambiente */
public void setAmbiente (String Ambiente)
{
if (Ambiente == null || Ambiente.equals("H") || Ambiente.equals("P") || ( refContainsValue("LYEI-AD_Reference-1010328", Ambiente) ) );
 else throw new IllegalArgumentException ("Ambiente Invalid value: " + Ambiente + ".  Valid: " +  refValidOptions("LYEI-AD_Reference-1010328") );
if (Ambiente != null && Ambiente.length() > 1)
{
log.warning("Length > 1 - truncated");
Ambiente = Ambiente.substring(0,1);
}
set_Value ("Ambiente", Ambiente);
}
/** Get Ambiente */
public String getAmbiente() 
{
return (String)get_Value("Ambiente");
}
/** Set Business Partner .
Identifies a Business Partner */
public void setC_BPartner_ID (int C_BPartner_ID)
{
if (C_BPartner_ID <= 0) set_Value ("C_BPartner_ID", null);
 else 
set_Value ("C_BPartner_ID", new Integer(C_BPartner_ID));
}
/** Get Business Partner .
Identifies a Business Partner */
public int getC_BPartner_ID() 
{
Integer ii = (Integer)get_Value("C_BPartner_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set Document Type.
Document type or rules */
public void setC_DocType_ID (int C_DocType_ID)
{
if (C_DocType_ID <= 0) set_Value ("C_DocType_ID", null);
 else 
set_Value ("C_DocType_ID", new Integer(C_DocType_ID));
}
/** Get Document Type.
Document type or rules */
public int getC_DocType_ID() 
{
Integer ii = (Integer)get_Value("C_DocType_ID");
if (ii == null) return 0;
return ii.intValue();
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
/** Set Date Invoiced.
Date printed on Invoice */
public void setDateInvoiced (Timestamp DateInvoiced)
{
set_Value ("DateInvoiced", DateInvoiced);
}
/** Get Date Invoiced.
Date printed on Invoice */
public Timestamp getDateInvoiced() 
{
return (Timestamp)get_Value("DateInvoiced");
}
/** Set Document No.
Document sequence NUMERIC of the document */
public void setDocumentNo (String DocumentNo)
{
if (DocumentNo != null && DocumentNo.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
DocumentNo = DocumentNo.substring(0,2147483647);
}
set_Value ("DocumentNo", DocumentNo);
}
/** Get Document No.
Document sequence NUMERIC of the document */
public String getDocumentNo() 
{
return (String)get_Value("DocumentNo");
}
/** Set Grand Total.
Total amount of document */
public void setGrandTotal (BigDecimal GrandTotal)
{
set_Value ("GrandTotal", GrandTotal);
}
/** Get Grand Total.
Total amount of document */
public BigDecimal getGrandTotal() 
{
BigDecimal bd = (BigDecimal)get_Value("GrandTotal");
if (bd == null) return Env.ZERO;
return bd;
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
/** Set Orden */
public void setOrden (int Orden)
{
set_Value ("Orden", new Integer(Orden));
}
/** Get Orden */
public int getOrden() 
{
Integer ii = (Integer)get_Value("Orden");
if (ii == null) return 0;
return ii.intValue();
}
/** Set Periodo */
public void setPeriodo (int Periodo)
{
set_Value ("Periodo", new Integer(Periodo));
}
/** Get Periodo */
public int getPeriodo() 
{
Integer ii = (Integer)get_Value("Periodo");
if (ii == null) return 0;
return ii.intValue();
}
/** Set PtoVta */
public void setPtoVta (int PtoVta)
{
set_Value ("PtoVta", new Integer(PtoVta));
}
/** Get PtoVta */
public int getPtoVta() 
{
Integer ii = (Integer)get_Value("PtoVta");
if (ii == null) return 0;
return ii.intValue();
}
}
