package com.administration.etatcivil.signature;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfFont;
import com.spire.pdf.graphics.PdfFontFamily;
import com.spire.pdf.graphics.PdfFontStyle;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.security.GraphicMode;
import com.spire.pdf.security.PdfCertificate;
import com.spire.pdf.security.PdfCertificationFlags;
import com.spire.pdf.security.PdfSignature;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class SignatureController {
	
	public void signeFichier(String fichier) {
		
     try {
    		
    		//Load a pdf document
    		        PdfDocument doc = new PdfDocument();
    		        doc.loadFromFile(fichier);
    		
    		        //Load the certificate
    		        PdfCertificate cert = new PdfCertificate("C:\\Users\\HP\\Documents\\e_etatcivil_backend\\src\\main\\java\\com\\administration\\etatcivil\\signature\\signature.pfx", "passer");
    		
    		        //Create a PdfSignature object and specify its position and size
    	
    		        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(1), cert, "MonSignature");
    		        Rectangle2D rect = new Rectangle2D.Float();
    		        rect.setFrame(new Point2D.Float((float) doc.getPages().get(1).getActualSize().getWidth() - 320, (float) doc.getPages().get(1).getActualSize().getHeight() - 140), new Dimension(270, 100));
    		        signature.setBounds(rect);
    		
    		      //Set the graphics mode
    		        signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);
    		
    		        //Set the signature content
    		       // signature.setNameLabel("Signataire:");
    		        signature.setName("E-admnistration");
    		       // signature.setContactInfoLabel("Tel:");
    		        signature.setContactInfo("33-835-87-33");
    		       // signature.setDateLabel("Date:");
    		        signature.setDate(new java.util.Date());
    		      //  signature.setLocationInfoLabel("Location:");
    		        signature.setLocationInfo("Dakar");
    		     //   signature.setReasonLabel("Reason: ");
    		        signature.setReason("J'approuve ce document");
    		     //   signature.setDistinguishedNameLabel("DN: ");
    		        signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());
    		        signature.setSignImageSource(PdfImage.fromFile("C:\\Users\\HP\\Documents\\e_etatcivil_backend\\src\\main\\java\\com\\administration\\etatcivil\\signature\\logo1.png"));
    		       
    		        //Set the signature font
    		        signature.setSignDetailsFont(new PdfFont(PdfFontFamily.Helvetica, 10f, PdfFontStyle.Regular));
    		
    		        //Set the document permission
    		        signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);
    		        signature.setCertificated(true);
    	
    		        //Save to file
    		        doc.saveToFile("C:\\Users\\HP\\Downloads\\output.pdf");
    		        doc.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}
    
}
