/**
 * FiltroFechaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class FiltroFechaType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.TipoFechaSimpleType tipo;

    private java.util.Date desde;

    private java.util.Date hasta;

    public FiltroFechaType() {
    }

    public FiltroFechaType(
           wsfecred.afip.gob.ar.FECredService.TipoFechaSimpleType tipo,
           java.util.Date desde,
           java.util.Date hasta) {
           this.tipo = tipo;
           this.desde = desde;
           this.hasta = hasta;
    }


    /**
     * Gets the tipo value for this FiltroFechaType.
     * 
     * @return tipo
     */
    public wsfecred.afip.gob.ar.FECredService.TipoFechaSimpleType getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this FiltroFechaType.
     * 
     * @param tipo
     */
    public void setTipo(wsfecred.afip.gob.ar.FECredService.TipoFechaSimpleType tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the desde value for this FiltroFechaType.
     * 
     * @return desde
     */
    public java.util.Date getDesde() {
        return desde;
    }


    /**
     * Sets the desde value for this FiltroFechaType.
     * 
     * @param desde
     */
    public void setDesde(java.util.Date desde) {
        this.desde = desde;
    }


    /**
     * Gets the hasta value for this FiltroFechaType.
     * 
     * @return hasta
     */
    public java.util.Date getHasta() {
        return hasta;
    }


    /**
     * Sets the hasta value for this FiltroFechaType.
     * 
     * @param hasta
     */
    public void setHasta(java.util.Date hasta) {
        this.hasta = hasta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroFechaType)) return false;
        FiltroFechaType other = (FiltroFechaType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.desde==null && other.getDesde()==null) || 
             (this.desde!=null &&
              this.desde.equals(other.getDesde()))) &&
            ((this.hasta==null && other.getHasta()==null) || 
             (this.hasta!=null &&
              this.hasta.equals(other.getHasta())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getDesde() != null) {
            _hashCode += getDesde().hashCode();
        }
        if (getHasta() != null) {
            _hashCode += getHasta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroFechaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FiltroFechaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoFechaSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hasta"));
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
