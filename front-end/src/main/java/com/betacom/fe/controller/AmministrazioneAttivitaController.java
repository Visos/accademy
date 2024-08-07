package com.betacom.fe.controller;

import static com.betacom.fe.utilities.WebUtils.convertInObject;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import com.betacom.fe.dto.AttivitaDTO;
import com.betacom.fe.dto.AttivitaViewDTO;
import com.betacom.fe.request.AttivitaRequest;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
@RequestMapping("/admin")
public class AmministrazioneAttivitaController {
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoManagerController.class);
	
	@GetMapping("/listAttivita")
	public ModelAndView listAttivita() {
		ModelAndView mav = new ModelAndView("list-attivita");
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/listAll")
				.buildAndExpand().toUri();
		
		log.debug("URI: " + uri);
		Response<?> r = rest.getForEntity(uri, Response.class).getBody();
		mav.addObject("attivita", r);
		mav.addObject("funzione", "list");
		return mav;
	}

	@GetMapping("/createNewAttivita")
	public ModelAndView createNewAttivita() {

	        ModelAndView mav = new ModelAndView("create-attivita");
	        AttivitaRequest att = new AttivitaRequest();
	        mav.addObject("attivita", att);
	        mav.addObject("funzione", "create");
	        return mav; 
	}
	
	@GetMapping("/updateAttivita")
	public ModelAndView updateAttivita(@RequestParam Integer attID) {
	        ModelAndView mav = new ModelAndView("create-attivita");
	        
	        URI uri = UriComponentsBuilder
					.fromHttpUrl(backend + "attivita/getById")
					.queryParam("id", attID)
					.buildAndExpand().toUri();
	        
			@SuppressWarnings("unchecked")
			ResponseObject<AttivitaDTO> resp = rest.getForEntity(uri, ResponseObject.class).getBody();
			
			AttivitaRequest req = new AttivitaRequest();
			req.setErrorMSG(null);
			AttivitaDTO dto = (AttivitaDTO) convertInObject(resp.getDato(), AttivitaDTO.class); 
			req.setId(dto.getId());
			req.setDescrizione(dto.getDescrizione());
			
			mav.addObject("attivita", req);
			mav.addObject("funzione", "update");
		    return mav; 

	}
	
	@GetMapping("/removeAttivita")
	public Object removeAttivita(@RequestParam Integer attID) {
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/removeAtt")
				.queryParam("id", attID)
				.buildAndExpand().toUri();
		log.debug("URI: " + uri);
		
		ResponseBase r = rest.postForEntity(uri, attID, ResponseBase.class).getBody();
		
		log.debug("rc error: " + r.getMsg());
		
		if(!r.getRc()) {
			ModelAndView mav = new ModelAndView("list-attivita");
			
			uri = UriComponentsBuilder
					.fromHttpUrl(backend + "attivita/listAttAbbSocio")
					.queryParam("id", attID)
					.buildAndExpand().toUri();
			log.debug("URI: " + uri);
			
			@SuppressWarnings("unchecked")
			ResponseObject<AttivitaViewDTO> resp = rest.getForEntity(uri, ResponseObject.class).getBody();
			AttivitaViewDTO dto = (AttivitaViewDTO) convertInObject(resp.getDato(), AttivitaViewDTO.class); 
			//Response<?> resp = rest.getForEntity(uri, Response.class).getBody();
			
			mav.addObject("attivita", dto);
			mav.addObject("funzione", "remove");
			
			return mav;
		}
		
		return "redirect:/admin/listAttivita";
	}
	
	@PostMapping("/saveAttivita")
	public Object saveSocio(@ModelAttribute("attivita") AttivitaRequest req) {
		log.debug("descrizione: " + req.getDescrizione());
		log.debug("id: " + req.getId());
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "attivita/create")
				.buildAndExpand().toUri();
		
		//la differenza che ho con la funzione precedente è che siamo in POST
		ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();
		log.debug("rc: " + resp.getRc());
		
		if (!resp.getRc()) {
			ModelAndView mav = new ModelAndView("create-attivita");
			req.setErrorMSG("Errore: " + resp.getMsg());
			mav.addObject("attivita", req);
			return mav;
		}
		
		//in questo modo voglio dico che voglio aggiornare la pagina e tornare in listSocio
		return "redirect:/admin/listAttivita";
		
		
	}

}
