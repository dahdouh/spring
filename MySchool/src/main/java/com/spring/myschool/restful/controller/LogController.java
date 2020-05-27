package com.spring.myschool.restful.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.spring.myschool.restful.repository.UserRepository;
import com.spring.myschool.restful.service.CourseService;
import com.spring.myschool.restful.service.LogService;
import com.spring.myschool.restful.service.PayementService;

@RestController
@RequestMapping("/api")
public class LogController {

	@Autowired
	private LogService logService;

	@Autowired
	public UserRepository userRepository;
	
	@RequestMapping("/log/{libelle}/{date}/{user_id}")
	public void savePayement(@PathVariable String libelle,@PathVariable String date, @PathVariable int user_id) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("d-M-yyyy");
		
		LogActivity log = new LogActivity();
		log.setLibelle(libelle);
		log.setDateActivity(formatter.parse(date));
		User u = userRepository.getUserById(user_id);
		u.setId(user_id);
		log.setUser(u);
		
		logService.saveLog(log);
	}
	
	@RequestMapping("/log/{user_id}")
	public List<LogActivity> getPayement(@PathVariable int user_id){
		
		User u = new User();
		u.setId(user_id);
		u.getId();
		return logService.getLog(u);
	}
}
