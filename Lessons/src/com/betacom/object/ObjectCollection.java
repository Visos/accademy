package com.betacom.object;

public class ObjectCollection {

	public String nome;
    String cognome;
    
    public ObjectCollection()
    {

    }
    
    public ObjectCollection(String nome, String cognome)
    {
    	this.nome = nome;
    	this.cognome = cognome;
    }

    public String toString()
    {
    	return "nome: "+ nome + " cognome: "+ cognome;
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}