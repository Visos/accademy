package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.AttivitaDTO;
import com.betacom.fe.request.AttivitaReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;

@Controller
public class AmministrazioneAttivitaController {
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;

	public static Logger log = LoggerFactory.getLogger(AmministrazioneAttivitaController.class);
	
	
	@GetMapping("/createAttivita")
	public ModelAndView createAttivita() {
		ModelAndView mav = new ModelAndView("create-attivita");
		
		AttivitaReq att = new  AttivitaReq();
		
		mav.addObject("att", att);
		
		return mav;
	}
	
	
	
	
	@PostMapping("/saveAttivita")
	public String saveAttivita(@ModelAttribute("socio") AttivitaReq req) {

		AttivitaDTO dto = new AttivitaDTO();
		dto.setDescrizione(req.getDescrizione());
		
		log.debug("ERRORE QUUA?");

		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/create")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		//ResponseBase r = rest.postForEntity(uri, dto, ResponseBase.class).getBody();	
		
		//log.debug("rc create attivita:" + r.getRc());
		
		return "redirect:/attivita";
	}
	@GetMapping("/attivita")
	public ModelAndView gestioneAttivita() {
		ModelAndView mav = new ModelAndView("attivita");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listAll")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);
		
		Response<?> lAtt = rest.getForEntity(uri, Response.class).getBody();
		mav.addObject("listAtt", lAtt);

	return mav;
	}
	
	@GetMapping("/updateAttivita")
	public String updateAttivita(@RequestParam Integer attID) {
		
//		URI uri = UriComponentsBuilder
//				.fromHttpUrl(backend + "attivita/updateAtt")
//				.buildAndExpand().toUri();
//		log.debug("URI:" + uri);
//
//		
//		ResponseBase r = rest.postForEntity(uri, AttID, ResponseBase.class).getBody();	
//		
//		log.debug("rc create attivita:" + r.getRc());
		
		return "redirect:/attivita";
	}
	
	@GetMapping("/removeAttivita")
	public String removeAttivita(@RequestParam Integer attID) {
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/remove")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		
		ResponseBase r = rest.postForEntity(uri, attID, ResponseBase.class).getBody();	
		
		log.debug("rc create attivita:" + r.getRc());
		
		return "redirect:/attivita";
	}
	
	

	

}
