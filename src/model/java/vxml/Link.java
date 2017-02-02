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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;group ref="{http://www.w3.org/2001/vxml}input" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Next.attribs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Cache.attribs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Throw.attribs"/>
 *       &lt;attribute name="fetchaudio" type="{http://www.w3.org/2001/vxml}URI.datatype" />
 *       &lt;attribute name="dtmf" type="{http://www.w3.org/2001/vxml}DTMFSequence.datatype" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "input"
})
@XmlRootElement(name = "link")
public class Link {

    @XmlElement(name = "grammar")
    protected List<MixedGrammar> input;
    @XmlAttribute(name = "fetchaudio")
    protected String fetchaudio;
    @XmlAttribute(name = "dtmf")
    protected String dtmf;
    @XmlAttribute(name = "expr")
    protected String expr;
    @XmlAttribute(name = "next")
    protected String next;
    @XmlAttribute(name = "fetchtimeout")
    protected String fetchtimeout;
    @XmlAttribute(name = "maxage")
    protected BigInteger maxage;
    @XmlAttribute(name = "fetchhint")
    protected FetchhintDatatype fetchhint;
    @XmlAttribute(name = "maxstale")
    protected BigInteger maxstale;
    @XmlAttribute(name = "event")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String event;
    @XmlAttribute(name = "eventexpr")
    protected String eventexpr;
    @XmlAttribute(name = "message")
    protected String message;
    @XmlAttribute(name = "messageexpr")
    protected String messageexpr;

    /**
     * Gets the value of the input property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the input property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MixedGrammar }
     * 
     * 
     */
    public List<MixedGrammar> getInput() {
        if (input == null) {
            input = new ArrayList<MixedGrammar>();
        }
        return this.input;
    }

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
     * Gets the value of the dtmf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtmf() {
        return dtmf;
    }

    /**
     * Sets the value of the dtmf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtmf(String value) {
        this.dtmf = value;
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
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the eventexpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventexpr() {
        return eventexpr;
    }

    /**
     * Sets the value of the eventexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventexpr(String value) {
        this.eventexpr = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the messageexpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageexpr() {
        return messageexpr;
    }

    /**
     * Sets the value of the messageexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageexpr(String value) {
        this.messageexpr = value;
    }

}
