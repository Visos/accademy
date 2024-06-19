package service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import dto.Pianificazione;
import dto.Richiesta;
import model.Attività;
import model.Istruttore;

public class PianificazioneRemove {

	public PianificazioneRemove() {
		//System.out.println("PianificazioneRemove eseguito");
	}
	
	public Pianificazione pianificazioneExecute(Richiesta richiesta, List<Istruttore> ist, List<Attività> att, Pianificazione p) {
		//System.out.println("Siamo dentro la creazione della pianificazione: " + richiesta.toString());
		
		try {
			String methodName = "setOra" + richiesta.getGiorno();
			Method executeMethod;
			executeMethod = p.getClass().getMethod(methodName, Integer.class);
			executeMethod.invoke(p, (Integer)null);
			
			methodName = "setNomeIstruttore" + richiesta.getGiorno();
			executeMethod = p.getClass().getMethod(methodName, String.class);
			executeMethod.invoke(p, (String)null);
			
			methodName = "setNomeAttività" + richiesta.getGiorno();
			executeMethod = p.getClass().getMethod(methodName, String.class);
			executeMethod.invoke(p, (String)null);
			
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
}
