package com.spring.myschool.restful.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.Profile;
import com.spring.myschool.restful.repository.CompteRepository;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;

@RestController
public class CompteController {
	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	public CompteRepository compteRepository;
	@Autowired
	public ProfileRepository profileRepository;
	
	@GetMapping("/compte")
	public List<Compte> getProfiles() {			
		return compteRepository.findAll();
	}
	
	@GetMapping("/compte/synchronize/{id}/{login}/{password}/{activate}")
	public Compte synchronizeCompte(@PathVariable int id, @PathVariable String login, @PathVariable String password, @PathVariable String activate) {
		Compte compte = compteRepository.getCompteById(id);
		compte.setLogin(login);
		compte.setPassword(password);
		compte.setActivate(activate);
		compteRepository.save(compte);
		
		return compte;
	}

}
