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

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "arrondissements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrondissements.findAll", query = "SELECT a FROM Arrondissements a"),
    @NamedQuery(name = "Arrondissements.findById", query = "SELECT a FROM Arrondissements a WHERE a.id = :id"),
    @NamedQuery(name = "Arrondissements.findByCode", query = "SELECT a FROM Arrondissements a WHERE a.code = :code"),
    @NamedQuery(name = "Arrondissements.findByLibelle", query = "SELECT a FROM Arrondissements a WHERE a.libelle = :libelle")})
public class Arrondissements implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArrondissement")
    private List<Communes> communesList;
    @JoinColumn(name = "id_departement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departements idDepartement;

    public Arrondissements() {
    }

    public Arrondissements(Long id) {
        this.id = id;
    }

    public Arrondissements(Long id, String code, String libelle) {
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
    public List<Communes> getCommunesList() {
        return communesList;
    }

    public void setCommunesList(List<Communes> communesList) {
        this.communesList = communesList;
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
        if (!(object instanceof Arrondissements)) {
            return false;
        }
        Arrondissements other = (Arrondissements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Arrondissements[ id=" + id + " ]";
    }
    
}
