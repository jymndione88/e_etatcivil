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

import com.administration.etatcivil.entities.EtatDemandes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.EtatDemandeRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class EtatDemandeController {

	@Autowired
	private EtatDemandeRepository metier;
	                      
    @RequestMapping(value= "/etatdemande", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<EtatDemandes>> getListEtatDemande(){
    	List<EtatDemandes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<EtatDemandes>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<EtatDemandes>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/etatdemande", method= RequestMethod.POST)
    @ResponseBody
	public EtatDemandes addEtatDemande(@RequestBody EtatDemandes con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getEtat()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatDemande existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/etatdemande/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public EtatDemandes updateEtatDemande(@PathVariable("id") Long id, @RequestBody EtatDemandes con){

Optional<EtatDemandes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	EtatDemandes art = optionalart.get();
        	art.setEtat(con.getEtat());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatDemande non trouvé");
		}
	}
    
    @RequestMapping(value= "/etatdemande/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public EtatDemandes getEtatDemandeById(@PathVariable("id") Long id) {

    	Optional<EtatDemandes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		EtatDemandes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "EtatDemande non trouvé");
		}
    }
    
    @RequestMapping(value= "/etatdemande/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteEtatDemande(@PathVariable("id") Long id){

    	Optional<EtatDemandes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	EtatDemandes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
