package com.betacom.object;

public class Impiegata extends User{
	public Impiegata(String nome, String cognome, Boolean sesso) {
		super(nome, cognome, sesso);
		// TODO Auto-generated constructor stub
	}

	Long salary;

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
