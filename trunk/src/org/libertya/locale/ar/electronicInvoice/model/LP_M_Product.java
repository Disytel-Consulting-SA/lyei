/** Modelo Generado - NO CAMBIAR MANUALMENTE - Disytel */
package org.libertya.locale.ar.electronicInvoice.model;
import org.openXpertya.model.*;
import java.util.logging.Level;
 import java.util.*;
import java.sql.*;
import java.math.*;
import org.openXpertya.util.*;
/** Modelo Generado por M_Product
 *  @author Comunidad de Desarrollo Libertya*         *Basado en Codigo Original Modificado, Revisado y Optimizado de:*         * Jorg Janke 
 *  @version  - 2021-05-17 09:03:13.324 */
public class LP_M_Product extends org.openXpertya.model.MProduct
{
/** Constructor estándar */
public LP_M_Product (Properties ctx, int M_Product_ID, String trxName)
{
super (ctx, M_Product_ID, trxName);
/** if (M_Product_ID == 0)
{
}
 */
}
/** Load Constructor */
public LP_M_Product (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
public String toString()
{
StringBuffer sb = new StringBuffer ("LP_M_Product[").append(getID()).append("]");
return sb.toString();
}
/** Set LYEIUnidadesMtx */
public void setLYEIUnidadesMtx (int LYEIUnidadesMtx)
{
set_Value ("LYEIUnidadesMtx", new Integer(LYEIUnidadesMtx));
}
/** Get LYEIUnidadesMtx */
public int getLYEIUnidadesMtx() 
{
Integer ii = (Integer)get_Value("LYEIUnidadesMtx");
if (ii == null) return 0;
return ii.intValue();
}
}
