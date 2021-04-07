/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_LYEICAEARequest
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-04-07 12:33:45.022 */
public class LP_C_LYEICAEARequest extends org.openXpertya.model.PO
{
/** Constructor estándar */
public LP_C_LYEICAEARequest (Properties ctx, int C_LYEICAEARequest_ID, String trxName)
{
super (ctx, C_LYEICAEARequest_ID, trxName);
/** if (C_LYEICAEARequest_ID == 0)
{
setC_LYEICAEARequest_ID (0);
}
 */
}
/** Load Constructor */
public LP_C_LYEICAEARequest (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID */
public static final int Table_ID = M_Table.getTableID("C_LYEICAEARequest");

/** TableName=C_LYEICAEARequest */
public static final String Table_Name="C_LYEICAEARequest";

protected static KeyNamePair Model = new KeyNamePair(Table_ID,"C_LYEICAEARequest");
protected static BigDecimal AccessLevel = new BigDecimal(7);

/** Load Meta Data */
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_LYEICAEARequest[").append(getID()).append("]");
return sb.toString();
}
/** Set CAEA */
public void setCAEA (String CAEA)
{
if (CAEA != null && CAEA.length() > 14)
{
log.warning("Length > 14 - truncated");
CAEA = CAEA.substring(0,14);
}
set_Value ("CAEA", CAEA);
}
/** Get CAEA */
public String getCAEA() 
{
return (String)get_Value("CAEA");
}
/** Set C_LYEICAEARequest_ID */
public void setC_LYEICAEARequest_ID (int C_LYEICAEARequest_ID)
{
set_ValueNoCheck ("C_LYEICAEARequest_ID", new Integer(C_LYEICAEARequest_ID));
}
/** Get C_LYEICAEARequest_ID */
public int getC_LYEICAEARequest_ID() 
{
Integer ii = (Integer)get_Value("C_LYEICAEARequest_ID");
if (ii == null) return 0;
return ii.intValue();
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
/** Set FechaDesde */
public void setFechaDesde (Timestamp FechaDesde)
{
set_Value ("FechaDesde", FechaDesde);
}
/** Get FechaDesde */
public Timestamp getFechaDesde() 
{
return (Timestamp)get_Value("FechaDesde");
}
/** Set FechaHasta */
public void setFechaHasta (Timestamp FechaHasta)
{
set_Value ("FechaHasta", FechaHasta);
}
/** Get FechaHasta */
public Timestamp getFechaHasta() 
{
return (Timestamp)get_Value("FechaHasta");
}
/** Set FechaTopeInforme */
public void setFechaTopeInforme (Timestamp FechaTopeInforme)
{
set_Value ("FechaTopeInforme", FechaTopeInforme);
}
/** Get FechaTopeInforme */
public Timestamp getFechaTopeInforme() 
{
return (Timestamp)get_Value("FechaTopeInforme");
}
/** Set Observaciones */
public void setObservaciones (String Observaciones)
{
if (Observaciones != null && Observaciones.length() > 2147483647)
{
log.warning("Length > 2147483647 - truncated");
Observaciones = Observaciones.substring(0,2147483647);
}
set_Value ("Observaciones", Observaciones);
}
/** Get Observaciones */
public String getObservaciones() 
{
return (String)get_Value("Observaciones");
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
}
