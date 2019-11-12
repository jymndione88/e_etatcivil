/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "officiers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officiers.findAll", query = "SELECT o FROM Officiers o"),
    @NamedQuery(name = "Officiers.findById", query = "SELECT o FROM Officiers o WHERE o.id = :id")})
public class Officiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_role_officier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoleOfficiers idRoleOfficier;
    @JoinColumn(name = "id_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatCivils idEtatCivil;
    @JoinColumn(name = "id_internaute", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Internautes idInternaute;
    @OneToMany(mappedBy = "idOfficier")
    private List<Demandes> demandesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOfficier")
    private List<Declarations> declarationsList;

    public Officiers() {
    }

    public Officiers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleOfficiers getIdRoleOfficier() {
        return idRoleOfficier;
    }

    public void setIdRoleOfficier(RoleOfficiers idRoleOfficier) {
        this.idRoleOfficier = idRoleOfficier;
    }

    public EtatCivils getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(EtatCivils idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
    }

    public Internautes getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Internautes idInternaute) {
        this.idInternaute = idInternaute;
    }

    @XmlTransient
    public List<Demandes> getDemandesList() {
        return demandesList;
    }

    public void setDemandesList(List<Demandes> demandesList) {
        this.demandesList = demandesList;
    }

    @XmlTransient
    public List<Declarations> getDeclarationsList() {
        return declarationsList;
    }

    public void setDeclarationsList(List<Declarations> declarationsList) {
        this.declarationsList = declarationsList;
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
        if (!(object instanceof Officiers)) {
            return false;
        }
        Officiers other = (Officiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Officiers[ id=" + id + " ]";
    }
    
}
