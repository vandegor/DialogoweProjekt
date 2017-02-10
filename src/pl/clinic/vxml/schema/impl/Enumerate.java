//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.05 at 03:42:58 PM CET 
//


package pl.clinic.vxml.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;group ref="{http://www.w3.org/2001/vxml}allowed-within-sentence"/>
 *         &lt;group ref="{http://www.w3.org/2001/vxml}structure"/>
 *         &lt;element name="foreach" type="{http://www.w3.org/2001/vxml}foreach-in-prompt.type"/>
 *       &lt;/choice>
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
public class Enumerate {

    @XmlElementRefs({
        @XmlElementRef(name = "struct", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "foreach", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "aws", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;

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
     * {@link JAXBElement }{@code <}{@link Value }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Voice }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link Enumerate }{@code >}
     * {@link JAXBElement }{@code <}{@link Mark }{@code >}
     * {@link JAXBElement }{@code <}{@link Paragraph }{@code >}
     * {@link JAXBElement }{@code <}{@link Audio }{@code >}
     * {@link JAXBElement }{@code <}{@link Break }{@code >}
     * {@link JAXBElement }{@code <}{@link SayAs }{@code >}
     * {@link JAXBElement }{@code <}{@link Sentence }{@code >}
     * {@link JAXBElement }{@code <}{@link Emphasis }{@code >}
     * {@link JAXBElement }{@code <}{@link ForeachInPromptType }{@code >}
     * {@link JAXBElement }{@code <}{@link Phoneme }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Prosody }{@code >}
     * {@link JAXBElement }{@code <}{@link Sub }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

}