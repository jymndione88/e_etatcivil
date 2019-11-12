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
 * @author dev1202
 */
@Entity
@Table(name = "demandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandes.findAll", query = "SELECT d FROM Demandes d"),
    @NamedQuery(name = "Demandes.findById", query = "SELECT d FROM Demandes d WHERE d.id = :id"),
    @NamedQuery(name = "Demandes.findByNumero", query = "SELECT d FROM Demandes d WHERE d.numero = :numero"),
    @NamedQuery(name = "Demandes.findByDate", query = "SELECT d FROM Demandes d WHERE d.date = :date"),
    @NamedQuery(name = "Demandes.findByIdDeclaration", query = "SELECT d FROM Demandes d WHERE d.idDeclaration = :idDeclaration")})
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
    @Column(name = "id_declaration")
    private long idDeclaration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Factures> facturesList;
    @JoinColumn(name = "id_internaute", referencedColumnName = "id")
    @ManyToOne
    private Internautes idInternaute;
    @JoinColumn(name = "id_etat_demande", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatDemandes idEtatDemande;
    @JoinColumn(name = "id_officier", referencedColumnName = "id")
    @ManyToOne
    private Officiers idOfficier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Livraison> livraisonList;

    public Demandes() {
    }

    public Demandes(Long id) {
        this.id = id;
    }

    public Demandes(Long id, String numero, Date date, long idDeclaration) {
        this.id = id;
        this.numero = numero;
        this.date = date;
        this.idDeclaration = idDeclaration;
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

    public long getIdDeclaration() {
        return idDeclaration;
    }

    public void setIdDeclaration(long idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    @XmlTransient
    public List<Factures> getFacturesList() {
        return facturesList;
    }

    public void setFacturesList(List<Factures> facturesList) {
        this.facturesList = facturesList;
    }

    public Internautes getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Internautes idInternaute) {
        this.idInternaute = idInternaute;
    }

    public EtatDemandes getIdEtatDemande() {
        return idEtatDemande;
    }

    public void setIdEtatDemande(EtatDemandes idEtatDemande) {
        this.idEtatDemande = idEtatDemande;
    }

    public Officiers getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(Officiers idOfficier) {
        this.idOfficier = idOfficier;
    }

    @XmlTransient
    public List<Livraison> getLivraisonList() {
        return livraisonList;
    }

    public void setLivraisonList(List<Livraison> livraisonList) {
        this.livraisonList = livraisonList;
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
