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

import com.administration.etatcivil.entities.Concernes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.ConcerneRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class ConcerneController {

	@Autowired
	private ConcerneRepository metier;
	                      
    @RequestMapping(value= "/concerne", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Concernes>> getListConcerne(){
    	List<Concernes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Concernes>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Concernes>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/concerne", method= RequestMethod.POST)
    @ResponseBody
	public Concernes addConcerne(@RequestBody Concernes con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getNomConjoint()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "concerne existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/concerne/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Concernes updateConcerne(@PathVariable("id") Long id, @RequestBody Concernes con){

Optional<Concernes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Concernes art = optionalart.get();
        	art.setNomConjoint(con.getNomConjoint());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "concerne non trouvé");
		}
      
	}
    
    @RequestMapping(value= "/concerne/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Concernes getConcerneById(@PathVariable("id") Long id) {

    	Optional<Concernes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Concernes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "concerne non trouvé");
		}
    }
    
    @RequestMapping(value= "/concerne/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteConcerne(@PathVariable("id") Long id){

    	Optional<Concernes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Concernes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
