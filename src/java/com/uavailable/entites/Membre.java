/*
 *	Fichier:	DAO.java
 *	Contenu:	Interface qui sert de base aux classes du DAO
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	13 octobre 2013
 *	Dernière modification:	13 octobre 2013
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
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "membre", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByCourriel", query = "SELECT m FROM Membre m WHERE m.identifiants.courriel = :courriel"),
    @NamedQuery(name = "Membre.findByNom", query = "SELECT m FROM Membre m WHERE m.nom = :nom"),
    @NamedQuery(name = "Membre.findByPrenom", query = "SELECT m FROM Membre m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Membre.findByDateNaissance", query = "SELECT m FROM Membre m WHERE m.dateNaissance = :dateNaissance") })

public class Membre implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    
    @Embedded
    private Identifiants identifiants;
    
    @Column(name = "nom",  length = 30)
    private String nom;
    
    @Column(name = "prenom", length = 30)
    private String prenom;
    
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(name = "numeroTelephone", length = 10)
    private String numeroTelephone;
    
    @Transient
    private ToDoList toDoList;

    // CONSTRUCTEURS
    public Membre() { this("", "", "", "", null, ""); }
    public Membre(String courriel, String nom, String prenom, String mdp) { this(courriel, nom, prenom, mdp, null, ""); }
    public Membre(String courriel, String nom, String prenom, String mdp, Date dateNaissance, String tel) {
        this.identifiants.setCourriel(courriel);
        this.identifiants.setMotDePasse(mdp);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = tel;
    }
    
    // NOM
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // PRENOM
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // DATE DE NAISSANCE
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // NUMÉRO DE TÉLÉPHONE
    public String getNumeroTelephone() {
        return numeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Membre[ courriel=" + identifiants.getCourriel() + " ]";
    }
    
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courriel != null ? courriel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.courriel == null && other.courriel != null) || (this.courriel != null && !this.courriel.equals(other.courriel))) {
            return false;
        }
        return true;
    }
*/

    
}
