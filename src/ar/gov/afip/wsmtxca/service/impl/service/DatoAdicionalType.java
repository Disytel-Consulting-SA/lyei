/**
 * DatoAdicionalType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class DatoAdicionalType  implements java.io.Serializable {
    private short t;

    private java.lang.String c1;

    private java.lang.String c2;

    private java.lang.String c3;

    private java.lang.String c4;

    private java.lang.String c5;

    private java.lang.String c6;

    public DatoAdicionalType() {
    }

    public DatoAdicionalType(
           short t,
           java.lang.String c1,
           java.lang.String c2,
           java.lang.String c3,
           java.lang.String c4,
           java.lang.String c5,
           java.lang.String c6) {
           this.t = t;
           this.c1 = c1;
           this.c2 = c2;
           this.c3 = c3;
           this.c4 = c4;
           this.c5 = c5;
           this.c6 = c6;
    }


    /**
     * Gets the t value for this DatoAdicionalType.
     * 
     * @return t
     */
    public short getT() {
        return t;
    }


    /**
     * Sets the t value for this DatoAdicionalType.
     * 
     * @param t
     */
    public void setT(short t) {
        this.t = t;
    }


    /**
     * Gets the c1 value for this DatoAdicionalType.
     * 
     * @return c1
     */
    public java.lang.String getC1() {
        return c1;
    }


    /**
     * Sets the c1 value for this DatoAdicionalType.
     * 
     * @param c1
     */
    public void setC1(java.lang.String c1) {
        this.c1 = c1;
    }


    /**
     * Gets the c2 value for this DatoAdicionalType.
     * 
     * @return c2
     */
    public java.lang.String getC2() {
        return c2;
    }


    /**
     * Sets the c2 value for this DatoAdicionalType.
     * 
     * @param c2
     */
    public void setC2(java.lang.String c2) {
        this.c2 = c2;
    }


    /**
     * Gets the c3 value for this DatoAdicionalType.
     * 
     * @return c3
     */
    public java.lang.String getC3() {
        return c3;
    }


    /**
     * Sets the c3 value for this DatoAdicionalType.
     * 
     * @param c3
     */
    public void setC3(java.lang.String c3) {
        this.c3 = c3;
    }


    /**
     * Gets the c4 value for this DatoAdicionalType.
     * 
     * @return c4
     */
    public java.lang.String getC4() {
        return c4;
    }


    /**
     * Sets the c4 value for this DatoAdicionalType.
     * 
     * @param c4
     */
    public void setC4(java.lang.String c4) {
        this.c4 = c4;
    }


    /**
     * Gets the c5 value for this DatoAdicionalType.
     * 
     * @return c5
     */
    public java.lang.String getC5() {
        return c5;
    }


    /**
     * Sets the c5 value for this DatoAdicionalType.
     * 
     * @param c5
     */
    public void setC5(java.lang.String c5) {
        this.c5 = c5;
    }


    /**
     * Gets the c6 value for this DatoAdicionalType.
     * 
     * @return c6
     */
    public java.lang.String getC6() {
        return c6;
    }


    /**
     * Sets the c6 value for this DatoAdicionalType.
     * 
     * @param c6
     */
    public void setC6(java.lang.String c6) {
        this.c6 = c6;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatoAdicionalType)) return false;
        DatoAdicionalType other = (DatoAdicionalType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.t == other.getT() &&
            ((this.c1==null && other.getC1()==null) || 
             (this.c1!=null &&
              this.c1.equals(other.getC1()))) &&
            ((this.c2==null && other.getC2()==null) || 
             (this.c2!=null &&
              this.c2.equals(other.getC2()))) &&
            ((this.c3==null && other.getC3()==null) || 
             (this.c3!=null &&
              this.c3.equals(other.getC3()))) &&
            ((this.c4==null && other.getC4()==null) || 
             (this.c4!=null &&
              this.c4.equals(other.getC4()))) &&
            ((this.c5==null && other.getC5()==null) || 
             (this.c5!=null &&
              this.c5.equals(other.getC5()))) &&
            ((this.c6==null && other.getC6()==null) || 
             (this.c6!=null &&
              this.c6.equals(other.getC6())));
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
        _hashCode += getT();
        if (getC1() != null) {
            _hashCode += getC1().hashCode();
        }
        if (getC2() != null) {
            _hashCode += getC2().hashCode();
        }
        if (getC3() != null) {
            _hashCode += getC3().hashCode();
        }
        if (getC4() != null) {
            _hashCode += getC4().hashCode();
        }
        if (getC5() != null) {
            _hashCode += getC5().hashCode();
        }
        if (getC6() != null) {
            _hashCode += getC6().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatoAdicionalType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DatoAdicionalType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t");
        elemField.setXmlName(new javax.xml.namespace.QName("", "t"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "c6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
