//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.09 at 12:01:01 PM CET 
//


package com.spring.consumingSOAPwebservice.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Adresse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Adresse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="pays" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="vile" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="positionGPS" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresse", propOrder = {
    "id",
    "pays",
    "vile",
    "rue",
    "numero",
    "positionGPS"
})
public class Adresse {

    protected int id;
    @XmlElement(required = true)
    protected String pays;
    @XmlElement(required = true)
    protected String vile;
    @XmlElement(required = true)
    protected String rue;
    protected int numero;
    @XmlElement(required = true)
    protected String positionGPS;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPays(String value) {
        this.pays = value;
    }

    /**
     * Gets the value of the vile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVile() {
        return vile;
    }

    /**
     * Sets the value of the vile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVile(String value) {
        this.vile = value;
    }

    /**
     * Gets the value of the rue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRue() {
        return rue;
    }

    /**
     * Sets the value of the rue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRue(String value) {
        this.rue = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Gets the value of the positionGPS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionGPS() {
        return positionGPS;
    }

    /**
     * Sets the value of the positionGPS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionGPS(String value) {
        this.positionGPS = value;
    }

}
