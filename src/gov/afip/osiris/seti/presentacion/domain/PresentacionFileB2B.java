/**
 * PresentacionFileB2B.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.afip.osiris.seti.presentacion.domain;

public class PresentacionFileB2B  implements java.io.Serializable {
    private byte[] presentacionDataHandler;

    private java.lang.String fileName;

    public PresentacionFileB2B() {
    }

    public PresentacionFileB2B(
           byte[] presentacionDataHandler,
           java.lang.String fileName) {
           this.presentacionDataHandler = presentacionDataHandler;
           this.fileName = fileName;
    }


    /**
     * Gets the presentacionDataHandler value for this PresentacionFileB2B.
     * 
     * @return presentacionDataHandler
     */
    public byte[] getPresentacionDataHandler() {
        return presentacionDataHandler;
    }


    /**
     * Sets the presentacionDataHandler value for this PresentacionFileB2B.
     * 
     * @param presentacionDataHandler
     */
    public void setPresentacionDataHandler(byte[] presentacionDataHandler) {
        this.presentacionDataHandler = presentacionDataHandler;
    }


    /**
     * Gets the fileName value for this PresentacionFileB2B.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this PresentacionFileB2B.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PresentacionFileB2B)) return false;
        PresentacionFileB2B other = (PresentacionFileB2B) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.presentacionDataHandler==null && other.getPresentacionDataHandler()==null) || 
             (this.presentacionDataHandler!=null &&
              java.util.Arrays.equals(this.presentacionDataHandler, other.getPresentacionDataHandler()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName())));
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
        if (getPresentacionDataHandler() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPresentacionDataHandler());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPresentacionDataHandler(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PresentacionFileB2B.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.presentacion.seti.osiris.afip.gov/", "presentacionFileB2B"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("presentacionDataHandler");
        elemField.setXmlName(new javax.xml.namespace.QName("", "presentacionDataHandler"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
