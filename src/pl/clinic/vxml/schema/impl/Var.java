//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//

package pl.clinic.vxml.schema.impl;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.clinic.vxml.schema.abstractImpl.AbstractNVC;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Expr.attrib"/>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/vxml}RestrictedVariableName.datatype" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "var")
public class Var extends AbstractNVC {

	@XmlAttribute(name = "name", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String name;
	@XmlAttribute(name = "expr")
	protected String expr;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the expr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExpr() {
		return expr;
	}

	/**
	 * Sets the value of the expr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExpr(String value) {
		this.expr = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<java.lang.Object> getObjectChildrens() {
		return Collections.EMPTY_LIST;
	}

}
