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
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.dao.CourseDao;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao coursedao;
	
	@Transactional
	@Override
	public List<Course> get() {
		
		return coursedao.get();
	}
	@Override
	public List<Course> getCourseRecommendation() {
		
		return coursedao.getCourseRecommendation();
	}
	
	@Override
	public Course getCourseById(int id) {
		return coursedao.getCourseById(id);
	}
	
	@Override
	public void save(Course course) {
		coursedao.save(course);
	}
	

	@Override
	public List<Course_content> getContent() {
		
		return coursedao.getContent();
	}

	@Override
	public List<Exercice> getExerice() {
		
		return coursedao.getExerice();
	}


	@Override
	public List<Course_content> getContent(int course_id) {
		
		return coursedao.getContent(course_id);
	}

	@Override
	public List<Exercice> getExerice(int course_id) {
		
		return coursedao.getExerice(course_id);
	}

	@Override
	public List<Course> get(int id) {
		return coursedao.get(id);
	}

	@Override
	public List<Course_content> getContent(int course_id, int type) {
		return coursedao.getContent(course_id, type);
	}


	@Override
	public List<Exercice> getEx(int id) {
		return coursedao.getEx(id);
	}


	@Override
	public List<Qcm> getAllQcm() {
		return coursedao.getAllQcm();
	}


	@Override
	public List<Qcm> getQcm(int id) {
		return coursedao.getQcm(id);
	}


	@Override
	public List<Listchoices> getChoices(int qcm_id) {
		return coursedao.getChoices(qcm_id);
	}


	@Override
	public void updateCourseProgress(int course_id) {
		coursedao.updateCourseProgress(course_id);
	}


	@Override
	public void updateExerciceProgress(int exercice_id) {
		coursedao.updateExerciceProgress(exercice_id);
	}


	@Override
	public List<Course_progress> getCourseProgress(int course_id) {
		return coursedao.getCourseProgress(course_id);
	}


	@Override
	public List<Exercice_progress> getExerciceProgress(int course_id) {
		return coursedao.getExerciceProgress(course_id);
	}

}
