/**
 * ConsultarHistorialEstadosComprobanteReturnType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ConsultarHistorialEstadosComprobanteReturnType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobante;

    private wsfecred.afip.gob.ar.FECredService.EstadoCmpType[] arrayHistorialEstados;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato;

    public ConsultarHistorialEstadosComprobanteReturnType() {
    }

    public ConsultarHistorialEstadosComprobanteReturnType(
           wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobante,
           wsfecred.afip.gob.ar.FECredService.EstadoCmpType[] arrayHistorialEstados,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
           this.idComprobante = idComprobante;
           this.arrayHistorialEstados = arrayHistorialEstados;
           this.arrayErrores = arrayErrores;
           this.arrayErroresFormato = arrayErroresFormato;
    }


    /**
     * Gets the idComprobante value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @return idComprobante
     */
    public wsfecred.afip.gob.ar.FECredService.IdComprobanteType getIdComprobante() {
        return idComprobante;
    }


    /**
     * Sets the idComprobante value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @param idComprobante
     */
    public void setIdComprobante(wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobante) {
        this.idComprobante = idComprobante;
    }


    /**
     * Gets the arrayHistorialEstados value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @return arrayHistorialEstados
     */
    public wsfecred.afip.gob.ar.FECredService.EstadoCmpType[] getArrayHistorialEstados() {
        return arrayHistorialEstados;
    }


    /**
     * Sets the arrayHistorialEstados value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @param arrayHistorialEstados
     */
    public void setArrayHistorialEstados(wsfecred.afip.gob.ar.FECredService.EstadoCmpType[] arrayHistorialEstados) {
        this.arrayHistorialEstados = arrayHistorialEstados;
    }


    /**
     * Gets the arrayErrores value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @return arrayErrores
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the arrayErroresFormato value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @return arrayErroresFormato
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] getArrayErroresFormato() {
        return arrayErroresFormato;
    }


    /**
     * Sets the arrayErroresFormato value for this ConsultarHistorialEstadosComprobanteReturnType.
     * 
     * @param arrayErroresFormato
     */
    public void setArrayErroresFormato(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[] arrayErroresFormato) {
        this.arrayErroresFormato = arrayErroresFormato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarHistorialEstadosComprobanteReturnType)) return false;
        ConsultarHistorialEstadosComprobanteReturnType other = (ConsultarHistorialEstadosComprobanteReturnType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idComprobante==null && other.getIdComprobante()==null) || 
             (this.idComprobante!=null &&
              this.idComprobante.equals(other.getIdComprobante()))) &&
            ((this.arrayHistorialEstados==null && other.getArrayHistorialEstados()==null) || 
             (this.arrayHistorialEstados!=null &&
              java.util.Arrays.equals(this.arrayHistorialEstados, other.getArrayHistorialEstados()))) &&
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
        if (getIdComprobante() != null) {
            _hashCode += getIdComprobante().hashCode();
        }
        if (getArrayHistorialEstados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayHistorialEstados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayHistorialEstados(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarHistorialEstadosComprobanteReturnType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteReturnType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayHistorialEstados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayHistorialEstados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "estadoHistorico"));
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
