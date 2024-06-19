package com.betacom.thread;

public class AutoPiccola extends Automobile implements Runnable{

	public AutoPiccola(String marca, String modello, String targa, Integer cilindrata) {
		super(marca, modello, targa, cilindrata);
	}

	@Override
	public void run() {
		
		System.out.println("il thread " + this + " ha inizziato l'esecuzione");
		System.out.println(this.getMessagge());
		
		
		
		
		System.out.println("il thread " + this + " ha finito l'esecuzione");
	}

	@Override
	public String getType() {
		return "AutoPiccola";
	}

}
