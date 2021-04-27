/**
 * ConsultaComprobanteRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultaComprobanteRequestType  implements java.io.Serializable {
    private short codigoTipoComprobante;

    private int numeroPuntoVenta;

    private long numeroComprobante;

    public ConsultaComprobanteRequestType() {
    }

    public ConsultaComprobanteRequestType(
           short codigoTipoComprobante,
           int numeroPuntoVenta,
           long numeroComprobante) {
           this.codigoTipoComprobante = codigoTipoComprobante;
           this.numeroPuntoVenta = numeroPuntoVenta;
           this.numeroComprobante = numeroComprobante;
    }


    /**
     * Gets the codigoTipoComprobante value for this ConsultaComprobanteRequestType.
     * 
     * @return codigoTipoComprobante
     */
    public short getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }


    /**
     * Sets the codigoTipoComprobante value for this ConsultaComprobanteRequestType.
     * 
     * @param codigoTipoComprobante
     */
    public void setCodigoTipoComprobante(short codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }


    /**
     * Gets the numeroPuntoVenta value for this ConsultaComprobanteRequestType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this ConsultaComprobanteRequestType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the numeroComprobante value for this ConsultaComprobanteRequestType.
     * 
     * @return numeroComprobante
     */
    public long getNumeroComprobante() {
        return numeroComprobante;
    }


    /**
     * Sets the numeroComprobante value for this ConsultaComprobanteRequestType.
     * 
     * @param numeroComprobante
     */
    public void setNumeroComprobante(long numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaComprobanteRequestType)) return false;
        ConsultaComprobanteRequestType other = (ConsultaComprobanteRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigoTipoComprobante == other.getCodigoTipoComprobante() &&
            this.numeroPuntoVenta == other.getNumeroPuntoVenta() &&
            this.numeroComprobante == other.getNumeroComprobante();
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
        _hashCode += getCodigoTipoComprobante();
        _hashCode += getNumeroPuntoVenta();
        _hashCode += new Long(getNumeroComprobante()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaComprobanteRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaComprobanteRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoTipoComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
