package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Jugements;

public interface JugementRepository extends JpaRepository<Jugements, Long> {

	 @Query("SELECT b FROM Jugements b WHERE b.numero = ?1")
	 Optional<Jugements> findByNumero(String num);
	
	//Optional<Jugements> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
