/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por C_Controlador_Fiscal
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2022-10-25 13:30:02.051 */
public class LP_C_Controlador_Fiscal extends org.openXpertya.model.MControladorFiscal
{
/** Constructor estándar */
public LP_C_Controlador_Fiscal (Properties ctx, int C_Controlador_Fiscal_ID, String trxName)
{
super (ctx, C_Controlador_Fiscal_ID, trxName);
/** if (C_Controlador_Fiscal_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_C_Controlador_Fiscal (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_C_Controlador_Fiscal[").append(getID()).append("]");
return sb.toString();
}
/** Set lyeicom */
public void setlyeicom (int lyeicom)
{
set_Value ("lyeicom", new Integer(lyeicom));
}
/** Get lyeicom */
public int getlyeicom() 
{
Integer ii = (Integer)get_Value("lyeicom");
if (ii == null) return 0;
return ii.intValue();
}
/** Set lyeipos */
public void setlyeipos (int lyeipos)
{
set_Value ("lyeipos", new Integer(lyeipos));
}
/** Get lyeipos */
public int getlyeipos() 
{
Integer ii = (Integer)get_Value("lyeipos");
if (ii == null) return 0;
return ii.intValue();
}
}
