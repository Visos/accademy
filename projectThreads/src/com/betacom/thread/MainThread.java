package com.betacom.thread;

public class MainThread {

	public static void main(String[] args) {
		
		AutoGrande grande = new AutoGrande("jeep", "Tcross", "12345", 2500);
		
		AutoPiccola piccola = new AutoPiccola("Mini", "moltoMini", "5678", 100);
		
		Moto bike = new Moto("Ducati", "super", "abcd", 4000);
		
		Thread t1 = new Thread(grande);
		Thread t2 = new Thread(piccola);
		
		t1.start();
		t2.start();
		bike.start();
		
		
		
		
	}

}
