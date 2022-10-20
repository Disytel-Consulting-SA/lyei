/**
 * UploadLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.afip.osiris.seti.presentacion.domain.service.implementation.ws;

public class UploadLocator extends org.apache.axis.client.Service implements gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.Upload {

    public UploadLocator() {
    }


    public UploadLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UploadLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PresentacionProcessorMTOMImplPort
    private java.lang.String PresentacionProcessorMTOMImplPort_address = "https://awshomo.afip.gov.ar/setiws/webservices/uploadPresentacionService";

    public java.lang.String getPresentacionProcessorMTOMImplPortAddress() {
        return PresentacionProcessorMTOMImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PresentacionProcessorMTOMImplPortWSDDServiceName = "PresentacionProcessorMTOMImplPort";

    public java.lang.String getPresentacionProcessorMTOMImplPortWSDDServiceName() {
        return PresentacionProcessorMTOMImplPortWSDDServiceName;
    }

    public void setPresentacionProcessorMTOMImplPortWSDDServiceName(java.lang.String name) {
        PresentacionProcessorMTOMImplPortWSDDServiceName = name;
    }

    public gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService getPresentacionProcessorMTOMImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PresentacionProcessorMTOMImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPresentacionProcessorMTOMImplPort(endpoint);
    }

    public gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService getPresentacionProcessorMTOMImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadSoapBindingStub _stub = new gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadSoapBindingStub(portAddress, this);
            _stub.setPortName(getPresentacionProcessorMTOMImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPresentacionProcessorMTOMImplPortEndpointAddress(java.lang.String address) {
        PresentacionProcessorMTOMImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gov.afip.osiris.seti.presentacion.domain.PresentacionProcessorMTOMService.class.isAssignableFrom(serviceEndpointInterface)) {
                gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadSoapBindingStub _stub = new gov.afip.osiris.seti.presentacion.domain.service.implementation.ws.UploadSoapBindingStub(new java.net.URL(PresentacionProcessorMTOMImplPort_address), this);
                _stub.setPortName(getPresentacionProcessorMTOMImplPortWSDDServiceName());
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
        if ("PresentacionProcessorMTOMImplPort".equals(inputPortName)) {
            return getPresentacionProcessorMTOMImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/", "upload");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.implementation.service.domain.presentacion.seti.osiris.afip.gov/", "PresentacionProcessorMTOMImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PresentacionProcessorMTOMImplPort".equals(portName)) {
            setPresentacionProcessorMTOMImplPortEndpointAddress(address);
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
