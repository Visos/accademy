package com.betacom.sbjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.betacom.sbjdbc.model.Uffici;

import java.util.List;

@Component
public class BusinessComponent {

	@Autowired
	private UfficiDao uDao;
	
	

	public void listUffici() {
		
		List<Uffici> lU = uDao.getUffici();
		lU.forEach(u->System.out.println(u.toString()));
		
		System.out.println("**************select with id: 3 ********************");
		
		
		lU = uDao.getUfficiById(3);
		lU.forEach(u->System.out.println(u.toString()));

		System.out.println("**************insert********************");
		uDao.addUfficio("new room");
		lU = uDao.getUffici();
		lU.forEach(u->System.out.println(u));

		
	}
}
