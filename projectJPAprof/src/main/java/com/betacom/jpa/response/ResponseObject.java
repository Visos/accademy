package com.betacom.jpa.response;

public class ResponseObject<T> {
	
	private T dati;
	
	private boolean rc;
	
	

	public boolean isRc() {
		return rc;
	}

	public void setRc(boolean rc) {
		this.rc = rc;
	}

	public T getDati() {
		return dati;
	}

	public void setDati(T dati) {
		this.dati = dati;
	}
	
	
	

}
