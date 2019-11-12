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

import com.administration.etatcivil.entities.Officiers;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.OfficierRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class OfficierController {

	@Autowired
	private OfficierRepository metier;
	                      
    @RequestMapping(value= "/officier", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Officiers>> getListOfficier(){
    	List<Officiers> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Officiers>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Officiers>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/officier", method= RequestMethod.POST)
    @ResponseBody
	public Officiers addOfficier(@RequestBody Officiers con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getLogin()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Officier existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/officier/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Officiers updateOfficier(@PathVariable("id") Long id, @RequestBody Officiers con){

Optional<Officiers> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Officiers art = optionalart.get();
        	//art.setLogin(con.getLogin());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Officier non trouvé");
		}
        
	}
    
    @RequestMapping(value= "/officier/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Officiers getOfficierById(@PathVariable("id") Long id) {

    	Optional<Officiers> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Officiers art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Officier non trouvé");
		}
    }
    
    @RequestMapping(value= "/officier/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteOfficier(@PathVariable("id") Long id){

    	Optional<Officiers> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Officiers art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
