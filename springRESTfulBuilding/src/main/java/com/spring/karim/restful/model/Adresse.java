
package com.spring.karim.restful.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
    protected String pays;
    protected String vile;
    protected String rue;
    protected int numero;
    protected String positionGPS;


}
