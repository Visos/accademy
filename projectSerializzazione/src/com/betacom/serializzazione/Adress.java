package com.betacom.serializzazione;

import java.io.Serializable;

public class Adress implements Serializable{
	
	private static final long serialVersionUID = 2L;	//campo obligatorio per Serializable. serve per fare un controllo incorciato con la versione del server
	private String street;
	private String city;
	private String name;
	private String caso;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Adress [street=" + street + ", city=" + city + "]";
	}
	
	
	
	

}
