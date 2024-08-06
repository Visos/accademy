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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.MotoViewDTO;
import com.betacom.fe.request.MotoReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;


@Controller
public class MotoManagerController {

	    @Value("${jpa.backend}")
	    private String backend;

	    @Autowired
	    RestTemplate rest;

	    public static Logger log = LoggerFactory.getLogger(MotoManagerController.class);

	    @GetMapping("/listMoto")
	    public ModelAndView listMoto() {

	        ModelAndView mav = new ModelAndView("list-moto");

	        URI uri = UriComponentsBuilder
	                .fromHttpUrl(backend + "veicolo/listAll")
	                .queryParam("cat", "moto")
	                .buildAndExpand().toUri();
	        log.debug("Uri: " + uri);

	        Response<?> moto = rest.getForEntity(uri, Response.class).getBody();

	        mav.addObject("listMoto", moto);

	        log.debug("List moto: " + moto);

	        return mav;
	    }

	    @GetMapping("/createMoto")
	    public ModelAndView createMoto() {
	        ModelAndView mav = new ModelAndView("create-moto");
	        MotoReq m = new MotoReq();
	        m.setErrorMsg(m.getErrorMsg());
	        mav.addObject("moto", m);

	        return mav;
	    }
	    
	    @SuppressWarnings("unchecked")
	    @GetMapping("/updateMoto")
	    public ModelAndView updateMoto(@RequestParam Integer veicoloID) {
	        ModelAndView mav = new ModelAndView("update-moto");
	        URI uri = UriComponentsBuilder.fromHttpUrl(backend + "moto/getByIdMoto")
	                .queryParam("id", veicoloID)
	                .buildAndExpand().toUri();

	        log.debug("URI", uri);

	        ResponseObject<MotoViewDTO> m = rest.getForEntity(uri, ResponseObject.class).getBody();

	        MotoReq motoR = new MotoReq();
	        motoR.setErrorMsg(null);
	        MotoViewDTO view = (MotoViewDTO) convertInObject(m.getDato(), MotoViewDTO.class);
	        motoR.setAlimentazione(view.getAlimentazione());
	        motoR.setCilindrata(view.getCilindrata());
	        motoR.setColore(view.getColore());
	        motoR.setId(view.getMotoID());
	        motoR.setIdVeicolo(view.getIdVeicolo());
	        motoR.setKilowatt(view.getKilowatt());
	        motoR.setMarca(view.getMarca());
	        motoR.setNumeroPosti(view.getNumeroPosti());
	        motoR.setNumeroRuote(view.getNumeroRuote());
	        motoR.setTarga(view.getTarga());
	        motoR.setTipoVeicolo(view.getTipo());
	        mav.addObject("moto", motoR);
	        return mav;
	    }

	    @PostMapping("/saveMoto")
	    public Object saveMoto(@ModelAttribute("moto") MotoReq req) {

	        System.out.println(req.getId());
	        System.out.println(req.getIdVeicolo());

	        if (req.getIdVeicolo() != null) {
	            URI uri = UriComponentsBuilder
	            		.fromHttpUrl(backend + "moto/updateMoto")
	            		.buildAndExpand().toUri();
	            
	            ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();	            
	            
	            if (!resp.getRc()) {
		            ModelAndView mav = new ModelAndView("update-moto");
		            req.setErrorMsg(resp.getMsg());
		            mav.addObject("moto", req);
		            return mav;
		        }
	            
	            return "redirect:/listMoto";

	        }

	        URI uri = UriComponentsBuilder
	        		.fromHttpUrl(backend + "moto/create")
	        		.buildAndExpand().toUri();

	        ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

	        log.debug("return code: " + resp.getRc());

	        if (!resp.getRc()) {
	            ModelAndView mav = new ModelAndView("create-moto");
	            req.setErrorMsg(resp.getMsg());
	            mav.addObject("moto", req);
	            return mav;
	        }

	        return "redirect:/listMoto";
	    }
	}

