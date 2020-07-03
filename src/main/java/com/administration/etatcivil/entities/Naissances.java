/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "naissances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naissances.findAll", query = "SELECT n FROM Naissances n"),
    @NamedQuery(name = "Naissances.findById", query = "SELECT n FROM Naissances n WHERE n.id = :id"),
    @NamedQuery(name = "Naissances.findByGenre", query = "SELECT n FROM Naissances n WHERE n.genre = :genre"),
    @NamedQuery(name = "Naissances.findByNom", query = "SELECT n FROM Naissances n WHERE n.nom = :nom"),
    @NamedQuery(name = "Naissances.findByPrenom", query = "SELECT n FROM Naissances n WHERE n.prenom = :prenom"),
    @NamedQuery(name = "Naissances.findByDatenaiss", query = "SELECT n FROM Naissances n WHERE n.datenaiss = :datenaiss"),
    @NamedQuery(name = "Naissances.findByHeurenaiss", query = "SELECT n FROM Naissances n WHERE n.heurenaiss = :heurenaiss"),
    @NamedQuery(name = "Naissances.findByNomPere", query = "SELECT n FROM Naissances n WHERE n.nomPere = :nomPere"),
    @NamedQuery(name = "Naissances.findByPrenomPere", query = "SELECT n FROM Naissances n WHERE n.prenomPere = :prenomPere"),
    @NamedQuery(name = "Naissances.findByNomMere", query = "SELECT n FROM Naissances n WHERE n.nomMere = :nomMere"),
    @NamedQuery(name = "Naissances.findByPrenomMere", query = "SELECT n FROM Naissances n WHERE n.prenomMere = :prenomMere"),
    @NamedQuery(name = "Naissances.findByIdJugement", query = "SELECT n FROM Naissances n WHERE n.idJugement = :idJugement"),
    @NamedQuery(name = "Naissances.findByIdDeclaration", query = "SELECT n FROM Naissances n WHERE n.idDeclaration = :idDeclaration"),
    @NamedQuery(name = "Naissances.findByIdLieuHospitalier", query = "SELECT n FROM Naissances n WHERE n.idLieuHospitalier = :idLieuHospitalier"),
    @NamedQuery(name = "Naissances.findByLieunaiss", query = "SELECT n FROM Naissances n WHERE n.lieunaiss = :lieunaiss")})
public class Naissances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "genre")
    private Character genre;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @Column(name = "heurenaiss")
    @Temporal(TemporalType.TIME)
    private Date heurenaiss;
    @Basic(optional = false)
    @Column(name = "nom_pere")
    private String nomPere;
    @Basic(optional = false)
    @Column(name = "prenom_pere")
    private String prenomPere;
    @Basic(optional = false)
    @Column(name = "nom_mere")
    private String nomMere;
    @Basic(optional = false)
    @Column(name = "prenom_mere")
    private String prenomMere;
    @Lob
    @Column(name = "mention_marginal")
    private String mentionMarginal;
    @Column(name = "id_jugement")
    private BigInteger idJugement;
    @Basic(optional = false)
    @Column(name = "id_declaration")
    private long idDeclaration;
    @Basic(optional = false)
    @Column(name = "id_lieu_hospitalier")
    private long idLieuHospitalier;
    @Basic(optional = false)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @OneToMany(mappedBy = "idNaissance")
    @JsonIgnore
    private List<Demandes> demandesList;

    public Naissances() {
    }

    public Naissances(Long id) {
        this.id = id;
    }

    public Naissances(Long id, Character genre, String nom, String prenom, Date datenaiss, Date heurenaiss, String nomPere, String prenomPere, String nomMere, String prenomMere, long idDeclaration, long idLieuHospitalier, String lieunaiss) {
        this.id = id;
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.heurenaiss = heurenaiss;
        this.nomPere = nomPere;
        this.prenomPere = prenomPere;
        this.nomMere = nomMere;
        this.prenomMere = prenomMere;
        this.idDeclaration = idDeclaration;
        this.idLieuHospitalier = idLieuHospitalier;
        this.lieunaiss = lieunaiss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getGenre() {
        return genre;
    }

    public void setGenre(Character genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Date getHeurenaiss() {
        return heurenaiss;
    }

    public void setHeurenaiss(Date heurenaiss) {
        this.heurenaiss = heurenaiss;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getMentionMarginal() {
        return mentionMarginal;
    }

    public void setMentionMarginal(String mentionMarginal) {
        this.mentionMarginal = mentionMarginal;
    }

    public BigInteger getIdJugement() {
        return idJugement;
    }

    public void setIdJugement(BigInteger idJugement) {
        this.idJugement = idJugement;
    }

    public long getIdDeclaration() {
        return idDeclaration;
    }

    public void setIdDeclaration(long idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    public long getIdLieuHospitalier() {
        return idLieuHospitalier;
    }

    public void setIdLieuHospitalier(long idLieuHospitalier) {
        this.idLieuHospitalier = idLieuHospitalier;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
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
        if (!(object instanceof Naissances)) {
            return false;
        }
        Naissances other = (Naissances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Naissances[ id=" + id + " ]";
    }
    
}
