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
import com.spring.myschool.restful.model.Qcm;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Course> get() {
	    Session session = entityManager.unwrap(Session.class);
	    Query<Course> query = session.createQuery("from Course ", Course.class);
	    
	    List<Course> liste = query.getResultList();
	    return liste;	   
	}
	
	@Override
	public List<Course> getCourseRecommendation() {
	    Session session = entityManager.unwrap(Session.class);
	    List<Course> liste = session.createQuery("from Course ", Course.class).setMaxResults(5).getResultList();
	    
	    return liste;
	    
	}
	
	@Override
	public Course getCourseById(int id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Course> query = session.createQuery("from Course c where c.id="+ id, Course.class);
	    
	    return  query.getSingleResult();
	}
	
	@Override
	public void save(Course course) {
		//entityManager.getTransaction().begin();
	    javax.persistence.Query query = entityManager.createNativeQuery("update Course c set c.progress = :progress where c.id = :id ");
	    query.setParameter("id", course.getId());
	    query.setParameter("libelle", course.getLibelle());
	    query.setParameter("description", course.getDescription());
	    query.setParameter("image", course.getImage());
	    query.setParameter("level", course.getLevel());
	    query.setParameter("progress", course.getProgress());
	    query.executeUpdate();
	    //entityManager.getTransaction().commit();
	}



	@Override
	public List<Course_content> getContent() {
		 	Session session = entityManager.unwrap(Session.class);
		    Query<Course_content> query = session.createQuery("from Course_content", Course_content.class);
		    
		    List<Course_content> liste = query.getResultList();
		    return liste;
	}

	@Override
	public List<Exercice> getExerice() {
		Session session = entityManager.unwrap(Session.class);
	    Query<Exercice> query = session.createQuery("from Exercice", Exercice.class);
	    
	    List<Exercice> liste = query.getResultList();
	    return liste;
	}

	

	@Override
	public List<Course_content> getContent(int course_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Course_content> query = session.createQuery("from Course_content c where c.course_id="+course_id+" and c.type="+1, Course_content.class);
	    
	    List<Course_content> liste = query.getResultList();
	    return liste;
	}

	@Override
	public List<Exercice> getExerice(int course_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Exercice> query = session.createQuery("from Exercice e where e.course_id="+course_id, Exercice.class);
	    
	    List<Exercice> liste = query.getResultList();
	    return liste;
	}

	@Override
	public List<Course> get(int id) {
		Session session = entityManager.unwrap(Session.class);
		String a ="Maths";
	    Query<Course> query = session.createQuery("from Course  where id="+id, Course.class);
	    
	    List<Course> liste = query.getResultList();
	    return liste;
	}

	@Override
	public List<Course_content> getContent(int course_id, int type) {
		
		Session session = entityManager.unwrap(Session.class);
	    Query<Course_content> query = session.createQuery("from Course_content c where c.course_id="+course_id+" and c.type="+type, Course_content.class);
	    
	    List<Course_content> liste = query.getResultList();
	    return liste;
	
	}



	@Override
	public List<Exercice> getEx(int id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Exercice> query = session.createQuery("from Exercice e where e.id="+id, Exercice.class);
	    
	    List<Exercice> liste = query.getResultList();
	    return liste;
	}



	@Override
	public List<Qcm> getAllQcm() {
	
		Session session = entityManager.unwrap(Session.class);
	    Query<Qcm> query = session.createQuery("from Qcm", Qcm.class);
	    
	    List<Qcm> liste = query.getResultList();
	    return liste;
	}



	@Override
	public List<Qcm> getQcm(int id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Qcm> query = session.createQuery("from Qcm q where q.id="+id, Qcm.class);
	    
	    List<Qcm> liste = query.getResultList();
	    return liste;
	}



	@Override
	public List<Listchoices> getChoices(int qcm_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Listchoices> query = session.createQuery("from Listchoices l where l.qcm_id="+qcm_id, Listchoices.class);
	    
	    List<Listchoices> liste = query.getResultList();
	    return liste;
	}



	@Override
	public void updateCourseProgress(int course_id) {
		
		entityManager.getTransaction().begin();
	    javax.persistence.Query query = entityManager.createNativeQuery("update from Course_progress e set e.state='done' where e.id_course = :course_id ");
	    //entityManager.createQuery("update from Course_progress e set e.state='done' where e.id_course = :course_id ").setParameter("course_id", course_id);
	   // entityManager.createQuery("delete from TrainingEntry e where e.module = :mod and e.completedDate IS NULL").setParameter("mod", mod);
	    query.setParameter("course_id", course_id);
	    query.executeUpdate();
	    entityManager.getTransaction().commit();
	    
	    
	}



	@Override
	public void updateExerciceProgress(int exercice_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Exercice_progress> query = session.createQuery("update from Exercice_progress e set e.state='done' where e.id_exercice="+exercice_id, Exercice_progress.class);
	    
		query.executeUpdate();		
	}



	@Override
	public List<Course_progress> getCourseProgress(int course_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Course_progress> query = session.createQuery("from Course_progress cp where cp.id_course="+course_id, Course_progress.class);
	    
	    List<Course_progress> liste = query.getResultList();
	    return liste;
	}



	@Override
	public List<Exercice_progress> getExerciceProgress(int course_id) {
		Session session = entityManager.unwrap(Session.class);
	    Query<Exercice_progress> query = session.createQuery("from Exercice_progress ep where ep.id_course="+course_id, Exercice_progress.class);
	    
	    List<Exercice_progress> liste = query.getResultList();
	    return liste;
	}

}
