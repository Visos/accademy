package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Utente;
import com.betacom.jpa.repository.IUtenteRepository;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.service.interfaces.IMessaggioService;
import com.betacom.jpa.service.interfaces.IUtenteService;
import com.betacom.jpa.util.Roles;

@Service
public class UtenteServiceImpl implements IUtenteService {

    @Autowired
    IUtenteRepository utenteRep;

    @Autowired
    IMessaggioService msgS;
    @Override
    public void createUtente(UtenteReq req) throws AcademyException{
        Optional<Utente> utente = utenteRep.findByUsername(req.getUsername().trim());

        if (utente.isPresent()) {
            throw new AcademyException(msgS.getMessaggio("user-exist"));
        }
            
        Utente u = new Utente();
        u.setUsername(req.getUsername());
        u.setPassword(req.getPassword());
        u.setRole(Roles.valueOf(req.getRole()));

        utenteRep.save(u);
    }
    @Override
    public List<UtenteDTO> getAll() {

        List<Utente> utenti = utenteRep.findAll();
        return utenti.stream()
                .map(u -> new UtenteDTO(
                    u.getId(), 
                    u.getUsername(), 
                    u.getPassword(), 
                    u.getRole().name()))
                .collect(Collectors.toList());
    }

}
