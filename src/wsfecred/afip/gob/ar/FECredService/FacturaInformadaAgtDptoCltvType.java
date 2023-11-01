/**
 * FacturaInformadaAgtDptoCltvType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class FacturaInformadaAgtDptoCltvType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFactura;

    private wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv;

    public FacturaInformadaAgtDptoCltvType() {
    }

    public FacturaInformadaAgtDptoCltvType(
           wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFactura,
           wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv) {
           this.idFactura = idFactura;
           this.infoAgtDptoCltv = infoAgtDptoCltv;
    }


    /**
     * Gets the idFactura value for this FacturaInformadaAgtDptoCltvType.
     * 
     * @return idFactura
     */
    public wsfecred.afip.gob.ar.FECredService.IdComprobanteType getIdFactura() {
        return idFactura;
    }


    /**
     * Sets the idFactura value for this FacturaInformadaAgtDptoCltvType.
     * 
     * @param idFactura
     */
    public void setIdFactura(wsfecred.afip.gob.ar.FECredService.IdComprobanteType idFactura) {
        this.idFactura = idFactura;
    }


    /**
     * Gets the infoAgtDptoCltv value for this FacturaInformadaAgtDptoCltvType.
     * 
     * @return infoAgtDptoCltv
     */
    public wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType getInfoAgtDptoCltv() {
        return infoAgtDptoCltv;
    }


    /**
     * Sets the infoAgtDptoCltv value for this FacturaInformadaAgtDptoCltvType.
     * 
     * @param infoAgtDptoCltv
     */
    public void setInfoAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv) {
        this.infoAgtDptoCltv = infoAgtDptoCltv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FacturaInformadaAgtDptoCltvType)) return false;
        FacturaInformadaAgtDptoCltvType other = (FacturaInformadaAgtDptoCltvType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idFactura==null && other.getIdFactura()==null) || 
             (this.idFactura!=null &&
              this.idFactura.equals(other.getIdFactura()))) &&
            ((this.infoAgtDptoCltv==null && other.getInfoAgtDptoCltv()==null) || 
             (this.infoAgtDptoCltv!=null &&
              this.infoAgtDptoCltv.equals(other.getInfoAgtDptoCltv())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIdFactura() != null) {
            _hashCode += getIdFactura().hashCode();
        }
        if (getInfoAgtDptoCltv() != null) {
            _hashCode += getInfoAgtDptoCltv().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FacturaInformadaAgtDptoCltvType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "FacturaInformadaAgtDptoCltvType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFactura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFactura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoAgtDptoCltv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoAgtDptoCltv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoAgtDptoCltvType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
