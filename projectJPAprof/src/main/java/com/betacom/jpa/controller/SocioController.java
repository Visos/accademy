package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.service.implementations.MessageServiceImpl;
import com.betacom.jpa.service.interfaces.ISocioService;


@RestController
@RequestMapping("/rest/socio")
public class SocioController {
	
	@Autowired
	ISocioService socioS;
	
	@Autowired
	MessageServiceImpl msgS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  SocioDTO req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
			if (req.getNome() == null)
				throw new AcademyException(msgS.getMessaggio("socio-nonome"));
			if (req.getCognome() == null)
				throw new AcademyException(msgS.getMessaggio("socio-nocognome"));
			if (req.getcFiscale() == null)
				throw new AcademyException(msgS.getMessaggio("socio-nocfiscale"));
			
			
			socioS.createUpdateSocio(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}
	
	@DeleteMapping("/delete")
	public ResponseBase remove(@RequestBody (required = true)  SocioDTO req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {

			socioS.removeSocio(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}

	@GetMapping("/list")
	public Response<SocioViewDTO> listAll(@RequestParam (required = false)  Integer id, String nome, String cognome){
		Response<SocioViewDTO> resp = new Response<SocioViewDTO>();
		resp.setRc(true);
		resp.setDati(socioS.listAllSocio(id, nome, cognome));
		return resp;
	}
	
	@GetMapping("/getById")
	public ResponseObject<SocioViewDTO> getById( Integer id){
		ResponseObject<SocioViewDTO> resp = new ResponseObject<SocioViewDTO>();
		resp.setDati(socioS.searchById(id));
		resp.setRc(true);
		return resp;
	}
	
}
