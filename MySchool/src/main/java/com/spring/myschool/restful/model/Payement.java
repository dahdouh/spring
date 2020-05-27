package com.spring.myschool.restful.model;

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
public class Payement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nom_proprietaire;
	public String numero_carte;
	public int mois_expiration;
	public int annee_expiration;
	public int cryptonyme_carte;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	public User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_proprietaire() {
		return nom_proprietaire;
	}

	public void setNom_proprietaire(String nom_proprietaire) {
		this.nom_proprietaire = nom_proprietaire;
	}

	public String getNumero_carte() {
		return numero_carte;
	}

	public void setNumero_carte(String numero_carte) {
		this.numero_carte = numero_carte;
	}

	public int getMois_expiration() {
		return mois_expiration;
	}

	public void setMois_expiration(int mois_expiration) {
		this.mois_expiration = mois_expiration;
	}

	public int getAnnee_expiration() {
		return annee_expiration;
	}

	public void setAnnee_expiration(int annee_expiration) {
		this.annee_expiration = annee_expiration;
	}

	public int getCryptonyme_carte() {
		return cryptonyme_carte;
	}

	public void setCryptonyme_carte(int cryptonyme_carte) {
		this.cryptonyme_carte = cryptonyme_carte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}