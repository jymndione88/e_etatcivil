package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.Regions;
import com.administration.etatcivil.entities.RoleOfficiers;

public interface RoleOfficierRepository extends JpaRepository<RoleOfficiers, Long> {

	 @Query("SELECT b FROM RoleOfficiers b WHERE b.role = ?1")
	 Optional<RoleOfficiers> findByRole(String role);
	 
	//Optional<RoleOfficiers> findByNumero(String numero);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	 //@Query("SELECT b FROM Bien b WHERE b.bien.id = ?1")
	 //List<Arrondissements> findByTypeBien(Integer type_bien_id);
}
