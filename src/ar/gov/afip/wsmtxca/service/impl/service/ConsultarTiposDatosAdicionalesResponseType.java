/**
 * ConsultarTiposDatosAdicionalesResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultarTiposDatosAdicionalesResponseType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayTiposDatosAdicionales;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento;

    public ConsultarTiposDatosAdicionalesResponseType() {
    }

    public ConsultarTiposDatosAdicionalesResponseType(
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayTiposDatosAdicionales,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
           this.arrayTiposDatosAdicionales = arrayTiposDatosAdicionales;
           this.evento = evento;
    }


    /**
     * Gets the arrayTiposDatosAdicionales value for this ConsultarTiposDatosAdicionalesResponseType.
     * 
     * @return arrayTiposDatosAdicionales
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] getArrayTiposDatosAdicionales() {
        return arrayTiposDatosAdicionales;
    }


    /**
     * Sets the arrayTiposDatosAdicionales value for this ConsultarTiposDatosAdicionalesResponseType.
     * 
     * @param arrayTiposDatosAdicionales
     */
    public void setArrayTiposDatosAdicionales(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayTiposDatosAdicionales) {
        this.arrayTiposDatosAdicionales = arrayTiposDatosAdicionales;
    }


    /**
     * Gets the evento value for this ConsultarTiposDatosAdicionalesResponseType.
     * 
     * @return evento
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this ConsultarTiposDatosAdicionalesResponseType.
     * 
     * @param evento
     */
    public void setEvento(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarTiposDatosAdicionalesResponseType)) return false;
        ConsultarTiposDatosAdicionalesResponseType other = (ConsultarTiposDatosAdicionalesResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayTiposDatosAdicionales==null && other.getArrayTiposDatosAdicionales()==null) || 
             (this.arrayTiposDatosAdicionales!=null &&
              java.util.Arrays.equals(this.arrayTiposDatosAdicionales, other.getArrayTiposDatosAdicionales()))) &&
            ((this.evento==null && other.getEvento()==null) || 
             (this.evento!=null &&
              this.evento.equals(other.getEvento())));
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
        if (getArrayTiposDatosAdicionales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayTiposDatosAdicionales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayTiposDatosAdicionales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEvento() != null) {
            _hashCode += getEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarTiposDatosAdicionalesResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDatosAdicionalesResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayTiposDatosAdicionales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayTiposDatosAdicionales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
