package com.spring.myschool.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.dao.CourseDao;
import com.spring.myschool.restful.dao.PayementDao;

@Service
public class PayementServiceImpl implements PayementService {

	@Autowired
	private PayementDao payementdao;
	
	@Transactional
	@Override
	public void savePayement(Payement payement) {
		payementdao.savePayement(payement);
		
	}
	@Transactional
	@Override
	public List<Payement> getPayement(User user) {
		
		return payementdao.getPayement(user);
	}

}
