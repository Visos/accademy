package com.betacom.jpa.request;

public class RequestBiciAmmortizzatori {
	private Integer biciId;
	private String[] ammortizzatori;
	
	
	
	
	
	public RequestBiciAmmortizzatori(Integer biciId, String[] ammortizzatori) {
		super();
		this.biciId = biciId;
		this.ammortizzatori = ammortizzatori;
	}
	public Integer getBiciId() {
		return biciId;
	}
	public void setBiciId(Integer biciId) {
		this.biciId = biciId;
	}
	public String[] getAmmortizzatori() {
		return ammortizzatori;
	}
	public void setAmmortizzatori(String[] ammortizzatori) {
		this.ammortizzatori = ammortizzatori;
	}
	
	

}
