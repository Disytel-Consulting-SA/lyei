/**
 * ConsultarCtaCteResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarCtaCteResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteReturnType consultarCtaCteReturn;

    public ConsultarCtaCteResponseType() {
    }

    public ConsultarCtaCteResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteReturnType consultarCtaCteReturn) {
           this.consultarCtaCteReturn = consultarCtaCteReturn;
    }


    /**
     * Gets the consultarCtaCteReturn value for this ConsultarCtaCteResponseType.
     * 
     * @return consultarCtaCteReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteReturnType getConsultarCtaCteReturn() {
        return consultarCtaCteReturn;
    }


    /**
     * Sets the consultarCtaCteReturn value for this ConsultarCtaCteResponseType.
     * 
     * @param consultarCtaCteReturn
     */
    public void setConsultarCtaCteReturn(wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteReturnType consultarCtaCteReturn) {
        this.consultarCtaCteReturn = consultarCtaCteReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCtaCteResponseType)) return false;
        ConsultarCtaCteResponseType other = (ConsultarCtaCteResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarCtaCteReturn==null && other.getConsultarCtaCteReturn()==null) || 
             (this.consultarCtaCteReturn!=null &&
              this.consultarCtaCteReturn.equals(other.getConsultarCtaCteReturn())));
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
        if (getConsultarCtaCteReturn() != null) {
            _hashCode += getConsultarCtaCteReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarCtaCteResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarCtaCteReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarCtaCteReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteReturnType"));
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
