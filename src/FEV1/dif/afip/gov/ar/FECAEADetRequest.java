/**
 * FECAEADetRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar;

public class FECAEADetRequest  extends FEV1.dif.afip.gov.ar.FEDetRequest  implements java.io.Serializable {
    private java.lang.String CAEA;

    private java.lang.String cbteFchHsGen;

    public FECAEADetRequest() {
    }

    public FECAEADetRequest(
           int concepto,
           int docTipo,
           long docNro,
           long cbteDesde,
           long cbteHasta,
           java.lang.String cbteFch,
           double impTotal,
           double impTotConc,
           double impNeto,
           double impOpEx,
           double impTrib,
           double impIVA,
           java.lang.String fchServDesde,
           java.lang.String fchServHasta,
           java.lang.String fchVtoPago,
           java.lang.String monId,
           double monCotiz,
           int condicionIvaReceptorId, // dREHER Feb 25
           FEV1.dif.afip.gov.ar.CbteAsoc[] cbtesAsoc,
           FEV1.dif.afip.gov.ar.Tributo[] tributos,
           FEV1.dif.afip.gov.ar.AlicIva[] iva,
           FEV1.dif.afip.gov.ar.Opcional[] opcionales,
           FEV1.dif.afip.gov.ar.Comprador[] compradores,
           FEV1.dif.afip.gov.ar.Periodo periodoAsoc,
           FEV1.dif.afip.gov.ar.Actividad[] actividades,
           java.lang.String CAEA,
           java.lang.String cbteFchHsGen) {
        super(
            concepto,
            docTipo,
            docNro,
            cbteDesde,
            cbteHasta,
            cbteFch,
            impTotal,
            impTotConc,
            impNeto,
            impOpEx,
            impTrib,
            impIVA,
            fchServDesde,
            fchServHasta,
            fchVtoPago,
            monId,
            monCotiz,
            condicionIvaReceptorId, // dREHER Feb 25
            cbtesAsoc,
            tributos,
            iva,
            opcionales,
            compradores,
            periodoAsoc,
            actividades);
        this.CAEA = CAEA;
        this.cbteFchHsGen = cbteFchHsGen;
    }


    /**
     * Gets the CAEA value for this FECAEADetRequest.
     * 
     * @return CAEA
     */
    public java.lang.String getCAEA() {
        return CAEA;
    }


    /**
     * Sets the CAEA value for this FECAEADetRequest.
     * 
     * @param CAEA
     */
    public void setCAEA(java.lang.String CAEA) {
        this.CAEA = CAEA;
    }


    /**
     * Gets the cbteFchHsGen value for this FECAEADetRequest.
     * 
     * @return cbteFchHsGen
     */
    public java.lang.String getCbteFchHsGen() {
        return cbteFchHsGen;
    }


    /**
     * Sets the cbteFchHsGen value for this FECAEADetRequest.
     * 
     * @param cbteFchHsGen
     */
    public void setCbteFchHsGen(java.lang.String cbteFchHsGen) {
        this.cbteFchHsGen = cbteFchHsGen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FECAEADetRequest)) return false;
        FECAEADetRequest other = (FECAEADetRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CAEA==null && other.getCAEA()==null) || 
             (this.CAEA!=null &&
              this.CAEA.equals(other.getCAEA()))) &&
            ((this.cbteFchHsGen==null && other.getCbteFchHsGen()==null) || 
             (this.cbteFchHsGen!=null &&
              this.cbteFchHsGen.equals(other.getCbteFchHsGen())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCAEA() != null) {
            _hashCode += getCAEA().hashCode();
        }
        if (getCbteFchHsGen() != null) {
            _hashCode += getCbteFchHsGen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FECAEADetRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEADetRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAEA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CAEA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbteFchHsGen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "CbteFchHsGen"));
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
