package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.request.AttivitaReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;

@Controller
public class AttivitaManagerController {

	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;

	public static Logger log = LoggerFactory.getLogger(AttivitaManagerController.class);
	
	@GetMapping("/attivitaAbbonamenti")
	public ModelAndView attivitaAbbonamenti(@RequestParam Integer abbID,@RequestParam Integer socioID) {
		ModelAndView mav = new ModelAndView("list-attivita");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listByAbbonamento")
				.queryParam("id", abbID)
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		Response<?> attiv = rest.getForEntity(uri, Response.class).getBody();
		
		mav.addObject("attivita", attiv);
		mav.addObject("abbID",abbID);
		mav.addObject("socioID",socioID);
		mav.addObject("funzione", "list");
		
		
		return mav;
	}
	
	@GetMapping("/removeAttivitaAbbonamenti")
	public String removeAttivitaAbbonamenti(@RequestParam Integer abbID, @RequestParam Integer attID,  @RequestParam Integer socioID) {
		log.debug("attID:" + attID + " abbID:" + abbID);
		
		AttivitaReq req = new AttivitaReq();
		req.setAbbonamentoID(abbID);
		req.setId(attID);
		
		
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/removeAttivitaAbbo")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);


		ResponseBase r = rest.postForEntity(uri, req, ResponseBase.class).getBody();	
		
		log.debug("rc:" + r.getRc());
		
		return "redirect:/attivitaAbbonamenti?abbID=" + abbID+ "&socioID="+socioID;
	}
	
	@GetMapping("/createAttivitaAbbo")
	public ModelAndView createAttivita(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		log.debug("abbID:" + abbID + " socioID: "+ socioID);
		ModelAndView mav = new ModelAndView("create-attivita-abbonamento");

		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listAttivitaNonAbbonamento")
				.queryParam("id", abbID)
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		Response<?> lAtt = rest.getForEntity(uri, Response.class).getBody();
		mav.addObject("listAttivita", lAtt);
		
		AttivitaReq req = new AttivitaReq();
		req.setAbbonamentoID(abbID);
		req.setSocioID(socioID);
		
		mav.addObject("attivitaReq", req);

		
		return mav;
	}
	
	@PostMapping("/saveAttivitaAbbonamento")
	public String saveAttivitaAbbonamento(@ModelAttribute("attivitaReq") AttivitaReq req ) {
		log.debug("id attivita;" + req.getId() + " Abbonamento:" + req.getAbbonamentoID());
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/createAttivitaAbbo")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);
		
		ResponseBase r = rest.postForEntity(uri, req, ResponseBase.class).getBody();	
		
		log.debug("rc create attivita:" + r.getRc());
		
		return "redirect:/attivitaAbbonamenti?abbID=" + req.getAbbonamentoID() + "&soicioID" + req.getSocioID();
	}
	
}
