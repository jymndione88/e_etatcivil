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

import com.administration.etatcivil.entities.LieuLivraisons;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.LieuLivraisonRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class LieuLivraisonController {

	@Autowired
	private LieuLivraisonRepository metier;
	                      
    @RequestMapping(value= "/lieulivraison", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<LieuLivraisons>> getListLieuLivraison(){
    	List<LieuLivraisons> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<LieuLivraisons>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<LieuLivraisons>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/lieulivraison", method= RequestMethod.POST)
    @ResponseBody
	public LieuLivraisons addLieuLivraison(@RequestBody LieuLivraisons con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getAdresse()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuLivraison existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/lieulivraison/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public LieuLivraisons updateLieuLivraison(@PathVariable("id") Long id, @RequestBody LieuLivraisons con){

    	Optional<LieuLivraisons> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	LieuLivraisons art = optionalart.get();
        	art.setAdresse(con.getAdresse());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuLivraison non trouvé");
		}

	}
    
    @RequestMapping(value= "/lieulivraison/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public LieuLivraisons getLieuLivraisonById(@PathVariable("id") Long id) {

    	Optional<LieuLivraisons> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		LieuLivraisons art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuLivraison non trouvé");
		}

    }
    
    @RequestMapping(value= "/lieulivraison/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteLieuLivraison(@PathVariable("id") Long id){

    	Optional<LieuLivraisons> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	LieuLivraisons art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
       
   	}
    
}
