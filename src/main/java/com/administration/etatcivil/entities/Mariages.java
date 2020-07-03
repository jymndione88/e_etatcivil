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
    @NamedQuery(name = "Mariages.findByDate", query = "SELECT m FROM Mariages m WHERE m.date = :date"),
    @NamedQuery(name = "Mariages.findByNumero", query = "SELECT m FROM Mariages m WHERE m.numero = :numero"),
    @NamedQuery(name = "Mariages.findByType", query = "SELECT m FROM Mariages m WHERE m.type = :type"),
    @NamedQuery(name = "Mariages.findByRegime", query = "SELECT m FROM Mariages m WHERE m.regime = :regime"),
    @NamedQuery(name = "Mariages.findByContrat", query = "SELECT m FROM Mariages m WHERE m.contrat = :contrat"),
    @NamedQuery(name = "Mariages.findByNomConjoint", query = "SELECT m FROM Mariages m WHERE m.nomConjoint = :nomConjoint"),
    @NamedQuery(name = "Mariages.findByPrenomConjoint", query = "SELECT m FROM Mariages m WHERE m.prenomConjoint = :prenomConjoint"),
    @NamedQuery(name = "Mariages.findByNomConjointe", query = "SELECT m FROM Mariages m WHERE m.nomConjointe = :nomConjointe"),
    @NamedQuery(name = "Mariages.findByPrenomConjointe", query = "SELECT m FROM Mariages m WHERE m.prenomConjointe = :prenomConjointe"),
    @NamedQuery(name = "Mariages.findByDatenaissConjoint", query = "SELECT m FROM Mariages m WHERE m.datenaissConjoint = :datenaissConjoint"),
    @NamedQuery(name = "Mariages.findByLieunaissConjoint", query = "SELECT m FROM Mariages m WHERE m.lieunaissConjoint = :lieunaissConjoint"),
    @NamedQuery(name = "Mariages.findByProfessionConjoint", query = "SELECT m FROM Mariages m WHERE m.professionConjoint = :professionConjoint"),
    @NamedQuery(name = "Mariages.findByDatenaissConjointe", query = "SELECT m FROM Mariages m WHERE m.datenaissConjointe = :datenaissConjointe"),
    @NamedQuery(name = "Mariages.findByLieunaissConjointe", query = "SELECT m FROM Mariages m WHERE m.lieunaissConjointe = :lieunaissConjointe"),
    @NamedQuery(name = "Mariages.findByProfessionConjointe", query = "SELECT m FROM Mariages m WHERE m.professionConjointe = :professionConjointe"),
    @NamedQuery(name = "Mariages.findByNomPereConjoint", query = "SELECT m FROM Mariages m WHERE m.nomPereConjoint = :nomPereConjoint"),
    @NamedQuery(name = "Mariages.findByNomMereConjoint", query = "SELECT m FROM Mariages m WHERE m.nomMereConjoint = :nomMereConjoint"),
    @NamedQuery(name = "Mariages.findByAdressParentConjoint", query = "SELECT m FROM Mariages m WHERE m.adressParentConjoint = :adressParentConjoint"),
    @NamedQuery(name = "Mariages.findByNomPereConjointe", query = "SELECT m FROM Mariages m WHERE m.nomPereConjointe = :nomPereConjointe"),
    @NamedQuery(name = "Mariages.findByNomMereConjointe", query = "SELECT m FROM Mariages m WHERE m.nomMereConjointe = :nomMereConjointe"),
    @NamedQuery(name = "Mariages.findByAdressParentConjointe", query = "SELECT m FROM Mariages m WHERE m.adressParentConjointe = :adressParentConjointe"),
    @NamedQuery(name = "Mariages.findByIdOfficier", query = "SELECT m FROM Mariages m WHERE m.idOfficier = :idOfficier"),
    @NamedQuery(name = "Mariages.findByIdEtatCivil", query = "SELECT m FROM Mariages m WHERE m.idEtatCivil = :idEtatCivil")})
