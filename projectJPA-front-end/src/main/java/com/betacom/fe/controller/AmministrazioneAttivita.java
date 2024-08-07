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
import com.betacom.fe.request.AttivitaReq;
import com.betacom.fe.request.UtenteReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
@RequestMapping("/admin")
public class AmministrazioneAttivita {

    @Value("${jpa.backend}")
    private String backend;

    @Autowired
    RestTemplate rest;

    public static Logger log = LoggerFactory.getLogger(AmministrazioneAttivita.class);

    @GetMapping("/listAttivita")
    public ModelAndView listAllAttivita() {
        
        ModelAndView mav = new ModelAndView("attivita-admin");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/listAll")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

        Response<?> att = rest.getForEntity(uri, Response.class).getBody();

        mav.addObject("listAttivita", att);

        return mav;
    }

    @GetMapping("/createNewAttivita")
    public ModelAndView createAttivita() {

        ModelAndView mav = new ModelAndView("create-attivita");
        AttivitaReq req = new AttivitaReq();
        req.setErrorMsg(null);
        mav.addObject("attivita", req);

        return mav;
    }

    @SuppressWarnings({ "unchecked", "null" })
    @GetMapping("/updateAttivita")
    public ModelAndView updateAttivita(@RequestParam Integer attID) {
        
        ModelAndView mav = new ModelAndView("create-attivita");
        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/attivitaByID")
                .queryParam("id", attID)
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

        ResponseObject<AttivitaDTO> response = rest.getForEntity(uri, ResponseObject.class).getBody();

        AttivitaReq attivita = new AttivitaReq();
        AttivitaDTO dto = (AttivitaDTO) convertInObject(response.getDati(), AttivitaDTO.class);
        attivita.setId(attID);
        attivita.setDescrizione(dto.getDescrizione());

        mav.addObject("attivita", attivita);

        return mav;
    }


    @PostMapping("/saveAttivita")
    public Object saveAttivita(@ModelAttribute("attivita") AttivitaReq attivita) {
        
        log.debug("\nsaveAtt -> descrizione: " + attivita.getDescrizione() + " - ID: " + attivita.getId()  + " - ErrorMsg: ");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/create")
                .buildAndExpand().toUri();

        log.debug("\nURI: " + uri);
        
        ResponseBase resp = rest.postForEntity(uri, attivita, ResponseBase.class).getBody();

        if (resp != null && !resp.getRc()) {
            ModelAndView mav = new ModelAndView("create-attivita");
            attivita.setErrorMsg(resp.getMsg());
            mav.addObject("attivita", attivita);
            return mav;
        }
        
        return "redirect:/admin/listAttivita";
    }

    @SuppressWarnings("null")
    @GetMapping("removeAttivita")
    public Object removeAttivita(@RequestParam Integer attID) {
        
        log.debug("\nremoveAtt -> ID: " + attID);

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/remove")
                .queryParam("id", attID)
                .buildAndExpand().toUri();

        ResponseBase resp = rest.getForEntity(uri, ResponseBase.class).getBody();

        log.debug("Risultato remove = " + resp.getRc());

        // if (resp!= null &&!resp.getRc()) {
        //     ModelAndView mav = new ModelAndView("attivita-socio-associato");
        //     uri = UriComponentsBuilder
		// 			.fromHttpUrl(backend + "attivita/attivitaByID")
		// 			.queryParam("id", attID)
		// 			.buildAndExpand().toUri();
		// 	log.debug("URI:" + uri);
        // }

        return "redirect:/admin/listAttivita";
    }

    @GetMapping("/createUtente")
    public ModelAndView createUtente() {

        ModelAndView mav = new ModelAndView("create-utente");
        mav.addObject("req", new UtenteReq());
        mav.addObject("errorMsg", "");

        return mav;
    }


    @PostMapping("/saveUtente")
    public Object saveUtente(@ModelAttribute("req") UtenteReq req) {
        
        log.debug("\nsaveUtente -> " +
                "\n - username: " + req.getUsername() + 
                "\n - password: " + req.getPassword() + 
                "\n - role: " + req.getRole());

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "utente/create")
                .buildAndExpand().toUri(); 
                
        log.debug("\nURI: " + uri);
        
        ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        
        if (resp!= null &&!resp.getRc()) {
            ModelAndView mav = new ModelAndView("create-utente");
            mav.addObject("req", req);
            mav.addObject("errorMsg", resp.getMsg());
            return mav;
        }
        
        return "redirect:/jpa";
    }
        


}
