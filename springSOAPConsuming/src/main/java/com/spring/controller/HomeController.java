package com.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.client.HotelClient;
import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelResponse;
import com.spring.consumingSOAPwebservice.wsdl.Offre;
import com.spring.consumingSOAPwebservice.wsdl.ReservationRequest;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;


@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

	@Autowired 
	private HotelClient hotelClient;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();

	  /*****************************************************************************/
	  /********************************  Offres d'hotel ****************************/
	  /*****************************************************************************/
	
	  @GetMapping("/")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "index";
	  }
}
