package com.betacom;

import java.util.ArrayList;
import java.util.List;

import com.betacom.objects.BMW;
import com.betacom.objects.Fiat500;
import com.betacom.objects.Impiegati;
import com.betacom.objects.User;
import com.betacom.processi.implementations.UserProcess;
import com.betacom.processi.interfaces.MyInterface;
import com.betacom.processi.interfaces.MyInterfaces2;

public class MainAbtractInterface {

	public static void main(String[] args) {
		/*
		Fiat500 c = new Fiat500();
		c.setModel("500");
		c.freni();
		c.speed();
		System.out.println("Model :" + c.getModel());

		BMW b = new BMW();
		b.setColor("verde");
		b.freni();
		b.speed();
		//System.out.println("Color :" + b.getColor());
		
		*/
		Impiegati user1 = new Impiegati("Pio", "ass", 10L);
		user1.setTipo(1);
		
		Impiegati user2 = new Impiegati("Gérard","Smal", 10L);
		user2.setTipo(1);	
		
		UserProcess proc = new UserProcess();
		
		proc.insertNewSalary(user1);
		proc.insertNewSalary(user2);
		
		//System.out.println("User " + user1.getNome() + " " + user1.getCognome() + " ha un stipendio di " + proc.displaySalary(user2));
		//System.out.println("User " + user2.getNome() + " " + user2.getCognome() + " ha un stipendio di " + user2.getSalary());
		
		User user3 = new User("u3", "u3");
		
		List<User> u = new ArrayList<User>();
		u.add(user1);
		u.add(user2);
		u.add(user3);
		
		System.out.println("tipo user 3" + user1.getTipo());
		
		System.out.println("Users found:" + u.size());
		
		for ( User person : u ) {
			if ( person instanceof Impiegati) {
				Impiegati bro = (Impiegati)person;	//oppure si può utilizzare il casting
				System.out.println(person.getNome() + person.getCognome() +proc.displaySalary((Impiegati)person));
			}
			else {
				System.out.println(person.getNome() + person.getCognome());
			}
		}
		
	}

}
