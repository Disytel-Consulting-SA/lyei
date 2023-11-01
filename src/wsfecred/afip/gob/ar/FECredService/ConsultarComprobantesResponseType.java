/**
 * ConsultarComprobantesResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarComprobantesResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarCmpReturnType consultarCmpReturn;

    public ConsultarComprobantesResponseType() {
    }

    public ConsultarComprobantesResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarCmpReturnType consultarCmpReturn) {
           this.consultarCmpReturn = consultarCmpReturn;
    }


    /**
     * Gets the consultarCmpReturn value for this ConsultarComprobantesResponseType.
     * 
     * @return consultarCmpReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCmpReturnType getConsultarCmpReturn() {
        return consultarCmpReturn;
    }


    /**
     * Sets the consultarCmpReturn value for this ConsultarComprobantesResponseType.
     * 
     * @param consultarCmpReturn
     */
    public void setConsultarCmpReturn(wsfecred.afip.gob.ar.FECredService.ConsultarCmpReturnType consultarCmpReturn) {
        this.consultarCmpReturn = consultarCmpReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarComprobantesResponseType)) return false;
        ConsultarComprobantesResponseType other = (ConsultarComprobantesResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarCmpReturn==null && other.getConsultarCmpReturn()==null) || 
             (this.consultarCmpReturn!=null &&
              this.consultarCmpReturn.equals(other.getConsultarCmpReturn())));
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
        if (getConsultarCmpReturn() != null) {
            _hashCode += getConsultarCmpReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarComprobantesResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarComprobantesResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarCmpReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarCmpReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCmpReturnType"));
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
