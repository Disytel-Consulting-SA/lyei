/**
 * InfoAgtDptoCltvType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class InfoAgtDptoCltvType  implements java.io.Serializable {
    private java.util.Date fechaInfo;

    private wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType ctaAgente;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType recibida;

    private java.util.Date fechaLectura;

    private java.util.Date fechaRecep;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType aceptada;

    private java.lang.String motivoRechazo;

    private java.lang.String idPagoAgtDptoCltv;

    private java.lang.String CBUAgtDptoCltv;

    public InfoAgtDptoCltvType() {
    }

    public InfoAgtDptoCltvType(
           java.util.Date fechaInfo,
           wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType ctaAgente,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType recibida,
           java.util.Date fechaLectura,
           java.util.Date fechaRecep,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType aceptada,
           java.lang.String motivoRechazo,
           java.lang.String idPagoAgtDptoCltv,
           java.lang.String CBUAgtDptoCltv) {
           this.fechaInfo = fechaInfo;
           this.ctaAgente = ctaAgente;
           this.recibida = recibida;
           this.fechaLectura = fechaLectura;
           this.fechaRecep = fechaRecep;
           this.aceptada = aceptada;
           this.motivoRechazo = motivoRechazo;
           this.idPagoAgtDptoCltv = idPagoAgtDptoCltv;
           this.CBUAgtDptoCltv = CBUAgtDptoCltv;
    }


    /**
     * Gets the fechaInfo value for this InfoAgtDptoCltvType.
     * 
     * @return fechaInfo
     */
    public java.util.Date getFechaInfo() {
        return fechaInfo;
    }


    /**
     * Sets the fechaInfo value for this InfoAgtDptoCltvType.
     * 
     * @param fechaInfo
     */
    public void setFechaInfo(java.util.Date fechaInfo) {
        this.fechaInfo = fechaInfo;
    }


    /**
     * Gets the ctaAgente value for this InfoAgtDptoCltvType.
     * 
     * @return ctaAgente
     */
    public wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType getCtaAgente() {
        return ctaAgente;
    }


    /**
     * Sets the ctaAgente value for this InfoAgtDptoCltvType.
     * 
     * @param ctaAgente
     */
    public void setCtaAgente(wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType ctaAgente) {
        this.ctaAgente = ctaAgente;
    }


    /**
     * Gets the recibida value for this InfoAgtDptoCltvType.
     * 
     * @return recibida
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getRecibida() {
        return recibida;
    }


    /**
     * Sets the recibida value for this InfoAgtDptoCltvType.
     * 
     * @param recibida
     */
    public void setRecibida(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType recibida) {
        this.recibida = recibida;
    }


    /**
     * Gets the fechaLectura value for this InfoAgtDptoCltvType.
     * 
     * @return fechaLectura
     */
    public java.util.Date getFechaLectura() {
        return fechaLectura;
    }


    /**
     * Sets the fechaLectura value for this InfoAgtDptoCltvType.
     * 
     * @param fechaLectura
     */
    public void setFechaLectura(java.util.Date fechaLectura) {
        this.fechaLectura = fechaLectura;
    }


    /**
     * Gets the fechaRecep value for this InfoAgtDptoCltvType.
     * 
     * @return fechaRecep
     */
    public java.util.Date getFechaRecep() {
        return fechaRecep;
    }


    /**
     * Sets the fechaRecep value for this InfoAgtDptoCltvType.
     * 
     * @param fechaRecep
     */
    public void setFechaRecep(java.util.Date fechaRecep) {
        this.fechaRecep = fechaRecep;
    }


    /**
     * Gets the aceptada value for this InfoAgtDptoCltvType.
     * 
     * @return aceptada
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getAceptada() {
        return aceptada;
    }


    /**
     * Sets the aceptada value for this InfoAgtDptoCltvType.
     * 
     * @param aceptada
     */
    public void setAceptada(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType aceptada) {
        this.aceptada = aceptada;
    }


    /**
     * Gets the motivoRechazo value for this InfoAgtDptoCltvType.
     * 
     * @return motivoRechazo
     */
    public java.lang.String getMotivoRechazo() {
        return motivoRechazo;
    }


    /**
     * Sets the motivoRechazo value for this InfoAgtDptoCltvType.
     * 
     * @param motivoRechazo
     */
    public void setMotivoRechazo(java.lang.String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }


    /**
     * Gets the idPagoAgtDptoCltv value for this InfoAgtDptoCltvType.
     * 
     * @return idPagoAgtDptoCltv
     */
    public java.lang.String getIdPagoAgtDptoCltv() {
        return idPagoAgtDptoCltv;
    }


    /**
     * Sets the idPagoAgtDptoCltv value for this InfoAgtDptoCltvType.
     * 
     * @param idPagoAgtDptoCltv
     */
    public void setIdPagoAgtDptoCltv(java.lang.String idPagoAgtDptoCltv) {
        this.idPagoAgtDptoCltv = idPagoAgtDptoCltv;
    }


    /**
     * Gets the CBUAgtDptoCltv value for this InfoAgtDptoCltvType.
     * 
     * @return CBUAgtDptoCltv
     */
    public java.lang.String getCBUAgtDptoCltv() {
        return CBUAgtDptoCltv;
    }


    /**
     * Sets the CBUAgtDptoCltv value for this InfoAgtDptoCltvType.
     * 
     * @param CBUAgtDptoCltv
     */
    public void setCBUAgtDptoCltv(java.lang.String CBUAgtDptoCltv) {
        this.CBUAgtDptoCltv = CBUAgtDptoCltv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoAgtDptoCltvType)) return false;
        InfoAgtDptoCltvType other = (InfoAgtDptoCltvType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaInfo==null && other.getFechaInfo()==null) || 
             (this.fechaInfo!=null &&
              this.fechaInfo.equals(other.getFechaInfo()))) &&
            ((this.ctaAgente==null && other.getCtaAgente()==null) || 
             (this.ctaAgente!=null &&
              this.ctaAgente.equals(other.getCtaAgente()))) &&
            ((this.recibida==null && other.getRecibida()==null) || 
             (this.recibida!=null &&
              this.recibida.equals(other.getRecibida()))) &&
            ((this.fechaLectura==null && other.getFechaLectura()==null) || 
             (this.fechaLectura!=null &&
              this.fechaLectura.equals(other.getFechaLectura()))) &&
            ((this.fechaRecep==null && other.getFechaRecep()==null) || 
             (this.fechaRecep!=null &&
              this.fechaRecep.equals(other.getFechaRecep()))) &&
            ((this.aceptada==null && other.getAceptada()==null) || 
             (this.aceptada!=null &&
              this.aceptada.equals(other.getAceptada()))) &&
            ((this.motivoRechazo==null && other.getMotivoRechazo()==null) || 
             (this.motivoRechazo!=null &&
              this.motivoRechazo.equals(other.getMotivoRechazo()))) &&
            ((this.idPagoAgtDptoCltv==null && other.getIdPagoAgtDptoCltv()==null) || 
             (this.idPagoAgtDptoCltv!=null &&
              this.idPagoAgtDptoCltv.equals(other.getIdPagoAgtDptoCltv()))) &&
            ((this.CBUAgtDptoCltv==null && other.getCBUAgtDptoCltv()==null) || 
             (this.CBUAgtDptoCltv!=null &&
              this.CBUAgtDptoCltv.equals(other.getCBUAgtDptoCltv())));
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
        if (getFechaInfo() != null) {
            _hashCode += getFechaInfo().hashCode();
        }
        if (getCtaAgente() != null) {
            _hashCode += getCtaAgente().hashCode();
        }
        if (getRecibida() != null) {
            _hashCode += getRecibida().hashCode();
        }
        if (getFechaLectura() != null) {
            _hashCode += getFechaLectura().hashCode();
        }
        if (getFechaRecep() != null) {
            _hashCode += getFechaRecep().hashCode();
        }
        if (getAceptada() != null) {
            _hashCode += getAceptada().hashCode();
        }
        if (getMotivoRechazo() != null) {
            _hashCode += getMotivoRechazo().hashCode();
        }
        if (getIdPagoAgtDptoCltv() != null) {
            _hashCode += getIdPagoAgtDptoCltv().hashCode();
        }
        if (getCBUAgtDptoCltv() != null) {
            _hashCode += getCBUAgtDptoCltv().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoAgtDptoCltvType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoAgtDptoCltvType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctaAgente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ctaAgente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaEnAgenteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recibida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recibida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaLectura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaLectura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaRecep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaRecep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aceptada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aceptada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivoRechazo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "motivoRechazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPagoAgtDptoCltv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPagoAgtDptoCltv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBUAgtDptoCltv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CBUAgtDptoCltv"));
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
