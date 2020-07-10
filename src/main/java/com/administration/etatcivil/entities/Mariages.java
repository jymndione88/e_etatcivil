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
@Table(name = "mariages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mariages.findAll", query = "SELECT m FROM Mariages m"),
    @NamedQuery(name = "Mariages.findById", query = "SELECT m FROM Mariages m WHERE m.id = :id"),
    @NamedQuery(name = "Mariages.findByAdressParentConjoint", query = "SELECT m FROM Mariages m WHERE m.adressParentConjoint = :adressParentConjoint"),
    @NamedQuery(name = "Mariages.findByAdressParentConjointe", query = "SELECT m FROM Mariages m WHERE m.adressParentConjointe = :adressParentConjointe"),
    @NamedQuery(name = "Mariages.findByContrat", query = "SELECT m FROM Mariages m WHERE m.contrat = :contrat"),
    @NamedQuery(name = "Mariages.findByDate", query = "SELECT m FROM Mariages m WHERE m.date = :date"),
    @NamedQuery(name = "Mariages.findByDatenaissConjoint", query = "SELECT m FROM Mariages m WHERE m.datenaissConjoint = :datenaissConjoint"),
    @NamedQuery(name = "Mariages.findByDatenaissConjointe", query = "SELECT m FROM Mariages m WHERE m.datenaissConjointe = :datenaissConjointe"),
    @NamedQuery(name = "Mariages.findByLieunaissConjoint", query = "SELECT m FROM Mariages m WHERE m.lieunaissConjoint = :lieunaissConjoint"),
    @NamedQuery(name = "Mariages.findByLieunaissConjointe", query = "SELECT m FROM Mariages m WHERE m.lieunaissConjointe = :lieunaissConjointe"),
    @NamedQuery(name = "Mariages.findByNomConjoint", query = "SELECT m FROM Mariages m WHERE m.nomConjoint = :nomConjoint"),
    @NamedQuery(name = "Mariages.findByNomConjointe", query = "SELECT m FROM Mariages m WHERE m.nomConjointe = :nomConjointe"),
    @NamedQuery(name = "Mariages.findByNomMereConjoint", query = "SELECT m FROM Mariages m WHERE m.nomMereConjoint = :nomMereConjoint"),
    @NamedQuery(name = "Mariages.findByNomMereConjointe", query = "SELECT m FROM Mariages m WHERE m.nomMereConjointe = :nomMereConjointe"),
    @NamedQuery(name = "Mariages.findByNomPereConjoint", query = "SELECT m FROM Mariages m WHERE m.nomPereConjoint = :nomPereConjoint"),
    @NamedQuery(name = "Mariages.findByNomPereConjointe", query = "SELECT m FROM Mariages m WHERE m.nomPereConjointe = :nomPereConjointe"),
    @NamedQuery(name = "Mariages.findByNumero", query = "SELECT m FROM Mariages m WHERE m.numero = :numero"),
    @NamedQuery(name = "Mariages.findByPrenomConjoint", query = "SELECT m FROM Mariages m WHERE m.prenomConjoint = :prenomConjoint"),
    @NamedQuery(name = "Mariages.findByPrenomConjointe", query = "SELECT m FROM Mariages m WHERE m.prenomConjointe = :prenomConjointe"),
    @NamedQuery(name = "Mariages.findByProfessionConjoint", query = "SELECT m FROM Mariages m WHERE m.professionConjoint = :professionConjoint"),
    @NamedQuery(name = "Mariages.findByProfessionConjointe", query = "SELECT m FROM Mariages m WHERE m.professionConjointe = :professionConjointe"),
    @NamedQuery(name = "Mariages.findByRegime", query = "SELECT m FROM Mariages m WHERE m.regime = :regime"),
    @NamedQuery(name = "Mariages.findByType", query = "SELECT m FROM Mariages m WHERE m.type = :type")})
