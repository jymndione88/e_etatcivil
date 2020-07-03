package com.administration.etatcivil.controllers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.administration.etatcivil.entities.Deces;
import com.administration.etatcivil.entities.Mariages;
import com.administration.etatcivil.repositories.DecesRepository;


//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= "/api")
@RestController
public class DecesController {

	@Autowired
	private DecesRepository metier;
	                      
    @RequestMapping(value= "/deces", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
	public ResponseEntity<List<Deces>> getListDeces(){
    	List<Deces> con= metier.findAll();	

    	if (con == null || con.isEmpty()){
    		//erreur 204
            return new ResponseEntity<List<Deces>>(HttpStatus.NOT_FOUND);
        }else{
        	
        	return new ResponseEntity<List<Deces>>(con, HttpStatus.OK);
        }

    	
	}
	
    @RequestMapping(value= "/deces", method= RequestMethod.POST)
	public ResponseEntity<?> addDeces(@RequestBody Deces con){
    
    	Time t= null;
    	try {
    		DateFormat d= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        	String st= d.format(con.getHeureDeces());
        	 t= new Time(d.parse(st).getTime());
        	
		} catch (Exception e) {
			System.out.println("erreur convert: " + e.getMessage());
		}
    	
    	con.setHeureDeces(t);
    	 metier.save(con);
 		return new ResponseEntity<>(con, HttpStatus.CREATED);
 		
    	//Si l'con n'existe pas déja
    	//if(metier.findByCode(con.getCode())!= null){
    		// metier.save(con);
    		//return new ResponseEntity<>(con, HttpStatus.CREATED);
    	//}else {
    		//return new ResponseEntity<>("Deces existe déjà", HttpStatus.CONFLICT);
    	//}
    	
	}
    
    @RequestMapping(value= "/deces/{id}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateDeces(@PathVariable("id") Long id, @RequestBody Deces con){

Optional<Deces> optionalart = metier.findById(id);
    	
        if (optionalart== null){
        	 return new ResponseEntity<>("Deces non trouvé", HttpStatus.NOT_FOUND);
        	
        }else { 
        	Deces art = optionalart.get();
        	art.setNomMedecin(con.getNomMedecin());
        	art.setNomMort(con.getMotif());
        	art.setPrenomMort(con.getPrenomMort());
        	art.setDatenaiss(con.getDatenaiss());
        	art.setLieunaiss(con.getLieunaiss());;
        	art.setDateDeces(con.getDateDeces());
       
        	Time t= null;
        	try {
        		DateFormat d= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            	String st= d.format(con.getHeureDeces());
            	 t= new Time(d.parse(st).getTime());
            	
    		} catch (Exception e) {
    			System.out.println("erreur convertion: " + e.getMessage());
    		}
        	
        	art.setHeureDeces(t);
        	art.setMotif(con.getMotif());
        	art.setIdDeclaration(con.getIdDeclaration());
        	art.setIdLieuHospitalier(con.getIdLieuHospitalier());
        	metier.save(art);
        	
        	return new ResponseEntity<>(art, HttpStatus.OK);
        	
		}
    
	}
    
    @RequestMapping(value= "/deces/{id}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getDecesById(@PathVariable("id") Long id) {

    	Optional<Deces> optionalart = metier.findById(id);

    	if (optionalart== null){
    		return new ResponseEntity<>("Deces non trouvé", HttpStatus.NOT_FOUND);
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}
        
    }
    
    @RequestMapping(value= "/deces/{id}/{num}", method= RequestMethod.GET,
    		headers={"Accept=application/json"})
    @ResponseBody
    public ResponseEntity<?> getdecesByDeclaration(@PathVariable("id") Long id, @PathVariable("num") Long num) {

    	Optional<Deces> optionalart = metier.findByDeclaration(num);

    	if (optionalart== null){
    		return new ResponseEntity<>("deces non trouvé", HttpStatus.NOT_FOUND);
 
    	}else { 
    		return new ResponseEntity<>(optionalart, HttpStatus.OK);
		}

    }
  
    
    @RequestMapping(value= "/deces/{id}", method= RequestMethod.DELETE)
    @ResponseBody
   	public ResponseEntity<Void> deleteDeces(@PathVariable("id") Long id){

    	Optional<Deces> optionalart  = metier.findById(id);

        if (optionalart== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	Deces art = optionalart.get();
    		metier.delete(art);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

   	}
    
}
