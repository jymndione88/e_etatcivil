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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Demandes.findByNumero", query = "SELECT d FROM Demandes d WHERE d.numero = :numero"),
    @NamedQuery(name = "Demandes.findByDate", query = "SELECT d FROM Demandes d WHERE d.date = :date"),
    @NamedQuery(name = "Demandes.findByMotif", query = "SELECT d FROM Demandes d WHERE d.motif = :motif"),
    @NamedQuery(name = "Demandes.findByQualiteDemandeur", query = "SELECT d FROM Demandes d WHERE d.qualiteDemandeur = :qualiteDemandeur"),
    @NamedQuery(name = "Demandes.findByNatureActe", query = "SELECT d FROM Demandes d WHERE d.natureActe = :natureActe"),
    @NamedQuery(name = "Demandes.findByNbreExemplaire", query = "SELECT d FROM Demandes d WHERE d.nbreExemplaire = :nbreExemplaire"),
    @NamedQuery(name = "Demandes.findByCivilite", query = "SELECT d FROM Demandes d WHERE d.civilite = :civilite"),
    @NamedQuery(name = "Demandes.findByNom", query = "SELECT d FROM Demandes d WHERE d.nom = :nom"),
    @NamedQuery(name = "Demandes.findByPrenom", query = "SELECT d FROM Demandes d WHERE d.prenom = :prenom"),
    @NamedQuery(name = "Demandes.findByDatenaiss", query = "SELECT d FROM Demandes d WHERE d.datenaiss = :datenaiss"),
    @NamedQuery(name = "Demandes.findByPays", query = "SELECT d FROM Demandes d WHERE d.pays = :pays"),
    @NamedQuery(name = "Demandes.findByNationalite", query = "SELECT d FROM Demandes d WHERE d.nationalite = :nationalite")})
public class Demandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "motif")
    private String motif;
    @Basic(optional = false)
    @Column(name = "qualite_demandeur")
    private String qualiteDemandeur;
    @Basic(optional = false)
    @Column(name = "nature_acte")
    private String natureActe;
    @Basic(optional = false)
    @Column(name = "nbre_exemplaire")
    private int nbreExemplaire;
    @Basic(optional = false)
    @Column(name = "civilite")
    private String civilite;
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
    @Column(name = "pays")
    private String pays;
    @Basic(optional = false)
    @Column(name = "nationalite")
    private String nationalite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Factures> facturesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Livraisons> livraisonsList;
    @JoinColumn(name = "id_etat_demande", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatDemandes idEtatDemande;
    @JoinColumn(name = "id_commune", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Communes idCommune;
    @JoinColumn(name = "id_deces", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Deces idDeces;
    @JoinColumn(name = "id_mariage", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mariages idMariage;
    @JoinColumn(name = "id_naissance", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Naissances idNaissance;

    public Demandes() {
    }

    public Demandes(Long id) {
        this.id = id;
    }

    public Demandes(Long id, String numero, Date date, String motif, String qualiteDemandeur, String natureActe, int nbreExemplaire, String civilite, String nom, String prenom, Date datenaiss, String pays, String nationalite) {
        this.id = id;
        this.numero = numero;
        this.date = date;
        this.motif = motif;
        this.qualiteDemandeur = qualiteDemandeur;
        this.natureActe = natureActe;
        this.nbreExemplaire = nbreExemplaire;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.pays = pays;
        this.nationalite = nationalite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getQualiteDemandeur() {
        return qualiteDemandeur;
    }

    public void setQualiteDemandeur(String qualiteDemandeur) {
        this.qualiteDemandeur = qualiteDemandeur;
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

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @XmlTransient
    public List<Factures> getFacturesList() {
        return facturesList;
    }

    public void setFacturesList(List<Factures> facturesList) {
        this.facturesList = facturesList;
    }

    @XmlTransient
    public List<Livraisons> getLivraisonsList() {
        return livraisonsList;
    }

    public void setLivraisonsList(List<Livraisons> livraisonsList) {
        this.livraisonsList = livraisonsList;
    }

    public EtatDemandes getIdEtatDemande() {
        return idEtatDemande;
    }

    public void setIdEtatDemande(EtatDemandes idEtatDemande) {
        this.idEtatDemande = idEtatDemande;
    }

    public Communes getIdCommune() {
        return idCommune;
    }

    public void setIdCommune(Communes idCommune) {
        this.idCommune = idCommune;
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
