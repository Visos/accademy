package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;

public interface ISocioService {
	
	void createUpdateSocio(SocioDTO socio) throws AcademyException;
	List<SocioViewDTO> listAllSocio(Integer id, String nome, String cognome);
	List<SocioDTO> searchCognome(String cognome);
	List<SocioDTO> searchCognomi(List<String> cognomi);
	List<SocioDTO> searchCognomiLike(String pattern);
	List<SocioDTO> searchByAttivia(String attivita);
	SocioViewDTO searchById(Integer Id);

	
	void removeSocio(SocioDTO socio) throws AcademyException;
	List<AbbonamentoViewDTO> loadListViewAbbDto (List<Abbonamento> resp);
	List<AttivitaDTO> transformAttivitaInDTO(List<Attivita> resp);


	
}
