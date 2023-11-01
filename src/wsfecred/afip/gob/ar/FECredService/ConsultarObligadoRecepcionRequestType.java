/**
 * ConsultarObligadoRecepcionRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarObligadoRecepcionRequestType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest;

    private long cuitConsultada;

    public ConsultarObligadoRecepcionRequestType() {
    }

    public ConsultarObligadoRecepcionRequestType(
           wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest,
           long cuitConsultada) {
           this.authRequest = authRequest;
           this.cuitConsultada = cuitConsultada;
    }


    /**
     * Gets the authRequest value for this ConsultarObligadoRecepcionRequestType.
     * 
     * @return authRequest
     */
    public wsfecred.afip.gob.ar.FECredService.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ConsultarObligadoRecepcionRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the cuitConsultada value for this ConsultarObligadoRecepcionRequestType.
     * 
     * @return cuitConsultada
     */
    public long getCuitConsultada() {
        return cuitConsultada;
    }


    /**
     * Sets the cuitConsultada value for this ConsultarObligadoRecepcionRequestType.
     * 
     * @param cuitConsultada
     */
    public void setCuitConsultada(long cuitConsultada) {
        this.cuitConsultada = cuitConsultada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarObligadoRecepcionRequestType)) return false;
        ConsultarObligadoRecepcionRequestType other = (ConsultarObligadoRecepcionRequestType) obj;
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
            this.cuitConsultada == other.getCuitConsultada();
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
        _hashCode += new Long(getCuitConsultada()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarObligadoRecepcionRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuitConsultada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuitConsultada"));
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
