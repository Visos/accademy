package com.betacom;
import java.util.ArrayList;
import java.util.List;

import com.betacom.objects.Cliente;
import com.betacom.objects.compare.CompareByAge;


public class MainCollection {
	public static void main(String[] args) {
		
		List<Cliente> lCliente = new ArrayList<Cliente>();
		
		lCliente.add(new Cliente("Luca", "Rossi", 25));
		lCliente.add(new Cliente("Marco", "Bianchi", 37));
		lCliente.add(new Cliente("Giulia", "Verdi", 19));
		lCliente.add(new Cliente("Anna", "Neri", 42));
		lCliente.add(new Cliente("Sara", "Gialli", 55));
		lCliente.add(new Cliente("Paolo", "Blu", 68));
		lCliente.add(new Cliente("Laura", "Marroni", 23));
		lCliente.add(new Cliente("Francesco", "Grigi", 31));
		lCliente.add(new Cliente("Chiara", "Arancio", 47));
		lCliente.add(new Cliente("Davide", "Viola", 60));
		lCliente.add(new Cliente("Gino", "Postino", 90));
		
		//sort lista in base all'età
		
		lCliente.sort(new CompareByAge());
		
		for(Cliente a : lCliente) {
			System.out.println(a.toString());
		}


	}

}
