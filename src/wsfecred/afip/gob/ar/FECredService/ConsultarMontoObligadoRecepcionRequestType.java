/**
 * ConsultarMontoObligadoRecepcionRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarMontoObligadoRecepcionRequestType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest;

    private long cuitConsultada;

    private java.util.Date fechaEmision;

    public ConsultarMontoObligadoRecepcionRequestType() {
    }

    public ConsultarMontoObligadoRecepcionRequestType(
           wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest,
           long cuitConsultada,
           java.util.Date fechaEmision) {
           this.authRequest = authRequest;
           this.cuitConsultada = cuitConsultada;
           this.fechaEmision = fechaEmision;
    }


    /**
     * Gets the authRequest value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @return authRequest
     */
    public wsfecred.afip.gob.ar.FECredService.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the cuitConsultada value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @return cuitConsultada
     */
    public long getCuitConsultada() {
        return cuitConsultada;
    }


    /**
     * Sets the cuitConsultada value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @param cuitConsultada
     */
    public void setCuitConsultada(long cuitConsultada) {
        this.cuitConsultada = cuitConsultada;
    }


    /**
     * Gets the fechaEmision value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @return fechaEmision
     */
    public java.util.Date getFechaEmision() {
        return fechaEmision;
    }


    /**
     * Sets the fechaEmision value for this ConsultarMontoObligadoRecepcionRequestType.
     * 
     * @param fechaEmision
     */
    public void setFechaEmision(java.util.Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMontoObligadoRecepcionRequestType)) return false;
        ConsultarMontoObligadoRecepcionRequestType other = (ConsultarMontoObligadoRecepcionRequestType) obj;
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
            this.cuitConsultada == other.getCuitConsultada() &&
            ((this.fechaEmision==null && other.getFechaEmision()==null) || 
             (this.fechaEmision!=null &&
              this.fechaEmision.equals(other.getFechaEmision())));
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
        if (getFechaEmision() != null) {
            _hashCode += getFechaEmision().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarMontoObligadoRecepcionRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionRequestType"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEmision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaEmision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
