package com.betacom.jpa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.pojo.Utente;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IUtenteService;

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
		} catch (Exception e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}
	@GetMapping("/list")
	public List<HashMap<String, Object>> list(){
		List<HashMap<String, Object>> resp = new ArrayList<HashMap<String,Object>>();
		List<UtenteDTO> ut = utenteS.getAll();
		
		for (UtenteDTO u : ut) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userName", u.getUserName());
			map.put("pwd", u.getPwd());
			map.put("role", u.getRole());
			resp.add(map);
		}
		
		return resp;
	}
	
}
