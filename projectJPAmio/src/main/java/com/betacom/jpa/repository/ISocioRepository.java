package com.betacom.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.pojo.Socio;

@Repository
public interface ISocioRepository  extends JpaRepository<Socio, Integer>{
	List<Socio> findByCognome(String cognome);	//devono iniziare sempre con findby
	List<Socio> findByCognomeIn(List<String> cognomi);
	//socio service fa una lista e la trasfroma
	
	@Query(name = "socio.cognomeByLike")
	List<Socio> findByCognomeLike(@Param("pattern") String pattern);
	
	
	@Query(name = "socio.selectMyAttivita")
	List<Socio> findByAttivita(@Param("attivita") String pattern);	
}
