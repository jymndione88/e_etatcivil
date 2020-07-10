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
@Table(name = "factures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factures.findAll", query = "SELECT f FROM Factures f"),
    @NamedQuery(name = "Factures.findById", query = "SELECT f FROM Factures f WHERE f.id = :id"),
    @NamedQuery(name = "Factures.findByDate", query = "SELECT f FROM Factures f WHERE f.date = :date"),
    @NamedQuery(name = "Factures.findByEtat", query = "SELECT f FROM Factures f WHERE f.etat = :etat"),
    @NamedQuery(name = "Factures.findByMontant", query = "SELECT f FROM Factures f WHERE f.montant = :montant"),
    @NamedQuery(name = "Factures.findByRemise", query = "SELECT f FROM Factures f WHERE f.remise = :remise"),
    @NamedQuery(name = "Factures.findByTva", query = "SELECT f FROM Factures f WHERE f.tva = :tva")})
public class Factures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "etat")
    private boolean etat;
    @Basic(optional = false)
    @Column(name = "montant")
    private double montant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "remise")
    private Float remise;
    @Column(name = "tva")
    private Float tva;
    @JoinColumn(name = "id_demande", referencedColumnName = "id")
    @ManyToOne
    private Demandes idDemande;
    @JoinColumn(name = "id_declaration", referencedColumnName = "id")
    @ManyToOne
    private Declarations idDeclaration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacture")
    @JsonIgnore
    private List<Paiements> paiementsList;

    public Factures() {
    }

    public Factures(Long id) {
        this.id = id;
    }

    public Factures(Long id, Date date, boolean etat, double montant) {
        this.id = id;
        this.date = date;
        this.etat = etat;
        this.montant = montant;
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

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Float getRemise() {
        return remise;
    }

    public void setRemise(Float remise) {
        this.remise = remise;
    }

    public Float getTva() {
        return tva;
    }

    public void setTva(Float tva) {
        this.tva = tva;
    }

    public Demandes getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Demandes idDemande) {
        this.idDemande = idDemande;
    }

    public Declarations getIdDeclaration() {
        return idDeclaration;
    }

    public void setIdDeclaration(Declarations idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    @XmlTransient
    public List<Paiements> getPaiementsList() {
        return paiementsList;
    }

    public void setPaiementsList(List<Paiements> paiementsList) {
        this.paiementsList = paiementsList;
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
        if (!(object instanceof Factures)) {
            return false;
        }
        Factures other = (Factures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Factures[ id=" + id + " ]";
    }
    
}
