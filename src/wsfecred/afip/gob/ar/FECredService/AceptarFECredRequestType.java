/**
 * AceptarFECredRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class AceptarFECredRequestType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest;

    private wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte;

    private wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType[] arrayConfirmarNotasDC;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion;

    private wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones;

    private wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion;

    private wsfecred.afip.gob.ar.FECredService.TipoCancelacionSimpleType tipoCancelacion;

    private java.math.BigDecimal importeCancelado;

    private java.math.BigDecimal importeTotalRetPesos;

    private java.math.BigDecimal importeEmbargoPesos;

    private java.math.BigDecimal saldoAceptado;

    private java.lang.String codMoneda;

    private java.math.BigDecimal cotizacionMonedaUlt;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBU;

    private java.lang.String CBUComprador;

    public AceptarFECredRequestType() {
    }

    public AceptarFECredRequestType(
           wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest,
           wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte,
           wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType[] arrayConfirmarNotasDC,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion,
           wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones,
           wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion,
           wsfecred.afip.gob.ar.FECredService.TipoCancelacionSimpleType tipoCancelacion,
           java.math.BigDecimal importeCancelado,
           java.math.BigDecimal importeTotalRetPesos,
           java.math.BigDecimal importeEmbargoPesos,
           java.math.BigDecimal saldoAceptado,
           java.lang.String codMoneda,
           java.math.BigDecimal cotizacionMonedaUlt,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBU,
           java.lang.String CBUComprador) {
           this.authRequest = authRequest;
           this.idCtaCte = idCtaCte;
           this.arrayConfirmarNotasDC = arrayConfirmarNotasDC;
           this.arrayFormasCancelacion = arrayFormasCancelacion;
           this.arrayRetenciones = arrayRetenciones;
           this.arrayAjustesOperacion = arrayAjustesOperacion;
           this.tipoCancelacion = tipoCancelacion;
           this.importeCancelado = importeCancelado;
           this.importeTotalRetPesos = importeTotalRetPesos;
           this.importeEmbargoPesos = importeEmbargoPesos;
           this.saldoAceptado = saldoAceptado;
           this.codMoneda = codMoneda;
           this.cotizacionMonedaUlt = cotizacionMonedaUlt;
           this.informaCBU = informaCBU;
           this.CBUComprador = CBUComprador;
    }


    /**
     * Gets the authRequest value for this AceptarFECredRequestType.
     * 
     * @return authRequest
     */
    public wsfecred.afip.gob.ar.FECredService.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this AceptarFECredRequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(wsfecred.afip.gob.ar.FECredService.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the idCtaCte value for this AceptarFECredRequestType.
     * 
     * @return idCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.IdCtaCteType getIdCtaCte() {
        return idCtaCte;
    }


    /**
     * Sets the idCtaCte value for this AceptarFECredRequestType.
     * 
     * @param idCtaCte
     */
    public void setIdCtaCte(wsfecred.afip.gob.ar.FECredService.IdCtaCteType idCtaCte) {
        this.idCtaCte = idCtaCte;
    }


    /**
     * Gets the arrayConfirmarNotasDC value for this AceptarFECredRequestType.
     * 
     * @return arrayConfirmarNotasDC
     */
    public wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType[] getArrayConfirmarNotasDC() {
        return arrayConfirmarNotasDC;
    }


    /**
     * Sets the arrayConfirmarNotasDC value for this AceptarFECredRequestType.
     * 
     * @param arrayConfirmarNotasDC
     */
    public void setArrayConfirmarNotasDC(wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType[] arrayConfirmarNotasDC) {
        this.arrayConfirmarNotasDC = arrayConfirmarNotasDC;
    }


    /**
     * Gets the arrayFormasCancelacion value for this AceptarFECredRequestType.
     * 
     * @return arrayFormasCancelacion
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayFormasCancelacion() {
        return arrayFormasCancelacion;
    }


    /**
     * Sets the arrayFormasCancelacion value for this AceptarFECredRequestType.
     * 
     * @param arrayFormasCancelacion
     */
    public void setArrayFormasCancelacion(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion) {
        this.arrayFormasCancelacion = arrayFormasCancelacion;
    }


    /**
     * Gets the arrayRetenciones value for this AceptarFECredRequestType.
     * 
     * @return arrayRetenciones
     */
    public wsfecred.afip.gob.ar.FECredService.RetencionType[] getArrayRetenciones() {
        return arrayRetenciones;
    }


    /**
     * Sets the arrayRetenciones value for this AceptarFECredRequestType.
     * 
     * @param arrayRetenciones
     */
    public void setArrayRetenciones(wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones) {
        this.arrayRetenciones = arrayRetenciones;
    }


    /**
     * Gets the arrayAjustesOperacion value for this AceptarFECredRequestType.
     * 
     * @return arrayAjustesOperacion
     */
    public wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] getArrayAjustesOperacion() {
        return arrayAjustesOperacion;
    }


    /**
     * Sets the arrayAjustesOperacion value for this AceptarFECredRequestType.
     * 
     * @param arrayAjustesOperacion
     */
    public void setArrayAjustesOperacion(wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion) {
        this.arrayAjustesOperacion = arrayAjustesOperacion;
    }


    /**
     * Gets the tipoCancelacion value for this AceptarFECredRequestType.
     * 
     * @return tipoCancelacion
     */
    public wsfecred.afip.gob.ar.FECredService.TipoCancelacionSimpleType getTipoCancelacion() {
        return tipoCancelacion;
    }


    /**
     * Sets the tipoCancelacion value for this AceptarFECredRequestType.
     * 
     * @param tipoCancelacion
     */
    public void setTipoCancelacion(wsfecred.afip.gob.ar.FECredService.TipoCancelacionSimpleType tipoCancelacion) {
        this.tipoCancelacion = tipoCancelacion;
    }


    /**
     * Gets the importeCancelado value for this AceptarFECredRequestType.
     * 
     * @return importeCancelado
     */
    public java.math.BigDecimal getImporteCancelado() {
        return importeCancelado;
    }


    /**
     * Sets the importeCancelado value for this AceptarFECredRequestType.
     * 
     * @param importeCancelado
     */
    public void setImporteCancelado(java.math.BigDecimal importeCancelado) {
        this.importeCancelado = importeCancelado;
    }


    /**
     * Gets the importeTotalRetPesos value for this AceptarFECredRequestType.
     * 
     * @return importeTotalRetPesos
     */
    public java.math.BigDecimal getImporteTotalRetPesos() {
        return importeTotalRetPesos;
    }


    /**
     * Sets the importeTotalRetPesos value for this AceptarFECredRequestType.
     * 
     * @param importeTotalRetPesos
     */
    public void setImporteTotalRetPesos(java.math.BigDecimal importeTotalRetPesos) {
        this.importeTotalRetPesos = importeTotalRetPesos;
    }


    /**
     * Gets the importeEmbargoPesos value for this AceptarFECredRequestType.
     * 
     * @return importeEmbargoPesos
     */
    public java.math.BigDecimal getImporteEmbargoPesos() {
        return importeEmbargoPesos;
    }


    /**
     * Sets the importeEmbargoPesos value for this AceptarFECredRequestType.
     * 
     * @param importeEmbargoPesos
     */
    public void setImporteEmbargoPesos(java.math.BigDecimal importeEmbargoPesos) {
        this.importeEmbargoPesos = importeEmbargoPesos;
    }


    /**
     * Gets the saldoAceptado value for this AceptarFECredRequestType.
     * 
     * @return saldoAceptado
     */
    public java.math.BigDecimal getSaldoAceptado() {
        return saldoAceptado;
    }


    /**
     * Sets the saldoAceptado value for this AceptarFECredRequestType.
     * 
     * @param saldoAceptado
     */
    public void setSaldoAceptado(java.math.BigDecimal saldoAceptado) {
        this.saldoAceptado = saldoAceptado;
    }


    /**
     * Gets the codMoneda value for this AceptarFECredRequestType.
     * 
     * @return codMoneda
     */
    public java.lang.String getCodMoneda() {
        return codMoneda;
    }


    /**
     * Sets the codMoneda value for this AceptarFECredRequestType.
     * 
     * @param codMoneda
     */
    public void setCodMoneda(java.lang.String codMoneda) {
        this.codMoneda = codMoneda;
    }


    /**
     * Gets the cotizacionMonedaUlt value for this AceptarFECredRequestType.
     * 
     * @return cotizacionMonedaUlt
     */
    public java.math.BigDecimal getCotizacionMonedaUlt() {
        return cotizacionMonedaUlt;
    }


    /**
     * Sets the cotizacionMonedaUlt value for this AceptarFECredRequestType.
     * 
     * @param cotizacionMonedaUlt
     */
    public void setCotizacionMonedaUlt(java.math.BigDecimal cotizacionMonedaUlt) {
        this.cotizacionMonedaUlt = cotizacionMonedaUlt;
    }


    /**
     * Gets the informaCBU value for this AceptarFECredRequestType.
     * 
     * @return informaCBU
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getInformaCBU() {
        return informaCBU;
    }


    /**
     * Sets the informaCBU value for this AceptarFECredRequestType.
     * 
     * @param informaCBU
     */
    public void setInformaCBU(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType informaCBU) {
        this.informaCBU = informaCBU;
    }


    /**
     * Gets the CBUComprador value for this AceptarFECredRequestType.
     * 
     * @return CBUComprador
     */
    public java.lang.String getCBUComprador() {
        return CBUComprador;
    }


    /**
     * Sets the CBUComprador value for this AceptarFECredRequestType.
     * 
     * @param CBUComprador
     */
    public void setCBUComprador(java.lang.String CBUComprador) {
        this.CBUComprador = CBUComprador;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AceptarFECredRequestType)) return false;
        AceptarFECredRequestType other = (AceptarFECredRequestType) obj;
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
            ((this.arrayConfirmarNotasDC==null && other.getArrayConfirmarNotasDC()==null) || 
             (this.arrayConfirmarNotasDC!=null &&
              java.util.Arrays.equals(this.arrayConfirmarNotasDC, other.getArrayConfirmarNotasDC()))) &&
            ((this.arrayFormasCancelacion==null && other.getArrayFormasCancelacion()==null) || 
             (this.arrayFormasCancelacion!=null &&
              java.util.Arrays.equals(this.arrayFormasCancelacion, other.getArrayFormasCancelacion()))) &&
            ((this.arrayRetenciones==null && other.getArrayRetenciones()==null) || 
             (this.arrayRetenciones!=null &&
              java.util.Arrays.equals(this.arrayRetenciones, other.getArrayRetenciones()))) &&
            ((this.arrayAjustesOperacion==null && other.getArrayAjustesOperacion()==null) || 
             (this.arrayAjustesOperacion!=null &&
              java.util.Arrays.equals(this.arrayAjustesOperacion, other.getArrayAjustesOperacion()))) &&
            ((this.tipoCancelacion==null && other.getTipoCancelacion()==null) || 
             (this.tipoCancelacion!=null &&
              this.tipoCancelacion.equals(other.getTipoCancelacion()))) &&
            ((this.importeCancelado==null && other.getImporteCancelado()==null) || 
             (this.importeCancelado!=null &&
              this.importeCancelado.equals(other.getImporteCancelado()))) &&
            ((this.importeTotalRetPesos==null && other.getImporteTotalRetPesos()==null) || 
             (this.importeTotalRetPesos!=null &&
              this.importeTotalRetPesos.equals(other.getImporteTotalRetPesos()))) &&
            ((this.importeEmbargoPesos==null && other.getImporteEmbargoPesos()==null) || 
             (this.importeEmbargoPesos!=null &&
              this.importeEmbargoPesos.equals(other.getImporteEmbargoPesos()))) &&
            ((this.saldoAceptado==null && other.getSaldoAceptado()==null) || 
             (this.saldoAceptado!=null &&
              this.saldoAceptado.equals(other.getSaldoAceptado()))) &&
            ((this.codMoneda==null && other.getCodMoneda()==null) || 
             (this.codMoneda!=null &&
              this.codMoneda.equals(other.getCodMoneda()))) &&
            ((this.cotizacionMonedaUlt==null && other.getCotizacionMonedaUlt()==null) || 
             (this.cotizacionMonedaUlt!=null &&
              this.cotizacionMonedaUlt.equals(other.getCotizacionMonedaUlt()))) &&
            ((this.informaCBU==null && other.getInformaCBU()==null) || 
             (this.informaCBU!=null &&
              this.informaCBU.equals(other.getInformaCBU()))) &&
            ((this.CBUComprador==null && other.getCBUComprador()==null) || 
             (this.CBUComprador!=null &&
              this.CBUComprador.equals(other.getCBUComprador())));
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
        if (getArrayConfirmarNotasDC() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayConfirmarNotasDC());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayConfirmarNotasDC(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getArrayRetenciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayRetenciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayRetenciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayAjustesOperacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayAjustesOperacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayAjustesOperacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTipoCancelacion() != null) {
            _hashCode += getTipoCancelacion().hashCode();
        }
        if (getImporteCancelado() != null) {
            _hashCode += getImporteCancelado().hashCode();
        }
        if (getImporteTotalRetPesos() != null) {
            _hashCode += getImporteTotalRetPesos().hashCode();
        }
        if (getImporteEmbargoPesos() != null) {
            _hashCode += getImporteEmbargoPesos().hashCode();
        }
        if (getSaldoAceptado() != null) {
            _hashCode += getSaldoAceptado().hashCode();
        }
        if (getCodMoneda() != null) {
            _hashCode += getCodMoneda().hashCode();
        }
        if (getCotizacionMonedaUlt() != null) {
            _hashCode += getCotizacionMonedaUlt().hashCode();
        }
        if (getInformaCBU() != null) {
            _hashCode += getInformaCBU().hashCode();
        }
        if (getCBUComprador() != null) {
            _hashCode += getCBUComprador().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AceptarFECredRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AceptarFECredRequestType"));
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
        elemField.setFieldName("arrayConfirmarNotasDC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayConfirmarNotasDC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConfirmarNotaDCType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "confirmarNota"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayFormasCancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayFormasCancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayRetenciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayRetenciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RetencionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "retencion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayAjustesOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayAjustesOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AjusteOperacionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "ajuste"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoCancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoCancelacionSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeCancelado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeCancelado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeTotalRetPesos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeTotalRetPesos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeEmbargoPesos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeEmbargoPesos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoAceptado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldoAceptado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cotizacionMonedaUlt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cotizacionMonedaUlt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informaCBU");
        elemField.setXmlName(new javax.xml.namespace.QName("", "informaCBU"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBUComprador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CBUComprador"));
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
