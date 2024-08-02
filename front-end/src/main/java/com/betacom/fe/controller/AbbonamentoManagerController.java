package com.betacom.fe.controller;

import java.net.URI;
import java.security.AlgorithmConstraints;
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

import com.betacom.fe.request.AbbonamentoReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;

@Controller
public class AbbonamentoManagerController {

	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;

	public static Logger log = LoggerFactory.getLogger(AbbonamentoManagerController.class);
	@GetMapping("/listAbbonamenti")
	public ModelAndView listAbbonamenti(@RequestParam Integer socioID) {
		ModelAndView mav = new ModelAndView("list-abbonamenti");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/listBySocio")
				.queryParam("id", socioID)
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		Response<?> abbo = rest.getForEntity(uri, Response.class).getBody();
		
		mav.addObject("abbonamenti", abbo);
		log.debug("socioId:" + socioID);
		mav.addObject("socioId", socioID);
		
		return mav;
	}
	
	@GetMapping("/createAbbonamento")
	public String createAbbonamento(@RequestParam Integer socioID) {
		log.debug("SOCIO ID: " + socioID);
		AbbonamentoReq req = new AbbonamentoReq();
		req.setSocioID(socioID);
		req.setDataIscrizione(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/create")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);

		ResponseBase r = rest.postForEntity(uri,req,  ResponseBase.class).getBody();

		return "redirect:/listAbbonamenti?socioID=" + socioID ;
		
		
	}
	
	@GetMapping("/removeAbbonamenti")
	public Object removeAbbonamenti(@RequestParam Integer abbID, @RequestParam Integer socioID) {
		
		log.debug("removeAbbonamenti abbID:" + abbID + " socioID:" + socioID);
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "abbonamento/remove")
				.buildAndExpand().toUri();
		log.debug("URI:" + uri);
		
		ResponseBase r = rest.postForEntity(uri, abbID, ResponseBase.class).getBody();
		
		log.debug("rc remove :" + r.getRc() + " " + r.getMsg());
		if (!r.getRc()) {
			ModelAndView mav = new ModelAndView("list-attivita");
			
			uri = UriComponentsBuilder
					.fromHttpUrl(backend + "attivita/listByAbbonamento")
					.queryParam("id", abbID)
					.buildAndExpand().toUri();
			log.debug("URI:" + uri);

			Response<?> attiv = rest.getForEntity(uri, Response.class).getBody();
			
			mav.addObject("attivita", attiv);
			mav.addObject("abbID",abbID);
			mav.addObject("socioId", socioID);
			mav.addObject("funzione", "remove");
	
			return mav;

		}
		
		
		
		
		return "redirect:/listAbbonamenti?socioID=" + socioID ;
	}

}
