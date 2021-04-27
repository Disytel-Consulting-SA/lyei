/**
 * ComprobanteCAEResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ComprobanteCAEResponseType  implements java.io.Serializable {
    private long cuit;

    private short codigoTipoComprobante;

    private int numeroPuntoVenta;

    private long numeroComprobante;

    private java.util.Date fechaEmision;

    private long CAE;

    private java.util.Date fechaVencimientoCAE;

    public ComprobanteCAEResponseType() {
    }

    public ComprobanteCAEResponseType(
           long cuit,
           short codigoTipoComprobante,
           int numeroPuntoVenta,
           long numeroComprobante,
           java.util.Date fechaEmision,
           long CAE,
           java.util.Date fechaVencimientoCAE) {
           this.cuit = cuit;
           this.codigoTipoComprobante = codigoTipoComprobante;
           this.numeroPuntoVenta = numeroPuntoVenta;
           this.numeroComprobante = numeroComprobante;
           this.fechaEmision = fechaEmision;
           this.CAE = CAE;
           this.fechaVencimientoCAE = fechaVencimientoCAE;
    }


    /**
     * Gets the cuit value for this ComprobanteCAEResponseType.
     * 
     * @return cuit
     */
    public long getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this ComprobanteCAEResponseType.
     * 
     * @param cuit
     */
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }


    /**
     * Gets the codigoTipoComprobante value for this ComprobanteCAEResponseType.
     * 
     * @return codigoTipoComprobante
     */
    public short getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }


    /**
     * Sets the codigoTipoComprobante value for this ComprobanteCAEResponseType.
     * 
     * @param codigoTipoComprobante
     */
    public void setCodigoTipoComprobante(short codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }


    /**
     * Gets the numeroPuntoVenta value for this ComprobanteCAEResponseType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this ComprobanteCAEResponseType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the numeroComprobante value for this ComprobanteCAEResponseType.
     * 
     * @return numeroComprobante
     */
    public long getNumeroComprobante() {
        return numeroComprobante;
    }


    /**
     * Sets the numeroComprobante value for this ComprobanteCAEResponseType.
     * 
     * @param numeroComprobante
     */
    public void setNumeroComprobante(long numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }


    /**
     * Gets the fechaEmision value for this ComprobanteCAEResponseType.
     * 
     * @return fechaEmision
     */
    public java.util.Date getFechaEmision() {
        return fechaEmision;
    }


    /**
     * Sets the fechaEmision value for this ComprobanteCAEResponseType.
     * 
     * @param fechaEmision
     */
    public void setFechaEmision(java.util.Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }


    /**
     * Gets the CAE value for this ComprobanteCAEResponseType.
     * 
     * @return CAE
     */
    public long getCAE() {
        return CAE;
    }


    /**
     * Sets the CAE value for this ComprobanteCAEResponseType.
     * 
     * @param CAE
     */
    public void setCAE(long CAE) {
        this.CAE = CAE;
    }


    /**
     * Gets the fechaVencimientoCAE value for this ComprobanteCAEResponseType.
     * 
     * @return fechaVencimientoCAE
     */
    public java.util.Date getFechaVencimientoCAE() {
        return fechaVencimientoCAE;
    }


    /**
     * Sets the fechaVencimientoCAE value for this ComprobanteCAEResponseType.
     * 
     * @param fechaVencimientoCAE
     */
    public void setFechaVencimientoCAE(java.util.Date fechaVencimientoCAE) {
        this.fechaVencimientoCAE = fechaVencimientoCAE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComprobanteCAEResponseType)) return false;
        ComprobanteCAEResponseType other = (ComprobanteCAEResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cuit == other.getCuit() &&
            this.codigoTipoComprobante == other.getCodigoTipoComprobante() &&
            this.numeroPuntoVenta == other.getNumeroPuntoVenta() &&
            this.numeroComprobante == other.getNumeroComprobante() &&
            ((this.fechaEmision==null && other.getFechaEmision()==null) || 
             (this.fechaEmision!=null &&
              this.fechaEmision.equals(other.getFechaEmision()))) &&
            this.CAE == other.getCAE() &&
            ((this.fechaVencimientoCAE==null && other.getFechaVencimientoCAE()==null) || 
             (this.fechaVencimientoCAE!=null &&
              this.fechaVencimientoCAE.equals(other.getFechaVencimientoCAE())));
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
        _hashCode += new Long(getCuit()).hashCode();
        _hashCode += getCodigoTipoComprobante();
        _hashCode += getNumeroPuntoVenta();
        _hashCode += new Long(getNumeroComprobante()).hashCode();
        if (getFechaEmision() != null) {
            _hashCode += getFechaEmision().hashCode();
        }
        _hashCode += new Long(getCAE()).hashCode();
        if (getFechaVencimientoCAE() != null) {
            _hashCode += getFechaVencimientoCAE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComprobanteCAEResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoTipoComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEmision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaEmision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CAE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVencimientoCAE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVencimientoCAE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
