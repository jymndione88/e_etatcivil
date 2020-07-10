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
@Table(name = "demandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandes.findAll", query = "SELECT d FROM Demandes d"),
    @NamedQuery(name = "Demandes.findById", query = "SELECT d FROM Demandes d WHERE d.id = :id"),
    @NamedQuery(name = "Demandes.findByCivilite", query = "SELECT d FROM Demandes d WHERE d.civilite = :civilite"),
    @NamedQuery(name = "Demandes.findByDate", query = "SELECT d FROM Demandes d WHERE d.date = :date"),
    @NamedQuery(name = "Demandes.findByDatenaiss", query = "SELECT d FROM Demandes d WHERE d.datenaiss = :datenaiss"),
    @NamedQuery(name = "Demandes.findByEtat", query = "SELECT d FROM Demandes d WHERE d.etat = :etat"),
    @NamedQuery(name = "Demandes.findByMotif", query = "SELECT d FROM Demandes d WHERE d.motif = :motif"),
    @NamedQuery(name = "Demandes.findByNationalite", query = "SELECT d FROM Demandes d WHERE d.nationalite = :nationalite"),
    @NamedQuery(name = "Demandes.findByNatureActe", query = "SELECT d FROM Demandes d WHERE d.natureActe = :natureActe"),
    @NamedQuery(name = "Demandes.findByNbreExemplaire", query = "SELECT d FROM Demandes d WHERE d.nbreExemplaire = :nbreExemplaire"),
    @NamedQuery(name = "Demandes.findByNom", query = "SELECT d FROM Demandes d WHERE d.nom = :nom"),
    @NamedQuery(name = "Demandes.findByNumRegistre", query = "SELECT d FROM Demandes d WHERE d.numRegistre = :numRegistre"),
    @NamedQuery(name = "Demandes.findByNumero", query = "SELECT d FROM Demandes d WHERE d.numero = :numero"),
    @NamedQuery(name = "Demandes.findByPays", query = "SELECT d FROM Demandes d WHERE d.pays = :pays"),
    @NamedQuery(name = "Demandes.findByPrenom", query = "SELECT d FROM Demandes d WHERE d.prenom = :prenom"),
    @NamedQuery(name = "Demandes.findByQualiteDemandeur", query = "SELECT d FROM Demandes d WHERE d.qualiteDemandeur = :qualiteDemandeur")})
public class Demandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "civilite")
    private String civilite;
    @Lob
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @Column(name = "etat")
    private boolean etat;
    @Basic(optional = false)
    @Column(name = "motif")
    private String motif;
    @Basic(optional = false)
    @Column(name = "nationalite")
    private String nationalite;
    @Basic(optional = false)
    @Column(name = "nature_acte")
    private String natureActe;
    @Basic(optional = false)
    @Column(name = "nbre_exemplaire")
    private int nbreExemplaire;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "num_registre")
    private String numRegistre;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "pays")
    private String pays;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "qualite_demandeur")
    private String qualiteDemandeur;
    @OneToMany(mappedBy = "idDemande")
    @JsonIgnore
    private List<Livraisons> livraisonsList;
    @OneToMany(mappedBy = "idDemande")
    @JsonIgnore
    private List<Factures> facturesList;
    @JoinColumn(name = "id_deces", referencedColumnName = "id")
    @ManyToOne
    private Deces idDeces;
    @JoinColumn(name = "id_mariage", referencedColumnName = "id")
    @ManyToOne
    private Mariages idMariage;
    @JoinColumn(name = "id_naissance", referencedColumnName = "id")
    @ManyToOne
    private Naissances idNaissance;
    @JoinColumn(name = "id_officier", referencedColumnName = "id")
    @ManyToOne
    private Officiers idOfficier;

    public Demandes() {
    }

    public Demandes(Long id) {
        this.id = id;
    }

    public Demandes(Long id, String civilite, Date date, Date datenaiss, boolean etat, String motif, String nationalite, String natureActe, int nbreExemplaire, String nom, String numRegistre, String numero, String pays, String prenom, String qualiteDemandeur) {
        this.id = id;
        this.civilite = civilite;
        this.date = date;
        this.datenaiss = datenaiss;
        this.etat = etat;
        this.motif = motif;
        this.nationalite = nationalite;
        this.natureActe = natureActe;
        this.nbreExemplaire = nbreExemplaire;
        this.nom = nom;
        this.numRegistre = numRegistre;
        this.numero = numero;
        this.pays = pays;
        this.prenom = prenom;
        this.qualiteDemandeur = qualiteDemandeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNatureActe() {
        return natureActe;
    }

    public void setNatureActe(String natureActe) {
        this.natureActe = natureActe;
    }

    public int getNbreExemplaire() {
        return nbreExemplaire;
    }

    public void setNbreExemplaire(int nbreExemplaire) {
        this.nbreExemplaire = nbreExemplaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumRegistre() {
        return numRegistre;
    }

    public void setNumRegistre(String numRegistre) {
        this.numRegistre = numRegistre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getQualiteDemandeur() {
        return qualiteDemandeur;
    }

    public void setQualiteDemandeur(String qualiteDemandeur) {
        this.qualiteDemandeur = qualiteDemandeur;
    }

    @XmlTransient
    public List<Livraisons> getLivraisonsList() {
        return livraisonsList;
    }

    public void setLivraisonsList(List<Livraisons> livraisonsList) {
        this.livraisonsList = livraisonsList;
    }

    @XmlTransient
    public List<Factures> getFacturesList() {
        return facturesList;
    }

    public void setFacturesList(List<Factures> facturesList) {
        this.facturesList = facturesList;
    }

    public Deces getIdDeces() {
        return idDeces;
    }

    public void setIdDeces(Deces idDeces) {
        this.idDeces = idDeces;
    }

    public Mariages getIdMariage() {
        return idMariage;
    }

    public void setIdMariage(Mariages idMariage) {
        this.idMariage = idMariage;
    }

    public Naissances getIdNaissance() {
        return idNaissance;
    }

    public void setIdNaissance(Naissances idNaissance) {
        this.idNaissance = idNaissance;
    }

    public Officiers getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(Officiers idOfficier) {
        this.idOfficier = idOfficier;
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
        if (!(object instanceof Demandes)) {
            return false;
        }
        Demandes other = (Demandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Demandes[ id=" + id + " ]";
    }
    
}
