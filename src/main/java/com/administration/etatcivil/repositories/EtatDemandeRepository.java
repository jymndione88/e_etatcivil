package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.EtatDemandes;

public interface EtatDemandeRepository extends JpaRepository<EtatDemandes, Long> {

	//Optional<EtatDemandes> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	 //@Query("SELECT b FROM Bien b WHERE b.bien.id = ?1")
	 //List<Arrondissements> findByTypeBien(Integer type_bien_id);
}
