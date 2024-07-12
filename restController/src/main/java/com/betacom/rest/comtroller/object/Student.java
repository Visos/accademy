package com.betacom.rest.comtroller.object;

public class Student {
	private String nome;
	private String congnome;
	public Student(String nome, String congnome) {
		super();
		this.nome = nome;
		this.congnome = congnome;
	}
	public Student() {
	super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCongnome() {
		return congnome;
	}
	public void setCongnome(String congnome) {
		this.congnome = congnome;
	}
	
	
}
