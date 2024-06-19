package com.betacom.MainCsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class MainCsv {

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\utenti.csv";		
		List<Users> l = new ArrayList<Users>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		Date d1 = new Date();
		
		Users a1 = new Users();
		Users a2 = new Users();
		Users a3 = new Users();

		
		a1.setCognome("rossi");
		a1.setDataNascita("10/04/1996");
		a1.setNome("gino");
		a1.setSesso(false);
		
		a2.setCognome("vianello");
		a2.setDataNascita("08/05/1700");
		a2.setNome("mario");
		a2.setSesso(false);
		
		a3.setCognome("postina");
		a3.setDataNascita("02/02/2002");
		a3.setNome("gina");
		a3.setSesso(true);
		
		
		try {
			d1 = sdf.parse(a1.getDataNascita());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		l.add(a1);
		l.add(a2);
		l.add(a3);
		
		
		for(Users u : l) {
			System.out.println(u.toString1());
		}
		l.sort((Users a , Users b ) -> a.getCognome().charAt(0) - b.getCognome().charAt(0));
		
		System.out.println("-------AFTER SORT-------");
		for(Users u : l) {
			System.out.println(u.toString1());
		}
		
		
		writeFile(filePath, l);
		
		
		
		//creare file csv: formatcsv cognome, nome; mascio o femmina; 
		//
		
		
		
	}
	
	public static void writeFile(String filePath, List<Users> records) {
		
		File f = new File(filePath);
		
		//controlla se un file esiste
		if(f.exists()) {
			System.out.println("file daje");
		}else {
			System.out.println("file non daje");
		}
		
		FileWriter o = null;
		
		int num = 0;
		try {
			o = new FileWriter(f);
			for(Users s : records) {
				o.write(s.getCognome()+";"+s.getNome()+";"+s.getDataNascita()+ ";" + (s.getSesso()==true?"femmina":"maschio") + "\n");
				num++;
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
		
	}

}
