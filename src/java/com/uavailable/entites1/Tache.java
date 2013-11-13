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
import javax.persistence.Lob;
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
@Table(name = "tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findByNomTache", query = "SELECT t FROM Tache t WHERE t.nomTache = :nomTache"),
    @NamedQuery(name = "Tache.findByDateHeure", query = "SELECT t FROM Tache t WHERE t.dateHeure = :dateHeure"),
    @NamedQuery(name = "Tache.findByOptRappel", query = "SELECT t FROM Tache t WHERE t.optRappel = :optRappel")})
public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomTache")
    private String nomTache;
    @Basic(optional = false)
    @Column(name = "dateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Basic(optional = false)
    @Lob
    @Column(name = "descriptionTache")
    private String descriptionTache;
    @Basic(optional = false)
    @Column(name = "optRappel")
    private String optRappel;

    public Tache() {
    }

    public Tache(String nomTache) {
        this.nomTache = nomTache;
    }

    public Tache(String nomTache, Date dateHeure, String descriptionTache, String optRappel) {
        this.nomTache = nomTache;
        this.dateHeure = dateHeure;
        this.descriptionTache = descriptionTache;
        this.optRappel = optRappel;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public String getOptRappel() {
        return optRappel;
    }

    public void setOptRappel(String optRappel) {
        this.optRappel = optRappel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomTache != null ? nomTache.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.nomTache == null && other.nomTache != null) || (this.nomTache != null && !this.nomTache.equals(other.nomTache))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.Tache[ nomTache=" + nomTache + " ]";
    }
    
}
