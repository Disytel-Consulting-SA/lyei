/**
 * ConsultarUltimoComprobanteAutorizadoRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultarUltimoComprobanteAutorizadoRequestType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest;

    private ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType consultaUltimoComprobanteAutorizadoRequest;

    public ConsultarUltimoComprobanteAutorizadoRequestType() {
    }

    public ConsultarUltimoComprobanteAutorizadoRequestType(
           ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest,
           ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType consultaUltimoComprobanteAutorizadoRequest) {
           this.authRequest = authRequest;
           this.consultaUltimoComprobanteAutorizadoRequest = consultaUltimoComprobanteAutorizadoRequest;
    }


    /**
     * Gets the authRequest value for this ConsultarUltimoComprobanteAutorizadoRequestType.
     * 
     * @return authRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ConsultarUltimoComprobanteAutorizadoRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the consultaUltimoComprobanteAutorizadoRequest value for this ConsultarUltimoComprobanteAutorizadoRequestType.
     * 
     * @return consultaUltimoComprobanteAutorizadoRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType getConsultaUltimoComprobanteAutorizadoRequest() {
        return consultaUltimoComprobanteAutorizadoRequest;
    }


    /**
     * Sets the consultaUltimoComprobanteAutorizadoRequest value for this ConsultarUltimoComprobanteAutorizadoRequestType.
     * 
     * @param consultaUltimoComprobanteAutorizadoRequest
     */
    public void setConsultaUltimoComprobanteAutorizadoRequest(ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType consultaUltimoComprobanteAutorizadoRequest) {
        this.consultaUltimoComprobanteAutorizadoRequest = consultaUltimoComprobanteAutorizadoRequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarUltimoComprobanteAutorizadoRequestType)) return false;
        ConsultarUltimoComprobanteAutorizadoRequestType other = (ConsultarUltimoComprobanteAutorizadoRequestType) obj;
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
            ((this.consultaUltimoComprobanteAutorizadoRequest==null && other.getConsultaUltimoComprobanteAutorizadoRequest()==null) || 
             (this.consultaUltimoComprobanteAutorizadoRequest!=null &&
              this.consultaUltimoComprobanteAutorizadoRequest.equals(other.getConsultaUltimoComprobanteAutorizadoRequest())));
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
        if (getConsultaUltimoComprobanteAutorizadoRequest() != null) {
            _hashCode += getConsultaUltimoComprobanteAutorizadoRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarUltimoComprobanteAutorizadoRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultaUltimoComprobanteAutorizadoRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultaUltimoComprobanteAutorizadoRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaUltimoComprobanteAutorizadoRequestType"));
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
