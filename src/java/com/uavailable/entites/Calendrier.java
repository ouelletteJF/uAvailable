/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "calendrier", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendrier.findAll", query = "SELECT c FROM Calendrier c"),
    @NamedQuery(name = "Calendrier.findById", query = "SELECT c FROM Calendrier c WHERE c.id = :id"),
    @NamedQuery(name = "Calendrier.findByNom", query = "SELECT c FROM Calendrier c WHERE c.nom = :nom"),
    @NamedQuery(name = "Calendrier.findByCouleur", query = "SELECT c FROM Calendrier c WHERE c.couleur = :couleur"),
    @NamedQuery(name = "Calendrier.findByOptPartage", query = "SELECT c FROM Calendrier c WHERE c.optPartage = :optPartage"),
    @NamedQuery(name = "Calendrier.findByCourrielMembre", query = "SELECT c FROM Calendrier c WHERE c.courrielMembre = :courrielMembre")})
public class Calendrier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Basic(optional = false)
    @Lob
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @Column(name = "couleur", nullable = false, length = 20)
    private String couleur;
    @Basic(optional = false)
    @Column(name = "optPartage", nullable = false, length = 20)
    private String optPartage;
    @Basic(optional = false)
    @Column(name = "courrielMembre", nullable = false, length = 50)
    private String courrielMembre;

    public Calendrier() {
    }

    public Calendrier(Integer id) {
        this.id = id;
    }

    public Calendrier(Integer id, String nom, String description, String couleur, String optPartage, String courrielMembre) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.optPartage = optPartage;
        this.courrielMembre = courrielMembre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getOptPartage() {
        return optPartage;
    }

    public void setOptPartage(String optPartage) {
        this.optPartage = optPartage;
    }

    public String getCourrielMembre() {
        return courrielMembre;
    }

    public void setCourrielMembre(String courrielMembre) {
        this.courrielMembre = courrielMembre;
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
        if (!(object instanceof Calendrier)) {
            return false;
        }
        Calendrier other = (Calendrier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Calendrier[ id=" + id + " ]";
    }
    
}
