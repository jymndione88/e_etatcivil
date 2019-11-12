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

import com.administration.etatcivil.entities.TypeCommunes;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.TypeCommuneRepository;

@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class TypeCommuneController {

	@Autowired
	private TypeCommuneRepository metier;
	                      
    @RequestMapping(value= "/typecommune", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<TypeCommunes>> getListTypeCommune(){
    	List<TypeCommunes> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<TypeCommunes>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<TypeCommunes>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/typecommune", method= RequestMethod.POST)
    @ResponseBody
	public TypeCommunes addTypeCommune(@RequestBody TypeCommunes con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getType()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeCommune existe déjà");
    	//}
    	return null;

	}
    
    @RequestMapping(value= "/typecommune/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public TypeCommunes updateTypeCommune(@PathVariable("id") Long id, @RequestBody TypeCommunes con){

Optional<TypeCommunes> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	TypeCommunes art = optionalart.get();
        	art.setType(con.getType());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeCommune non trouvé");
		}
      
	}
    
    @RequestMapping(value= "/typecommune/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public TypeCommunes getTypeCommuneById(@PathVariable("id") Long id) {

    	Optional<TypeCommunes> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		TypeCommunes art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeCommune non trouvé");
		}

    }
    
    @RequestMapping(value= "/typecommune/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteTypeCommune(@PathVariable("id") Long id){

    	Optional<TypeCommunes> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	TypeCommunes art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
