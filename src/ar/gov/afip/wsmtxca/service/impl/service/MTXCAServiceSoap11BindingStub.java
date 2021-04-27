/**
 * MTXCAServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class MTXCAServiceSoap11BindingStub extends org.apache.axis.client.Stub implements ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[25];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("dummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DummyResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "dummyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("autorizarComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteRequestType"), ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("solicitarCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "solicitarCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEARequestType"), ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "solicitarCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarComprobanteCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarComprobanteCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEARequestType"), ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarComprobanteCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarUltimoComprobanteAutorizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUltimoComprobanteAutorizadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUltimoComprobanteAutorizadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDocumentoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarAlicuotasIVA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarAlicuotasIVARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVARequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarAlicuotasIVAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCondicionesIVA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCondicionesIVARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVARequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCondicionesIVAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarMonedas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarMonedasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarMonedasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCotizacionMoneda");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCotizacionMonedaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCotizacionMonedaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarUnidadesMedida");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUnidadesMedidaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUnidadesMedidaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVenta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVentaCAE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAERequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAERequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAERequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVentaCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAEARequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarCAEANoUtilizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoRequestType"), ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposTributo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposTributoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposTributoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarCAEANoUtilizadoPtoVta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoPtoVtaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaRequestType"), ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoPtoVtaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEARequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPtosVtaCAEANoInformados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPtosVtaCAEANoInformadosRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPtosVtaCAEANoInformadosResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCAEAEntreFechas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAEntreFechasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAEntreFechasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("autorizarAjusteIVA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarAjusteIVARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarAjusteIVARequestType"), ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarAjusteIVAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarAjusteIVAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarAjusteIVACAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarAjusteIVACAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarAjusteIVACAEARequestType"), ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarAjusteIVACAEAResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarAjusteIVACAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposDatosAdicionales");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDatosAdicionalesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDatosAdicionalesRequestType"), ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDatosAdicionalesResponseType"));
        oper.setReturnClass(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDatosAdicionalesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[24] = oper;

    }

    public MTXCAServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MTXCAServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MTXCAServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CAEAResponseType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CAEAResponseType");
            qName2 = new javax.xml.namespace.QName("", "CAEAResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCodigosDescripcionesStringType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionStringType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionStringType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCodigosDescripcionesType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCompradoresType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CompradorType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CompradorType");
            qName2 = new javax.xml.namespace.QName("", "comprador");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayComprobantesAsociadosType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteAsociadoType");
            qName2 = new javax.xml.namespace.QName("", "comprobanteAsociado");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayDatosAdicionalesType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DatoAdicionalType");
            qName2 = new javax.xml.namespace.QName("", "datoAdicional");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayItemsType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ItemType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ItemType");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayOtrosTributosType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "OtroTributoType");
            qName2 = new javax.xml.namespace.QName("", "otroTributo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayPuntosVentaType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType");
            qName2 = new javax.xml.namespace.QName("", "puntoVenta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArraySubtotalesIVAType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SubtotalIVAType");
            qName2 = new javax.xml.namespace.QName("", "subtotalIVA");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.AuthRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarAjusteIVARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarAjusteIVAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionStringType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionStringType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoTipoAutorizacionSimpleType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CodigoTipoAutorizacionSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CompradorType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.CompradorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteAsociadoType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ComprobanteAsociadoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultaComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAEARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAERequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAERequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDatosAdicionalesRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDatosAdicionalesResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaUltimoComprobanteAutorizadoRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ConsultaUltimoComprobanteAutorizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DatoAdicionalType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.DatoAdicionalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DecimalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DummyResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ImporteSubtotalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ImporteTotalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarAjusteIVACAEARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarAjusteIVACAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoRequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ItemType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ItemType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "NumeroComprobanteSimpleType");
            cachedSerQNames.add(qName);
            cls = long.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "NumeroPuntoVentaSimpleType");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "OtroTributoType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.OtroTributoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PorcentajeSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ResultadoSimpleType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.ResultadoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SiNoSimpleType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SiNoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEARequestType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitudCAEAType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SolicitudCAEAType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SubtotalIVAType");
            cachedSerQNames.add(qName);
            cls = ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType.class;
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

    public ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType dummy() throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/dummy");
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
                return (ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType autorizarComprobante(ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/autorizarComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "autorizarComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType solicitarCAEA(ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/solicitarCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "solicitarCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType informarComprobanteCAEA(ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarComprobanteCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarComprobanteCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizado(ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarUltimoComprobanteAutorizado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarUltimoComprobanteAutorizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType consultarComprobante(ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType consultarTiposComprobante(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType consultarTiposDocumento(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType consultarAlicuotasIVA(ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarAlicuotasIVA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarAlicuotasIVA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType consultarCondicionesIVA(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCondicionesIVA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCondicionesIVA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType consultarMonedas(ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarMonedas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarMonedas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType consultarCotizacionMoneda(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCotizacionMoneda");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCotizacionMoneda"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType consultarUnidadesMedida(ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarUnidadesMedida");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarUnidadesMedida"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType consultarPuntosVenta(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVenta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVenta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType consultarPuntosVentaCAE(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAERequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAE");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVentaCAE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType consultarPuntosVentaCAEA(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaCAEARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVentaCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType informarCAEANoUtilizado(ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarCAEANoUtilizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType consultarTiposTributo(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposTributo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposTributo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType informarCAEANoUtilizadoPtoVta(ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizadoPtoVta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarCAEANoUtilizadoPtoVta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType consultarCAEA(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType consultarPtosVtaCAEANoInformados(ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPtosVtaCAEANoInformados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPtosVtaCAEANoInformados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType consultarCAEAEntreFechas(ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEAEntreFechas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCAEAEntreFechas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType autorizarAjusteIVA(ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/autorizarAjusteIVA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "autorizarAjusteIVA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType informarAjusteIVACAEA(ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEARequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarAjusteIVACAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarAjusteIVACAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType consultarTiposDatosAdicionales(ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesRequestType parameters) throws java.rmi.RemoteException, ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposDatosAdicionales");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposDatosAdicionales"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) {
              throw (ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
