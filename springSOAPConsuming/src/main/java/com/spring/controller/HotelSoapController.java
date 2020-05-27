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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/soap")
public class HotelSoapController {
    private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

	@Autowired 
	private HotelClient hotelClient;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();

	  /*****************************************************************************/
	  /********************************  Offres d'hotel ****************************/
	  /*****************************************************************************/
	
	  @GetMapping("/home")
	  public String home(Model model) {
		  model.addAttribute("standardDate", new Date());
	    return "soap/index";
	  }
	  
//	  @GetMapping("/")
//	  public String hokjhkjhme() {
//        return "index";
//      }

	  
	  @GetMapping("/offres")
	  public String OffreForm(Model model) {
	    model.addAttribute("RequestOffres", new GetHotelRequest());
	    return "soap/offres-form";
	  }

	  @PostMapping("/offres")
	  public String OffreSubmit(@ModelAttribute("RequestOffres") GetHotelRequest RequestOffres, Model model) {
		  String login = RequestOffres.getLogin();
		  String password = RequestOffres.getPassword();
		  String dateDebut = RequestOffres.getDateDebut();
		  String dateFin = RequestOffres.getDateFin();
		  int nombrePersonnesHeberges = RequestOffres.getNombrePersonnesHeberges();
		  GetHotelResponse response = new GetHotelResponse();
		  response = hotelClient.getOffresHotel(login, password, dateDebut, dateFin, nombrePersonnesHeberges);
		  offres = response.getOffres();
		  
		  if(offres != null)
			  model.addAttribute("listOffre", offres);
		  else
			  model.addAttribute("listOffre", null);
			
	    return "soap/offres-result";
	  }
	  
	  /*****************************************************************************/
	  /********************************  Reservation *******************************/
	  /*****************************************************************************/
	  
	  @GetMapping("/reservation/{idOffre}")
	  public String reservationForm(@PathVariable String idOffre, Model model) {
		ReservationRequest rq = new ReservationRequest();
		rq.setIdOffre(idOffre);
	    model.addAttribute("reservationRequest", rq);
	    return "soap/reservation-form";
	  }

	  @PostMapping("/reservation")
	  public String reservationSubmit(@ModelAttribute("reservationRequest") ReservationRequest reservationRequest, Model model) {
		  String login = reservationRequest.getLogin();
		  String password = reservationRequest.getPassword();
		  String idOffre = reservationRequest.getIdOffre();
		  Client client = reservationRequest.getClient();
		  		  		  
		  ReservationResponse response = hotelClient.doReservation(login, password, idOffre,client);
		  confirmation = response.getConfirmation();
		 		  
		  model.addAttribute("confirmation", confirmation);
		  model.addAttribute("client", client);
			
	    return "soap/reservation-result";
	  }

}
