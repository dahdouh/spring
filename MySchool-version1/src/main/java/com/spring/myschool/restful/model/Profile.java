package com.spring.myschool.restful.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String libelle;
	public String role;
	
	public Profile() {
		
	}
	
	public Profile(String libelle, String role) {
		this.libelle = libelle;
		this.role = role;
	}
	

}
