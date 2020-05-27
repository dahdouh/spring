package com.spring.myschool.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Course_content")
public class Course_content {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public int id;
	@Column
	public String path;
	@Column
	public String title;
	@Column
	public int type;
	@Column
	public int course_id;
	
}
