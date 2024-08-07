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

import com.betacom.fe.request.AttivitaRequest;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;

@Controller
public class AttivitaManagerController {

	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoManagerController.class);

	@GetMapping("/attivitaAbbonamento")
	public ModelAndView attivitaAbbonamento(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		
		ModelAndView mav = new ModelAndView("list-attivita-abbonamento");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listByAbb")
				.queryParam("idAbb", abbID)
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		Response<?> att = rest.getForEntity(uri, Response.class).getBody();
		
		mav.addObject("attivita", att);
		mav.addObject("abbID", abbID);
		mav.addObject("socioID", socioID);
		mav.addObject("funzione", "list");

		
		return mav;
		
		}
	
	@GetMapping("/listAttivitaByAbbAndSocio")
	public ModelAndView listAttivitaByAbbAndSocio(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		
		ModelAndView mav = new ModelAndView("list-attivita-abbonamento");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listByAbb")
				.queryParam("idAbb", abbID)
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		Response<?> att = rest.getForEntity(uri, Response.class).getBody();
		
		mav.addObject("attivita", att);
		mav.addObject("abbID", abbID);
		mav.addObject("socioID", socioID);
		mav.addObject("funzione", "list");

		
		return mav;
		
		}
	
	@GetMapping("/removeAttivitaAbbonamento")
	public Object removeAttivitaAbbonamento(@RequestParam Integer abbID, @RequestParam Integer attID, @RequestParam Integer socioID) {
		log.debug("abbID: " + abbID + " attID: " + attID);
		
		AttivitaRequest req = new AttivitaRequest();
		req.setAbbonamentoId(abbID);
		req.setId(attID);
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/removeAttFromAbb")
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		ResponseBase att = rest.postForEntity(uri,req,ResponseBase.class).getBody();
		
		return "redirect:/attivitaAbbonamento?abbID="+abbID+"&socioID="+socioID;
	}
	
	@GetMapping("/createAttivita")
	public ModelAndView createAttivita(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		
		log.debug("abbId: " + abbID);
		log.debug("socioId: " + socioID);
		
		ModelAndView mav = new ModelAndView("create-attivita-abbonamento");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listAttNonAbb")
				.queryParam("idAbb", abbID)
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		Response<?> lAtt = rest.getForEntity(uri, Response.class).getBody();
		mav.addObject("listAttivita", lAtt);
		
		AttivitaRequest req = new AttivitaRequest();
		req.setAbbonamentoId(abbID);
		req.setSocioID(socioID);
		mav.addObject("attivitaReq", req);
		
		return mav;
		}
	
	@PostMapping("/saveAttivitaAbbonamento")
	public Object saveAttivitaAbbonamento(@ModelAttribute("attivitaReq") AttivitaRequest req) {
		log.debug("id attivita: " + req.getId()+ " id abbonamento: " + req.getAbbonamentoId());
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/addAtt")
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
	
		ResponseBase att = rest.postForEntity(uri,req,ResponseBase.class).getBody();

		log.debug("rc " + att.getRc());
		
		//in questo modo voglio dico che voglio aggiornare la pagina e tornare in listSocio
		return "redirect:/attivitaAbbonamento?abbID="+ req.getAbbonamentoId()+"&socioID="+req.getSocioID();
}
}
