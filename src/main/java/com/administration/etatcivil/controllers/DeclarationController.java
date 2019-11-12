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

import com.administration.etatcivil.entities.Declarations;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.DeclarationRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class DeclarationController {

	@Autowired
	private DeclarationRepository metier;
	                      
    @RequestMapping(value= "/declaration", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Declarations>> getListDeclaration(){
    	List<Declarations> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Declarations>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<Declarations>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/declaration", method= RequestMethod.POST)
    @ResponseBody
	public Declarations addDeclaration(@RequestBody Declarations con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getNumero()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declaration existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public Declarations updateDeclaration(@PathVariable("id") Long id, @RequestBody Declarations con){

Optional<Declarations> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	Declarations art = optionalart.get();
        	//art.setNumero(con.getNumero());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declaration non trouvé");
		}

	}
    
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public Declarations getDeclarationById(@PathVariable("id") Long id) {

    	Optional<Declarations> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		Declarations art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "declaration non trouvé");
		}
    }
    
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDeclaration(@PathVariable("id") Long id){

    	Optional<Declarations> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Declarations art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
