/**
 * PersonaServiceA5SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class PersonaServiceA5SoapBindingStub extends org.apache.axis.client.Stub implements sr.puc.server.ws.soap.a5.PersonaServiceA5_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersona");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cuitRepresentada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idPersona"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaReturn"));
        oper.setReturnClass(sr.puc.server.ws.soap.a5.PersonaReturn.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "personaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"),
                      "sr.puc.server.ws.soap.a5.SRValidationException",
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersonaList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cuitRepresentada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idPersona"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaListReturn"));
        oper.setReturnClass(sr.puc.server.ws.soap.a5.PersonaListReturn.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "personaListReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"),
                      "sr.puc.server.ws.soap.a5.SRValidationException",
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersona_v2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cuitRepresentada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idPersona"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaReturn"));
        oper.setReturnClass(sr.puc.server.ws.soap.a5.PersonaReturn.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "personaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"),
                      "sr.puc.server.ws.soap.a5.SRValidationException",
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("dummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "dummyReturn"));
        oper.setReturnClass(sr.puc.server.ws.soap.a5.DummyReturn.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersonaList_v2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cuitRepresentada"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idPersona"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaListReturn"));
        oper.setReturnClass(sr.puc.server.ws.soap.a5.PersonaListReturn.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "personaListReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"),
                      "sr.puc.server.ws.soap.a5.SRValidationException",
                      new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException"), 
                      true
                     ));
        _operations[4] = oper;

    }

    public PersonaServiceA5SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PersonaServiceA5SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PersonaServiceA5SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "actividad");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Actividad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "caracterizacion");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Caracterizacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "categoria");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Categoria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosGenerales");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.DatosGenerales.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosMonotributo");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.DatosMonotributo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "datosRegimenGeneral");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.DatosRegimenGeneral.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "dependencia");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Dependencia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "domicilio");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Domicilio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "dummyReturn");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.DummyReturn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "errorConstancia");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.ErrorConstancia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "errorMonotributo");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.ErrorMonotributo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "errorRegimenGeneral");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.ErrorRegimenGeneral.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "impuesto");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Impuesto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "metadata");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Metadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "persona");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Persona.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaListReturn");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.PersonaListReturn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaReturn");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.PersonaReturn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "regimen");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Regimen.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "relacion");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.Relacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "SRValidationException");
            cachedSerQNames.add(qName);
            cls = sr.puc.server.ws.soap.a5.SRValidationException.class;
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

    public sr.puc.server.ws.soap.a5.PersonaReturn getPersona(java.lang.String token, java.lang.String sign, long cuitRepresentada, long idPersona) throws java.rmi.RemoteException, sr.puc.server.ws.soap.a5.SRValidationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "getPersona"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {token, sign, new java.lang.Long(cuitRepresentada), new java.lang.Long(idPersona)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (sr.puc.server.ws.soap.a5.PersonaReturn) _resp;
            } catch (java.lang.Exception _exception) {
                return (sr.puc.server.ws.soap.a5.PersonaReturn) org.apache.axis.utils.JavaUtils.convert(_resp, sr.puc.server.ws.soap.a5.PersonaReturn.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof sr.puc.server.ws.soap.a5.SRValidationException) {
              throw (sr.puc.server.ws.soap.a5.SRValidationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public sr.puc.server.ws.soap.a5.PersonaListReturn getPersonaList(java.lang.String token, java.lang.String sign, long cuitRepresentada, long[] idPersona) throws java.rmi.RemoteException, sr.puc.server.ws.soap.a5.SRValidationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "getPersonaList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {token, sign, new java.lang.Long(cuitRepresentada), idPersona});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (sr.puc.server.ws.soap.a5.PersonaListReturn) _resp;
            } catch (java.lang.Exception _exception) {
                return (sr.puc.server.ws.soap.a5.PersonaListReturn) org.apache.axis.utils.JavaUtils.convert(_resp, sr.puc.server.ws.soap.a5.PersonaListReturn.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof sr.puc.server.ws.soap.a5.SRValidationException) {
              throw (sr.puc.server.ws.soap.a5.SRValidationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public sr.puc.server.ws.soap.a5.PersonaReturn getPersona_v2(java.lang.String token, java.lang.String sign, long cuitRepresentada, long idPersona) throws java.rmi.RemoteException, sr.puc.server.ws.soap.a5.SRValidationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "getPersona_v2"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {token, sign, new java.lang.Long(cuitRepresentada), new java.lang.Long(idPersona)});

        if (_resp instanceof java.rmi.RemoteException) {
        	throw (java.rmi.RemoteException)_resp;
        }
        else {
        	extractAttachments(_call);
        	try {
        		return (sr.puc.server.ws.soap.a5.PersonaReturn) _resp;
        	} catch (java.lang.Exception _exception) {
        		return (sr.puc.server.ws.soap.a5.PersonaReturn) org.apache.axis.utils.JavaUtils.convert(_resp, sr.puc.server.ws.soap.a5.PersonaReturn.class);
        	}
        }
        } catch (org.apache.axis.AxisFault axisFaultException) {
        	if (axisFaultException.detail != null) {
        		if (axisFaultException.detail instanceof java.rmi.RemoteException) {
        			throw (java.rmi.RemoteException) axisFaultException.detail;
        		}
        		if (axisFaultException.detail instanceof sr.puc.server.ws.soap.a5.SRValidationException) {
        			throw (sr.puc.server.ws.soap.a5.SRValidationException) axisFaultException.detail;
        		}
        	}
        	throw axisFaultException;
        }
    }

    public sr.puc.server.ws.soap.a5.DummyReturn dummy() throws java.rmi.RemoteException {
    	if (super.cachedEndpoint == null) {
    		throw new org.apache.axis.NoEndPointException();
    	}
    	org.apache.axis.client.Call _call = createCall();
    	_call.setOperation(_operations[3]);
    	_call.setUseSOAPAction(true);
    	_call.setSOAPActionURI("");
    	_call.setEncodingStyle(null);
    	_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    	_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    	_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    	_call.setOperationName(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "dummy"));

    	setRequestHeaders(_call);
    	setAttachments(_call);
    	try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

    	if (_resp instanceof java.rmi.RemoteException) {
    		throw (java.rmi.RemoteException)_resp;
    	}
    	else {
    		extractAttachments(_call);
    		try {
    			return (sr.puc.server.ws.soap.a5.DummyReturn) _resp;
    		} catch (java.lang.Exception _exception) {
    			return (sr.puc.server.ws.soap.a5.DummyReturn) org.apache.axis.utils.JavaUtils.convert(_resp, sr.puc.server.ws.soap.a5.DummyReturn.class);
    		}
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public sr.puc.server.ws.soap.a5.PersonaListReturn getPersonaList_v2(java.lang.String token, java.lang.String sign, long cuitRepresentada, long[] idPersona) throws java.rmi.RemoteException, sr.puc.server.ws.soap.a5.SRValidationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "getPersonaList_v2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {token, sign, new java.lang.Long(cuitRepresentada), idPersona});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (sr.puc.server.ws.soap.a5.PersonaListReturn) _resp;
            } catch (java.lang.Exception _exception) {
                return (sr.puc.server.ws.soap.a5.PersonaListReturn) org.apache.axis.utils.JavaUtils.convert(_resp, sr.puc.server.ws.soap.a5.PersonaListReturn.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof sr.puc.server.ws.soap.a5.SRValidationException) {
              throw (sr.puc.server.ws.soap.a5.SRValidationException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }
    
    // Modificaciones ad-hoc para poder recuperar el XML request y response 
    public String getCallRequestXML() {	try { return _call.getMessageContext().getRequestMessage().getSOAPPartAsString(); } catch (Exception e) { e.printStackTrace(); return ""; } } 
    public String getCallResponseXML() { try { return _call.getMessageContext().getResponseMessage().getSOAPPartAsString(); } catch (Exception e) { e.printStackTrace(); return ""; } } 
 

}
