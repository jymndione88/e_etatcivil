/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administration.etatcivil.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dev1202
 */
@Entity
@Table(name = "declarations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Declarations.findAll", query = "SELECT d FROM Declarations d"),
    @NamedQuery(name = "Declarations.findById", query = "SELECT d FROM Declarations d WHERE d.id = :id"),
    @NamedQuery(name = "Declarations.findByNumero", query = "SELECT d FROM Declarations d WHERE d.numero = :numero"),
    @NamedQuery(name = "Declarations.findByDate", query = "SELECT d FROM Declarations d WHERE d.date = :date"),
    @NamedQuery(name = "Declarations.findByMentionMarginal", query = "SELECT d FROM Declarations d WHERE d.mentionMarginal = :mentionMarginal")})
public class Declarations implements Serializable {

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
    @Column(name = "mention_marginal")
    private String mentionMarginal;
    @JoinColumn(name = "id_declarant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Declarants idDeclarant;
    @JoinColumn(name = "id_jugement", referencedColumnName = "id")
    @ManyToOne
    private Jugements idJugement;
    @JoinColumn(name = "id_officier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Officiers idOfficier;
    @JoinColumn(name = "id_type_declaration", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeDeclarations idTypeDeclaration;

    public Declarations() {
    }

    public Declarations(Long id) {
        this.id = id;
    }

    public Declarations(Long id, String numero, Date date) {
        this.id = id;
        this.numero = numero;
        this.date = date;
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

    public String getMentionMarginal() {
        return mentionMarginal;
    }

    public void setMentionMarginal(String mentionMarginal) {
        this.mentionMarginal = mentionMarginal;
    }

    public Declarants getIdDeclarant() {
        return idDeclarant;
    }

    public void setIdDeclarant(Declarants idDeclarant) {
        this.idDeclarant = idDeclarant;
    }

    public Jugements getIdJugement() {
        return idJugement;
    }

    public void setIdJugement(Jugements idJugement) {
        this.idJugement = idJugement;
    }

    public Officiers getIdOfficier() {
        return idOfficier;
    }

    public void setIdOfficier(Officiers idOfficier) {
        this.idOfficier = idOfficier;
    }

    public TypeDeclarations getIdTypeDeclaration() {
        return idTypeDeclaration;
    }

    public void setIdTypeDeclaration(TypeDeclarations idTypeDeclaration) {
        this.idTypeDeclaration = idTypeDeclaration;
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
        if (!(object instanceof Declarations)) {
            return false;
        }
        Declarations other = (Declarations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Declarations[ id=" + id + " ]";
    }
    
}
