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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "declarations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Declarations.findAll", query = "SELECT d FROM Declarations d"),
    @NamedQuery(name = "Declarations.findById", query = "SELECT d FROM Declarations d WHERE d.id = :id"),
    @NamedQuery(name = "Declarations.findByDate", query = "SELECT d FROM Declarations d WHERE d.date = :date"),
    @NamedQuery(name = "Declarations.findByNumero", query = "SELECT d FROM Declarations d WHERE d.numero = :numero"),
    @NamedQuery(name = "Declarations.findByQualiteDeclarant", query = "SELECT d FROM Declarations d WHERE d.qualiteDeclarant = :qualiteDeclarant"),
    @NamedQuery(name = "Declarations.findByStatut", query = "SELECT d FROM Declarations d WHERE d.statut = :statut")})
public class Declarations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "qualite_declarant")
    private String qualiteDeclarant;
    @Column(name = "statut")
    private Boolean statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeclaration")
    @JsonIgnore
    private List<Deces> decesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeclaration")
    @JsonIgnore
    private List<Naissances> naissancesList;
    @OneToMany(mappedBy = "idDeclaraion")
    @JsonIgnore
    private List<Livraisons> livraisonsList;
    @OneToMany(mappedBy = "idDeclaration")
    @JsonIgnore
    private List<Factures> facturesList;
    @JoinColumn(name = "id_internaute", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Internautes idInternaute;
    @JoinColumn(name = "id_officier", referencedColumnName = "id")
    @ManyToOne
    private Officiers idOfficier;

    public Declarations() {
    }

    public Declarations(Long id) {
        this.id = id;
    }

    public Declarations(Long id, Date date, String numero, String qualiteDeclarant) {
        this.id = id;
        this.date = date;
        this.numero = numero;
        this.qualiteDeclarant = qualiteDeclarant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getQualiteDeclarant() {
        return qualiteDeclarant;
    }

    public void setQualiteDeclarant(String qualiteDeclarant) {
        this.qualiteDeclarant = qualiteDeclarant;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    @XmlTransient
    public List<Deces> getDecesList() {
        return decesList;
    }

    public void setDecesList(List<Deces> decesList) {
        this.decesList = decesList;
    }

    @XmlTransient
    public List<Naissances> getNaissancesList() {
        return naissancesList;
    }

    public void setNaissancesList(List<Naissances> naissancesList) {
        this.naissancesList = naissancesList;
    }

    @XmlTransient
    public List<Livraisons> getLivraisonsList() {
        return livraisonsList;
    }

    public void setLivraisonsList(List<Livraisons> livraisonsList) {
        this.livraisonsList = livraisonsList;
    }

    @XmlTransient
    public List<Factures> getFacturesList() {
        return facturesList;
    }

    public void setFacturesList(List<Factures> facturesList) {
        this.facturesList = facturesList;
    }

    public Internautes getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Internautes idInternaute) {
        this.idInternaute = idInternaute;
    }

    public Officiers getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(Officiers idOfficier) {
        this.idOfficier = idOfficier;
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
        if (!(object instanceof Declarations)) {
            return false;
        }
        Declarations other = (Declarations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Declarations[ id=" + id + " ]";
    }
    
}
