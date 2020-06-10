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

import com.administration.etatcivil.entities.Mariages;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.MariageRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class MariageController {

	@Autowired
	private MariageRepository metier;
	                      
    @RequestMapping(value= "/mariage", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Mariages>> getListMariage(){
    	List<Mariages> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Mariages>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Mariages>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/mariage", method= RequestMethod.POST)
    @ResponseBody
	public Mariages addMariage(@RequestBody Mariages con, HttpServletResponse response){
    	
    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getRegim()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Mariage existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Mariages updateMariage(@PathVariable("id") Long id, @RequestBody Mariages con){
    	
Optional<Mariages> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Mariages art = optionalart.get();
        	//art.setRegim(con.getRegim());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Mariage non trouvé");
		}
        
	}
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Mariages getMariageById(@PathVariable("id") Long id) {

    	Optional<Mariages> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Mariages art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Mariage non trouvé");
		}

    }
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteMariage(@PathVariable("id") Long id){

    	Optional<Mariages> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Mariages art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
