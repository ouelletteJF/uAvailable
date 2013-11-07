/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uavailable.entites;

/**
 *
 * @author Usager
 */
public class GroupeDeContact {
      private String nomGroupe ,nomMembre ;

    public GroupeDeContact(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }
      
}
