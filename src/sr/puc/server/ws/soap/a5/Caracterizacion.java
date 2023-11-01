/**
 * Caracterizacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class Caracterizacion  implements java.io.Serializable {
    private java.lang.String descripcionCaracterizacion;

    private java.lang.Integer idCaracterizacion;

    private java.lang.Integer periodo;

    public Caracterizacion() {
    }

    public Caracterizacion(
           java.lang.String descripcionCaracterizacion,
           java.lang.Integer idCaracterizacion,
           java.lang.Integer periodo) {
           this.descripcionCaracterizacion = descripcionCaracterizacion;
           this.idCaracterizacion = idCaracterizacion;
           this.periodo = periodo;
    }


    /**
     * Gets the descripcionCaracterizacion value for this Caracterizacion.
     * 
     * @return descripcionCaracterizacion
     */
    public java.lang.String getDescripcionCaracterizacion() {
        return descripcionCaracterizacion;
    }


    /**
     * Sets the descripcionCaracterizacion value for this Caracterizacion.
     * 
     * @param descripcionCaracterizacion
     */
    public void setDescripcionCaracterizacion(java.lang.String descripcionCaracterizacion) {
        this.descripcionCaracterizacion = descripcionCaracterizacion;
    }


    /**
     * Gets the idCaracterizacion value for this Caracterizacion.
     * 
     * @return idCaracterizacion
     */
    public java.lang.Integer getIdCaracterizacion() {
        return idCaracterizacion;
    }


    /**
     * Sets the idCaracterizacion value for this Caracterizacion.
     * 
     * @param idCaracterizacion
     */
    public void setIdCaracterizacion(java.lang.Integer idCaracterizacion) {
        this.idCaracterizacion = idCaracterizacion;
    }


    /**
     * Gets the periodo value for this Caracterizacion.
     * 
     * @return periodo
     */
    public java.lang.Integer getPeriodo() {
        return periodo;
    }


    /**
     * Sets the periodo value for this Caracterizacion.
     * 
     * @param periodo
     */
    public void setPeriodo(java.lang.Integer periodo) {
        this.periodo = periodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Caracterizacion)) return false;
        Caracterizacion other = (Caracterizacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcionCaracterizacion==null && other.getDescripcionCaracterizacion()==null) || 
             (this.descripcionCaracterizacion!=null &&
              this.descripcionCaracterizacion.equals(other.getDescripcionCaracterizacion()))) &&
            ((this.idCaracterizacion==null && other.getIdCaracterizacion()==null) || 
             (this.idCaracterizacion!=null &&
              this.idCaracterizacion.equals(other.getIdCaracterizacion()))) &&
            ((this.periodo==null && other.getPeriodo()==null) || 
             (this.periodo!=null &&
              this.periodo.equals(other.getPeriodo())));
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
        if (getDescripcionCaracterizacion() != null) {
            _hashCode += getDescripcionCaracterizacion().hashCode();
        }
        if (getIdCaracterizacion() != null) {
            _hashCode += getIdCaracterizacion().hashCode();
        }
        if (getPeriodo() != null) {
            _hashCode += getPeriodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Caracterizacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "caracterizacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionCaracterizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcionCaracterizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCaracterizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCaracterizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
