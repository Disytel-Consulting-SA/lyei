/**
 * FECredServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class FECredServiceLocator extends org.apache.axis.client.Service implements wsfecred.afip.gob.ar.FECredService.FECredService {

    public FECredServiceLocator() {
    }


    public FECredServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FECredServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FECredServiceSOAP
    private java.lang.String FECredServiceSOAP_address = "https://serviciosjava.afip.gob.ar:443/wsfecred/FECredService";

    public java.lang.String getFECredServiceSOAPAddress() {
        return FECredServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FECredServiceSOAPWSDDServiceName = "FECredServiceSOAP";

    public java.lang.String getFECredServiceSOAPWSDDServiceName() {
        return FECredServiceSOAPWSDDServiceName;
    }

    public void setFECredServiceSOAPWSDDServiceName(java.lang.String name) {
        FECredServiceSOAPWSDDServiceName = name;
    }

    public wsfecred.afip.gob.ar.FECredService.FECredServicePortType getFECredServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FECredServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFECredServiceSOAP(endpoint);
    }

    public wsfecred.afip.gob.ar.FECredService.FECredServicePortType getFECredServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wsfecred.afip.gob.ar.FECredService.FECredServiceSOAPStub _stub = new wsfecred.afip.gob.ar.FECredService.FECredServiceSOAPStub(portAddress, this);
            _stub.setPortName(getFECredServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFECredServiceSOAPEndpointAddress(java.lang.String address) {
        FECredServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wsfecred.afip.gob.ar.FECredService.FECredServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                wsfecred.afip.gob.ar.FECredService.FECredServiceSOAPStub _stub = new wsfecred.afip.gob.ar.FECredService.FECredServiceSOAPStub(new java.net.URL(FECredServiceSOAP_address), this);
                _stub.setPortName(getFECredServiceSOAPWSDDServiceName());
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
        if ("FECredServiceSOAP".equals(inputPortName)) {
            return getFECredServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FECredService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FECredServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FECredServiceSOAP".equals(portName)) {
            setFECredServiceSOAPEndpointAddress(address);
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
