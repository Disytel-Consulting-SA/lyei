/**
 * ConsultarCtasCtesResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarCtasCtesResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesReturnType consultarCtasCtesReturn;

    public ConsultarCtasCtesResponseType() {
    }

    public ConsultarCtasCtesResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesReturnType consultarCtasCtesReturn) {
           this.consultarCtasCtesReturn = consultarCtasCtesReturn;
    }


    /**
     * Gets the consultarCtasCtesReturn value for this ConsultarCtasCtesResponseType.
     * 
     * @return consultarCtasCtesReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesReturnType getConsultarCtasCtesReturn() {
        return consultarCtasCtesReturn;
    }


    /**
     * Sets the consultarCtasCtesReturn value for this ConsultarCtasCtesResponseType.
     * 
     * @param consultarCtasCtesReturn
     */
    public void setConsultarCtasCtesReturn(wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesReturnType consultarCtasCtesReturn) {
        this.consultarCtasCtesReturn = consultarCtasCtesReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCtasCtesResponseType)) return false;
        ConsultarCtasCtesResponseType other = (ConsultarCtasCtesResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarCtasCtesReturn==null && other.getConsultarCtasCtesReturn()==null) || 
             (this.consultarCtasCtesReturn!=null &&
              this.consultarCtasCtesReturn.equals(other.getConsultarCtasCtesReturn())));
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
        if (getConsultarCtasCtesReturn() != null) {
            _hashCode += getConsultarCtasCtesReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarCtasCtesResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarCtasCtesReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarCtasCtesReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesReturnType"));
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
