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
import com.betacom.jpa.dto.MacchinaViewDto;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.implementations.MessageServiceImpl;
import com.betacom.jpa.service.intefaces.IMacchinaService;
import com.betacom.jpa.service.intefaces.IMessaggeService;
import com.betacom.jpa.service.intefaces.IveicoloService;



@RestController
@RequestMapping("/rest/macchina")
public class MacchinaController {
	
	@Autowired
	IMacchinaService maccS;
	
	
	@Autowired
	IveicoloService vecS;
	
	@Autowired
	IMessaggeService msgS;
	
	@GetMapping("/list")
	public Response<MacchinaViewDto> listAll(@RequestParam (required = false)  Integer id){
		Response<MacchinaViewDto> resp = new Response<MacchinaViewDto>();
		resp.setRc(true);
		resp.setDati(maccS.listAllMacchine());
		return resp;
	}
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  CreateReq<MacchinaDTO> macReq) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		String s = macReq.getVeicolo().getColore();
		System.out.println(s);  
		
		
		try {
			if (macReq.getTipo().getNumeroPorte() == null)
				throw new AcademyException(msgS.getMessaggio("mac-noporte"));
			if (macReq.getTipo().getNumerotarga() == null)
				throw new AcademyException(msgS.getMessaggio("mac-notarga"));
			if (macReq.getVeicolo().getMarca() == null)
				throw new AcademyException(msgS.getMessaggio("veic-nomarca"));
			
			
			vecS.createMacchina(macReq.getTipo(), macReq.getVeicolo());
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
			maccS.removeMacchina(id);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}
	

}
