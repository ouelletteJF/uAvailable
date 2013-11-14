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
@Table(name = "tache", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id"),
    @NamedQuery(name = "Tache.findByComplete", query = "SELECT t FROM Tache t WHERE t.complete = :complete"),
    @NamedQuery(name = "Tache.findByDateButoire", query = "SELECT t FROM Tache t WHERE t.dateButoire = :dateButoire"),
    @NamedQuery(name = "Tache.findByDescription", query = "SELECT t FROM Tache t WHERE t.description = :description"),
    @NamedQuery(name = "Tache.findByNom", query = "SELECT t FROM Tache t WHERE t.nom = :nom"),
    @NamedQuery(name = "Tache.findByPriorite", query = "SELECT t FROM Tache t WHERE t.priorite = :priorite"),
    @NamedQuery(name = "Tache.findByRappel", query = "SELECT t FROM Tache t WHERE t.rappel = :rappel"),
    @NamedQuery(name = "Tache.findByIdListe", query = "SELECT t FROM Tache t WHERE t.idListe = :idListe")})
public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "complete", nullable = false)
    private boolean complete;
    @Basic(optional = false)
    @Column(name = "dateButoire", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateButoire;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Basic(optional = false)
    @Column(name = "priorite", nullable = false, length = 20)
    private String priorite;
    @Basic(optional = false)
    @Column(name = "rappel", nullable = false, length = 20)
    private String rappel;
    @Basic(optional = false)
    @Column(name = "idListe", nullable = false)
    private int idListe;

    public Tache() {
    }

    public Tache(Integer id) {
        this.id = id;
    }

    public Tache(Integer id, boolean complete, Date dateButoire, String description, String nom, String priorite, String rappel, int idListe) {
        this.id = id;
        this.complete = complete;
        this.dateButoire = dateButoire;
        this.description = description;
        this.nom = nom;
        this.priorite = priorite;
        this.rappel = rappel;
        this.idListe = idListe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getRappel() {
        return rappel;
    }

    public void setRappel(String rappel) {
        this.rappel = rappel;
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
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
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Tache[ id=" + id + " ]";
    }
    
}
