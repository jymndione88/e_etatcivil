package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.administration.etatcivil.entities.LieuHospitalier;

public interface LieuHospitalierRepository extends JpaRepository<LieuHospitalier, Long> {

	 @Query("SELECT b FROM LieuHospitalier b WHERE b.code = ?1")
	 Optional<LieuHospitalier> findByCode(String code);
	
	 @Query("SELECT b FROM LieuHospitalier b WHERE b.libelle = ?1")
	 Optional<LieuHospitalier> findByLibelle(String libelle);
	
	 // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
	
}
