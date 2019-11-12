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

import com.administration.etatcivil.entities.EtatFactures;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.EtatFactureRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class EtatFactureController {

	@Autowired
	private EtatFactureRepository metier;
	                      
    @RequestMapping(value= "/etatfacture", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<EtatFactures>> getListEtatFacture(){
    	List<EtatFactures> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<EtatFactures>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<EtatFactures>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/etatfacture", method= RequestMethod.POST)
    @ResponseBody
	public EtatFactures addEtatFacture(@RequestBody EtatFactures con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getEtat()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatFacture existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/etatfacture/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public EtatFactures updateEtatFacture(@PathVariable("id") Long id, @RequestBody EtatFactures con){
    	
Optional<EtatFactures> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	EtatFactures art = optionalart.get();
        	art.setEtat(con.getEtat());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatFacture non trouvé");
		}
       
	}
    
    @RequestMapping(value= "/etatfacture/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public EtatFactures getEtatFactureById(@PathVariable("id") Long id) {

    	Optional<EtatFactures> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		EtatFactures art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatFacture non trouvé");
		}

    }
    
    @RequestMapping(value= "/etatfacture/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteEtatFacture(@PathVariable("id") Long id){

    	Optional<EtatFactures> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	EtatFactures art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
