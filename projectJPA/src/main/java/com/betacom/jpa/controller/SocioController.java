package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.Responsebase;
import com.betacom.jpa.service.interfaces.ISocioService;

@RestController
@RequestMapping("/rest/socio")
public class SocioController {
	
	@Autowired
	ISocioService socioS;
	
	@PostMapping("/create")
	public Responsebase create(@RequestBody ( required =true) SocioDTO req) {
		Responsebase res = new Responsebase();
		res.setRc(true);
		
		try {
			if(req.getNome() == null) {
				throw new AcademyException("nome non presente");
			}
			if(req.getCognome() == null) {
				throw new AcademyException("cognome non presente");
			}
			if(req.getcFiscale() == null) {
				throw new AcademyException("cFiscale non presente");
			}
			
			
			
			socioS.createSocio(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
			e.printStackTrace();
		}

		return res;

	}
	
	@GetMapping("/listAll")
	public Response<SocioViewDTO> listAll(){
		Response<SocioViewDTO> res = new Response<SocioViewDTO>();
		res.setRc(true);
		res.setDati(socioS.listAllSocio());
		
		return res;
	}

}
