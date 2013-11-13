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
@Table(name = "blocdisponilites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlocDisponilites.findAll", query = "SELECT b FROM BlocDisponilites b"),
    @NamedQuery(name = "BlocDisponilites.findByNomBloc", query = "SELECT b FROM BlocDisponilites b WHERE b.nomBloc = :nomBloc"),
    @NamedQuery(name = "BlocDisponilites.findByDateHeureBloc", query = "SELECT b FROM BlocDisponilites b WHERE b.dateHeureBloc = :dateHeureBloc"),
    @NamedQuery(name = "BlocDisponilites.findByDuree", query = "SELECT b FROM BlocDisponilites b WHERE b.duree = :duree"),
    @NamedQuery(name = "BlocDisponilites.findByNomCalendrier", query = "SELECT b FROM BlocDisponilites b WHERE b.nomCalendrier = :nomCalendrier"),
    @NamedQuery(name = "BlocDisponilites.findByOptRappelBloc", query = "SELECT b FROM BlocDisponilites b WHERE b.optRappelBloc = :optRappelBloc")})
public class BlocDisponilites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomBloc")
    private String nomBloc;
    @Basic(optional = false)
    @Lob
    @Column(name = "descriptionBloc")
    private String descriptionBloc;
    @Basic(optional = false)
    @Column(name = "dateHeureBloc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureBloc;
    @Basic(optional = false)
    @Column(name = "duree")
    private int duree;
    @Basic(optional = false)
    @Column(name = "nomCalendrier")
    private String nomCalendrier;
    @Basic(optional = false)
    @Column(name = "optRappelBloc")
    private String optRappelBloc;

    public BlocDisponilites() {
    }

    public BlocDisponilites(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public BlocDisponilites(String nomBloc, String descriptionBloc, Date dateHeureBloc, int duree, String nomCalendrier, String optRappelBloc) {
        this.nomBloc = nomBloc;
        this.descriptionBloc = descriptionBloc;
        this.dateHeureBloc = dateHeureBloc;
        this.duree = duree;
        this.nomCalendrier = nomCalendrier;
        this.optRappelBloc = optRappelBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public String getDescriptionBloc() {
        return descriptionBloc;
    }

    public void setDescriptionBloc(String descriptionBloc) {
        this.descriptionBloc = descriptionBloc;
    }

    public Date getDateHeureBloc() {
        return dateHeureBloc;
    }

    public void setDateHeureBloc(Date dateHeureBloc) {
        this.dateHeureBloc = dateHeureBloc;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getNomCalendrier() {
        return nomCalendrier;
    }

    public void setNomCalendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public String getOptRappelBloc() {
        return optRappelBloc;
    }

    public void setOptRappelBloc(String optRappelBloc) {
        this.optRappelBloc = optRappelBloc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomBloc != null ? nomBloc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlocDisponilites)) {
            return false;
        }
        BlocDisponilites other = (BlocDisponilites) object;
        if ((this.nomBloc == null && other.nomBloc != null) || (this.nomBloc != null && !this.nomBloc.equals(other.nomBloc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.BlocDisponilites[ nomBloc=" + nomBloc + " ]";
    }
    
}
