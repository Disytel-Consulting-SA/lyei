/**
 * RetencionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class RetencionType  implements java.io.Serializable {
    private short codTipo;

    private java.math.BigDecimal importe;

    private java.math.BigDecimal porcentaje;

    private java.lang.String descMotivo;

    public RetencionType() {
    }

    public RetencionType(
           short codTipo,
           java.math.BigDecimal importe,
           java.math.BigDecimal porcentaje,
           java.lang.String descMotivo) {
           this.codTipo = codTipo;
           this.importe = importe;
           this.porcentaje = porcentaje;
           this.descMotivo = descMotivo;
    }


    /**
     * Gets the codTipo value for this RetencionType.
     * 
     * @return codTipo
     */
    public short getCodTipo() {
        return codTipo;
    }


    /**
     * Sets the codTipo value for this RetencionType.
     * 
     * @param codTipo
     */
    public void setCodTipo(short codTipo) {
        this.codTipo = codTipo;
    }


    /**
     * Gets the importe value for this RetencionType.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this RetencionType.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the porcentaje value for this RetencionType.
     * 
     * @return porcentaje
     */
    public java.math.BigDecimal getPorcentaje() {
        return porcentaje;
    }


    /**
     * Sets the porcentaje value for this RetencionType.
     * 
     * @param porcentaje
     */
    public void setPorcentaje(java.math.BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }


    /**
     * Gets the descMotivo value for this RetencionType.
     * 
     * @return descMotivo
     */
    public java.lang.String getDescMotivo() {
        return descMotivo;
    }


    /**
     * Sets the descMotivo value for this RetencionType.
     * 
     * @param descMotivo
     */
    public void setDescMotivo(java.lang.String descMotivo) {
        this.descMotivo = descMotivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetencionType)) return false;
        RetencionType other = (RetencionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codTipo == other.getCodTipo() &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.porcentaje==null && other.getPorcentaje()==null) || 
             (this.porcentaje!=null &&
              this.porcentaje.equals(other.getPorcentaje()))) &&
            ((this.descMotivo==null && other.getDescMotivo()==null) || 
             (this.descMotivo!=null &&
              this.descMotivo.equals(other.getDescMotivo())));
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
        _hashCode += getCodTipo();
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getPorcentaje() != null) {
            _hashCode += getPorcentaje().hashCode();
        }
        if (getDescMotivo() != null) {
            _hashCode += getDescMotivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetencionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RetencionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codTipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codTipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "porcentaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descMotivo"));
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
