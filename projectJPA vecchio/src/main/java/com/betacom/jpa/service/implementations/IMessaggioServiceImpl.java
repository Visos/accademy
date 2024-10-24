package com.betacom.jpa.service.implementations;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.jpa.pojo.MessageID;
import com.betacom.jpa.pojo.Messaggi;
import com.betacom.jpa.pojo.MessaggiInternational;
import com.betacom.jpa.repository.IMessaggiInternationalRepository;
import com.betacom.jpa.repository.IMessaggioRepository;
import com.betacom.jpa.service.interfaces.IMessaggioService;

@Service
public class IMessaggioServiceImpl implements IMessaggioService{

	@Autowired
	IMessaggioRepository msgR;
	
	
	@Autowired
	IMessaggiInternationalRepository msgIR;
	
	@Value("${lang}")
	String lang; 
	
	@Override
	public String getMessaggio(String code) {
		Optional<Messaggi> msg = msgR.findById(code);
		String res = null;
		if (msg.isEmpty())
			res = code;
		else
			res = msg.get().getMessaggio();

		return res;
	}

	@Override
	public String getMessaggioInt(String code) {
		Optional<MessaggiInternational> msg = msgIR.findById(new MessageID(lang, code));
		String res = null;
		if (msg.isEmpty())
			res = code;
		else
			res = msg.get().getMessagio();

		return res;
	}




}
