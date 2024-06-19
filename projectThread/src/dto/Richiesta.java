package dto;

import java.util.Date;

public class Richiesta {
	private String tipo; //add remove update
	private String giorno; //Lun Mar Mer Gio Ven Sab Dom
	private Integer ora;
	private int idIstruttore;
	private int attività; //yoga, pilates, pesi, pugilato, fitness, step
	
	public Richiesta(String tipo, String giorno, Integer ora, int idIstruttore, int attività) {
		super();
		this.tipo = tipo;
		this.giorno = giorno;
		this.ora = ora;
		this.idIstruttore = idIstruttore;
		this.attività = attività;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public Integer getOra() {
		return ora;
	}
	public void setOra(Integer ora) {
		this.ora = ora;
	}
	public int getIdIstruttore() {
		return idIstruttore;
	}
	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}
	public int getAttività() {
		return attività;
	}
	public void setAttività(int attività) {
		this.attività = attività;
	}

	@Override
	public String toString() {
		return "richiesta [tipo=" + tipo + ", giorno=" + giorno + ", ora=" + ora + ", idIstruttore=" + idIstruttore
				+ ", attività=" + attività + "]";
	}
	
}
