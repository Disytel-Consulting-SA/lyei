/**
 * InfoTransferenciaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class InfoTransferenciaType  implements java.io.Serializable {
    private wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv;

    private wsfecred.afip.gob.ar.FECredService.InfoSCAType infoSCA;

    public InfoTransferenciaType() {
    }

    public InfoTransferenciaType(
           wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv,
           wsfecred.afip.gob.ar.FECredService.InfoSCAType infoSCA) {
           this.infoAgtDptoCltv = infoAgtDptoCltv;
           this.infoSCA = infoSCA;
    }


    /**
     * Gets the infoAgtDptoCltv value for this InfoTransferenciaType.
     * 
     * @return infoAgtDptoCltv
     */
    public wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType getInfoAgtDptoCltv() {
        return infoAgtDptoCltv;
    }


    /**
     * Sets the infoAgtDptoCltv value for this InfoTransferenciaType.
     * 
     * @param infoAgtDptoCltv
     */
    public void setInfoAgtDptoCltv(wsfecred.afip.gob.ar.FECredService.InfoAgtDptoCltvType infoAgtDptoCltv) {
        this.infoAgtDptoCltv = infoAgtDptoCltv;
    }


    /**
     * Gets the infoSCA value for this InfoTransferenciaType.
     * 
     * @return infoSCA
     */
    public wsfecred.afip.gob.ar.FECredService.InfoSCAType getInfoSCA() {
        return infoSCA;
    }


    /**
     * Sets the infoSCA value for this InfoTransferenciaType.
     * 
     * @param infoSCA
     */
    public void setInfoSCA(wsfecred.afip.gob.ar.FECredService.InfoSCAType infoSCA) {
        this.infoSCA = infoSCA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoTransferenciaType)) return false;
        InfoTransferenciaType other = (InfoTransferenciaType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.infoAgtDptoCltv==null && other.getInfoAgtDptoCltv()==null) || 
             (this.infoAgtDptoCltv!=null &&
              this.infoAgtDptoCltv.equals(other.getInfoAgtDptoCltv()))) &&
            ((this.infoSCA==null && other.getInfoSCA()==null) || 
             (this.infoSCA!=null &&
              this.infoSCA.equals(other.getInfoSCA())));
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
        if (getInfoAgtDptoCltv() != null) {
            _hashCode += getInfoAgtDptoCltv().hashCode();
        }
        if (getInfoSCA() != null) {
            _hashCode += getInfoSCA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoTransferenciaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoTransferenciaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoAgtDptoCltv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoAgtDptoCltv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoAgtDptoCltvType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoSCA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoSCA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "InfoSCAType"));
        elemField.setMinOccurs(0);
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
