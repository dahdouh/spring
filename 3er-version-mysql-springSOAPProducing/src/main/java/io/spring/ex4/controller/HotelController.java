package io.spring.ex4.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.ex4.webservice.Repository.AgenceVoyageRepository;
import io.spring.ex4.webservice.Repository.ChambreRepository;
import io.spring.ex4.webservice.Repository.ClientRepository;
import io.spring.ex4.webservice.Repository.HotelRepository;
import io.spring.ex4.webservice.Repository.ReservationRepository;
import io.spring.ex4.webservice.AgenceVoyage;
import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Client;
import io.spring.ex4.webservice.Hotel;
import io.spring.ex4.webservice.Offre;
import io.spring.ex4.webservice.Reservation;
import io.spring.ex4.webservice.Comparateur;

@RestController
@RequestMapping(value = "/restful")
public class HotelController {
 	  
	private HotelRepository hotelRepository;
	private ReservationRepository reservationRepository;
	private AgenceVoyageRepository agenceVoyageRepository;
	private ChambreRepository chambreRepository;
	private ClientRepository clientRepository;
	private List<Offre> offres = new ArrayList<Offre>();
	private List<String> confirmation = new ArrayList<String>();
	private List<Comparateur> OffresComparateur = new ArrayList<Comparateur>();

	private Hotel hotel = new Hotel();
	private List<Chambre> listChambres = new ArrayList<Chambre>();
	private AgenceVoyage agencesVoyages = new AgenceVoyage();
		
	public HotelController(HotelRepository hotelRepository, ReservationRepository reservationRepository, 
			AgenceVoyageRepository agenceVoyageRepository, ChambreRepository chambreRepository, ClientRepository clientRepository) {
		this.hotelRepository = hotelRepository;
		this.reservationRepository = reservationRepository;
		this.agenceVoyageRepository = agenceVoyageRepository;
		this.chambreRepository = chambreRepository;
		this.clientRepository = clientRepository;
	}
	  
	/*---------------------- Gestion des offres d'hotel  ------------------------*/
	@GetMapping("/offres/{login}/{password}/{dateDebut}/{dateFin}/{nombrePersonnesHeberges}")
	public List<Offre> getOffres(@PathVariable String login, @PathVariable String password, @PathVariable String dateDebut, @PathVariable String dateFin, @PathVariable int nombrePersonnesHeberges) {
		if(!offres.isEmpty())
			offres.clear();
		hotel = hotelRepository.findHotel(1);	
		agencesVoyages = agenceVoyageRepository.findAgenceVoyage(login, password);
		if (agencesVoyages != null) {
			if (hotel.getChambre().size() >= nombrePersonnesHeberges) {
				for (Chambre ch : hotel.getChambre()) {
					if (ch.getDisponible().equals("yes")) {
						Offre offr = new Offre();
						offr.setId(ch.getNumero() + "_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
						String pattern = "MM-dd-yyyy";
						offr.setDateDisponibilite(""+dateDebut);
						offr.setTypeChambre(ch.getTypeLit());
						//offr.setPrix((agencesVoyages.getTarif() * ch.getPrix()) / 100);
						offr.setPrix(ch.getPrix());
						offr.setNomHotel(ch.getHotel().getNom());
						offres.add(offr);
					}
				}
			}
		} 
		
		return offres;
	}
	/*---------------------- Gestion de reservation  ------------------------*/
	@GetMapping("/reservation/{login}/{password}/{idOffre}/{nom}/{prenom}/{carteCredit}")
	public List<String> Reservation(@PathVariable String login, @PathVariable String password, @PathVariable String idOffre, 
			@PathVariable String nom, @PathVariable String prenom, @PathVariable String carteCredit) {
		if(!confirmation.isEmpty())
			confirmation.clear();
		Reservation res = new Reservation();
		Client client = clientRepository.searchClient(nom, prenom, carteCredit);
		if(client == null) {
			Client newClient = new Client();
			newClient.setNom(nom);
			newClient.setPrenom(prenom);
			newClient.setCarteCredit(carteCredit);
			clientRepository.save(newClient);
			res.setClient(newClient);
		} else  {
			res.setClient(client);
		}

		Chambre chambre = chambreRepository.findById(1).orElse(null);
		res.setChambre(chambre);
		AgenceVoyage agenceVoyage = agenceVoyageRepository.findAgenceVoyage(login, password);
		res.setAgenceVoyage(agenceVoyage);
		res.setDateArrivee("2020-03-05");
		res.setDateDepart("2020-03-09");		
		//reservationRepository.save(res);
		reservationRepository.save(res);
		
		confirmation.add("Reservation  a été bien faite.");
		return confirmation;
	}
	/*---------------------- Comparateur des offres des hotels ---------------------*/
	@GetMapping("/comparateur/{ville}/{dateDebut}/{dateFin}/{nombrePersonnes}/{nombreEtoile}")
	public List<Comparateur> Comparateur(@PathVariable String ville, @PathVariable String dateDebut, @PathVariable String dateFin, 
			@PathVariable int nombrePersonnes, @PathVariable int nombreEtoile) {
			if(!OffresComparateur.isEmpty())
				OffresComparateur.clear();
			List<Hotel> hotels = hotelRepository.findAll();	
			List<AgenceVoyage> agencesVoyages = new ArrayList<AgenceVoyage>();
			agencesVoyages = agenceVoyageRepository.findAll();
			for (AgenceVoyage ag : agencesVoyages ) {
				for (Hotel hot : hotels) {
					if (hot.getChambre().size() >= nombrePersonnes && hot.getAdresse().getVile().equals(ville) && hot.getNombreEtoiles() == nombreEtoile) {
						for (Chambre ch : hot.getChambre()) {
							if (ch.getDisponible().equals("yes")) {
								Comparateur comparateur = new Comparateur();
								comparateur.setIdChambre(ch.getNumero() + "_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
								comparateur.setNomHotel("" + hot.getNom());
								comparateur.setAdresseHotel(hot.getAdresse().getNumero()+ ", "+ hot.getAdresse().getRue()+ ", "+hot.getAdresse().getVile()+ ", "+ hot.getAdresse().getPays());
								// offr.setPrix((agencesVoyages.getTarif() * ch.getPrix()) / 100);
								comparateur.setNombreEtoile(hot.getNombreEtoiles());
								if(ch.getTypeLit().equals("lit simple")) comparateur.setNombreLits(1);
								else comparateur.setNombreLits(2);
								comparateur.setNomAgenceVoyage(ag.getNom());
								OffresComparateur.add(comparateur);
							}
						}
					}
				}
			}
			
			return OffresComparateur;
		}
	
	/*---------------------- fonction permet de retourner une image d'une chambre d'hotel donnée ---------------------*/
	@GetMapping(value = "/get-image-with-media-type/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable String id) throws IOException {
		//InputStream in = getClass().getResourceAsStream(id+".jpg");

		InputStream in = getClass().getClassLoader().getResourceAsStream("static/image/"+id+".jpg");
		return IOUtils.toByteArray(in);
	}


}
