package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.request.AttivitaReq;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggioService;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioDTO;

@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {
	
	@Autowired
	private IAttivitaService attS;
	
	@Autowired
	IMessaggioService msgS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			if (req.getDescrizione() == null)
				throw new AcademyException(msgS.getMessaggio("attiv-nodesc"));
			
			attS.create(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	

	@PostMapping("/createAttivitaAbbo")
	public ResponseBase createAttivitaAbbo(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			attS.createAttivitaAbbonamento(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	

	@PostMapping("/removeAttivitaAbbo")
	public ResponseBase removeAttivitaAbbo(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			attS.removeAttivitaAbbonamento(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	


	@PostMapping("/removeAttivita")
	public Response<SocioDTO> removeAttivita(@RequestBody (required = true)  AttivitaReq req) {
		Response<SocioDTO> res = new Response<SocioDTO>();
		res.setRc(true);
		
		try {
			res.setDati(attS.removeAttivita(req));
			if (!res.getDati().isEmpty())
				res.setRc(false);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	
	@GetMapping("/list")
	public ResponseObject<AttivitaViewDTO> list(@RequestParam("id")Integer id){
		ResponseObject<AttivitaViewDTO> r = new ResponseObject<AttivitaViewDTO>();
		r.setRc(true);
		
		try {
			r.setDati(attS.list(id));
		} catch (AcademyException e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		return r;
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
		Response<AttivitaDTO> r = new Response<AttivitaDTO>();
		r.setRc(true);
		try {
			r.setDati(attS.listByAbbonamento(id));
		} catch (AcademyException e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		return r;
	}

	@GetMapping("/listAttivitaNonAbbonamento")
	public Response<AttivitaDTO> listAttivitaNonAbbonamento(Integer id){
		Response<AttivitaDTO> r = new Response<AttivitaDTO>();
		r.setRc(true);
		try {
			r.setDati(attS.listAttivitaNonAbbonamento(id));
		} catch (AcademyException e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		return r;
	}

}
