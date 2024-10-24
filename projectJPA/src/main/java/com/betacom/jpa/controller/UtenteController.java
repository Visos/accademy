
package com.betacom.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.service.interfaces.IUtenteService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/rest/utente")
public class UtenteController {
	
	@Autowired
	private IUtenteService utenteS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  UtenteReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			utenteS.createUtente(req);
			
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}
	
	@GetMapping("/list")
	public List<UtenteDTO> list(){
		return utenteS.getAll();
		
	}

	@GetMapping("/findUtente")
	public UtenteDTO findUtente(String name){
		try {
			return utenteS.findUtente(name);
		} catch (AcademyException e) {
			return null;
		}
		
	}

	@GetMapping("/findID")
	public UtenteDTO findID(Integer id){
		try {
			return utenteS.findUtenteById(id);
		} catch (AcademyException e) {
			return null;
		}
		
	}

	@GetMapping("/signin")
	public  ResponseObject<UtenteDTO> signin(String user, String pwd){
		ResponseObject<UtenteDTO> r = new ResponseObject<UtenteDTO>();
		r.setRc(true);
		try {
			r.setDati(utenteS.signIn(user, pwd));
		} catch (AcademyException e) {
			r.setRc(false);
			r.setMsg(e.getMessage());
		}
		return r;
	}

}
