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
@Table(name = "departements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departements.findAll", query = "SELECT d FROM Departements d"),
    @NamedQuery(name = "Departements.findById", query = "SELECT d FROM Departements d WHERE d.id = :id"),
    @NamedQuery(name = "Departements.findByCode", query = "SELECT d FROM Departements d WHERE d.code = :code"),
    @NamedQuery(name = "Departements.findByLibelle", query = "SELECT d FROM Departements d WHERE d.libelle = :libelle")})
public class Departements implements Serializable {

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
    @JoinColumn(name = "id_region", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Regions idRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartement")
    private List<Arrondissements> arrondissementsList;

    public Departements() {
    }

    public Departements(Long id) {
        this.id = id;
    }

    public Departements(Long id, String code, String libelle) {
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

    public Regions getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Regions idRegion) {
        this.idRegion = idRegion;
    }

    @XmlTransient
    public List<Arrondissements> getArrondissementsList() {
        return arrondissementsList;
    }

    public void setArrondissementsList(List<Arrondissements> arrondissementsList) {
        this.arrondissementsList = arrondissementsList;
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
        if (!(object instanceof Departements)) {
            return false;
        }
        Departements other = (Departements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Departements[ id=" + id + " ]";
    }
    
}
