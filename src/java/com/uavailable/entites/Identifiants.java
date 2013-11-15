/*
 *	Fichier:	Identifiants.java
 *	Contenu:	Classe Identifiants - Représente les informations de connexion d'un Membre
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	14 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

package com.uavailable.entites;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Identifiants {

    private String courriel;
    private String motDePasse;
    
    // CONSTRUCTEURS
    public Identifiants() {
        this("", "");
    }
    public Identifiants(String c, String mdp) {
        this.courriel = c;
        this.motDePasse = mdp;
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
}
