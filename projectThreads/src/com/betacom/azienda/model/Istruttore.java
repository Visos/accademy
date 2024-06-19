package model;

import java.util.Date;

public class Istruttore {
	private Integer id;
	private String cognome;
	private String nome;
	private int idAttività; //l'id dell'attivit�.
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdAttività() {
		return idAttività;
	}
	public void setIdAttività(Integer idAttività) {
		this.idAttività = idAttività;
	}

	@Override
	public String toString() {
		return "Istruttore [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", idAttivit�=" + idAttività + "]";
	}
	
}
