
package com.exo.soap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour updatePersonne complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="updatePersonne">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://service.soap.exo.com/}personne" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonne", propOrder = {
    "arg0",
    "arg1"
})
public class UpdatePersonne {

    protected Long arg0;
    protected Personne arg1;

    /**
     * Obtient la valeur de la propri�t� arg0.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArg0() {
        return arg0;
    }

    /**
     * D�finit la valeur de la propri�t� arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArg0(Long value) {
        this.arg0 = value;
    }

    /**
     * Obtient la valeur de la propri�t� arg1.
     * 
     * @return
     *     possible object is
     *     {@link Personne }
     *     
     */
    public Personne getArg1() {
        return arg1;
    }

    /**
     * D�finit la valeur de la propri�t� arg1.
     * 
     * @param value
     *     allowed object is
     *     {@link Personne }
     *     
     */
    public void setArg1(Personne value) {
        this.arg1 = value;
    }

}
