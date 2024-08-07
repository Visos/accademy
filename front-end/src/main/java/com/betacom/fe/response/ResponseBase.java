package com.betacom.fe.response;

//la classe madre ci dice se la risposta è andata a buon fine o no
//nel caso non sia andata a buon fine, ci mostra l'errore [Creazione o Delete o Update]
public class ResponseBase {
	
	private Boolean rc;
	private String msg;
	
	public Boolean getRc() {
		return rc;
	}
	public ResponseBase() {
		super();
	}
	public void setRc(Boolean rc) {
		this.rc = rc;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
