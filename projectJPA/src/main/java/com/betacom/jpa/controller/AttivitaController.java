package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AttivitaReq;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggioService;

@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {
	
	@Autowired
	private IAttivitaService attS;
	
	@Autowired
	IMessaggioService msgS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			if (req.getDescrizione() == null)
				throw new AcademyException(msgS.getMessaggio("attiv-nodesc"));
			
			attS.create(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		
		return resp;
	}	

	@PostMapping("/createAttivitaAbbo")
	public ResponseBase createAttivitaAbbo(@RequestBody (required = true)  AttivitaReq req) {
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

	@PostMapping("/removeAttivitaAbbo")
	public ResponseBase removeAttivitaAbbo(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			attS.removeAttivitaAbbonamento(req);
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		
		return resp;
	}	


	@DeleteMapping("/removeAttivita")
	public ResponseBase removeAttivita(@RequestBody (required = true)  AttivitaReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			attS.removeAttivita(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}	
	@GetMapping("/list")
	public ResponseObject<AttivitaViewDTO> list(@RequestParam("id")Integer id){
		ResponseObject<AttivitaViewDTO> resp = new ResponseObject<AttivitaViewDTO>();
		resp.setRc(true);
		
		try {
			resp.setDati(attS.list(id));
		} catch (AcademyException e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}

	
	@GetMapping("/listAll")
	public Response<AttivitaDTO> listAll(){
		Response<AttivitaDTO> resp = new Response<AttivitaDTO>();
		resp.setRc(true);
		resp.setDati(attS.listAll());
		
		return resp;
	}

	@GetMapping("/listByAbbonamento")
	public Response<AttivitaDTO> listByAbbonamento(Integer id){
		Response<AttivitaDTO> resp = new Response<AttivitaDTO>();
		resp.setRc(true);
		try {
			resp.setDati(attS.listByAbbonamento(id));
		} catch (Exception e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}

	@GetMapping("/listAllNoAbb")
    public Response<AttivitaDTO> listAllNoAbb(Integer id){
		Response<AttivitaDTO> resp = new Response<AttivitaDTO>();
		resp.setRc(true);
		try {
			resp.setDati(attS.listAllNoAbb(id));
		} catch (Exception e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;
	}

	@GetMapping("/attivitaByID")
	public ResponseObject<AttivitaDTO> attivitaByID(@RequestParam Integer id) {
		
		ResponseObject<AttivitaDTO> resp = new ResponseObject<AttivitaDTO>();
		resp.setRc(true);
		try {
			resp.setDati(attS.attivitaByID(id));
		} catch (Exception e) {
			resp.setRc(false);
			resp.setMsg(e.getMessage());
		}
		return resp;

	}
	
}
