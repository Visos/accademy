package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.pojo.Messagge;
import com.betacom.jpa.repository.IMessaggioRepository;
import com.betacom.jpa.service.intefaces.IMessaggeService;


@Service
public class MessageServiceImpl implements IMessaggeService{
	
	@Autowired
	IMessaggioRepository msgR;
	
	
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


	

}
