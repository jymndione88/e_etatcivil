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

import com.administration.etatcivil.entities.ModeLivraison;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.ModeLivraisonRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class ModeLivraisonController {

	@Autowired
	private ModeLivraisonRepository metier;
	                      
    @RequestMapping(value= "/modelivraison", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<ModeLivraison>> getListModeLivraison(){
    	List<ModeLivraison> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<ModeLivraison>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<ModeLivraison>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/modelivraison", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addModeLivraison(@RequestBody ModeLivraison con){

    	//Si l'con n'existe pas déja
    	if(metier.findByMode(con.getMode())!=null){
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("ModeLivraison existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateModeLivraison(@PathVariable("id") Long id, @RequestBody ModeLivraison con){

Optional<ModeLivraison> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("ModeLivraison non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	ModeLivraison art = optionalart.get();
        	art.setMode(con.getMode());
        	 metier.save(art);
        	 
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
	}
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getModeLivraisonById(@PathVariable("id") Long id) {

    	Optional<ModeLivraison> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("ModeLivraison non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/modelivraison/{id}/{type}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getModeLivraisonByType(@PathVariable("id") Long id, @PathVariable("type") String type) {

    	Optional<ModeLivraison> optionalart = metier.findByMode(type);

    	if (optionalart== null){
    		return new ResponseEntity<>("ModeLivraison non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteModeLivraison(@PathVariable("id") Long id){

    	Optional<ModeLivraison> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	ModeLivraison art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
