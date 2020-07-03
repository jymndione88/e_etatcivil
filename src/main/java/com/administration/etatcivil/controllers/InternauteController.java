package com.administration.etatcivil.controllers;

//import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
//import static com.galima.security.SecurityConstants.FORGOT_EXPIRATION_TIME;
//import static com.galima.security.SecurityConstants.FORGOT_SECRET;
//import static com.galima.security.SecurityConstants.MINPASSWORD;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.administration.etatcivil.entities.Arrondissements;
import com.administration.etatcivil.entities.Internautes;
import com.administration.etatcivil.entities.Personnes;
import com.administration.etatcivil.entities.Roles;
import com.administration.etatcivil.repositories.InternauteRepository;
import com.administration.etatcivil.repositories.PersonneRepository;
import com.administration.etatcivil.repositories.RoleRepository;
import com.administration.etatcivil.security.JwtResponse;
import com.administration.etatcivil.security.JwtUtils;
import com.administration.etatcivil.security.MessageResponse;
import com.administration.etatcivil.security.NomsRole;
import com.administration.etatcivil.security.SignupRequest;
import com.administration.etatcivil.security.UserDetailsImpl;

import io.jsonwebtoken.JwtParser;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class InternauteController {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private InternauteRepository utilisateurRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtUtils jwtUtils;

	   @RequestMapping(value= "/internaute", method= RequestMethod.GET,
	    		headers={"Accept=application/json"})
	    @ResponseBody
		public ResponseEntity<List<Internautes>> getListinternaute(){
	    	List<Internautes> internaute= utilisateurRepository.findAll();	
	    	
	    	if (internaute == null || internaute.isEmpty()){
	    		//erreur 204
	            return new ResponseEntity<List<Internautes>>(HttpStatus.NOT_FOUND);
	        }else{
	        	
	        	return new ResponseEntity<List<Internautes>>(internaute, HttpStatus.OK);
	        }

	    	
		}
		
	    @RequestMapping(value= "/internaute", method= RequestMethod.POST)
	    @ResponseBody
		public ResponseEntity<?>  addinternaute(@RequestBody Internautes arron){

	    	if(utilisateurRepository.findByEmail(arron.getEmail())!= null){
	    		utilisateurRepository.save(arron);
	    		 return new ResponseEntity<>(arron, HttpStatus.CREATED);
	    	}else {
	    		
	    		return new ResponseEntity<>("internaute existe déjà", HttpStatus.CONFLICT);
	    	}
	     
		}
	    
	    @RequestMapping(value= "/internaute/{id}", method= RequestMethod.PUT)
	    @ResponseBody
		public ResponseEntity<?> updateinternaute(@PathVariable("id") Long id, @RequestBody Internautes arron){

	Optional<Internautes> optionalart = utilisateurRepository.findById(id);
	    	
	        if (optionalart== null){
	          	 return new ResponseEntity<>("internaute non trouvé", HttpStatus.NOT_FOUND);
	        	
	        }else { 

	        	Internautes art = optionalart.get();
	        	art.setLogin(arron.getLogin());
	        	art.setEmail(arron.getEmail());
	        	
	        	utilisateurRepository.save(art);
	        	 return new ResponseEntity<>(art, HttpStatus.OK);        	
			}
		}
	    
	    @RequestMapping(value= "/internaute/{id}", method= RequestMethod.GET,
	    		headers={"Accept=application/json"})
	    @ResponseBody
	    public ResponseEntity<?> getinternaute(@PathVariable("id") Long id) {

	    	Optional<Internautes> optionalart = utilisateurRepository.findById(id);

	    	if (optionalart== null){
	    		return new ResponseEntity<>("internaute non trouvé", HttpStatus.NOT_FOUND);
	            
	    	}else { 
	    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
			}
	    }
	    
	    @RequestMapping(value= "/internaute/{id}", method= RequestMethod.DELETE)
	    @ResponseBody
	   	public ResponseEntity<Void> deleteinternaute(@PathVariable("id") Long id){

	    	Optional<Internautes> optionalart  = utilisateurRepository.findById(id);

	        if (optionalart== null){
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        }else{

	        	Internautes art = optionalart.get();
	        	utilisateurRepository.delete(art);
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	   	}
	
    @RequestMapping(value="/login", method= RequestMethod.POST)
 	public ResponseEntity<?> signInUser(@RequestBody Internautes internaute){
    	
    	String optionalart = utilisateurRepository.findLoginByEmail(internaute.getEmail());
    	
    	Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(optionalart, internaute.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
 	}
 
    
    @RequestMapping(value="/inscrire", method= RequestMethod.POST)
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignupRequest userSignUp) {
    	if (utilisateurRepository.findByUsername(userSignUp.getLogin()).isPresent()) {
			
			  return new ResponseEntity<String>("Erreur: login existe deja!",
	                    HttpStatus.BAD_REQUEST);
		}

		if (utilisateurRepository.findByEmail(userSignUp.getEmail()).isPresent()) {

			return new ResponseEntity<String>("Erreur: Email existe deja!",
                    HttpStatus.BAD_REQUEST);
		}

		// Create new user's account
		Internautes user = new Internautes(userSignUp.getLogin(), 
								userSignUp.getEmail(),
								passwordEncoder.encode(userSignUp.getPassword()));

		Set<String> strRoles = userSignUp.getRole();
		Set<Roles> roles = new HashSet<>();
		
		if (strRoles == null) {
			Roles userRole = roleRepository.findByName(NomsRole.ROLE_USER.toString())
					.orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "Admin":
					Optional<Roles> adminRole = roleRepository.findByName(NomsRole.ROLE_ADMIN.toString());
					 if (adminRole== null){
			           //return new ResponseEntity<>("Erreur: Role est non défini", HttpStatus.NOT_FOUND);
			        	throw new RuntimeException("Erreur: Role est non défini.");
			        }else { 
			        	roles.add(adminRole.get());
			        }
				
					break;
				case "Officier":
					Roles officierRole = roleRepository.findByName(NomsRole.ROLE_OFFICIER.toString())
							.orElseThrow(() -> new RuntimeException("Erreur: Role est non défini."));
					roles.add(officierRole);

					break;
				case "Agent":
					Roles agentRole = roleRepository.findByName(NomsRole.ROLE_AGENT.toString())
							.orElseThrow(() -> new RuntimeException("Erreur: Role est non défini."));
					roles.add(agentRole);

					break;
				default:
					Roles declarantRole = roleRepository.findByName(NomsRole.ROLE_USER.toString())
							.orElseThrow(() -> new RuntimeException("Erreur: Role est non défini."));
					roles.add(declarantRole);
				}
			});
		}

		user.setRoles(roles);
		
		if (userSignUp.getNom() != null) {
			Personnes p= new Personnes();
			p.setNom(userSignUp.getNom());
			p.setPrenom(userSignUp.getPrenom());
			p.setDatenaiss(userSignUp.getDatenaiss());
			p.setAdresse(userSignUp.getAdresse());
			p.setLieunaiss(userSignUp.getLieunaiss());
			p.setNin(userSignUp.getNIN());
			p.setTel(userSignUp.getTel());
			
			personneRepository.save(p);
			user.setIdPersonne(p);
		}else {
			Personnes p= new Personnes();
			p.setNom(userSignUp.getLogin());
			p.setPrenom(userSignUp.getLogin());
			p.setDatenaiss(new Date());
			p.setAdresse(userSignUp.getLogin());
			p.setLieunaiss(userSignUp.getLogin());
			p.setNin(123);
			p.setTel(77654398);
			
			personneRepository.save(p);
			user.setIdPersonne(p);
		}
		
		user.setResetPassword("");
		utilisateurRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User enregistré avec succés!"));
	
    } 
   

}
