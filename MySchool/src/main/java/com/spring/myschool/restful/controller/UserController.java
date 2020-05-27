package com.spring.myschool.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;

@RestController
public class UserController {
	
Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	public UserRepository userRepository;
	//@Autowired
	//public ProfileRepository profileRepository;
	
	
	@GetMapping("/user")
	public List<User> getProfiles() {	
		List<User> users = new ArrayList<User>();
		for(User u : userRepository.findAll()) {
			if(u.getParent() == null) {
				u.setParent(new User());
			}
			users.add(u);
		}
		return users;
	}
	
	@GetMapping("/user/synchronize/{id}/{email}/{firstname}/{lastname}/{parentRelation}/{level}/{tel}/{ville}/{sex}")
	public User synchronizeProfile(@PathVariable int id, @PathVariable String email, @PathVariable String firstname, @PathVariable String lastname,
			@PathVariable String parentRelation, @PathVariable String level, @PathVariable String tel, @PathVariable String ville, @PathVariable String sex) {
		User user = userRepository.getUserById(id);
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setParentRelation(parentRelation);
		user.setLevel(level);
		user.setTel(tel);
		user.setVille(ville);
		user.setSex(sex);
		userRepository.save(user);
		
		return user;
	}

}
