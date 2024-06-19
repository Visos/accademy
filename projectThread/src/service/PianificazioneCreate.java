package service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import dto.Pianificazione;
import dto.Richiesta;
import model.Attività;
import model.Istruttore;

public class PianificazioneCreate {
	
	public PianificazioneCreate() {
		//System.out.println("eseguito");
	}
	
	public Pianificazione pianificazioneExecute(Richiesta richiesta, List<Istruttore> ist, List<Attività> att, Pianificazione p) {
		//System.out.println("Siamo dentro la creazione della pianificazione: " + richiesta.toString());
		
		try {
			String methodName = "setOra" + richiesta.getGiorno();
			Method executeMethod;
			executeMethod = p.getClass().getMethod(methodName, Integer.class);
			executeMethod.invoke(p, richiesta.getOra());
			
			methodName = "setNomeIstruttore" + richiesta.getGiorno();
			executeMethod = p.getClass().getMethod(methodName, String.class);
			executeMethod.invoke(p, searchIstruttore(richiesta.getIdIstruttore(), ist));
			
			methodName = "setNomeAttività" + richiesta.getGiorno();
			executeMethod = p.getClass().getMethod(methodName, String.class);
			executeMethod.invoke(p, searchAttività(richiesta.getAttività(), att));
			return p;
		} catch (NoSuchMethodException e) {
			System.out.println("Error method: " + e.getMessage());
		} catch (SecurityException e){
			e.printStackTrace();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
			System.out.println("Error arguments: " + e.getMessage());
			e.printStackTrace();
		}
		return p;
	}
	
	//voglio evitarmi i cicli for
	private String searchAttività(int id, List<Attività> att) {
		return att.stream().filter(i -> i.getId() == id).findFirst().map(i -> i.getAttività()).orElse(null);
		//carino.
	}
	
	private String searchIstruttore(int id, List<Istruttore> ist) {
		return ist.stream().filter(i -> i.getId() == id).findFirst().map(i -> i.getNome()).orElse(null);
	}
}
