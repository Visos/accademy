package com.betcacom.car.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reader {
	String path = "file.txt";
	File f  = new File(path);
	
	
	
	public Map<String, List<String>> getMapFile(String path) {
		
		Map<String , List<String>> map = new HashMap<String , List<String>>();
		List<String> value = new ArrayList<String>();
		String key = null;
		
		
		FileReader fileIn;
		int next = 0;
		StringBuilder sb = new StringBuilder();

		try {
			fileIn = new FileReader(path);
			
			
			//get key dalla stringa 
			
			do {
				next = fileIn.read();
				if(next !=-1) {
					char nextc = (char) next;
					if(nextc == '=') {
						key = sb.toString();
						sb = new StringBuilder();
					}else 
						if(nextc == ',') {
							value.add(sb.toString());
							sb = new StringBuilder();
					} else 
						if(nextc == ';') {
							value.add(sb.toString());
							map.put(key, value);
							value = new ArrayList<String>();
							sb = new StringBuilder();
					}
					if(nextc != ';' && nextc != ',' && nextc != '\n' && nextc != '=') {
						sb.append(nextc);
					}
				}

			}while(next != - 1);
			
		} catch (IOException e) {
			System.out.println("errore read file: " + e.getMessage());
			e.printStackTrace();
		}

		
		
		return map;
	}
	
	
	
	public Map<String,List<String>> getMapFile2(String path) {
		Map<String, List<String>> map = new HashMap<String , List<String>>();
		List<String> value = new ArrayList<String>();
		String key = null;
		String[] param = null;

		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while(line != null) {
				param = line.split("=");
				if(param.length==2) {
					map.put(param[0].trim(), Arrays.asList(param[1].trim().split(",")));
				}
				else
					System.out.println("ERRORE PARAMETRO INVALIDO");
				line = reader.readLine();
			}

		}catch(IOException e){			
			e.printStackTrace();
		}
		
		
		return map;
		
	}
	
	public static Map<String, Set<String>> readLlne(String path){
		Map<String , Set<String>> map = new HashMap<String , Set<String>>();
		String[] param = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while(line != null) {
				param = line.split("=");
				if(param.length==2) {
					map.put(param[0].trim(), new HashSet<String>(Arrays.asList(param[1].trim().split(","))));
				}
				else
					System.out.println("ERRORE PARAMETRO INVALIDO");
				line = reader.readLine();
			}

		}catch(IOException e){			
			e.printStackTrace();
		}
		
		
		
		return map;
	}
	

}
