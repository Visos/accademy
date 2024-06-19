package com.betcacom.car.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betcacom.car.oggetti.Macchina;
import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IGestioneSystem;
import com.betcacom.car.utility.Reader;

public class MySingleton implements IGestioneSystem{
	private static MySingleton instance;
	
	private List<Veicolo> listV = new ArrayList<Veicolo>();
	private Integer id = 0;
	
	private static String inputTipoMachina = "fuoristrada,city,sportiva,utilitaria";
	private static String inputTipoMoto = "crosa,corsa,sidecar,scooter";
	private static String inputTipoBici = "mountainbike,pista,tandem,rotelle";

	private static String [] TipoMacchina = null;
	private static String [] TipoMoto = null ;
	private static String [] TipoBici = null ;
	
	//--------
	private final String [] TipoAlimentazioneAuto = {"disel", "benzina", "elettrica", "gas", "ibrido"};
	private final String [] TipoAlimentazioneMoto = {"benzina", "elettrica"};
	private final String [] TipoAlimentazioneBici = {"manuale", "pedass", "elettrica"};
	
	//
	private final String [] MarcaAuto = {"Ferrari", "Audi", "Honda", "Lamborghini"};
	private final String [] MarcaMoto = {"Ducati", "Yamaha", "Honda", "Aprilia"};
	private final String [] MarcaBici = {"Aurora", "Bianchi", "Merida", "Kona"};


	private static Map<String, List<String>> mapV = new HashMap<String, List<String>>();
	private static Map<String, List<String>> mapAlim = new HashMap<String, List<String>>();
	private static Map<String, List<String>> mapMarca = new HashMap<String, List<String>>();

	private final static String pathTipo = "C:\\Users\\Betacom\\Documenti\\Gfile\\listeMacchine.txt";
	private final static String pathAlim = "C:\\Users\\Betacom\\Documenti\\Gfile\\listaAlim.txt";
	private final static String pathMarca = "C:\\Users\\Betacom\\Documenti\\Gfile\\listeMacchine.txt";

	private static Map<String, String[]> mapV1 = new HashMap<String, String[]>();
	
	private static boolean isFree = true;

	
	//Quando utilizziamo un sigleton usare SEMPRE un costruttore privato
	private MySingleton() {
	}
	
	public static MySingleton getInstance() {
		if (instance == null) {
			instance = new MySingleton();
		}
		//splitTipo();
		createMap();
	
		
		return instance;
	}
	
	
	public int getID() {
		id++;
		return id;
	}
	
//	public static void splitTipo() {
//		TipoMacchina = inputTipoMachina.split(",");
//		TipoMoto = inputTipoMoto.split(",");
//		TipoBici = inputTipoBici.split(",");
//		for(String s : TipoMacchina) {
//			System.out.println("dentro il for"+s);
//		}
//	}


	
	public static void createMap () {
//		mapV.put("Macchina", TipoMacchina);
//		mapV.put("Moto", TipoMoto);
//		mapV.put("Bici", TipoBici);
		Reader r = new Reader();
		mapV = r.getMapFile(pathTipo);
		mapAlim = r.getMapFile(pathAlim);
		//mapMarca = r.getMapFile(pathMarca);	//TO DO

		
		//mapV1 =r.readLlne(pathTipo);

	}
	
	
	
	public boolean checkTipoVeicolo(String tipo, String tipoVeicolo) {
		boolean flag = false;				
		for(String s : mapV.get(tipoVeicolo)) {
			if (s.equalsIgnoreCase(tipo)){
				flag = true;
			}
		}
		return flag;
		
	}
	
	
	public boolean checkTipoAlimentazione(String tipo, String tipoAlim) {
		boolean flag = false;
		for(String s : mapAlim.get(tipoAlim)) {
			if (s.equalsIgnoreCase(tipo)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	//---------------AUTO------------
	public boolean checkMarcaAuto(String tipo) {
		boolean flag = false;
		for(String s : MarcaAuto) {
			if (s.equalsIgnoreCase(tipo)) {
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	
	//----------------MOTO 
	public boolean checkMarcaMoto(String tipo) {
		boolean flag = false;
		for(String s : MarcaMoto) {
			if (s.equalsIgnoreCase(tipo)) {
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	
	//--------------------BICI
	
	
	public boolean checkMarcaBici(String tipo) {
		boolean flag = false;
		for(String s : MarcaBici) {
			if (s.equalsIgnoreCase(tipo)) {
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	

	
	public void updateList(	Veicolo ob) {
		if(canIwork()) {
			isFree = false;
			listV.add(ob);
			System.out.println("object " + ob.getTipoVeicolo() +" has been added");
			isFree = true;
		}

		
	}
	
//	public boolean removeItem1(int id) {
//		for( Veicolo item : listV) {
//			if(item.getId().equals(id)){
//				System.out.println("Object " + item.getTipoVeicolo() +" has benn removed");
//				if(item instanceof Macchina) {
//					Macchina.numeroMacchina--;
//					System.out.println("numero macchine aggiornato = " + Macchina.numeroMacchina);
//				}
//				listV.remove(item);
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean removeItem(int id) {
		boolean rc = false;
		if(canIwork()) {
			isFree = false;
			listV.removeIf(it -> it.getId() == id);
			isFree = true;
			rc  = true;
		}
		return rc;
		
	}
	
	
	private boolean canIwork() {
		while(!isFree) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return isFree;

	}

	
	
	
	
	//versoine vecchia
//	public Veicolo getItem1(Integer id) {
//		for( Veicolo v : listV) {
//			if(v.getId() == id) {
//				return v;
//			}
//		}
//		return null;
//	}
	
	//versione figa usando stream
	public Veicolo getItem(Integer id) {
		return listV.stream().filter(it ->
		it.getId() == id).findFirst().orElse(null);
	}
	
	public void displayList() {
		System.out.println("Numero veicolo totale:" + listV.size());
		for( Veicolo v : listV) {
			System.out.println("Id: "+v.getId() + " Tipo: " + v.getTipoVeicolo());
		}
	}

	@Override
	public List<Veicolo> getList() {
		return listV;
	}
}
