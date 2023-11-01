/**
 * InformarCancelacionTotalFECredRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class InformarCancelacionTotalFECredRequestType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest;

    private wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion;

    private java.math.BigDecimal importeCancelacion;

    public InformarCancelacionTotalFECredRequestType() {
    }

    public InformarCancelacionTotalFECredRequestType(
           wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest,
           wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion,
           java.math.BigDecimal importeCancelacion) {
           this.authRequest = authRequest;
           this.idCtaCte = idCtaCte;
           this.arrayFormasCancelacion = arrayFormasCancelacion;
           this.importeCancelacion = importeCancelacion;
    }


    /**
     * Gets the authRequest value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @return authRequest
     */
    public wsfecred.afip.gob.ar.FECredService.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the idCtaCte value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @return idCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.IdCtaCteType getIdCtaCte() {
        return idCtaCte;
    }


    /**
     * Sets the idCtaCte value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @param idCtaCte
     */
    public void setIdCtaCte(wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte) {
        this.idCtaCte = idCtaCte;
    }


    /**
     * Gets the arrayFormasCancelacion value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @return arrayFormasCancelacion
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayFormasCancelacion() {
        return arrayFormasCancelacion;
    }


    /**
     * Sets the arrayFormasCancelacion value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @param arrayFormasCancelacion
     */
    public void setArrayFormasCancelacion(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion) {
        this.arrayFormasCancelacion = arrayFormasCancelacion;
    }


    /**
     * Gets the importeCancelacion value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @return importeCancelacion
     */
    public java.math.BigDecimal getImporteCancelacion() {
        return importeCancelacion;
    }


    /**
     * Sets the importeCancelacion value for this InformarCancelacionTotalFECredRequestType.
     * 
     * @param importeCancelacion
     */
    public void setImporteCancelacion(java.math.BigDecimal importeCancelacion) {
        this.importeCancelacion = importeCancelacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformarCancelacionTotalFECredRequestType)) return false;
        InformarCancelacionTotalFECredRequestType other = (InformarCancelacionTotalFECredRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authRequest==null && other.getAuthRequest()==null) || 
             (this.authRequest!=null &&
              this.authRequest.equals(other.getAuthRequest()))) &&
            ((this.idCtaCte==null && other.getIdCtaCte()==null) || 
             (this.idCtaCte!=null &&
              this.idCtaCte.equals(other.getIdCtaCte()))) &&
            ((this.arrayFormasCancelacion==null && other.getArrayFormasCancelacion()==null) || 
             (this.arrayFormasCancelacion!=null &&
              java.util.Arrays.equals(this.arrayFormasCancelacion, other.getArrayFormasCancelacion()))) &&
            ((this.importeCancelacion==null && other.getImporteCancelacion()==null) || 
             (this.importeCancelacion!=null &&
              this.importeCancelacion.equals(other.getImporteCancelacion())));
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
        if (getAuthRequest() != null) {
            _hashCode += getAuthRequest().hashCode();
        }
        if (getIdCtaCte() != null) {
            _hashCode += getIdCtaCte().hashCode();
        }
        if (getArrayFormasCancelacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayFormasCancelacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayFormasCancelacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImporteCancelacion() != null) {
            _hashCode += getImporteCancelacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformarCancelacionTotalFECredRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InformarCancelacionTotalFECredRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCtaCte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCtaCte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdCtaCteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayFormasCancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayFormasCancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeCancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeCancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
