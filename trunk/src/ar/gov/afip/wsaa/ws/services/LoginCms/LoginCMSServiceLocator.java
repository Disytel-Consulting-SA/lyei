/**
 * LoginCMSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsaa.ws.services.LoginCms;

public class LoginCMSServiceLocator extends org.apache.axis.client.Service implements ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMSService {

    public LoginCMSServiceLocator() {
    }


    public LoginCMSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginCMSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoginCms
    private java.lang.String LoginCms_address = "https://wsaa.afip.gov.ar/ws/services/LoginCms";

    public java.lang.String getLoginCmsAddress() {
        return LoginCms_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoginCmsWSDDServiceName = "LoginCms";

    public java.lang.String getLoginCmsWSDDServiceName() {
        return LoginCmsWSDDServiceName;
    }

    public void setLoginCmsWSDDServiceName(java.lang.String name) {
        LoginCmsWSDDServiceName = name;
    }

    public ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS getLoginCms() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoginCms_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoginCms(endpoint);
    }

    public ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS getLoginCms(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ar.gov.afip.wsaa.ws.services.LoginCms.LoginCmsSoapBindingStub _stub = new ar.gov.afip.wsaa.ws.services.LoginCms.LoginCmsSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginCmsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginCmsEndpointAddress(java.lang.String address) {
        LoginCms_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS.class.isAssignableFrom(serviceEndpointInterface)) {
                ar.gov.afip.wsaa.ws.services.LoginCms.LoginCmsSoapBindingStub _stub = new ar.gov.afip.wsaa.ws.services.LoginCms.LoginCmsSoapBindingStub(new java.net.URL(LoginCms_address), this);
                _stub.setPortName(getLoginCmsWSDDServiceName());
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
        if ("LoginCms".equals(inputPortName)) {
            return getLoginCms();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://wsaa.afip.gov.ar/ws/services/LoginCms", "LoginCMSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://wsaa.afip.gov.ar/ws/services/LoginCms", "LoginCms"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoginCms".equals(portName)) {
            setLoginCmsEndpointAddress(address);
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
