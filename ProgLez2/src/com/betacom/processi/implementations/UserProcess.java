package com.betacom.processi.implementations;

import com.betacom.objects.Car;
import com.betacom.objects.Impiegati;
import com.betacom.processi.interfaces.MyInterface;
import com.betacom.processi.interfaces.MyInterfaces2;

public class UserProcess  extends Car implements MyInterface, MyInterfaces2{

	@Override
	public void insertNewSalary(Impiegati user) {
		if (user.getCognome().equalsIgnoreCase("smal"))
			user.setSalary(10000L);
		else
			user.setSalary(1500L);
		
	}

	@Override
	public Long displaySalary(Impiegati user) {
		return user.getSalary();
		
	}

	@Override
	public void freni() {
		System.out.println("freni");
		
	}

	@Override
	public void speed() {
		System.out.println("speed");
		
	}


}
