package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.PersoneReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.response.Response;

import com.betacom.jpa.service.interfaces.IPersoneService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/rest/persone")
public class PersoneController {
	@Autowired
	IPersoneService perS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) PersoneReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		try {
			perS.create(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

	
	@PostMapping("/update")
	public ResponseBase update(@RequestBody (required = true) PersoneReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		try {
			perS.update(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

	
	@PostMapping("/delete")
	public ResponseBase delete(@RequestBody (required = true) PersoneReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		try {
			perS.delete(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

	
	@GetMapping("/list")
	public Response<PersoneDTO> list() {
		Response<PersoneDTO> res = new Response<PersoneDTO>();
		res.setRc(true);
		res.setDati(perS.list());
		return res;
	}


	@GetMapping("/getPersona")
	public ResponseObject<PersoneDTO> getPersona(Integer id) {
		ResponseObject<PersoneDTO> res = new ResponseObject<PersoneDTO>();
		res.setRc(true);
		try {
			
			 res.setDati(perS.getPersona(id));
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

}