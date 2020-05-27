package com.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.Comparateur;
import com.spring.consumingSOAPwebservice.wsdl.ComparateurRequest;
import com.spring.consumingSOAPwebservice.wsdl.GetHotelRequest;
import com.spring.consumingSOAPwebservice.wsdl.Offre;
import com.spring.consumingSOAPwebservice.wsdl.ReservationRequest;


@Controller
@RequestMapping(value = "/restful")
public class HotelRestController {
    private static final Logger log = LoggerFactory.getLogger(HotelRestController.class);

	@Autowired 
	private RestTemplate restTemplate;
	//private HotelClient hotelClient;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();
	private List<Comparateur> OffresComparateur = new ArrayList<Comparateur>();

	  /*****************************************************************************/
	  /********************************  Offres d'hotel ****************************/
	  /*****************************************************************************/
	
	  @GetMapping("/home")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "restful/index";
	  }
	  
//	  @GetMapping("/")
//	  public String hokjhkjhme() {
//        return "index";
//      }
	  
	  
	  @GetMapping("/offres")
	  public String OffreForm(Model model) {
	    model.addAttribute("RequestOffres", new GetHotelRequest());
	    return "restful/offres-form";
	  }

	  @PostMapping("/offres")
	  public String OffreSubmit(@Valid @ModelAttribute("RequestOffres") GetHotelRequest RequestOffres, BindingResult bindingResult, Model model) {
		  if (bindingResult.hasErrors()) {
				return "restful/offres-form";
		  }
		  String login = RequestOffres.getLogin();
		  String password = RequestOffres.getPassword();
		  String dateDebut = RequestOffres.getDateDebut();
		  String dateFin = RequestOffres.getDateFin();
		  int nombrePersonnesHeberges = RequestOffres.getNombrePersonnesHeberges();		
		  
		  String uri = "https://hotel-webservices.cfapps.io/restful/offres/"+login+"/"+password+"/"+dateFin+"/"+dateFin+"/"+nombrePersonnesHeberges;
		  Offre[] offs = restTemplate.getForObject(uri, Offre[].class);
		  offres = Arrays.asList(offs);
		   
		  if(offres != null)
			  model.addAttribute("listOffre", offres);
		  else
			  model.addAttribute("listOffre", null);
			
	    return "restful/offres-result";
	  }
	
	  /*****************************************************************************/
	  /********************************  Reservation *******************************/
	  /*****************************************************************************/
	  
	  @GetMapping("/reservation/{idOffre}")
	  public String reservationForm(@PathVariable String idOffre, Model model) {
		ReservationRequest rq = new ReservationRequest();
		rq.setIdOffre(idOffre);
		model.addAttribute("reservationRequest", rq);
	    return "restful/reservation-form";
	  }
	  
	  @PostMapping("/reservation/{idOffre}")
	  public String reservationSubmit(@PathVariable String idOffre, @Valid @ModelAttribute("reservationRequest") ReservationRequest reservationRequest, BindingResult bindingResult, Model model) {
		  if (bindingResult.hasErrors()) {
				return "restful/reservation-form";
		  }
		  
		  ReservationRequest rq = new ReservationRequest();
		  rq.setIdOffre(idOffre);
		  
		  String login = reservationRequest.getLogin();
		  String password = reservationRequest.getPassword();
		  String idOff = reservationRequest.getIdOffre();
		  Client client = reservationRequest.getClient();
		  
		  String uri = "https://hotel-webservices.cfapps.io/restful/reservation/"+login+"/"+password+"/"+idOff+"/"+client.getNom()+"/"+client.getPrenom()+"/"+client.getCarteCredit();
		  String[] conf = restTemplate.getForObject(uri, String[].class);
		  confirmation = Arrays.asList(conf);

		  model.addAttribute("confirmation", confirmation);
		  model.addAttribute("client", client);
			
	    return "restful/reservation-result";
	  }
	  
	  /*****************************************************************************/
	  /********************************  Comparateur *******************************/
	  /*****************************************************************************/
	  
	  @GetMapping("/comparateur")
	  public String comparateurForm(Model model) {
		ComparateurRequest comparateur = new ComparateurRequest();
		model.addAttribute("comparateur", comparateur);
	    return "restful/comparateur-form";
	  }
	  
	  @PostMapping("/comparateur")
	  public String comparateurSubmit(@ModelAttribute("comparateur") ComparateurRequest comparateur, Model model) {
		  String ville = comparateur.getVille();
		  String dateDebut = comparateur.getDateDebut();
		  String dateFin = comparateur.getDateFin();
		  int nombrePersonnes = comparateur.getNombrePersonnes();
		  int nombreEtoile = comparateur.getNombreEtoile();
		  
		  String uri = "http://localhost:8080/restful/comparateur/"+ville+"/"+dateDebut+"/"+dateFin+"/"+nombrePersonnes+"/"+nombreEtoile;
		  Comparateur[] conf = restTemplate.getForObject(uri, Comparateur[].class);
		  OffresComparateur = Arrays.asList(conf);
//		  for(Comparateur comp: OffresComparateur)
//			  System.out.println("############################");
		  

		  model.addAttribute("criteresRecherche", comparateur);
		  model.addAttribute("OffresComparateur", OffresComparateur);
			
	    return "restful/comparateur-result";
	  }

}
