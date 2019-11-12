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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "livraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findById", query = "SELECT l FROM Livraison l WHERE l.id = :id"),
    @NamedQuery(name = "Livraison.findByDate", query = "SELECT l FROM Livraison l WHERE l.date = :date")})
public class Livraison implements Serializable {

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
    @Lob
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_mode_livraison", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModeLivraison idModeLivraison;
    @JoinColumn(name = "id_demande", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Demandes idDemande;
    @JoinColumn(name = "id_lieu", referencedColumnName = "id")
    @ManyToOne
    private LieuLivraisons idLieu;

    public Livraison() {
    }

    public Livraison(Long id) {
        this.id = id;
    }

    public Livraison(Long id, Date date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModeLivraison getIdModeLivraison() {
        return idModeLivraison;
    }

    public void setIdModeLivraison(ModeLivraison idModeLivraison) {
        this.idModeLivraison = idModeLivraison;
    }

    public Demandes getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Demandes idDemande) {
        this.idDemande = idDemande;
    }

    public LieuLivraisons getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(LieuLivraisons idLieu) {
        this.idLieu = idLieu;
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
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Livraison[ id=" + id + " ]";
    }
    
}
