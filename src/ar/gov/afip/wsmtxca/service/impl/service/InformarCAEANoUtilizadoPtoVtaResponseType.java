/**
 * InformarCAEANoUtilizadoPtoVtaResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class InformarCAEANoUtilizadoPtoVtaResponseType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado;

    private java.util.Date fechaProceso;

    private long CAEA;

    private int numeroPuntoVenta;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento;

    public InformarCAEANoUtilizadoPtoVtaResponseType() {
    }

    public InformarCAEANoUtilizadoPtoVtaResponseType(
           ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado,
           java.util.Date fechaProceso,
           long CAEA,
           int numeroPuntoVenta,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
           this.resultado = resultado;
           this.fechaProceso = fechaProceso;
           this.CAEA = CAEA;
           this.numeroPuntoVenta = numeroPuntoVenta;
           this.arrayErrores = arrayErrores;
           this.evento = evento;
    }


    /**
     * Gets the resultado value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return resultado
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param resultado
     */
    public void setResultado(ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the fechaProceso value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return fechaProceso
     */
    public java.util.Date getFechaProceso() {
        return fechaProceso;
    }


    /**
     * Sets the fechaProceso value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param fechaProceso
     */
    public void setFechaProceso(java.util.Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }


    /**
     * Gets the CAEA value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return CAEA
     */
    public long getCAEA() {
        return CAEA;
    }


    /**
     * Sets the CAEA value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param CAEA
     */
    public void setCAEA(long CAEA) {
        this.CAEA = CAEA;
    }


    /**
     * Gets the numeroPuntoVenta value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the arrayErrores value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return arrayErrores
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the evento value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @return evento
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this InformarCAEANoUtilizadoPtoVtaResponseType.
     * 
     * @param evento
     */
    public void setEvento(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformarCAEANoUtilizadoPtoVtaResponseType)) return false;
        InformarCAEANoUtilizadoPtoVtaResponseType other = (InformarCAEANoUtilizadoPtoVtaResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.fechaProceso==null && other.getFechaProceso()==null) || 
             (this.fechaProceso!=null &&
              this.fechaProceso.equals(other.getFechaProceso()))) &&
            this.CAEA == other.getCAEA() &&
            this.numeroPuntoVenta == other.getNumeroPuntoVenta() &&
            ((this.arrayErrores==null && other.getArrayErrores()==null) || 
             (this.arrayErrores!=null &&
              java.util.Arrays.equals(this.arrayErrores, other.getArrayErrores()))) &&
            ((this.evento==null && other.getEvento()==null) || 
             (this.evento!=null &&
              this.evento.equals(other.getEvento())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getFechaProceso() != null) {
            _hashCode += getFechaProceso().hashCode();
        }
        _hashCode += new Long(getCAEA()).hashCode();
        _hashCode += getNumeroPuntoVenta();
        if (getArrayErrores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayErrores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayErrores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEvento() != null) {
            _hashCode += getEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformarCAEANoUtilizadoPtoVtaResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ResultadoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaProceso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaProceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAEA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CAEA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayErrores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayErrores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
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
