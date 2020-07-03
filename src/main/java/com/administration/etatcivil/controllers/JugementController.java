package com.administration.etatcivil.controllers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

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

import com.administration.etatcivil.entities.Jugements;
import com.administration.etatcivil.entities.TypeEtatcivil;
import com.administration.etatcivil.repositories.JugementRepository;

//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class JugementController {

	@Autowired
	private JugementRepository metier;
	                      
    @RequestMapping(value= "/jugement", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Jugements>> getListJugement(){
    	List<Jugements> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Jugements>>(HttpStatus.NOT_FOUND);
        }else{

        	return new ResponseEntity<List<Jugements>>(con, HttpStatus.OK);
        }

	}
	
    @RequestMapping(value= "/jugement", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> addJugement(@RequestBody Jugements con){

    	//Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
    	//cal.setTime(con.getAnnee());
    	//int year = cal.get(Calendar.YEAR);
    	
    		 metier.save(con);
    		 return new ResponseEntity<>(con, HttpStatus.CREATED);
    	
	}
    
    @RequestMapping(value= "/jugement/{id}", method= RequestMethod.PUT)
    @ResponseBody
	public ResponseEntity<?> updateJugement(@PathVariable("id") Long id, @RequestBody Jugements con){

Optional<Jugements> optionalart = metier.findById(id);
    	
        if (optionalart== null){
          	 return new ResponseEntity<>("Jugement non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 

        	Jugements art = optionalart.get();
        	art.setNumero(con.getNumero());
        	//art.setAnnee(con.getAnnee());
        	art.setDate(con.getDate());
        	art.setLieu(con.getLieu()); 	
        	art.setPieceJointe(con.getPieceJointe());
        	
        	 metier.save(art);
        	 
        	 return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}

	}
    
    @RequestMapping(value= "/jugement/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getJugementById(@PathVariable("id") Long id) {

    	Optional<Jugements> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Jugement non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
			
			return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
    
    @RequestMapping(value= "/jugement/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteJugement(@PathVariable("id") Long id){

    	Optional<Jugements> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Jugements art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
   	}
    
}
