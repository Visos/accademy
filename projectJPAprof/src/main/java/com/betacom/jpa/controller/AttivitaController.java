package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.request.AttivitaRequest;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggeService;

@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {
	
	@Autowired
	IAttivitaService attS;
	
	@Autowired
	IMessaggeService msgS;
	
	@PostMapping("/create")

	public ResponseBase create (@RequestBody (required = true)  AttivitaRequest req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			
			if(req.getDescrizione() == null)
				throw new AcademyException(msgS.getMessaggio("attiv-nodesc"));
			attS.create(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	
	@PostMapping("/createAttivitaAbbonamento")
	public ResponseBase createAttivitaAbbonamento (@RequestBody (required = true)  AttivitaRequest req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			
			attS.createAttivitaAbbonamento(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	
	
	
	@GetMapping("/listAll")
	public Response<AttivitaDTO> listAll(){
		Response<AttivitaDTO> r = new Response<AttivitaDTO>();
		r.setRc(true);
		r.setDati(attS.listAll(null));
		return r;
		
		
		
	}
	

}
