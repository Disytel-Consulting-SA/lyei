/**
 * ConsultarMontoObligadoRecepcionResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarMontoObligadoRecepcionResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType consultarMontoObligadoRecepcionReturn;

    public ConsultarMontoObligadoRecepcionResponseType() {
    }

    public ConsultarMontoObligadoRecepcionResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType consultarMontoObligadoRecepcionReturn) {
           this.consultarMontoObligadoRecepcionReturn = consultarMontoObligadoRecepcionReturn;
    }


    /**
     * Gets the consultarMontoObligadoRecepcionReturn value for this ConsultarMontoObligadoRecepcionResponseType.
     * 
     * @return consultarMontoObligadoRecepcionReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType getConsultarMontoObligadoRecepcionReturn() {
        return consultarMontoObligadoRecepcionReturn;
    }


    /**
     * Sets the consultarMontoObligadoRecepcionReturn value for this ConsultarMontoObligadoRecepcionResponseType.
     * 
     * @param consultarMontoObligadoRecepcionReturn
     */
    public void setConsultarMontoObligadoRecepcionReturn(wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType consultarMontoObligadoRecepcionReturn) {
        this.consultarMontoObligadoRecepcionReturn = consultarMontoObligadoRecepcionReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarMontoObligadoRecepcionResponseType)) return false;
        ConsultarMontoObligadoRecepcionResponseType other = (ConsultarMontoObligadoRecepcionResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarMontoObligadoRecepcionReturn==null && other.getConsultarMontoObligadoRecepcionReturn()==null) || 
             (this.consultarMontoObligadoRecepcionReturn!=null &&
              this.consultarMontoObligadoRecepcionReturn.equals(other.getConsultarMontoObligadoRecepcionReturn())));
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
        if (getConsultarMontoObligadoRecepcionReturn() != null) {
            _hashCode += getConsultarMontoObligadoRecepcionReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarMontoObligadoRecepcionResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarMontoObligadoRecepcionReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarMontoObligadoRecepcionReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionReturnType"));
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
