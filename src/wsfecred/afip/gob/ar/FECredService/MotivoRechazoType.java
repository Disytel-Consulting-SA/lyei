/**
 * MotivoRechazoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class MotivoRechazoType  implements java.io.Serializable {
    private short codMotivo;

    private java.lang.String descMotivo;

    private java.lang.String justificacion;

    public MotivoRechazoType() {
    }

    public MotivoRechazoType(
           short codMotivo,
           java.lang.String descMotivo,
           java.lang.String justificacion) {
           this.codMotivo = codMotivo;
           this.descMotivo = descMotivo;
           this.justificacion = justificacion;
    }


    /**
     * Gets the codMotivo value for this MotivoRechazoType.
     * 
     * @return codMotivo
     */
    public short getCodMotivo() {
        return codMotivo;
    }


    /**
     * Sets the codMotivo value for this MotivoRechazoType.
     * 
     * @param codMotivo
     */
    public void setCodMotivo(short codMotivo) {
        this.codMotivo = codMotivo;
    }


    /**
     * Gets the descMotivo value for this MotivoRechazoType.
     * 
     * @return descMotivo
     */
    public java.lang.String getDescMotivo() {
        return descMotivo;
    }


    /**
     * Sets the descMotivo value for this MotivoRechazoType.
     * 
     * @param descMotivo
     */
    public void setDescMotivo(java.lang.String descMotivo) {
        this.descMotivo = descMotivo;
    }


    /**
     * Gets the justificacion value for this MotivoRechazoType.
     * 
     * @return justificacion
     */
    public java.lang.String getJustificacion() {
        return justificacion;
    }


    /**
     * Sets the justificacion value for this MotivoRechazoType.
     * 
     * @param justificacion
     */
    public void setJustificacion(java.lang.String justificacion) {
        this.justificacion = justificacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MotivoRechazoType)) return false;
        MotivoRechazoType other = (MotivoRechazoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codMotivo == other.getCodMotivo() &&
            ((this.descMotivo==null && other.getDescMotivo()==null) || 
             (this.descMotivo!=null &&
              this.descMotivo.equals(other.getDescMotivo()))) &&
            ((this.justificacion==null && other.getJustificacion()==null) || 
             (this.justificacion!=null &&
              this.justificacion.equals(other.getJustificacion())));
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
        _hashCode += getCodMotivo();
        if (getDescMotivo() != null) {
            _hashCode += getDescMotivo().hashCode();
        }
        if (getJustificacion() != null) {
            _hashCode += getJustificacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MotivoRechazoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "MotivoRechazoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descMotivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descMotivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "justificacion"));
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
