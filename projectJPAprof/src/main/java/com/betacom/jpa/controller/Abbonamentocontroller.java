package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@RestController
@RequestMapping("/rest/abbonamento")
public class Abbonamentocontroller {
	
	@Autowired
	private IAbbonamentoService abboS;
	
	
	@PostMapping("/create")
	public ResponseBase create (@RequestBody (required = true)  AbbonamentoReq req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			abboS.create(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	

}
