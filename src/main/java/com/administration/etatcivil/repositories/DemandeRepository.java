package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Demandes;
import	java.lang.String;

public interface DemandeRepository extends JpaRepository<Demandes, Long> {
	
	//Optional<Demandes> findByNumero(String numero);
	
	@Query("SELECT b FROM Demandes b WHERE b.idNaissance != NULL")
	List<Demandes> findByNaissance();
	
	@Query("SELECT b FROM Demandes b WHERE b.idMariage != NULL")
	List<Demandes> findByMariage();
	
	@Query("SELECT b FROM Demandes b WHERE b.idDeces != NULL")
	List<Demandes> findByDeces();
	
	@Query("SELECT COUNT(b) FROM Demandes b WHERE b.idNaissance != NULL")
	Integer nbfindByNaissance();
	
	@Query("SELECT COUNT(b) FROM Demandes b WHERE b.idMariage != NULL")
	Integer nbfindByMariage();
	
	@Query("SELECT COUNT(b) FROM Demandes b WHERE b.idDeces != NULL")
	Integer nbfindByDeces();
	
}
