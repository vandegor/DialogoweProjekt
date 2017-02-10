//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//


package pl.clinic.vxml.schema.impl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Next.attribs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Cache.attribs"/>
 *       &lt;attribute name="fetchaudio" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *       &lt;attribute name="expritem" type="{http://www.w3.org/2001/vxml}Script.datatype" />
 *       &lt;attribute name="nextitem" type="{http://www.w3.org/2001/vxml}RestrictedVariableName.datatype" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "goto")
public class Goto {

    @XmlAttribute(name = "fetchaudio")
    protected String fetchaudio;
    @XmlAttribute(name = "expritem")
    protected String expritem;
    @XmlAttribute(name = "nextitem")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nextitem;
    @XmlAttribute(name = "expr")
    protected String expr;
    @XmlAttribute(name = "next")
    protected String next;
    @XmlAttribute(name = "fetchtimeout")
    protected String fetchtimeout;
    @XmlAttribute(name = "maxstale")
    protected BigInteger maxstale;
    @XmlAttribute(name = "fetchhint")
    protected FetchhintDatatype fetchhint;
    @XmlAttribute(name = "maxage")
    protected BigInteger maxage;

    /**
     * Gets the value of the fetchaudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFetchaudio() {
        return fetchaudio;
    }

    /**
     * Sets the value of the fetchaudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFetchaudio(String value) {
        this.fetchaudio = value;
    }

    /**
     * Gets the value of the expritem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpritem() {
        return expritem;
    }

    /**
     * Sets the value of the expritem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpritem(String value) {
        this.expritem = value;
    }

    /**
     * Gets the value of the nextitem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextitem() {
        return nextitem;
    }

    /**
     * Sets the value of the nextitem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextitem(String value) {
        this.nextitem = value;
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

    /**
     * Gets the value of the next property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNext() {
        return next;
    }

    /**
     * Sets the value of the next property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNext(String value) {
        this.next = value;
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

}