package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Demandes;
import	java.lang.String;

public interface DemandeRepository extends JpaRepository<Demandes, Long> {
	
	//Optional<Demandes> findByNumero(String numero);
	
	@Query("SELECT b FROM Demandes b WHERE b.id_naissance not null")
	List<Demandes> findByNaissance();
	
	@Query("SELECT b FROM Demandes b WHERE b.id_mariage not null")
	List<Demandes> findByMariage();
	
	@Query("SELECT b FROM Demandes b WHERE b.id_deces not null")
	List<Demandes> findByDeces();
	
}
