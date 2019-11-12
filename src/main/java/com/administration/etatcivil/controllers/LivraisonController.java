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

import com.administration.etatcivil.entities.Livraison;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.LivraisonRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class LivraisonController {

	@Autowired
	private LivraisonRepository metier;
	                      
    @RequestMapping(value= "/livraison", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Livraison>> getListLivraison(){
    	List<Livraison> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Livraison>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Livraison>>(con, HttpStatus.OK);
        }

    
	}
	
    @RequestMapping(value= "/livraison", method= RequestMethod.POST)
    @ResponseBody
	public Livraison addLivraison(@RequestBody Livraison con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getDescription()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Livraison existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Livraison updateLivraison(@PathVariable("id") Long id, @RequestBody Livraison con){

Optional<Livraison> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Livraison art = optionalart.get();
        	art.setDate(con.getDate());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Livraison non trouvé");
		}

	}
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Livraison getLivraisonById(@PathVariable("id") Long id) {

    	Optional<Livraison> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Livraison art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Livraison non trouvé");
		}
    }
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteLivraison(@PathVariable("id") Long id){

    	Optional<Livraison> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Livraison art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
