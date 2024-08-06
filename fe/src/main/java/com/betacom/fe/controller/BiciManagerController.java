package com.betacom.fe.controller;

import static com.betacom.fe.utilities.WebUtils.convertInObject;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import com.betacom.fe.dto.BiciViewDTO;
import com.betacom.fe.request.BiciReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
public class BiciManagerController {

	@Value("${jpa.backend}")
	private String backend;

	@Autowired
	RestTemplate rest;

	public static Logger log = LoggerFactory.getLogger(BiciManagerController.class);

	@GetMapping("/listBici")
	public ModelAndView listBici() {

		ModelAndView mav = new ModelAndView("list-bici");

		URI uri = UriComponentsBuilder.fromHttpUrl(backend + "veicolo/listAll")
				.queryParam("cat", "bici")
				.buildAndExpand().toUri();
		log.debug("Uri: " + uri);

		Response<?> veicolo = rest.getForEntity(uri, Response.class).getBody();

		mav.addObject("listVeicolo", veicolo);

		return mav;
	}
	
	@GetMapping("/createBici")
	public ModelAndView createBici() {
		ModelAndView mav = new ModelAndView("create-bici");
		BiciReq s = new BiciReq();
		s.setErrorMsg(null);
		mav.addObject("bici", s);

		return mav;
	}
	
	@SuppressWarnings("unchecked")
    @GetMapping("/updateBici")
    public ModelAndView updateMoto(@RequestParam Integer veicoloID) {
        ModelAndView mav = new ModelAndView("update-bici");
        URI uri = UriComponentsBuilder.fromHttpUrl(backend + "bici/getByIdBici")
                .queryParam("id", veicoloID)
                .buildAndExpand().toUri();

        log.debug("URI", uri);

        ResponseObject<BiciViewDTO> m = rest.getForEntity(uri, ResponseObject.class).getBody();
        
		BiciReq save = new BiciReq();
		save.setErrorMsg(null);
		BiciViewDTO view = (BiciViewDTO) convertInObject(m.getDato(), BiciViewDTO.class);
		save.setIdVeicolo(veicoloID);
		save.setAlimentazione(view.getAlimentazione());
		save.setAmmortizzatore(view.getAmmortizzatore());
		save.setColore(view.getColore());
		save.setMarca(view.getMarca());
		save.setNumeroPosti(view.getNumeroPosti());
		save.setNumeroRuote(view.getNumeroRuote());
		save.setPedalataAssistita(view.getPedalataAssistita());
		save.setPieghevole(view.getPieghevole());
		save.setTipoVeicolo(view.getTipo());
		mav.addObject("bici", save);
        return mav;
    }

	@PostMapping("/saveBici")
	public Object saveBici(@ModelAttribute("bici") BiciReq req) {
		
		if (req.getIdVeicolo() != null) {
			URI uri = UriComponentsBuilder
					.fromHttpUrl(backend + "bici/updateBici")
					.buildAndExpand().toUri();
			log.debug("uri:" + uri);

			ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

			log.debug("rc:" + resp.getRc());

			if (!resp.getRc()) {
				ModelAndView mav = new ModelAndView("update-bici");
				req.setErrorMsg(resp.getMsg());
				mav.addObject("veicolo", req);
				return mav;
			}
			
			return "redirect:/listBici";
		}
		
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "bici/create")
				.buildAndExpand().toUri();
		log.debug("uri:" + uri);

		ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

		log.debug("rc:" + resp.getRc());

		if (!resp.getRc()) {
			ModelAndView mav = new ModelAndView("create-bici");
			req.setErrorMsg(resp.getMsg());
			mav.addObject("veicolo", req);
			return mav;
		}

		return "redirect:/listBici";
	}



}