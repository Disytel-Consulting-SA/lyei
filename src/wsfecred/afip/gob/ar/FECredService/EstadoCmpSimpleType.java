/**
 * EstadoCmpSimpleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class EstadoCmpSimpleType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected EstadoCmpSimpleType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _PendienteRecepcion = "PendienteRecepcion";
    public static final java.lang.String _Recepcionado = "Recepcionado";
    public static final java.lang.String _Aceptado = "Aceptado";
    public static final java.lang.String _Rechazado = "Rechazado";
    public static final java.lang.String _InformadaAgDpto = "InformadaAgDpto";
    public static final EstadoCmpSimpleType PendienteRecepcion = new EstadoCmpSimpleType(_PendienteRecepcion);
    public static final EstadoCmpSimpleType Recepcionado = new EstadoCmpSimpleType(_Recepcionado);
    public static final EstadoCmpSimpleType Aceptado = new EstadoCmpSimpleType(_Aceptado);
    public static final EstadoCmpSimpleType Rechazado = new EstadoCmpSimpleType(_Rechazado);
    public static final EstadoCmpSimpleType InformadaAgDpto = new EstadoCmpSimpleType(_InformadaAgDpto);
    public java.lang.String getValue() { return _value_;}
    public static EstadoCmpSimpleType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        EstadoCmpSimpleType enumeration = (EstadoCmpSimpleType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static EstadoCmpSimpleType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstadoCmpSimpleType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "EstadoCmpSimpleType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
