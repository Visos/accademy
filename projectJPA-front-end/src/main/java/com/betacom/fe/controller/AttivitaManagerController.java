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

import com.betacom.fe.request.AttivitaReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;


@Controller
public class AttivitaManagerController {

    @Value("${jpa.backend}")
    private String backend;

    @Autowired
    RestTemplate rest;

    public static Logger log = LoggerFactory.getLogger(AttivitaManagerController.class);

    @GetMapping("/attivitaAbbonamenti")
    public Object attivitaAbbonamenti(@RequestParam Integer abbID, @RequestParam Integer socioID) {
        ModelAndView mav = new ModelAndView("list-attivita");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/listByAbbonamento")
                .queryParam("id", abbID)
                .buildAndExpand().toUri();
        log.debug("\nUri : " + uri);

        Response<?> attiv = rest.getForEntity(uri, Response.class).getBody();
        mav.addObject("attivita", attiv);
        mav.addObject("abbID", abbID);
        mav.addObject("socioID", socioID);
        mav.addObject("funzione", "list");


        return mav;
    }
    @SuppressWarnings("null")
    @GetMapping("/removeAttivitaAbbonamenti")
    public Object removeAttivitaAbbonamenti(@RequestParam Integer abbID, @RequestParam Integer attID, @RequestParam Integer socioID) {

        log.debug("abbID: " + abbID + ", attID: " + attID);

        AttivitaReq req = new AttivitaReq();
        req.setAbbonamentoID(abbID);
        req.setId(attID);

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/removeAttivitaAbbo")
                .buildAndExpand().toUri();
        log.debug("Uri: " + uri);

        ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        
        log.debug("rc=" + resp.getRc());

        return "redirect:/attivitaAbbonamenti?abbID=" + abbID + "&socioID=" + socioID;
    }
    @GetMapping("/createAttivita")
    public ModelAndView createAttivita(@RequestParam Integer abbID, @RequestParam Integer socioID) {
        ModelAndView mav = new ModelAndView("create-attivita-abbonamento");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/listAllNoAbb")
                .queryParam("id", abbID)
                .buildAndExpand().toUri();
        log.debug("Uri: " + uri);

        Response<?> attiv = rest.getForEntity(uri, Response.class).getBody();
        mav.addObject("listAttivita", attiv);

        AttivitaReq req = new AttivitaReq();
        req.setAbbonamentoID(abbID);
        req.setSocioID(socioID);
        mav.addObject("attivitaReq", req);

        return mav;
    }

    @SuppressWarnings("null")
    @PostMapping("/saveAttivitaAbbonamento")
    public Object saveAttivitaAbbonamento(@ModelAttribute("attivitaReq") AttivitaReq req) {

        log.debug("\nid attivita: " + req.getId() + " " + "id abbonamento: " + req.getAbbonamentoID());

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "attivita/createAttivitaAbbo")
                .buildAndExpand().toUri();
        log.debug("Uri: " + uri);

        ResponseBase attiv = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        log.debug("rc create attivita per abbonamento:" + attiv.getRc());

        return "redirect:/attivitaAbbonamenti?abbID=" + req.getAbbonamentoID() + "&socioID=" + req.getSocioID();
    }
    
    
}
