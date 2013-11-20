/*
 *	Fichier:	Calendrier.java
 *	Contenu:	Classe Calendrier
 *
 *	Auteur:		Steven Lacroix
 *	Version:	1.0
 *
 *	Date de création:	?
 *	Dernière modification:	15 novembre 2013
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

package com.uavailable.entites;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "calendrier", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendrier.findAll", query = "SELECT c FROM Calendrier c"),
    @NamedQuery(name = "Calendrier.findById", query = "SELECT c FROM Calendrier c WHERE c.id = :id"),
    @NamedQuery(name = "Calendrier.findByNom", query = "SELECT c FROM Calendrier c WHERE c.nom = :nom"),
    @NamedQuery(name = "Calendrier.findByIdMembre", query = "SELECT c FROM Calendrier c WHERE c.idMembre = :courrielMembre")})
public class Calendrier implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "description")
    private String description;
 
    @Column(name = "couleur")
    private String couleur;
    
    @Column(name = "optPartage")
    private String optPartage;
    
    @Transient
    private HashMap<Integer, BlocDisponibilite> blocs;
    
    @Column(name = "courrielMembre")
    private String courrielMembre;

    
    // CONSTRUCTEURS
    public Calendrier() { this(null, "", "", "", "", null, ""); }
    public Calendrier(Integer idC, String nom, String couleur, String idM) { this(idC, nom, "", couleur, "", null, idM); }
    public Calendrier(Integer id, String nom, String description, String couleur, String optPartage, HashMap<Integer, BlocDisponibilite> b, String idMembre) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.optPartage = optPartage;
        this.blocs = b;
        this.courrielMembre = idMembre;
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
    
    // COULEUR
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    // OPTIONS DE PARTAGE
    public String getOptPartage() {
        return optPartage;
    }
    public void setOptPartage(String optPartage) {
        this.optPartage = optPartage;
    }
    
    // BLOCS
    public HashMap<Integer, BlocDisponibilite> getBlocs() {
        return this.blocs;
    }
    public void setBlocs(HashMap<Integer, BlocDisponibilite> b) {
        this.blocs = b;
    }
    
    // ID DU MEMBRE
    public String getCourrielMembre() {
        return courrielMembre;
    }
    public void setCourrielMembre(String courrielMembre) {
        this.courrielMembre = courrielMembre;
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
        if (!(object instanceof Calendrier)) {
            return false;
        }
        Calendrier other = (Calendrier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "com.uavailable.entites.Calendrier[ id=" + id + " ]";
    }
    
}
