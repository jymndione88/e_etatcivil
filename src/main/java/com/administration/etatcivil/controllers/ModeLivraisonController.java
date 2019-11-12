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

import com.administration.etatcivil.entities.ModeLivraison;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.ModeLivraisonRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class ModeLivraisonController {

	@Autowired
	private ModeLivraisonRepository metier;
	                      
    @RequestMapping(value= "/modelivraison", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<ModeLivraison>> getListModeLivraison(){
    	List<ModeLivraison> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<ModeLivraison>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<ModeLivraison>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/modelivraison", method= RequestMethod.POST)
    @ResponseBody
	public ModeLivraison addModeLivraison(@RequestBody ModeLivraison con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getMode()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModeLivraison existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ModeLivraison updateModeLivraison(@PathVariable("id") Long id, @RequestBody ModeLivraison con){

Optional<ModeLivraison> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	ModeLivraison art = optionalart.get();
        	art.setMode(con.getMode());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModeLivraison non trouvé");
		}
	}
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ModeLivraison getModeLivraisonById(@PathVariable("id") Long id) {

    	Optional<ModeLivraison> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		ModeLivraison art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ModeLivraison non trouvé");
		}

    }
    
    @RequestMapping(value= "/modelivraison/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteModeLivraison(@PathVariable("id") Long id){

    	Optional<ModeLivraison> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	ModeLivraison art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
