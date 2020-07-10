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
import javax.persistence.Lob;
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
@Table(name = "jugements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugements.findAll", query = "SELECT j FROM Jugements j"),
    @NamedQuery(name = "Jugements.findById", query = "SELECT j FROM Jugements j WHERE j.id = :id"),
    @NamedQuery(name = "Jugements.findByAnnee", query = "SELECT j FROM Jugements j WHERE j.annee = :annee"),
    @NamedQuery(name = "Jugements.findByDate", query = "SELECT j FROM Jugements j WHERE j.date = :date"),
    @NamedQuery(name = "Jugements.findByLieu", query = "SELECT j FROM Jugements j WHERE j.lieu = :lieu"),
    @NamedQuery(name = "Jugements.findByNumero", query = "SELECT j FROM Jugements j WHERE j.numero = :numero")})
public class Jugements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "annee")
    @Temporal(TemporalType.DATE)
    private Date annee;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "lieu")
    private String lieu;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Lob
    @Column(name = "piece_jointe")
    private byte[] pieceJointe;
    @OneToMany(mappedBy = "idJugement")
    @JsonIgnore
    private List<Naissances> naissancesList;

    public Jugements() {
    }

    public Jugements(Long id) {
        this.id = id;
    }

    public Jugements(Long id, Date annee, Date date, String lieu, int numero) {
        this.id = id;
        this.annee = annee;
        this.date = date;
        this.lieu = lieu;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public byte[] getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    @XmlTransient
    public List<Naissances> getNaissancesList() {
        return naissancesList;
    }

    public void setNaissancesList(List<Naissances> naissancesList) {
        this.naissancesList = naissancesList;
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
        if (!(object instanceof Jugements)) {
            return false;
        }
        Jugements other = (Jugements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administration.etatcivil.entities.Jugements[ id=" + id + " ]";
    }
    
}
