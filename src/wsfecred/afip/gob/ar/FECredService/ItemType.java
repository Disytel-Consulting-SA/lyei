/**
 * ItemType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsfecred.afip.gob.ar.FECredService;

public class ItemType  implements java.io.Serializable {
    private int orden;

    private java.lang.Integer unidadesMtx;

    private java.lang.String codigoMtx;

    private java.lang.String codigo;

    private java.lang.String descripcion;

    private java.lang.String codNomMercosur;

    private java.math.BigDecimal cantidad;

    private java.lang.Short codigoUnidadMedida;

    private java.math.BigDecimal precioUnitario;

    private java.math.BigDecimal importeBonificacion;

    private short codigoCondicionIVA;

    private java.math.BigDecimal importeIVA;

    private java.math.BigDecimal importeItem;

    public ItemType() {
    }

    public ItemType(
           int orden,
           java.lang.Integer unidadesMtx,
           java.lang.String codigoMtx,
           java.lang.String codigo,
           java.lang.String descripcion,
           java.lang.String codNomMercosur,
           java.math.BigDecimal cantidad,
           java.lang.Short codigoUnidadMedida,
           java.math.BigDecimal precioUnitario,
           java.math.BigDecimal importeBonificacion,
           short codigoCondicionIVA,
           java.math.BigDecimal importeIVA,
           java.math.BigDecimal importeItem) {
           this.orden = orden;
           this.unidadesMtx = unidadesMtx;
           this.codigoMtx = codigoMtx;
           this.codigo = codigo;
           this.descripcion = descripcion;
           this.codNomMercosur = codNomMercosur;
           this.cantidad = cantidad;
           this.codigoUnidadMedida = codigoUnidadMedida;
           this.precioUnitario = precioUnitario;
           this.importeBonificacion = importeBonificacion;
           this.codigoCondicionIVA = codigoCondicionIVA;
           this.importeIVA = importeIVA;
           this.importeItem = importeItem;
    }


    /**
     * Gets the orden value for this ItemType.
     * 
     * @return orden
     */
    public int getOrden() {
        return orden;
    }


    /**
     * Sets the orden value for this ItemType.
     * 
     * @param orden
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }


    /**
     * Gets the unidadesMtx value for this ItemType.
     * 
     * @return unidadesMtx
     */
    public java.lang.Integer getUnidadesMtx() {
        return unidadesMtx;
    }


    /**
     * Sets the unidadesMtx value for this ItemType.
     * 
     * @param unidadesMtx
     */
    public void setUnidadesMtx(java.lang.Integer unidadesMtx) {
        this.unidadesMtx = unidadesMtx;
    }


    /**
     * Gets the codigoMtx value for this ItemType.
     * 
     * @return codigoMtx
     */
    public java.lang.String getCodigoMtx() {
        return codigoMtx;
    }


    /**
     * Sets the codigoMtx value for this ItemType.
     * 
     * @param codigoMtx
     */
    public void setCodigoMtx(java.lang.String codigoMtx) {
        this.codigoMtx = codigoMtx;
    }


    /**
     * Gets the codigo value for this ItemType.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this ItemType.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the descripcion value for this ItemType.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ItemType.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the codNomMercosur value for this ItemType.
     * 
     * @return codNomMercosur
     */
    public java.lang.String getCodNomMercosur() {
        return codNomMercosur;
    }


    /**
     * Sets the codNomMercosur value for this ItemType.
     * 
     * @param codNomMercosur
     */
    public void setCodNomMercosur(java.lang.String codNomMercosur) {
        this.codNomMercosur = codNomMercosur;
    }


    /**
     * Gets the cantidad value for this ItemType.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ItemType.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the codigoUnidadMedida value for this ItemType.
     * 
     * @return codigoUnidadMedida
     */
    public java.lang.Short getCodigoUnidadMedida() {
        return codigoUnidadMedida;
    }


    /**
     * Sets the codigoUnidadMedida value for this ItemType.
     * 
     * @param codigoUnidadMedida
     */
    public void setCodigoUnidadMedida(java.lang.Short codigoUnidadMedida) {
        this.codigoUnidadMedida = codigoUnidadMedida;
    }


    /**
     * Gets the precioUnitario value for this ItemType.
     * 
     * @return precioUnitario
     */
    public java.math.BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }


    /**
     * Sets the precioUnitario value for this ItemType.
     * 
     * @param precioUnitario
     */
    public void setPrecioUnitario(java.math.BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }


    /**
     * Gets the importeBonificacion value for this ItemType.
     * 
     * @return importeBonificacion
     */
    public java.math.BigDecimal getImporteBonificacion() {
        return importeBonificacion;
    }


    /**
     * Sets the importeBonificacion value for this ItemType.
     * 
     * @param importeBonificacion
     */
    public void setImporteBonificacion(java.math.BigDecimal importeBonificacion) {
        this.importeBonificacion = importeBonificacion;
    }


    /**
     * Gets the codigoCondicionIVA value for this ItemType.
     * 
     * @return codigoCondicionIVA
     */
    public short getCodigoCondicionIVA() {
        return codigoCondicionIVA;
    }


    /**
     * Sets the codigoCondicionIVA value for this ItemType.
     * 
     * @param codigoCondicionIVA
     */
    public void setCodigoCondicionIVA(short codigoCondicionIVA) {
        this.codigoCondicionIVA = codigoCondicionIVA;
    }


    /**
     * Gets the importeIVA value for this ItemType.
     * 
     * @return importeIVA
     */
    public java.math.BigDecimal getImporteIVA() {
        return importeIVA;
    }


    /**
     * Sets the importeIVA value for this ItemType.
     * 
     * @param importeIVA
     */
    public void setImporteIVA(java.math.BigDecimal importeIVA) {
        this.importeIVA = importeIVA;
    }


    /**
     * Gets the importeItem value for this ItemType.
     * 
     * @return importeItem
     */
    public java.math.BigDecimal getImporteItem() {
        return importeItem;
    }


    /**
     * Sets the importeItem value for this ItemType.
     * 
     * @param importeItem
     */
    public void setImporteItem(java.math.BigDecimal importeItem) {
        this.importeItem = importeItem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemType)) return false;
        ItemType other = (ItemType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orden == other.getOrden() &&
            ((this.unidadesMtx==null && other.getUnidadesMtx()==null) || 
             (this.unidadesMtx!=null &&
              this.unidadesMtx.equals(other.getUnidadesMtx()))) &&
            ((this.codigoMtx==null && other.getCodigoMtx()==null) || 
             (this.codigoMtx!=null &&
              this.codigoMtx.equals(other.getCodigoMtx()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.codNomMercosur==null && other.getCodNomMercosur()==null) || 
             (this.codNomMercosur!=null &&
              this.codNomMercosur.equals(other.getCodNomMercosur()))) &&
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.codigoUnidadMedida==null && other.getCodigoUnidadMedida()==null) || 
             (this.codigoUnidadMedida!=null &&
              this.codigoUnidadMedida.equals(other.getCodigoUnidadMedida()))) &&
            ((this.precioUnitario==null && other.getPrecioUnitario()==null) || 
             (this.precioUnitario!=null &&
              this.precioUnitario.equals(other.getPrecioUnitario()))) &&
            ((this.importeBonificacion==null && other.getImporteBonificacion()==null) || 
             (this.importeBonificacion!=null &&
              this.importeBonificacion.equals(other.getImporteBonificacion()))) &&
            this.codigoCondicionIVA == other.getCodigoCondicionIVA() &&
            ((this.importeIVA==null && other.getImporteIVA()==null) || 
             (this.importeIVA!=null &&
              this.importeIVA.equals(other.getImporteIVA()))) &&
            ((this.importeItem==null && other.getImporteItem()==null) || 
             (this.importeItem!=null &&
              this.importeItem.equals(other.getImporteItem())));
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
        _hashCode += getOrden();
        if (getUnidadesMtx() != null) {
            _hashCode += getUnidadesMtx().hashCode();
        }
        if (getCodigoMtx() != null) {
            _hashCode += getCodigoMtx().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getCodNomMercosur() != null) {
            _hashCode += getCodNomMercosur().hashCode();
        }
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getCodigoUnidadMedida() != null) {
            _hashCode += getCodigoUnidadMedida().hashCode();
        }
        if (getPrecioUnitario() != null) {
            _hashCode += getPrecioUnitario().hashCode();
        }
        if (getImporteBonificacion() != null) {
            _hashCode += getImporteBonificacion().hashCode();
        }
        _hashCode += getCodigoCondicionIVA();
        if (getImporteIVA() != null) {
            _hashCode += getImporteIVA().hashCode();
        }
        if (getImporteItem() != null) {
            _hashCode += getImporteItem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gob.afip.wsfecred/FECredService/", "ItemType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orden");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadesMtx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidadesMtx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoMtx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoMtx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codNomMercosur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codNomMercosur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoUnidadMedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoUnidadMedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precioUnitario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precioUnitario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeBonificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeBonificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoCondicionIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoCondicionIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importeItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
