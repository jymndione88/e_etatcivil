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

import com.administration.etatcivil.entities.RoleOfficiers;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.RoleOfficierRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class RoleOfficierController {

	@Autowired
	private RoleOfficierRepository metier;
	                      
    @RequestMapping(value= "/roleofficier", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<RoleOfficiers>> getListRoleOfficier(){
    	List<RoleOfficiers> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<RoleOfficiers>>(HttpStatus.NO_CONTENT);
        }else{
        	
        	return new ResponseEntity<List<RoleOfficiers>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/roleofficier", method= RequestMethod.POST)
    @ResponseBody
	public RoleOfficiers addRoleOfficier(@RequestBody RoleOfficiers con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getRole()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "RoleOfficier existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/roleofficier/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public RoleOfficiers updateRoleOfficier(@PathVariable("id") Long id, @RequestBody RoleOfficiers con){

Optional<RoleOfficiers> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	RoleOfficiers art = optionalart.get();
        	art.setRole(con.getRole());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "RoleOfficier non trouvé");
		}
       
	}
    
    @RequestMapping(value= "/roleofficier/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public RoleOfficiers getRoleOfficierById(@PathVariable("id") Long id) {

    	Optional<RoleOfficiers> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		RoleOfficiers art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "RoleOfficier non trouvé");
		}

    }
    
    @RequestMapping(value= "/roleofficier/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteRoleOfficier(@PathVariable("id") Long id){

    	Optional<RoleOfficiers> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	RoleOfficiers art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
