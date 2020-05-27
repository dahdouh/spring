package com.spring.myschool.restful.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.CompteRepository;
import com.spring.myschool.restful.repository.LogSessionRepository;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;
import com.spring.myschool.restful.service.EmailService;
import com.spring.myschool.restful.service.EmailServiceImpl;

@RestController
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	public EmailService emailService = new EmailServiceImpl();
	
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public CompteRepository compteRepository;
	@Autowired
	public ProfileRepository profileRepository;
	@Autowired
	public LogSessionRepository logSessionRepository;
	
	
	/*------------------------- new student  ------------------------*/
	@GetMapping("/student/{userconnected}/{login}/{password}/{firstname}/{lastname}/{parent}/{level}/{sex}")
	public User addStudent(@PathVariable String userconnected, @PathVariable String firstname, @PathVariable String login, @PathVariable String password, @PathVariable String lastname, @PathVariable String parent, @PathVariable String level, @PathVariable String sex) {
		User user = new User(firstname, lastname, level, parent);
		user.setSex(sex);
		if(!firstname.equals("") && !lastname.equals("") && !parent.equals("") && !level.equals("")) {
			
			User student_parent = null;
			student_parent = userRepository.getUserByEmail(userconnected);
			if(student_parent == null) {
				System.out.println("######################### user not Exist "+ student_parent.getFirstname());
				user.setFirstname("user not exist");
				logger.info("user not exist!");
				
			} else {
				user.setParent(student_parent);
				//compteRepository.save(new Compte(login, password));
				Compte compte = new Compte();
				Profile profile = profileRepository.getProfileById(2);			
				compte.setProfile(profile);
				compte.setLogin(login);
				compte.setPassword(password);
				compte.setActivate("yes");
				user.setCompte(compte);
				userRepository.save(user);
				/*---------------- send email, contains students login and password, to parent ------------*/
				emailService.sendSimpleMessage(student_parent.getEmail(), "Online school registration", "Hi "+ student_parent.getLastname() +", We would to inform you that  your child registration is successfully done. To connect to the new account, please use "+login+" as username and "+ password +" as password.");
				logger.info("student has been successfully registred");
			}
		}
		
		return user;
	}
	
	/*------------------------- new student  ------------------------*/
	@GetMapping("/student_self/{login}/{password}/{firstname}/{lastname}/{email}/{level}/{sex}")
	public User studentSelf(@PathVariable String login, @PathVariable String password, 
							@PathVariable String firstname, @PathVariable String lastname,
							@PathVariable String email, @PathVariable String level, @PathVariable String sex) {
			User user = new User();			
			Compte compteExist = null;
			compteExist = compteRepository.getCompteByLogin(login);
			User userByEmail = userRepository.getUserByEmail(email);
			if(compteExist != null || userByEmail != null) {
				user.setFirstname("already exist");
				System.out.println("######################## already exist!!");
				logger.info("Compte ! " + user.getFirstname());
				
			} else {
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setEmail(email);
			user.setLevel(level);
			user.setSex(sex);
			
			Compte compte = new Compte();
			Profile profile = profileRepository.getProfileById(2);			
			compte.setProfile(profile);
			compte.setLogin(login);
			compte.setPassword(password);
			compte.setActivate("yes");
			user.setCompte(compte);
			userRepository.save(user);
			/*---------------- send email, contains students login and password, to parent ------------*/
			emailService.sendSimpleMessage(email, "Online school registration", "Hi "+ lastname +", We would to inform you that  your child registration is successfully done. To connect to the new account, please use "+login+" as username and "+ password +" as password.");
			logger.info("student has been successfully registred");
			
			}
		
		
		return user;
	}
	
	/*--------------------------- unsubscribe ---------------------------*/
	@GetMapping("/unsubscribe/{userConnected}")
	public User unsubscibe(@PathVariable String userConnected) {
		User user = userRepository.getUserById(Integer.parseInt(userConnected));
		user.getCompte().setActivate("unsubscribe");
		userRepository.save(user);
		logger.info("student has been successfully deleted");
		
		return user;
	}
	
	/*------------------------- update student  ------------------------*/
	@GetMapping("/studentUpdate/{studentSelected}/{userConnected}/{login}/{password}/{firstname}/{lastname}/{parent}/{level}") 
	public User updateStudent(@PathVariable String studentSelected, @PathVariable String userConnected, @PathVariable String firstname, @PathVariable String login, @PathVariable String password, @PathVariable String lastname, @PathVariable String parent, @PathVariable String level) {
		
			User user = userRepository.getUserById(Integer.parseInt(studentSelected));
			Compte compte = user.getCompte();
			User student_parent = null;
			
			student_parent = userRepository.getUserById(Integer.parseInt(userConnected));
			if(student_parent == null) {
				user.setFirstname("user not exist");
				logger.info("user not exist!");
				
			} else {
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setLevel(level);;
				user.setParent(student_parent);
					
				compte.setLogin(login);
				compte.setPassword(password);
					
				user.setCompte(compte);
				userRepository.save(user);
			}

		return user;
	}

}
