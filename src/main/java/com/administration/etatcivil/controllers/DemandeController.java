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

import com.administration.etatcivil.entities.Demandes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.DemandeRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class DemandeController {

	@Autowired
	private DemandeRepository metier;
	                      
    @RequestMapping(value= "/demande", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Demandes>> getListDemande(){
    	List<Demandes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Demandes>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Demandes>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/demande", method= RequestMethod.POST)
    @ResponseBody
	public Demandes addDemande(@RequestBody Demandes con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getNumero()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "demande existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Demandes updateDemande(@PathVariable("id") Long id, @RequestBody Demandes con){

Optional<Demandes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Demandes art = optionalart.get();
        	art.setNumero(con.getNumero());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "demande non trouvé");
		}
        
	}
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Demandes getDemandeById(@PathVariable("id") Long id) {

    	Optional<Demandes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Demandes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "demande non trouvé");
		}

    }
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDemande(@PathVariable("id") Long id){

    	Optional<Demandes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Demandes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
