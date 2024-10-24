package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@RestController
@RequestMapping("/rest/abbonamento")
public class AbbonamentoController {

	@Autowired
	private IAbbonamentoService abboS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  AbbonamentoReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			abboS.create(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	

	@PostMapping("/remove")
	public ResponseBase remove(@RequestBody (required = true)  Integer id) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			abboS.removeAbbonamento(id);
			
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	

	@PostMapping("/forseRemove")
	public ResponseBase forseRemove(@RequestBody (required = true)  Integer id) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			abboS.forseRemoveAbbonamento(id);
			
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	

	
	@GetMapping("/list")
	public Response<AbbonamentoViewDTO> list(Integer id){
		Response<AbbonamentoViewDTO> res = new Response<AbbonamentoViewDTO>();
		res.setRc(true);
		try {
			res.setDati(abboS.listAbbonamenti(id));
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
		
		
	}

	@GetMapping("/listBySocio")
	public Response<AbbonamentoViewDTO> listBySocio(Integer id){
		Response<AbbonamentoViewDTO> res = new Response<AbbonamentoViewDTO>();
		res.setRc(true);
		try {
			res.setDati(abboS.listAbbonamentiBySocio(id));
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
		
		
	}

	
}
