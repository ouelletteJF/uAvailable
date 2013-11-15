/*
 *	Fichier:	Horaire.java
 *	Contenu:	Classe Horaire - NON PRÉSENTE DANS LA BD
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

import java.util.Date;
import java.util.HashMap;

public class Horaire {
    
    private HashMap<Integer, Calendrier> calendriers;
    
    public Horaire() { this(null); }
    public Horaire( HashMap<Integer, Calendrier> l ) {
        this.calendriers = l;
    }
    
    // Opérations sur les Listes
    public Boolean creerCalendrier(Integer idL, String nom, String desc, String coul, HashMap<Integer, BlocDisponibilite> c, Integer idM) {
        if( calendriers.put(idL, new Calendrier(idL, nom, desc, coul, c, idM)) != null )
            return true;
        
        return false;
    }
    public Boolean supprimerCalendrier(Calendrier c) {
        if( calendriers.remove( c.getId() ) != null )
            return true;
        
        return false;
    }
    public Boolean modifierCalendrier(Calendrier c) {
        if( calendriers.containsKey( c.getId() )  ) {
            calendriers.put(c.getId(), c);
            return true;
        }
        
        return false;
    }
    
    // Opérations sur les Taches
    public Boolean creerBloc(Integer id, boolean complete, Date dateButoire, String desc, String nom, String prio, String rappel, Integer idListe) {
            
        if( calendriers.get(idListe).getTaches().put( id, new Tache(id, complete, dateButoire, desc, nom, prio, rappel, idListe) ) != null )
            return true;
        
        return false;
        
    }
    public Boolean supprimerBloc(Tache t) {
        
        if( calendriers.get( t.getIdListe() ).getTaches().remove( t.getId() ) != null )
            return true;
        
        return false;
        
    }
    public Boolean modifierBloc(Tache t) {
        
        if( calendriers.get( t.getIdListe() ).getTaches().put( t.getId(), t ) != null )
            return true;
        
        return false;
    }
}
