package com.betacom.thread;

public class Moto extends Thread{
	private String marca ;
	private String modello;
	private String targa;
	private Integer cilindrata;
	
	
	public Moto(String marca, String modello, String targa, Integer cilindrata) {
		super();
	this.marca = marca;
	this.modello = modello;
	this.targa = targa;
	this.cilindrata = cilindrata;
	}
	
	
	public String getMessagge() {
		return "" + this + "Tipo: Moto" + this.marca + "modello: " + this.modello +" cilindrata: " + this.cilindrata + " targa: " + this.targa;
	}
	
	@Override
	public void run() {
		
		System.out.println("il thread " + this + " ha inizziato l'esecuzione");
		System.out.println(this.getMessagge());
		
		
		
		
		System.out.println("il thread " + this + " ha finito l'esecuzione");
	}
	
	
	

}
