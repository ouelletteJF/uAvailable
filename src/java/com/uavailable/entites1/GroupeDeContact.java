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
@Table(name = "groupedecontact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupeDeContact.findAll", query = "SELECT g FROM GroupeDeContact g"),
    @NamedQuery(name = "GroupeDeContact.findByNomGroupe", query = "SELECT g FROM GroupeDeContact g WHERE g.nomGroupe = :nomGroupe"),
    @NamedQuery(name = "GroupeDeContact.findByNomMembre", query = "SELECT g FROM GroupeDeContact g WHERE g.nomMembre = :nomMembre")})
public class GroupeDeContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomGroupe")
    private String nomGroupe;
    @Basic(optional = false)
    @Column(name = "nomMembre")
    private String nomMembre;

    public GroupeDeContact() {
    }

    public GroupeDeContact(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public GroupeDeContact(String nomGroupe, String nomMembre) {
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
        if (!(object instanceof GroupeDeContact)) {
            return false;
        }
        GroupeDeContact other = (GroupeDeContact) object;
        if ((this.nomGroupe == null && other.nomGroupe != null) || (this.nomGroupe != null && !this.nomGroupe.equals(other.nomGroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.GroupeDeContact[ nomGroupe=" + nomGroupe + " ]";
    }
    
}
