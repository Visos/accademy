package com.betacom.jpa.dto;


public class AttivitaDTO {
		

		private Integer id;
		private String descrizione;

//		private List<Abbonamento> abbonamento;
		

		public Integer getId() {
			return id;
		}

		public AttivitaDTO(String descrizione) {
		super();
		this.descrizione = descrizione;
		}
		
		public AttivitaDTO() {
		super();
		}


		public void setId(Integer id) {
			this.id = id;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		
		
		


}
