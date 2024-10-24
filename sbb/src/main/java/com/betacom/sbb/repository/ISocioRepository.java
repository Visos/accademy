package com.betacom.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.sbb.pojo.Socio;

@Repository
public interface ISocioRepository extends JpaRepository<Socio, Integer>{
	// List<Socio> findByCognome(String cognome);
	
	// List<Socio> findByCognomeIn(List<String> cognomi);

	// @Query(name="socio.cognomeByLike")
	// List<Socio> findByCognomeLike(@Param("pattern") String pattern);
	
	// @Query(name="socio.selectByAttivita")
	// List<Socio> findSocioByAttivita(@Param("attivita") String attivita);
	
	// @Query(name="socio.selectByFilter")
	// List<Socio> selectByFilter(
	// 		@Param("id") Integer id,
	// 		@Param("nome") String nome,
	// 		@Param("cognome") String cognome);

	
}
