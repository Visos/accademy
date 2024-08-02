package com.betacom.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.dto.MacchinaViewDto;
import com.betacom.jpa.pojo.Macchina;


public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{

	@Query("select m from Macchina m "
			+ "	where m.veicolo.nPosti = :nPosti")
	public List<Macchina> findByNposti(@Param("nPosti") Integer posti);

}
