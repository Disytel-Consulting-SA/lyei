/**
 * ClsFEXResponse_Mon_CON_Cotizacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fexv1.dif.afip.gov.ar;

public class ClsFEXResponse_Mon_CON_Cotizacion  implements java.io.Serializable {
    private java.lang.String mon_Id;

    private java.lang.String mon_Ds;

    private java.lang.String mon_ctz;

    private java.lang.String fecha_ctz;

    public ClsFEXResponse_Mon_CON_Cotizacion() {
    }

    public ClsFEXResponse_Mon_CON_Cotizacion(
           java.lang.String mon_Id,
           java.lang.String mon_Ds,
           java.lang.String mon_ctz,
           java.lang.String fecha_ctz) {
           this.mon_Id = mon_Id;
           this.mon_Ds = mon_Ds;
           this.mon_ctz = mon_ctz;
           this.fecha_ctz = fecha_ctz;
    }


    /**
     * Gets the mon_Id value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @return mon_Id
     */
    public java.lang.String getMon_Id() {
        return mon_Id;
    }


    /**
     * Sets the mon_Id value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @param mon_Id
     */
    public void setMon_Id(java.lang.String mon_Id) {
        this.mon_Id = mon_Id;
    }


    /**
     * Gets the mon_Ds value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @return mon_Ds
     */
    public java.lang.String getMon_Ds() {
        return mon_Ds;
    }


    /**
     * Sets the mon_Ds value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @param mon_Ds
     */
    public void setMon_Ds(java.lang.String mon_Ds) {
        this.mon_Ds = mon_Ds;
    }


    /**
     * Gets the mon_ctz value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @return mon_ctz
     */
    public java.lang.String getMon_ctz() {
        return mon_ctz;
    }


    /**
     * Sets the mon_ctz value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @param mon_ctz
     */
    public void setMon_ctz(java.lang.String mon_ctz) {
        this.mon_ctz = mon_ctz;
    }


    /**
     * Gets the fecha_ctz value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @return fecha_ctz
     */
    public java.lang.String getFecha_ctz() {
        return fecha_ctz;
    }


    /**
     * Sets the fecha_ctz value for this ClsFEXResponse_Mon_CON_Cotizacion.
     * 
     * @param fecha_ctz
     */
    public void setFecha_ctz(java.lang.String fecha_ctz) {
        this.fecha_ctz = fecha_ctz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClsFEXResponse_Mon_CON_Cotizacion)) return false;
        ClsFEXResponse_Mon_CON_Cotizacion other = (ClsFEXResponse_Mon_CON_Cotizacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mon_Id==null && other.getMon_Id()==null) || 
             (this.mon_Id!=null &&
              this.mon_Id.equals(other.getMon_Id()))) &&
            ((this.mon_Ds==null && other.getMon_Ds()==null) || 
             (this.mon_Ds!=null &&
              this.mon_Ds.equals(other.getMon_Ds()))) &&
            ((this.mon_ctz==null && other.getMon_ctz()==null) || 
             (this.mon_ctz!=null &&
              this.mon_ctz.equals(other.getMon_ctz()))) &&
            ((this.fecha_ctz==null && other.getFecha_ctz()==null) || 
             (this.fecha_ctz!=null &&
              this.fecha_ctz.equals(other.getFecha_ctz())));
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
        if (getMon_Id() != null) {
            _hashCode += getMon_Id().hashCode();
        }
        if (getMon_Ds() != null) {
            _hashCode += getMon_Ds().hashCode();
        }
        if (getMon_ctz() != null) {
            _hashCode += getMon_ctz().hashCode();
        }
        if (getFecha_ctz() != null) {
            _hashCode += getFecha_ctz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClsFEXResponse_Mon_CON_Cotizacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fexv1/", "ClsFEXResponse_Mon_CON_Cotizacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mon_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fexv1/", "Mon_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mon_Ds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fexv1/", "Mon_Ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mon_ctz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fexv1/", "Mon_ctz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_ctz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fexv1/", "Fecha_ctz"));
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
