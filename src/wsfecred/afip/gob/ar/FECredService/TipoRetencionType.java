/**
 * TipoRetencionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class TipoRetencionType  implements java.io.Serializable {
    private short codigoJurisdiccion;

    private java.lang.String descripcionJurisdiccion;

    private java.math.BigDecimal porcentajeRetencion;

    public TipoRetencionType() {
    }

    public TipoRetencionType(
           short codigoJurisdiccion,
           java.lang.String descripcionJurisdiccion,
           java.math.BigDecimal porcentajeRetencion) {
           this.codigoJurisdiccion = codigoJurisdiccion;
           this.descripcionJurisdiccion = descripcionJurisdiccion;
           this.porcentajeRetencion = porcentajeRetencion;
    }


    /**
     * Gets the codigoJurisdiccion value for this TipoRetencionType.
     * 
     * @return codigoJurisdiccion
     */
    public short getCodigoJurisdiccion() {
        return codigoJurisdiccion;
    }


    /**
     * Sets the codigoJurisdiccion value for this TipoRetencionType.
     * 
     * @param codigoJurisdiccion
     */
    public void setCodigoJurisdiccion(short codigoJurisdiccion) {
        this.codigoJurisdiccion = codigoJurisdiccion;
    }


    /**
     * Gets the descripcionJurisdiccion value for this TipoRetencionType.
     * 
     * @return descripcionJurisdiccion
     */
    public java.lang.String getDescripcionJurisdiccion() {
        return descripcionJurisdiccion;
    }


    /**
     * Sets the descripcionJurisdiccion value for this TipoRetencionType.
     * 
     * @param descripcionJurisdiccion
     */
    public void setDescripcionJurisdiccion(java.lang.String descripcionJurisdiccion) {
        this.descripcionJurisdiccion = descripcionJurisdiccion;
    }


    /**
     * Gets the porcentajeRetencion value for this TipoRetencionType.
     * 
     * @return porcentajeRetencion
     */
    public java.math.BigDecimal getPorcentajeRetencion() {
        return porcentajeRetencion;
    }


    /**
     * Sets the porcentajeRetencion value for this TipoRetencionType.
     * 
     * @param porcentajeRetencion
     */
    public void setPorcentajeRetencion(java.math.BigDecimal porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TipoRetencionType)) return false;
        TipoRetencionType other = (TipoRetencionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigoJurisdiccion == other.getCodigoJurisdiccion() &&
            ((this.descripcionJurisdiccion==null && other.getDescripcionJurisdiccion()==null) || 
             (this.descripcionJurisdiccion!=null &&
              this.descripcionJurisdiccion.equals(other.getDescripcionJurisdiccion()))) &&
            ((this.porcentajeRetencion==null && other.getPorcentajeRetencion()==null) || 
             (this.porcentajeRetencion!=null &&
              this.porcentajeRetencion.equals(other.getPorcentajeRetencion())));
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
        _hashCode += getCodigoJurisdiccion();
        if (getDescripcionJurisdiccion() != null) {
            _hashCode += getDescripcionJurisdiccion().hashCode();
        }
        if (getPorcentajeRetencion() != null) {
            _hashCode += getPorcentajeRetencion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TipoRetencionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoRetencionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoJurisdiccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoJurisdiccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionJurisdiccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcionJurisdiccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentajeRetencion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "porcentajeRetencion"));
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
