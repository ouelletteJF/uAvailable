/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uavailable.entites;

/**
 *
 * @author Usager
 */
public class Tache {
   private String nomTache,dateHeure,descriptionTache,optRappel;

    public Tache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getNomTache() {
        return nomTache;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public String getOptRappel() {
        return optRappel;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public void setOptRappel(String optRappel) {
        this.optRappel = optRappel;
    }
    
}
