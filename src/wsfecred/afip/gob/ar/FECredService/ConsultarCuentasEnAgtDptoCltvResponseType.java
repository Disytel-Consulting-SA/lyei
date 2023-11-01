/**
 * ConsultarCuentasEnAgtDptoCltvResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarCuentasEnAgtDptoCltvResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvReturnType consultarCuentasEnAgtDptoCltvReturn;

    public ConsultarCuentasEnAgtDptoCltvResponseType() {
    }

    public ConsultarCuentasEnAgtDptoCltvResponseType(
           wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvReturnType consultarCuentasEnAgtDptoCltvReturn) {
           this.consultarCuentasEnAgtDptoCltvReturn = consultarCuentasEnAgtDptoCltvReturn;
    }


    /**
     * Gets the consultarCuentasEnAgtDptoCltvReturn value for this ConsultarCuentasEnAgtDptoCltvResponseType.
     * 
     * @return consultarCuentasEnAgtDptoCltvReturn
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvReturnType getConsultarCuentasEnAgtDptoCltvReturn() {
        return consultarCuentasEnAgtDptoCltvReturn;
    }


    /**
     * Sets the consultarCuentasEnAgtDptoCltvReturn value for this ConsultarCuentasEnAgtDptoCltvResponseType.
     * 
     * @param consultarCuentasEnAgtDptoCltvReturn
     */
    public void setConsultarCuentasEnAgtDptoCltvReturn(wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvReturnType consultarCuentasEnAgtDptoCltvReturn) {
        this.consultarCuentasEnAgtDptoCltvReturn = consultarCuentasEnAgtDptoCltvReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCuentasEnAgtDptoCltvResponseType)) return false;
        ConsultarCuentasEnAgtDptoCltvResponseType other = (ConsultarCuentasEnAgtDptoCltvResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultarCuentasEnAgtDptoCltvReturn==null && other.getConsultarCuentasEnAgtDptoCltvReturn()==null) || 
             (this.consultarCuentasEnAgtDptoCltvReturn!=null &&
              this.consultarCuentasEnAgtDptoCltvReturn.equals(other.getConsultarCuentasEnAgtDptoCltvReturn())));
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
        if (getConsultarCuentasEnAgtDptoCltvReturn() != null) {
            _hashCode += getConsultarCuentasEnAgtDptoCltvReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarCuentasEnAgtDptoCltvResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCuentasEnAgtDptoCltvResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultarCuentasEnAgtDptoCltvReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consultarCuentasEnAgtDptoCltvReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCuentasEnAgtDptoCltvReturnType"));
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
