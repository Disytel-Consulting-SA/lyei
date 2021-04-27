/**
 * PuntoVentaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class PuntoVentaType  implements java.io.Serializable {
    private int numeroPuntoVenta;

    private ar.gov.afip.wsmtxca.service.impl.service.SiNoSimpleType bloqueado;

    private java.util.Date fechaBaja;

    public PuntoVentaType() {
    }

    public PuntoVentaType(
           int numeroPuntoVenta,
           ar.gov.afip.wsmtxca.service.impl.service.SiNoSimpleType bloqueado,
           java.util.Date fechaBaja) {
           this.numeroPuntoVenta = numeroPuntoVenta;
           this.bloqueado = bloqueado;
           this.fechaBaja = fechaBaja;
    }


    /**
     * Gets the numeroPuntoVenta value for this PuntoVentaType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this PuntoVentaType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the bloqueado value for this PuntoVentaType.
     * 
     * @return bloqueado
     */
    public ar.gov.afip.wsmtxca.service.impl.service.SiNoSimpleType getBloqueado() {
        return bloqueado;
    }


    /**
     * Sets the bloqueado value for this PuntoVentaType.
     * 
     * @param bloqueado
     */
    public void setBloqueado(ar.gov.afip.wsmtxca.service.impl.service.SiNoSimpleType bloqueado) {
        this.bloqueado = bloqueado;
    }


    /**
     * Gets the fechaBaja value for this PuntoVentaType.
     * 
     * @return fechaBaja
     */
    public java.util.Date getFechaBaja() {
        return fechaBaja;
    }


    /**
     * Sets the fechaBaja value for this PuntoVentaType.
     * 
     * @param fechaBaja
     */
    public void setFechaBaja(java.util.Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PuntoVentaType)) return false;
        PuntoVentaType other = (PuntoVentaType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numeroPuntoVenta == other.getNumeroPuntoVenta() &&
            ((this.bloqueado==null && other.getBloqueado()==null) || 
             (this.bloqueado!=null &&
              this.bloqueado.equals(other.getBloqueado()))) &&
            ((this.fechaBaja==null && other.getFechaBaja()==null) || 
             (this.fechaBaja!=null &&
              this.fechaBaja.equals(other.getFechaBaja())));
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
        _hashCode += getNumeroPuntoVenta();
        if (getBloqueado() != null) {
            _hashCode += getBloqueado().hashCode();
        }
        if (getFechaBaja() != null) {
            _hashCode += getFechaBaja().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PuntoVentaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bloqueado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bloqueado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SiNoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaBaja");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaBaja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
