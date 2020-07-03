package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Declarations;
import com.administration.etatcivil.entities.Mariages;

public interface MariageRepository extends JpaRepository<Mariages, Long> {

	@Query("SELECT b FROM Mariages b WHERE b.numero = ?1")
	Optional<Mariages> findByDeclaration(String num);
	
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	 //@Query("SELECT b FROM Bien b WHERE b.bien.id = ?1")
	 //List<Arrondissements> findByTypeBien(Integer type_bien_id);
}
