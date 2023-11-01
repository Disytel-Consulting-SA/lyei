/**
 * OtroTributoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class OtroTributoType  implements java.io.Serializable {
    private short codigo;

    private java.lang.String detalle;

    private java.math.BigDecimal baseImponible;

    private java.math.BigDecimal importe;

    public OtroTributoType() {
    }

    public OtroTributoType(
           short codigo,
           java.lang.String detalle,
           java.math.BigDecimal baseImponible,
           java.math.BigDecimal importe) {
           this.codigo = codigo;
           this.detalle = detalle;
           this.baseImponible = baseImponible;
           this.importe = importe;
    }


    /**
     * Gets the codigo value for this OtroTributoType.
     * 
     * @return codigo
     */
    public short getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this OtroTributoType.
     * 
     * @param codigo
     */
    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the detalle value for this OtroTributoType.
     * 
     * @return detalle
     */
    public java.lang.String getDetalle() {
        return detalle;
    }


    /**
     * Sets the detalle value for this OtroTributoType.
     * 
     * @param detalle
     */
    public void setDetalle(java.lang.String detalle) {
        this.detalle = detalle;
    }


    /**
     * Gets the baseImponible value for this OtroTributoType.
     * 
     * @return baseImponible
     */
    public java.math.BigDecimal getBaseImponible() {
        return baseImponible;
    }


    /**
     * Sets the baseImponible value for this OtroTributoType.
     * 
     * @param baseImponible
     */
    public void setBaseImponible(java.math.BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }


    /**
     * Gets the importe value for this OtroTributoType.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this OtroTributoType.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OtroTributoType)) return false;
        OtroTributoType other = (OtroTributoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigo == other.getCodigo() &&
            ((this.detalle==null && other.getDetalle()==null) || 
             (this.detalle!=null &&
              this.detalle.equals(other.getDetalle()))) &&
            ((this.baseImponible==null && other.getBaseImponible()==null) || 
             (this.baseImponible!=null &&
              this.baseImponible.equals(other.getBaseImponible()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte())));
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
        _hashCode += getCodigo();
        if (getDetalle() != null) {
            _hashCode += getDetalle().hashCode();
        }
        if (getBaseImponible() != null) {
            _hashCode += getBaseImponible().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OtroTributoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OtroTributoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detalle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detalle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseImponible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseImponible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
