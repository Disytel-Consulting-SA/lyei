/**
 * AutorizarAjusteIVARequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class AutorizarAjusteIVARequestType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest;

    private ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType comprobanteCAERequest;

    public AutorizarAjusteIVARequestType() {
    }

    public AutorizarAjusteIVARequestType(
           ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest,
           ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType comprobanteCAERequest) {
           this.authRequest = authRequest;
           this.comprobanteCAERequest = comprobanteCAERequest;
    }


    /**
     * Gets the authRequest value for this AutorizarAjusteIVARequestType.
     * 
     * @return authRequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this AutorizarAjusteIVARequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the comprobanteCAERequest value for this AutorizarAjusteIVARequestType.
     * 
     * @return comprobanteCAERequest
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType getComprobanteCAERequest() {
        return comprobanteCAERequest;
    }


    /**
     * Sets the comprobanteCAERequest value for this AutorizarAjusteIVARequestType.
     * 
     * @param comprobanteCAERequest
     */
    public void setComprobanteCAERequest(ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType comprobanteCAERequest) {
        this.comprobanteCAERequest = comprobanteCAERequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutorizarAjusteIVARequestType)) return false;
        AutorizarAjusteIVARequestType other = (AutorizarAjusteIVARequestType) obj;
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
            ((this.comprobanteCAERequest==null && other.getComprobanteCAERequest()==null) || 
             (this.comprobanteCAERequest!=null &&
              this.comprobanteCAERequest.equals(other.getComprobanteCAERequest())));
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
        if (getComprobanteCAERequest() != null) {
            _hashCode += getComprobanteCAERequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutorizarAjusteIVARequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarAjusteIVARequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobanteCAERequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobanteCAERequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteType"));
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
