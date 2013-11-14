/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites;

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
 * @author Steven
 */
@Entity
@Table(name = "membre", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByCourriel", query = "SELECT m FROM Membre m WHERE m.courriel = :courriel"),
    @NamedQuery(name = "Membre.findByNom", query = "SELECT m FROM Membre m WHERE m.nom = :nom"),
    @NamedQuery(name = "Membre.findByPrenom", query = "SELECT m FROM Membre m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Membre.findByDateNaissance", query = "SELECT m FROM Membre m WHERE m.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Membre.findByNumeroTelephone", query = "SELECT m FROM Membre m WHERE m.numeroTelephone = :numeroTelephone"),
    @NamedQuery(name = "Membre.findByMotDePasse", query = "SELECT m FROM Membre m WHERE m.motDePasse = :motDePasse")})
public class Membre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "courriel", nullable = false, length = 50)
    private String courriel;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom", nullable = false, length = 20)
    private String prenom;
    @Basic(optional = false)
    @Column(name = "dateNaissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "numeroTelephone", length = 10)
    private String numeroTelephone;
    @Column(name = "motDePasse", length = 20)
    private String motDePasse;

    public Membre() {
    }

    public Membre(String courriel) {
        this.courriel = courriel;
    }

    public Membre(String courriel, String nom, String prenom) {
        this.courriel = courriel;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courriel != null ? courriel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.courriel == null && other.courriel != null) || (this.courriel != null && !this.courriel.equals(other.courriel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Membre[ courriel=" + courriel + " ]";
    }
    
}
