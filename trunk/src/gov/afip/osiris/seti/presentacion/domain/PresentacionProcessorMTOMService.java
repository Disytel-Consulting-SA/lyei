/**
 * PresentacionProcessorMTOMService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.afip.osiris.seti.presentacion.domain;

public interface PresentacionProcessorMTOMService extends java.rmi.Remote {
    public long upload(java.lang.String token, java.lang.String sign, java.lang.String representadoCuit, gov.afip.osiris.seti.presentacion.domain.PresentacionFileB2B presentacion) throws java.rmi.RemoteException, gov.afip.osiris.seti.presentacion.domain.Exception;
    public gov.afip.osiris.seti.presentacion.domain.DummyReturn dummy() throws java.rmi.RemoteException, gov.afip.osiris.seti.presentacion.domain.Exception;
    public gov.afip.osiris.seti.presentacion.domain.ConsultaPresentacionReturn consulta(java.lang.String token, java.lang.String sign, java.lang.String representadoCuit, java.lang.String fileName, int formulario, long contribuyenteCuit, java.lang.String md5) throws java.rmi.RemoteException, gov.afip.osiris.seti.presentacion.domain.Exception;
}
