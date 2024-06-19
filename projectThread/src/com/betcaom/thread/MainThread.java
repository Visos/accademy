package com.betcaom.thread;

import com.betcaom.thread.attivita.MainAttivita;

public class MainThread {

	public static void main(String[] args) {
		
		Thread attivita = new Thread(new MainAttivita());
		
		attivita.start();
	}

}
