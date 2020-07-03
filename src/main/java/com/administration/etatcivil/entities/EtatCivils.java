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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "etat_civils")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtatCivils.findAll", query = "SELECT e FROM EtatCivils e"),
    @NamedQuery(name = "EtatCivils.findById", query = "SELECT e FROM EtatCivils e WHERE e.id = :id"),
    @NamedQuery(name = "EtatCivils.findByCode", query = "SELECT e FROM EtatCivils e WHERE e.code = :code"),
    @NamedQuery(name = "EtatCivils.findByLibelle", query = "SELECT e FROM EtatCivils e WHERE e.libelle = :libelle")})
public class EtatCivils implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtatCivil")
    @JsonIgnore
    private List<LieuHospitalier> lieuHospitalierList;
    @JoinColumn(name = "id_commune", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Communes idCommune;
    @JoinColumn(name = "id_type_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeEtatcivil idTypeEtatCivil;

    public EtatCivils() {
    }

    public EtatCivils(Long id) {
        this.id = id;
    }

    public EtatCivils(Long id, String code, String libelle) {
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
    public List<LieuHospitalier> getLieuHospitalierList() {
        return lieuHospitalierList;
    }

    public void setLieuHospitalierList(List<LieuHospitalier> lieuHospitalierList) {
        this.lieuHospitalierList = lieuHospitalierList;
    }

    public Communes getIdCommune() {
        return idCommune;
    }

    public void setIdCommune(Communes idCommune) {
        this.idCommune = idCommune;
    }

    public TypeEtatcivil getIdTypeEtatCivil() {
        return idTypeEtatCivil;
    }

    public void setIdTypeEtatCivil(TypeEtatcivil idTypeEtatCivil) {
        this.idTypeEtatCivil = idTypeEtatCivil;
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
        if (!(object instanceof EtatCivils)) {
            return false;
        }
        EtatCivils other = (EtatCivils) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.EtatCivils[ id=" + id + " ]";
    }
    
}
