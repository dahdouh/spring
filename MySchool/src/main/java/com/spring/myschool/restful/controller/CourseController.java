package com.spring.myschool.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Course;
import com.spring.myschool.restful.model.Course_content;
import com.spring.myschool.restful.model.Course_progress;
import com.spring.myschool.restful.model.Exercice;
import com.spring.myschool.restful.model.Exercice_progress;
import com.spring.myschool.restful.model.Listchoices;
import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.repository.CoursRepo;
import com.spring.myschool.restful.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private CoursRepo coursRepo;
	
	
	@RequestMapping("/cours")
	public List<Course> getCours(){
		return courseService.get();
	}
	
	@RequestMapping("/cours/recommendation")
	public List<Course> getCoursByUser(){
		return courseService.getCourseRecommendation();
	}
	
	@RequestMapping("/cours/contenu")
	public List<Course_content> getContent(){
		return courseService.getContent();
	}
	@RequestMapping("/cours/exercice")
	public List<Exercice> getExercice(){
		return courseService.getExerice();
	}
	@RequestMapping("/cours/{id}")
	public List<Course> getRecherche(@PathVariable int id){
		return courseService.get(id);
	}
	@RequestMapping("/cours/contenu/{course_id}")
	public List<Course_content> getContent(@PathVariable int course_id){
		return courseService.getContent(course_id);
	}
	@RequestMapping("/cours/exercice/{course_id}")
	public List<Exercice> getExercice(@PathVariable int course_id){
		return courseService.getExerice(course_id);
	}
	@RequestMapping("/cours/contenu/{course_id}/{type}")
	public List<Course_content> getContent(@PathVariable int course_id,@PathVariable int type){
		return courseService.getContent(course_id,type);
	}
	@RequestMapping("/cours/exercice/exercice/{id}")
	public List<Exercice> getExe(@PathVariable int id){
		return courseService.getEx(id);
	}
	@RequestMapping("/cours/exercice/qcm")
	public List<Qcm> getQcm(){
		return courseService.getAllQcm();
		
	}
	@RequestMapping("/cours/exercice/qcm/{id}")
	public List<Qcm> getQcm(@PathVariable int id){
		return courseService.getQcm(id);
	}
	@RequestMapping("/cours/exercice/listechoices/{qcm_id}")
	public List<Listchoices> getListChoices(@PathVariable int qcm_id){
		return courseService.getChoices(qcm_id);
	}
	
	
	@RequestMapping("/cours/progress/update/{course_id}")
	public void updateCourseprogress(@PathVariable int course_id){
		courseService.updateCourseProgress(course_id);
	}
	
	@RequestMapping("/cours/exercice/progress/update/{exercice_id}")
	public void updateExerciceprogress(@PathVariable int exercice_id){
		courseService.updateExerciceProgress(exercice_id);
	}
	
	@RequestMapping("/cours/progress/{course_id}")
	public List<Course_progress> getCourseProgress(@PathVariable int course_id){
		return courseService.getCourseProgress(course_id);
	}
	@RequestMapping("/cours/exercice/progress/{course_id}")
	public List<Exercice_progress> getExerciceProgress(@PathVariable int course_id){
		return courseService.getExerciceProgress(course_id);
	}
	
	
	
	
	
	//@GetMapping("/course/synchronize/{id}/{libelle}/{description}/{image}/{level}/{progress}")
	@GetMapping("/course/synchronize/{id}/{progress}")
	public Course synchronizeCourse(@PathVariable int id, @PathVariable String progress) {
		Course course = courseService.getCourseById(id);
		course.setProgress(progress);
		coursRepo.updateSynch(id, progress);
		return course;
	}
}
