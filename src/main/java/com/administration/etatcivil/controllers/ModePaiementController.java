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

import com.administration.etatcivil.entities.ModePaiements;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.ModePaiementRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class ModePaiementController {

	@Autowired
	private ModePaiementRepository metier;
	                      
    @RequestMapping(value= "/modepaiement", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<ModePaiements>> getListModePaiement(){
    	List<ModePaiements> con= metier.findAll();
    	
    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<ModePaiements>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<ModePaiements>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/modepaiement", method= RequestMethod.POST)
    @ResponseBody
	public ModePaiements addModePaiement(@RequestBody ModePaiements con, HttpServletResponse response){
    	
    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getMode()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModePaiement existe déjà");
    	//}
    	return null;

	}
    
    @RequestMapping(value= "/modepaiement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ModePaiements updateModePaiement(@PathVariable("id") Long id, @RequestBody ModePaiements con){

Optional<ModePaiements> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	ModePaiements art = optionalart.get();
        	art.setMode(con.getMode());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModePaiement non trouvé");
		}

	}
    
    @RequestMapping(value= "/modepaiement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ModePaiements getModePaiementById(@PathVariable("id") Long id) {

    	Optional<ModePaiements> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		ModePaiements art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModePaiement non trouvé");
		}
    }
    
    @RequestMapping(value= "/modepaiement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteModePaiement(@PathVariable("id") Long id){

    	Optional<ModePaiements> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	ModePaiements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
