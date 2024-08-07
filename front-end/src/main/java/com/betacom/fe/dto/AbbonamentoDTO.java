package com.betacom.fe.dto;

public class AbbonamentoDTO {

	private Integer id;
	private String dataIscrizione;
	private Integer socioId;
	private String socioNome;
	private String socioCognome;


	public AbbonamentoDTO(Integer id, String dataIscrizione, Integer socioId, String socioNome, String socioCognome) {
		super();
		this.id = id;
		this.dataIscrizione = dataIscrizione;
		this.socioId = socioId;
		this.socioNome = socioNome;
		this.socioCognome = socioCognome;
	}



	public String getSocioNome() {
		return socioNome;
	}



	public void setSocioNome(String socioNome) {
		this.socioNome = socioNome;
	}



	public String getSocioCognome() {
		return socioCognome;
	}



	public void setSocioCognome(String socioCognome) {
		this.socioCognome = socioCognome;
	}



	public AbbonamentoDTO() {}


	
	public final Integer getSocioId() {
		return socioId;
	}

	public final void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}

	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getDataIscrizione() {
		return dataIscrizione;
	}
	public final void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	
}
