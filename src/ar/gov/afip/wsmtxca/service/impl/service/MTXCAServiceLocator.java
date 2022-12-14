/**
 * MTXCAServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsmtxca.service.impl.service;

public class MTXCAServiceLocator extends org.apache.axis.client.Service implements ar.gov.afip.wsmtxca.service.impl.service.MTXCAService {

    public MTXCAServiceLocator() {
    }


    public MTXCAServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MTXCAServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MTXCAServiceHttpSoap11Endpoint
    private java.lang.String MTXCAServiceHttpSoap11Endpoint_address = "https://serviciosjava.afip.gob.ar/wsmtxca/services/MTXCAService";

    public java.lang.String getMTXCAServiceHttpSoap11EndpointAddress() {
        return MTXCAServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MTXCAServiceHttpSoap11EndpointWSDDServiceName = "MTXCAServiceHttpSoap11Endpoint";

    public java.lang.String getMTXCAServiceHttpSoap11EndpointWSDDServiceName() {
        return MTXCAServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setMTXCAServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        MTXCAServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType getMTXCAServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MTXCAServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMTXCAServiceHttpSoap11Endpoint(endpoint);
    }

    public ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType getMTXCAServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub _stub = new ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getMTXCAServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMTXCAServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        MTXCAServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ar.gov.afip.wsmtxca.service.impl.service.MTXCAServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub _stub = new ar.gov.afip.wsmtxca.service.impl.service.MTXCAServiceSoap11BindingStub(new java.net.URL(MTXCAServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getMTXCAServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MTXCAServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getMTXCAServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "MTXCAService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "MTXCAServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MTXCAServiceHttpSoap11Endpoint".equals(portName)) {
            setMTXCAServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
