package com.ecole.serveur.dao;

import java.util.List;

import com.ecole.serveur.model.Course;
import com.ecole.serveur.model.Course_content;
import com.ecole.serveur.model.Course_progress;
import com.ecole.serveur.model.Exercice;
import com.ecole.serveur.model.Exercice_progress;
import com.ecole.serveur.model.Listchoices;
import com.ecole.serveur.model.Qcm;

public interface CourseDao {
	
	List<Course> get();
	
	List<Course_content> getContent();
	
    List<Exercice> getExerice();
    
	//Course get(int id);
	
	List<Course> get(int id);

	List<Course_content> getContent(int course_id);
	
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
