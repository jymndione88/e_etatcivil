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

import com.administration.etatcivil.entities.LieuHospitalier;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.LieuHospitalierRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class LieuHospitalierController {

	@Autowired
	private LieuHospitalierRepository metier;
	
    @RequestMapping(value= "/lieuhospitalier", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<LieuHospitalier>> getListLieuHospitalier(){
    	List<LieuHospitalier> con= metier.findAll();	
    	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<LieuHospitalier>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<LieuHospitalier>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/lieuhospitalier", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addLieuHospitalier(@RequestBody LieuHospitalier con){

    	//Si l'con n'existe pas déja
    	if(metier.findByCode(con.getCode())!= null){
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	}else {
    		
    		return new ResponseEntity<>("LieuHospitalier existe déjà", HttpStatus.CONFLICT);
    	}
    	
	}
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateLieuHospitalier(@PathVariable("id") Long id, @RequestBody LieuHospitalier con){

Optional<LieuHospitalier> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("LieuHospitalier non trouvé", HttpStatus.NOT_FOUND);
        	
        	
        }else { 
        	LieuHospitalier art = optionalart.get();
        	art.setCode(con.getCode());
        	art.setLibelle(con.getLibelle());
        	
        	 metier.save(art);
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
	}
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getLieuHospitalierById(@PathVariable("id") Long id) {

    	Optional<LieuHospitalier> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("LieuHospitalier non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
		
			return new ResponseEntity<>(optionalart, HttpStatus.OK);
    	}

    }
    
    @RequestMapping(value= "/lieuhospitalier/{id}/{libelle}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getLieuHospitalierByLibelle(@PathVariable("id") Long id, @PathVariable("libelle") String libelle) {

    	Optional<LieuHospitalier> optionalart = metier.findByLibelle(libelle);

    	if (optionalart== null){
    		return new ResponseEntity<>("LieuHospitalier non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
		
			return new ResponseEntity<>(optionalart, HttpStatus.OK);
    	}

    }
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteLieuHospitalier(@PathVariable("id") Long id){


    	Optional<LieuHospitalier> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	LieuHospitalier art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
