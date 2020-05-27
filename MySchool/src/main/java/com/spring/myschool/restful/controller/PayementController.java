package com.spring.myschool.restful.controller;

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
import com.spring.myschool.restful.model.Payement;
import com.spring.myschool.restful.model.Qcm;
import com.spring.myschool.restful.model.User;
import com.spring.myschool.restful.repository.ProfileRepository;
import com.spring.myschool.restful.repository.UserRepository;
import com.spring.myschool.restful.service.CourseService;
import com.spring.myschool.restful.service.PayementService;

@RestController
@RequestMapping("/api")
public class PayementController {

	@Autowired
	private PayementService payementService;
	@Autowired
	public UserRepository userRepository;
	
	
	@RequestMapping("/payement/{nom_proprietaire}/{numero_carte}/{mois_expiration}/{annee_expiration}/{cryptonyme}/{user_id}")
	public void savePayement(@PathVariable String nom_proprietaire
			,@PathVariable String numero_carte,@PathVariable int mois_expiration,@PathVariable int annee_expiration, 
			@PathVariable int cryptonyme , @PathVariable int user_id){
		
		Payement p = new Payement();
		p.setNom_proprietaire(nom_proprietaire);
		p.setNumero_carte(numero_carte);
		p.setMois_expiration(mois_expiration);
		p.setAnnee_expiration(annee_expiration);
		p.setCryptonyme_carte(cryptonyme);
		User u = userRepository.getUserById(user_id);
		p.setUser(u);
		payementService.savePayement(p);
	}
	@RequestMapping("/payement/{user_id}")
	public List<Payement> getPayement(@PathVariable int user_id){
		
		User u = new User();
		u.setId(user_id);
		u.getId();
		return payementService.getPayement(u);
	}
}
