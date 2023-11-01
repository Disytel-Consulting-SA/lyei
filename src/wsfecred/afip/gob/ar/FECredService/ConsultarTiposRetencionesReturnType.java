/**
 * ConsultarTiposRetencionesReturnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarTiposRetencionesReturnType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.TipoRetencionType[] arrayTiposRetenciones;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato;

    public ConsultarTiposRetencionesReturnType() {
    }

    public ConsultarTiposRetencionesReturnType(
           wsfecred.afip.gob.ar.FECredService.TipoRetencionType[] arrayTiposRetenciones,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
           this.arrayTiposRetenciones = arrayTiposRetenciones;
           this.arrayErroresFormato = arrayErroresFormato;
    }


    /**
     * Gets the arrayTiposRetenciones value for this ConsultarTiposRetencionesReturnType.
     * 
     * @return arrayTiposRetenciones
     */
    public wsfecred.afip.gob.ar.FECredService.TipoRetencionType[] getArrayTiposRetenciones() {
        return arrayTiposRetenciones;
    }


    /**
     * Sets the arrayTiposRetenciones value for this ConsultarTiposRetencionesReturnType.
     * 
     * @param arrayTiposRetenciones
     */
    public void setArrayTiposRetenciones(wsfecred.afip.gob.ar.FECredService.TipoRetencionType[] arrayTiposRetenciones) {
        this.arrayTiposRetenciones = arrayTiposRetenciones;
    }


    /**
     * Gets the arrayErroresFormato value for this ConsultarTiposRetencionesReturnType.
     * 
     * @return arrayErroresFormato
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] getArrayErroresFormato() {
        return arrayErroresFormato;
    }


    /**
     * Sets the arrayErroresFormato value for this ConsultarTiposRetencionesReturnType.
     * 
     * @param arrayErroresFormato
     */
    public void setArrayErroresFormato(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
        this.arrayErroresFormato = arrayErroresFormato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarTiposRetencionesReturnType)) return false;
        ConsultarTiposRetencionesReturnType other = (ConsultarTiposRetencionesReturnType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayTiposRetenciones==null && other.getArrayTiposRetenciones()==null) || 
             (this.arrayTiposRetenciones!=null &&
              java.util.Arrays.equals(this.arrayTiposRetenciones, other.getArrayTiposRetenciones()))) &&
            ((this.arrayErroresFormato==null && other.getArrayErroresFormato()==null) || 
             (this.arrayErroresFormato!=null &&
              java.util.Arrays.equals(this.arrayErroresFormato, other.getArrayErroresFormato())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArrayTiposRetenciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayTiposRetenciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayTiposRetenciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayErroresFormato() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayErroresFormato());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayErroresFormato(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarTiposRetencionesReturnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesReturnType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayTiposRetenciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayTiposRetenciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoRetencionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "tipoRetencion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayErroresFormato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayErroresFormato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionStringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcionString"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
