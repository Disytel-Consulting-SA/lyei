/**
 * ConsultarTiposRetencionesResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarTiposRetencionesResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesReturnType consultarTiposRetencionesReturn;

    public ConsultarTiposRetencionesResponseType() {
    }

    public ConsultarTiposRetencionesResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesReturnType consultarTiposRetencionesReturn) {
           this.consultarTiposRetencionesReturn = consultarTiposRetencionesReturn;
    }


    /**
     * Gets the consultarTiposRetencionesReturn value for this ConsultarTiposRetencionesResponseType.
     * 
     * @return consultarTiposRetencionesReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesReturnType getConsultarTiposRetencionesReturn() {
        return consultarTiposRetencionesReturn;
    }


    /**
     * Sets the consultarTiposRetencionesReturn value for this ConsultarTiposRetencionesResponseType.
     * 
     * @param consultarTiposRetencionesReturn
     */
    public void setConsultarTiposRetencionesReturn(wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesReturnType consultarTiposRetencionesReturn) {
        this.consultarTiposRetencionesReturn = consultarTiposRetencionesReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarTiposRetencionesResponseType)) return false;
        ConsultarTiposRetencionesResponseType other = (ConsultarTiposRetencionesResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarTiposRetencionesReturn==null && other.getConsultarTiposRetencionesReturn()==null) || 
             (this.consultarTiposRetencionesReturn!=null &&
              this.consultarTiposRetencionesReturn.equals(other.getConsultarTiposRetencionesReturn())));
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
        if (getConsultarTiposRetencionesReturn() != null) {
            _hashCode += getConsultarTiposRetencionesReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarTiposRetencionesResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarTiposRetencionesReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarTiposRetencionesReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesReturnType"));
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
