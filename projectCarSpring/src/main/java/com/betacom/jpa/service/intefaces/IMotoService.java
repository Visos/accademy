package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.MotoViewDto;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IMotoService {

	void removeMoto(Integer id) throws AcademyException;

	List<MotoViewDto> listAllMoto();


}
