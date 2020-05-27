package com.spring.myschool.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exercice")
public class Exercice {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public int id;
	@Column
	public String libelle;
	@Column
	public Double note;
	@Column
	public int course_id;
	
}
