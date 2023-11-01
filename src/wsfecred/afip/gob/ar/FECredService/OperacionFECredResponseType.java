/**
 * OperacionFECredResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class OperacionFECredResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.OperacionFECredReturnType operacionFECredReturn;

    public OperacionFECredResponseType() {
    }

    public OperacionFECredResponseType(
           wsfecred.afip.gob.ar.FECredService.OperacionFECredReturnType operacionFECredReturn) {
           this.operacionFECredReturn = operacionFECredReturn;
    }


    /**
     * Gets the operacionFECredReturn value for this OperacionFECredResponseType.
     * 
     * @return operacionFECredReturn
     */
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredReturnType getOperacionFECredReturn() {
        return operacionFECredReturn;
    }


    /**
     * Sets the operacionFECredReturn value for this OperacionFECredResponseType.
     * 
     * @param operacionFECredReturn
     */
    public void setOperacionFECredReturn(wsfecred.afip.gob.ar.FECredService.OperacionFECredReturnType operacionFECredReturn) {
        this.operacionFECredReturn = operacionFECredReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperacionFECredResponseType)) return false;
        OperacionFECredResponseType other = (OperacionFECredResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operacionFECredReturn==null && other.getOperacionFECredReturn()==null) || 
             (this.operacionFECredReturn!=null &&
              this.operacionFECredReturn.equals(other.getOperacionFECredReturn())));
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
        if (getOperacionFECredReturn() != null) {
            _hashCode += getOperacionFECredReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperacionFECredResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionFECredReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operacionFECredReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredReturnType"));
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
