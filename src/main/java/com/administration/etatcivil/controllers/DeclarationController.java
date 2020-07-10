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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.administration.etatcivil.entities.Deces;
import com.administration.etatcivil.entities.Declarations;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.DeclarationRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class DeclarationController {

	@Autowired
	private DeclarationRepository metier;
	
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Declarations>> getListDeclaration(){
    	List<Declarations> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Declarations>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Declarations>>(con, HttpStatus.OK);
        }

	}
	
   //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?>  addDeclaration(@RequestBody Declarations con){
    	
    	metier.save(con);
 		return new ResponseEntity<>(con, HttpStatus.CREATED);
 		
    	//Si l'con n'existe pas déja
    	// if(metier.findByCode(con.getCode())!= null){
    		// metier.save(con);
    		//return new ResponseEntity<>(con, HttpStatus.CREATED);
    	//}else {
    	//	return new ResponseEntity<>("Declaration existe déjà", HttpStatus.CONFLICT);
    	//}
	}
    
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateDeclaration(@PathVariable("id") Long id, @RequestBody Declarations con){

Optional<Declarations> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("declaration non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Declarations art = optionalart.get();
        	art.setNumero(con.getNumero());
        	art.setDate(con.getDate());
        	art.setQualiteDeclarant(con.getQualiteDeclarant());
        	art.setStatut(con.getStatut());
        	art.setCommentaire(con.getCommentaire());
        	art.setIdInternaute(con.getIdInternaute());
        	art.setIdOfficier(con.getIdOfficier());
        	
        	 metier.save(art);
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}

	}
    
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getDeclarationById(@PathVariable("id") Long id) {

    	Optional<Declarations> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("declaration non trouvé", HttpStatus.NOT_FOUND);
            
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration/{id}/{numero}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getDeclarationByNum(@PathVariable("id") Long id, @PathVariable("numero") String numero) {
    	
    	Optional<Declarations> optionalart = metier.findByNum(numero);

    	if (optionalart== null){
    		return new ResponseEntity<>("declaration non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
        
    }
    
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value= "/declaration/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDeclaration(@PathVariable("id") Long id){

    	Optional<Declarations> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Declarations art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
