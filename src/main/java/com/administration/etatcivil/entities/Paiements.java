/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paiements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiements.findAll", query = "SELECT p FROM Paiements p"),
    @NamedQuery(name = "Paiements.findById", query = "SELECT p FROM Paiements p WHERE p.id = :id"),
    @NamedQuery(name = "Paiements.findByDate", query = "SELECT p FROM Paiements p WHERE p.date = :date"),
    @NamedQuery(name = "Paiements.findByMontant", query = "SELECT p FROM Paiements p WHERE p.montant = :montant")})
public class Paiements implements Serializable {

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
    @Column(name = "montant")
    private double montant;
    @JoinColumn(name = "id_facture", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factures idFacture;
    @JoinColumn(name = "id_mode_paiement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModePaiements idModePaiement;

    public Paiements() {
    }

    public Paiements(Long id) {
        this.id = id;
    }

    public Paiements(Long id, Date date, double montant) {
        this.id = id;
        this.date = date;
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Factures getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Factures idFacture) {
        this.idFacture = idFacture;
    }

    public ModePaiements getIdModePaiement() {
        return idModePaiement;
    }

    public void setIdModePaiement(ModePaiements idModePaiement) {
        this.idModePaiement = idModePaiement;
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
        if (!(object instanceof Paiements)) {
            return false;
        }
        Paiements other = (Paiements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Paiements[ id=" + id + " ]";
    }
    
}
