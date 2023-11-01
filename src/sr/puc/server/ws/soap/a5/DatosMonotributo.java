/**
 * DatosMonotributo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class DatosMonotributo  implements java.io.Serializable {
    private sr.puc.server.ws.soap.a5.Actividad[] actividad;

    private sr.puc.server.ws.soap.a5.Actividad actividadMonotributista;

    private sr.puc.server.ws.soap.a5.Categoria categoriaMonotributo;

    private sr.puc.server.ws.soap.a5.Relacion[] componenteDeSociedad;

    private sr.puc.server.ws.soap.a5.Impuesto[] impuesto;

    public DatosMonotributo() {
    }

    public DatosMonotributo(
           sr.puc.server.ws.soap.a5.Actividad[] actividad,
           sr.puc.server.ws.soap.a5.Actividad actividadMonotributista,
           sr.puc.server.ws.soap.a5.Categoria categoriaMonotributo,
           sr.puc.server.ws.soap.a5.Relacion[] componenteDeSociedad,
           sr.puc.server.ws.soap.a5.Impuesto[] impuesto) {
           this.actividad = actividad;
           this.actividadMonotributista = actividadMonotributista;
           this.categoriaMonotributo = categoriaMonotributo;
           this.componenteDeSociedad = componenteDeSociedad;
           this.impuesto = impuesto;
    }


    /**
     * Gets the actividad value for this DatosMonotributo.
     * 
     * @return actividad
     */
    public sr.puc.server.ws.soap.a5.Actividad[] getActividad() {
        return actividad;
    }


    /**
     * Sets the actividad value for this DatosMonotributo.
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
     * Gets the actividadMonotributista value for this DatosMonotributo.
     * 
     * @return actividadMonotributista
     */
    public sr.puc.server.ws.soap.a5.Actividad getActividadMonotributista() {
        return actividadMonotributista;
    }


    /**
     * Sets the actividadMonotributista value for this DatosMonotributo.
     * 
     * @param actividadMonotributista
     */
    public void setActividadMonotributista(sr.puc.server.ws.soap.a5.Actividad actividadMonotributista) {
        this.actividadMonotributista = actividadMonotributista;
    }


    /**
     * Gets the categoriaMonotributo value for this DatosMonotributo.
     * 
     * @return categoriaMonotributo
     */
    public sr.puc.server.ws.soap.a5.Categoria getCategoriaMonotributo() {
        return categoriaMonotributo;
    }


    /**
     * Sets the categoriaMonotributo value for this DatosMonotributo.
     * 
     * @param categoriaMonotributo
     */
    public void setCategoriaMonotributo(sr.puc.server.ws.soap.a5.Categoria categoriaMonotributo) {
        this.categoriaMonotributo = categoriaMonotributo;
    }


    /**
     * Gets the componenteDeSociedad value for this DatosMonotributo.
     * 
     * @return componenteDeSociedad
     */
    public sr.puc.server.ws.soap.a5.Relacion[] getComponenteDeSociedad() {
        return componenteDeSociedad;
    }


    /**
     * Sets the componenteDeSociedad value for this DatosMonotributo.
     * 
     * @param componenteDeSociedad
     */
    public void setComponenteDeSociedad(sr.puc.server.ws.soap.a5.Relacion[] componenteDeSociedad) {
        this.componenteDeSociedad = componenteDeSociedad;
    }

    public sr.puc.server.ws.soap.a5.Relacion getComponenteDeSociedad(int i) {
        return this.componenteDeSociedad[i];
    }

    public void setComponenteDeSociedad(int i, sr.puc.server.ws.soap.a5.Relacion _value) {
        this.componenteDeSociedad[i] = _value;
    }


    /**
     * Gets the impuesto value for this DatosMonotributo.
     * 
     * @return impuesto
     */
    public sr.puc.server.ws.soap.a5.Impuesto[] getImpuesto() {
        return impuesto;
    }


    /**
     * Sets the impuesto value for this DatosMonotributo.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosMonotributo)) return false;
        DatosMonotributo other = (DatosMonotributo) obj;
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
            ((this.actividadMonotributista==null && other.getActividadMonotributista()==null) || 
             (this.actividadMonotributista!=null &&
              this.actividadMonotributista.equals(other.getActividadMonotributista()))) &&
            ((this.categoriaMonotributo==null && other.getCategoriaMonotributo()==null) || 
             (this.categoriaMonotributo!=null &&
              this.categoriaMonotributo.equals(other.getCategoriaMonotributo()))) &&
            ((this.componenteDeSociedad==null && other.getComponenteDeSociedad()==null) || 
             (this.componenteDeSociedad!=null &&
              java.util.Arrays.equals(this.componenteDeSociedad, other.getComponenteDeSociedad()))) &&
            ((this.impuesto==null && other.getImpuesto()==null) || 
             (this.impuesto!=null &&
              java.util.Arrays.equals(this.impuesto, other.getImpuesto())));
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
        if (getActividadMonotributista() != null) {
            _hashCode += getActividadMonotributista().hashCode();
        }
        if (getCategoriaMonotributo() != null) {
            _hashCode += getCategoriaMonotributo().hashCode();
        }
        if (getComponenteDeSociedad() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComponenteDeSociedad());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComponenteDeSociedad(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosMonotributo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosMonotributo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "actividad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividadMonotributista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividadMonotributista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "actividad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriaMonotributo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoriaMonotributo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "categoria"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componenteDeSociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "componenteDeSociedad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "relacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "impuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "impuesto"));
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
