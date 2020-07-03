package com.administration.etatcivil.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.administration.etatcivil.entities.Arrondissements;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.ArrondissementRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class ArrondissementController {
	

	@Autowired
	private ArrondissementRepository metier;
	
    @RequestMapping(value= "/arrondissement", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Arrondissements>> getListArrondissement(){
    	List<Arrondissements> arrondissements= metier.findAll();	
    	
    	if (arrondissements == null || arrondissements.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Arrondissements>>(HttpStatus.NOT_FOUND);
        }else{
        	
        	return new ResponseEntity<List<Arrondissements>>(arrondissements, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/arrondissement", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?>  addArrondissement(@RequestBody Arrondissements arron){

    	//Si l'arron n'existe pas déja
    	if(metier.findByCode(arron.getCode())!= null){
    		 metier.save(arron);
    		 return new ResponseEntity<>(arron, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("arrondissement existe déjà", HttpStatus.CONFLICT);
    	}
     
	}
    
    @RequestMapping(value= "/arrondissement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateArrondissement(@PathVariable("id") Long id, @RequestBody Arrondissements arron){

Optional<Arrondissements> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("arrondissement non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Arrondissements art = optionalart.get();
        	art.setCode(arron.getCode());
        	art.setLibelle(arron.getLibelle());
        	art.setIdDepartement(arron.getIdDepartement());
        	
        	 metier.save(art);
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
	}
    
    @RequestMapping(value= "/arrondissement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getArrondissementById(@PathVariable("id") Long id) {

    	Optional<Arrondissements> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("arrondissement non trouvé", HttpStatus.NOT_FOUND);
            
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
    @RequestMapping(value= "/arrondissement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteArrondissement(@PathVariable("id") Long id){

    	Optional<Arrondissements> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Arrondissements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
