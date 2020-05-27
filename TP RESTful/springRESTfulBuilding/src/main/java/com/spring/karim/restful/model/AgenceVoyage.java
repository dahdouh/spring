
package com.spring.karim.restful.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@Entity
public class AgenceVoyage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
    protected String nom;
    protected String login;
    protected String password;
    protected double tarif;

}
