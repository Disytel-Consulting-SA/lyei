/**
 * ComprobanteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ComprobanteType  implements java.io.Serializable {
    private long cuitEmisor;

    private java.lang.String razonSocialEmi;

    private short codTipoCmp;

    private int ptovta;

    private long nroCmp;

    private long cuitReceptor;

    private java.lang.String razonSocialRecep;

    private wsfecred.afip.gob.ar.FECredService.TipoCodAutorizacionType tipoCodAuto;

    private long codAutorizacion;

    private java.util.Date fechaEmision;

    private java.util.Date fechaPuestaDispo;

    private java.util.Date fechaVenPago;

    private java.util.Date fechaVenAcep;

    private java.math.BigDecimal importeTotal;

    private java.lang.String codMoneda;

    private java.math.BigDecimal cotizacionMoneda;

    private java.lang.String CBUEmisor;

    private java.lang.String aliasEmisor;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esAnulacion;

    private wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esPostAceptacion;

    private wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobanteAsociado;

    private java.lang.String[] referenciasComerciales;

    private wsfecred.afip.gob.ar.FECredService.SubtotalIVAType[] arraySubtotalesIVA;

    private wsfecred.afip.gob.ar.FECredService.OtroTributoType[] arrayOtrosTributos;

    private wsfecred.afip.gob.ar.FECredService.ItemType[] arrayItems;

    private java.lang.String datosGenerales;

    private java.lang.String datosComerciales;

    private java.lang.String leyendaComercial;

    private long codCtaCte;

    private wsfecred.afip.gob.ar.FECredService.EstadoCmpType estado;

    private wsfecred.afip.gob.ar.FECredService.TipoAceptacionSimpleType tipoAcep;

    private java.util.Calendar fechaHoraAcep;

    private wsfecred.afip.gob.ar.FECredService.MotivoRechazoType[] arrayMotivosRechazo;

    private wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia;

    private wsfecred.afip.gob.ar.FECredService.InfoTransferenciaType infoTransferencia;

    public ComprobanteType() {
    }

    public ComprobanteType(
           long cuitEmisor,
           java.lang.String razonSocialEmi,
           short codTipoCmp,
           int ptovta,
           long nroCmp,
           long cuitReceptor,
           java.lang.String razonSocialRecep,
           wsfecred.afip.gob.ar.FECredService.TipoCodAutorizacionType tipoCodAuto,
           long codAutorizacion,
           java.util.Date fechaEmision,
           java.util.Date fechaPuestaDispo,
           java.util.Date fechaVenPago,
           java.util.Date fechaVenAcep,
           java.math.BigDecimal importeTotal,
           java.lang.String codMoneda,
           java.math.BigDecimal cotizacionMoneda,
           java.lang.String CBUEmisor,
           java.lang.String aliasEmisor,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esAnulacion,
           wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esPostAceptacion,
           wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobanteAsociado,
           java.lang.String[] referenciasComerciales,
           wsfecred.afip.gob.ar.FECredService.SubtotalIVAType[] arraySubtotalesIVA,
           wsfecred.afip.gob.ar.FECredService.OtroTributoType[] arrayOtrosTributos,
           wsfecred.afip.gob.ar.FECredService.ItemType[] arrayItems,
           java.lang.String datosGenerales,
           java.lang.String datosComerciales,
           java.lang.String leyendaComercial,
           long codCtaCte,
           wsfecred.afip.gob.ar.FECredService.EstadoCmpType estado,
           wsfecred.afip.gob.ar.FECredService.TipoAceptacionSimpleType tipoAcep,
           java.util.Calendar fechaHoraAcep,
           wsfecred.afip.gob.ar.FECredService.MotivoRechazoType[] arrayMotivosRechazo,
           wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia,
           wsfecred.afip.gob.ar.FECredService.InfoTransferenciaType infoTransferencia) {
           this.cuitEmisor = cuitEmisor;
           this.razonSocialEmi = razonSocialEmi;
           this.codTipoCmp = codTipoCmp;
           this.ptovta = ptovta;
           this.nroCmp = nroCmp;
           this.cuitReceptor = cuitReceptor;
           this.razonSocialRecep = razonSocialRecep;
           this.tipoCodAuto = tipoCodAuto;
           this.codAutorizacion = codAutorizacion;
           this.fechaEmision = fechaEmision;
           this.fechaPuestaDispo = fechaPuestaDispo;
           this.fechaVenPago = fechaVenPago;
           this.fechaVenAcep = fechaVenAcep;
           this.importeTotal = importeTotal;
           this.codMoneda = codMoneda;
           this.cotizacionMoneda = cotizacionMoneda;
           this.CBUEmisor = CBUEmisor;
           this.aliasEmisor = aliasEmisor;
           this.esAnulacion = esAnulacion;
           this.esPostAceptacion = esPostAceptacion;
           this.idComprobanteAsociado = idComprobanteAsociado;
           this.referenciasComerciales = referenciasComerciales;
           this.arraySubtotalesIVA = arraySubtotalesIVA;
           this.arrayOtrosTributos = arrayOtrosTributos;
           this.arrayItems = arrayItems;
           this.datosGenerales = datosGenerales;
           this.datosComerciales = datosComerciales;
           this.leyendaComercial = leyendaComercial;
           this.codCtaCte = codCtaCte;
           this.estado = estado;
           this.tipoAcep = tipoAcep;
           this.fechaHoraAcep = fechaHoraAcep;
           this.arrayMotivosRechazo = arrayMotivosRechazo;
           this.opcionTransferencia = opcionTransferencia;
           this.infoTransferencia = infoTransferencia;
    }


    /**
     * Gets the cuitEmisor value for this ComprobanteType.
     * 
     * @return cuitEmisor
     */
    public long getCuitEmisor() {
        return cuitEmisor;
    }


    /**
     * Sets the cuitEmisor value for this ComprobanteType.
     * 
     * @param cuitEmisor
     */
    public void setCuitEmisor(long cuitEmisor) {
        this.cuitEmisor = cuitEmisor;
    }


    /**
     * Gets the razonSocialEmi value for this ComprobanteType.
     * 
     * @return razonSocialEmi
     */
    public java.lang.String getRazonSocialEmi() {
        return razonSocialEmi;
    }


    /**
     * Sets the razonSocialEmi value for this ComprobanteType.
     * 
     * @param razonSocialEmi
     */
    public void setRazonSocialEmi(java.lang.String razonSocialEmi) {
        this.razonSocialEmi = razonSocialEmi;
    }


    /**
     * Gets the codTipoCmp value for this ComprobanteType.
     * 
     * @return codTipoCmp
     */
    public short getCodTipoCmp() {
        return codTipoCmp;
    }


    /**
     * Sets the codTipoCmp value for this ComprobanteType.
     * 
     * @param codTipoCmp
     */
    public void setCodTipoCmp(short codTipoCmp) {
        this.codTipoCmp = codTipoCmp;
    }


    /**
     * Gets the ptovta value for this ComprobanteType.
     * 
     * @return ptovta
     */
    public int getPtovta() {
        return ptovta;
    }


    /**
     * Sets the ptovta value for this ComprobanteType.
     * 
     * @param ptovta
     */
    public void setPtovta(int ptovta) {
        this.ptovta = ptovta;
    }


    /**
     * Gets the nroCmp value for this ComprobanteType.
     * 
     * @return nroCmp
     */
    public long getNroCmp() {
        return nroCmp;
    }


    /**
     * Sets the nroCmp value for this ComprobanteType.
     * 
     * @param nroCmp
     */
    public void setNroCmp(long nroCmp) {
        this.nroCmp = nroCmp;
    }


    /**
     * Gets the cuitReceptor value for this ComprobanteType.
     * 
     * @return cuitReceptor
     */
    public long getCuitReceptor() {
        return cuitReceptor;
    }


    /**
     * Sets the cuitReceptor value for this ComprobanteType.
     * 
     * @param cuitReceptor
     */
    public void setCuitReceptor(long cuitReceptor) {
        this.cuitReceptor = cuitReceptor;
    }


    /**
     * Gets the razonSocialRecep value for this ComprobanteType.
     * 
     * @return razonSocialRecep
     */
    public java.lang.String getRazonSocialRecep() {
        return razonSocialRecep;
    }


    /**
     * Sets the razonSocialRecep value for this ComprobanteType.
     * 
     * @param razonSocialRecep
     */
    public void setRazonSocialRecep(java.lang.String razonSocialRecep) {
        this.razonSocialRecep = razonSocialRecep;
    }


    /**
     * Gets the tipoCodAuto value for this ComprobanteType.
     * 
     * @return tipoCodAuto
     */
    public wsfecred.afip.gob.ar.FECredService.TipoCodAutorizacionType getTipoCodAuto() {
        return tipoCodAuto;
    }


    /**
     * Sets the tipoCodAuto value for this ComprobanteType.
     * 
     * @param tipoCodAuto
     */
    public void setTipoCodAuto(wsfecred.afip.gob.ar.FECredService.TipoCodAutorizacionType tipoCodAuto) {
        this.tipoCodAuto = tipoCodAuto;
    }


    /**
     * Gets the codAutorizacion value for this ComprobanteType.
     * 
     * @return codAutorizacion
     */
    public long getCodAutorizacion() {
        return codAutorizacion;
    }


    /**
     * Sets the codAutorizacion value for this ComprobanteType.
     * 
     * @param codAutorizacion
     */
    public void setCodAutorizacion(long codAutorizacion) {
        this.codAutorizacion = codAutorizacion;
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
     * Gets the fechaPuestaDispo value for this ComprobanteType.
     * 
     * @return fechaPuestaDispo
     */
    public java.util.Date getFechaPuestaDispo() {
        return fechaPuestaDispo;
    }


    /**
     * Sets the fechaPuestaDispo value for this ComprobanteType.
     * 
     * @param fechaPuestaDispo
     */
    public void setFechaPuestaDispo(java.util.Date fechaPuestaDispo) {
        this.fechaPuestaDispo = fechaPuestaDispo;
    }


    /**
     * Gets the fechaVenPago value for this ComprobanteType.
     * 
     * @return fechaVenPago
     */
    public java.util.Date getFechaVenPago() {
        return fechaVenPago;
    }


    /**
     * Sets the fechaVenPago value for this ComprobanteType.
     * 
     * @param fechaVenPago
     */
    public void setFechaVenPago(java.util.Date fechaVenPago) {
        this.fechaVenPago = fechaVenPago;
    }


    /**
     * Gets the fechaVenAcep value for this ComprobanteType.
     * 
     * @return fechaVenAcep
     */
    public java.util.Date getFechaVenAcep() {
        return fechaVenAcep;
    }


    /**
     * Sets the fechaVenAcep value for this ComprobanteType.
     * 
     * @param fechaVenAcep
     */
    public void setFechaVenAcep(java.util.Date fechaVenAcep) {
        this.fechaVenAcep = fechaVenAcep;
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
     * Gets the codMoneda value for this ComprobanteType.
     * 
     * @return codMoneda
     */
    public java.lang.String getCodMoneda() {
        return codMoneda;
    }


    /**
     * Sets the codMoneda value for this ComprobanteType.
     * 
     * @param codMoneda
     */
    public void setCodMoneda(java.lang.String codMoneda) {
        this.codMoneda = codMoneda;
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
     * Gets the CBUEmisor value for this ComprobanteType.
     * 
     * @return CBUEmisor
     */
    public java.lang.String getCBUEmisor() {
        return CBUEmisor;
    }


    /**
     * Sets the CBUEmisor value for this ComprobanteType.
     * 
     * @param CBUEmisor
     */
    public void setCBUEmisor(java.lang.String CBUEmisor) {
        this.CBUEmisor = CBUEmisor;
    }


    /**
     * Gets the aliasEmisor value for this ComprobanteType.
     * 
     * @return aliasEmisor
     */
    public java.lang.String getAliasEmisor() {
        return aliasEmisor;
    }


    /**
     * Sets the aliasEmisor value for this ComprobanteType.
     * 
     * @param aliasEmisor
     */
    public void setAliasEmisor(java.lang.String aliasEmisor) {
        this.aliasEmisor = aliasEmisor;
    }


    /**
     * Gets the esAnulacion value for this ComprobanteType.
     * 
     * @return esAnulacion
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getEsAnulacion() {
        return esAnulacion;
    }


    /**
     * Sets the esAnulacion value for this ComprobanteType.
     * 
     * @param esAnulacion
     */
    public void setEsAnulacion(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esAnulacion) {
        this.esAnulacion = esAnulacion;
    }


    /**
     * Gets the esPostAceptacion value for this ComprobanteType.
     * 
     * @return esPostAceptacion
     */
    public wsfecred.afip.gob.ar.FECredService.SiNoSimpleType getEsPostAceptacion() {
        return esPostAceptacion;
    }


    /**
     * Sets the esPostAceptacion value for this ComprobanteType.
     * 
     * @param esPostAceptacion
     */
    public void setEsPostAceptacion(wsfecred.afip.gob.ar.FECredService.SiNoSimpleType esPostAceptacion) {
        this.esPostAceptacion = esPostAceptacion;
    }


    /**
     * Gets the idComprobanteAsociado value for this ComprobanteType.
     * 
     * @return idComprobanteAsociado
     */
    public wsfecred.afip.gob.ar.FECredService.IdComprobanteType getIdComprobanteAsociado() {
        return idComprobanteAsociado;
    }


    /**
     * Sets the idComprobanteAsociado value for this ComprobanteType.
     * 
     * @param idComprobanteAsociado
     */
    public void setIdComprobanteAsociado(wsfecred.afip.gob.ar.FECredService.IdComprobanteType idComprobanteAsociado) {
        this.idComprobanteAsociado = idComprobanteAsociado;
    }


    /**
     * Gets the referenciasComerciales value for this ComprobanteType.
     * 
     * @return referenciasComerciales
     */
    public java.lang.String[] getReferenciasComerciales() {
        return referenciasComerciales;
    }


    /**
     * Sets the referenciasComerciales value for this ComprobanteType.
     * 
     * @param referenciasComerciales
     */
    public void setReferenciasComerciales(java.lang.String[] referenciasComerciales) {
        this.referenciasComerciales = referenciasComerciales;
    }


    /**
     * Gets the arraySubtotalesIVA value for this ComprobanteType.
     * 
     * @return arraySubtotalesIVA
     */
    public wsfecred.afip.gob.ar.FECredService.SubtotalIVAType[] getArraySubtotalesIVA() {
        return arraySubtotalesIVA;
    }


    /**
     * Sets the arraySubtotalesIVA value for this ComprobanteType.
     * 
     * @param arraySubtotalesIVA
     */
    public void setArraySubtotalesIVA(wsfecred.afip.gob.ar.FECredService.SubtotalIVAType[] arraySubtotalesIVA) {
        this.arraySubtotalesIVA = arraySubtotalesIVA;
    }


    /**
     * Gets the arrayOtrosTributos value for this ComprobanteType.
     * 
     * @return arrayOtrosTributos
     */
    public wsfecred.afip.gob.ar.FECredService.OtroTributoType[] getArrayOtrosTributos() {
        return arrayOtrosTributos;
    }


    /**
     * Sets the arrayOtrosTributos value for this ComprobanteType.
     * 
     * @param arrayOtrosTributos
     */
    public void setArrayOtrosTributos(wsfecred.afip.gob.ar.FECredService.OtroTributoType[] arrayOtrosTributos) {
        this.arrayOtrosTributos = arrayOtrosTributos;
    }


    /**
     * Gets the arrayItems value for this ComprobanteType.
     * 
     * @return arrayItems
     */
    public wsfecred.afip.gob.ar.FECredService.ItemType[] getArrayItems() {
        return arrayItems;
    }


    /**
     * Sets the arrayItems value for this ComprobanteType.
     * 
     * @param arrayItems
     */
    public void setArrayItems(wsfecred.afip.gob.ar.FECredService.ItemType[] arrayItems) {
        this.arrayItems = arrayItems;
    }


    /**
     * Gets the datosGenerales value for this ComprobanteType.
     * 
     * @return datosGenerales
     */
    public java.lang.String getDatosGenerales() {
        return datosGenerales;
    }


    /**
     * Sets the datosGenerales value for this ComprobanteType.
     * 
     * @param datosGenerales
     */
    public void setDatosGenerales(java.lang.String datosGenerales) {
        this.datosGenerales = datosGenerales;
    }


    /**
     * Gets the datosComerciales value for this ComprobanteType.
     * 
     * @return datosComerciales
     */
    public java.lang.String getDatosComerciales() {
        return datosComerciales;
    }


    /**
     * Sets the datosComerciales value for this ComprobanteType.
     * 
     * @param datosComerciales
     */
    public void setDatosComerciales(java.lang.String datosComerciales) {
        this.datosComerciales = datosComerciales;
    }


    /**
     * Gets the leyendaComercial value for this ComprobanteType.
     * 
     * @return leyendaComercial
     */
    public java.lang.String getLeyendaComercial() {
        return leyendaComercial;
    }


    /**
     * Sets the leyendaComercial value for this ComprobanteType.
     * 
     * @param leyendaComercial
     */
    public void setLeyendaComercial(java.lang.String leyendaComercial) {
        this.leyendaComercial = leyendaComercial;
    }


    /**
     * Gets the codCtaCte value for this ComprobanteType.
     * 
     * @return codCtaCte
     */
    public long getCodCtaCte() {
        return codCtaCte;
    }


    /**
     * Sets the codCtaCte value for this ComprobanteType.
     * 
     * @param codCtaCte
     */
    public void setCodCtaCte(long codCtaCte) {
        this.codCtaCte = codCtaCte;
    }


    /**
     * Gets the estado value for this ComprobanteType.
     * 
     * @return estado
     */
    public wsfecred.afip.gob.ar.FECredService.EstadoCmpType getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ComprobanteType.
     * 
     * @param estado
     */
    public void setEstado(wsfecred.afip.gob.ar.FECredService.EstadoCmpType estado) {
        this.estado = estado;
    }


    /**
     * Gets the tipoAcep value for this ComprobanteType.
     * 
     * @return tipoAcep
     */
    public wsfecred.afip.gob.ar.FECredService.TipoAceptacionSimpleType getTipoAcep() {
        return tipoAcep;
    }


    /**
     * Sets the tipoAcep value for this ComprobanteType.
     * 
     * @param tipoAcep
     */
    public void setTipoAcep(wsfecred.afip.gob.ar.FECredService.TipoAceptacionSimpleType tipoAcep) {
        this.tipoAcep = tipoAcep;
    }


    /**
     * Gets the fechaHoraAcep value for this ComprobanteType.
     * 
     * @return fechaHoraAcep
     */
    public java.util.Calendar getFechaHoraAcep() {
        return fechaHoraAcep;
    }


    /**
     * Sets the fechaHoraAcep value for this ComprobanteType.
     * 
     * @param fechaHoraAcep
     */
    public void setFechaHoraAcep(java.util.Calendar fechaHoraAcep) {
        this.fechaHoraAcep = fechaHoraAcep;
    }


    /**
     * Gets the arrayMotivosRechazo value for this ComprobanteType.
     * 
     * @return arrayMotivosRechazo
     */
    public wsfecred.afip.gob.ar.FECredService.MotivoRechazoType[] getArrayMotivosRechazo() {
        return arrayMotivosRechazo;
    }


    /**
     * Sets the arrayMotivosRechazo value for this ComprobanteType.
     * 
     * @param arrayMotivosRechazo
     */
    public void setArrayMotivosRechazo(wsfecred.afip.gob.ar.FECredService.MotivoRechazoType[] arrayMotivosRechazo) {
        this.arrayMotivosRechazo = arrayMotivosRechazo;
    }


    /**
     * Gets the opcionTransferencia value for this ComprobanteType.
     * 
     * @return opcionTransferencia
     */
    public wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType getOpcionTransferencia() {
        return opcionTransferencia;
    }


    /**
     * Sets the opcionTransferencia value for this ComprobanteType.
     * 
     * @param opcionTransferencia
     */
    public void setOpcionTransferencia(wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType opcionTransferencia) {
        this.opcionTransferencia = opcionTransferencia;
    }


    /**
     * Gets the infoTransferencia value for this ComprobanteType.
     * 
     * @return infoTransferencia
     */
    public wsfecred.afip.gob.ar.FECredService.InfoTransferenciaType getInfoTransferencia() {
        return infoTransferencia;
    }


    /**
     * Sets the infoTransferencia value for this ComprobanteType.
     * 
     * @param infoTransferencia
     */
    public void setInfoTransferencia(wsfecred.afip.gob.ar.FECredService.InfoTransferenciaType infoTransferencia) {
        this.infoTransferencia = infoTransferencia;
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
            this.cuitEmisor == other.getCuitEmisor() &&
            ((this.razonSocialEmi==null && other.getRazonSocialEmi()==null) || 
             (this.razonSocialEmi!=null &&
              this.razonSocialEmi.equals(other.getRazonSocialEmi()))) &&
            this.codTipoCmp == other.getCodTipoCmp() &&
            this.ptovta == other.getPtovta() &&
            this.nroCmp == other.getNroCmp() &&
            this.cuitReceptor == other.getCuitReceptor() &&
            ((this.razonSocialRecep==null && other.getRazonSocialRecep()==null) || 
             (this.razonSocialRecep!=null &&
              this.razonSocialRecep.equals(other.getRazonSocialRecep()))) &&
            ((this.tipoCodAuto==null && other.getTipoCodAuto()==null) || 
             (this.tipoCodAuto!=null &&
              this.tipoCodAuto.equals(other.getTipoCodAuto()))) &&
            this.codAutorizacion == other.getCodAutorizacion() &&
            ((this.fechaEmision==null && other.getFechaEmision()==null) || 
             (this.fechaEmision!=null &&
              this.fechaEmision.equals(other.getFechaEmision()))) &&
            ((this.fechaPuestaDispo==null && other.getFechaPuestaDispo()==null) || 
             (this.fechaPuestaDispo!=null &&
              this.fechaPuestaDispo.equals(other.getFechaPuestaDispo()))) &&
            ((this.fechaVenPago==null && other.getFechaVenPago()==null) || 
             (this.fechaVenPago!=null &&
              this.fechaVenPago.equals(other.getFechaVenPago()))) &&
            ((this.fechaVenAcep==null && other.getFechaVenAcep()==null) || 
             (this.fechaVenAcep!=null &&
              this.fechaVenAcep.equals(other.getFechaVenAcep()))) &&
            ((this.importeTotal==null && other.getImporteTotal()==null) || 
             (this.importeTotal!=null &&
              this.importeTotal.equals(other.getImporteTotal()))) &&
            ((this.codMoneda==null && other.getCodMoneda()==null) || 
             (this.codMoneda!=null &&
              this.codMoneda.equals(other.getCodMoneda()))) &&
            ((this.cotizacionMoneda==null && other.getCotizacionMoneda()==null) || 
             (this.cotizacionMoneda!=null &&
              this.cotizacionMoneda.equals(other.getCotizacionMoneda()))) &&
            ((this.CBUEmisor==null && other.getCBUEmisor()==null) || 
             (this.CBUEmisor!=null &&
              this.CBUEmisor.equals(other.getCBUEmisor()))) &&
            ((this.aliasEmisor==null && other.getAliasEmisor()==null) || 
             (this.aliasEmisor!=null &&
              this.aliasEmisor.equals(other.getAliasEmisor()))) &&
            ((this.esAnulacion==null && other.getEsAnulacion()==null) || 
             (this.esAnulacion!=null &&
              this.esAnulacion.equals(other.getEsAnulacion()))) &&
            ((this.esPostAceptacion==null && other.getEsPostAceptacion()==null) || 
             (this.esPostAceptacion!=null &&
              this.esPostAceptacion.equals(other.getEsPostAceptacion()))) &&
            ((this.idComprobanteAsociado==null && other.getIdComprobanteAsociado()==null) || 
             (this.idComprobanteAsociado!=null &&
              this.idComprobanteAsociado.equals(other.getIdComprobanteAsociado()))) &&
            ((this.referenciasComerciales==null && other.getReferenciasComerciales()==null) || 
             (this.referenciasComerciales!=null &&
              java.util.Arrays.equals(this.referenciasComerciales, other.getReferenciasComerciales()))) &&
            ((this.arraySubtotalesIVA==null && other.getArraySubtotalesIVA()==null) || 
             (this.arraySubtotalesIVA!=null &&
              java.util.Arrays.equals(this.arraySubtotalesIVA, other.getArraySubtotalesIVA()))) &&
            ((this.arrayOtrosTributos==null && other.getArrayOtrosTributos()==null) || 
             (this.arrayOtrosTributos!=null &&
              java.util.Arrays.equals(this.arrayOtrosTributos, other.getArrayOtrosTributos()))) &&
            ((this.arrayItems==null && other.getArrayItems()==null) || 
             (this.arrayItems!=null &&
              java.util.Arrays.equals(this.arrayItems, other.getArrayItems()))) &&
            ((this.datosGenerales==null && other.getDatosGenerales()==null) || 
             (this.datosGenerales!=null &&
              this.datosGenerales.equals(other.getDatosGenerales()))) &&
            ((this.datosComerciales==null && other.getDatosComerciales()==null) || 
             (this.datosComerciales!=null &&
              this.datosComerciales.equals(other.getDatosComerciales()))) &&
            ((this.leyendaComercial==null && other.getLeyendaComercial()==null) || 
             (this.leyendaComercial!=null &&
              this.leyendaComercial.equals(other.getLeyendaComercial()))) &&
            this.codCtaCte == other.getCodCtaCte() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.tipoAcep==null && other.getTipoAcep()==null) || 
             (this.tipoAcep!=null &&
              this.tipoAcep.equals(other.getTipoAcep()))) &&
            ((this.fechaHoraAcep==null && other.getFechaHoraAcep()==null) || 
             (this.fechaHoraAcep!=null &&
              this.fechaHoraAcep.equals(other.getFechaHoraAcep()))) &&
            ((this.arrayMotivosRechazo==null && other.getArrayMotivosRechazo()==null) || 
             (this.arrayMotivosRechazo!=null &&
              java.util.Arrays.equals(this.arrayMotivosRechazo, other.getArrayMotivosRechazo()))) &&
            ((this.opcionTransferencia==null && other.getOpcionTransferencia()==null) || 
             (this.opcionTransferencia!=null &&
              this.opcionTransferencia.equals(other.getOpcionTransferencia()))) &&
            ((this.infoTransferencia==null && other.getInfoTransferencia()==null) || 
             (this.infoTransferencia!=null &&
              this.infoTransferencia.equals(other.getInfoTransferencia())));
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
        _hashCode += new Long(getCuitEmisor()).hashCode();
        if (getRazonSocialEmi() != null) {
            _hashCode += getRazonSocialEmi().hashCode();
        }
        _hashCode += getCodTipoCmp();
        _hashCode += getPtovta();
        _hashCode += new Long(getNroCmp()).hashCode();
        _hashCode += new Long(getCuitReceptor()).hashCode();
        if (getRazonSocialRecep() != null) {
            _hashCode += getRazonSocialRecep().hashCode();
        }
        if (getTipoCodAuto() != null) {
            _hashCode += getTipoCodAuto().hashCode();
        }
        _hashCode += new Long(getCodAutorizacion()).hashCode();
        if (getFechaEmision() != null) {
            _hashCode += getFechaEmision().hashCode();
        }
        if (getFechaPuestaDispo() != null) {
            _hashCode += getFechaPuestaDispo().hashCode();
        }
        if (getFechaVenPago() != null) {
            _hashCode += getFechaVenPago().hashCode();
        }
        if (getFechaVenAcep() != null) {
            _hashCode += getFechaVenAcep().hashCode();
        }
        if (getImporteTotal() != null) {
            _hashCode += getImporteTotal().hashCode();
        }
        if (getCodMoneda() != null) {
            _hashCode += getCodMoneda().hashCode();
        }
        if (getCotizacionMoneda() != null) {
            _hashCode += getCotizacionMoneda().hashCode();
        }
        if (getCBUEmisor() != null) {
            _hashCode += getCBUEmisor().hashCode();
        }
        if (getAliasEmisor() != null) {
            _hashCode += getAliasEmisor().hashCode();
        }
        if (getEsAnulacion() != null) {
            _hashCode += getEsAnulacion().hashCode();
        }
        if (getEsPostAceptacion() != null) {
            _hashCode += getEsPostAceptacion().hashCode();
        }
        if (getIdComprobanteAsociado() != null) {
            _hashCode += getIdComprobanteAsociado().hashCode();
        }
        if (getReferenciasComerciales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReferenciasComerciales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReferenciasComerciales(), i);
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
        if (getDatosGenerales() != null) {
            _hashCode += getDatosGenerales().hashCode();
        }
        if (getDatosComerciales() != null) {
            _hashCode += getDatosComerciales().hashCode();
        }
        if (getLeyendaComercial() != null) {
            _hashCode += getLeyendaComercial().hashCode();
        }
        _hashCode += new Long(getCodCtaCte()).hashCode();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getTipoAcep() != null) {
            _hashCode += getTipoAcep().hashCode();
        }
        if (getFechaHoraAcep() != null) {
            _hashCode += getFechaHoraAcep().hashCode();
        }
        if (getArrayMotivosRechazo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayMotivosRechazo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayMotivosRechazo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOpcionTransferencia() != null) {
            _hashCode += getOpcionTransferencia().hashCode();
        }
        if (getInfoTransferencia() != null) {
            _hashCode += getInfoTransferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComprobanteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuitEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuitEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialEmi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razonSocialEmi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codTipoCmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codTipoCmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptovta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptovta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroCmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nroCmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuitReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuitReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razonSocialRecep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razonSocialRecep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCodAuto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoCodAuto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoCodAutorizacionType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaEmision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaEmision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPuestaDispo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPuestaDispo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVenPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVenPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVenAcep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVenAcep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
        elemField.setFieldName("codMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codMoneda"));
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
        elemField.setFieldName("CBUEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CBUEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aliasEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AliasEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esAnulacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "esAnulacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esPostAceptacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "esPostAceptacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idComprobanteAsociado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idComprobanteAsociado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenciasComerciales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referenciasComerciales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "Texto250SimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "texto"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arraySubtotalesIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arraySubtotalesIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SubtotalIVAType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "subtotalIVA"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayOtrosTributos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayOtrosTributos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OtroTributoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "otroTributo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ItemType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosGenerales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datosGenerales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosComerciales");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datosComerciales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leyendaComercial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leyendaComercial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCtaCte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codCtaCte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAcep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAcep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoAceptacionSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraAcep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHoraAcep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayMotivosRechazo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayMotivosRechazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "MotivoRechazoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "motivoRechazo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opcionTransferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opcionTransferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OpcionTransferenciaSimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoTransferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoTransferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoTransferenciaType"));
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
