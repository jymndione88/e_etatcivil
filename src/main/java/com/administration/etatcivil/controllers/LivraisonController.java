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

import com.administration.etatcivil.entities.Livraisons;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.LivraisonRepository;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class LivraisonController {

	@Autowired
	private LivraisonRepository metier;
	                      
    @RequestMapping(value= "/livraison", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Livraisons>> getListLivraison(){
    	List<Livraisons> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Livraisons>>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<List<Livraisons>>(con, HttpStatus.OK);
        }

    
	}
	
    @RequestMapping(value= "/livraison", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addLivraison(@RequestBody Livraisons con){

    	//Si l'con n'existe pas déja
    	if(metier.findByDate(con.getDate())!=null){
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("Livraison existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateLivraison(@PathVariable("id") Long id, @RequestBody Livraisons con){

Optional<Livraisons> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Livraison non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Livraisons art = optionalart.get();
        	art.setDate(con.getDate());
        	art.setAdresse(con.getAdresse());
        	art.setBoiteEmail(con.getBoiteEmail());
        	art.setBoitePostal(con.getBoitePostal());
        	art.setDescription(con.getDescription());
        	//art.setPays(con.getPays());
        	art.setIdDemande(con.getIdDemande());
        	art.setIdModeLivraison(con.getIdModeLivraison());
        	 metier.save(art);
        	 
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}

	}
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getLivraisonById(@PathVariable("id") Long id) {

    	Optional<Livraisons> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Livraison non trouvé", HttpStatus.NOT_FOUND);
    		
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
    }
    
    @RequestMapping(value= "/livraison/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteLivraison(@PathVariable("id") Long id){

    	Optional<Livraisons> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Livraisons art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
