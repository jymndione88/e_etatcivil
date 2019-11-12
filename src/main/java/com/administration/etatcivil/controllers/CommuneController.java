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

import com.administration.etatcivil.entities.Communes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.CommuneRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class CommuneController {

	
	@Autowired
	private CommuneRepository metier;
	                      
    @RequestMapping(value= "/commune", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Communes>> getListCommune(){
    	List<Communes> communes= metier.findAll();	

    	if (communes == null || communes.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Communes>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Communes>>(communes, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/commune", method= RequestMethod.POST)
    @ResponseBody
	public Communes addCommune(@RequestBody Communes com, HttpServletResponse response){

    	//Si l'com n'existe pas déja
    	//if(!metier.findByNumero(com.getCode()).isPresent()){
    		//return metier.save(com);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "commune existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/commune/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Communes updateCommune(@PathVariable("id") Long id, @RequestBody Communes com){

    	Optional<Communes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Communes art = optionalart.get();
        	//art.setLibelle(com.getLibelle());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "commune non trouvé");
		}
	}
    
    @RequestMapping(value= "/commune/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Communes getCommuneById(@PathVariable("id") Long id) {

    	Optional<Communes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Communes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "commune non trouvé");
		}
      
    }
    
    @RequestMapping(value= "/commune/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteCommune(@PathVariable("id") Long id){

    	Optional<Communes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Communes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
