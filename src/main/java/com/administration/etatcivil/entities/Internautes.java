/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name = "internautes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Internautes.findAll", query = "SELECT i FROM Internautes i"),
    @NamedQuery(name = "Internautes.findById", query = "SELECT i FROM Internautes i WHERE i.id = :id"),
    @NamedQuery(name = "Internautes.findByLogin", query = "SELECT i FROM Internautes i WHERE i.login = :login"),
    @NamedQuery(name = "Internautes.findByEmail", query = "SELECT i FROM Internautes i WHERE i.email = :email"),
    @NamedQuery(name = "Internautes.findByPassword", query = "SELECT i FROM Internautes i WHERE i.password = :password"),
    @NamedQuery(name = "Internautes.findByResetPassword", query = "SELECT i FROM Internautes i WHERE i.resetPassword = :resetPassword"),
    @NamedQuery(name = "Internautes.findByActive", query = "SELECT i FROM Internautes i WHERE i.active = :active")})
public class Internautes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "reset_password")
    private String resetPassword;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personnes idPersonne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInternaute")
    @JsonIgnore
    private List<InternauteRoles> internauteRolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInternaute")
    @JsonIgnore
    private List<Declarations> declarationsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInternaute")
    @JsonIgnore
    private List<Officiers> officiersList;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "internaute_roles",
            joinColumns = @JoinColumn(name = "id_internaute", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName="id"))
    private Set<Roles> roles;

    public Internautes() {
    }

    public Internautes(Long id) {
        this.id = id;
    }

    public Internautes(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
    
    public Internautes(Long id, String login, String email, String password, String resetPassword, boolean active) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.resetPassword = resetPassword;
        this.active = active;
    }
    
    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
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

    public String getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(String resetPassword) {
        this.resetPassword = resetPassword;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Personnes getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personnes idPersonne) {
        this.idPersonne = idPersonne;
    }

    @XmlTransient
    public List<InternauteRoles> getInternauteRolesList() {
        return internauteRolesList;
    }

    public void setInternauteRolesList(List<InternauteRoles> internauteRolesList) {
        this.internauteRolesList = internauteRolesList;
    }

    @XmlTransient
    public List<Declarations> getDeclarationsList() {
        return declarationsList;
    }

    public void setDeclarationsList(List<Declarations> declarationsList) {
        this.declarationsList = declarationsList;
    }

    @XmlTransient
    public List<Officiers> getOfficiersList() {
        return officiersList;
    }

    public void setOfficiersList(List<Officiers> officiersList) {
        this.officiersList = officiersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internautes)) {
            return false;
        }
        Internautes other = (Internautes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Internautes[ id=" + id + " ]";
    }
    
}
