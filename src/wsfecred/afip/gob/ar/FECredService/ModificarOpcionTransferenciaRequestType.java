/**
 * ModificarOpcionTransferenciaRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ModificarOpcionTransferenciaRequestType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest;

    private wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte;

    private wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia;

    public ModificarOpcionTransferenciaRequestType() {
    }

    public ModificarOpcionTransferenciaRequestType(
           wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest,
           wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte,
           wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia) {
           this.authRequest = authRequest;
           this.idCtaCte = idCtaCte;
           this.opcionTransferencia = opcionTransferencia;
    }


    /**
     * Gets the authRequest value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @return authRequest
     */
    public wsfecred.afip.gob.ar.FECredService.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the idCtaCte value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @return idCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.IdCtaCteType getIdCtaCte() {
        return idCtaCte;
    }


    /**
     * Sets the idCtaCte value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @param idCtaCte
     */
    public void setIdCtaCte(wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte) {
        this.idCtaCte = idCtaCte;
    }


    /**
     * Gets the opcionTransferencia value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @return opcionTransferencia
     */
    public wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType getOpcionTransferencia() {
        return opcionTransferencia;
    }


    /**
     * Sets the opcionTransferencia value for this ModificarOpcionTransferenciaRequestType.
     * 
     * @param opcionTransferencia
     */
    public void setOpcionTransferencia(wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia) {
        this.opcionTransferencia = opcionTransferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModificarOpcionTransferenciaRequestType)) return false;
        ModificarOpcionTransferenciaRequestType other = (ModificarOpcionTransferenciaRequestType) obj;
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
            ((this.opcionTransferencia==null && other.getOpcionTransferencia()==null) || 
             (this.opcionTransferencia!=null &&
              this.opcionTransferencia.equals(other.getOpcionTransferencia())));
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
        if (getOpcionTransferencia() != null) {
            _hashCode += getOpcionTransferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModificarOpcionTransferenciaRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ModificarOpcionTransferenciaRequestType"));
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
        elemField.setFieldName("opcionTransferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opcionTransferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OpcionTransferenciaSimpleType"));
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
