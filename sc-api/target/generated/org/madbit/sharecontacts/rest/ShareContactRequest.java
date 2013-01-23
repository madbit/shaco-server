//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.23 at 10:58:45 AM CET 
//


package org.madbit.sharecontacts.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.madbit.org/ShareContactService}User"/>
 *         &lt;element name="to_contact" type="{http://www.madbit.org/ShareContactService}Contact"/>
 *         &lt;element name="contact_to_share" type="{http://www.madbit.org/ShareContactService}Contact"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user",
    "toContact",
    "contactToShare"
})
@XmlRootElement(name = "ShareContactRequest")
public class ShareContactRequest {

    @XmlElement(required = true)
    protected User user;
    @XmlElement(name = "to_contact", required = true)
    protected Contact toContact;
    @XmlElement(name = "contact_to_share", required = true)
    protected Contact contactToShare;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the toContact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getToContact() {
        return toContact;
    }

    /**
     * Sets the value of the toContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setToContact(Contact value) {
        this.toContact = value;
    }

    /**
     * Gets the value of the contactToShare property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContactToShare() {
        return contactToShare;
    }

    /**
     * Sets the value of the contactToShare property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContactToShare(Contact value) {
        this.contactToShare = value;
    }

}
