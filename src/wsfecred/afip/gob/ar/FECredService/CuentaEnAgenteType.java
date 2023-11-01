/**
 * CuentaEnAgenteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class CuentaEnAgenteType  implements java.io.Serializable {
    private long cuitAgente;

    private java.lang.String razonSocialAgente;

    private java.lang.String idCuenta;

    private java.lang.String denominacion;

    public CuentaEnAgenteType() {
    }

    public CuentaEnAgenteType(
           long cuitAgente,
           java.lang.String razonSocialAgente,
           java.lang.String idCuenta,
           java.lang.String denominacion) {
           this.cuitAgente = cuitAgente;
           this.razonSocialAgente = razonSocialAgente;
           this.idCuenta = idCuenta;
           this.denominacion = denominacion;
    }


    /**
     * Gets the cuitAgente value for this CuentaEnAgenteType.
     * 
     * @return cuitAgente
     */
    public long getCuitAgente() {
        return cuitAgente;
    }


    /**
     * Sets the cuitAgente value for this CuentaEnAgenteType.
     * 
     * @param cuitAgente
     */
    public void setCuitAgente(long cuitAgente) {
        this.cuitAgente = cuitAgente;
    }


    /**
     * Gets the razonSocialAgente value for this CuentaEnAgenteType.
     * 
     * @return razonSocialAgente
     */
    public java.lang.String getRazonSocialAgente() {
        return razonSocialAgente;
    }


    /**
     * Sets the razonSocialAgente value for this CuentaEnAgenteType.
     * 
     * @param razonSocialAgente
     */
    public void setRazonSocialAgente(java.lang.String razonSocialAgente) {
        this.razonSocialAgente = razonSocialAgente;
    }


    /**
     * Gets the idCuenta value for this CuentaEnAgenteType.
     * 
     * @return idCuenta
     */
    public java.lang.String getIdCuenta() {
        return idCuenta;
    }


    /**
     * Sets the idCuenta value for this CuentaEnAgenteType.
     * 
     * @param idCuenta
     */
    public void setIdCuenta(java.lang.String idCuenta) {
        this.idCuenta = idCuenta;
    }


    /**
     * Gets the denominacion value for this CuentaEnAgenteType.
     * 
     * @return denominacion
     */
    public java.lang.String getDenominacion() {
        return denominacion;
    }


    /**
     * Sets the denominacion value for this CuentaEnAgenteType.
     * 
     * @param denominacion
     */
    public void setDenominacion(java.lang.String denominacion) {
        this.denominacion = denominacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CuentaEnAgenteType)) return false;
        CuentaEnAgenteType other = (CuentaEnAgenteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cuitAgente == other.getCuitAgente() &&
            ((this.razonSocialAgente==null && other.getRazonSocialAgente()==null) || 
             (this.razonSocialAgente!=null &&
              this.razonSocialAgente.equals(other.getRazonSocialAgente()))) &&
            ((this.idCuenta==null && other.getIdCuenta()==null) || 
             (this.idCuenta!=null &&
              this.idCuenta.equals(other.getIdCuenta()))) &&
            ((this.denominacion==null && other.getDenominacion()==null) || 
             (this.denominacion!=null &&
              this.denominacion.equals(other.getDenominacion())));
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
        _hashCode += new Long(getCuitAgente()).hashCode();
        if (getRazonSocialAgente() != null) {
            _hashCode += getRazonSocialAgente().hashCode();
        }
        if (getIdCuenta() != null) {
            _hashCode += getIdCuenta().hashCode();
        }
        if (getDenominacion() != null) {
            _hashCode += getDenominacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CuentaEnAgenteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaEnAgenteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuitAgente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuitAgente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialAgente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razonSocialAgente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominacion"));
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
