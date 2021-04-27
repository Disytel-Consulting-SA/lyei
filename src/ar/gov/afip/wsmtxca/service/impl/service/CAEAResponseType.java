/**
 * CAEAResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class CAEAResponseType  implements java.io.Serializable {
    private java.util.Date fechaProceso;

    private long CAEA;

    private int periodo;

    private short orden;

    private java.util.Date fechaDesde;

    private java.util.Date fechaHasta;

    private java.util.Date fechaTopeInforme;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones;

    public CAEAResponseType() {
    }

    public CAEAResponseType(
           java.util.Date fechaProceso,
           long CAEA,
           int periodo,
           short orden,
           java.util.Date fechaDesde,
           java.util.Date fechaHasta,
           java.util.Date fechaTopeInforme,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones) {
           this.fechaProceso = fechaProceso;
           this.CAEA = CAEA;
           this.periodo = periodo;
           this.orden = orden;
           this.fechaDesde = fechaDesde;
           this.fechaHasta = fechaHasta;
           this.fechaTopeInforme = fechaTopeInforme;
           this.arrayObservaciones = arrayObservaciones;
    }


    /**
     * Gets the fechaProceso value for this CAEAResponseType.
     * 
     * @return fechaProceso
     */
    public java.util.Date getFechaProceso() {
        return fechaProceso;
    }


    /**
     * Sets the fechaProceso value for this CAEAResponseType.
     * 
     * @param fechaProceso
     */
    public void setFechaProceso(java.util.Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }


    /**
     * Gets the CAEA value for this CAEAResponseType.
     * 
     * @return CAEA
     */
    public long getCAEA() {
        return CAEA;
    }


    /**
     * Sets the CAEA value for this CAEAResponseType.
     * 
     * @param CAEA
     */
    public void setCAEA(long CAEA) {
        this.CAEA = CAEA;
    }


    /**
     * Gets the periodo value for this CAEAResponseType.
     * 
     * @return periodo
     */
    public int getPeriodo() {
        return periodo;
    }


    /**
     * Sets the periodo value for this CAEAResponseType.
     * 
     * @param periodo
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }


    /**
     * Gets the orden value for this CAEAResponseType.
     * 
     * @return orden
     */
    public short getOrden() {
        return orden;
    }


    /**
     * Sets the orden value for this CAEAResponseType.
     * 
     * @param orden
     */
    public void setOrden(short orden) {
        this.orden = orden;
    }


    /**
     * Gets the fechaDesde value for this CAEAResponseType.
     * 
     * @return fechaDesde
     */
    public java.util.Date getFechaDesde() {
        return fechaDesde;
    }


    /**
     * Sets the fechaDesde value for this CAEAResponseType.
     * 
     * @param fechaDesde
     */
    public void setFechaDesde(java.util.Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    /**
     * Gets the fechaHasta value for this CAEAResponseType.
     * 
     * @return fechaHasta
     */
    public java.util.Date getFechaHasta() {
        return fechaHasta;
    }


    /**
     * Sets the fechaHasta value for this CAEAResponseType.
     * 
     * @param fechaHasta
     */
    public void setFechaHasta(java.util.Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    /**
     * Gets the fechaTopeInforme value for this CAEAResponseType.
     * 
     * @return fechaTopeInforme
     */
    public java.util.Date getFechaTopeInforme() {
        return fechaTopeInforme;
    }


    /**
     * Sets the fechaTopeInforme value for this CAEAResponseType.
     * 
     * @param fechaTopeInforme
     */
    public void setFechaTopeInforme(java.util.Date fechaTopeInforme) {
        this.fechaTopeInforme = fechaTopeInforme;
    }


    /**
     * Gets the arrayObservaciones value for this CAEAResponseType.
     * 
     * @return arrayObservaciones
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] getArrayObservaciones() {
        return arrayObservaciones;
    }


    /**
     * Sets the arrayObservaciones value for this CAEAResponseType.
     * 
     * @param arrayObservaciones
     */
    public void setArrayObservaciones(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones) {
        this.arrayObservaciones = arrayObservaciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CAEAResponseType)) return false;
        CAEAResponseType other = (CAEAResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaProceso==null && other.getFechaProceso()==null) || 
             (this.fechaProceso!=null &&
              this.fechaProceso.equals(other.getFechaProceso()))) &&
            this.CAEA == other.getCAEA() &&
            this.periodo == other.getPeriodo() &&
            this.orden == other.getOrden() &&
            ((this.fechaDesde==null && other.getFechaDesde()==null) || 
             (this.fechaDesde!=null &&
              this.fechaDesde.equals(other.getFechaDesde()))) &&
            ((this.fechaHasta==null && other.getFechaHasta()==null) || 
             (this.fechaHasta!=null &&
              this.fechaHasta.equals(other.getFechaHasta()))) &&
            ((this.fechaTopeInforme==null && other.getFechaTopeInforme()==null) || 
             (this.fechaTopeInforme!=null &&
              this.fechaTopeInforme.equals(other.getFechaTopeInforme()))) &&
            ((this.arrayObservaciones==null && other.getArrayObservaciones()==null) || 
             (this.arrayObservaciones!=null &&
              java.util.Arrays.equals(this.arrayObservaciones, other.getArrayObservaciones())));
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
        if (getFechaProceso() != null) {
            _hashCode += getFechaProceso().hashCode();
        }
        _hashCode += new Long(getCAEA()).hashCode();
        _hashCode += getPeriodo();
        _hashCode += getOrden();
        if (getFechaDesde() != null) {
            _hashCode += getFechaDesde().hashCode();
        }
        if (getFechaHasta() != null) {
            _hashCode += getFechaHasta().hashCode();
        }
        if (getFechaTopeInforme() != null) {
            _hashCode += getFechaTopeInforme().hashCode();
        }
        if (getArrayObservaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayObservaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayObservaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CAEAResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CAEAResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("periodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orden");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTopeInforme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaTopeInforme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayObservaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayObservaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
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
