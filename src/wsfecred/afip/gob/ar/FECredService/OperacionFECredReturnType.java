/**
 * OperacionFECredReturnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class OperacionFECredReturnType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ResultadoSimpleType resultado;

    private wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato;

    public OperacionFECredReturnType() {
    }

    public OperacionFECredReturnType(
           wsfecred.afip.gob.ar.FECredService.ResultadoSimpleType resultado,
           wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
           this.resultado = resultado;
           this.idCtaCte = idCtaCte;
           this.evento = evento;
           this.arrayObservaciones = arrayObservaciones;
           this.arrayErrores = arrayErrores;
           this.arrayErroresFormato = arrayErroresFormato;
    }


    /**
     * Gets the resultado value for this OperacionFECredReturnType.
     * 
     * @return resultado
     */
    public wsfecred.afip.gob.ar.FECredService.ResultadoSimpleType getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this OperacionFECredReturnType.
     * 
     * @param resultado
     */
    public void setResultado(wsfecred.afip.gob.ar.FECredService.ResultadoSimpleType resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the idCtaCte value for this OperacionFECredReturnType.
     * 
     * @return idCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.IdCtaCteType getIdCtaCte() {
        return idCtaCte;
    }


    /**
     * Sets the idCtaCte value for this OperacionFECredReturnType.
     * 
     * @param idCtaCte
     */
    public void setIdCtaCte(wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte) {
        this.idCtaCte = idCtaCte;
    }


    /**
     * Gets the evento value for this OperacionFECredReturnType.
     * 
     * @return evento
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this OperacionFECredReturnType.
     * 
     * @param evento
     */
    public void setEvento(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento) {
        this.evento = evento;
    }


    /**
     * Gets the arrayObservaciones value for this OperacionFECredReturnType.
     * 
     * @return arrayObservaciones
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayObservaciones() {
        return arrayObservaciones;
    }


    /**
     * Sets the arrayObservaciones value for this OperacionFECredReturnType.
     * 
     * @param arrayObservaciones
     */
    public void setArrayObservaciones(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones) {
        this.arrayObservaciones = arrayObservaciones;
    }


    /**
     * Gets the arrayErrores value for this OperacionFECredReturnType.
     * 
     * @return arrayErrores
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this OperacionFECredReturnType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the arrayErroresFormato value for this OperacionFECredReturnType.
     * 
     * @return arrayErroresFormato
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] getArrayErroresFormato() {
        return arrayErroresFormato;
    }


    /**
     * Sets the arrayErroresFormato value for this OperacionFECredReturnType.
     * 
     * @param arrayErroresFormato
     */
    public void setArrayErroresFormato(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
        this.arrayErroresFormato = arrayErroresFormato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperacionFECredReturnType)) return false;
        OperacionFECredReturnType other = (OperacionFECredReturnType) obj;
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
            ((this.idCtaCte==null && other.getIdCtaCte()==null) || 
             (this.idCtaCte!=null &&
              this.idCtaCte.equals(other.getIdCtaCte()))) &&
            ((this.evento==null && other.getEvento()==null) || 
             (this.evento!=null &&
              this.evento.equals(other.getEvento()))) &&
            ((this.arrayObservaciones==null && other.getArrayObservaciones()==null) || 
             (this.arrayObservaciones!=null &&
              java.util.Arrays.equals(this.arrayObservaciones, other.getArrayObservaciones()))) &&
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getIdCtaCte() != null) {
            _hashCode += getIdCtaCte().hashCode();
        }
        if (getEvento() != null) {
            _hashCode += getEvento().hashCode();
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
        new org.apache.axis.description.TypeDesc(OperacionFECredReturnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredReturnType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ResultadoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCtaCte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCtaCte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdCtaCteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayObservaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayObservaciones"));
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
