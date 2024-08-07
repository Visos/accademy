package com.betacom.fe.controller;

import org.slf4j.LoggerFactory;

import java.net.URI;

import org.slf4j.Logger;
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

import com.betacom.fe.dto.SocioDTO;
import com.betacom.fe.dto.SocioViewDTO;
import com.betacom.fe.request.SocioRequest;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;
import static com.betacom.fe.utilities.WebUtils.convertInObject;;



@Controller
public class SocioManagerController {
	
	//Con questa annotazione chiamiamo la prop jpa.backend nella string
	@Value("${jpa.backend}")
	String backend;
	
	//faccio autowired del bean RestTemplate, in Spring ha la funzione di gestire http request e response
	@Autowired
	RestTemplate rest;
	
	public static Logger log = LoggerFactory.getLogger(SocioManagerController.class);

	@GetMapping(value = {"/jpa", "/listSocio"})
	public ModelAndView listSocio() {
		//questo oggetto ci permette di recuperare gli il Model e la View assieme
		//index indica la View da utilizzare
		ModelAndView mav = new ModelAndView("list-socio");
		
		//Uniform Resource Identifier: indica una stringa che identifica univocamente e universalmente un oggetto 
		//in questo modo si costruisce un URI a partire in questo caso da URL (Uniform Resource Locator)
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "socio/listAllSocio")
				.buildAndExpand().toUri();
		
		log.debug("URI: " + uri);
		
		//recuperiamo la risposta
		Response<?> soc = rest.getForEntity(uri, Response.class).getBody();
		//mandiamo la risposta nel ModelAndView
		
		mav.addObject("listSocio", soc);
		
		
		return mav;
	}
	
	@GetMapping("/createSocio")
	public ModelAndView createSocio() {

	        ModelAndView mav = new ModelAndView("create-socio");
	        SocioRequest s = new SocioRequest();
	        s.setErrorMSG(null);
	        mav.addObject("socio", s);
	        return mav; 
	    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/updateSocio")
	public ModelAndView updateSocio(@RequestParam Integer socioID) {

	        ModelAndView mav = new ModelAndView("create-socio");
	        
	        URI uri = UriComponentsBuilder
					.fromHttpUrl(backend + "socio/getById")
					.queryParam("id", socioID)
					.buildAndExpand().toUri();
	        
			ResponseObject<SocioViewDTO> soc = rest.getForEntity(uri, ResponseObject.class).getBody();

	        SocioRequest s = new SocioRequest();
	        s.setErrorMSG(null);
	        SocioViewDTO v = (SocioViewDTO) convertInObject(soc.getDato(), SocioViewDTO.class); 
	        s.setId(v.getId());
	        s.setNome(v.getNome());
	        log.debug("Nome: " + v.getNome());
	        log.debug("Nome: " + s.getNome());
	        s.setCognome(v.getCognome());
	        log.debug("Cognome: " + v.getCognome());
	        log.debug("Cognome: " + s.getCognome());
	        s.setCf(v.getCf());
	       
	        mav.addObject("socio", s);
	        return mav; 
	    }
	
	@PostMapping("/saveSocio")
	public Object saveSocio(@ModelAttribute("socio") SocioRequest req) {
		log.debug("saveSocio cognome: " + req.getCognome());
		SocioDTO dto = new SocioDTO();
		dto.setId(req.getId());
		dto.setNome(req.getNome());
		log.debug("Nome: " + req.getNome());
		dto.setCognome(req.getCognome());
		log.debug("Cognome: " + req.getCognome());
		dto.setCf(req.getCf());
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "socio/create")
				.buildAndExpand().toUri();
		
		//la differenza che ho con la funzione precedente è che siamo in POST
		ResponseBase resp = rest.postForEntity(uri, dto, ResponseBase.class).getBody();
		log.debug("Nome: " + dto.getNome());
		log.debug("rc: " + resp.getRc());
		
		if (!resp.getRc()) {
			ModelAndView mav = new ModelAndView("create-socio");
			req.setErrorMSG("Errore: " + resp.getMsg());
			mav.addObject("socio", req);
			return mav;
		}
		
		//in questo modo voglio dico che voglio aggiornare la pagina e tornare in listSocio
		return "redirect:/listSocio";
		
		
	}
}
