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
@Table(name = "mode_paiements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModePaiements.findAll", query = "SELECT m FROM ModePaiements m"),
    @NamedQuery(name = "ModePaiements.findById", query = "SELECT m FROM ModePaiements m WHERE m.id = :id"),
    @NamedQuery(name = "ModePaiements.findByMode", query = "SELECT m FROM ModePaiements m WHERE m.mode = :mode"),
    @NamedQuery(name = "ModePaiements.findByCodeTransaction", query = "SELECT m FROM ModePaiements m WHERE m.codeTransaction = :codeTransaction"),
    @NamedQuery(name = "ModePaiements.findByOperateur", query = "SELECT m FROM ModePaiements m WHERE m.operateur = :operateur")})
public class ModePaiements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "mode")
    private String mode;
    @Basic(optional = false)
    @Column(name = "code_transaction")
    private int codeTransaction;
    @Basic(optional = false)
    @Column(name = "operateur")
    private String operateur;

    public ModePaiements() {
    }

    public ModePaiements(Long id) {
        this.id = id;
    }

    public ModePaiements(Long id, String mode, int codeTransaction, String operateur) {
        this.id = id;
        this.mode = mode;
        this.codeTransaction = codeTransaction;
        this.operateur = operateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(int codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
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
        if (!(object instanceof ModePaiements)) {
            return false;
        }
        ModePaiements other = (ModePaiements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.ModePaiements[ id=" + id + " ]";
    }
    
}
