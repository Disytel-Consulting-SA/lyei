/**
 * DummyResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class DummyResponseType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.DummyReturnType dummyReturn;

    public DummyResponseType() {
    }

    public DummyResponseType(
           wsfecred.afip.gob.ar.FECredService.DummyReturnType dummyReturn) {
           this.dummyReturn = dummyReturn;
    }


    /**
     * Gets the dummyReturn value for this DummyResponseType.
     * 
     * @return dummyReturn
     */
    public wsfecred.afip.gob.ar.FECredService.DummyReturnType getDummyReturn() {
        return dummyReturn;
    }


    /**
     * Sets the dummyReturn value for this DummyResponseType.
     * 
     * @param dummyReturn
     */
    public void setDummyReturn(wsfecred.afip.gob.ar.FECredService.DummyReturnType dummyReturn) {
        this.dummyReturn = dummyReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DummyResponseType)) return false;
        DummyResponseType other = (DummyResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dummyReturn==null && other.getDummyReturn()==null) || 
             (this.dummyReturn!=null &&
              this.dummyReturn.equals(other.getDummyReturn())));
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
        if (getDummyReturn() != null) {
            _hashCode += getDummyReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DummyResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DummyResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dummyReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dummyReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DummyReturnType"));
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
