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

import com.betacom.fe.dto.SocioDTO;
import com.betacom.fe.dto.SocioViewDTO;
import com.betacom.fe.request.SocioReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;
import static com.betacom.fe.utilities.WebUtils.convertInObject;



@Controller
public class SocioManagerController {

    @Value("${jpa.backend}")
    String backend;

    @Autowired
    RestTemplate rest;

    public static Logger log = LoggerFactory.getLogger(SocioManagerController.class);

    @GetMapping(value = {"/jpa", "/listSocio"})
    public ModelAndView listAllSocio() {

        ModelAndView mav = new ModelAndView("index");
        
        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "socio/list")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

        Response<?> soc = rest.getForEntity(uri, Response.class).getBody();

        mav.addObject("listSocio", soc);

        return mav;
    }

    @GetMapping("/createSocio")
    public ModelAndView createSocio() {

        ModelAndView mav = new ModelAndView("create-socio");
        
        SocioReq req = new SocioReq();
        req.setErrorMsg(null);
        mav.addObject("socio", req);

        return mav;
    }

    @SuppressWarnings({ "unchecked", "null" })
    @GetMapping("/updateSocio")
    public ModelAndView updateSocio(@RequestParam Integer id) {

        ModelAndView mav = new ModelAndView("create-socio");
        
        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "socio/getById")
                .queryParam("id", id)
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

        ResponseObject<SocioViewDTO> response = rest.getForEntity(uri, ResponseObject.class).getBody();

        SocioReq req = new SocioReq();
        SocioViewDTO viewDTO = (SocioViewDTO) convertInObject(response.getDati(), SocioViewDTO.class);
        req.setErrorMsg(null);
        req.setId(viewDTO.getId());
        req.setNome(viewDTO.getNome());
        req.setCognome(viewDTO.getCognome());
        req.setcFiscale(viewDTO.getcFiscale());

        mav.addObject("socio", req);
        

        return mav;
    }

    @PostMapping("/saveSocio")
    public Object saveSocio(@ModelAttribute("socio") SocioReq socio) {
        
        log.debug("\nsaveSocio -> Cognome: " + socio.getCognome());
        
        SocioDTO dto = new SocioDTO();
        dto.setId((socio.getId() == null) ? null : socio.getId());
        dto.setNome(socio.getNome());
        dto.setCognome(socio.getCognome());
        dto.setcFiscale(socio.getcFiscale());
        
        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "socio/create")
                .buildAndExpand().toUri();

        log.debug("\nURI: " + uri);
        
        ResponseBase resp = rest.postForEntity(uri, dto, ResponseBase.class).getBody();

        if (resp != null && !resp.getRc()) {
            ModelAndView mav = new ModelAndView("create-socio");
            socio.setErrorMsg(resp.getMsg());
            mav.addObject("socio", socio);
            return mav;
        }
        
        return "redirect:/listSocio";
    }
}
