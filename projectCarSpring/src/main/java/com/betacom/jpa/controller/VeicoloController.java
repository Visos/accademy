package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.service.intefaces.IMessaggeService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@RestController
@RequestMapping("/rest/veicolo")
public class VeicoloController {

	@Autowired
	IveicoloService vecS;
	
	@Autowired
	IMessaggeService msgS;
	
	@GetMapping("/list")
	public Response<VeicoloDTO> listAll(){
		Response<VeicoloDTO> resp = new Response<VeicoloDTO>();
		resp.setRc(true);
		resp.setDati(vecS.listAll());
		return resp;
	}
}
