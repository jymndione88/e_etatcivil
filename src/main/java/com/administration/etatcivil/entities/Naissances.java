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
import javax.persistence.Lob;
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
@Table(name = "naissances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naissances.findAll", query = "SELECT n FROM Naissances n"),
    @NamedQuery(name = "Naissances.findById", query = "SELECT n FROM Naissances n WHERE n.id = :id"),
    @NamedQuery(name = "Naissances.findByDatenaiss", query = "SELECT n FROM Naissances n WHERE n.datenaiss = :datenaiss"),
    @NamedQuery(name = "Naissances.findByGenre", query = "SELECT n FROM Naissances n WHERE n.genre = :genre"),
    @NamedQuery(name = "Naissances.findByHeurenaiss", query = "SELECT n FROM Naissances n WHERE n.heurenaiss = :heurenaiss"),
    @NamedQuery(name = "Naissances.findByNom", query = "SELECT n FROM Naissances n WHERE n.nom = :nom"),
    @NamedQuery(name = "Naissances.findByNomMere", query = "SELECT n FROM Naissances n WHERE n.nomMere = :nomMere"),
    @NamedQuery(name = "Naissances.findByNomPere", query = "SELECT n FROM Naissances n WHERE n.nomPere = :nomPere"),
    @NamedQuery(name = "Naissances.findByPrenom", query = "SELECT n FROM Naissances n WHERE n.prenom = :prenom"),
    @NamedQuery(name = "Naissances.findByPrenomMere", query = "SELECT n FROM Naissances n WHERE n.prenomMere = :prenomMere"),
    @NamedQuery(name = "Naissances.findByPrenomPere", query = "SELECT n FROM Naissances n WHERE n.prenomPere = :prenomPere")})
public class Naissances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @Column(name = "genre")
    private Character genre;
    @Basic(optional = false)
    @Column(name = "heurenaiss")
    @Temporal(TemporalType.TIME)
    private Date heurenaiss;
    @Lob
    @Column(name = "mention_marginal")
    private String mentionMarginal;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "nom_mere")
    private String nomMere;
    @Basic(optional = false)
    @Column(name = "nom_pere")
    private String nomPere;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "prenom_mere")
    private String prenomMere;
    @Basic(optional = false)
    @Column(name = "prenom_pere")
    private String prenomPere;
    @JoinColumn(name = "id_declaration", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Declarations idDeclaration;
    @JoinColumn(name = "id_lieu_hospitalier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LieuHospitalier idLieuHospitalier;
    @JoinColumn(name = "id_jugement", referencedColumnName = "id")
    @ManyToOne
    private Jugements idJugement;
    @OneToMany(mappedBy = "idNaissance")
    @JsonIgnore
    private List<Demandes> demandesList;

    public Naissances() {
    }

    public Naissances(Long id) {
        this.id = id;
    }

    public Naissances(Long id, Date datenaiss, Character genre, Date heurenaiss, String nom, String nomMere, String nomPere, String prenom, String prenomMere, String prenomPere) {
        this.id = id;
        this.datenaiss = datenaiss;
        this.genre = genre;
        this.heurenaiss = heurenaiss;
        this.nom = nom;
        this.nomMere = nomMere;
        this.nomPere = nomPere;
        this.prenom = prenom;
        this.prenomMere = prenomMere;
        this.prenomPere = prenomPere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Character getGenre() {
        return genre;
    }

    public void setGenre(Character genre) {
        this.genre = genre;
    }

    public Date getHeurenaiss() {
        return heurenaiss;
    }

    public void setHeurenaiss(Date heurenaiss) {
        this.heurenaiss = heurenaiss;
    }

    public String getMentionMarginal() {
        return mentionMarginal;
    }

    public void setMentionMarginal(String mentionMarginal) {
        this.mentionMarginal = mentionMarginal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
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

    public Jugements getIdJugement() {
        return idJugement;
    }

    public void setIdJugement(Jugements idJugement) {
        this.idJugement = idJugement;
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
