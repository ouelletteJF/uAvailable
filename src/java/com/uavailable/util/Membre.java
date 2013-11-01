
package com.uavailable.util;


public class Membre {
private String numeroTelephone,nomMembre,prenomMembre,dateNaissance,eMail,motDePasse,nomGroupe,nomHoraire,nomToDoList;

    public Membre(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String geteMail() {
        return eMail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public String getNomHoraire() {
        return nomHoraire;
    }

    public String getNomToDoList() {
        return nomToDoList;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public void setNomHoraire(String nomHoraire) {
        this.nomHoraire = nomHoraire;
    }

    public void setNomToDoList(String nomToDoList) {
        this.nomToDoList = nomToDoList;
    }
    
}
