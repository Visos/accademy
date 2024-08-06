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
import com.betacom.fe.dto.AutoViewDTO;
import com.betacom.fe.request.AutoReq;
import com.betacom.fe.response.Response;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
public class AutoManagerController {

    @Value("${jpa.backend}")
    String backend;

    @Autowired
    RestTemplate rest;

    public static Logger log = LoggerFactory.getLogger(AutoManagerController.class);

    @GetMapping("/listAuto")
    public ModelAndView listAuto() {

        ModelAndView mav = new ModelAndView("list-auto");

        URI uri = UriComponentsBuilder
                .fromHttpUrl(backend + "veicolo/listAll")
                .queryParam("cat", "auto")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);

         Response<?> auto = rest.getForEntity(uri, Response.class).getBody();

         mav.addObject("auto", auto);
         mav.addObject("funzione", "list");
        
         return mav;
    }

    @GetMapping("/createAuto")
    public ModelAndView createAuto() {
        ModelAndView mav = new ModelAndView("create-auto");

        AutoReq req = new AutoReq();
        req.setErrorMsg(null);
        mav.addObject("auto", req);
        mav.addObject("funzione", "create");
        return mav;
    }
    
    @GetMapping("/updateAuto")
   	public ModelAndView updateAuto(@RequestParam Integer veicoloID) {
   	        ModelAndView mav = new ModelAndView("create-auto");
   	        
   	        URI uri = UriComponentsBuilder
   					.fromHttpUrl(backend + "auto/getByIdAuto")
   					.queryParam("id", veicoloID)
   					.buildAndExpand().toUri();
   	        
   			@SuppressWarnings("unchecked")
   			ResponseObject<AutoViewDTO> resp = rest.getForEntity(uri, ResponseObject.class).getBody();
   			
   			AutoReq req = new AutoReq();
   			req.setErrorMsg(null);
   			AutoViewDTO dto = (AutoViewDTO) convertInObject(resp.getDato(), AutoViewDTO.class); 
   			req.setIdVeicolo(veicoloID);
   			req.setNumeroRuote(dto.getNumeroRuote());
   			log.debug("veicoloDTO: " + dto.getNumeroRuote());
   			log.debug("veicoloReq: " + req.getNumeroRuote());
   			req.setNumeroPosti(dto.getNumeroPosti());
   			req.setAlimentazione(dto.getAlimentazione());
   			req.setColore(dto.getColore());
   			req.setMarca(dto.getMarca());
   			req.setTipoVeicolo(dto.getTipo());
   			log.debug("veicoloDTO: " + dto.getTipo());
   			log.debug("veicoloReq: " + req.getTipoVeicolo());
   			req.setCilindrata(dto.getCilindrata());
   			req.setKilowatt(dto.getKilowatt());
   			req.setNumeroPorte(dto.getNumeroPorte());
   			req.setTarga(dto.getTarga());
   			mav.addObject("auto", req);
   			mav.addObject("funzione", "update");
   			
   		    return mav; 

   	}

    @PostMapping("/saveAuto")
    public Object saveAuto(@ModelAttribute("auto") AutoReq req) {
    	
    	log.debug("id: " + req.getIdVeicolo());
		
    	if (req.getIdVeicolo() == null)  {
		URI uri = UriComponentsBuilder
				.fromHttpUrl(backend + "auto/create")
				.buildAndExpand().toUri();
		
		//la differenza che ho con la funzione precedente è che siamo in POST
		ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();
		log.debug("rc: " + resp.getRc());
		
		if (!resp.getRc()) {
			ModelAndView mav = new ModelAndView("create-auto");
			req.setErrorMsg("Errore: " + resp.getMsg());
			mav.addObject("attivita", req);
			mav.addObject("funzione","create");
			log.debug("RC " + resp.getMsg());
			return mav;
		}
		return "redirect:/listAuto";
    	}
        
    	
    	URI	uri = UriComponentsBuilder
                .fromHttpUrl(backend + "auto/updateAuto")
                .buildAndExpand().toUri();
        log.debug("\nURI: " + uri);
        
        ResponseBase resp = rest.postForEntity(uri, req, ResponseBase.class).getBody();

        if (!resp.getRc()) {
            ModelAndView mav = new ModelAndView("create-auto");
            req.setErrorMsg(resp.getMsg());
            log.debug("RC " + resp.getMsg());
            mav.addObject("auto", req);
            mav.addObject("funzione","update");
            return mav;
        }
    	
        return "redirect:/listAuto";

   }
}