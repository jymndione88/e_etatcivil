package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Roles;
import com.administration.etatcivil.security.NomsRole;

public interface RoleRepository extends JpaRepository<Roles, Long> {

	@Query("SELECT b FROM Roles b WHERE b.libelle = :nom")
	 Optional<Roles> findByName(String nom);
	
	 @Query("SELECT b FROM Roles b WHERE b.code = :nom")
	 Optional<Roles> findByCode(String nom);
}
