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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DomyMb
 */
@Entity
@Table(name = "horaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horaire.findAll", query = "SELECT h FROM Horaire h"),
    @NamedQuery(name = "Horaire.findByNomHoraire", query = "SELECT h FROM Horaire h WHERE h.nomHoraire = :nomHoraire"),
    @NamedQuery(name = "Horaire.findByNomCalendrier", query = "SELECT h FROM Horaire h WHERE h.nomCalendrier = :nomCalendrier"),
    @NamedQuery(name = "Horaire.findByNomBloc", query = "SELECT h FROM Horaire h WHERE h.nomBloc = :nomBloc")})
public class Horaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomHoraire")
    private String nomHoraire;
    @Basic(optional = false)
    @Column(name = "nomCalendrier")
    private String nomCalendrier;
    @Basic(optional = false)
    @Column(name = "nomBloc")
    private String nomBloc;

    public Horaire() {
    }

    public Horaire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public Horaire(String nomHoraire, String nomCalendrier, String nomBloc) {
        this.nomHoraire = nomHoraire;
        this.nomCalendrier = nomCalendrier;
        this.nomBloc = nomBloc;
    }

    public String getNomHoraire() {
        return nomHoraire;
    }

    public void setNomHoraire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public String getNomCalendrier() {
        return nomCalendrier;
    }

    public void setNomCalendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomHoraire != null ? nomHoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.nomHoraire == null && other.nomHoraire != null) || (this.nomHoraire != null && !this.nomHoraire.equals(other.nomHoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.Horaire[ nomHoraire=" + nomHoraire + " ]";
    }
    
}
