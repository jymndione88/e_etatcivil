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


@CrossOrigin("http://localhost:4200")
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
            return new ResponseEntity<List<Regions>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Regions>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/region", method= RequestMethod.POST)
    @ResponseBody
	public Regions addRegion(@RequestBody Regions con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getCode()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Region existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Regions updateRegion(@PathVariable("id") Long id, @RequestBody Regions con){

Optional<Regions> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Regions art = optionalart.get();
        	art.setCode(con.getCode());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Region non trouvé");
		}
        
	}
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Regions getRegionById(@PathVariable("id") Long id) {

    	Optional<Regions> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Regions art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Region non trouvé");
		}
    }
    
    @RequestMapping(value= "/region/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteRegion(@PathVariable("id") Long id){

    	Optional<Regions> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Regions art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
