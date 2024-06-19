package service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import dto.Pianificazione;
import dto.Richiesta;
import model.Attività;
import model.Istruttore;
import utilities.Utilities;

public class PianificazioneService {
	public Pianificazione pianificazioneManager(Richiesta richiesta, List<Istruttore> ist, List<Attività> att, Pianificazione p) {
		String pakageName = "service.Pianificazione" + richiesta.getTipo();
		
		//System.out.println("class to execute: " + pakageName);
		
		try {
			Class cl = Class.forName(pakageName);
			Constructor[] ctors = cl.getConstructors();
			Constructor ctorSelected = null;
			
			for (Constructor ctor:ctors) {
				if (ctor.getGenericParameterTypes().length == 0) {
					ctorSelected = ctor;
					break;
				}
			}
			
			Object myClass = ctorSelected.newInstance();
			//System.out.println("After new instance");
			String methodName = "pianificazioneExecute";
			Method executeMethod = myClass.getClass().getMethod(methodName, Richiesta.class, List.class, List.class, Pianificazione.class);
			return (Pianificazione)executeMethod.invoke(myClass, richiesta, ist, att, p);
			
		} catch (ClassNotFoundException e) {
			System.out.println("tipo " + richiesta + " invalido");
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("Error in new Instance " + e.getMessage());
				e.printStackTrace();
				
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("tipo " + richiesta + " invalido");
			e.printStackTrace();
		}
		return p;
	}
}
