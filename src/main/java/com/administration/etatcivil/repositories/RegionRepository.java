package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Regions;

public interface RegionRepository extends JpaRepository<Regions, Long> {

	 @Query("SELECT b FROM Regions b WHERE b.code = ?1")
	 Optional<Regions> findByCode(String code);
	
	//Optional<Regions> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
