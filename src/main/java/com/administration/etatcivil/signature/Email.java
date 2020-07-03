/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.signature;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Utilisateur
 */

public class Email implements Serializable {

    private String email;
    private String objet;
    private String body;
    private String attach;

    public Email() {
    }


    public Email(String email, String objet, String body, String attach) {
        this.email = email;
        this.objet = objet;
        this.body = body;
        this.attach = attach;
    }
    
    

    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getAttach() {
		return attach;
	}


	public void setAttach(String attach) {
		this.attach = attach;
	}

    
}
