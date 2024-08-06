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

import com.betacom.fe.dto.VeicoloViewDTO;
import com.betacom.fe.request.BiciReq;
import com.betacom.fe.request.VeicoloReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
public class BiciManagerController {

	@Value("${jpa.backend}")
	private String backend;

	@Autowired
	RestTemplate rest;

	public static Logger log = LoggerFactory.getLogger(BiciManagerController.class);

	@GetMapping("/listBici")
	public ModelAndView listBici() {

		ModelAndView mav = new ModelAndView("list-bici");

		URI uri = UriComponentsBuilder.fromHttpUrl(backend + "veicolo/listAll").queryParam("cat", "bici")
				.buildAndExpand().toUri();
		log.debug("Uri: " + uri);

		Response<?> veicolo = rest.getForEntity(uri, Response.class).getBody();

		mav.addObject("listVeicolo", veicolo);

		return mav;
	}

	@PostMapping("/saveBici")
	public Object saveBici(@ModelAttribute("veicolo") BiciReq req) {
		
		URI uri = UriComponentsBuilder.fromHttpUrl(backend + "bici/create").buildAndExpand().toUri();

		
		if(req.getIdVeicolo() != null) {

			uri = UriComponentsBuilder.fromHttpUrl(backend + "veicolo/update").buildAndExpand().toUri();

		}
		
		log.debug("uri:" + uri);
		ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

		log.debug("rc:" + resp.getRc());

		if (!resp.getRc()) {
			ModelAndView mav = new ModelAndView("create-bici");
			req.setErrorMsg(resp.getMsg());
			mav.addObject("veicolo", req);
			return mav;
		}

		return "redirect:/listBici";
	}

	@GetMapping("/createBici")
	public ModelAndView createBici(Integer idVeicolo ) {
		ModelAndView mav = new ModelAndView("create-bici");
		BiciReq s = new BiciReq();
		s.setIdVeicolo(idVeicolo);
		
		System.out.println("VEICOLOID" + idVeicolo);
		s.setErrorMsg(null);
		mav.addObject("veicolo", s);
		

		return mav;
	}
	
 

}