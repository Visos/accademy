package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.jpa.repository.IMessaggeInternationalRepository;
import com.betacom.jpa.repository.IMessaggioRepository;
import com.betacom.jpa.service.interfaces.IMessaggeService;
import com.betacom.jpa.pojo.Messagge;
import com.betacom.jpa.pojo.MessaggeID;
import com.betacom.jpa.pojo.MessaggeInternational;

@Service
public class MessageServiceImpl implements IMessaggeService{
	
	@Autowired
	IMessaggioRepository msgR;
	
	@Autowired
	IMessaggeInternationalRepository msgIntR;
	
	@Value("${lang}")	//valore da prendere dal file di properties
	String lang;
	
	@Override
	public String getMessaggio(String code) {
		Optional<Messagge> msg = msgR.findById(code);
		String res = null;
		if(msg.isEmpty())
			res = code;
		else
			res = msg.get().getMessaggio();
		return res;
	}

	@Override
	public String getMessaggioInternational(String code) {
		Optional<MessaggeInternational> msg = msgIntR.findById(new MessaggeID(lang, code));
		String res = null;
		if(msg.isEmpty())
			res = code;
		else
			res = msg.get().getMessaggio();
		return res;
	}
	

}
