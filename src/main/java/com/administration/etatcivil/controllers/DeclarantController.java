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

import com.administration.etatcivil.entities.Declarants;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.DeclarantRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class DeclarantController {

	@Autowired
	private DeclarantRepository metier;
	                      
    @RequestMapping(value= "/declarant", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Declarants>> getListDeclarant(){
    	List<Declarants> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Declarants>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Declarants>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/declarant", method= RequestMethod.POST)
    @ResponseBody
	public Declarants addDeclarant(@RequestBody Declarants con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByContenu(con.getContent()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declarant existe déjà");
    	//}
    	
    	return null;
	}
    
    @RequestMapping(value= "/declarant/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Declarants updateDeclarant(@PathVariable("id") Long id, @RequestBody Declarants con){

Optional<Declarants> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Declarants art = optionalart.get();
        	//art.setNin(con.getNin());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declarant non trouvé");
		}
	}
    
    @RequestMapping(value= "/declarant/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Declarants getDeclarantById(@PathVariable("id") Long id) {

    	Optional<Declarants> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Declarants art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declarant non trouvé");
		}
    }
    
    @RequestMapping(value= "/declarant/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDeclarant(@PathVariable("id") Long id){

    	Optional<Declarants> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Declarants art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