public class Mariages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "regime")
    private String regime;
    @Basic(optional = false)
    @Column(name = "contrat")
    private String contrat;
    @Basic(optional = false)
    @Column(name = "nom_conjoint")
    private String nomConjoint;
    @Basic(optional = false)
    @Column(name = "prenom_conjoint")
    private String prenomConjoint;
    @Basic(optional = false)
    @Column(name = "nom_conjointe")
    private String nomConjointe;
    @Basic(optional = false)
    @Column(name = "prenom_conjointe")
    private String prenomConjointe;
    @Basic(optional = false)
    @Column(name = "datenaiss_conjoint")
    @Temporal(TemporalType.DATE)
    private Date datenaissConjoint;
    @Basic(optional = false)
    @Column(name = "lieunaiss_conjoint")
    private String lieunaissConjoint;
    @Basic(optional = false)
    @Column(name = "profession_conjoint")
    private String professionConjoint;
    @Basic(optional = false)
    @Column(name = "datenaiss_conjointe")
    @Temporal(TemporalType.DATE)
    private Date datenaissConjointe;
    @Basic(optional = false)
    @Column(name = "lieunaiss_conjointe")
    private String lieunaissConjointe;
    @Basic(optional = false)
    @Column(name = "profession_conjointe")
    private String professionConjointe;
    @Basic(optional = false)
    @Column(name = "nom_pere_conjoint")
    private String nomPereConjoint;
    @Basic(optional = false)
    @Column(name = "nom_mere_conjoint")
    private String nomMereConjoint;
    @Basic(optional = false)
    @Column(name = "adress_parent_conjoint")
    private String adressParentConjoint;
    @Basic(optional = false)
    @Column(name = "nom_pere_conjointe")
    private String nomPereConjointe;
    @Basic(optional = false)
    @Column(name = "nom_mere_conjointe")
    private String nomMereConjointe;
    @Basic(optional = false)
    @Column(name = "adress_parent_conjointe")
    private String adressParentConjointe;
    @Basic(optional = false)
    @Column(name = "id_officier")
    private long idOfficier;
    @Basic(optional = false)
    @Column(name = "id_etat_civil")
    private long idEtatCivil;
    @OneToMany(mappedBy = "idMariage")
    @JsonIgnore
    private List<Demandes> demandesList;

    public Mariages() {
    }

    public Mariages(Long id) {
        this.id = id;
    }

    public Mariages(Long id, Date date, String numero, String type, String regime, String contrat, String nomConjoint, String prenomConjoint, String nomConjointe, String prenomConjointe, Date datenaissConjoint, String lieunaissConjoint, String professionConjoint, Date datenaissConjointe, String lieunaissConjointe, String professionConjointe, String nomPereConjoint, String nomMereConjoint, String adressParentConjoint, String nomPereConjointe, String nomMereConjointe, String adressParentConjointe, long idOfficier, long idEtatCivil) {
        this.id = id;
        this.date = date;
        this.numero = numero;
        this.type = type;
        this.regime = regime;
        this.contrat = contrat;
        this.nomConjoint = nomConjoint;
        this.prenomConjoint = prenomConjoint;
        this.nomConjointe = nomConjointe;
        this.prenomConjointe = prenomConjointe;
        this.datenaissConjoint = datenaissConjoint;
        this.lieunaissConjoint = lieunaissConjoint;
        this.professionConjoint = professionConjoint;
        this.datenaissConjointe = datenaissConjointe;
        this.lieunaissConjointe = lieunaissConjointe;
        this.professionConjointe = professionConjointe;
        this.nomPereConjoint = nomPereConjoint;
        this.nomMereConjoint = nomMereConjoint;
        this.adressParentConjoint = adressParentConjoint;
        this.nomPereConjointe = nomPereConjointe;
        this.nomMereConjointe = nomMereConjointe;
        this.adressParentConjointe = adressParentConjointe;
        this.idOfficier = idOfficier;
        this.idEtatCivil = idEtatCivil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
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

    public String getNomConjointe() {
        return nomConjointe;
    }

    public void setNomConjointe(String nomConjointe) {
        this.nomConjointe = nomConjointe;
    }

    public String getPrenomConjointe() {
        return prenomConjointe;
    }

    public void setPrenomConjointe(String prenomConjointe) {
        this.prenomConjointe = prenomConjointe;
    }

    public Date getDatenaissConjoint() {
        return datenaissConjoint;
    }

    public void setDatenaissConjoint(Date datenaissConjoint) {
        this.datenaissConjoint = datenaissConjoint;
    }

    public String getLieunaissConjoint() {
        return lieunaissConjoint;
    }

    public void setLieunaissConjoint(String lieunaissConjoint) {
        this.lieunaissConjoint = lieunaissConjoint;
    }

    public String getProfessionConjoint() {
        return professionConjoint;
    }

    public void setProfessionConjoint(String professionConjoint) {
        this.professionConjoint = professionConjoint;
    }

    public Date getDatenaissConjointe() {
        return datenaissConjointe;
    }

    public void setDatenaissConjointe(Date datenaissConjointe) {
        this.datenaissConjointe = datenaissConjointe;
    }

    public String getLieunaissConjointe() {
        return lieunaissConjointe;
    }

    public void setLieunaissConjointe(String lieunaissConjointe) {
        this.lieunaissConjointe = lieunaissConjointe;
    }

    public String getProfessionConjointe() {
        return professionConjointe;
    }

    public void setProfessionConjointe(String professionConjointe) {
        this.professionConjointe = professionConjointe;
    }

    public String getNomPereConjoint() {
        return nomPereConjoint;
    }

    public void setNomPereConjoint(String nomPereConjoint) {
        this.nomPereConjoint = nomPereConjoint;
    }

    public String getNomMereConjoint() {
        return nomMereConjoint;
    }

    public void setNomMereConjoint(String nomMereConjoint) {
        this.nomMereConjoint = nomMereConjoint;
    }

    public String getAdressParentConjoint() {
        return adressParentConjoint;
    }

    public void setAdressParentConjoint(String adressParentConjoint) {
        this.adressParentConjoint = adressParentConjoint;
    }

    public String getNomPereConjointe() {
        return nomPereConjointe;
    }

    public void setNomPereConjointe(String nomPereConjointe) {
        this.nomPereConjointe = nomPereConjointe;
    }

    public String getNomMereConjointe() {
        return nomMereConjointe;
    }

    public void setNomMereConjointe(String nomMereConjointe) {
        this.nomMereConjointe = nomMereConjointe;
    }

    public String getAdressParentConjointe() {
        return adressParentConjointe;
    }

    public void setAdressParentConjointe(String adressParentConjointe) {
        this.adressParentConjointe = adressParentConjointe;
    }

    public long getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(long idOfficier) {
        this.idOfficier = idOfficier;
    }

    public long getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(long idEtatCivil) {
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
