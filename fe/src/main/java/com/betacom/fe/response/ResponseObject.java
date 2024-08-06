package com.betacom.fe.response;

public class ResponseObject<T> extends ResponseBase{
	
	public T dato;

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

}
