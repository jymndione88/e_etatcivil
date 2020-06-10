/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "type_declarations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeDeclarations.findAll", query = "SELECT t FROM TypeDeclarations t"),
    @NamedQuery(name = "TypeDeclarations.findById", query = "SELECT t FROM TypeDeclarations t WHERE t.id = :id"),
    @NamedQuery(name = "TypeDeclarations.findByCode", query = "SELECT t FROM TypeDeclarations t WHERE t.code = :code"),
    @NamedQuery(name = "TypeDeclarations.findByType", query = "SELECT t FROM TypeDeclarations t WHERE t.type = :type")})
public class TypeDeclarations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public TypeDeclarations() {
    }

    public TypeDeclarations(Long id) {
        this.id = id;
    }

    public TypeDeclarations(Long id, String code, String type) {
        this.id = id;
        this.code = code;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof TypeDeclarations)) {
            return false;
        }
        TypeDeclarations other = (TypeDeclarations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.TypeDeclarations[ id=" + id + " ]";
    }
    
}
