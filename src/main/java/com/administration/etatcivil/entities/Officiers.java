/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Entity
@Table(name = "officiers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officiers.findAll", query = "SELECT o FROM Officiers o"),
    @NamedQuery(name = "Officiers.findById", query = "SELECT o FROM Officiers o WHERE o.id = :id"),
    @NamedQuery(name = "Officiers.findByIdInternaute", query = "SELECT o FROM Officiers o WHERE o.idInternaute = :idInternaute"),
    @NamedQuery(name = "Officiers.findByIdEtatCivil", query = "SELECT o FROM Officiers o WHERE o.idEtatCivil = :idEtatCivil"),
    @NamedQuery(name = "Officiers.findByIdRoleOfficier", query = "SELECT o FROM Officiers o WHERE o.idRoleOfficier = :idRoleOfficier")})
public class Officiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "id_internaute")
    private long idInternaute;
    @Basic(optional = false)
    @Column(name = "id_etat_civil")
    private long idEtatCivil;
    @Basic(optional = false)
    @Column(name = "id_role_officier")
    private long idRoleOfficier;
    @OneToMany(mappedBy = "idOfficier")
    @JsonIgnore
    private List<Demandes> demandesList;
    @OneToMany(mappedBy = "idOfficier")
    @JsonIgnore
    private List<Declarations> declarationsList;

    public Officiers() {
    }

    public Officiers(Long id) {
        this.id = id;
    }

    public Officiers(Long id, long idInternaute, long idEtatCivil, long idRoleOfficier) {
        this.id = id;
        this.idInternaute = idInternaute;
        this.idEtatCivil = idEtatCivil;
        this.idRoleOfficier = idRoleOfficier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(long idInternaute) {
        this.idInternaute = idInternaute;
    }

    public long getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(long idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
    }

    public long getIdRoleOfficier() {
        return idRoleOfficier;
    }

    public void setIdRoleOfficier(long idRoleOfficier) {
        this.idRoleOfficier = idRoleOfficier;
    }

    @XmlTransient
    public List<Demandes> getDemandesList() {
        return demandesList;
    }

    public void setDemandesList(List<Demandes> demandesList) {
        this.demandesList = demandesList;
    }

    @XmlTransient
    public List<Declarations> getDeclarationsList() {
        return declarationsList;
    }

    public void setDeclarationsList(List<Declarations> declarationsList) {
        this.declarationsList = declarationsList;
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
        if (!(object instanceof Officiers)) {
            return false;
        }
        Officiers other = (Officiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Officiers[ id=" + id + " ]";
    }
    
}
