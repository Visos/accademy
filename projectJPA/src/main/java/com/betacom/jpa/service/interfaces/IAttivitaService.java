package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.dto.AttivitaDTO;

public interface IAttivitaService {
	void create (AttivitaDTO att);
	void remove(String attivita);

}
