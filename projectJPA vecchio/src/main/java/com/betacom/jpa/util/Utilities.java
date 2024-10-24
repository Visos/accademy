package com.betacom.jpa.util;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;

public class Utilities {
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


}
