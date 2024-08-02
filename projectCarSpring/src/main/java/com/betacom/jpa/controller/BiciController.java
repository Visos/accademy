package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.BiciViewDto;
import com.betacom.jpa.dto.CreateReq;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MacchinaViewDto;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.Response;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.intefaces.IBiciService;
import com.betacom.jpa.service.intefaces.IMacchinaService;
import com.betacom.jpa.service.intefaces.IMessaggeService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@RestController
@RequestMapping("/rest/bici")
public class BiciController {
	
	@Autowired
	IBiciService biciS;
	
	@Autowired
	IveicoloService vecS;
	
	@Autowired
	IMessaggeService msgS;
	
	@GetMapping("/list")
	public Response<BiciViewDto> listAll(@RequestParam (required = false)  Integer id, String nome, String cognome){
		Response<BiciViewDto> resp = new Response<BiciViewDto>();
		resp.setRc(true);
		resp.setDati(biciS.listAllBici());
		return resp;
	}
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  CreateReq<BiciDTO> macReq) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		String s = macReq.getVeicolo().getColore();
		System.out.println(s);  
		
		
		try {
			if (macReq.getTipo().getPieghevole() == null)
				throw new AcademyException(msgS.getMessaggio("mac-noporte"));
			if (macReq.getTipo().getTipoUso() == null)
				throw new AcademyException(msgS.getMessaggio("mac-notarga"));
			if (macReq.getVeicolo().getMarca() == null)
				throw new AcademyException(msgS.getMessaggio("veic-marca"));
			
			
			vecS.createBici(macReq.getTipo(), macReq.getVeicolo());
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
			biciS.removeBici(id);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}
	
	
	
	
	@PostMapping("/addAmmortizzatore")
	public ResponseBase addAmmortizzatore() {
		ResponseBase res = new ResponseBase();

		
		return res;
	}

}
