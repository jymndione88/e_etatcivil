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

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "mariages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mariages.findAll", query = "SELECT m FROM Mariages m"),
    @NamedQuery(name = "Mariages.findById", query = "SELECT m FROM Mariages m WHERE m.id = :id"),
    @NamedQuery(name = "Mariages.findByDate", query = "SELECT m FROM Mariages m WHERE m.date = :date"),
    @NamedQuery(name = "Mariages.findByType", query = "SELECT m FROM Mariages m WHERE m.type = :type"),
    @NamedQuery(name = "Mariages.findByRegim", query = "SELECT m FROM Mariages m WHERE m.regim = :regim"),
    @NamedQuery(name = "Mariages.findByContrat", query = "SELECT m FROM Mariages m WHERE m.contrat = :contrat")})
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
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "regim")
    private String regim;
    @Basic(optional = false)
    @Column(name = "contrat")
    private String contrat;
    @JoinColumn(name = "id_etat_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtatCivils idEtatCivil;
    @OneToMany(mappedBy = "idMariage")
    private List<Concernes> concernesList;

    public Mariages() {
    }

    public Mariages(Long id) {
        this.id = id;
    }

    public Mariages(Long id, Date date, String type, String regim, String contrat) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.regim = regim;
        this.contrat = contrat;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegim() {
        return regim;
    }

    public void setRegim(String regim) {
        this.regim = regim;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public EtatCivils getIdEtatCivil() {
        return idEtatCivil;
    }

    public void setIdEtatCivil(EtatCivils idEtatCivil) {
        this.idEtatCivil = idEtatCivil;
    }

    @XmlTransient
    public List<Concernes> getConcernesList() {
        return concernesList;
    }

    public void setConcernesList(List<Concernes> concernesList) {
        this.concernesList = concernesList;
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
