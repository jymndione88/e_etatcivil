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


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
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
            return new ResponseEntity<List<Mariages>>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<List<Mariages>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/mariage", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addMariage(@RequestBody Mariages con){
    	
    	metier.save(con);
 		return new ResponseEntity<>(con, HttpStatus.CREATED);
 		
    	//Si l'con n'existe pas déja
    	// if(metier.findByCode(con.getCode())!= null){
    		// metier.save(con);
    		//return new ResponseEntity<>(con, HttpStatus.CREATED);
    	//}else {
    	//	return new ResponseEntity<>("Mariage existe déjà", HttpStatus.CONFLICT);
    	//}
    	
	}
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateMariage(@PathVariable("id") Long id, @RequestBody Mariages con){
    	
Optional<Mariages> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Mariage non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 
        	Mariages art = optionalart.get();
        	art.setDate(con.getDate());
        	art.setNumero(con.getNumero());
        	art.setType(con.getType());     	
        	art.setRegime(con.getRegime());
        	art.setContrat(con.getContrat());
        	art.setNomConjoint(con.getNomConjoint());	
        	art.setPrenomConjoint(con.getPrenomConjoint());
        	art.setNomConjointe(con.getNomConjointe());
        	art.setPrenomConjointe(con.getPrenomConjointe());
        	art.setDatenaissConjoint(con.getDatenaissConjoint());
        	art.setLieunaissConjoint(con.getLieunaissConjoint());
        	art.setProfessionConjoint(con.getProfessionConjoint());
        	art.setDatenaissConjointe(con.getDatenaissConjointe());
        	art.setLieunaissConjointe(con.getLieunaissConjointe());
        	art.setProfessionConjointe(con.getProfessionConjointe());      	
        	art.setNomPereConjoint(con.getNomPereConjoint());
        	art.setNomMereConjoint(con.getNomMereConjoint());
        	art.setAdressParentConjoint(con.getAdressParentConjoint());        	
        	art.setNomPereConjointe(con.getNomPereConjointe());
        	art.setNomMereConjointe(con.getNomMereConjointe());
        	art.setAdressParentConjointe(con.getAdressParentConjointe());
        	
        	art.setIdEtatCivil(con.getIdEtatCivil());
        	art.setIdOfficier(con.getIdOfficier());
        	
        	 metier.save(art);
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
        
	}
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getMariageById(@PathVariable("id") Long id) {

    	Optional<Mariages> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Mariage non trouvé", HttpStatus.NOT_FOUND);
 
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/mariage/{id}/{num}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getMariageByDeclaration(@PathVariable("id") Long id, @PathVariable("num") String num) {

    	Optional<Mariages> optionalart = metier.findByDeclaration(num);
    	
    	if (optionalart== null){
    		return new ResponseEntity<>("Mariage non trouvé", HttpStatus.NOT_FOUND);
 
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/mariage/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteMariage(@PathVariable("id") Long id){

    	Optional<Mariages> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Mariages art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
