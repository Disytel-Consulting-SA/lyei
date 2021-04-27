/**
 * ConsultarComprobanteRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ConsultarComprobanteRequestType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest;

    private ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType consultaComprobanteRequest;

    public ConsultarComprobanteRequestType() {
    }

    public ConsultarComprobanteRequestType(
           ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest,
           ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType consultaComprobanteRequest) {
           this.authRequest = authRequest;
           this.consultaComprobanteRequest = consultaComprobanteRequest;
    }


    /**
     * Gets the authRequest value for this ConsultarComprobanteRequestType.
     * 
     * @return authRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ConsultarComprobanteRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the consultaComprobanteRequest value for this ConsultarComprobanteRequestType.
     * 
     * @return consultaComprobanteRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType getConsultaComprobanteRequest() {
        return consultaComprobanteRequest;
    }


    /**
     * Sets the consultaComprobanteRequest value for this ConsultarComprobanteRequestType.
     * 
     * @param consultaComprobanteRequest
     */
    public void setConsultaComprobanteRequest(ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType consultaComprobanteRequest) {
        this.consultaComprobanteRequest = consultaComprobanteRequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarComprobanteRequestType)) return false;
        ConsultarComprobanteRequestType other = (ConsultarComprobanteRequestType) obj;
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
            ((this.consultaComprobanteRequest==null && other.getConsultaComprobanteRequest()==null) || 
             (this.consultaComprobanteRequest!=null &&
              this.consultaComprobanteRequest.equals(other.getConsultaComprobanteRequest())));
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
        if (getConsultaComprobanteRequest() != null) {
            _hashCode += getConsultaComprobanteRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarComprobanteRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultaComprobanteRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultaComprobanteRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaComprobanteRequestType"));
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
