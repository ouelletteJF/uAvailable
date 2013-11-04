/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uavailable.entites;

/**
 *
 * @author Usager
 */
public class Horaire {
    private String nomHoraire,nomCalendrier,nomBloc;

    public Horaire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public String getNomHoraire() {
        return nomHoraire;
    }

    public String getNomCalendrier() {
        return nomCalendrier;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomHoraire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public void setNomCalendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    @Override
    public String toString() {
        return "Horaire{" + "nomHoraire=" + nomHoraire + ", nomCalendrier=" + nomCalendrier + ", nomBloc=" + nomBloc + '}';
    }
    
    
}
