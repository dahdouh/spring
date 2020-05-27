package com.spring.myschool.restful.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String firstname;
	public String lastname;
	public String email;
	public String tel;
	public String ville;
	//public String twitter;
	/*-------- for student ---------*/
	public String level;
	public String sex;
	@OneToOne()
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
	public User parent;
	/*---- father, mother, other ----*/
	public String parentRelation;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "compte_id", referencedColumnName = "id")
	public Compte compte;
	/*	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	public List<Recommendation> recommendations;
	*/
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	public List<LogSession> logSession;
	
	public User() {	}
	
	public User(String firstname, String lastname, String email, String tel, String ville) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.tel = tel;
		this.ville = ville;
	}
	
	public User(String firstname, String lastname, String level, String parent) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
		this.parentRelation = parent;
	}
	
	
}
