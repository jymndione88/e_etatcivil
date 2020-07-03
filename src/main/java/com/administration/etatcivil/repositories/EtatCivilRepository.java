package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.EtatCivils;

public interface EtatCivilRepository extends JpaRepository<EtatCivils, Long> {

	 @Query("SELECT b FROM EtatCivils b WHERE b.code = ?1")
	 Optional<EtatCivils> findByCode(String code);
	
	//Optional<EtatCivils> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
