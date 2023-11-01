/**
 * EstadoCtaCteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class EstadoCtaCteType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.EstadoCtaCteSimpleType estado;

    private java.util.Calendar fechaHoraEstado;

    public EstadoCtaCteType() {
    }

    public EstadoCtaCteType(
           wsfecred.afip.gob.ar.FECredService.EstadoCtaCteSimpleType estado,
           java.util.Calendar fechaHoraEstado) {
           this.estado = estado;
           this.fechaHoraEstado = fechaHoraEstado;
    }


    /**
     * Gets the estado value for this EstadoCtaCteType.
     * 
     * @return estado
     */
    public wsfecred.afip.gob.ar.FECredService.EstadoCtaCteSimpleType getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this EstadoCtaCteType.
     * 
     * @param estado
     */
    public void setEstado(wsfecred.afip.gob.ar.FECredService.EstadoCtaCteSimpleType estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaHoraEstado value for this EstadoCtaCteType.
     * 
     * @return fechaHoraEstado
     */
    public java.util.Calendar getFechaHoraEstado() {
        return fechaHoraEstado;
    }


    /**
     * Sets the fechaHoraEstado value for this EstadoCtaCteType.
     * 
     * @param fechaHoraEstado
     */
    public void setFechaHoraEstado(java.util.Calendar fechaHoraEstado) {
        this.fechaHoraEstado = fechaHoraEstado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstadoCtaCteType)) return false;
        EstadoCtaCteType other = (EstadoCtaCteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaHoraEstado==null && other.getFechaHoraEstado()==null) || 
             (this.fechaHoraEstado!=null &&
              this.fechaHoraEstado.equals(other.getFechaHoraEstado())));
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaHoraEstado() != null) {
            _hashCode += getFechaHoraEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstadoCtaCteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHoraEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
