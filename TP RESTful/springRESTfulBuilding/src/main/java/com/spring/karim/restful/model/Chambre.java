
package com.spring.karim.restful.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Chambre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
    protected int numero;
    protected String typeLit;
    protected double prix;
    protected String disponible;
    @ManyToOne(fetch = FetchType.EAGER)
    protected Hotel hotel;

}
