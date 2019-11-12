package com.administration.etatcivil.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.administration.etatcivil.entities.Personnes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.PersonneRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class PersonneController {

	@Autowired
	private PersonneRepository metier;
	                      
    @RequestMapping(value= "/personne", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Personnes>> getListPersonne(){
    	List<Personnes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Personnes>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Personnes>>(con, HttpStatus.OK);
        }

	
    }
    
    @RequestMapping(value= "/personne", method= RequestMethod.POST)
    @ResponseBody
	public Personnes addPersonne(@RequestBody Personnes con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getNom()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Personne existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/personne/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Personnes updatePersonne(@PathVariable("id") Long id, @RequestBody Personnes con){

Optional<Personnes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Personnes art = optionalart.get();
        	art.setNom(con.getNom());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Personne non trouvé");
		}

	}
    
    @RequestMapping(value= "/personne/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Personnes getPersonneById(@PathVariable("id") Long id) {

    	Optional<Personnes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Personnes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Personne non trouvé");
		}
    }
    
    @RequestMapping(value= "/personne/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deletePersonne(@PathVariable("id") Long id){

    	Optional<Personnes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Personnes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
       
   	}
    
}
