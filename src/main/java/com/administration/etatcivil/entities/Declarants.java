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
@Table(name = "declarants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Declarants.findAll", query = "SELECT d FROM Declarants d"),
    @NamedQuery(name = "Declarants.findById", query = "SELECT d FROM Declarants d WHERE d.id = :id")})
public class Declarants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_internaute", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Internautes idInternaute;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeclarant")
    private List<Declarations> declarationsList;

    public Declarants() {
    }

    public Declarants(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Internautes getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(Internautes idInternaute) {
        this.idInternaute = idInternaute;
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
        if (!(object instanceof Declarants)) {
            return false;
        }
        Declarants other = (Declarants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Declarants[ id=" + id + " ]";
    }
    
}
