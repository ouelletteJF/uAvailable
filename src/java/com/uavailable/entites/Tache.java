/*
 *	Fichier:	Tache.java
 *	Contenu:	Classe Tache
 *
 *	Auteur:		Steven Lacroix
 *	Version:	1.0
 *
 *	Date de création:	?
 *	Dernière modification:	14 novembre 2013
 *	Raison mise à jour:	-
 *
 *	À faire:    À JOUR
 *
*/

package com.uavailable.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "tache", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t"),
    @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id"),
    @NamedQuery(name = "Tache.findByIdListe", query = "SELECT t FROM Tache t WHERE t.idListe = :idListe")})
public class Tache implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "complete")
    private boolean complete;
    
    @Column(name = "dateButoire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateButoire;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "priorite")
    private String priorite;
    
    @Column(name = "rappel")
    private String rappel;
    
    @Column(name = "idListe")
    private Integer idListe;

    public Tache() { this(null, false, null, "", "", "", "", null); }
    public Tache(Integer id, boolean complete, String nom, Integer idListe) { this(id, complete, null, "", nom, "", "", idListe); }
    public Tache(Integer id, boolean complete, Date dateButoire, String description, String nom, String priorite, String rappel, Integer idListe) {
        this.id = id;
        this.complete = complete;
        this.dateButoire = dateButoire;
        this.description = description;
        this.nom = nom;
        this.priorite = priorite;
        this.rappel = rappel;
        this.idListe = idListe;
    }

    // ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // COMPLÉTÉ
    public boolean getComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    // DATE BUTOIRE
    public Date getDateButoire() {
        return dateButoire;
    }
    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    // DESCRIPTION
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // NOM
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // PRIORITE
    public String getPriorite() {
        return priorite;
    }
    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    // RAPPEL
    public String getRappel() {
        return rappel;
    }
    public void setRappel(String rappel) {
        this.rappel = rappel;
    }
    
    // ID LISTE
    public int getIdListe() {
        return idListe;
    }
    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    /*
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
*/
    @Override
    public String toString() {
        return "com.uavailable.entites.Tache[ id=" + id + " ]";
    }
    
}
