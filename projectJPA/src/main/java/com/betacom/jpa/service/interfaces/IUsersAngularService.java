package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.dto.UsersAngularDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.UsersAngularReq;

public interface IUsersAngularService {
	
	void create(UsersAngularReq req) throws AcademyException;

	UsersAngularDTO singin(String user, String pwd) throws AcademyException;
}
