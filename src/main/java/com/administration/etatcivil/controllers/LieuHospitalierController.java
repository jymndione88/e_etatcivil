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


@CrossOrigin("http://localhost:4200")
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
            return new ResponseEntity<List<LieuHospitalier>>(HttpStatus.NO_CONTENT);
        }else{

        	return new ResponseEntity<List<LieuHospitalier>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/lieuhospitalier", method= RequestMethod.POST)
    @ResponseBody
	public LieuHospitalier addLieuHospitalier(@RequestBody LieuHospitalier con, HttpServletResponse response){

    	//Si l'con n'existe pas déja
    	//if(!metier.findByNumero(con.getCode()).isPresent()){
    		//return metier.save(con);
    	//}else {
    		//throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuHospitalier existe déjà");
    	//}
    	return null;
	}
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public LieuHospitalier updateLieuHospitalier(@PathVariable("id") Long id, @RequestBody LieuHospitalier con){

Optional<LieuHospitalier> optionalart = metier.findById(id);
    	
        if (optionalart.isPresent()){
        	
        	LieuHospitalier art = optionalart.get();
        	art.setCode(con.getCode());
        	return metier.save(art);
        	
        }else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuHospitalier non trouvé");
		}
	}
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public LieuHospitalier getLieuHospitalierById(@PathVariable("id") Long id) {

    	Optional<LieuHospitalier> optionalart = metier.findById(id);

    	if (optionalart.isPresent()){
            
    		LieuHospitalier art = optionalart.get();
    		return art;
    	}else { 
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "LieuHospitalier non trouvé");
		}

    }
    
    @RequestMapping(value= "/lieuhospitalier/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteLieuHospitalier(@PathVariable("id") Long id){


    	Optional<LieuHospitalier> optionalart  = metier.findById(id);

        if (!optionalart.isPresent()){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	LieuHospitalier art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
