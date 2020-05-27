package com.spring.myschool.restful.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.LogSession;
import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.CompteRepository;
import com.spring.myschool.restful.repository.LogSessionRepository;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;
import com.spring.myschool.restful.service.EmailService;
import com.spring.myschool.restful.service.EmailServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MySchoolController {
	
	public static final String IP="http://10.115.187.47:8085";
	//public static final String IP="https://onlineschool.cfapps.io";
	Logger logger = LoggerFactory.getLogger(MySchoolController.class);
	
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
	
	/*------------------------- registration  ------------------------*/
	@GetMapping("/register/{login}/{password}/{firstname}/{lastname}/{email}/{tel}/{ville}")
	public User registration(@PathVariable String login, @PathVariable String password, @PathVariable String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String tel, @PathVariable String ville) {
		User user = new User(firstname, lastname, email, tel, ville);
		if(!login.equals("") && !password.equals("") && !firstname.equals("") && !lastname.equals("") && !email.equals("") && !tel.equals("") && !ville.equals("")) {
			
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
				user.setTel(tel);
				user.setVille(ville);
				
				Compte compte = new Compte(login, password);
				Profile profile = new Profile();
				profile = profileRepository.getProfileByRole("ROLE_PARENT");
				compte.setProfile(profile);
				compte.setActivate("no");
				compteRepository.save(compte);	
				
				user.setCompte(compte);
				userRepository.save(user);
				//String url = "https://onlineschool.cfapps.io/activateAccount/"+user.getId();
				String url = MySchoolController.IP+"/activateAccount/"+user.getId();
				
				emailService.sendSimpleMessage(email, "Online school registration", "Hi "+user.getLastname()+", thank you for your registration in our online school courses. "
						+ "In order to activate your account please click in this link: "+url);
				logger.info("utilisateur est bien enregistré");
				
				
			}
		}
		
		return user;
	}
	
	/*------------------------- registration  ------------------------*/
	@GetMapping("/updateProfile/{id}/{login}/{password}/{firstname}/{lastname}/{email}/{tel}/{ville}")
	public User updateProfile(@PathVariable String id, @PathVariable String login, @PathVariable String password, @PathVariable String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String tel, @PathVariable String ville) {
		
			User user = userRepository.getUserById(Integer.parseInt(id));
			Compte compte = user.getCompte();
			
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setEmail(email);
			user.setTel(tel);
			user.setVille(ville);
				
			compte.setLogin(login);
			compte.setPassword(password);
				
			user.setCompte(compte);
			userRepository.save(user);

		return user;
	}
	
	/*------------------------- list students  ------------------------*/
	@GetMapping("/students/{userconnected}")
	public List<User> getStudents(@PathVariable int userconnected) {
		List<User> students = new ArrayList<User>();
		students = userRepository.getStudentsByParent(userconnected);				
		for (User user : students) {
			System.out.println("########################## "+ user.getFirstname());
		}
		return students;
	}
	
	
	
	/*------------------------- Login: Authentification  ------------------------*/
	@GetMapping("/auth/{login}/{password}")
	public User authentification(@PathVariable String login, @PathVariable String password) {
		User user = new User();
		Compte compte = null;
		if(!login.equals("") && !password.equals("")) {
			
			compte = compteRepository.authentification(login, password);
			if(compte != null) {
				user = userRepository.getUserByCompteId(compte.getId());
				LogSession logSession = new LogSession(new Date(), user);
				logSessionRepository.save(logSession);
				logger.info("authentification ok!");
			} else {
				user.setFirstname("not found");
				System.out.println("????????????????????????????????? authentification failed");
			}
			
			if(user != null) 
			logger.info("authentification ok!");
		}
		
		return user;
	}
	
	/*------------------------- Logout  ------------------------*/
	@GetMapping("/logout/{userconnectedId}")
	public LogSession logout(@PathVariable int userconnectedId) {
		LogSession logSession = null;

			logSession = logSessionRepository.getSessionByUserLogin(userconnectedId);
			if(logSession != null) {
				System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP "+ logSession.getDateConnexion() + " ====> "+logSession.getDateDeconnexion());
				logSession.setDateDeconnexion(new Date());
				logSessionRepository.save(logSession);
				logger.info("logout ok!");
			}else {
				User user = logSession.getUser();
				user.setFirstname("not found");
				logSession.setUser(user);
			}
		return logSession;
	}
	
	/*-------------------------   confirmation of registration by email   ------------------------*/
	@GetMapping("/sendMail")
	public void sendMail(User user) {
		  emailService.sendSimpleMessage("karim.dahdouh.fr@gmail.com", "Online school registration", "Hi "+user.getLastname()+", thank you for your registration in our online school courses.");
		  /*=emailService.sendMessageWithAttachment("karim.dahdouh.fr@gmail.com", "Online school registration", "Hi, thank you for your registration in our online school courses",
				  									"/home/karim/Downloads/EcoleEnLigne.pdf");
	      */
	}
	
	/*-------------------------  send password   ------------------------*/
	@GetMapping("/sendPassword/{email}")
	public User sendPassword(@PathVariable String email, Model model) {
		  User user = null;
		  user = userRepository.getUserByEmail(email);
		  if(user != null) {
			  emailService.sendSimpleMessage(email, "Recover your password", "Hi, You have requested a new password. To access the MySchool application, you can use the following coordinates: login ("+ user.getCompte().getLogin() +") and password ("+ user.getCompte().getPassword() +").");;
			  logger.info("mot de passe à bien été envoyé à l'adresse mail indiquée. ");
			} else {
				user.setFirstname("email not found");
				logger.info("mot de passe à bien été envoyé à l'adresse mail indiquée. ");
			}
		  
		  
	    return user;
	}
	

}
