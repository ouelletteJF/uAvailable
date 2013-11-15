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
 * @author Steven
 */
@Entity
@Table(name = "groupedecontact", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupeDeContacts.findAll", query = "SELECT g FROM GroupeDeContacts g"),
    @NamedQuery(name = "GroupeDeContacts.findByNomGroupe", query = "SELECT g FROM GroupeDeContacts g WHERE g.nomGroupe = :nomGroupe"),
    @NamedQuery(name = "GroupeDeContacts.findByNomMembre", query = "SELECT g FROM GroupeDeContacts g WHERE g.nomMembre = :nomMembre")})
public class GroupeDeContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomGroupe", nullable = false, length = 20)
    private String nomGroupe;
    @Basic(optional = false)
    @Column(name = "nomMembre", nullable = false, length = 20)
    private String nomMembre;

    public GroupeDeContacts() {
    }

    public GroupeDeContacts(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public GroupeDeContacts(String nomGroupe, String nomMembre) {
        this.nomGroupe = nomGroupe;
        this.nomMembre = nomMembre;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomGroupe != null ? nomGroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupeDeContacts)) {
            return false;
        }
        GroupeDeContacts other = (GroupeDeContacts) object;
        if ((this.nomGroupe == null && other.nomGroupe != null) || (this.nomGroupe != null && !this.nomGroupe.equals(other.nomGroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.GroupeDeContacts[ nomGroupe=" + nomGroupe + " ]";
    }
    
}
