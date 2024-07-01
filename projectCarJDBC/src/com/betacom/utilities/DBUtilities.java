package com.betacom.utilities;

import java.io.BufferedReader;
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
import java.util.stream.Collectors;

import com.betacom.oggetti.Macchina;

public class DBUtilities {
	
	public Map<Integer, Object> buildParameters(Object[] p){
		
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		int pIdx = 1;
		for(Object o : p) {
			params.put(pIdx++, o);
		}
		
		return params;
	}
	
	
	public List<Macchina> transformResultInMacchina(List<Map<String, Object>> rows){
		return rows.stream()
				.map(row-> new Macchina(
						(Integer) row.get("id"),
						(Integer) row.get("id_tipo_alimentazione"),
						(Integer) row.get("id_code_colore"),
						row.get("id_code_tipo").toString(),
						(Integer) row.get("numero_ruote"),
						(Integer) row.get("numero_posti"),
						(Integer) row.get("id_code_marca"),
						(Integer) row.get("numero_porte"),
						row.get("targa").toString()
						)).collect(Collectors.toList());
		
	}
	
	public Macchina transformResultInMacchina(Map<String, Object> row){
		return new Macchina(
				(Integer) row.get("id"),
				(Integer) row.get("id_tipo_alimentazione"),
				(Integer) row.get("id_code_colore"),
				row.get("id_code_tipo").toString(),
				(Integer) row.get("numero_ruote"),
				(Integer) row.get("numero_posti"),
				(Integer) row.get("id_code_marca"),
				(Integer) row.get("numero_porte"),
				row.get("targa").toString()
				);
	}
	
	public static Map<String, List<String>> readLlne(String path){
		Map<String , List<String>> map = new HashMap<String , List<String>>();
		String[] param = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while(line != null) {
				param = line.split(":");
				if(param.length==2) {
					map.put(param[0].trim(), new ArrayList<String>(Arrays.asList(param[1].trim().split(","))));
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
