package com.betcom.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.betcom.json.object.Data;
import com.betcom.json.object.Persona;
import com.betcom.json.object.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainJson {
	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\utenti.json";		

		
		Persona p = new Persona("gino", "postino", new Data(1,10,1999));
		Gson gson = new Gson();
		String jsonString = gson.toJson(p);
		//System.out.println(jsonString);
		
		Persona newPersona = gson.fromJson(jsonString, Persona.class);
		//System.out.println("new persona: " + newPersona);
		
		List<Persona> ll = new ArrayList<Persona>();
		
		ll.add(new Persona("Maria", "defilippis", new Data(21,10,940)));
		ll.add(new Persona("Mario", "rossi", new Data(12,12,1940)));
		ll.add(new Persona("Antonio", "filippis", new Data(3,2,1980)));
		ll.add(new Persona("Franco", "bianchi", new Data(22,8,1960)));
		ll.add(new Persona("Asdruale", "verdi", new Data(31,4,2004)));
		
		String jsonList = gson.toJson(ll);
		//System.out.println(jsonList);
		
		List<Persona> nw = new ArrayList<Persona>();
		nw = gson.fromJson(jsonList, List.class);
		
		
		
		//-----------------------------------------------
		
		List<Users> l = new ArrayList<Users>();		
		l.add(new Users("antonio","verdi",new Date() , false));
		l.add(new Users("gina","rossi",new Date() , false));
		l.add(new Users("gino","postino",new Date() , true));
		
		
		
		//metodo 1
		String sj = writeFile(filePath, l);
		String converted = gson.toJson(sj);
		System.out.println("************************");
		System.out.println(converted);
		
		
		//problema del sesso a boolean
		//writeFile1(filePath, l);
		
		
		

	}
	
	public static String writeFile(String filePath, List<Users> records) {
		
		File f = new File(filePath);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String res = "";
		
		//controlla se un file esiste
		if(f.exists()) {
			System.out.println("file daje");
		}else {
			System.out.println("file non daje");
		}
		
		FileWriter o = null;
		
		try {
			o = new FileWriter(f);
			for(Users s : records) {
				res += "{ cognome : " + s.getCognome()+", Nome : "+s.getNome()+", DataNascita : "+sdf.format(s.getDataNascita())+ " ,sesso : " + (s.getSesso()==true?"femmina":"maschio") + "}";
				o.write(res);
			}
		} catch (IOException e) {
			System.out.println("errore creazione file: " + e.getMessage());
			e.printStackTrace();
		}finally{
			if(o != null) {
				try {
					o.flush();
					o.close();
					System.out.println();
				}catch(IOException e){
					System.out.println("errore chiusura file: " + e.getMessage());
				}
			}
		}
		
		return res;
		
	}
	
	public static void writeFile1(String filePath, List<Users> records) {
		
		File f = new File(filePath);
		Gson gb = new GsonBuilder().setDateFormat("dd/MM/yyyy").setPrettyPrinting().create();
		String list = gb.toJson(records , List.class);
		
		
		//controlla se un file esiste
		if(f.exists()) {
			System.out.println("file daje");
		}else {
			System.out.println("file non daje");
		}
		
		FileWriter o = null;
		
		try {
			o = new FileWriter(f);
			o.write(list);
		} catch (IOException e) {
			System.out.println("errore creazione file: " + e.getMessage());
			e.printStackTrace();
		}finally{
			if(o != null) {
				try {
					o.flush();
					o.close();
					System.out.println();
				}catch(IOException e){
					System.out.println("errore chiusura file: " + e.getMessage());
				}
			}
		}

	}

}
