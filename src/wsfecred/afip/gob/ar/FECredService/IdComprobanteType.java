/**
 * IdComprobanteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class IdComprobanteType  implements java.io.Serializable {
    private long CUITEmisor;

    private short codTipoCmp;

    private int ptoVta;

    private long nroCmp;

    public IdComprobanteType() {
    }

    public IdComprobanteType(
           long CUITEmisor,
           short codTipoCmp,
           int ptoVta,
           long nroCmp) {
           this.CUITEmisor = CUITEmisor;
           this.codTipoCmp = codTipoCmp;
           this.ptoVta = ptoVta;
           this.nroCmp = nroCmp;
    }


    /**
     * Gets the CUITEmisor value for this IdComprobanteType.
     * 
     * @return CUITEmisor
     */
    public long getCUITEmisor() {
        return CUITEmisor;
    }


    /**
     * Sets the CUITEmisor value for this IdComprobanteType.
     * 
     * @param CUITEmisor
     */
    public void setCUITEmisor(long CUITEmisor) {
        this.CUITEmisor = CUITEmisor;
    }


    /**
     * Gets the codTipoCmp value for this IdComprobanteType.
     * 
     * @return codTipoCmp
     */
    public short getCodTipoCmp() {
        return codTipoCmp;
    }


    /**
     * Sets the codTipoCmp value for this IdComprobanteType.
     * 
     * @param codTipoCmp
     */
    public void setCodTipoCmp(short codTipoCmp) {
        this.codTipoCmp = codTipoCmp;
    }


    /**
     * Gets the ptoVta value for this IdComprobanteType.
     * 
     * @return ptoVta
     */
    public int getPtoVta() {
        return ptoVta;
    }


    /**
     * Sets the ptoVta value for this IdComprobanteType.
     * 
     * @param ptoVta
     */
    public void setPtoVta(int ptoVta) {
        this.ptoVta = ptoVta;
    }


    /**
     * Gets the nroCmp value for this IdComprobanteType.
     * 
     * @return nroCmp
     */
    public long getNroCmp() {
        return nroCmp;
    }


    /**
     * Sets the nroCmp value for this IdComprobanteType.
     * 
     * @param nroCmp
     */
    public void setNroCmp(long nroCmp) {
        this.nroCmp = nroCmp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdComprobanteType)) return false;
        IdComprobanteType other = (IdComprobanteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.CUITEmisor == other.getCUITEmisor() &&
            this.codTipoCmp == other.getCodTipoCmp() &&
            this.ptoVta == other.getPtoVta() &&
            this.nroCmp == other.getNroCmp();
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
        _hashCode += new Long(getCUITEmisor()).hashCode();
        _hashCode += getCodTipoCmp();
        _hashCode += getPtoVta();
        _hashCode += new Long(getNroCmp()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdComprobanteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "IdComprobanteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUITEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CUITEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codTipoCmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codTipoCmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptoVta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptoVta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroCmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nroCmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
