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

import static com.betacom.fe.utilities.WebUtils.convertInObject;

import com.betacom.fe.dto.VeicoloViewDTO;
import com.betacom.fe.request.AutoReq;
import com.betacom.fe.request.VeicoloReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;


@Controller
public class VeicoloManagerController {

    @Value("${jpa.backend}")
    private String backend;

    @Autowired
    RestTemplate rest;

    

    public static Logger log = LoggerFactory.getLogger(VeicoloManagerController.class);

    @GetMapping(value = {"/carjpa","/listVeicolo"})
    public ModelAndView listVeicolo() {

        ModelAndView mav = new ModelAndView("list-veicolo");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "veicolo/listVeicoli")
                .buildAndExpand().toUri();
        log.debug("Uri: " + uri);

        Response<?> veicolo = rest.getForEntity(uri, Response.class).getBody();

        mav.addObject("listVeicolo", veicolo);

        return mav;
    }
    
    @GetMapping("/removeVeicolo")
    public Object removeVeicolo(@RequestParam Integer veicoloID) {
        VeicoloReq req = new VeicoloReq();
        req.setIdVeicolo(veicoloID);

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "veicolo/delete")
                .buildAndExpand().toUri();
        log.debug("URI", uri);
        ResponseBase r = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        log.debug("rc: " + r.getRc());

        return "redirect:/listVeicolo";
    }
//    
//
//	@PostMapping("/saveVeicolo")
//	public Object saveSocio(@ModelAttribute("veicolo") VeicoloReq req) {
//		log.debug("id: " + req.getIdVeicolo());
//		
//		URI uri = UriComponentsBuilder
//				.fromHttpUrl(backend + "veicolo/create")
//				.buildAndExpand().toUri();
//		
//		//la differenza che ho con la funzione precedente è che siamo in POST
//		ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();
//		log.debug("rc: " + resp.getRc());
//		
//		if (!resp.getRc()) {
//			ModelAndView mav = new ModelAndView("update-veicolo");
//			req.setErrorMSG("Errore: " + resp.getMsg());
//			mav.addObject("attivita", req);
//			return mav;
//		}
//		
//		//in questo modo voglio dico che voglio aggiornare la pagina e tornare in listSocio
//		return "redirect:/listVeicolo";
//		
//		
//	}
    
}
