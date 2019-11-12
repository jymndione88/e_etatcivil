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

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "lieu_livraisons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LieuLivraisons.findAll", query = "SELECT l FROM LieuLivraisons l"),
    @NamedQuery(name = "LieuLivraisons.findById", query = "SELECT l FROM LieuLivraisons l WHERE l.id = :id"),
    @NamedQuery(name = "LieuLivraisons.findByAdresse", query = "SELECT l FROM LieuLivraisons l WHERE l.adresse = :adresse")})
public class LieuLivraisons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @OneToMany(mappedBy = "idLieu")
    private List<Livraison> livraisonList;

    public LieuLivraisons() {
    }

    public LieuLivraisons(Long id) {
        this.id = id;
    }

    public LieuLivraisons(Long id, String adresse) {
        this.id = id;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlTransient
    public List<Livraison> getLivraisonList() {
        return livraisonList;
    }

    public void setLivraisonList(List<Livraison> livraisonList) {
        this.livraisonList = livraisonList;
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
        if (!(object instanceof LieuLivraisons)) {
            return false;
        }
        LieuLivraisons other = (LieuLivraisons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.LieuLivraisons[ id=" + id + " ]";
    }
    
}
