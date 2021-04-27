/**
 * InformarCAEANoUtilizadoPtoVtaRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class InformarCAEANoUtilizadoPtoVtaRequestType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest;

    private long CAEA;

    private int numeroPuntoVenta;

    public InformarCAEANoUtilizadoPtoVtaRequestType() {
    }

    public InformarCAEANoUtilizadoPtoVtaRequestType(
           ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest,
           long CAEA,
           int numeroPuntoVenta) {
           this.authRequest = authRequest;
           this.CAEA = CAEA;
           this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the authRequest value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @return authRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the CAEA value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @return CAEA
     */
    public long getCAEA() {
        return CAEA;
    }


    /**
     * Sets the CAEA value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @param CAEA
     */
    public void setCAEA(long CAEA) {
        this.CAEA = CAEA;
    }


    /**
     * Gets the numeroPuntoVenta value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this InformarCAEANoUtilizadoPtoVtaRequestType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformarCAEANoUtilizadoPtoVtaRequestType)) return false;
        InformarCAEANoUtilizadoPtoVtaRequestType other = (InformarCAEANoUtilizadoPtoVtaRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authRequest==null && other.getAuthRequest()==null) || 
             (this.authRequest!=null &&
              this.authRequest.equals(other.getAuthRequest()))) &&
            this.CAEA == other.getCAEA() &&
            this.numeroPuntoVenta == other.getNumeroPuntoVenta();
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
        if (getAuthRequest() != null) {
            _hashCode += getAuthRequest().hashCode();
        }
        _hashCode += new Long(getCAEA()).hashCode();
        _hashCode += getNumeroPuntoVenta();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformarCAEANoUtilizadoPtoVtaRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAEA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CAEA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
