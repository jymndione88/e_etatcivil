package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Communes;
import com.administration.etatcivil.entities.EtatCivils;

public interface CommuneRepository extends JpaRepository<Communes, Long> {

	 @Query("SELECT b FROM Communes b WHERE b.code = ?1")
	 Optional<Communes> findByCode(String code);
	 
	//Optional<Communes> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
