/*
 *	Fichier:	Membre.java
 *	Contenu:	Classe Membre
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	13 octobre 2013
 *	Dernière modification:	26 novembre 2013
 *	Raison mise à jour:	Correction du mappage du courriel et du mot de passe
 *
 *	À faire:    -
 *
*/

package com.uavailable.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "membre", catalog = "uavailable", schema = "")
@SecondaryTables({
    @SecondaryTable(name = "profiles")
})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByCourriel", query = "SELECT m FROM Membre m WHERE m.courriel = :courriel"),
    @NamedQuery(name = "Membre.findByNom", query = "SELECT m FROM Membre m WHERE m.nom = :nom"),
    @NamedQuery(name = "Membre.findByPrenom", query = "SELECT m FROM Membre m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Membre.findByTel", query = "SELECT m FROM Membre m WHERE m.numeroTelephone = :tel"),
    @NamedQuery(name = "Membre.findByDateNaissance", query = "SELECT m FROM Membre m WHERE m.dateNaissance = :dateNaissance") 
})

public class Membre implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="courriel")
    private String courriel;
    
    @Column(name="motdepasse")
    private String motDePasse;
    
    @Column(table = "profiles", name = "nom",  length = 30)
    private String nom;
    
    @Column(table = "profiles", name = "prenom", length = 30)
    private String prenom;
    
    @Column(table = "profiles", name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(table = "profiles", name = "numeroTelephone", length = 10)
    private String numeroTelephone;
    
    @Transient
    private ListeDeContacts contacts;
    
    @Transient
    private ToDoList toDoList;

    // CONSTRUCTEURS
    public Membre() { this("", "", "", "", null, ""); }
    public Membre(String courriel, String nom, String prenom, String mdp) { this(courriel, nom, prenom, mdp, null, ""); }
    public Membre(String courriel, String nom, String prenom, String mdp, Date dateNaissance, String tel) {
        this.courriel = courriel;
        this.motDePasse = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = tel;
    }
    
    // COURRIEL
    public void setCourriel(String c) {
        this.courriel = c;
    }
    public String getCourriel() {
        return this.courriel;
    }
    
    // MOT DE PASSE
    public void setMotDePasse(String mdp) {
        this.motDePasse = mdp;
    }
    public String getMotDePasse() {
        return this.motDePasse;
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
    
    // CONTACTS
    public ListeDeContacts getContacts() {
        return contacts;
    }
    public void setContacts(ListeDeContacts c) {
        this.contacts = c;
    }
    
    // TO-DO LIST
    public ToDoList getToDoList() {
        return toDoList;
    }
    public void setToDoList(ToDoList tdl) {
        this.toDoList = tdl;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Membre[ courriel=" + this.courriel + " ]";
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
