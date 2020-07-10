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
import java.lang.String;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class DemandeController {

	@Autowired
	private DemandeRepository metier;
	                      
    @RequestMapping(value= "/demande/{nat}/{liste}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Demandes>> getListDemandeBy(@PathVariable("nat") String nat, @PathVariable("liste") String liste){
    	
    	List<Demandes> con= null;
    			
    	if(nat.equals("naissance")) {
    		con= metier.findByNaissance();	
    	}else if (nat.equals("mariage")) {
    		con= metier.findByMariage();	
		}else if (nat.equals("deces")) {
			con= metier.findByDeces();	
		}
    	
    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Demandes>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Demandes>>(con, HttpStatus.OK);
        }

	}
    
    @RequestMapping(value= "/demande", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Demandes>> getListDemande(){
    	
    	List<Demandes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Demandes>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Demandes>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/demande", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addDemande(@RequestBody Demandes con, HttpServletResponse response){

    	metier.save(con);
    	return new ResponseEntity<>(con, HttpStatus.CREATED);
    	
	}
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateDemande(@PathVariable("id") Long id, @RequestBody Demandes con){

Optional<Demandes> optionalart = metier.findById(id);
    	
        if (optionalart== null){
        	return new ResponseEntity<>("demande non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 
        	Demandes art = optionalart.get();
        	art.setNumero(con.getNumero());
        	art.setDate(con.getDate());
        	art.setMotif(con.getMotif());
        	art.setQualiteDemandeur(con.getQualiteDemandeur());        	
        	art.setNatureActe(con.getNatureActe());
        	art.setNbreExemplaire(con.getNbreExemplaire());
        	art.setCivilite(con.getCivilite());
        	art.setNom(con.getNom());
        	art.setPrenom(con.getPrenom());
        	
        	art.setDatenaiss(con.getDate());
        	art.setPays(con.getPays());
        	art.setNationalite(con.getNationalite());
        	art.setEtat(con.getEtat());
        	art.setCommentaire(con.getCommentaire());
        	
        	art.setIdNaissance(con.getIdNaissance());
        	art.setIdDeces(con.getIdDeces());
        	art.setIdMariage(con.getIdMariage());
        	art.setIdOfficier(con.getIdOfficier());
        	
        	metier.save(art);
        	
        	return new ResponseEntity<>(art, HttpStatus.OK);
		}
        
	}
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getDemandeById(@PathVariable("id") Long id) {

    	Optional<Demandes> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("demande non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/demande/{id}/{nb}/{type}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getNbDemandeBy(@PathVariable("id") Long id, @PathVariable("nb") Long nb, @PathVariable("type") String type) {

    	Integer optionalart = null;
    	if(type.equals("naissance")) {
    		 optionalart = metier.nbfindByNaissance();
    		 
    	}else if (type.equals("mariage")) {
    		optionalart = metier.nbfindByMariage();
		}else{
			optionalart = metier.nbfindByDeces();
		}    	

    	if (optionalart== null){
    		return new ResponseEntity<>("demande non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/demande/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDemande(@PathVariable("id") Long id){

    	Optional<Demandes> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Demandes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
