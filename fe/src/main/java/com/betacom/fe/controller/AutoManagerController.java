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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.request.AutoReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;

@Controller
public class AutoManagerController {

    @Value("${jpa.backend}")
    String backend;

    @Autowired
    RestTemplate rest;

    public static Logger log = LoggerFactory.getLogger(AutoManagerController.class);

    @GetMapping("/listAuto")
    public ModelAndView listAuto() {

        ModelAndView mav = new ModelAndView("list-auto");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "veicolo/listAll")
                .queryParam("cat", "auto")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

         Response<?> auto = rest.getForEntity(uri, Response.class).getBody();

         mav.addObject("auto", auto);
         mav.addObject("funzione", "list");
        
         return mav;
    }

    @GetMapping("/createAuto")
    public ModelAndView createAuto() {
        ModelAndView mav = new ModelAndView("create-auto");

        AutoReq req = new AutoReq();
        req.setErrorMsg(null);
        mav.addObject("auto", req);

        return mav;
    }

    @PostMapping("/saveAuto")
    public Object saveAuto(@ModelAttribute("auto") AutoReq req) {
        
        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "auto/create")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);
        
        ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

        if (!resp.getRc()) {
            ModelAndView mav = new ModelAndView("create-auto");
            req.setErrorMsg(resp.getMsg());
            mav.addObject("auto", req);
            return mav;
        }
        
        return "redirect:/listAuto";
    }
}