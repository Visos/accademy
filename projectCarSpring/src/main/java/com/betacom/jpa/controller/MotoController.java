package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.CreateReq;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.MotoViewDto;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.intefaces.IMessaggeService;
import com.betacom.jpa.service.intefaces.IMotoService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@RestController
@RequestMapping("/rest/moto")
public class MotoController {
	
	@Autowired
	IMotoService motoS;
	
	@Autowired
	IveicoloService vecS;
	
	@Autowired
	IMessaggeService msgS;
	
	@GetMapping("/list")
	public Response<MotoViewDto> listAll(@RequestParam (required = false)  Integer id, String nome, String cognome){
		Response<MotoViewDto> resp = new Response<MotoViewDto>();
		resp.setRc(true);
		resp.setDati(motoS.listAllMoto());
		return resp;
	}
	
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  CreateReq<MotoDTO> macReq) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		String s = macReq.getVeicolo().getColore();
		System.out.println(s);  
		
		
		try {
			if (macReq.getTipo().getCc() == null)
				throw new AcademyException(msgS.getMessaggio("mot-nocc"));
			if (macReq.getTipo().getTarga() == null)
				throw new AcademyException(msgS.getMessaggio("mot-notarga"));
			if (macReq.getVeicolo().getMarca() == null)
				throw new AcademyException(msgS.getMessaggio("veic-nomarca"));
			
			
			vecS.createMoto(macReq.getTipo(), macReq.getVeicolo());
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg("ERRORE"+e.getMessage());
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	@DeleteMapping("/delete")
	public ResponseBase removeVeicolo(@RequestParam (required = true)  Integer id) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		try {
			motoS.removeMoto(id);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

}
