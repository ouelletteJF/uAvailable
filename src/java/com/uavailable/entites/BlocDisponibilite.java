/*
 *	Fichier:	BlocDisponibilite.java
 *	Contenu:	Classe BlocDisponibilite
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	2.0
 *
 *	Date de création:	?
 *	Dernière modification:	14 novembre 2013
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
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

@Entity
@Table(name = "blocdisponilites", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlocDisponibilite.findAll", query = "SELECT b FROM BlocDisponibilite b"),
    @NamedQuery(name = "BlocDisponibilite.findById", query = "SELECT b FROM BlocDisponibilite b WHERE b.id = :id"),
    @NamedQuery(name = "BlocDisponibilite.findByNom", query = "SELECT b FROM BlocDisponibilite b WHERE b.nom = :nom"),
    @NamedQuery(name = "BlocDisponibilite.findByDebut", query = "SELECT b FROM BlocDisponibilite b WHERE b.debut = :debut"),
    @NamedQuery(name = "BlocDisponibilite.findByFin", query = "SELECT b FROM BlocDisponibilite b WHERE b.fin = :fin"),
    @NamedQuery(name = "BlocDisponibilite.findByType", query = "SELECT b FROM BlocDisponibilite b WHERE b.type = :type"),
    @NamedQuery(name = "BlocDisponibilite.findByIdCalendrier", query = "SELECT b FROM BlocDisponibilite b WHERE b.idCalendrier = :idCalendrier")})
public class BlocDisponibilite implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "description")
    private String description;

    @Column(name = "debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debut;
    
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    
    @Column(name = "rappel")
    private String rappel;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "idCalendrier")
    private int idCalendrier;

    public BlocDisponibilite() { this(null, "", "", null, null, "", "", null); }
    public BlocDisponibilite(Integer idB, String nom, Date debut, String type, Integer idC) { this(idB, nom, "", debut, null, "", type, idC); }
    public BlocDisponibilite(Integer id, String nom, String description, Date debut, Date fin, String rappel, String type, Integer idCalendrier) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.debut = debut;
        this.fin = fin;
        this.rappel = rappel;
        this.type = type;
        this.idCalendrier = idCalendrier;
    }

    // ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // NOM
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // DESCRIPTION
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // DATE DE DEBUT
    public Date getDebut() {
        return debut;
    }
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    //  DATE DE FIN
    public Date getFin() {
        return fin;
    }
    public void setFin(Date fin) {
        this.fin = fin;
    }

    // OPTIONS DE RAPPEL
    public String getRappel() {
        return rappel;
    }
    public void setRappel(String rappel) {
        this.rappel = rappel;
    }

    // TYPE
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // ID DU CALENDRIER
    public int getIdCalendrier() {
        return idCalendrier;
    }
    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
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
        if (!(object instanceof BlocDisponibilite)) {
            return false;
        }
        BlocDisponibilite other = (BlocDisponibilite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "com.uavailable.entites.BlocDisponibilite[ id=" + id + " ]";
    }
    
}
