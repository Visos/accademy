package projectDate;

import java.util.Date;
import java.util.GregorianCalendar;


public class Client {
	
	String nome;
	String cognome;
	private Date dataNascita;
	
	
	
	
	public Client(String nome, String cognome, int giorno, int mese, int anno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		GregorianCalendar c = new GregorianCalendar(anno, mese, giorno);
		this.dataNascita = c.getTime(); 
		

	
	}
	
	
	public String toString1() {
		return "Client [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + "]";
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

}
