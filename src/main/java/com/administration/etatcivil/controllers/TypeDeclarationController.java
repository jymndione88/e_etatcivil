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

import com.administration.etatcivil.entities.TypeDeclarations;
import com.administration.etatcivil.repositories.TypeDeclarationRepository;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class TypeDeclarationController {

	@Autowired
	private TypeDeclarationRepository metier;
	                      
    @RequestMapping(value= "/typedeclaration", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<TypeDeclarations>> getListTypeDeclaration(){
    	List<TypeDeclarations> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<TypeDeclarations>>(HttpStatus.NO_CONTENT);
        }else{
        	
        	return new ResponseEntity<List<TypeDeclarations>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/typedeclaration", method= RequestMethod.POST)
    @ResponseBody
	public TypeDeclarations addTypeDeclaration(@RequestBody TypeDeclarations con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getType()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeDeclarations existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/typedeclaration/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public TypeDeclarations updateTypeDeclaration(@PathVariable("id") Long id, @RequestBody TypeDeclarations con){

Optional<TypeDeclarations> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	TypeDeclarations art = optionalart.get();
        	art.setType(con.getType());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeDeclaration non trouvé");
		}
    
	}
    
    @RequestMapping(value= "/typedeclaration/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public TypeDeclarations getTypeDeclarationById(@PathVariable("id") Long id) {

    	Optional<TypeDeclarations> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		TypeDeclarations art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "TypeDeclaration non trouvé");
		}
        
    }
    
    @RequestMapping(value= "/typedeclaration/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteTypeDeclaration(@PathVariable("id") Long id){

    	Optional<TypeDeclarations> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	TypeDeclarations art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
