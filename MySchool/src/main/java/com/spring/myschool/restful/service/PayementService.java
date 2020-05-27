package com.spring.myschool.restful.service;

import java.util.List;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;

public interface PayementService {
	
	void savePayement(Payement payement);
	List<Payement> getPayement(User user);


}
