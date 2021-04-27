/**
 * InformarAjusteIVACAEAResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class InformarAjusteIVACAEAResponseType  implements java.io.Serializable {
    private ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado;

    private java.util.Date fechaProceso;

    private ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEAResponseType comprobanteCAEAResponse;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento;

    public InformarAjusteIVACAEAResponseType() {
    }

    public InformarAjusteIVACAEAResponseType(
           ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado,
           java.util.Date fechaProceso,
           ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEAResponseType comprobanteCAEAResponse,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
           this.resultado = resultado;
           this.fechaProceso = fechaProceso;
           this.comprobanteCAEAResponse = comprobanteCAEAResponse;
           this.arrayObservaciones = arrayObservaciones;
           this.arrayErrores = arrayErrores;
           this.evento = evento;
    }


    /**
     * Gets the resultado value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return resultado
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param resultado
     */
    public void setResultado(ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the fechaProceso value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return fechaProceso
     */
    public java.util.Date getFechaProceso() {
        return fechaProceso;
    }


    /**
     * Sets the fechaProceso value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param fechaProceso
     */
    public void setFechaProceso(java.util.Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }


    /**
     * Gets the comprobanteCAEAResponse value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return comprobanteCAEAResponse
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEAResponseType getComprobanteCAEAResponse() {
        return comprobanteCAEAResponse;
    }


    /**
     * Sets the comprobanteCAEAResponse value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param comprobanteCAEAResponse
     */
    public void setComprobanteCAEAResponse(ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEAResponseType comprobanteCAEAResponse) {
        this.comprobanteCAEAResponse = comprobanteCAEAResponse;
    }


    /**
     * Gets the arrayObservaciones value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return arrayObservaciones
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] getArrayObservaciones() {
        return arrayObservaciones;
    }


    /**
     * Sets the arrayObservaciones value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param arrayObservaciones
     */
    public void setArrayObservaciones(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayObservaciones) {
        this.arrayObservaciones = arrayObservaciones;
    }


    /**
     * Gets the arrayErrores value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return arrayErrores
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the evento value for this InformarAjusteIVACAEAResponseType.
     * 
     * @return evento
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this InformarAjusteIVACAEAResponseType.
     * 
     * @param evento
     */
    public void setEvento(ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformarAjusteIVACAEAResponseType)) return false;
        InformarAjusteIVACAEAResponseType other = (InformarAjusteIVACAEAResponseType) obj;
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
            ((this.comprobanteCAEAResponse==null && other.getComprobanteCAEAResponse()==null) || 
             (this.comprobanteCAEAResponse!=null &&
              this.comprobanteCAEAResponse.equals(other.getComprobanteCAEAResponse()))) &&
            ((this.arrayObservaciones==null && other.getArrayObservaciones()==null) || 
             (this.arrayObservaciones!=null &&
              java.util.Arrays.equals(this.arrayObservaciones, other.getArrayObservaciones()))) &&
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
        if (getComprobanteCAEAResponse() != null) {
            _hashCode += getComprobanteCAEAResponse().hashCode();
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
        new org.apache.axis.description.TypeDesc(InformarAjusteIVACAEAResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarAjusteIVACAEAResponseType"));
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
        elemField.setFieldName("comprobanteCAEAResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobanteCAEAResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEAResponseType"));
        elemField.setMinOccurs(0);
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
