package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.UsersAngularDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.UsersAngular;
import com.betacom.jpa.repository.IUsersAngularRepository;
import com.betacom.jpa.request.UsersAngularReq;
import com.betacom.jpa.service.interfaces.IUsersAngularService;
import com.betacom.jpa.util.Roles;

@Service
public class UsersAngularServiceImpl  implements IUsersAngularService{
	
	@Autowired
	IUsersAngularRepository userR;
	
	@Override
	public void create(UsersAngularReq req) throws AcademyException {
		Optional<UsersAngular> u = userR.findByUserName(req.getUserName());
		if (!u.isEmpty())
			throw new AcademyException("User esiste già");
		UsersAngular us = new UsersAngular();
		us.setUserName(req.getUserName());
		us.setPwd(req.getUserName());
		
		try {
			us.setRole(Roles.valueOf(req.getRole()));
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
		
		userR.save(us);
		
	}

	@Override
	public UsersAngularDTO singin(String user, String pwd) throws AcademyException {
		Optional<UsersAngular> u = userR.findByUserNameAndPwd(user, pwd);
		if (u.isEmpty())
			throw new AcademyException("Invalid user/pwd");
		return new UsersAngularDTO(
				u.get().getId(),
				u.get().getUserName(),
				u.get().getPwd(),
				u.get().getRole().toString()
				);
	}

}
