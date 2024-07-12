package com.betacom.sbjdbc.model;

public class Uffici {
	private Integer idUfficio;
	private String nomeUfficio;
	
	
	
	public Uffici() {
		super();
	}

	
	
	@Override
	public String toString() {
		return "Uffici [idUfficio=" + idUfficio + ", nomeUfficio=" + nomeUfficio + "]";
	}



	public Uffici(Integer idUfficio, String nomeUfficio) {
		super();
		this.idUfficio = idUfficio;
		this.nomeUfficio = nomeUfficio;
	}
	public Integer getIdUfficio() {
		return idUfficio;
	}
	public void setIdUfficio(Integer idUfficio) {
		this.idUfficio = idUfficio;
	}
	public String getNomeUfficio() {
		return nomeUfficio;
	}
	public void setNomeUfficio(String nomeUfficio) {
		this.nomeUfficio = nomeUfficio;
	}
	
	
}
