package com.spring.myschool.restful.service;

import java.util.List;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.Qcm;

public interface CourseService {

    List<Course> get();
    List<Course> getCourseRecommendation();
    Course getCourseById(int id);
    void save(Course course);
	List<Course_content> getContent();
    List<Exercice> getExerice();
	//Course get(int id);  
	List<Course_content> getContent(int course_id);

	List<Course> get(int id);

	List<Course_content> getContent(int course_id,int type);

	List<Exercice> getExerice(int course_id);
	List<Exercice> getEx(int id);
	List<Qcm> getAllQcm();
	List<Qcm> getQcm(int id);
	List<Listchoices> getChoices(int qcm_id);

	void updateCourseProgress (int course_id);
	void updateExerciceProgress (int exercice_id);
	
	List<Course_progress> getCourseProgress(int course_id);
	List<Exercice_progress> getExerciceProgress(int course_id);


}
