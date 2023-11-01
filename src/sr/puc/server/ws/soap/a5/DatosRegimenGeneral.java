/**
 * DatosRegimenGeneral.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class DatosRegimenGeneral  implements java.io.Serializable {
    private sr.puc.server.ws.soap.a5.Actividad[] actividad;

    private sr.puc.server.ws.soap.a5.Categoria categoriaAutonomo;

    private sr.puc.server.ws.soap.a5.Impuesto[] impuesto;

    private sr.puc.server.ws.soap.a5.Regimen[] regimen;

    public DatosRegimenGeneral() {
    }

    public DatosRegimenGeneral(
           sr.puc.server.ws.soap.a5.Actividad[] actividad,
           sr.puc.server.ws.soap.a5.Categoria categoriaAutonomo,
           sr.puc.server.ws.soap.a5.Impuesto[] impuesto,
           sr.puc.server.ws.soap.a5.Regimen[] regimen) {
           this.actividad = actividad;
           this.categoriaAutonomo = categoriaAutonomo;
           this.impuesto = impuesto;
           this.regimen = regimen;
    }


    /**
     * Gets the actividad value for this DatosRegimenGeneral.
     * 
     * @return actividad
     */
    public sr.puc.server.ws.soap.a5.Actividad[] getActividad() {
        return actividad;
    }


    /**
     * Sets the actividad value for this DatosRegimenGeneral.
     * 
     * @param actividad
     */
    public void setActividad(sr.puc.server.ws.soap.a5.Actividad[] actividad) {
        this.actividad = actividad;
    }

    public sr.puc.server.ws.soap.a5.Actividad getActividad(int i) {
        return this.actividad[i];
    }

    public void setActividad(int i, sr.puc.server.ws.soap.a5.Actividad _value) {
        this.actividad[i] = _value;
    }


    /**
     * Gets the categoriaAutonomo value for this DatosRegimenGeneral.
     * 
     * @return categoriaAutonomo
     */
    public sr.puc.server.ws.soap.a5.Categoria getCategoriaAutonomo() {
        return categoriaAutonomo;
    }


    /**
     * Sets the categoriaAutonomo value for this DatosRegimenGeneral.
     * 
     * @param categoriaAutonomo
     */
    public void setCategoriaAutonomo(sr.puc.server.ws.soap.a5.Categoria categoriaAutonomo) {
        this.categoriaAutonomo = categoriaAutonomo;
    }


    /**
     * Gets the impuesto value for this DatosRegimenGeneral.
     * 
     * @return impuesto
     */
    public sr.puc.server.ws.soap.a5.Impuesto[] getImpuesto() {
        return impuesto;
    }


    /**
     * Sets the impuesto value for this DatosRegimenGeneral.
     * 
     * @param impuesto
     */
    public void setImpuesto(sr.puc.server.ws.soap.a5.Impuesto[] impuesto) {
        this.impuesto = impuesto;
    }

    public sr.puc.server.ws.soap.a5.Impuesto getImpuesto(int i) {
        return this.impuesto[i];
    }

    public void setImpuesto(int i, sr.puc.server.ws.soap.a5.Impuesto _value) {
        this.impuesto[i] = _value;
    }


    /**
     * Gets the regimen value for this DatosRegimenGeneral.
     * 
     * @return regimen
     */
    public sr.puc.server.ws.soap.a5.Regimen[] getRegimen() {
        return regimen;
    }


    /**
     * Sets the regimen value for this DatosRegimenGeneral.
     * 
     * @param regimen
     */
    public void setRegimen(sr.puc.server.ws.soap.a5.Regimen[] regimen) {
        this.regimen = regimen;
    }

    public sr.puc.server.ws.soap.a5.Regimen getRegimen(int i) {
        return this.regimen[i];
    }

    public void setRegimen(int i, sr.puc.server.ws.soap.a5.Regimen _value) {
        this.regimen[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosRegimenGeneral)) return false;
        DatosRegimenGeneral other = (DatosRegimenGeneral) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actividad==null && other.getActividad()==null) || 
             (this.actividad!=null &&
              java.util.Arrays.equals(this.actividad, other.getActividad()))) &&
            ((this.categoriaAutonomo==null && other.getCategoriaAutonomo()==null) || 
             (this.categoriaAutonomo!=null &&
              this.categoriaAutonomo.equals(other.getCategoriaAutonomo()))) &&
            ((this.impuesto==null && other.getImpuesto()==null) || 
             (this.impuesto!=null &&
              java.util.Arrays.equals(this.impuesto, other.getImpuesto()))) &&
            ((this.regimen==null && other.getRegimen()==null) || 
             (this.regimen!=null &&
              java.util.Arrays.equals(this.regimen, other.getRegimen())));
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
        if (getActividad() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActividad());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActividad(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategoriaAutonomo() != null) {
            _hashCode += getCategoriaAutonomo().hashCode();
        }
        if (getImpuesto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImpuesto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImpuesto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRegimen() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegimen());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegimen(), i);
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
        new org.apache.axis.description.TypeDesc(DatosRegimenGeneral.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosRegimenGeneral"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "actividad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriaAutonomo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoriaAutonomo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "categoria"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "impuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "impuesto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regimen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "regimen"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
