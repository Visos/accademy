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
import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@RestController
@RequestMapping("/rest/abbonamento")
public class AbbonamentoController {
	
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
	
	@GetMapping("/list")
	public Response<AbbonamentoViewDTO> list (@RequestBody (required = false)  Integer id) {
		Response<AbbonamentoViewDTO> resp = new Response<AbbonamentoViewDTO>();
		resp.setRc(true);
		
		try {
			resp.setDati(abboS.listAbbonamento(id));
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		
		return resp;
	}
	
	@GetMapping("/listBySocio")
	public Response<AbbonamentoViewDTO> listBySocio (Integer id) {
		Response<AbbonamentoViewDTO> resp = new Response<AbbonamentoViewDTO>();
		resp.setRc(true);
		
		try {
			resp.setDati(abboS.listAbbonamentiBySocio(id));
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		
		return resp;
	}
	
	@PostMapping("/remove")
	public ResponseBase remove (@RequestBody (required = true)  Integer id) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			abboS.removeAbbonamento(id);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	
	
	
	
	

}
