package com.betacom.fe.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.request.AbbonamentoRequest;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;


@Controller
public class AbbonamentoManagerController {
	//Con questa annotazione chiamiamo la prop jpa.backend nella string
	@Value("${jpa.backend}")
	String backend;
	
	//faccio autowired del bean RestTemplate, in Spring ha la funzione di gestire http request e response
	@Autowired
	RestTemplate rest;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoManagerController.class);
	
	@GetMapping("/listAbbonamenti")
	public ModelAndView listAbbonamento(@RequestParam Integer socioID) {
		ModelAndView mav = new ModelAndView("list-abbonamenti-socio");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/listAbbBySocio")
				.queryParam("id", socioID)
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		Response<?> abbo = rest.getForEntity(uri, Response.class).getBody();
		
		//"Abbonamenti" è la view che passo alla pagina html
		mav.addObject("abbonamenti", abbo);
		mav.addObject("socioID", socioID);
		return mav;
		}
	
	//Create abbonamento e Save abbonamento sono due cose diverse
	@GetMapping("/createAbbonamento")
	public String createAbbonamento(@RequestParam Integer socioID) {
		AbbonamentoRequest req = new AbbonamentoRequest();
		req.setSocioId(socioID);
		req.setDataIscrizione(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/create")
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		ResponseBase abbo = rest.postForEntity(uri, req, ResponseBase.class).getBody();
		
		return "redirect:/listAbbonamenti?socioID=" + socioID;
		}

	@GetMapping("/removeAbbonamento")
	public Object removeAbbonamento(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/remove")
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		ResponseBase abbo = rest.postForEntity(uri, abbID, ResponseBase.class).getBody();
		
		log.debug("rc error: " + abbo.getMsg());
		
		if(!abbo.getRc()) {
			ModelAndView mav = new ModelAndView("list-attivita-abbonamento");
			
			uri = UriComponentsBuilder
					.fromHttpUrl(backend + "attivita/listByAbb")
					.queryParam("idAbb", abbID)
					.buildAndExpand().toUri();
			log.debug("URI: " + uri);
			
			Response<?> att = rest.getForEntity(uri, Response.class).getBody();
			
			mav.addObject("attivita", att);
			mav.addObject("abbID", abbID);
			mav.addObject("socioID", socioID);
			mav.addObject("funzione", "remove");
			
			return mav;
		}
		
		return "redirect:/listAbbonamenti?socioID=" + socioID;
	}
	
	@GetMapping("/forceRemoveAbbonamento")
	public Object forceRemoveAbbonamento(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/forceRemove")
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		ResponseBase abbo = rest.postForEntity(uri, abbID, ResponseBase.class).getBody();
		
		log.debug("rc error: " + abbo.getMsg());
		
		return "redirect:/listAbbonamenti?socioID=" + socioID;
	}
}
