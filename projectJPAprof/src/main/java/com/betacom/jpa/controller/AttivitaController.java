package com.betacom.jpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.request.AttivitaRequest;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.implementations.AbbonamentoServiceImpl;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggeService;

@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {
	
	@Autowired
	IAttivitaService attS;
	
	@Autowired
	IMessaggeService msgS;
	
	@Autowired
	private IAbbonamentoService abboS;
	
	public static Logger log = LoggerFactory.getLogger(AttivitaController.class);

	
	
	@PostMapping("/create")
	public ResponseBase create (@RequestBody (required = true)  AttivitaRequest req) {
		ResponseBase resp = new ResponseBase();
	    System.out.println("Socio ID: " + req.getSocioID());
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
	
	@PostMapping("/remove")
	public Response<AbbonamentoDTO> remove (@RequestBody (required = true)  AttivitaRequest req) {
		Response<AbbonamentoDTO> resp = new Response<AbbonamentoDTO>();
		resp.setRc(true);
		try {
			if(req.getDescrizione() == null)
				throw new AcademyException(msgS.getMessaggio("attiv-nodesc"));
			if(!attS.removeAttivita(req)){
				resp.setDati(attS.getByDescrizioneAtt(req.getDescrizione()));
			}
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	
	
	


	@PostMapping("/createAttivitaAbbo")
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
		r.setDati(attS.listAll());
		return r;
		
	}
	
	@GetMapping("/listByAbbonamento")
	public Response<AttivitaDTO> listByAbbonamento(Integer id){
		Response<AttivitaDTO> resp = new Response<AttivitaDTO>();
		resp.setRc(true);
		
		try {
			resp.setDati(attS.listAttivitaByAbboo(id));

		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
			
		}
		return resp;
	}
	
	@GetMapping("/listAttivitaNonAbbonamento")
	public Response<AttivitaDTO> listAttivitaNonAbbonamento(Integer id){
		Response<AttivitaDTO> resp = new Response<AttivitaDTO>();
		resp.setRc(true);
		
		try {
			resp.setDati(attS.listAttivitaNonAbboo(id));

		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
			
		}
		return resp;
	}
	
	@PostMapping("/removeAttivitaAbbo")
	public ResponseBase removeAttivitaAbbo (@RequestBody (required = true)  AttivitaRequest req) {
		ResponseBase resp = new ResponseBase();
		log.debug(req.toString());
		resp.setRc(true);
		
		try {
			
			attS.removeAttivitaAbbonamento(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}
	

}
