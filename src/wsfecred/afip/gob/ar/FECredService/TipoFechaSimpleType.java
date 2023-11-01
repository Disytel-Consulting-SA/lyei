/**
 * TipoFechaSimpleType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class TipoFechaSimpleType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TipoFechaSimpleType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Emision = "Emision";
    public static final java.lang.String _PuestaDispo = "PuestaDispo";
    public static final java.lang.String _VenPago = "VenPago";
    public static final java.lang.String _VenAcep = "VenAcep";
    public static final java.lang.String _Acep = "Acep";
    public static final java.lang.String _InfoAgDptoCltv = "InfoAgDptoCltv";
    public static final TipoFechaSimpleType Emision = new TipoFechaSimpleType(_Emision);
    public static final TipoFechaSimpleType PuestaDispo = new TipoFechaSimpleType(_PuestaDispo);
    public static final TipoFechaSimpleType VenPago = new TipoFechaSimpleType(_VenPago);
    public static final TipoFechaSimpleType VenAcep = new TipoFechaSimpleType(_VenAcep);
    public static final TipoFechaSimpleType Acep = new TipoFechaSimpleType(_Acep);
    public static final TipoFechaSimpleType InfoAgDptoCltv = new TipoFechaSimpleType(_InfoAgDptoCltv);
    public java.lang.String getValue() { return _value_;}
    public static TipoFechaSimpleType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TipoFechaSimpleType enumeration = (TipoFechaSimpleType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TipoFechaSimpleType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TipoFechaSimpleType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "TipoFechaSimpleType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
