/**
 * InfoSCAType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class InfoSCAType  implements java.io.Serializable {
    private java.util.Date fechaAceptacionFactura;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBUReceptor;

    private java.lang.String CBUReceptor;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType CBUValidada;

    private java.util.Calendar fechaLecturaSCA;

    public InfoSCAType() {
    }

    public InfoSCAType(
           java.util.Date fechaAceptacionFactura,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBUReceptor,
           java.lang.String CBUReceptor,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType CBUValidada,
           java.util.Calendar fechaLecturaSCA) {
           this.fechaAceptacionFactura = fechaAceptacionFactura;
           this.informaCBUReceptor = informaCBUReceptor;
           this.CBUReceptor = CBUReceptor;
           this.CBUValidada = CBUValidada;
           this.fechaLecturaSCA = fechaLecturaSCA;
    }


    /**
     * Gets the fechaAceptacionFactura value for this InfoSCAType.
     * 
     * @return fechaAceptacionFactura
     */
    public java.util.Date getFechaAceptacionFactura() {
        return fechaAceptacionFactura;
    }


    /**
     * Sets the fechaAceptacionFactura value for this InfoSCAType.
     * 
     * @param fechaAceptacionFactura
     */
    public void setFechaAceptacionFactura(java.util.Date fechaAceptacionFactura) {
        this.fechaAceptacionFactura = fechaAceptacionFactura;
    }


    /**
     * Gets the informaCBUReceptor value for this InfoSCAType.
     * 
     * @return informaCBUReceptor
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getInformaCBUReceptor() {
        return informaCBUReceptor;
    }


    /**
     * Sets the informaCBUReceptor value for this InfoSCAType.
     * 
     * @param informaCBUReceptor
     */
    public void setInformaCBUReceptor(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBUReceptor) {
        this.informaCBUReceptor = informaCBUReceptor;
    }


    /**
     * Gets the CBUReceptor value for this InfoSCAType.
     * 
     * @return CBUReceptor
     */
    public java.lang.String getCBUReceptor() {
        return CBUReceptor;
    }


    /**
     * Sets the CBUReceptor value for this InfoSCAType.
     * 
     * @param CBUReceptor
     */
    public void setCBUReceptor(java.lang.String CBUReceptor) {
        this.CBUReceptor = CBUReceptor;
    }


    /**
     * Gets the CBUValidada value for this InfoSCAType.
     * 
     * @return CBUValidada
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getCBUValidada() {
        return CBUValidada;
    }


    /**
     * Sets the CBUValidada value for this InfoSCAType.
     * 
     * @param CBUValidada
     */
    public void setCBUValidada(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType CBUValidada) {
        this.CBUValidada = CBUValidada;
    }


    /**
     * Gets the fechaLecturaSCA value for this InfoSCAType.
     * 
     * @return fechaLecturaSCA
     */
    public java.util.Calendar getFechaLecturaSCA() {
        return fechaLecturaSCA;
    }


    /**
     * Sets the fechaLecturaSCA value for this InfoSCAType.
     * 
     * @param fechaLecturaSCA
     */
    public void setFechaLecturaSCA(java.util.Calendar fechaLecturaSCA) {
        this.fechaLecturaSCA = fechaLecturaSCA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoSCAType)) return false;
        InfoSCAType other = (InfoSCAType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaAceptacionFactura==null && other.getFechaAceptacionFactura()==null) || 
             (this.fechaAceptacionFactura!=null &&
              this.fechaAceptacionFactura.equals(other.getFechaAceptacionFactura()))) &&
            ((this.informaCBUReceptor==null && other.getInformaCBUReceptor()==null) || 
             (this.informaCBUReceptor!=null &&
              this.informaCBUReceptor.equals(other.getInformaCBUReceptor()))) &&
            ((this.CBUReceptor==null && other.getCBUReceptor()==null) || 
             (this.CBUReceptor!=null &&
              this.CBUReceptor.equals(other.getCBUReceptor()))) &&
            ((this.CBUValidada==null && other.getCBUValidada()==null) || 
             (this.CBUValidada!=null &&
              this.CBUValidada.equals(other.getCBUValidada()))) &&
            ((this.fechaLecturaSCA==null && other.getFechaLecturaSCA()==null) || 
             (this.fechaLecturaSCA!=null &&
              this.fechaLecturaSCA.equals(other.getFechaLecturaSCA())));
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
        if (getFechaAceptacionFactura() != null) {
            _hashCode += getFechaAceptacionFactura().hashCode();
        }
        if (getInformaCBUReceptor() != null) {
            _hashCode += getInformaCBUReceptor().hashCode();
        }
        if (getCBUReceptor() != null) {
            _hashCode += getCBUReceptor().hashCode();
        }
        if (getCBUValidada() != null) {
            _hashCode += getCBUValidada().hashCode();
        }
        if (getFechaLecturaSCA() != null) {
            _hashCode += getFechaLecturaSCA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoSCAType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoSCAType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAceptacionFactura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaAceptacionFactura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informaCBUReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "informaCBUReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBUReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CBUReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBUValidada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CBUValidada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaLecturaSCA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaLecturaSCA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
