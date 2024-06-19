package projectMap;

import java.util.Date;
import java.util.GregorianCalendar;


public class Client {
	
	String nome;
	String cognome;
	Integer anni;
	
	
	




	public Client(String nome, String cognome,int anni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		

	
	}
	
	public Integer getAnni() {
		return anni;
	}

	public void setAnni(Integer anni) {
		this.anni = anni;
	}

	@Override
	public String toString() {
		return "Client [nome=" + nome + ", cognome=" + cognome + ", anni=" + anni + "]";
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
}
