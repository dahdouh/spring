package com.spring.myschool.restful.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;

@Repository
public class PayementDaoImpl implements PayementDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void savePayement(Payement payement) {
		
		 Session session = entityManager.unwrap(Session.class);
		 session.save(payement);
		
	}

	@Override
	public List<Payement> getPayement(User user) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Payement> query = session.createQuery("from Payement p where p.user.id="+user.id, Payement.class);
	    
	    List<Payement> liste = query.getResultList();
	    return liste;
	}

	
	
}
