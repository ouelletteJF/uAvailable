/*
 *	Fichier:	Liste.java
 *	Contenu:	Classe Liste
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
import java.util.HashMap;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "liste", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liste.findAll", query = "SELECT l FROM Liste l"),
    @NamedQuery(name = "Liste.findById", query = "SELECT l FROM Liste l WHERE l.id = :id"),
    @NamedQuery(name = "Liste.findByNom", query = "SELECT l FROM Liste l WHERE l.nom = :nom"),
    @NamedQuery(name = "Liste.findByIdMembre", query = "SELECT l FROM Liste l WHERE l.idMembre = :idToDoList")})
public class Liste implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "couleur")
    private String couleur;
    
    @Column(name = "idMembre")
    private String idMembre;
    
    @Transient
    private HashMap<Integer, Tache> taches;

    // CONSTRUCTEURS
    public Liste() { this(null, "", "", "", null, ""); }
    public Liste(Integer idL, String idM, String nom, String desc, String couleur) { this(idL, nom, desc, couleur, null, idM); }
    public Liste(Integer idL, String nom, String description, String couleur, HashMap<Integer, Tache> t, String idM) {
        this.id = idL;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.taches = t;
        this.idMembre = idM;
    }

    // ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer idL) {
        this.id = idL;
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
    
    // TACHES
    public HashMap<Integer, Tache> getTaches() {
        return taches;
    }
    public void setTaches(HashMap<Integer, Tache> t) {
        this.taches = t;
    }

    // ID MEMBRE
    public String getIdToDoList() {
        return idMembre;
    }
    public void setIdToDoList(String idM) {
        this.idMembre = idM;
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
        if (!(object instanceof Liste)) {
            return false;
        }
        Liste other = (Liste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "com.uavailable.entites.Liste[ id=" + id + " ]";
    }    
}
