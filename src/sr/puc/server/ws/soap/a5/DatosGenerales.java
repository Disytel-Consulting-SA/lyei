/**
 * DatosGenerales.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class DatosGenerales  implements java.io.Serializable {
    private java.lang.String apellido;

    private sr.puc.server.ws.soap.a5.Caracterizacion[] caracterizacion;

    private sr.puc.server.ws.soap.a5.Dependencia dependencia;

    private sr.puc.server.ws.soap.a5.Domicilio domicilioFiscal;

    private java.lang.String esSucesion;

    private java.lang.String estadoClave;

    private java.util.Calendar fechaContratoSocial;

    private java.util.Calendar fechaFallecimiento;

    private java.lang.Long idPersona;

    private java.lang.Integer mesCierre;

    private java.lang.String nombre;

    private java.lang.String razonSocial;

    private java.lang.String tipoClave;

    private java.lang.String tipoPersona;

    public DatosGenerales() {
    }

    public DatosGenerales(
           java.lang.String apellido,
           sr.puc.server.ws.soap.a5.Caracterizacion[] caracterizacion,
           sr.puc.server.ws.soap.a5.Dependencia dependencia,
           sr.puc.server.ws.soap.a5.Domicilio domicilioFiscal,
           java.lang.String esSucesion,
           java.lang.String estadoClave,
           java.util.Calendar fechaContratoSocial,
           java.util.Calendar fechaFallecimiento,
           java.lang.Long idPersona,
           java.lang.Integer mesCierre,
           java.lang.String nombre,
           java.lang.String razonSocial,
           java.lang.String tipoClave,
           java.lang.String tipoPersona) {
           this.apellido = apellido;
           this.caracterizacion = caracterizacion;
           this.dependencia = dependencia;
           this.domicilioFiscal = domicilioFiscal;
           this.esSucesion = esSucesion;
           this.estadoClave = estadoClave;
           this.fechaContratoSocial = fechaContratoSocial;
           this.fechaFallecimiento = fechaFallecimiento;
           this.idPersona = idPersona;
           this.mesCierre = mesCierre;
           this.nombre = nombre;
           this.razonSocial = razonSocial;
           this.tipoClave = tipoClave;
           this.tipoPersona = tipoPersona;
    }


    /**
     * Gets the apellido value for this DatosGenerales.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this DatosGenerales.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the caracterizacion value for this DatosGenerales.
     * 
     * @return caracterizacion
     */
    public sr.puc.server.ws.soap.a5.Caracterizacion[] getCaracterizacion() {
        return caracterizacion;
    }


    /**
     * Sets the caracterizacion value for this DatosGenerales.
     * 
     * @param caracterizacion
     */
    public void setCaracterizacion(sr.puc.server.ws.soap.a5.Caracterizacion[] caracterizacion) {
        this.caracterizacion = caracterizacion;
    }

    public sr.puc.server.ws.soap.a5.Caracterizacion getCaracterizacion(int i) {
        return this.caracterizacion[i];
    }

    public void setCaracterizacion(int i, sr.puc.server.ws.soap.a5.Caracterizacion _value) {
        this.caracterizacion[i] = _value;
    }


    /**
     * Gets the dependencia value for this DatosGenerales.
     * 
     * @return dependencia
     */
    public sr.puc.server.ws.soap.a5.Dependencia getDependencia() {
        return dependencia;
    }


    /**
     * Sets the dependencia value for this DatosGenerales.
     * 
     * @param dependencia
     */
    public void setDependencia(sr.puc.server.ws.soap.a5.Dependencia dependencia) {
        this.dependencia = dependencia;
    }


    /**
     * Gets the domicilioFiscal value for this DatosGenerales.
     * 
     * @return domicilioFiscal
     */
    public sr.puc.server.ws.soap.a5.Domicilio getDomicilioFiscal() {
        return domicilioFiscal;
    }


    /**
     * Sets the domicilioFiscal value for this DatosGenerales.
     * 
     * @param domicilioFiscal
     */
    public void setDomicilioFiscal(sr.puc.server.ws.soap.a5.Domicilio domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }


    /**
     * Gets the esSucesion value for this DatosGenerales.
     * 
     * @return esSucesion
     */
    public java.lang.String getEsSucesion() {
        return esSucesion;
    }


    /**
     * Sets the esSucesion value for this DatosGenerales.
     * 
     * @param esSucesion
     */
    public void setEsSucesion(java.lang.String esSucesion) {
        this.esSucesion = esSucesion;
    }


    /**
     * Gets the estadoClave value for this DatosGenerales.
     * 
     * @return estadoClave
     */
    public java.lang.String getEstadoClave() {
        return estadoClave;
    }


    /**
     * Sets the estadoClave value for this DatosGenerales.
     * 
     * @param estadoClave
     */
    public void setEstadoClave(java.lang.String estadoClave) {
        this.estadoClave = estadoClave;
    }


    /**
     * Gets the fechaContratoSocial value for this DatosGenerales.
     * 
     * @return fechaContratoSocial
     */
    public java.util.Calendar getFechaContratoSocial() {
        return fechaContratoSocial;
    }


    /**
     * Sets the fechaContratoSocial value for this DatosGenerales.
     * 
     * @param fechaContratoSocial
     */
    public void setFechaContratoSocial(java.util.Calendar fechaContratoSocial) {
        this.fechaContratoSocial = fechaContratoSocial;
    }


    /**
     * Gets the fechaFallecimiento value for this DatosGenerales.
     * 
     * @return fechaFallecimiento
     */
    public java.util.Calendar getFechaFallecimiento() {
        return fechaFallecimiento;
    }


    /**
     * Sets the fechaFallecimiento value for this DatosGenerales.
     * 
     * @param fechaFallecimiento
     */
    public void setFechaFallecimiento(java.util.Calendar fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }


    /**
     * Gets the idPersona value for this DatosGenerales.
     * 
     * @return idPersona
     */
    public java.lang.Long getIdPersona() {
        return idPersona;
    }


    /**
     * Sets the idPersona value for this DatosGenerales.
     * 
     * @param idPersona
     */
    public void setIdPersona(java.lang.Long idPersona) {
        this.idPersona = idPersona;
    }


    /**
     * Gets the mesCierre value for this DatosGenerales.
     * 
     * @return mesCierre
     */
    public java.lang.Integer getMesCierre() {
        return mesCierre;
    }


    /**
     * Sets the mesCierre value for this DatosGenerales.
     * 
     * @param mesCierre
     */
    public void setMesCierre(java.lang.Integer mesCierre) {
        this.mesCierre = mesCierre;
    }


    /**
     * Gets the nombre value for this DatosGenerales.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DatosGenerales.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the razonSocial value for this DatosGenerales.
     * 
     * @return razonSocial
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }


    /**
     * Sets the razonSocial value for this DatosGenerales.
     * 
     * @param razonSocial
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }


    /**
     * Gets the tipoClave value for this DatosGenerales.
     * 
     * @return tipoClave
     */
    public java.lang.String getTipoClave() {
        return tipoClave;
    }


    /**
     * Sets the tipoClave value for this DatosGenerales.
     * 
     * @param tipoClave
     */
    public void setTipoClave(java.lang.String tipoClave) {
        this.tipoClave = tipoClave;
    }


    /**
     * Gets the tipoPersona value for this DatosGenerales.
     * 
     * @return tipoPersona
     */
    public java.lang.String getTipoPersona() {
        return tipoPersona;
    }


    /**
     * Sets the tipoPersona value for this DatosGenerales.
     * 
     * @param tipoPersona
     */
    public void setTipoPersona(java.lang.String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosGenerales)) return false;
        DatosGenerales other = (DatosGenerales) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.caracterizacion==null && other.getCaracterizacion()==null) || 
             (this.caracterizacion!=null &&
              java.util.Arrays.equals(this.caracterizacion, other.getCaracterizacion()))) &&
            ((this.dependencia==null && other.getDependencia()==null) || 
             (this.dependencia!=null &&
              this.dependencia.equals(other.getDependencia()))) &&
            ((this.domicilioFiscal==null && other.getDomicilioFiscal()==null) || 
             (this.domicilioFiscal!=null &&
              this.domicilioFiscal.equals(other.getDomicilioFiscal()))) &&
            ((this.esSucesion==null && other.getEsSucesion()==null) || 
             (this.esSucesion!=null &&
              this.esSucesion.equals(other.getEsSucesion()))) &&
            ((this.estadoClave==null && other.getEstadoClave()==null) || 
             (this.estadoClave!=null &&
              this.estadoClave.equals(other.getEstadoClave()))) &&
            ((this.fechaContratoSocial==null && other.getFechaContratoSocial()==null) || 
             (this.fechaContratoSocial!=null &&
              this.fechaContratoSocial.equals(other.getFechaContratoSocial()))) &&
            ((this.fechaFallecimiento==null && other.getFechaFallecimiento()==null) || 
             (this.fechaFallecimiento!=null &&
              this.fechaFallecimiento.equals(other.getFechaFallecimiento()))) &&
            ((this.idPersona==null && other.getIdPersona()==null) || 
             (this.idPersona!=null &&
              this.idPersona.equals(other.getIdPersona()))) &&
            ((this.mesCierre==null && other.getMesCierre()==null) || 
             (this.mesCierre!=null &&
              this.mesCierre.equals(other.getMesCierre()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.razonSocial==null && other.getRazonSocial()==null) || 
             (this.razonSocial!=null &&
              this.razonSocial.equals(other.getRazonSocial()))) &&
            ((this.tipoClave==null && other.getTipoClave()==null) || 
             (this.tipoClave!=null &&
              this.tipoClave.equals(other.getTipoClave()))) &&
            ((this.tipoPersona==null && other.getTipoPersona()==null) || 
             (this.tipoPersona!=null &&
              this.tipoPersona.equals(other.getTipoPersona())));
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
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getCaracterizacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCaracterizacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCaracterizacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDependencia() != null) {
            _hashCode += getDependencia().hashCode();
        }
        if (getDomicilioFiscal() != null) {
            _hashCode += getDomicilioFiscal().hashCode();
        }
        if (getEsSucesion() != null) {
            _hashCode += getEsSucesion().hashCode();
        }
        if (getEstadoClave() != null) {
            _hashCode += getEstadoClave().hashCode();
        }
        if (getFechaContratoSocial() != null) {
            _hashCode += getFechaContratoSocial().hashCode();
        }
        if (getFechaFallecimiento() != null) {
            _hashCode += getFechaFallecimiento().hashCode();
        }
        if (getIdPersona() != null) {
            _hashCode += getIdPersona().hashCode();
        }
        if (getMesCierre() != null) {
            _hashCode += getMesCierre().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getRazonSocial() != null) {
            _hashCode += getRazonSocial().hashCode();
        }
        if (getTipoClave() != null) {
            _hashCode += getTipoClave().hashCode();
        }
        if (getTipoPersona() != null) {
            _hashCode += getTipoPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosGenerales.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosGenerales"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caracterizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caracterizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "caracterizacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dependencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dependencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "dependencia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domicilioFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "domicilio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esSucesion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "esSucesion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoClave");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadoClave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaContratoSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaContratoSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFallecimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaFallecimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesCierre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesCierre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razonSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoClave");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoClave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoPersona"));
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
