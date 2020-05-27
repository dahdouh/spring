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
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String login;
	public String password;
	public String activate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
	public Profile profile;
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "compte")
//	public User user;
	
	public Compte() {
	}

	public Compte(String login, String password){
		this.login = login;
		this.password = password;
	}
	

}