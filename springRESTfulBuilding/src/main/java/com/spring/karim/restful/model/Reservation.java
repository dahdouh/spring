
package com.spring.karim.restful.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected int id;
    protected String dateArrivee;
    protected String dateDepart;
    @OneToOne(fetch = FetchType.EAGER /*, cascade = {CascadeType.PERSIST, CascadeType.MERGE}*/)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    protected Client client;
    @OneToOne(fetch = FetchType.EAGER /*, cascade = {CascadeType.PERSIST, CascadeType.MERGE} */)
    @JoinColumn(name = "chambre_id", referencedColumnName = "id")
    protected Chambre chambre;
    @OneToOne(fetch = FetchType.EAGER /*, cascade = {CascadeType.PERSIST, CascadeType.MERGE} */)
    @JoinColumn(name = "agence_voyage_id", referencedColumnName = "id")
    protected AgenceVoyage agenceVoyage;

 }
