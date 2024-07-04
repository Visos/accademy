package com.betacom.jpa.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificato")
public class Certificato {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column
	private boolean tipo;
	
	@Column(length = 10,
			name = "data_certificato")
	private String dataCertificato;

	
	@OneToOne
	@JoinColumn(
			name = "socio_id",
			referencedColumnName = "id"
			)
	private Socio socio;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public String getDataCertificato() {
		return dataCertificato;
	}

	public void setDataCertificato(String dataCertificato) {
		this.dataCertificato = dataCertificato;
	}
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
	
	

}
