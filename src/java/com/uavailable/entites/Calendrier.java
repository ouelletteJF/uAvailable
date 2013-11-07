/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uavailable.entites;

public class Calendrier {
    private String nomCalendrier, descriptionCalendrier, optPartage;

    public Calendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public String getNomCalendrier() {
        return nomCalendrier;
    }

    public String getDescriptionCalendrier() {
        return descriptionCalendrier;
    }

    public String getOptPartage() {
        return optPartage;
    }

    public void setNomCalendrier(String nomCalendrier) {
        this.nomCalendrier = nomCalendrier;
    }

    public void setDescriptionCalendrier(String descriptionCalendrier) {
        this.descriptionCalendrier = descriptionCalendrier;
    }

    public void setOptPartage(String optPartage) {
        this.optPartage = optPartage;
    }

    @Override
    public String toString() {
        return "Calendrier{" + "nomCalendrier=" + nomCalendrier + ", descriptionCalendrier=" + descriptionCalendrier + ", optPartage=" + optPartage + '}';
    }
    
    
    
    
    
    
}
