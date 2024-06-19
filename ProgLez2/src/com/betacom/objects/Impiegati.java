package com.betacom.objects;

public class Impiegati extends User{
	Long salary;
	
	public Impiegati(String nome, String cognome, Long salary) {
		super.nome = nome;
		super.cognome = cognome;
		this.salary = salary;
	}
	
	@Override
	public void setTipo(Integer tipo) {
		super.setTipo(tipo);
	}
	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
