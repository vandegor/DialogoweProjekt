//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.02 at 12:05:55 AM CET 
//


package model.java.vxml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.w3.org/2001/vxml}audio"/>
 *         &lt;group ref="{http://www.w3.org/2001/vxml}event.handler"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}filled"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}param"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}property"/>
 *         &lt;element ref="{http://www.w3.org/2001/vxml}prompt"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Cache.attribs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Form-item.attribs"/>
 *       &lt;attribute name="classid" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *       &lt;attribute name="codebase" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *       &lt;attribute name="data" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="codetype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="archive" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "object")
public class Object {

    @XmlElementRefs({
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "catch", namespace = "http://www.w3.org/2001/vxml", type = Catch.class, required = false),
        @XmlElementRef(name = "nomatch", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "filled", namespace = "http://www.w3.org/2001/vxml", type = Filled.class, required = false),
        @XmlElementRef(name = "noinput", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "help", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "param", namespace = "http://www.w3.org/2001/vxml", type = Param.class, required = false),
        @XmlElementRef(name = "property", namespace = "http://www.w3.org/2001/vxml", type = Property.class, required = false),
        @XmlElementRef(name = "prompt", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "enumerate", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "value", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "error", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<java.lang.Object> content;
    @XmlAttribute(name = "classid")
    protected String classid;
    @XmlAttribute(name = "codebase")
    protected String codebase;
    @XmlAttribute(name = "data")
    protected String data;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "codetype")
    protected String codetype;
    @XmlAttribute(name = "archive")
    protected String archive;
    @XmlAttribute(name = "fetchtimeout")
    protected String fetchtimeout;
    @XmlAttribute(name = "maxage")
    protected BigInteger maxage;
    @XmlAttribute(name = "fetchhint")
    protected FetchhintDatatype fetchhint;
    @XmlAttribute(name = "maxstale")
    protected BigInteger maxstale;
    @XmlAttribute(name = "cond")
    protected String cond;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "expr")
    protected String expr;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Catch }
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link Property }
     * {@link JAXBElement }{@code <}{@link VxmlSpeak }{@code >}
     * {@link JAXBElement }{@code <}{@link Value }{@code >}
     * {@link JAXBElement }{@code <}{@link Audio }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link Filled }
     * {@link Param }
     * {@link String }
     * {@link JAXBElement }{@code <}{@link Enumerate }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * 
     * 
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the classid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassid() {
        return classid;
    }

    /**
     * Sets the value of the classid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassid(String value) {
        this.classid = value;
    }

    /**
     * Gets the value of the codebase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodebase() {
        return codebase;
    }

    /**
     * Sets the value of the codebase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodebase(String value) {
        this.codebase = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the codetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodetype() {
        return codetype;
    }

    /**
     * Sets the value of the codetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodetype(String value) {
        this.codetype = value;
    }

    /**
     * Gets the value of the archive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchive() {
        return archive;
    }

    /**
     * Sets the value of the archive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchive(String value) {
        this.archive = value;
    }

    /**
     * Gets the value of the fetchtimeout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFetchtimeout() {
        return fetchtimeout;
    }

    /**
     * Sets the value of the fetchtimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFetchtimeout(String value) {
        this.fetchtimeout = value;
    }

    /**
     * Gets the value of the maxage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxage() {
        return maxage;
    }

    /**
     * Sets the value of the maxage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxage(BigInteger value) {
        this.maxage = value;
    }

    /**
     * Gets the value of the fetchhint property.
     * 
     * @return
     *     possible object is
     *     {@link FetchhintDatatype }
     *     
     */
    public FetchhintDatatype getFetchhint() {
        return fetchhint;
    }

    /**
     * Sets the value of the fetchhint property.
     * 
     * @param value
     *     allowed object is
     *     {@link FetchhintDatatype }
     *     
     */
    public void setFetchhint(FetchhintDatatype value) {
        this.fetchhint = value;
    }

    /**
     * Gets the value of the maxstale property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxstale() {
        return maxstale;
    }

    /**
     * Sets the value of the maxstale property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxstale(BigInteger value) {
        this.maxstale = value;
    }

    /**
     * Gets the value of the cond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCond() {
        return cond;
    }

    /**
     * Sets the value of the cond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCond(String value) {
        this.cond = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the expr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpr() {
        return expr;
    }

    /**
     * Sets the value of the expr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpr(String value) {
        this.expr = value;
    }

}
