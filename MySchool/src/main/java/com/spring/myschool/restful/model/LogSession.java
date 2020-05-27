package com.spring.myschool.restful.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class LogSession {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public Date dateConnexion;
	public Date dateDeconnexion;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="logSesseion")
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	public User user;
	
	public LogSession() {
		
	}
	
	public LogSession(Date dateConnextion, User user) {
		this.dateConnexion = dateConnextion;
		this.user = user;
	}
	

}
