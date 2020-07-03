package com.administration.etatcivil.security;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size( max = 20)
    private String login;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(max = 25)
    private String password; 
  
    @Size(max = 25)
    private String nom;
    
    @Size(max = 25)
    private String prenom;
    
    private Date datenaiss;
    
    @Size(max = 50)
    private String lieunaiss;
    
    private Integer tel;
    
	@Size(max = 50)
    private String adresse;
    
    private Integer NIN;
    
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getLieunaiss() {
		return lieunaiss;
	}

	public void setLieunaiss(String lieunaiss) {
		this.lieunaiss = lieunaiss;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getNIN() {
		return NIN;
	}

	public void setNIN(Integer nIN) {
		NIN = nIN;
	}
    
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}