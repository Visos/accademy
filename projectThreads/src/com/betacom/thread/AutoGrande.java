package com.betacom.thread;

public class AutoGrande extends Automobile implements Runnable{

	public AutoGrande(String marca, String modello, String targa, Integer cilindrata) {
		super(marca, modello, targa, cilindrata);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "autoGrande";
	}

	@Override
	public void run() {
		
		System.out.println("il thread " + this + " ha inizziato l'esecuzione");
		System.out.println(this.getMessagge());
		
		
		
		
		System.out.println("il thread " + this + " ha finito l'esecuzione");
	}

}
