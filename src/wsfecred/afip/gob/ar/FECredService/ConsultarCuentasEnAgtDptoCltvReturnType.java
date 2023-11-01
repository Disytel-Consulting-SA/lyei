/**
 * ConsultarCuentasEnAgtDptoCltvReturnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarCuentasEnAgtDptoCltvReturnType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType[] arrayCuentasEnAgente;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservacion;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato;

    public ConsultarCuentasEnAgtDptoCltvReturnType() {
    }

    public ConsultarCuentasEnAgtDptoCltvReturnType(
           wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType[] arrayCuentasEnAgente,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservacion,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
           this.arrayCuentasEnAgente = arrayCuentasEnAgente;
           this.arrayObservacion = arrayObservacion;
           this.arrayErrores = arrayErrores;
           this.arrayErroresFormato = arrayErroresFormato;
    }


    /**
     * Gets the arrayCuentasEnAgente value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @return arrayCuentasEnAgente
     */
    public wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType[] getArrayCuentasEnAgente() {
        return arrayCuentasEnAgente;
    }


    /**
     * Sets the arrayCuentasEnAgente value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @param arrayCuentasEnAgente
     */
    public void setArrayCuentasEnAgente(wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType[] arrayCuentasEnAgente) {
        this.arrayCuentasEnAgente = arrayCuentasEnAgente;
    }


    /**
     * Gets the arrayObservacion value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @return arrayObservacion
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayObservacion() {
        return arrayObservacion;
    }


    /**
     * Sets the arrayObservacion value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @param arrayObservacion
     */
    public void setArrayObservacion(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservacion) {
        this.arrayObservacion = arrayObservacion;
    }


    /**
     * Gets the arrayErrores value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @return arrayErrores
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the arrayErroresFormato value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @return arrayErroresFormato
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] getArrayErroresFormato() {
        return arrayErroresFormato;
    }


    /**
     * Sets the arrayErroresFormato value for this ConsultarCuentasEnAgtDptoCltvReturnType.
     * 
     * @param arrayErroresFormato
     */
    public void setArrayErroresFormato(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
        this.arrayErroresFormato = arrayErroresFormato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCuentasEnAgtDptoCltvReturnType)) return false;
        ConsultarCuentasEnAgtDptoCltvReturnType other = (ConsultarCuentasEnAgtDptoCltvReturnType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayCuentasEnAgente==null && other.getArrayCuentasEnAgente()==null) || 
             (this.arrayCuentasEnAgente!=null &&
              java.util.Arrays.equals(this.arrayCuentasEnAgente, other.getArrayCuentasEnAgente()))) &&
            ((this.arrayObservacion==null && other.getArrayObservacion()==null) || 
             (this.arrayObservacion!=null &&
              java.util.Arrays.equals(this.arrayObservacion, other.getArrayObservacion()))) &&
            ((this.arrayErrores==null && other.getArrayErrores()==null) || 
             (this.arrayErrores!=null &&
              java.util.Arrays.equals(this.arrayErrores, other.getArrayErrores()))) &&
            ((this.arrayErroresFormato==null && other.getArrayErroresFormato()==null) || 
             (this.arrayErroresFormato!=null &&
              java.util.Arrays.equals(this.arrayErroresFormato, other.getArrayErroresFormato())));
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
        if (getArrayCuentasEnAgente() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayCuentasEnAgente());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayCuentasEnAgente(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayObservacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayObservacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayObservacion(), i);
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
        if (getArrayErroresFormato() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayErroresFormato());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayErroresFormato(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarCuentasEnAgtDptoCltvReturnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCuentasEnAgtDptoCltvReturnType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayCuentasEnAgente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayCuentasEnAgente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaEnAgenteType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "cuentaEnAgente"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayObservacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayObservacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayErrores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayErrores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayErroresFormato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayErroresFormato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionStringType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcionString"));
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
