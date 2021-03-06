//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//


package pl.clinic.vxml.schema.impl;

import java.util.ArrayList;
import java.util.List;
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
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Throw.attribs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/vxml}Namelist.attrib"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "return")
public class Return {

    @XmlAttribute(name = "event")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String event;
    @XmlAttribute(name = "eventexpr")
    protected String eventexpr;
    @XmlAttribute(name = "message")
    protected String message;
    @XmlAttribute(name = "messageexpr")
    protected String messageexpr;
    @XmlAttribute(name = "namelist")
    protected List<String> namelist;

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

    /**
     * Gets the value of the namelist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the namelist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNamelist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNamelist() {
        if (namelist == null) {
            namelist = new ArrayList<String>();
        }
        return this.namelist;
    }

}
