package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Departements;
import com.administration.etatcivil.entities.EtatCivils;

public interface DepartementRepository extends JpaRepository<Departements, Long> {

	 @Query("SELECT b FROM Departements b WHERE b.code = ?1")
	 Optional<Departements> findByCode(String code);
	 
	//Optional<Departements> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
