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
import com.administration.etatcivil.entities.Roles;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.RegionRepository;
import com.administration.etatcivil.repositories.RoleRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class Role {

	@Autowired
	private RoleRepository metier;
	                      
    @RequestMapping(value= "/role", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Roles>> getListRoles(){
    	List<Roles> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Roles>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Roles>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/role", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addRoles(@RequestBody Roles con){

    	//Si l'con n'existe pas déja
    	if(metier.findByCode(con.getCode())!= null){
    		 metier.save(con);
    	 		return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    	
    		return new ResponseEntity<>("Roles existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/role/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateRoles(@PathVariable("id") Long id, @RequestBody Roles con){

Optional<Roles> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Roles non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Roles art = optionalart.get();
        	art.setCode(con.getCode());
        	art.setLibelle(con.getLibelle());
        	 metier.save(art);
        	return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
        
	}
    
    @RequestMapping(value= "/role/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getRolesById(@PathVariable("id") Long id) {

    	Optional<Roles> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Role non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
    @RequestMapping(value= "/role/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteRoles(@PathVariable("id") Long id){

    	Optional<Roles> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Roles art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
