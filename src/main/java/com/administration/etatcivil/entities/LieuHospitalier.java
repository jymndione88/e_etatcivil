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
 * @author dev1202
 */
@Entity
@Table(name = "lieu_hospitalier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LieuHospitalier.findAll", query = "SELECT l FROM LieuHospitalier l"),
    @NamedQuery(name = "LieuHospitalier.findById", query = "SELECT l FROM LieuHospitalier l WHERE l.id = :id"),
    @NamedQuery(name = "LieuHospitalier.findByCode", query = "SELECT l FROM LieuHospitalier l WHERE l.code = :code"),
    @NamedQuery(name = "LieuHospitalier.findByLibelle", query = "SELECT l FROM LieuHospitalier l WHERE l.libelle = :libelle")})
public class LieuHospitalier implements Serializable {

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
    @JoinColumn(name = "id_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatCivils idEtatCivil;
    @OneToMany(mappedBy = "idLieuHospitalier")
    private List<Concernes> concernesList;

    public LieuHospitalier() {
    }

    public LieuHospitalier(Long id) {
        this.id = id;
    }

    public LieuHospitalier(Long id, String code, String libelle) {
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

    public EtatCivils getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(EtatCivils idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
    }

    @XmlTransient
    public List<Concernes> getConcernesList() {
        return concernesList;
    }

    public void setConcernesList(List<Concernes> concernesList) {
        this.concernesList = concernesList;
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
        if (!(object instanceof LieuHospitalier)) {
            return false;
        }
        LieuHospitalier other = (LieuHospitalier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.LieuHospitalier[ id=" + id + " ]";
    }
    
}