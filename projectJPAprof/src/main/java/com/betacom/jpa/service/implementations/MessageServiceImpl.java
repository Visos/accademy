package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.repository.IMessaggioRepository;
import com.betacom.jpa.service.interfaces.IMessaggeService;
import com.betacom.jpa.pojo.Messagge;

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
		
		
		
		return null;
	}
	

}
