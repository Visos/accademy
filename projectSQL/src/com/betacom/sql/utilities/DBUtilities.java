package com.betacom.sql.utilities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.sql.dao.Dipendenti;

public class DBUtilities {
	
	public Map<Integer, Object> buildParameters(Object[] p){
		
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		int pIdx = 1;
		for(Object o : p) {
			params.put(pIdx++, o);
		}
		
		return params;
	}
	
	
	public List<Dipendenti> transformResultInDTO(List<Map<String, Object>> rows){
		return rows.stream()
				.map(row-> new Dipendenti(
						(Integer) row.get("id_user"),
						row.get("nome").toString(),
						row.get("cognome").toString(),
						(Date) row.get("data_assunzione"),
						row.get("telefono").toString(),
						row.get("mansione").toString(),
						(BigDecimal) row.get("stipendio"),
						(Integer) row.get("id_ufficio")
						)).collect(Collectors.toList());
		
	}
	
	public Dipendenti transformResultInDTO(Map<String, Object> map){
		return new Dipendenti(
						(Integer) map.get("id_user"),
						map.get("nome").toString(),
						map.get("cognome").toString(),
						(Date) map.get("data_assunzione"),
						map.get("telefono").toString(),
						map.get("mansione").toString(),
						(BigDecimal) map.get("stipendio"),
						(Integer) map.get("id_ufficio"));
		
	}
	

}
