package com.spring.myschool.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Listchoices")
public class Listchoices {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public int id;
	@Column
	public String libelle;
	@Column
	public String code;
	@Column
	public int qcm_id;

}
