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

import com.administration.etatcivil.entities.Regions;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.RegionRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class RegionController {

	@Autowired
	private RegionRepository metier;
	                      
    @RequestMapping(value= "/region", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Regions>> getListRegion(){
    	List<Regions> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Regions>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Regions>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/region", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addRegion(@RequestBody Regions con){

    	//Si l'con n'existe pas déja
    	if(metier.findByCode(con.getCode())!= null){
    		 metier.save(con);
    	 		return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    	
    		return new ResponseEntity<>("Region existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateRegion(@PathVariable("id") Long id, @RequestBody Regions con){

Optional<Regions> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Region non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Regions art = optionalart.get();
        	art.setCode(con.getCode());
        	art.setLibelle(con.getLibelle());
        	 metier.save(art);
        	return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
        
	}
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getRegionById(@PathVariable("id") Long id) {

    	Optional<Regions> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Region non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteRegion(@PathVariable("id") Long id){

    	Optional<Regions> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Regions art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
