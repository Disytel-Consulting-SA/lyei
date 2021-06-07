/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por T_CAEA_Not_Used
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-06-04 09:20:32.63 */
public class LP_T_CAEA_Not_Used extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_T_CAEA_Not_Used (Properties ctx, int T_CAEA_Not_Used_ID, String trxName)
{
super (ctx, T_CAEA_Not_Used_ID, trxName);
/** if (T_CAEA_Not_Used_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_T_CAEA_Not_Used (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("T_CAEA_Not_Used");

/** TableName=T_CAEA_Not_Used */
public static final String Table_Name="T_CAEA_Not_Used";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"T_CAEA_Not_Used");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_T_CAEA_Not_Used[").append(getID()).append("]");
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
/** Set CAEA */
public void setCAEA (String CAEA)
{
if (CAEA != null && CAEA.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
CAEA = CAEA.substring(0,2147483647);
}
set_Value ("CAEA", CAEA);
}
/** Get CAEA */
public String getCAEA() 
{
return (String)get_Value("CAEA");
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
