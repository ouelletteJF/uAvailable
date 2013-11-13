/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites1;

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
 * @author DomyMb
 */
@Entity
@Table(name = "calendrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendrier.findAll", query = "SELECT c FROM Calendrier c"),
    @NamedQuery(name = "Calendrier.findByNomCalendrier", query = "SELECT c FROM Calendrier c WHERE c.nomCalendrier = :nomCalendrier"),
    @NamedQuery(name = "Calendrier.findByOptPartage", query = "SELECT c FROM Calendrier c WHERE c.optPartage = :optPartage")})
public class Calendrier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomCalendrier")
    private String nomCalendrier;
    @Basic(optional = false)
    @Lob
    @Column(name = "descriptionCalendrier")
    private String descriptionCalendrier;
    @Basic(optional = false)
    @Column(name = "optPartage")
    private String optPartage;

    public Calendrier() {
    }

    public Calendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public Calendrier(String nomCalendrier, String descriptionCalendrier, String optPartage) {
        this.nomCalendrier = nomCalendrier;
        this.descriptionCalendrier = descriptionCalendrier;
        this.optPartage = optPartage;
    }

    public String getNomCalendrier() {
        return nomCalendrier;
    }

    public void setNomCalendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public String getDescriptionCalendrier() {
        return descriptionCalendrier;
    }

    public void setDescriptionCalendrier(String descriptionCalendrier) {
        this.descriptionCalendrier = descriptionCalendrier;
    }

    public String getOptPartage() {
        return optPartage;
    }

    public void setOptPartage(String optPartage) {
        this.optPartage = optPartage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomCalendrier != null ? nomCalendrier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendrier)) {
            return false;
        }
        Calendrier other = (Calendrier) object;
        if ((this.nomCalendrier == null && other.nomCalendrier != null) || (this.nomCalendrier != null && !this.nomCalendrier.equals(other.nomCalendrier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.Calendrier[ nomCalendrier=" + nomCalendrier + " ]";
    }
    
}
