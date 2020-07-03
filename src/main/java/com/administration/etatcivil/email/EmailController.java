package com.administration.etatcivil.email;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

import java.io.File;
import java.io.IOException;
import java.lang.String;

import com.administration.etatcivil.signature.Email;
import com.administration.etatcivil.signature.SignatureController;


@CrossOrigin("http://localhost:4200")
@RequestMapping(value= "/api")
@RestController
public class EmailController {
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	 
	 private SignatureController signe= new SignatureController();
	                      
    @RequestMapping(value= "/sendmail", method= RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> sendMail(@RequestBody Email email)
			throws MessagingException, IOException, InterruptedException{
    	
    	//SimpleMailMessage msg = new SimpleMailMessage();
    	
    	 MimeMessage msg = javaMailSender.createMimeMessage();

         // true = multipart message
         MimeMessageHelper helper = new MimeMessageHelper(msg, true);
         
         helper.setTo(email.getEmail());

         helper.setSentDate(new Date());
         helper.setSubject(email.getObjet());
         
         
         if(email.getAttach().equals("")) {
        	 helper.setText(email.getBody(), true);
        	 
         }else {
        	 
        	 Thread.sleep(2000);
        	 signe.signeFichier(email.getAttach()); 
        	// signe.signeFichier("C:\\Users\\HP\\Downloads\\input.pdf"); 
        	 
        	 // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(email.getBody(), "text/html");
     
            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            Thread.sleep(3000);
             //  attachment
            messageBodyPart = new MimeBodyPart();
             String filename = "C:\\Users\\HP\\Downloads\\output.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
            msg.setContent(multipart);
        	
         }
         
        try {
        	
        	 javaMailSender.send(msg);
        	 
        	 if(!email.getAttach().equals("")) {
        		 //File f= new File(email.getAttach());  
        		 File f= new File("C:\\Users\\HP\\Downloads\\input.pdf");
        		 
        		 f.delete();
        		 File f1= new File("C:\\Users\\HP\\Downloads\\output.pdf");  
        		 f1.delete();
        	 }
        	 
        	return new ResponseEntity<Void>(HttpStatus.OK);
        	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
    }
    
    
}
