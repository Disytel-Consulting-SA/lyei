/**
 * CbteAsoc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar;

public class CbteAsoc  implements java.io.Serializable {
    private int tipo;

    private int ptoVta;

    private long nro;

    private java.lang.String cuit;

    private java.lang.String cbteFch;

    public CbteAsoc() {
    }

    public CbteAsoc(
           int tipo,
           int ptoVta,
           long nro,
           java.lang.String cuit,
           java.lang.String cbteFch) {
           this.tipo = tipo;
           this.ptoVta = ptoVta;
           this.nro = nro;
           this.cuit = cuit;
           this.cbteFch = cbteFch;
    }


    /**
     * Gets the tipo value for this CbteAsoc.
     * 
     * @return tipo
     */
    public int getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this CbteAsoc.
     * 
     * @param tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the ptoVta value for this CbteAsoc.
     * 
     * @return ptoVta
     */
    public int getPtoVta() {
        return ptoVta;
    }


    /**
     * Sets the ptoVta value for this CbteAsoc.
     * 
     * @param ptoVta
     */
    public void setPtoVta(int ptoVta) {
        this.ptoVta = ptoVta;
    }


    /**
     * Gets the nro value for this CbteAsoc.
     * 
     * @return nro
     */
    public long getNro() {
        return nro;
    }


    /**
     * Sets the nro value for this CbteAsoc.
     * 
     * @param nro
     */
    public void setNro(long nro) {
        this.nro = nro;
    }


    /**
     * Gets the cuit value for this CbteAsoc.
     * 
     * @return cuit
     */
    public java.lang.String getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this CbteAsoc.
     * 
     * @param cuit
     */
    public void setCuit(java.lang.String cuit) {
        this.cuit = cuit;
    }


    /**
     * Gets the cbteFch value for this CbteAsoc.
     * 
     * @return cbteFch
     */
    public java.lang.String getCbteFch() {
        return cbteFch;
    }


    /**
     * Sets the cbteFch value for this CbteAsoc.
     * 
     * @param cbteFch
     */
    public void setCbteFch(java.lang.String cbteFch) {
        this.cbteFch = cbteFch;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CbteAsoc)) return false;
        CbteAsoc other = (CbteAsoc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.tipo == other.getTipo() &&
            this.ptoVta == other.getPtoVta() &&
            this.nro == other.getNro() &&
            ((this.cuit==null && other.getCuit()==null) || 
             (this.cuit!=null &&
              this.cuit.equals(other.getCuit()))) &&
            ((this.cbteFch==null && other.getCbteFch()==null) || 
             (this.cbteFch!=null &&
              this.cbteFch.equals(other.getCbteFch())));
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
        _hashCode += getTipo();
        _hashCode += getPtoVta();
        _hashCode += new Long(getNro()).hashCode();
        if (getCuit() != null) {
            _hashCode += getCuit().hashCode();
        }
        if (getCbteFch() != null) {
            _hashCode += getCbteFch().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CbteAsoc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteAsoc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptoVta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "PtoVta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Nro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Cuit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbteFch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteFch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
