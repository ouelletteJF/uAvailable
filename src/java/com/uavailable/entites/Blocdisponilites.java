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
import javax.persistence.Lob;
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
@Table(name = "blocdisponilites", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blocdisponilites.findAll", query = "SELECT b FROM Blocdisponilites b"),
    @NamedQuery(name = "Blocdisponilites.findById", query = "SELECT b FROM Blocdisponilites b WHERE b.id = :id"),
    @NamedQuery(name = "Blocdisponilites.findByNom", query = "SELECT b FROM Blocdisponilites b WHERE b.nom = :nom"),
    @NamedQuery(name = "Blocdisponilites.findByDebut", query = "SELECT b FROM Blocdisponilites b WHERE b.debut = :debut"),
    @NamedQuery(name = "Blocdisponilites.findByFin", query = "SELECT b FROM Blocdisponilites b WHERE b.fin = :fin"),
    @NamedQuery(name = "Blocdisponilites.findByRappel", query = "SELECT b FROM Blocdisponilites b WHERE b.rappel = :rappel"),
    @NamedQuery(name = "Blocdisponilites.findByType", query = "SELECT b FROM Blocdisponilites b WHERE b.type = :type"),
    @NamedQuery(name = "Blocdisponilites.findByIdCalendrier", query = "SELECT b FROM Blocdisponilites b WHERE b.idCalendrier = :idCalendrier")})
public class Blocdisponilites implements Serializable {
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
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @Column(name = "debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date debut;
    @Basic(optional = false)
    @Column(name = "fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @Basic(optional = false)
    @Column(name = "rappel", nullable = false, length = 20)
    private String rappel;
    @Basic(optional = false)
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Basic(optional = false)
    @Column(name = "idCalendrier", nullable = false)
    private int idCalendrier;

    public Blocdisponilites() {
    }

    public Blocdisponilites(Integer id) {
        this.id = id;
    }

    public Blocdisponilites(Integer id, String nom, String description, Date debut, Date fin, String rappel, String type, int idCalendrier) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.debut = debut;
        this.fin = fin;
        this.rappel = rappel;
        this.type = type;
        this.idCalendrier = idCalendrier;
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

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getRappel() {
        return rappel;
    }

    public void setRappel(String rappel) {
        this.rappel = rappel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
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
        if (!(object instanceof Blocdisponilites)) {
            return false;
        }
        Blocdisponilites other = (Blocdisponilites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Blocdisponilites[ id=" + id + " ]";
    }
    
}
