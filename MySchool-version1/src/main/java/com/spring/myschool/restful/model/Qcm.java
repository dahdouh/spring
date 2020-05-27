package com.spring.myschool.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Qcm")
public class Qcm {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public int id;
	@Column
	public String question;
	@Column
	public String response;
	@Column
	public int exercice_id;
	@Column
	public String libelle;

}
