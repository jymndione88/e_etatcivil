package com.administration.etatcivil.controllers;

//import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
//import static com.galima.security.SecurityConstants.FORGOT_EXPIRATION_TIME;
//import static com.galima.security.SecurityConstants.FORGOT_SECRET;
//import static com.galima.security.SecurityConstants.MINPASSWORD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.administration.etatcivil.entities.Internautes;
import com.administration.etatcivil.repositories.InternauteRepository;
import com.administration.etatcivil.repositories.RoleRepository;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InternauteController {
	
	@Autowired
	private InternauteRepository utilisateurRepository;
	
	@Autowired
	private RoleRepository roleRepository;

   // private BCryptPasswordEncoder bCryptPasswordEncoder;

    
   // public InternauteController(InternauteRepository utilisateurRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	//	this.utilisateurRepository = utilisateurRepository;
		//this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	//}
    
    public InternauteController() {

	}
   
    //@RequestMapping(value="/login",method=RequestMethod.POST)
 	//public ResponseEntity<?> createAuthenticationToken(@RequestBody Jwt bien){
 		//return bienRepository.save(bien);
 		//}

    @PostMapping("/sign-up")
    public String signUp(@RequestBody Internautes user) {
      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        utilisateurRepository.save(user);
        
        return "enregistrer avec succes!";
    }

}
