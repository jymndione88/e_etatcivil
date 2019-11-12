/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "personnes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnes.findAll", query = "SELECT p FROM Personnes p"),
    @NamedQuery(name = "Personnes.findById", query = "SELECT p FROM Personnes p WHERE p.id = :id"),
    @NamedQuery(name = "Personnes.findByNom", query = "SELECT p FROM Personnes p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnes.findByPrenom", query = "SELECT p FROM Personnes p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personnes.findByDatenaiss", query = "SELECT p FROM Personnes p WHERE p.datenaiss = :datenaiss"),
    @NamedQuery(name = "Personnes.findByLieunaiss", query = "SELECT p FROM Personnes p WHERE p.lieunaiss = :lieunaiss"),
    @NamedQuery(name = "Personnes.findByTel", query = "SELECT p FROM Personnes p WHERE p.tel = :tel"),
    @NamedQuery(name = "Personnes.findByAdresse", query = "SELECT p FROM Personnes p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personnes.findByNin", query = "SELECT p FROM Personnes p WHERE p.nin = :nin")})
public class Personnes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "NIN")
    private int nin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private List<Internautes> internautesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private List<Concernes> concernesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private List<Parents> parentsList;

    public Personnes() {
    }

    public Personnes(Long id) {
        this.id = id;
    }

    public Personnes(Long id, String nom, String prenom, Date datenaiss, String lieunaiss, String adresse, int nin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.adresse = adresse;
        this.nin = nin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNin() {
        return nin;
    }

    public void setNin(int nin) {
        this.nin = nin;
    }

    @XmlTransient
    public List<Internautes> getInternautesList() {
        return internautesList;
    }

    public void setInternautesList(List<Internautes> internautesList) {
        this.internautesList = internautesList;
    }

    @XmlTransient
    public List<Concernes> getConcernesList() {
        return concernesList;
    }

    public void setConcernesList(List<Concernes> concernesList) {
        this.concernesList = concernesList;
    }

    @XmlTransient
    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
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
        if (!(object instanceof Personnes)) {
            return false;
        }
        Personnes other = (Personnes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Personnes[ id=" + id + " ]";
    }
    
}