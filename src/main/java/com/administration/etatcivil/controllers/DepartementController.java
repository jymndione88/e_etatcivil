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


@CrossOrigin("http://localhost:4200")
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
            return new ResponseEntity<List<Departements>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Departements>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/departement", method= RequestMethod.POST)
    @ResponseBody
	public Departements addDepartement(@RequestBody Departements con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getLibelle()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Departement existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Departements updateDepartement(@PathVariable("id") Long id, @RequestBody Departements con){

Optional<Departements> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Departements art = optionalart.get();
        	art.setLibelle(con.getLibelle());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Departement non trouvé");
		}

	}
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Departements getDepartementById(@PathVariable("id") Long id) {

    	Optional<Departements> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Departements art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Departement non trouvé");
		}

    }
    
    @RequestMapping(value= "/departement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDepartement(@PathVariable("id") Long id){

    	Optional<Departements> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Departements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
