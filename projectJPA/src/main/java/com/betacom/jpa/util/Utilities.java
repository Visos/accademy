package com.betacom.jpa.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;

public class Utilities {
	private final static String df = "dd/MM/yyyy";
	
	
	public static List<AbbonamentoViewDTO> loadListViewAbbonamentoDTO(List<Abbonamento> resp){
		
		return resp.stream()
				.map(s -> new AbbonamentoViewDTO(
						s.getId(),
						s.getDataIscrizione(),
						transformAttivitaInDTO(s.getAttivita())
						))
				.collect(Collectors.toList());
	}	
	
	public static List<AttivitaDTO> transformAttivitaInDTO(List<Attivita> resp){
		return resp.stream()
				.map(a -> new AttivitaDTO(
						a.getId(),
						a.getDescrizione()
						)).collect(Collectors.toList());
				
	}

	public static Date convertStringToDate(String dateInString) throws ParseException  {
		SimpleDateFormat formatter = new SimpleDateFormat(df, Locale.ITALY);
		Date date = formatter.parse(dateInString);
		return date;
	}

	public static String convertDateToString(Date data){
		DateFormat formatter;
		formatter = new SimpleDateFormat(df);
		String s =formatter.format(data);	
		return s;
	}
	
}
