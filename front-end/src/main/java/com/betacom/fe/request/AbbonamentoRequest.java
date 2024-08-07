package com.betacom.fe.request;
//nella request abbiamo tutti i dati che ci servono alla creazione di un oggetto 


public class AbbonamentoRequest {
	
	private Integer id;
	private String dataIscrizione;
	private Integer socioId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public Integer getSocioId() {
		return socioId;
	}
	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}

}
