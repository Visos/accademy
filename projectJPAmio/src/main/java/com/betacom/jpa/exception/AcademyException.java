package com.betacom.jpa.exception;

public class AcademyException extends Exception {
	
	private String messagge;

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}

	public AcademyException(String messagge) {
		super();
		this.messagge = messagge;
	}

	
	
}
