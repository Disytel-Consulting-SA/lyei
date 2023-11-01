/**
 * ConsultarHistorialEstadosCtaCteResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarHistorialEstadosCtaCteResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteReturnType consultarHistorialEstadosCtaCteReturn;

    public ConsultarHistorialEstadosCtaCteResponseType() {
    }

    public ConsultarHistorialEstadosCtaCteResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteReturnType consultarHistorialEstadosCtaCteReturn) {
           this.consultarHistorialEstadosCtaCteReturn = consultarHistorialEstadosCtaCteReturn;
    }


    /**
     * Gets the consultarHistorialEstadosCtaCteReturn value for this ConsultarHistorialEstadosCtaCteResponseType.
     * 
     * @return consultarHistorialEstadosCtaCteReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteReturnType getConsultarHistorialEstadosCtaCteReturn() {
        return consultarHistorialEstadosCtaCteReturn;
    }


    /**
     * Sets the consultarHistorialEstadosCtaCteReturn value for this ConsultarHistorialEstadosCtaCteResponseType.
     * 
     * @param consultarHistorialEstadosCtaCteReturn
     */
    public void setConsultarHistorialEstadosCtaCteReturn(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteReturnType consultarHistorialEstadosCtaCteReturn) {
        this.consultarHistorialEstadosCtaCteReturn = consultarHistorialEstadosCtaCteReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarHistorialEstadosCtaCteResponseType)) return false;
        ConsultarHistorialEstadosCtaCteResponseType other = (ConsultarHistorialEstadosCtaCteResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarHistorialEstadosCtaCteReturn==null && other.getConsultarHistorialEstadosCtaCteReturn()==null) || 
             (this.consultarHistorialEstadosCtaCteReturn!=null &&
              this.consultarHistorialEstadosCtaCteReturn.equals(other.getConsultarHistorialEstadosCtaCteReturn())));
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
        if (getConsultarHistorialEstadosCtaCteReturn() != null) {
            _hashCode += getConsultarHistorialEstadosCtaCteReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarHistorialEstadosCtaCteResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarHistorialEstadosCtaCteReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarHistorialEstadosCtaCteReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteReturnType"));
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
