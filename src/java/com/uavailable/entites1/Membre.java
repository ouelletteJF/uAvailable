/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DomyMb
 */
@Entity
@Table(name = "membre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByEMail", query = "SELECT m FROM Membre m WHERE m.eMail = :eMail"),
    @NamedQuery(name = "Membre.findByNomMembre", query = "SELECT m FROM Membre m WHERE m.nomMembre = :nomMembre"),
    @NamedQuery(name = "Membre.findByPrenomMembre", query = "SELECT m FROM Membre m WHERE m.prenomMembre = :prenomMembre"),
    @NamedQuery(name = "Membre.findByDateNaissance", query = "SELECT m FROM Membre m WHERE m.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Membre.findByNumeroTelephone", query = "SELECT m FROM Membre m WHERE m.numeroTelephone = :numeroTelephone"),
    @NamedQuery(name = "Membre.findByMotDePasse", query = "SELECT m FROM Membre m WHERE m.motDePasse = :motDePasse"),
    @NamedQuery(name = "Membre.findByNomGroupe", query = "SELECT m FROM Membre m WHERE m.nomGroupe = :nomGroupe"),
    @NamedQuery(name = "Membre.findByNomHoraire", query = "SELECT m FROM Membre m WHERE m.nomHoraire = :nomHoraire"),
    @NamedQuery(name = "Membre.findByNomToDoList", query = "SELECT m FROM Membre m WHERE m.nomToDoList = :nomToDoList")})
public class Membre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eMail")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "nomMembre")
    private String nomMembre;
    @Basic(optional = false)
    @Column(name = "prenomMembre")
    private String prenomMembre;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "numeroTelephone")
    private String numeroTelephone;
    @Column(name = "motDePasse")
    private String motDePasse;
    @Column(name = "nomGroupe")
    private String nomGroupe;
    @Column(name = "nomHoraire")
    private String nomHoraire;
    @Column(name = "nomToDoList")
    private String nomToDoList;

    public Membre() {
    }

    public Membre(String eMail) {
        this.eMail = eMail;
    }

    public Membre(String eMail, String nomMembre, String prenomMembre) {
        this.eMail = eMail;
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomHoraire() {
        return nomHoraire;
    }

    public void setNomHoraire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public String getNomToDoList() {
        return nomToDoList;
    }

    public void setNomToDoList(String nomToDoList) {
        this.nomToDoList = nomToDoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eMail != null ? eMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.eMail == null && other.eMail != null) || (this.eMail != null && !this.eMail.equals(other.eMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.Membre[ eMail=" + eMail + " ]";
    }
    
}
