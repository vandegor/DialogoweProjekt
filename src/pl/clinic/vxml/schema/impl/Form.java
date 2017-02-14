//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//

package pl.clinic.vxml.schema.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.clinic.vxml.schema.abstractImpl.AbstractIVC;

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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.w3.org/2001/vxml}event.handler"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}filled"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}initial"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}object"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}link"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}property"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}record"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}script"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}subdialog"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}transfer"/>
 *         &lt;group ref="{http://www.w3.org/2001/vxml}variable"/>
 *         &lt;group ref="{http://www.w3.org/2001/vxml}input"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}GrammarScope.attrib"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "catchOrHelpOrNoinput" })
@XmlRootElement(name = "form")
public class Form extends AbstractIVC {

	@XmlElementRefs({
			@XmlElementRef(name = "script", namespace = "http://www.w3.org/2001/vxml", type = Script.class, required = false),
			@XmlElementRef(name = "transfer", namespace = "http://www.w3.org/2001/vxml", type = Transfer.class, required = false),
			@XmlElementRef(name = "catch", namespace = "http://www.w3.org/2001/vxml", type = Catch.class, required = false),
			@XmlElementRef(name = "property", namespace = "http://www.w3.org/2001/vxml", type = Property.class, required = false),
			@XmlElementRef(name = "grammar", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "object", namespace = "http://www.w3.org/2001/vxml", type = pl.clinic.vxml.schema.impl.Object.class, required = false),
			@XmlElementRef(name = "block", namespace = "http://www.w3.org/2001/vxml", type = Block.class, required = false),
			@XmlElementRef(name = "field", namespace = "http://www.w3.org/2001/vxml", type = Field.class, required = false),
			@XmlElementRef(name = "filled", namespace = "http://www.w3.org/2001/vxml", type = Filled.class, required = false),
			@XmlElementRef(name = "link", namespace = "http://www.w3.org/2001/vxml", type = Link.class, required = false),
			@XmlElementRef(name = "subdialog", namespace = "http://www.w3.org/2001/vxml", type = Subdialog.class, required = false),
			@XmlElementRef(name = "error", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "var", namespace = "http://www.w3.org/2001/vxml", type = Var.class, required = false),
			@XmlElementRef(name = "nomatch", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "help", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "noinput", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "initial", namespace = "http://www.w3.org/2001/vxml", type = Initial.class, required = false),
			@XmlElementRef(name = "record", namespace = "http://www.w3.org/2001/vxml", type = Record.class, required = false),
			@XmlElementRef(name = "data", namespace = "http://www.w3.org/2001/vxml", type = Data.class, required = false) })
	protected List<java.lang.Object> catchOrHelpOrNoinput;
	@XmlAttribute(name = "id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "scope")
	protected GrammarScopeDatatype scope;

	/**
	 * Gets the value of the catchOrHelpOrNoinput property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the catchOrHelpOrNoinput property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCatchOrHelpOrNoinput().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Script }
	 * {@link Transfer } {@link Catch } {@link Property } {@link JAXBElement
	 * }{@code <}{@link MixedGrammar }{@code >}
	 * {@link pl.clinic.vxml.schema.impl.Object } {@link Block } {@link Field }
	 * {@link Filled } {@link Link } {@link Subdialog } {@link JAXBElement
	 * }{@code <}{@link BasicEventHandler }{@code >} {@link Var }
	 * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
	 * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
	 * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
	 * {@link Initial } {@link Record } {@link Data }
	 * 
	 * 
	 */
	public List<java.lang.Object> getCatchOrHelpOrNoinput() {
		if (catchOrHelpOrNoinput == null) {
			catchOrHelpOrNoinput = new ArrayList<java.lang.Object>();
		}
		return this.catchOrHelpOrNoinput;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the scope property.
	 * 
	 * @return possible object is {@link GrammarScopeDatatype }
	 * 
	 */
	public GrammarScopeDatatype getScope() {
		if (scope == null) {
			return GrammarScopeDatatype.DIALOG;
		} else {
			return scope;
		}
	}

	/**
	 * Sets the value of the scope property.
	 * 
	 * @param value
	 *            allowed object is {@link GrammarScopeDatatype }
	 * 
	 */
	public void setScope(GrammarScopeDatatype value) {
		this.scope = value;
	}

	@Override
	public List<java.lang.Object> getObjectChildrens() {
		return getCatchOrHelpOrNoinput();
	}

}
