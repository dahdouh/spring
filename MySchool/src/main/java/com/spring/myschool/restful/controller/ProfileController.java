package com.spring.myschool.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;

@RestController
public class ProfileController {
	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ProfileRepository profileRepository;
	
	@GetMapping("/profile/{userconnected}")
	public User getProfileById(@PathVariable int userconnected) {
			User user = null;
			user = userRepository.getUserById(userconnected);
			if(user == null) {
				user = new User();
				user.setFirstname("user not exist");
				logger.info("user not exist!");
			} 
		return user;
	}
	
	@GetMapping("/profile")
	public List<Profile> getProfiles() {			
		return profileRepository.findAll();
	}
	
	@GetMapping("/profile/synchronize/{id}/{libelle}/{role}")
	public Profile synchronizeProfile(@PathVariable int id, @PathVariable String libelle, @PathVariable String role) {
		Profile profile = profileRepository.getProfileById(id);
		if(profile == null)
			profile = new Profile();
		profile.setLibelle(libelle);
		profile.setRole(role);
		profileRepository.save(profile);
		return profile;
	}
	

}
