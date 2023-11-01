/**
 * FECredServiceSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class FECredServiceSOAPStub extends org.apache.axis.client.Stub implements wsfecred.afip.gob.ar.FECredService.FECredServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[21];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("dummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DummyResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.DummyResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "dummyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarComprobantes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarComprobantesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarComprobanteRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarComprobantesResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarComprobantesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("rechazarFECred");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "rechazarFECredRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarFECredRequestType"), wsfecred.afip.gob.ar.FECredService.RechazarFECredRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "rechazarFECredResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCtasCtes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCtasCtesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCtasCtesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("rechazarNotaDC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "rechazarNotaDCRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarNotaDCRequestType"), wsfecred.afip.gob.ar.FECredService.RechazarNotaDCRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarNotaDCResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "rechazarNotaDCResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarFacturaAgtDptoCltv");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "informarFacturaAgtDptoCltvRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InformarFacturaAgtDptoCltvRequestType"), wsfecred.afip.gob.ar.FECredService.InformarFacturaAgtDptoCltvRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "informarFacturaAgtDptoCltvResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposRetenciones");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposRetencionesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposRetencionesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarObligadoRecepcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarFacturasAgtDptoCltv");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarFacturasAgtDptoCltvRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarFacturasAgtDptoCltvRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarFacturasAgtDptoCltvResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarFacturasAgtDptoCltvResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarCancelacionTotalFECred");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "informarCancelacionTotalFECredRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InformarCancelacionTotalFECredRequestType"), wsfecred.afip.gob.ar.FECredService.InformarCancelacionTotalFECredRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "informarCancelacionTotalFECredResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposMotivosRechazo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposMotivosRechazoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposMotivosRechazoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposFormasCancelacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposFormasCancelacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposFormasCancelacionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aceptarFECred");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "aceptarFECredRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AceptarFECredRequestType"), wsfecred.afip.gob.ar.FECredService.AceptarFECredRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "aceptarFECredResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCtaCte");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCtaCteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCtaCteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCuentasEnAgtDptoCltv");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCuentasEnAgtDptoCltvRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCuentasEnAgtDptoCltvRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCuentasEnAgtDptoCltvResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCuentasEnAgtDptoCltvResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerRemitos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "obtenerRemitosRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ObtenerRemitosRequestType"), wsfecred.afip.gob.ar.FECredService.ObtenerRemitosRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ObtenerRemitosResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "obtenerRemitosResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarHistorialEstadosComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarHistorialEstadosCtaCte");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosCtaCteRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposAjustesOperacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposAjustesOperacionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarTiposAjustesOperacionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarMontoObligadoRecepcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarMontoObligadoRecepcionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionRequestType"), wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarMontoObligadoRecepcionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modificarOpcionTransferencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "modificarOpcionTransferenciaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ModificarOpcionTransferenciaRequestType"), wsfecred.afip.gob.ar.FECredService.ModificarOpcionTransferenciaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType"));
        oper.setReturnClass(wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "modificarOpcionTransferenciaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

    }

    public FECredServiceSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public FECredServiceSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public FECredServiceSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AceptarFECredRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.AceptarFECredRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AjusteOperacionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.AjusteOperacionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayAjustesOperacionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.AjusteOperacionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AjusteOperacionType");
            qName2 = new javax.xml.namespace.QName("", "ajuste");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayCodigosDescripcionesStringType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionStringType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcionString");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayCodigosDescripcionesType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayComprobantesType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ComprobanteType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType");
            qName2 = new javax.xml.namespace.QName("", "comprobante");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayConfirmarNotasType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConfirmarNotaDCType");
            qName2 = new javax.xml.namespace.QName("", "confirmarNota");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayCuentasEnAgenteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaEnAgenteType");
            qName2 = new javax.xml.namespace.QName("", "cuentaEnAgente");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayFacturasAgtDptoCltvType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.FacturaInformadaAgtDptoCltvType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FacturaInformadaAgtDptoCltvType");
            qName2 = new javax.xml.namespace.QName("", "facturaInformada");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayHistorialEstadosComprobanteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCmpType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpType");
            qName2 = new javax.xml.namespace.QName("", "estadoHistorico");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayHistorialEstadosCtaCteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteType");
            qName2 = new javax.xml.namespace.QName("", "estadoHistorico");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayIdsComprobantesType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.IdComprobanteType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType");
            qName2 = new javax.xml.namespace.QName("", "idsComprobantes");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayInfosCtaCteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InfoCtaCteType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoCtaCteType");
            qName2 = new javax.xml.namespace.QName("", "infoCtaCte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayItemsType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ItemType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ItemType");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayMotivosRechazoType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.MotivoRechazoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "MotivoRechazoType");
            qName2 = new javax.xml.namespace.QName("", "motivoRechazo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayOtrosTributosType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.OtroTributoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OtroTributoType");
            qName2 = new javax.xml.namespace.QName("", "otroTributo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayRetencionesType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RetencionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RetencionType");
            qName2 = new javax.xml.namespace.QName("", "retencion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArraySubtotalesIVAType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.SubtotalIVAType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SubtotalIVAType");
            qName2 = new javax.xml.namespace.QName("", "subtotalIVA");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayTexto250SimpleType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "Texto250SimpleType");
            qName2 = new javax.xml.namespace.QName("", "texto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ArrayTiposRetencionesType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoRetencionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoRetencionType");
            qName2 = new javax.xml.namespace.QName("", "tipoRetencion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "AuthRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.AuthRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CBUSimpleType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionStringType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CodigoDescripcionStringType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CodigoDescripcionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CodigoDescripcionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ComprobanteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ComprobanteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConfirmarNotaDCType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConfirmarNotaDCType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCmpReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCmpReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCodigoDescripcionReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarComprobantesResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtaCteReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCtasCtesReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCuentasEnAgtDptoCltvRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarCuentasEnAgtDptoCltvResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarCuentasEnAgtDptoCltvReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarFacturasAgtDptoCltvRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarFacturasAgtDptoCltvResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarFacturasAgtDptoCltvReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosComprobanteReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarHistorialEstadosCtaCteRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarHistorialEstadosCtaCteReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarMontoObligadoRecepcionReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "consultarObligadoRecepcionReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ConsultarTiposRetencionesReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaCorrienteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CuentaCorrienteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuentaEnAgenteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.CuentaEnAgenteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "CuitSimpleType");
            cachedSerQNames.add(qName);
            cls = long.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DecimalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DummyResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.DummyResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "DummyReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.DummyReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCmpSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCmpType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCtaCteSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCtaCteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.EstadoCtaCteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FacturaInformadaAgtDptoCltvType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.FacturaInformadaAgtDptoCltvType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FiltroFechaType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.FiltroFechaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.IdComprobanteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdCtaCteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.IdCtaCteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdCuentaAgenteSimpleType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ImporteSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoAgtDptoCltvType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoCtaCteType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InfoCtaCteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InformarCancelacionTotalFECredRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InformarCancelacionTotalFECredRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InformarFacturaAgtDptoCltvRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InformarFacturaAgtDptoCltvRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoSCAType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InfoSCAType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoTransferenciaType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.InfoTransferenciaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ItemType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ItemType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ModificarOpcionTransferenciaRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ModificarOpcionTransferenciaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "MotivoRechazoType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.MotivoRechazoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "NumeroComprobanteSimpleType");
            cachedSerQNames.add(qName);
            cls = long.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ObtenerRemitosRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ObtenerRemitosRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ObtenerRemitosResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ObtenerRemitosReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ObtenerRemitosReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OpcionTransferenciaSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.OpcionTransferenciaSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OperacionFECredReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.OperacionFECredReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "OtroTributoType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.OtroTributoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "PorcentajeSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "PuntoVentaSimpleType");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarFECredRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RechazarFECredRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarNotaDCRequestType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RechazarNotaDCRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarNotaDCResponseType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RechazarNotaDCReturnType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RechazarNotaDCReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ResultadoSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.ResultadoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RetencionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RetencionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "RolSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.RolSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SiNoSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.SiNoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "SubtotalIVAType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.SubtotalIVAType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "Texto250SimpleType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoAceptacionSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoAceptacionSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoCancelacionSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoCancelacionSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoCodAutorizacionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoCodAutorizacionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoFechaSimpleType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoFechaSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoRetencionType");
            cachedSerQNames.add(qName);
            cls = wsfecred.afip.gob.ar.FECredService.TipoRetencionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public wsfecred.afip.gob.ar.FECredService.DummyResponseType dummy() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/dummy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "dummy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.DummyResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.DummyResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.DummyResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType consultarComprobantes(wsfecred.afip.gob.ar.FECredService.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarComprobantes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarComprobantes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarComprobantesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType rechazarFECred(wsfecred.afip.gob.ar.FECredService.RechazarFECredRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/rechazarFECred");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "rechazarFECred"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType consultarCtasCtes(wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarCtasCtes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCtasCtes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCtasCtesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType rechazarNotaDC(wsfecred.afip.gob.ar.FECredService.RechazarNotaDCRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/rechazarNotaDC");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "rechazarNotaDC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.RechazarNotaDCResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType informarFacturaAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.InformarFacturaAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/informarFacturaAgtDptoCltv");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarFacturaAgtDptoCltv"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType consultarTiposRetenciones(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarTiposRetenciones");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposRetenciones"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarTiposRetencionesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType consultarObligadoRecepcion(wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarObligadoRecepcion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarObligadoRecepcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarObligadoRecepcionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType consultarFacturasAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarFacturasAgtDptoCltv");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarFacturasAgtDptoCltv"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarFacturasAgtDptoCltvResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType informarCancelacionTotalFECred(wsfecred.afip.gob.ar.FECredService.InformarCancelacionTotalFECredRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/informarCancelacionTotalFECred");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarCancelacionTotalFECred"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposMotivosRechazo(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarTiposMotivosRechazo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposMotivosRechazo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposFormasCancelacion(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarTiposFormasCancelacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposFormasCancelacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType aceptarFECred(wsfecred.afip.gob.ar.FECredService.AceptarFECredRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/aceptarFECred");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "aceptarFECred"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType consultarCtaCte(wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarCtaCte");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCtaCte"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCtaCteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType consultarCuentasEnAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarCuentasEnAgtDptoCltv");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCuentasEnAgtDptoCltv"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCuentasEnAgtDptoCltvResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType obtenerRemitos(wsfecred.afip.gob.ar.FECredService.ObtenerRemitosRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/obtenerRemitos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "obtenerRemitos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ObtenerRemitosResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType consultarHistorialEstadosComprobante(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarHistorialEstadosComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarHistorialEstadosComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType consultarHistorialEstadosCtaCte(wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarHistorialEstadosCtaCte");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarHistorialEstadosCtaCte"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarHistorialEstadosCtaCteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType consultarTiposAjustesOperacion(wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarTiposAjustesOperacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposAjustesOperacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarCodigoDescripcionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType consultarMontoObligadoRecepcion(wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/consultarMontoObligadoRecepcion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarMontoObligadoRecepcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.ConsultarMontoObligadoRecepcionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType modificarOpcionTransferencia(wsfecred.afip.gob.ar.FECredService.ModificarOpcionTransferenciaRequestType parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gob.afip.wsfecred/FECredService/modificarOpcionTransferencia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "modificarOpcionTransferencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, wsfecred.afip.gob.ar.FECredService.OperacionFECredResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }
    
    // Modificaciones ad-hoc para poder recuperar el XML request y response 
    public String getCallRequestXML() {	try { return _call.getMessageContext().getRequestMessage().getSOAPPartAsString(); } catch (Exception e) { e.printStackTrace(); return ""; } } 
    public String getCallResponseXML() { try { return _call.getMessageContext().getResponseMessage().getSOAPPartAsString(); } catch (Exception e) { e.printStackTrace(); return ""; } } 
 

}
