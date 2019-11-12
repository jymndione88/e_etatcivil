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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "etat_demandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtatDemandes.findAll", query = "SELECT e FROM EtatDemandes e"),
    @NamedQuery(name = "EtatDemandes.findById", query = "SELECT e FROM EtatDemandes e WHERE e.id = :id"),
    @NamedQuery(name = "EtatDemandes.findByEtat", query = "SELECT e FROM EtatDemandes e WHERE e.etat = :etat")})
public class EtatDemandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "etat")
    private String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtatDemande")
    private List<Demandes> demandesList;

    public EtatDemandes() {
    }

    public EtatDemandes(Long id) {
        this.id = id;
    }

    public EtatDemandes(Long id, String etat) {
        this.id = id;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Demandes> getDemandesList() {
        return demandesList;
    }

    public void setDemandesList(List<Demandes> demandesList) {
        this.demandesList = demandesList;
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
        if (!(object instanceof EtatDemandes)) {
            return false;
        }
        EtatDemandes other = (EtatDemandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.EtatDemandes[ id=" + id + " ]";
    }
    
}