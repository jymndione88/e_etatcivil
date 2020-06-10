package com.administration.etatcivil.controllers;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.lang.String;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class MailController {
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	                      
    @RequestMapping(value= "/sendmail/{mail}/{objet}/{body}")
	public ResponseEntity<?> sendMail(@PathVariable("mail") String mail, @PathVariable("objet") String objet, @PathVariable("body") String body){
    	
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);

        msg.setSubject(objet);
        msg.setText(body);

        try {
        	
        	 javaMailSender.send(msg);
        	 
        	return new ResponseEntity<Void>(HttpStatus.OK);
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @RequestMapping(value= "/sendmail/{mail}/{objet}/{body}/{attach}")
	public ResponseEntity<?> sendMailAttach(@PathVariable("mail") String mail, @PathVariable("objet") String objet, @PathVariable("body") String body, @PathVariable("attach") String attach)
			throws MessagingException, IOException {
    	System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");
    	 MimeMessage msg = javaMailSender.createMimeMessage();

         // true = multipart message
         MimeMessageHelper helper = new MimeMessageHelper(msg, true);
         helper.setTo(mail);

         helper.setSubject(objet);

         // true = text/html
         helper.setText(body, true);

         helper.addAttachment(attach, new ClassPathResource("android.png"));

        try {
        	
        	 javaMailSender.send(msg);
        	 System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        	return new ResponseEntity<Void>(HttpStatus.OK);
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} 
    }
    
    
}