public class Mariages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "adress_parent_conjoint")
    private String adressParentConjoint;
    @Basic(optional = false)
    @Column(name = "adress_parent_conjointe")
    private String adressParentConjointe;
    @Basic(optional = false)
    @Column(name = "contrat")
    private String contrat;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "datenaiss_conjoint")
    @Temporal(TemporalType.DATE)
    private Date datenaissConjoint;
    @Basic(optional = false)
    @Column(name = "datenaiss_conjointe")
    @Temporal(TemporalType.DATE)
    private Date datenaissConjointe;
    @Basic(optional = false)
    @Column(name = "lieunaiss_conjoint")
    private String lieunaissConjoint;
    @Basic(optional = false)
    @Column(name = "lieunaiss_conjointe")
    private String lieunaissConjointe;
    @Basic(optional = false)
    @Column(name = "nom_conjoint")
    private String nomConjoint;
    @Basic(optional = false)
    @Column(name = "nom_conjointe")
    private String nomConjointe;
    @Basic(optional = false)
    @Column(name = "nom_mere_conjoint")
    private String nomMereConjoint;
    @Basic(optional = false)
    @Column(name = "nom_mere_conjointe")
    private String nomMereConjointe;
    @Basic(optional = false)
    @Column(name = "nom_pere_conjoint")
    private String nomPereConjoint;
    @Basic(optional = false)
    @Column(name = "nom_pere_conjointe")
    private String nomPereConjointe;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "prenom_conjoint")
    private String prenomConjoint;
    @Basic(optional = false)
    @Column(name = "prenom_conjointe")
    private String prenomConjointe;
    @Basic(optional = false)
    @Column(name = "profession_conjoint")
    private String professionConjoint;
    @Basic(optional = false)
    @Column(name = "profession_conjointe")
    private String professionConjointe;
    @Basic(optional = false)
    @Column(name = "regime")
    private String regime;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "id_officier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Officiers idOfficier;
    @JoinColumn(name = "id_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatCivils idEtatCivil;
    @OneToMany(mappedBy = "idMariage")
    @JsonIgnore
    private List<Demandes> demandesList;

    public Mariages() {
    }

    public Mariages(Long id) {
        this.id = id;
    }

    public Mariages(Long id, String adressParentConjoint, String adressParentConjointe, String contrat, Date date, Date datenaissConjoint, Date datenaissConjointe, String lieunaissConjoint, String lieunaissConjointe, String nomConjoint, String nomConjointe, String nomMereConjoint, String nomMereConjointe, String nomPereConjoint, String nomPereConjointe, String numero, String prenomConjoint, String prenomConjointe, String professionConjoint, String professionConjointe, String regime, String type) {
        this.id = id;
        this.adressParentConjoint = adressParentConjoint;
        this.adressParentConjointe = adressParentConjointe;
        this.contrat = contrat;
        this.date = date;
        this.datenaissConjoint = datenaissConjoint;
        this.datenaissConjointe = datenaissConjointe;
        this.lieunaissConjoint = lieunaissConjoint;
        this.lieunaissConjointe = lieunaissConjointe;
        this.nomConjoint = nomConjoint;
        this.nomConjointe = nomConjointe;
        this.nomMereConjoint = nomMereConjoint;
        this.nomMereConjointe = nomMereConjointe;
        this.nomPereConjoint = nomPereConjoint;
        this.nomPereConjointe = nomPereConjointe;
        this.numero = numero;
        this.prenomConjoint = prenomConjoint;
        this.prenomConjointe = prenomConjointe;
        this.professionConjoint = professionConjoint;
        this.professionConjointe = professionConjointe;
        this.regime = regime;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdressParentConjoint() {
        return adressParentConjoint;
    }

    public void setAdressParentConjoint(String adressParentConjoint) {
        this.adressParentConjoint = adressParentConjoint;
    }

    public String getAdressParentConjointe() {
        return adressParentConjointe;
    }

    public void setAdressParentConjointe(String adressParentConjointe) {
        this.adressParentConjointe = adressParentConjointe;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatenaissConjoint() {
        return datenaissConjoint;
    }

    public void setDatenaissConjoint(Date datenaissConjoint) {
        this.datenaissConjoint = datenaissConjoint;
    }

    public Date getDatenaissConjointe() {
        return datenaissConjointe;
    }

    public void setDatenaissConjointe(Date datenaissConjointe) {
        this.datenaissConjointe = datenaissConjointe;
    }

    public String getLieunaissConjoint() {
        return lieunaissConjoint;
    }

    public void setLieunaissConjoint(String lieunaissConjoint) {
        this.lieunaissConjoint = lieunaissConjoint;
    }

    public String getLieunaissConjointe() {
        return lieunaissConjointe;
    }

    public void setLieunaissConjointe(String lieunaissConjointe) {
        this.lieunaissConjointe = lieunaissConjointe;
    }

    public String getNomConjoint() {
        return nomConjoint;
    }

    public void setNomConjoint(String nomConjoint) {
        this.nomConjoint = nomConjoint;
    }

    public String getNomConjointe() {
        return nomConjointe;
    }

    public void setNomConjointe(String nomConjointe) {
        this.nomConjointe = nomConjointe;
    }

    public String getNomMereConjoint() {
        return nomMereConjoint;
    }

    public void setNomMereConjoint(String nomMereConjoint) {
        this.nomMereConjoint = nomMereConjoint;
    }

    public String getNomMereConjointe() {
        return nomMereConjointe;
    }

    public void setNomMereConjointe(String nomMereConjointe) {
        this.nomMereConjointe = nomMereConjointe;
    }

    public String getNomPereConjoint() {
        return nomPereConjoint;
    }

    public void setNomPereConjoint(String nomPereConjoint) {
        this.nomPereConjoint = nomPereConjoint;
    }

    public String getNomPereConjointe() {
        return nomPereConjointe;
    }

    public void setNomPereConjointe(String nomPereConjointe) {
        this.nomPereConjointe = nomPereConjointe;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrenomConjoint() {
        return prenomConjoint;
    }

    public void setPrenomConjoint(String prenomConjoint) {
        this.prenomConjoint = prenomConjoint;
    }

    public String getPrenomConjointe() {
        return prenomConjointe;
    }

    public void setPrenomConjointe(String prenomConjointe) {
        this.prenomConjointe = prenomConjointe;
    }

    public String getProfessionConjoint() {
        return professionConjoint;
    }

    public void setProfessionConjoint(String professionConjoint) {
        this.professionConjoint = professionConjoint;
    }

    public String getProfessionConjointe() {
        return professionConjointe;
    }

    public void setProfessionConjointe(String professionConjointe) {
        this.professionConjointe = professionConjointe;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Officiers getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(Officiers idOfficier) {
        this.idOfficier = idOfficier;
    }

    public EtatCivils getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(EtatCivils idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
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
        if (!(object instanceof Mariages)) {
            return false;
        }
        Mariages other = (Mariages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Mariages[ id=" + id + " ]";
    }
    
}
