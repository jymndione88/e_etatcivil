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
 * @author dev1202
 */
@Entity
@Table(name = "concernes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concernes.findAll", query = "SELECT c FROM Concernes c"),
    @NamedQuery(name = "Concernes.findById", query = "SELECT c FROM Concernes c WHERE c.id = :id"),
    @NamedQuery(name = "Concernes.findBySexe", query = "SELECT c FROM Concernes c WHERE c.sexe = :sexe"),
    @NamedQuery(name = "Concernes.findByDateDeces", query = "SELECT c FROM Concernes c WHERE c.dateDeces = :dateDeces"),
    @NamedQuery(name = "Concernes.findByAdresse", query = "SELECT c FROM Concernes c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Concernes.findByProfession", query = "SELECT c FROM Concernes c WHERE c.profession = :profession"),
    @NamedQuery(name = "Concernes.findByNomConjoint", query = "SELECT c FROM Concernes c WHERE c.nomConjoint = :nomConjoint"),
    @NamedQuery(name = "Concernes.findByPrenomConjoint", query = "SELECT c FROM Concernes c WHERE c.prenomConjoint = :prenomConjoint")})
public class Concernes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "sexe")
    private Character sexe;
    @Column(name = "date_deces")
    @Temporal(TemporalType.DATE)
    private Date dateDeces;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "profession")
    private String profession;
    @Column(name = "nom_conjoint")
    private String nomConjoint;
    @Column(name = "prenom_conjoint")
    private String prenomConjoint;
    @JoinColumn(name = "id_lieu_hospitalier", referencedColumnName = "id")
    @ManyToOne
    private LieuHospitalier idLieuHospitalier;
    @JoinColumn(name = "id_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatCivils idEtatCivil;
    @JoinColumn(name = "id_mariage", referencedColumnName = "id")
    @ManyToOne
    private Mariages idMariage;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personnes idPersonne;

    public Concernes() {
    }

    public Concernes(Long id) {
        this.id = id;
    }

    public Concernes(Long id, Character sexe, String adresse, String profession) {
        this.id = id;
        this.sexe = sexe;
        this.adresse = adresse;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNomConjoint() {
        return nomConjoint;
    }

    public void setNomConjoint(String nomConjoint) {
        this.nomConjoint = nomConjoint;
    }

    public String getPrenomConjoint() {
        return prenomConjoint;
    }

    public void setPrenomConjoint(String prenomConjoint) {
        this.prenomConjoint = prenomConjoint;
    }

    public LieuHospitalier getIdLieuHospitalier() {
        return idLieuHospitalier;
    }

    public void setIdLieuHospitalier(LieuHospitalier idLieuHospitalier) {
        this.idLieuHospitalier = idLieuHospitalier;
    }

    public EtatCivils getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(EtatCivils idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
    }

    public Mariages getIdMariage() {
        return idMariage;
    }

    public void setIdMariage(Mariages idMariage) {
        this.idMariage = idMariage;
    }

    public Personnes getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personnes idPersonne) {
        this.idPersonne = idPersonne;
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
        if (!(object instanceof Concernes)) {
            return false;
        }
        Concernes other = (Concernes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Concernes[ id=" + id + " ]";
    }
    
}
