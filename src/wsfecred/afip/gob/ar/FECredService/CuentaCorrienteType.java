/**
 * CuentaCorrienteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class CuentaCorrienteType  implements java.io.Serializable {
    private long codCtaCte;

    private wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte;

    private wsfecred.afip.gob.ar.FECredService.ComprobanteType factura;

    private wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayNotasDCAsociadas;

    private wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion;

    private wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones;

    private wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion;

    private java.math.BigDecimal importeInicial;

    private java.math.BigDecimal importeTotalNotasDC;

    private java.math.BigDecimal importeCancelado;

    private java.math.BigDecimal importeTotalRetPesos;

    private java.math.BigDecimal importeEmbargoPesos;

    private java.math.BigDecimal saldoAceptado;

    private java.math.BigDecimal saldo;

    private java.lang.String codMoneda;

    private java.math.BigDecimal cotizacionMonedaUlt;

    public CuentaCorrienteType() {
    }

    public CuentaCorrienteType(
           long codCtaCte,
           wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte,
           wsfecred.afip.gob.ar.FECredService.ComprobanteType factura,
           wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayNotasDCAsociadas,
           wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion,
           wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones,
           wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion,
           java.math.BigDecimal importeInicial,
           java.math.BigDecimal importeTotalNotasDC,
           java.math.BigDecimal importeCancelado,
           java.math.BigDecimal importeTotalRetPesos,
           java.math.BigDecimal importeEmbargoPesos,
           java.math.BigDecimal saldoAceptado,
           java.math.BigDecimal saldo,
           java.lang.String codMoneda,
           java.math.BigDecimal cotizacionMonedaUlt) {
           this.codCtaCte = codCtaCte;
           this.estadoCtaCte = estadoCtaCte;
           this.factura = factura;
           this.arrayNotasDCAsociadas = arrayNotasDCAsociadas;
           this.arrayFormasCancelacion = arrayFormasCancelacion;
           this.arrayRetenciones = arrayRetenciones;
           this.arrayAjustesOperacion = arrayAjustesOperacion;
           this.importeInicial = importeInicial;
           this.importeTotalNotasDC = importeTotalNotasDC;
           this.importeCancelado = importeCancelado;
           this.importeTotalRetPesos = importeTotalRetPesos;
           this.importeEmbargoPesos = importeEmbargoPesos;
           this.saldoAceptado = saldoAceptado;
           this.saldo = saldo;
           this.codMoneda = codMoneda;
           this.cotizacionMonedaUlt = cotizacionMonedaUlt;
    }


    /**
     * Gets the codCtaCte value for this CuentaCorrienteType.
     * 
     * @return codCtaCte
     */
    public long getCodCtaCte() {
        return codCtaCte;
    }


    /**
     * Sets the codCtaCte value for this CuentaCorrienteType.
     * 
     * @param codCtaCte
     */
    public void setCodCtaCte(long codCtaCte) {
        this.codCtaCte = codCtaCte;
    }


    /**
     * Gets the estadoCtaCte value for this CuentaCorrienteType.
     * 
     * @return estadoCtaCte
     */
    public wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType getEstadoCtaCte() {
        return estadoCtaCte;
    }


    /**
     * Sets the estadoCtaCte value for this CuentaCorrienteType.
     * 
     * @param estadoCtaCte
     */
    public void setEstadoCtaCte(wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType estadoCtaCte) {
        this.estadoCtaCte = estadoCtaCte;
    }


    /**
     * Gets the factura value for this CuentaCorrienteType.
     * 
     * @return factura
     */
    public wsfecred.afip.gob.ar.FECredService.ComprobanteType getFactura() {
        return factura;
    }


    /**
     * Sets the factura value for this CuentaCorrienteType.
     * 
     * @param factura
     */
    public void setFactura(wsfecred.afip.gob.ar.FECredService.ComprobanteType factura) {
        this.factura = factura;
    }


    /**
     * Gets the arrayNotasDCAsociadas value for this CuentaCorrienteType.
     * 
     * @return arrayNotasDCAsociadas
     */
    public wsfecred.afip.gob.ar.FECredService.ComprobanteType[] getArrayNotasDCAsociadas() {
        return arrayNotasDCAsociadas;
    }


    /**
     * Sets the arrayNotasDCAsociadas value for this CuentaCorrienteType.
     * 
     * @param arrayNotasDCAsociadas
     */
    public void setArrayNotasDCAsociadas(wsfecred.afip.gob.ar.FECredService.ComprobanteType[] arrayNotasDCAsociadas) {
        this.arrayNotasDCAsociadas = arrayNotasDCAsociadas;
    }


    /**
     * Gets the arrayFormasCancelacion value for this CuentaCorrienteType.
     * 
     * @return arrayFormasCancelacion
     */
    public wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] getArrayFormasCancelacion() {
        return arrayFormasCancelacion;
    }


    /**
     * Sets the arrayFormasCancelacion value for this CuentaCorrienteType.
     * 
     * @param arrayFormasCancelacion
     */
    public void setArrayFormasCancelacion(wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[] arrayFormasCancelacion) {
        this.arrayFormasCancelacion = arrayFormasCancelacion;
    }


    /**
     * Gets the arrayRetenciones value for this CuentaCorrienteType.
     * 
     * @return arrayRetenciones
     */
    public wsfecred.afip.gob.ar.FECredService.RetencionType[] getArrayRetenciones() {
        return arrayRetenciones;
    }


    /**
     * Sets the arrayRetenciones value for this CuentaCorrienteType.
     * 
     * @param arrayRetenciones
     */
    public void setArrayRetenciones(wsfecred.afip.gob.ar.FECredService.RetencionType[] arrayRetenciones) {
        this.arrayRetenciones = arrayRetenciones;
    }


    /**
     * Gets the arrayAjustesOperacion value for this CuentaCorrienteType.
     * 
     * @return arrayAjustesOperacion
     */
    public wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] getArrayAjustesOperacion() {
        return arrayAjustesOperacion;
    }


    /**
     * Sets the arrayAjustesOperacion value for this CuentaCorrienteType.
     * 
     * @param arrayAjustesOperacion
     */
    public void setArrayAjustesOperacion(wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[] arrayAjustesOperacion) {
        this.arrayAjustesOperacion = arrayAjustesOperacion;
    }


    /**
     * Gets the importeInicial value for this CuentaCorrienteType.
     * 
     * @return importeInicial
     */
    public java.math.BigDecimal getImporteInicial() {
        return importeInicial;
    }


    /**
     * Sets the importeInicial value for this CuentaCorrienteType.
     * 
     * @param importeInicial
     */
    public void setImporteInicial(java.math.BigDecimal importeInicial) {
        this.importeInicial = importeInicial;
    }


    /**
     * Gets the importeTotalNotasDC value for this CuentaCorrienteType.
     * 
     * @return importeTotalNotasDC
     */
    public java.math.BigDecimal getImporteTotalNotasDC() {
        return importeTotalNotasDC;
    }


    /**
     * Sets the importeTotalNotasDC value for this CuentaCorrienteType.
     * 
     * @param importeTotalNotasDC
     */
    public void setImporteTotalNotasDC(java.math.BigDecimal importeTotalNotasDC) {
        this.importeTotalNotasDC = importeTotalNotasDC;
    }


    /**
     * Gets the importeCancelado value for this CuentaCorrienteType.
     * 
     * @return importeCancelado
     */
    public java.math.BigDecimal getImporteCancelado() {
        return importeCancelado;
    }


    /**
     * Sets the importeCancelado value for this CuentaCorrienteType.
     * 
     * @param importeCancelado
     */
    public void setImporteCancelado(java.math.BigDecimal importeCancelado) {
        this.importeCancelado = importeCancelado;
    }


    /**
     * Gets the importeTotalRetPesos value for this CuentaCorrienteType.
     * 
     * @return importeTotalRetPesos
     */
    public java.math.BigDecimal getImporteTotalRetPesos() {
        return importeTotalRetPesos;
    }


    /**
     * Sets the importeTotalRetPesos value for this CuentaCorrienteType.
     * 
     * @param importeTotalRetPesos
     */
    public void setImporteTotalRetPesos(java.math.BigDecimal importeTotalRetPesos) {
        this.importeTotalRetPesos = importeTotalRetPesos;
    }


    /**
     * Gets the importeEmbargoPesos value for this CuentaCorrienteType.
     * 
     * @return importeEmbargoPesos
     */
    public java.math.BigDecimal getImporteEmbargoPesos() {
        return importeEmbargoPesos;
    }


    /**
     * Sets the importeEmbargoPesos value for this CuentaCorrienteType.
     * 
     * @param importeEmbargoPesos
     */
    public void setImporteEmbargoPesos(java.math.BigDecimal importeEmbargoPesos) {
        this.importeEmbargoPesos = importeEmbargoPesos;
    }


    /**
     * Gets the saldoAceptado value for this CuentaCorrienteType.
     * 
     * @return saldoAceptado
     */
    public java.math.BigDecimal getSaldoAceptado() {
        return saldoAceptado;
    }


    /**
     * Sets the saldoAceptado value for this CuentaCorrienteType.
     * 
     * @param saldoAceptado
     */
    public void setSaldoAceptado(java.math.BigDecimal saldoAceptado) {
        this.saldoAceptado = saldoAceptado;
    }


    /**
     * Gets the saldo value for this CuentaCorrienteType.
     * 
     * @return saldo
     */
    public java.math.BigDecimal getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this CuentaCorrienteType.
     * 
     * @param saldo
     */
    public void setSaldo(java.math.BigDecimal saldo) {
        this.saldo = saldo;
    }


    /**
     * Gets the codMoneda value for this CuentaCorrienteType.
     * 
     * @return codMoneda
     */
    public java.lang.String getCodMoneda() {
        return codMoneda;
    }


    /**
     * Sets the codMoneda value for this CuentaCorrienteType.
     * 
     * @param codMoneda
     */
    public void setCodMoneda(java.lang.String codMoneda) {
        this.codMoneda = codMoneda;
    }


    /**
     * Gets the cotizacionMonedaUlt value for this CuentaCorrienteType.
     * 
     * @return cotizacionMonedaUlt
     */
    public java.math.BigDecimal getCotizacionMonedaUlt() {
        return cotizacionMonedaUlt;
    }


    /**
     * Sets the cotizacionMonedaUlt value for this CuentaCorrienteType.
     * 
     * @param cotizacionMonedaUlt
     */
    public void setCotizacionMonedaUlt(java.math.BigDecimal cotizacionMonedaUlt) {
        this.cotizacionMonedaUlt = cotizacionMonedaUlt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CuentaCorrienteType)) return false;
        CuentaCorrienteType other = (CuentaCorrienteType) obj;
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
            ((this.factura==null && other.getFactura()==null) || 
             (this.factura!=null &&
              this.factura.equals(other.getFactura()))) &&
            ((this.arrayNotasDCAsociadas==null && other.getArrayNotasDCAsociadas()==null) || 
             (this.arrayNotasDCAsociadas!=null &&
              java.util.Arrays.equals(this.arrayNotasDCAsociadas, other.getArrayNotasDCAsociadas()))) &&
            ((this.arrayFormasCancelacion==null && other.getArrayFormasCancelacion()==null) || 
             (this.arrayFormasCancelacion!=null &&
              java.util.Arrays.equals(this.arrayFormasCancelacion, other.getArrayFormasCancelacion()))) &&
            ((this.arrayRetenciones==null && other.getArrayRetenciones()==null) || 
             (this.arrayRetenciones!=null &&
              java.util.Arrays.equals(this.arrayRetenciones, other.getArrayRetenciones()))) &&
            ((this.arrayAjustesOperacion==null && other.getArrayAjustesOperacion()==null) || 
             (this.arrayAjustesOperacion!=null &&
              java.util.Arrays.equals(this.arrayAjustesOperacion, other.getArrayAjustesOperacion()))) &&
            ((this.importeInicial==null && other.getImporteInicial()==null) || 
             (this.importeInicial!=null &&
              this.importeInicial.equals(other.getImporteInicial()))) &&
            ((this.importeTotalNotasDC==null && other.getImporteTotalNotasDC()==null) || 
             (this.importeTotalNotasDC!=null &&
              this.importeTotalNotasDC.equals(other.getImporteTotalNotasDC()))) &&
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
            ((this.saldo==null && other.getSaldo()==null) || 
             (this.saldo!=null &&
              this.saldo.equals(other.getSaldo()))) &&
            ((this.codMoneda==null && other.getCodMoneda()==null) || 
             (this.codMoneda!=null &&
              this.codMoneda.equals(other.getCodMoneda()))) &&
            ((this.cotizacionMonedaUlt==null && other.getCotizacionMonedaUlt()==null) || 
             (this.cotizacionMonedaUlt!=null &&
              this.cotizacionMonedaUlt.equals(other.getCotizacionMonedaUlt())));
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
        if (getFactura() != null) {
            _hashCode += getFactura().hashCode();
        }
        if (getArrayNotasDCAsociadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayNotasDCAsociadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayNotasDCAsociadas(), i);
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
        if (getImporteInicial() != null) {
            _hashCode += getImporteInicial().hashCode();
        }
        if (getImporteTotalNotasDC() != null) {
            _hashCode += getImporteTotalNotasDC().hashCode();
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
        if (getSaldo() != null) {
            _hashCode += getSaldo().hashCode();
        }
        if (getCodMoneda() != null) {
            _hashCode += getCodMoneda().hashCode();
        }
        if (getCotizacionMonedaUlt() != null) {
            _hashCode += getCotizacionMonedaUlt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CuentaCorrienteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaCorrienteType"));
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
        elemField.setFieldName("factura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "factura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayNotasDCAsociadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayNotasDCAsociadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "comprobante"));
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
        elemField.setFieldName("importeInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeTotalNotasDC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeTotalNotasDC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
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
