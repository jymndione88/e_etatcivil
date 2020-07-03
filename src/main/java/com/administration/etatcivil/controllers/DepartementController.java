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

import com.administration.etatcivil.entities.Departements;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.DepartementRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class DepartementController {

	@Autowired
	private DepartementRepository metier;
	                      
    @RequestMapping(value= "/departement", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Departements>> getListDepartement(){
    	List<Departements> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Departements>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Departements>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/departement", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?>  addDepartement(@RequestBody Departements con){

    	//Si l'con n'existe pas déja
    	if(metier.findByCode(con.getCode())!= null){
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("Departement existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateDepartement(@PathVariable("id") Long id, @RequestBody Departements con){

Optional<Departements> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Departement non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Departements art = optionalart.get();
        	art.setCode(con.getCode());
        	art.setLibelle(con.getLibelle());
        	art.setIdRegion(con.getIdRegion());
        	
        	 metier.save(art);
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}

	}
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getDepartementById(@PathVariable("id") Long id) {

    	Optional<Departements> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Departement non trouvé", HttpStatus.NOT_FOUND);
            
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDepartement(@PathVariable("id") Long id){

    	Optional<Departements> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Departements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
