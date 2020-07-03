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
@Table(name = "deces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deces.findAll", query = "SELECT d FROM Deces d"),
    @NamedQuery(name = "Deces.findById", query = "SELECT d FROM Deces d WHERE d.id = :id"),
    @NamedQuery(name = "Deces.findByNomMedecin", query = "SELECT d FROM Deces d WHERE d.nomMedecin = :nomMedecin"),
    @NamedQuery(name = "Deces.findByNomMort", query = "SELECT d FROM Deces d WHERE d.nomMort = :nomMort"),
    @NamedQuery(name = "Deces.findByPrenomMort", query = "SELECT d FROM Deces d WHERE d.prenomMort = :prenomMort"),
    @NamedQuery(name = "Deces.findByDatenaiss", query = "SELECT d FROM Deces d WHERE d.datenaiss = :datenaiss"),
    @NamedQuery(name = "Deces.findByLieunaiss", query = "SELECT d FROM Deces d WHERE d.lieunaiss = :lieunaiss"),
    @NamedQuery(name = "Deces.findByDateDeces", query = "SELECT d FROM Deces d WHERE d.dateDeces = :dateDeces"),
    @NamedQuery(name = "Deces.findByHeureDeces", query = "SELECT d FROM Deces d WHERE d.heureDeces = :heureDeces"),
    @NamedQuery(name = "Deces.findByMotif", query = "SELECT d FROM Deces d WHERE d.motif = :motif")})
public class Deces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom_medecin")
    private String nomMedecin;
    @Basic(optional = false)
    @Column(name = "nom_mort")
    private String nomMort;
    @Basic(optional = false)
    @Column(name = "prenom_mort")
    private String prenomMort;
    @Basic(optional = false)
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Basic(optional = false)
    @Column(name = "date_deces")
    @Temporal(TemporalType.DATE)
    private Date dateDeces;
    @Basic(optional = false)
    @Column(name = "heure_deces")
    @Temporal(TemporalType.TIME)
    private Date heureDeces;
    @Column(name = "motif")
    private String motif;
    @JoinColumn(name = "id_declaration", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Declarations idDeclaration;
    @JoinColumn(name = "id_lieu_hospitalier", referencedColumnName = "id")
    @ManyToOne
    private LieuHospitalier idLieuHospitalier;
    @OneToMany(mappedBy = "idDeces")
    @JsonIgnore
    private List<Demandes> demandesList;

    public Deces() {
    }

    public Deces(Long id) {
        this.id = id;
    }

    public Deces(Long id, String nomMedecin, String nomMort, String prenomMort, Date datenaiss, String lieunaiss, Date dateDeces, Date heureDeces) {
        this.id = id;
        this.nomMedecin = nomMedecin;
        this.nomMort = nomMort;
        this.prenomMort = prenomMort;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.dateDeces = dateDeces;
        this.heureDeces = heureDeces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getNomMort() {
        return nomMort;
    }

    public void setNomMort(String nomMort) {
        this.nomMort = nomMort;
    }

    public String getPrenomMort() {
        return prenomMort;
    }

    public void setPrenomMort(String prenomMort) {
        this.prenomMort = prenomMort;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public Date getHeureDeces() {
        return heureDeces;
    }

    public void setHeureDeces(Date heureDeces) {
        this.heureDeces = heureDeces;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Declarations getIdDeclaration() {
        return idDeclaration;
    }

    public void setIdDeclaration(Declarations idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    public LieuHospitalier getIdLieuHospitalier() {
        return idLieuHospitalier;
    }

    public void setIdLieuHospitalier(LieuHospitalier idLieuHospitalier) {
        this.idLieuHospitalier = idLieuHospitalier;
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
        if (!(object instanceof Deces)) {
            return false;
        }
        Deces other = (Deces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Deces[ id=" + id + " ]";
    }
    
}
