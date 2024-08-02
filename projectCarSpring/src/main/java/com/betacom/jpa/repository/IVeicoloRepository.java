package com.betacom.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.pojo.Veicolo;

public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer>{
	
	

@Query(	"select v from Veicolo v "
		+ "WHERE (:id IS NOT NULL AND v.id = :id)"
		+ "or (:id IS NULL)"
		+ "AND (:tipoV IS NULL OR v.tipoVeicolo.descrizione like :tipoV%)"
		+ "AND (:alim IS NULL OR v.tipoAlimentazione.descrizione like :alim%)"
		+ "AND (:colore IS NULL OR v.colore.descrizione like :colore%)"
		+ "AND (:marca IS NULL OR v.marca.descrizione like :marca%)"
		+ "AND (:ruote IS NULL OR v.numeroRuote = :ruote)"
		+ "AND (:posti IS NULL OR v.nPosti = :posti)")

	List<Veicolo> search ( @Param("id") Integer id,
			@Param("tipoV") String tipoVeicolo,
			@Param("alim") String tipoAlim,
			@Param("colore") String colore,
			@Param("ruote") Integer ruote,
			@Param("posti") Integer posti
			);
}
