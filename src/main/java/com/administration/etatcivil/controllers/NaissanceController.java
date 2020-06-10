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

import com.administration.etatcivil.entities.Naissances;
import com.administration.etatcivil.repositories.NaissanceRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class NaissanceController {

	@Autowired
	private NaissanceRepository metier;
	                      
    @RequestMapping(value= "/naissance", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Naissances>> getListNaissance(){
    	List<Naissances> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Naissances>>(HttpStatus.NOT_FOUND);
        }else{
        	
        	return new ResponseEntity<List<Naissances>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/naissance", method= RequestMethod.POST)
	public ResponseEntity<?> addNaissance(@RequestBody Naissances con){
    	
    	//Si l'con n'existe pas déja
    	// if(metier.findByCode(con.getCode())!= null){
    		 metier.save(con);
    		return new ResponseEntity<>(con, HttpStatus.CREATED);
    	//}else {
    	//	return new ResponseEntity<>("Naissance existe déjà", HttpStatus.CONFLICT);
    	//}
    	
	}
    
    @RequestMapping(value= "/naissance/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateNaissance(@PathVariable("id") Long id, @RequestBody Naissances con){

Optional<Naissances> optionalart = metier.findById(id);
    	
        if (optionalart== null){
        	 return new ResponseEntity<>("Naissance non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 
        	Naissances art = optionalart.get();
        	//art.setCode(con.getCode());
        	//art.setType(con.getType());
        	metier.save(art);
        	
        	return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
    
	}
    
    @RequestMapping(value= "/naissance/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getNaissanceById(@PathVariable("id") Long id) {

    	Optional<Naissances> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Naissance non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
        
    }
    
    @RequestMapping(value= "/naissance/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteNaissance(@PathVariable("id") Long id){

    	Optional<Naissances> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Naissances art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}