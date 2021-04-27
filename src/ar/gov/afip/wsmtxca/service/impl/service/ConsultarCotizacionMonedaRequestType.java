/**
 * ConsultarCotizacionMonedaRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultarCotizacionMonedaRequestType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest;

    private java.lang.String codigoMoneda;

    public ConsultarCotizacionMonedaRequestType() {
    }

    public ConsultarCotizacionMonedaRequestType(
           ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest,
           java.lang.String codigoMoneda) {
           this.authRequest = authRequest;
           this.codigoMoneda = codigoMoneda;
    }


    /**
     * Gets the authRequest value for this ConsultarCotizacionMonedaRequestType.
     * 
     * @return authRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ConsultarCotizacionMonedaRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the codigoMoneda value for this ConsultarCotizacionMonedaRequestType.
     * 
     * @return codigoMoneda
     */
    public java.lang.String getCodigoMoneda() {
        return codigoMoneda;
    }


    /**
     * Sets the codigoMoneda value for this ConsultarCotizacionMonedaRequestType.
     * 
     * @param codigoMoneda
     */
    public void setCodigoMoneda(java.lang.String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCotizacionMonedaRequestType)) return false;
        ConsultarCotizacionMonedaRequestType other = (ConsultarCotizacionMonedaRequestType) obj;
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
            ((this.codigoMoneda==null && other.getCodigoMoneda()==null) || 
             (this.codigoMoneda!=null &&
              this.codigoMoneda.equals(other.getCodigoMoneda())));
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
        if (getCodigoMoneda() != null) {
            _hashCode += getCodigoMoneda().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarCotizacionMonedaRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
