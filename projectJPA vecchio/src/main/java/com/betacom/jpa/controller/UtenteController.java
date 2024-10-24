package com.betacom.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.service.interfaces.IUtenteService;


@RestController
@RequestMapping("rest/utente")
public class UtenteController {

    @Autowired
    private IUtenteService service;

    @PostMapping("/create")
    public ResponseBase createUtente(@RequestBody (required = true) UtenteReq req) {

        ResponseBase res = new ResponseBase();
        res.setRc(true);
        try {
            service.createUtente(req);
        } catch (Exception e) {
            res.setRc(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @GetMapping("/list")
    // public List<HashMap<String, Object>> list() {
        
    //     List<UtenteDTO> u = service.getAll();
    //     List<HashMap<String, Object>> resp = new ArrayList<HashMap<String, Object>>();

    //     for(UtenteDTO dto : u){
    //         HashMap<String, Object> mappa = new HashMap<String, Object>();
    //         mappa.put("id", dto.getId());
    //         mappa.put("username", dto.getUsername());
    //         mappa.put("password", dto.getPassword());
    //         mappa.put("role", dto.getRole());
    //         resp.add(mappa);
    //     }
    //     return resp;
        
    // }
    public List<UtenteDTO> list() {
        return service.getAll();
    }

}
