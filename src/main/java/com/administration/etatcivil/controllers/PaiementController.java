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

import com.administration.etatcivil.entities.Paiements;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.PaiementRepository;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class PaiementController {

	@Autowired
	private PaiementRepository metier;
	                      
    @RequestMapping(value= "/paiement", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Paiements>> getListPaiement(){
    	List<Paiements> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Paiements>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Paiements>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/paiement", method= RequestMethod.POST)
    @ResponseBody
	public  ResponseEntity<?> addPaiement(@RequestBody Paiements con){

    	//Si l'con n'existe pas déja
    	if(metier.findByDate(con.getDate())!=null){
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("Paiement existe déjà", HttpStatus.CONFLICT);
    	}
    
	}
    
    @RequestMapping(value= "/paiement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updatePaiement(@PathVariable("id") Long id, @RequestBody Paiements con){

Optional<Paiements> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Paiement non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Paiements art = optionalart.get();
        	art.setDate(con.getDate());
        	art.setMontant(con.getMontant());
        	art.setIdFacture(con.getIdFacture());
        	art.setIdModePaiement(con.getIdModePaiement());
        	 metier.save(art);
        	 
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
	}
    
    @RequestMapping(value= "/paiement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getPaiementById(@PathVariable("id") Long id) {

    	Optional<Paiements> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Paiement non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
    @RequestMapping(value= "/paiement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deletePaiement(@PathVariable("id") Long id){

    	Optional<Paiements> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Paiements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
