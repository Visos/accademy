package com.betacom.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.dto.UsersAngularDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.PersoneReq;
import com.betacom.jpa.request.UsersAngularReq;
import com.betacom.jpa.response.ResponseBase;
import com.betacom.jpa.response.ResponseObject;
import com.betacom.jpa.response.Response;

import com.betacom.jpa.service.interfaces.IPersoneService;
import com.betacom.jpa.service.interfaces.IUsersAngularService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/rest/users")
public class UserAngularController {
	@Autowired
	IUsersAngularService userS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) UsersAngularReq req) {
		ResponseBase res = new ResponseBase();
		res.setRc(true);
		try {
			userS.create(req);
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}



	@GetMapping("/signin")
	public ResponseObject<UsersAngularDTO> signin(String username, String pwd) {
		ResponseObject<UsersAngularDTO> res = new ResponseObject<UsersAngularDTO>();
		res.setRc(true);
		try {
			
			 res.setDati(userS.singin(username, pwd));
		} catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		return res;
	}

}
