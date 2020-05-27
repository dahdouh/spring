package com.spring.myschool.restful.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.UserRepository;
import com.spring.myschool.restful.service.EmailService;
import com.spring.myschool.restful.service.EmailServiceImpl;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	
//	@Autowired
//	public EmailService emailService = new EmailServiceImpl();
	
	@Autowired
	public UserRepository userRepository;
	
	@GetMapping("/activateAccount/{userId}")
	  public String activateAccount(@PathVariable int userId, Model model) {
		  //model.addAttribute("standardDate", new Date());
		User user = userRepository.getUserById(userId);
		Compte compte = user.getCompte();
		compte.setActivate("yes");
		userRepository.save(user);
		logger.info("Account successfully activated!");
		
	    return "mail/activate";
	  }

}
