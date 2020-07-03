/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "livraisons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraisons.findAll", query = "SELECT l FROM Livraisons l"),
    @NamedQuery(name = "Livraisons.findById", query = "SELECT l FROM Livraisons l WHERE l.id = :id"),
    @NamedQuery(name = "Livraisons.findByDate", query = "SELECT l FROM Livraisons l WHERE l.date = :date"),
    @NamedQuery(name = "Livraisons.findByAdresse", query = "SELECT l FROM Livraisons l WHERE l.adresse = :adresse"),
    @NamedQuery(name = "Livraisons.findByBoiteEmail", query = "SELECT l FROM Livraisons l WHERE l.boiteEmail = :boiteEmail"),
    @NamedQuery(name = "Livraisons.findByBoitePostal", query = "SELECT l FROM Livraisons l WHERE l.boitePostal = :boitePostal"),
    @NamedQuery(name = "Livraisons.findByPays", query = "SELECT l FROM Livraisons l WHERE l.pays = :pays"),
    @NamedQuery(name = "Livraisons.findByIdDemande", query = "SELECT l FROM Livraisons l WHERE l.idDemande = :idDemande"),
    @NamedQuery(name = "Livraisons.findByIdDeclaraion", query = "SELECT l FROM Livraisons l WHERE l.idDeclaraion = :idDeclaraion"),
    @NamedQuery(name = "Livraisons.findByIdModeLivraison", query = "SELECT l FROM Livraisons l WHERE l.idModeLivraison = :idModeLivraison")})
public class Livraisons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "boite_email")
    private String boiteEmail;
    @Column(name = "boite_postal")
    private String boitePostal;
    @Column(name = "pays")
    private String pays;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "id_demande")
    private BigInteger idDemande;
    @Column(name = "id_declaraion")
    private BigInteger idDeclaraion;
    @Basic(optional = false)
    @Column(name = "id_mode_livraison")
    private long idModeLivraison;

    public Livraisons() {
    }

    public Livraisons(Long id) {
        this.id = id;
    }

    public Livraisons(Long id, long idModeLivraison) {
        this.id = id;
        this.idModeLivraison = idModeLivraison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBoiteEmail() {
        return boiteEmail;
    }

    public void setBoiteEmail(String boiteEmail) {
        this.boiteEmail = boiteEmail;
    }

    public String getBoitePostal() {
        return boitePostal;
    }

    public void setBoitePostal(String boitePostal) {
        this.boitePostal = boitePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(BigInteger idDemande) {
        this.idDemande = idDemande;
    }

    public BigInteger getIdDeclaraion() {
        return idDeclaraion;
    }

    public void setIdDeclaraion(BigInteger idDeclaraion) {
        this.idDeclaraion = idDeclaraion;
    }

    public long getIdModeLivraison() {
        return idModeLivraison;
    }

    public void setIdModeLivraison(long idModeLivraison) {
        this.idModeLivraison = idModeLivraison;
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
        if (!(object instanceof Livraisons)) {
            return false;
        }
        Livraisons other = (Livraisons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Livraisons[ id=" + id + " ]";
    }
    
}
