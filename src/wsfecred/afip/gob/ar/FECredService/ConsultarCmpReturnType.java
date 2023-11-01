/**
 * ConsultarCmpReturnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarCmpReturnType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayComprobantes;

    private java.lang.Short nroPagina;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType hayMas;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato;

    public ConsultarCmpReturnType() {
    }

    public ConsultarCmpReturnType(
           wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayComprobantes,
           java.lang.Short nroPagina,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType hayMas,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
           this.arrayComprobantes = arrayComprobantes;
           this.nroPagina = nroPagina;
           this.hayMas = hayMas;
           this.evento = evento;
           this.arrayObservaciones = arrayObservaciones;
           this.arrayErrores = arrayErrores;
           this.arrayErroresFormato = arrayErroresFormato;
    }


    /**
     * Gets the arrayComprobantes value for this ConsultarCmpReturnType.
     * 
     * @return arrayComprobantes
     */
    public wsfecred.afip.gob.ar.FECredService.ComprobanteType[] getArrayComprobantes() {
        return arrayComprobantes;
    }


    /**
     * Sets the arrayComprobantes value for this ConsultarCmpReturnType.
     * 
     * @param arrayComprobantes
     */
    public void setArrayComprobantes(wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayComprobantes) {
        this.arrayComprobantes = arrayComprobantes;
    }


    /**
     * Gets the nroPagina value for this ConsultarCmpReturnType.
     * 
     * @return nroPagina
     */
    public java.lang.Short getNroPagina() {
        return nroPagina;
    }


    /**
     * Sets the nroPagina value for this ConsultarCmpReturnType.
     * 
     * @param nroPagina
     */
    public void setNroPagina(java.lang.Short nroPagina) {
        this.nroPagina = nroPagina;
    }


    /**
     * Gets the hayMas value for this ConsultarCmpReturnType.
     * 
     * @return hayMas
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getHayMas() {
        return hayMas;
    }


    /**
     * Sets the hayMas value for this ConsultarCmpReturnType.
     * 
     * @param hayMas
     */
    public void setHayMas(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType hayMas) {
        this.hayMas = hayMas;
    }


    /**
     * Gets the evento value for this ConsultarCmpReturnType.
     * 
     * @return evento
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this ConsultarCmpReturnType.
     * 
     * @param evento
     */
    public void setEvento(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType evento) {
        this.evento = evento;
    }


    /**
     * Gets the arrayObservaciones value for this ConsultarCmpReturnType.
     * 
     * @return arrayObservaciones
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayObservaciones() {
        return arrayObservaciones;
    }


    /**
     * Sets the arrayObservaciones value for this ConsultarCmpReturnType.
     * 
     * @param arrayObservaciones
     */
    public void setArrayObservaciones(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayObservaciones) {
        this.arrayObservaciones = arrayObservaciones;
    }


    /**
     * Gets the arrayErrores value for this ConsultarCmpReturnType.
     * 
     * @return arrayErrores
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this ConsultarCmpReturnType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the arrayErroresFormato value for this ConsultarCmpReturnType.
     * 
     * @return arrayErroresFormato
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] getArrayErroresFormato() {
        return arrayErroresFormato;
    }


    /**
     * Sets the arrayErroresFormato value for this ConsultarCmpReturnType.
     * 
     * @param arrayErroresFormato
     */
    public void setArrayErroresFormato(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
        this.arrayErroresFormato = arrayErroresFormato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarCmpReturnType)) return false;
        ConsultarCmpReturnType other = (ConsultarCmpReturnType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayComprobantes==null && other.getArrayComprobantes()==null) || 
             (this.arrayComprobantes!=null &&
              java.util.Arrays.equals(this.arrayComprobantes, other.getArrayComprobantes()))) &&
            ((this.nroPagina==null && other.getNroPagina()==null) || 
             (this.nroPagina!=null &&
              this.nroPagina.equals(other.getNroPagina()))) &&
            ((this.hayMas==null && other.getHayMas()==null) || 
             (this.hayMas!=null &&
              this.hayMas.equals(other.getHayMas()))) &&
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
        if (getArrayComprobantes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayComprobantes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayComprobantes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNroPagina() != null) {
            _hashCode += getNroPagina().hashCode();
        }
        if (getHayMas() != null) {
            _hashCode += getHayMas().hashCode();
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
        new org.apache.axis.description.TypeDesc(ConsultarCmpReturnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCmpReturnType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayComprobantes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayComprobantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "comprobante"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroPagina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nroPagina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hayMas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hayMas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
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
