/**
 * LoginCMSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.gov.afip.wsaa.ws.services.LoginCms;

public interface LoginCMSService extends javax.xml.rpc.Service {
    public java.lang.String getLoginCmsAddress();

    public ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS getLoginCms() throws javax.xml.rpc.ServiceException;

    public ar.gov.afip.wsaa.ws.services.LoginCms.LoginCMS getLoginCms(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
