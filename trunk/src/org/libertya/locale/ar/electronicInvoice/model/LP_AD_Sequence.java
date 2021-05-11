/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por AD_Sequence
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-05-10 10:43:42.73 */
public class LP_AD_Sequence extends org.openXpertya.model.MSequence
{
/** Constructor estándar */
public LP_AD_Sequence (Properties ctx, int AD_Sequence_ID, String trxName)
{
super (ctx, AD_Sequence_ID, trxName);
/** if (AD_Sequence_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_AD_Sequence (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_AD_Sequence[").append(getID()).append("]");
return sb.toString();
}
/** Set LYEICurrentNextCAEAHomo */
public void setLYEICurrentNextCAEAHomo (BigDecimal LYEICurrentNextCAEAHomo)
{
set_Value ("LYEICurrentNextCAEAHomo", LYEICurrentNextCAEAHomo);
}
/** Get LYEICurrentNextCAEAHomo */
public BigDecimal getLYEICurrentNextCAEAHomo() 
{
BigDecimal bd = (BigDecimal)get_Value("LYEICurrentNextCAEAHomo");
if (bd == null) return Env.ZERO;
return bd;
}
/** Set LYEICurrentNextCAEAProd */
public void setLYEICurrentNextCAEAProd (BigDecimal LYEICurrentNextCAEAProd)
{
set_Value ("LYEICurrentNextCAEAProd", LYEICurrentNextCAEAProd);
}
/** Get LYEICurrentNextCAEAProd */
public BigDecimal getLYEICurrentNextCAEAProd() 
{
BigDecimal bd = (BigDecimal)get_Value("LYEICurrentNextCAEAProd");
if (bd == null) return Env.ZERO;
return bd;
}
}
