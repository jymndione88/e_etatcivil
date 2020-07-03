package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Arrondissements;
import com.administration.etatcivil.entities.EtatCivils;

public interface ArrondissementRepository extends JpaRepository<Arrondissements, Long> {

	 @Query("SELECT b FROM Arrondissements b WHERE b.code = ?1")
	 Optional<Arrondissements> findByCode(String code);
	 
	//Optional<Arrondissements> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
