/**
 * PersonaListReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sr.puc.server.ws.soap.a5;

public class PersonaListReturn  implements java.io.Serializable {
    private sr.puc.server.ws.soap.a5.Metadata metadata;

    private sr.puc.server.ws.soap.a5.Persona[] persona;

    public PersonaListReturn() {
    }

    public PersonaListReturn(
           sr.puc.server.ws.soap.a5.Metadata metadata,
           sr.puc.server.ws.soap.a5.Persona[] persona) {
           this.metadata = metadata;
           this.persona = persona;
    }


    /**
     * Gets the metadata value for this PersonaListReturn.
     * 
     * @return metadata
     */
    public sr.puc.server.ws.soap.a5.Metadata getMetadata() {
        return metadata;
    }


    /**
     * Sets the metadata value for this PersonaListReturn.
     * 
     * @param metadata
     */
    public void setMetadata(sr.puc.server.ws.soap.a5.Metadata metadata) {
        this.metadata = metadata;
    }


    /**
     * Gets the persona value for this PersonaListReturn.
     * 
     * @return persona
     */
    public sr.puc.server.ws.soap.a5.Persona[] getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this PersonaListReturn.
     * 
     * @param persona
     */
    public void setPersona(sr.puc.server.ws.soap.a5.Persona[] persona) {
        this.persona = persona;
    }

    public sr.puc.server.ws.soap.a5.Persona getPersona(int i) {
        return this.persona[i];
    }

    public void setPersona(int i, sr.puc.server.ws.soap.a5.Persona _value) {
        this.persona[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PersonaListReturn)) return false;
        PersonaListReturn other = (PersonaListReturn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.metadata==null && other.getMetadata()==null) || 
             (this.metadata!=null &&
              this.metadata.equals(other.getMetadata()))) &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              java.util.Arrays.equals(this.persona, other.getPersona())));
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
        if (getMetadata() != null) {
            _hashCode += getMetadata().hashCode();
        }
        if (getPersona() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPersona());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPersona(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PersonaListReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "personaListReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metadata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "metadata"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://a5.soap.ws.server.puc.sr/", "persona"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
