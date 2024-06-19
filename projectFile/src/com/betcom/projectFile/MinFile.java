package com.betcom.projectFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinFile {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\file.txt";
		
		List<String> records = new ArrayList<String>();
		records.add("record 1 \n");
		records.add("record 2 \n");
		records.add("record 3 \n");
		records.add("record 4 \n");
		records.add("record 5 \n");
		records.add("record 6 \n");
		records.add("record 7 \n");
		records.add("record 8 \n");
		records.add("record 9 \n");
		records.add("ciccino \n");

		
	
		
		String record = "bella bro appendi questo";
		
		writeFile(filePath, records);
		
		appendUsingWriter(filePath, record);
		
		
		System.out.println("\ninizio lettura");
		
		List<String> rr = readFile(filePath);
		
		for(String r :rr) {
			System.out.println(r);
		}
		
	}			
			
			
			
	public static void writeFile(String filePath, List<String> records) {
		
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
			for(String s : records) {
				o.write(s);
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
	
	public static void appendUsingWriter(String path, String record) {
		File file = new File(path);
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(file, true);
			fr.write(record);
		} catch (IOException e) {
			System.out.println("errore append: " + e.getMessage());
			e.printStackTrace();
		} finally{
			if(fr != null) {
				try {
					fr.flush();
					fr.close();
					System.out.println();
				}catch(IOException e){
					System.out.println("errore chiusura file: " + e.getMessage());
				}
			}
		}
	}
	
	private static List<String> readFile(String pathFile) {
		List<String> res = new ArrayList<String>();
		
		FileReader fileIn;
		int next = 0;
		
		StringBuilder sb = new StringBuilder();
		
		try {
			fileIn = new FileReader(pathFile);
			do {
				next = fileIn.read();
				if(next !=-1) {
					char nextc = (char) next;
					if(nextc == '\n') {
						res.add(sb.toString());
						sb = new StringBuilder();
					}
					sb.append(nextc);
				}
			}while(next != - 1);
			
		}catch (IOException e) {
			System.out.println("errore read file: " + e.getMessage());
			e.printStackTrace();
		}
		
		return res;
	}
	
	

}
