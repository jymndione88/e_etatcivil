package com.administration.etatcivil.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.administration.etatcivil.entities.Internautes;
import com.administration.etatcivil.entities.Personnes;

public interface InternauteRepository extends JpaRepository<Internautes, Long>{
	
	@Query("SELECT u FROM Internautes u WHERE u.login = :username")
	Optional<Internautes> findByUsername(String username);
	
	@Query("SELECT u FROM Internautes u WHERE u.email = :email")
	Optional<Internautes> findByEmail(String email);
	
	@Query("SELECT u.login FROM Internautes u WHERE u.email = :email")
	String findLoginByEmail(String email);
	
	//@Query("SELECT p FROM personnes p INNER JOIN p.internautesList i WHERE i.email = :email")
	//Personnes getPersonneByEmail(@Param("email") String email);
	
	//Internautes findByLogin(String login);
	//Internautes findByEmail(String email);

	
	//Internautes findByResetToken(String resetToken);
	
	//@Query("SELECT u FROM Internautes u join u.roles r WHERE r.code = :code")
	//List<Internautes> findByCode(@Param("code") String code);
}

