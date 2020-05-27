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
import com.spring.myschool.restful.model.LogActivity;
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;

@Repository
public class LogDaoImpl implements LogDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveLog(LogActivity activity) {
		
		 Session session = entityManager.unwrap(Session.class);
		 session.save(activity);
	}

	@Override
	public List<LogActivity> getLog(User user) {
		Session session = entityManager.unwrap(Session.class);
	    Query<LogActivity> query = session.createQuery("from LogActivity l where l.user.id="+user.id, LogActivity.class);
	    
	    List<LogActivity> liste = query.getResultList();
	    return liste;
	}

	
	
}
