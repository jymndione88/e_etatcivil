/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "communes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Communes.findAll", query = "SELECT c FROM Communes c"),
    @NamedQuery(name = "Communes.findById", query = "SELECT c FROM Communes c WHERE c.id = :id"),
    @NamedQuery(name = "Communes.findByCode", query = "SELECT c FROM Communes c WHERE c.code = :code"),
    @NamedQuery(name = "Communes.findByLibelle", query = "SELECT c FROM Communes c WHERE c.libelle = :libelle")})
public class Communes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommune")
    @JsonIgnore
    private List<EtatCivils> etatCivilsList;
    @JoinColumn(name = "id_departement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departements idDepartement;

    public Communes() {
    }

    public Communes(Long id) {
        this.id = id;
    }

    public Communes(Long id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<EtatCivils> getEtatCivilsList() {
        return etatCivilsList;
    }

    public void setEtatCivilsList(List<EtatCivils> etatCivilsList) {
        this.etatCivilsList = etatCivilsList;
    }

    public Departements getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departements idDepartement) {
        this.idDepartement = idDepartement;
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
        if (!(object instanceof Communes)) {
            return false;
        }
        Communes other = (Communes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Communes[ id=" + id + " ]";
    }
    
}
