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

import com.administration.etatcivil.entities.Factures;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.FactureRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class FactureController {

	@Autowired
	private FactureRepository metier;
	                      
    @RequestMapping(value= "/facture", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Factures>> getListFacture(){
    	List<Factures> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Factures>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Factures>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/facture", method= RequestMethod.POST)
    @ResponseBody
	public Factures addFacture(@RequestBody Factures con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByContenu(con.getContent()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Facture existe déjà");
    	//}
    	return null;

	}
    
    @RequestMapping(value= "/facture/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Factures updateFacture(@PathVariable("id") Long id, @RequestBody Factures con){

Optional<Factures> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Factures art = optionalart.get();
        	art.setMontant(con.getMontant());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Facture non trouvé");
		}
	}
    
    @RequestMapping(value= "/facture/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Factures getFactureById(@PathVariable("id") Long id) {

    	Optional<Factures> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Factures art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Facture non trouvé");
		}

    }
    
    @RequestMapping(value= "/facture/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteFacture(@PathVariable("id") Long id){

    	Optional<Factures> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Factures art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
