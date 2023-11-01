/**
 * InfoCtaCteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class InfoCtaCteType  implements java.io.Serializable {
    private long codCtaCte;

    private wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte;

    private wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFacturaCredito;

    private java.math.BigDecimal importeTotalFC;

    private java.math.BigDecimal saldo;

    private java.math.BigDecimal saldoAceptado;

    private java.lang.String codMoneda;

    private wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia;

    public InfoCtaCteType() {
    }

    public InfoCtaCteType(
           long codCtaCte,
           wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte,
           wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFacturaCredito,
           java.math.BigDecimal importeTotalFC,
           java.math.BigDecimal saldo,
           java.math.BigDecimal saldoAceptado,
           java.lang.String codMoneda,
           wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia) {
           this.codCtaCte = codCtaCte;
           this.estadoCtaCte = estadoCtaCte;
           this.idFacturaCredito = idFacturaCredito;
           this.importeTotalFC = importeTotalFC;
           this.saldo = saldo;
           this.saldoAceptado = saldoAceptado;
           this.codMoneda = codMoneda;
           this.opcionTransferencia = opcionTransferencia;
    }


    /**
     * Gets the codCtaCte value for this InfoCtaCteType.
     * 
     * @return codCtaCte
     */
    public long getCodCtaCte() {
        return codCtaCte;
    }


    /**
     * Sets the codCtaCte value for this InfoCtaCteType.
     * 
     * @param codCtaCte
     */
    public void setCodCtaCte(long codCtaCte) {
        this.codCtaCte = codCtaCte;
    }


    /**
     * Gets the estadoCtaCte value for this InfoCtaCteType.
     * 
     * @return estadoCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType getEstadoCtaCte() {
        return estadoCtaCte;
    }


    /**
     * Sets the estadoCtaCte value for this InfoCtaCteType.
     * 
     * @param estadoCtaCte
     */
    public void setEstadoCtaCte(wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte) {
        this.estadoCtaCte = estadoCtaCte;
    }


    /**
     * Gets the idFacturaCredito value for this InfoCtaCteType.
     * 
     * @return idFacturaCredito
     */
    public wsfecred.afip.gob.ar.FECredService.IdComprobanteType getIdFacturaCredito() {
        return idFacturaCredito;
    }


    /**
     * Sets the idFacturaCredito value for this InfoCtaCteType.
     * 
     * @param idFacturaCredito
     */
    public void setIdFacturaCredito(wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFacturaCredito) {
        this.idFacturaCredito = idFacturaCredito;
    }


    /**
     * Gets the importeTotalFC value for this InfoCtaCteType.
     * 
     * @return importeTotalFC
     */
    public java.math.BigDecimal getImporteTotalFC() {
        return importeTotalFC;
    }


    /**
     * Sets the importeTotalFC value for this InfoCtaCteType.
     * 
     * @param importeTotalFC
     */
    public void setImporteTotalFC(java.math.BigDecimal importeTotalFC) {
        this.importeTotalFC = importeTotalFC;
    }


    /**
     * Gets the saldo value for this InfoCtaCteType.
     * 
     * @return saldo
     */
    public java.math.BigDecimal getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this InfoCtaCteType.
     * 
     * @param saldo
     */
    public void setSaldo(java.math.BigDecimal saldo) {
        this.saldo = saldo;
    }


    /**
     * Gets the saldoAceptado value for this InfoCtaCteType.
     * 
     * @return saldoAceptado
     */
    public java.math.BigDecimal getSaldoAceptado() {
        return saldoAceptado;
    }


    /**
     * Sets the saldoAceptado value for this InfoCtaCteType.
     * 
     * @param saldoAceptado
     */
    public void setSaldoAceptado(java.math.BigDecimal saldoAceptado) {
        this.saldoAceptado = saldoAceptado;
    }


    /**
     * Gets the codMoneda value for this InfoCtaCteType.
     * 
     * @return codMoneda
     */
    public java.lang.String getCodMoneda() {
        return codMoneda;
    }


    /**
     * Sets the codMoneda value for this InfoCtaCteType.
     * 
     * @param codMoneda
     */
    public void setCodMoneda(java.lang.String codMoneda) {
        this.codMoneda = codMoneda;
    }


    /**
     * Gets the opcionTransferencia value for this InfoCtaCteType.
     * 
     * @return opcionTransferencia
     */
    public wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType getOpcionTransferencia() {
        return opcionTransferencia;
    }


    /**
     * Sets the opcionTransferencia value for this InfoCtaCteType.
     * 
     * @param opcionTransferencia
     */
    public void setOpcionTransferencia(wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia) {
        this.opcionTransferencia = opcionTransferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoCtaCteType)) return false;
        InfoCtaCteType other = (InfoCtaCteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codCtaCte == other.getCodCtaCte() &&
            ((this.estadoCtaCte==null && other.getEstadoCtaCte()==null) || 
             (this.estadoCtaCte!=null &&
              this.estadoCtaCte.equals(other.getEstadoCtaCte()))) &&
            ((this.idFacturaCredito==null && other.getIdFacturaCredito()==null) || 
             (this.idFacturaCredito!=null &&
              this.idFacturaCredito.equals(other.getIdFacturaCredito()))) &&
            ((this.importeTotalFC==null && other.getImporteTotalFC()==null) || 
             (this.importeTotalFC!=null &&
              this.importeTotalFC.equals(other.getImporteTotalFC()))) &&
            ((this.saldo==null && other.getSaldo()==null) || 
             (this.saldo!=null &&
              this.saldo.equals(other.getSaldo()))) &&
            ((this.saldoAceptado==null && other.getSaldoAceptado()==null) || 
             (this.saldoAceptado!=null &&
              this.saldoAceptado.equals(other.getSaldoAceptado()))) &&
            ((this.codMoneda==null && other.getCodMoneda()==null) || 
             (this.codMoneda!=null &&
              this.codMoneda.equals(other.getCodMoneda()))) &&
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
        _hashCode += new Long(getCodCtaCte()).hashCode();
        if (getEstadoCtaCte() != null) {
            _hashCode += getEstadoCtaCte().hashCode();
        }
        if (getIdFacturaCredito() != null) {
            _hashCode += getIdFacturaCredito().hashCode();
        }
        if (getImporteTotalFC() != null) {
            _hashCode += getImporteTotalFC().hashCode();
        }
        if (getSaldo() != null) {
            _hashCode += getSaldo().hashCode();
        }
        if (getSaldoAceptado() != null) {
            _hashCode += getSaldoAceptado().hashCode();
        }
        if (getCodMoneda() != null) {
            _hashCode += getCodMoneda().hashCode();
        }
        if (getOpcionTransferencia() != null) {
            _hashCode += getOpcionTransferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoCtaCteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoCtaCteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCtaCte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codCtaCte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoCtaCte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadoCtaCte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFacturaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFacturaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeTotalFC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeTotalFC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoAceptado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldoAceptado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
