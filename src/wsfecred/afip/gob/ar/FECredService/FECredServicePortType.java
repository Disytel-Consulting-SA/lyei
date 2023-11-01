/**
 * FECredServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public interface FECredServicePortType extends java.rmi.Remote {

    /**
     * Metodo dummy.
     */
    public wsfecred.afip.gob.ar.FECredService.DummyResponseType dummy() throws java.rmi.RemoteException;

    /**
     * Método que permite obtener información sobre los comprobates
     * Emitidos y Recibidos.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType consultarComprobantes(wsfecred.afip.gob.ar.FECredService.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite al Comprador rechazar Notas de Débito /
     * Crédito individualmente para
     * 				desafectarlas del cálculo del saldo de la Cta. Cte. vinculada.
     */
    public wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType rechazarNotaDC(wsfecred.afip.gob.ar.FECredService.RechazarNotaDCRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite obtener las cuentas corrientes que fueron
     * generadas a partir de la
     * 				facturación, que coinciden con los parámetros de búsqueda.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType consultarCtasCtes(wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite obtener el detalle y composición de una
     * cuenta corriente.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType consultarCtaCte(wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método por el cual el Comprador informa que le ha cancelado
     * (pagado) totalmente la deuda al
     * 				vendedor, debiendo indicar la forma de pago.Solo puede cancelar
     * las aceptadas dentros de los plazos establecidos
     */
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType informarCancelacionTotalFECred(wsfecred.afip.gob.ar.FECredService.InformarCancelacionTotalFECredRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite al Comprador Aceptar el saldo actual de
     * la Cta. Cte. de una Factura de Crédito
     * 				pudiendo indicar: pagos parciales, retenciones y/o embargos.
     */
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType aceptarFECred(wsfecred.afip.gob.ar.FECredService.AceptarFECredRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite al Comprador Rechazar la Cta. Cte. de una
     * Factura de Crédito debiendo indicar
     * 				el motivo del rechazo.
     */
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType rechazarFECred(wsfecred.afip.gob.ar.FECredService.RechazarFECredRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite al Vendedor solicitar la transeferencia
     * (al Agente de Depósito Colectivo) de
     * 				la factura de crédito con el saldo resultante de la cuenta corriente
     * vinculada aceptada por el comprador, debiendo
     * 				indicar la Cuenta del Agente de Deposito Colectivo.
     */
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType informarFacturaAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.InformarFacturaAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite obtener información sobre las transeferencias
     * realizadas al Agente de Depósito
     * 				Colectivo.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType consultarFacturasAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite al Vendedor consultar sus cuentas en sus
     * Agentes de Deposito Colectivo
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType consultarCuentasEnAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite a partir de una CUIT conocer su obligación
     * respecto a la emisión o recepción
     * 				de facturas de créditos
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType consultarObligadoRecepcion(wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite consultar los tipos de retenciones habilitadas
     * con sus respectivos porcentajes.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType consultarTiposRetenciones(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite listar los tipos de  motivos de rechazo
     * habilitados para una cta. cte.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposMotivosRechazo(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException;

    /**
     * Método que permite listar los tipos de formas de pago habilitados
     * para una factura de crédito.
     */
    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposFormasCancelacion(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType obtenerRemitos(wsfecred.afip.gob.ar.FECredService.ObtenerRemitosRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType consultarHistorialEstadosComprobante(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType consultarHistorialEstadosCtaCte(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposAjustesOperacion(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType consultarMontoObligadoRecepcion(wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionRequestType parameters) throws java.rmi.RemoteException;
    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType modificarOpcionTransferencia(wsfecred.afip.gob.ar.FECredService.ModificarOpcionTransferenciaRequestType parameters) throws java.rmi.RemoteException;
}
