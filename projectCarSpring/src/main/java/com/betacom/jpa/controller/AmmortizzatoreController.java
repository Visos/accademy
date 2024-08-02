package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.CreateReq;
import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.intefaces.IBiciService;
import com.betacom.jpa.service.intefaces.IMessaggeService;
import com.betacom.jpa.service.intefaces.ITipoAmmortizzatoreService;

@RestController
@RequestMapping("/rest/ammortizzatore")
public class AmmortizzatoreController {

	@Autowired
	ITipoAmmortizzatoreService ammoS;
	
	@Autowired
	IMessaggeService msgS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true)  TipoAmmortizzatoreDTO req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true); 

		try {
			if (req.getDescrizione() == null)
				throw new AcademyException(msgS.getMessaggio("ammo-nodesc"));
			if (req.getId() == null)
				throw new AcademyException(msgS.getMessaggio("ammo-noId"));

			ammoS.createAmmortizzatore(req);
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
			ammoS.removeAmmortizzatore(id);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}
	
}
