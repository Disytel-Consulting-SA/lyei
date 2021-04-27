/**
 * ConsultarPuntosVentaResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultarPuntosVentaResponseType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType[] arrayPuntosVenta;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento;

    public ConsultarPuntosVentaResponseType() {
    }

    public ConsultarPuntosVentaResponseType(
           ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType[] arrayPuntosVenta,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
           this.arrayPuntosVenta = arrayPuntosVenta;
           this.evento = evento;
    }


    /**
     * Gets the arrayPuntosVenta value for this ConsultarPuntosVentaResponseType.
     * 
     * @return arrayPuntosVenta
     */
    public ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType[] getArrayPuntosVenta() {
        return arrayPuntosVenta;
    }


    /**
     * Sets the arrayPuntosVenta value for this ConsultarPuntosVentaResponseType.
     * 
     * @param arrayPuntosVenta
     */
    public void setArrayPuntosVenta(ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType[] arrayPuntosVenta) {
        this.arrayPuntosVenta = arrayPuntosVenta;
    }


    /**
     * Gets the evento value for this ConsultarPuntosVentaResponseType.
     * 
     * @return evento
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this ConsultarPuntosVentaResponseType.
     * 
     * @param evento
     */
    public void setEvento(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarPuntosVentaResponseType)) return false;
        ConsultarPuntosVentaResponseType other = (ConsultarPuntosVentaResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayPuntosVenta==null && other.getArrayPuntosVenta()==null) || 
             (this.arrayPuntosVenta!=null &&
              java.util.Arrays.equals(this.arrayPuntosVenta, other.getArrayPuntosVenta()))) &&
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
        if (getArrayPuntosVenta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayPuntosVenta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayPuntosVenta(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarPuntosVentaResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayPuntosVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayPuntosVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "puntoVenta"));
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
