//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//


package pl.clinic.vxml.schema.impl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrammarScope.datatype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GrammarScope.datatype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="document"/>
 *     &lt;enumeration value="dialog"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GrammarScope.datatype")
@XmlEnum
public enum GrammarScopeDatatype {

    @XmlEnumValue("document")
    DOCUMENT("document"),
    @XmlEnumValue("dialog")
    DIALOG("dialog");
    private final String value;

    GrammarScopeDatatype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GrammarScopeDatatype fromValue(String v) {
        for (GrammarScopeDatatype c: GrammarScopeDatatype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
