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
import com.spring.myschool.restful.repository.UserRepository;

@RestController
public class ProfileController {
	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	public UserRepository userRepository;
	
	@GetMapping("/profile/{userconnected}")
	public User getProfile(@PathVariable int userconnected) {
			User user = null;
			user = userRepository.getUserById(userconnected);
			if(user == null) {
				user = new User();
				user.setFirstname("user not exist");
				logger.info("user not exist!");
			} 
		return user;
	}

}
