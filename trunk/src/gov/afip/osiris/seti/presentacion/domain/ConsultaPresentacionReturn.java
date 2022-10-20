/**
 * ConsultaPresentacionReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.afip.osiris.seti.presentacion.domain;

public class ConsultaPresentacionReturn  implements java.io.Serializable {
    private long contribuyenteCuit;

    private java.lang.String fechaHoraPresentacion;

    private java.lang.String fileName;

    private int formulario;

    private java.lang.String md5;

    private java.lang.Long numeroTransaccion;

    public ConsultaPresentacionReturn() {
    }

    public ConsultaPresentacionReturn(
           long contribuyenteCuit,
           java.lang.String fechaHoraPresentacion,
           java.lang.String fileName,
           int formulario,
           java.lang.String md5,
           java.lang.Long numeroTransaccion) {
           this.contribuyenteCuit = contribuyenteCuit;
           this.fechaHoraPresentacion = fechaHoraPresentacion;
           this.fileName = fileName;
           this.formulario = formulario;
           this.md5 = md5;
           this.numeroTransaccion = numeroTransaccion;
    }


    /**
     * Gets the contribuyenteCuit value for this ConsultaPresentacionReturn.
     * 
     * @return contribuyenteCuit
     */
    public long getContribuyenteCuit() {
        return contribuyenteCuit;
    }


    /**
     * Sets the contribuyenteCuit value for this ConsultaPresentacionReturn.
     * 
     * @param contribuyenteCuit
     */
    public void setContribuyenteCuit(long contribuyenteCuit) {
        this.contribuyenteCuit = contribuyenteCuit;
    }


    /**
     * Gets the fechaHoraPresentacion value for this ConsultaPresentacionReturn.
     * 
     * @return fechaHoraPresentacion
     */
    public java.lang.String getFechaHoraPresentacion() {
        return fechaHoraPresentacion;
    }


    /**
     * Sets the fechaHoraPresentacion value for this ConsultaPresentacionReturn.
     * 
     * @param fechaHoraPresentacion
     */
    public void setFechaHoraPresentacion(java.lang.String fechaHoraPresentacion) {
        this.fechaHoraPresentacion = fechaHoraPresentacion;
    }


    /**
     * Gets the fileName value for this ConsultaPresentacionReturn.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this ConsultaPresentacionReturn.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the formulario value for this ConsultaPresentacionReturn.
     * 
     * @return formulario
     */
    public int getFormulario() {
        return formulario;
    }


    /**
     * Sets the formulario value for this ConsultaPresentacionReturn.
     * 
     * @param formulario
     */
    public void setFormulario(int formulario) {
        this.formulario = formulario;
    }


    /**
     * Gets the md5 value for this ConsultaPresentacionReturn.
     * 
     * @return md5
     */
    public java.lang.String getMd5() {
        return md5;
    }


    /**
     * Sets the md5 value for this ConsultaPresentacionReturn.
     * 
     * @param md5
     */
    public void setMd5(java.lang.String md5) {
        this.md5 = md5;
    }


    /**
     * Gets the numeroTransaccion value for this ConsultaPresentacionReturn.
     * 
     * @return numeroTransaccion
     */
    public java.lang.Long getNumeroTransaccion() {
        return numeroTransaccion;
    }


    /**
     * Sets the numeroTransaccion value for this ConsultaPresentacionReturn.
     * 
     * @param numeroTransaccion
     */
    public void setNumeroTransaccion(java.lang.Long numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaPresentacionReturn)) return false;
        ConsultaPresentacionReturn other = (ConsultaPresentacionReturn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.contribuyenteCuit == other.getContribuyenteCuit() &&
            ((this.fechaHoraPresentacion==null && other.getFechaHoraPresentacion()==null) || 
             (this.fechaHoraPresentacion!=null &&
              this.fechaHoraPresentacion.equals(other.getFechaHoraPresentacion()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            this.formulario == other.getFormulario() &&
            ((this.md5==null && other.getMd5()==null) || 
             (this.md5!=null &&
              this.md5.equals(other.getMd5()))) &&
            ((this.numeroTransaccion==null && other.getNumeroTransaccion()==null) || 
             (this.numeroTransaccion!=null &&
              this.numeroTransaccion.equals(other.getNumeroTransaccion())));
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
        _hashCode += new Long(getContribuyenteCuit()).hashCode();
        if (getFechaHoraPresentacion() != null) {
            _hashCode += getFechaHoraPresentacion().hashCode();
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        _hashCode += getFormulario();
        if (getMd5() != null) {
            _hashCode += getMd5().hashCode();
        }
        if (getNumeroTransaccion() != null) {
            _hashCode += getNumeroTransaccion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaPresentacionReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.presentacion.seti.osiris.afip.gov/", "consultaPresentacionReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contribuyenteCuit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contribuyenteCuit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraPresentacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHoraPresentacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formulario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formulario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("md5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "md5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroTransaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroTransaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
