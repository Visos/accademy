package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.ICertificatoService;

@RestController
@RequestMapping("/rest/certificato")
public class CertificatoController {
	@Autowired
	ICertificatoService certifS;
	
	@PostMapping("/create")
	public ResponseBase create (@RequestBody (required = true)  CertificatoReq req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			certifS.createUpate(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	
	@DeleteMapping("/remove")
	public ResponseBase remove (@RequestBody (required = true)  CertificatoReq req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		try {
			certifS.remove(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
		
		
	}
	
	@GetMapping("/listAll")
	public Response<CertificatoDTO> listAll(){
		Response<CertificatoDTO> resp = new Response<CertificatoDTO>();
		resp.setRc(true);
		
		resp.setDati(certifS.listCertificati());
		return resp;
		
	}
}
