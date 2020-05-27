package io.spring.ex4.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/*---------------------- Page d'accueil  ------------------------*/
	@GetMapping("/restful")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "restful/index";
	  }

}
