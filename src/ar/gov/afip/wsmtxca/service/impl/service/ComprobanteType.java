/**
 * ComprobanteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class ComprobanteType  implements java.io.Serializable {
    private short codigoTipoComprobante;

    private int numeroPuntoVenta;

    private long numeroComprobante;

    private java.util.Date fechaEmision;

    private ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType codigoTipoAutorizacion;

    private java.lang.Long codigoAutorizacion;

    private java.util.Date fechaVencimiento;

    private java.lang.Short codigoTipoDocumento;

    private java.lang.Long numeroDocumento;

    private java.math.BigDecimal importeGravado;

    private java.math.BigDecimal importeNoGravado;

    private java.math.BigDecimal importeExento;

    private java.math.BigDecimal importeSubtotal;

    private java.math.BigDecimal importeOtrosTributos;

    private java.math.BigDecimal importeTotal;

    private java.lang.String codigoMoneda;

    private java.math.BigDecimal cotizacionMoneda;

    private java.lang.String observaciones;

    private short codigoConcepto;

    private java.util.Date fechaServicioDesde;

    private java.util.Date fechaServicioHasta;

    private java.util.Date fechaVencimientoPago;

    private java.util.Calendar fechaHoraGen;

    private ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType[] arrayComprobantesAsociados;

    private ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType[] arrayOtrosTributos;

    private ar.gov.afip.wsmtxca.service.impl.service.ItemType[] arrayItems;

    private ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType[] arraySubtotalesIVA;

    private ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType[] arrayDatosAdicionales;

    private ar.gov.afip.wsmtxca.service.impl.service.CompradorType[] arrayCompradores;

    public ComprobanteType() {
    }

    public ComprobanteType(
           short codigoTipoComprobante,
           int numeroPuntoVenta,
           long numeroComprobante,
           java.util.Date fechaEmision,
           ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType codigoTipoAutorizacion,
           java.lang.Long codigoAutorizacion,
           java.util.Date fechaVencimiento,
           java.lang.Short codigoTipoDocumento,
           java.lang.Long numeroDocumento,
           java.math.BigDecimal importeGravado,
           java.math.BigDecimal importeNoGravado,
           java.math.BigDecimal importeExento,
           java.math.BigDecimal importeSubtotal,
           java.math.BigDecimal importeOtrosTributos,
           java.math.BigDecimal importeTotal,
           java.lang.String codigoMoneda,
           java.math.BigDecimal cotizacionMoneda,
           java.lang.String observaciones,
           short codigoConcepto,
           java.util.Date fechaServicioDesde,
           java.util.Date fechaServicioHasta,
           java.util.Date fechaVencimientoPago,
           java.util.Calendar fechaHoraGen,
           ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType[] arrayComprobantesAsociados,
           ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType[] arrayOtrosTributos,
           ar.gov.afip.wsmtxca.service.impl.service.ItemType[] arrayItems,
           ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType[] arraySubtotalesIVA,
           ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType[] arrayDatosAdicionales,
           ar.gov.afip.wsmtxca.service.impl.service.CompradorType[] arrayCompradores) {
           this.codigoTipoComprobante = codigoTipoComprobante;
           this.numeroPuntoVenta = numeroPuntoVenta;
           this.numeroComprobante = numeroComprobante;
           this.fechaEmision = fechaEmision;
           this.codigoTipoAutorizacion = codigoTipoAutorizacion;
           this.codigoAutorizacion = codigoAutorizacion;
           this.fechaVencimiento = fechaVencimiento;
           this.codigoTipoDocumento = codigoTipoDocumento;
           this.numeroDocumento = numeroDocumento;
           this.importeGravado = importeGravado;
           this.importeNoGravado = importeNoGravado;
           this.importeExento = importeExento;
           this.importeSubtotal = importeSubtotal;
           this.importeOtrosTributos = importeOtrosTributos;
           this.importeTotal = importeTotal;
           this.codigoMoneda = codigoMoneda;
           this.cotizacionMoneda = cotizacionMoneda;
           this.observaciones = observaciones;
           this.codigoConcepto = codigoConcepto;
           this.fechaServicioDesde = fechaServicioDesde;
           this.fechaServicioHasta = fechaServicioHasta;
           this.fechaVencimientoPago = fechaVencimientoPago;
           this.fechaHoraGen = fechaHoraGen;
           this.arrayComprobantesAsociados = arrayComprobantesAsociados;
           this.arrayOtrosTributos = arrayOtrosTributos;
           this.arrayItems = arrayItems;
           this.arraySubtotalesIVA = arraySubtotalesIVA;
           this.arrayDatosAdicionales = arrayDatosAdicionales;
           this.arrayCompradores = arrayCompradores;
    }


    /**
     * Gets the codigoTipoComprobante value for this ComprobanteType.
     * 
     * @return codigoTipoComprobante
     */
    public short getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }


    /**
     * Sets the codigoTipoComprobante value for this ComprobanteType.
     * 
     * @param codigoTipoComprobante
     */
    public void setCodigoTipoComprobante(short codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }


    /**
     * Gets the numeroPuntoVenta value for this ComprobanteType.
     * 
     * @return numeroPuntoVenta
     */
    public int getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }


    /**
     * Sets the numeroPuntoVenta value for this ComprobanteType.
     * 
     * @param numeroPuntoVenta
     */
    public void setNumeroPuntoVenta(int numeroPuntoVenta) {
        this.numeroPuntoVenta = numeroPuntoVenta;
    }


    /**
     * Gets the numeroComprobante value for this ComprobanteType.
     * 
     * @return numeroComprobante
     */
    public long getNumeroComprobante() {
        return numeroComprobante;
    }


    /**
     * Sets the numeroComprobante value for this ComprobanteType.
     * 
     * @param numeroComprobante
     */
    public void setNumeroComprobante(long numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }


    /**
     * Gets the fechaEmision value for this ComprobanteType.
     * 
     * @return fechaEmision
     */
    public java.util.Date getFechaEmision() {
        return fechaEmision;
    }


    /**
     * Sets the fechaEmision value for this ComprobanteType.
     * 
     * @param fechaEmision
     */
    public void setFechaEmision(java.util.Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }


    /**
     * Gets the codigoTipoAutorizacion value for this ComprobanteType.
     * 
     * @return codigoTipoAutorizacion
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType getCodigoTipoAutorizacion() {
        return codigoTipoAutorizacion;
    }


    /**
     * Sets the codigoTipoAutorizacion value for this ComprobanteType.
     * 
     * @param codigoTipoAutorizacion
     */
    public void setCodigoTipoAutorizacion(ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType codigoTipoAutorizacion) {
        this.codigoTipoAutorizacion = codigoTipoAutorizacion;
    }


    /**
     * Gets the codigoAutorizacion value for this ComprobanteType.
     * 
     * @return codigoAutorizacion
     */
    public java.lang.Long getCodigoAutorizacion() {
        return codigoAutorizacion;
    }


    /**
     * Sets the codigoAutorizacion value for this ComprobanteType.
     * 
     * @param codigoAutorizacion
     */
    public void setCodigoAutorizacion(java.lang.Long codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }


    /**
     * Gets the fechaVencimiento value for this ComprobanteType.
     * 
     * @return fechaVencimiento
     */
    public java.util.Date getFechaVencimiento() {
        return fechaVencimiento;
    }


    /**
     * Sets the fechaVencimiento value for this ComprobanteType.
     * 
     * @param fechaVencimiento
     */
    public void setFechaVencimiento(java.util.Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    /**
     * Gets the codigoTipoDocumento value for this ComprobanteType.
     * 
     * @return codigoTipoDocumento
     */
    public java.lang.Short getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }


    /**
     * Sets the codigoTipoDocumento value for this ComprobanteType.
     * 
     * @param codigoTipoDocumento
     */
    public void setCodigoTipoDocumento(java.lang.Short codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }


    /**
     * Gets the numeroDocumento value for this ComprobanteType.
     * 
     * @return numeroDocumento
     */
    public java.lang.Long getNumeroDocumento() {
        return numeroDocumento;
    }


    /**
     * Sets the numeroDocumento value for this ComprobanteType.
     * 
     * @param numeroDocumento
     */
    public void setNumeroDocumento(java.lang.Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    /**
     * Gets the importeGravado value for this ComprobanteType.
     * 
     * @return importeGravado
     */
    public java.math.BigDecimal getImporteGravado() {
        return importeGravado;
    }


    /**
     * Sets the importeGravado value for this ComprobanteType.
     * 
     * @param importeGravado
     */
    public void setImporteGravado(java.math.BigDecimal importeGravado) {
        this.importeGravado = importeGravado;
    }


    /**
     * Gets the importeNoGravado value for this ComprobanteType.
     * 
     * @return importeNoGravado
     */
    public java.math.BigDecimal getImporteNoGravado() {
        return importeNoGravado;
    }


    /**
     * Sets the importeNoGravado value for this ComprobanteType.
     * 
     * @param importeNoGravado
     */
    public void setImporteNoGravado(java.math.BigDecimal importeNoGravado) {
        this.importeNoGravado = importeNoGravado;
    }


    /**
     * Gets the importeExento value for this ComprobanteType.
     * 
     * @return importeExento
     */
    public java.math.BigDecimal getImporteExento() {
        return importeExento;
    }


    /**
     * Sets the importeExento value for this ComprobanteType.
     * 
     * @param importeExento
     */
    public void setImporteExento(java.math.BigDecimal importeExento) {
        this.importeExento = importeExento;
    }


    /**
     * Gets the importeSubtotal value for this ComprobanteType.
     * 
     * @return importeSubtotal
     */
    public java.math.BigDecimal getImporteSubtotal() {
        return importeSubtotal;
    }


    /**
     * Sets the importeSubtotal value for this ComprobanteType.
     * 
     * @param importeSubtotal
     */
    public void setImporteSubtotal(java.math.BigDecimal importeSubtotal) {
        this.importeSubtotal = importeSubtotal;
    }


    /**
     * Gets the importeOtrosTributos value for this ComprobanteType.
     * 
     * @return importeOtrosTributos
     */
    public java.math.BigDecimal getImporteOtrosTributos() {
        return importeOtrosTributos;
    }


    /**
     * Sets the importeOtrosTributos value for this ComprobanteType.
     * 
     * @param importeOtrosTributos
     */
    public void setImporteOtrosTributos(java.math.BigDecimal importeOtrosTributos) {
        this.importeOtrosTributos = importeOtrosTributos;
    }


    /**
     * Gets the importeTotal value for this ComprobanteType.
     * 
     * @return importeTotal
     */
    public java.math.BigDecimal getImporteTotal() {
        return importeTotal;
    }


    /**
     * Sets the importeTotal value for this ComprobanteType.
     * 
     * @param importeTotal
     */
    public void setImporteTotal(java.math.BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }


    /**
     * Gets the codigoMoneda value for this ComprobanteType.
     * 
     * @return codigoMoneda
     */
    public java.lang.String getCodigoMoneda() {
        return codigoMoneda;
    }


    /**
     * Sets the codigoMoneda value for this ComprobanteType.
     * 
     * @param codigoMoneda
     */
    public void setCodigoMoneda(java.lang.String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }


    /**
     * Gets the cotizacionMoneda value for this ComprobanteType.
     * 
     * @return cotizacionMoneda
     */
    public java.math.BigDecimal getCotizacionMoneda() {
        return cotizacionMoneda;
    }


    /**
     * Sets the cotizacionMoneda value for this ComprobanteType.
     * 
     * @param cotizacionMoneda
     */
    public void setCotizacionMoneda(java.math.BigDecimal cotizacionMoneda) {
        this.cotizacionMoneda = cotizacionMoneda;
    }


    /**
     * Gets the observaciones value for this ComprobanteType.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this ComprobanteType.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the codigoConcepto value for this ComprobanteType.
     * 
     * @return codigoConcepto
     */
    public short getCodigoConcepto() {
        return codigoConcepto;
    }


    /**
     * Sets the codigoConcepto value for this ComprobanteType.
     * 
     * @param codigoConcepto
     */
    public void setCodigoConcepto(short codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }


    /**
     * Gets the fechaServicioDesde value for this ComprobanteType.
     * 
     * @return fechaServicioDesde
     */
    public java.util.Date getFechaServicioDesde() {
        return fechaServicioDesde;
    }


    /**
     * Sets the fechaServicioDesde value for this ComprobanteType.
     * 
     * @param fechaServicioDesde
     */
    public void setFechaServicioDesde(java.util.Date fechaServicioDesde) {
        this.fechaServicioDesde = fechaServicioDesde;
    }


    /**
     * Gets the fechaServicioHasta value for this ComprobanteType.
     * 
     * @return fechaServicioHasta
     */
    public java.util.Date getFechaServicioHasta() {
        return fechaServicioHasta;
    }


    /**
     * Sets the fechaServicioHasta value for this ComprobanteType.
     * 
     * @param fechaServicioHasta
     */
    public void setFechaServicioHasta(java.util.Date fechaServicioHasta) {
        this.fechaServicioHasta = fechaServicioHasta;
    }


    /**
     * Gets the fechaVencimientoPago value for this ComprobanteType.
     * 
     * @return fechaVencimientoPago
     */
    public java.util.Date getFechaVencimientoPago() {
        return fechaVencimientoPago;
    }


    /**
     * Sets the fechaVencimientoPago value for this ComprobanteType.
     * 
     * @param fechaVencimientoPago
     */
    public void setFechaVencimientoPago(java.util.Date fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }


    /**
     * Gets the fechaHoraGen value for this ComprobanteType.
     * 
     * @return fechaHoraGen
     */
    public java.util.Calendar getFechaHoraGen() {
        return fechaHoraGen;
    }


    /**
     * Sets the fechaHoraGen value for this ComprobanteType.
     * 
     * @param fechaHoraGen
     */
    public void setFechaHoraGen(java.util.Calendar fechaHoraGen) {
        this.fechaHoraGen = fechaHoraGen;
    }


    /**
     * Gets the arrayComprobantesAsociados value for this ComprobanteType.
     * 
     * @return arrayComprobantesAsociados
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType[] getArrayComprobantesAsociados() {
        return arrayComprobantesAsociados;
    }


    /**
     * Sets the arrayComprobantesAsociados value for this ComprobanteType.
     * 
     * @param arrayComprobantesAsociados
     */
    public void setArrayComprobantesAsociados(ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType[] arrayComprobantesAsociados) {
        this.arrayComprobantesAsociados = arrayComprobantesAsociados;
    }


    /**
     * Gets the arrayOtrosTributos value for this ComprobanteType.
     * 
     * @return arrayOtrosTributos
     */
    public ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType[] getArrayOtrosTributos() {
        return arrayOtrosTributos;
    }


    /**
     * Sets the arrayOtrosTributos value for this ComprobanteType.
     * 
     * @param arrayOtrosTributos
     */
    public void setArrayOtrosTributos(ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType[] arrayOtrosTributos) {
        this.arrayOtrosTributos = arrayOtrosTributos;
    }


    /**
     * Gets the arrayItems value for this ComprobanteType.
     * 
     * @return arrayItems
     */
    public ar.gov.afip.wsmtxca.service.impl.service.ItemType[] getArrayItems() {
        return arrayItems;
    }


    /**
     * Sets the arrayItems value for this ComprobanteType.
     * 
     * @param arrayItems
     */
    public void setArrayItems(ar.gov.afip.wsmtxca.service.impl.service.ItemType[] arrayItems) {
        this.arrayItems = arrayItems;
    }


    /**
     * Gets the arraySubtotalesIVA value for this ComprobanteType.
     * 
     * @return arraySubtotalesIVA
     */
    public ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType[] getArraySubtotalesIVA() {
        return arraySubtotalesIVA;
    }


    /**
     * Sets the arraySubtotalesIVA value for this ComprobanteType.
     * 
     * @param arraySubtotalesIVA
     */
    public void setArraySubtotalesIVA(ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType[] arraySubtotalesIVA) {
        this.arraySubtotalesIVA = arraySubtotalesIVA;
    }


    /**
     * Gets the arrayDatosAdicionales value for this ComprobanteType.
     * 
     * @return arrayDatosAdicionales
     */
    public ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType[] getArrayDatosAdicionales() {
        return arrayDatosAdicionales;
    }


    /**
     * Sets the arrayDatosAdicionales value for this ComprobanteType.
     * 
     * @param arrayDatosAdicionales
     */
    public void setArrayDatosAdicionales(ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType[] arrayDatosAdicionales) {
        this.arrayDatosAdicionales = arrayDatosAdicionales;
    }


    /**
     * Gets the arrayCompradores value for this ComprobanteType.
     * 
     * @return arrayCompradores
     */
    public ar.gov.afip.wsmtxca.service.impl.service.CompradorType[] getArrayCompradores() {
        return arrayCompradores;
    }


    /**
     * Sets the arrayCompradores value for this ComprobanteType.
     * 
     * @param arrayCompradores
     */
    public void setArrayCompradores(ar.gov.afip.wsmtxca.service.impl.service.CompradorType[] arrayCompradores) {
        this.arrayCompradores = arrayCompradores;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComprobanteType)) return false;
        ComprobanteType other = (ComprobanteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigoTipoComprobante == other.getCodigoTipoComprobante() &&
            this.numeroPuntoVenta == other.getNumeroPuntoVenta() &&
            this.numeroComprobante == other.getNumeroComprobante() &&
            ((this.fechaEmision==null && other.getFechaEmision()==null) || 
             (this.fechaEmision!=null &&
              this.fechaEmision.equals(other.getFechaEmision()))) &&
            ((this.codigoTipoAutorizacion==null && other.getCodigoTipoAutorizacion()==null) || 
             (this.codigoTipoAutorizacion!=null &&
              this.codigoTipoAutorizacion.equals(other.getCodigoTipoAutorizacion()))) &&
            ((this.codigoAutorizacion==null && other.getCodigoAutorizacion()==null) || 
             (this.codigoAutorizacion!=null &&
              this.codigoAutorizacion.equals(other.getCodigoAutorizacion()))) &&
            ((this.fechaVencimiento==null && other.getFechaVencimiento()==null) || 
             (this.fechaVencimiento!=null &&
              this.fechaVencimiento.equals(other.getFechaVencimiento()))) &&
            ((this.codigoTipoDocumento==null && other.getCodigoTipoDocumento()==null) || 
             (this.codigoTipoDocumento!=null &&
              this.codigoTipoDocumento.equals(other.getCodigoTipoDocumento()))) &&
            ((this.numeroDocumento==null && other.getNumeroDocumento()==null) || 
             (this.numeroDocumento!=null &&
              this.numeroDocumento.equals(other.getNumeroDocumento()))) &&
            ((this.importeGravado==null && other.getImporteGravado()==null) || 
             (this.importeGravado!=null &&
              this.importeGravado.equals(other.getImporteGravado()))) &&
            ((this.importeNoGravado==null && other.getImporteNoGravado()==null) || 
             (this.importeNoGravado!=null &&
              this.importeNoGravado.equals(other.getImporteNoGravado()))) &&
            ((this.importeExento==null && other.getImporteExento()==null) || 
             (this.importeExento!=null &&
              this.importeExento.equals(other.getImporteExento()))) &&
            ((this.importeSubtotal==null && other.getImporteSubtotal()==null) || 
             (this.importeSubtotal!=null &&
              this.importeSubtotal.equals(other.getImporteSubtotal()))) &&
            ((this.importeOtrosTributos==null && other.getImporteOtrosTributos()==null) || 
             (this.importeOtrosTributos!=null &&
              this.importeOtrosTributos.equals(other.getImporteOtrosTributos()))) &&
            ((this.importeTotal==null && other.getImporteTotal()==null) || 
             (this.importeTotal!=null &&
              this.importeTotal.equals(other.getImporteTotal()))) &&
            ((this.codigoMoneda==null && other.getCodigoMoneda()==null) || 
             (this.codigoMoneda!=null &&
              this.codigoMoneda.equals(other.getCodigoMoneda()))) &&
            ((this.cotizacionMoneda==null && other.getCotizacionMoneda()==null) || 
             (this.cotizacionMoneda!=null &&
              this.cotizacionMoneda.equals(other.getCotizacionMoneda()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            this.codigoConcepto == other.getCodigoConcepto() &&
            ((this.fechaServicioDesde==null && other.getFechaServicioDesde()==null) || 
             (this.fechaServicioDesde!=null &&
              this.fechaServicioDesde.equals(other.getFechaServicioDesde()))) &&
            ((this.fechaServicioHasta==null && other.getFechaServicioHasta()==null) || 
             (this.fechaServicioHasta!=null &&
              this.fechaServicioHasta.equals(other.getFechaServicioHasta()))) &&
            ((this.fechaVencimientoPago==null && other.getFechaVencimientoPago()==null) || 
             (this.fechaVencimientoPago!=null &&
              this.fechaVencimientoPago.equals(other.getFechaVencimientoPago()))) &&
            ((this.fechaHoraGen==null && other.getFechaHoraGen()==null) || 
             (this.fechaHoraGen!=null &&
              this.fechaHoraGen.equals(other.getFechaHoraGen()))) &&
            ((this.arrayComprobantesAsociados==null && other.getArrayComprobantesAsociados()==null) || 
             (this.arrayComprobantesAsociados!=null &&
              java.util.Arrays.equals(this.arrayComprobantesAsociados, other.getArrayComprobantesAsociados()))) &&
            ((this.arrayOtrosTributos==null && other.getArrayOtrosTributos()==null) || 
             (this.arrayOtrosTributos!=null &&
              java.util.Arrays.equals(this.arrayOtrosTributos, other.getArrayOtrosTributos()))) &&
            ((this.arrayItems==null && other.getArrayItems()==null) || 
             (this.arrayItems!=null &&
              java.util.Arrays.equals(this.arrayItems, other.getArrayItems()))) &&
            ((this.arraySubtotalesIVA==null && other.getArraySubtotalesIVA()==null) || 
             (this.arraySubtotalesIVA!=null &&
              java.util.Arrays.equals(this.arraySubtotalesIVA, other.getArraySubtotalesIVA()))) &&
            ((this.arrayDatosAdicionales==null && other.getArrayDatosAdicionales()==null) || 
             (this.arrayDatosAdicionales!=null &&
              java.util.Arrays.equals(this.arrayDatosAdicionales, other.getArrayDatosAdicionales()))) &&
            ((this.arrayCompradores==null && other.getArrayCompradores()==null) || 
             (this.arrayCompradores!=null &&
              java.util.Arrays.equals(this.arrayCompradores, other.getArrayCompradores())));
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
        _hashCode += getCodigoTipoComprobante();
        _hashCode += getNumeroPuntoVenta();
        _hashCode += new Long(getNumeroComprobante()).hashCode();
        if (getFechaEmision() != null) {
            _hashCode += getFechaEmision().hashCode();
        }
        if (getCodigoTipoAutorizacion() != null) {
            _hashCode += getCodigoTipoAutorizacion().hashCode();
        }
        if (getCodigoAutorizacion() != null) {
            _hashCode += getCodigoAutorizacion().hashCode();
        }
        if (getFechaVencimiento() != null) {
            _hashCode += getFechaVencimiento().hashCode();
        }
        if (getCodigoTipoDocumento() != null) {
            _hashCode += getCodigoTipoDocumento().hashCode();
        }
        if (getNumeroDocumento() != null) {
            _hashCode += getNumeroDocumento().hashCode();
        }
        if (getImporteGravado() != null) {
            _hashCode += getImporteGravado().hashCode();
        }
        if (getImporteNoGravado() != null) {
            _hashCode += getImporteNoGravado().hashCode();
        }
        if (getImporteExento() != null) {
            _hashCode += getImporteExento().hashCode();
        }
        if (getImporteSubtotal() != null) {
            _hashCode += getImporteSubtotal().hashCode();
        }
        if (getImporteOtrosTributos() != null) {
            _hashCode += getImporteOtrosTributos().hashCode();
        }
        if (getImporteTotal() != null) {
            _hashCode += getImporteTotal().hashCode();
        }
        if (getCodigoMoneda() != null) {
            _hashCode += getCodigoMoneda().hashCode();
        }
        if (getCotizacionMoneda() != null) {
            _hashCode += getCotizacionMoneda().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        _hashCode += getCodigoConcepto();
        if (getFechaServicioDesde() != null) {
            _hashCode += getFechaServicioDesde().hashCode();
        }
        if (getFechaServicioHasta() != null) {
            _hashCode += getFechaServicioHasta().hashCode();
        }
        if (getFechaVencimientoPago() != null) {
            _hashCode += getFechaVencimientoPago().hashCode();
        }
        if (getFechaHoraGen() != null) {
            _hashCode += getFechaHoraGen().hashCode();
        }
        if (getArrayComprobantesAsociados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayComprobantesAsociados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayComprobantesAsociados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayOtrosTributos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayOtrosTributos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayOtrosTributos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArraySubtotalesIVA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArraySubtotalesIVA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArraySubtotalesIVA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayDatosAdicionales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayDatosAdicionales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayDatosAdicionales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayCompradores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayCompradores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayCompradores(), i);
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
        new org.apache.axis.description.TypeDesc(ComprobanteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoTipoComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuntoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPuntoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEmision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaEmision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoTipoAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoTipoAutorizacionSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVencimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVencimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoTipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeGravado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeGravado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeNoGravado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeNoGravado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeExento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeExento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeSubtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeSubtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeOtrosTributos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeOtrosTributos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cotizacionMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cotizacionMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoConcepto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoConcepto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaServicioDesde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaServicioDesde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaServicioHasta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaServicioHasta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVencimientoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVencimientoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraGen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHoraGen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayComprobantesAsociados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayComprobantesAsociados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteAsociadoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "comprobanteAsociado"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOtrosTributos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayOtrosTributos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "OtroTributoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "otroTributo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ItemType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arraySubtotalesIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arraySubtotalesIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SubtotalIVAType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "subtotalIVA"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayDatosAdicionales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayDatosAdicionales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DatoAdicionalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "datoAdicional"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayCompradores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayCompradores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CompradorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "comprador"));
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
