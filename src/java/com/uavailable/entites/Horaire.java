
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
    
    // CALENDRIERS
    public HashMap<Integer, Calendrier> getCalendriers() {
        return this.calendriers;
    }
    public void setCalendriers(HashMap<Integer, Calendrier> c) {
        this.calendriers = c;
    }
    
    // Opérations sur les Calendriers
    public Boolean creerCalendrier(Integer idC, String nom, String desc, String coul, String optPartage, HashMap<Integer, BlocDisponibilite> b, String idM) {
        if( calendriers.put(idC, new Calendrier(idC, nom, desc, coul, optPartage, b, idM)) != null )
            return true;
        
        return false;
        
        // return calendriers.put( idC, new Calendrier(idC, nom, desc, coul, optPartage, b, idM) ); 
    }
    public Boolean supprimerCalendrier(Calendrier c) {
        if( calendriers.remove( c.getId() ) != null )
            return true;
        
        return false;
        
        // return calendriers.remove( c.getId() );
    }
    public Boolean modifierCalendrier(Calendrier c) {
        if( calendriers.containsKey( c.getId() )  ) {
            calendriers.put(c.getId(), c);
            return true;
        }
        
        return false;
    }
    
    // Opérations sur les Blocs
    public Boolean creerBloc(Integer idB, String nom, String desc, Date deb, Date fin, String rappel, String type, Integer idC) {
            
        if( calendriers.get(idC).getBlocs().put( idB, new BlocDisponibilite(idB, nom, desc, deb, fin, rappel, type, idC) ) != null )
            return true;
        
        return false;
        
        // return calendriers.get(idC).getBlocs().put( idB, new BlocDisponibilite(idB, nom, desc, deb, fin, rappel, type, idC) );
        
    }
    public Boolean supprimerBloc(BlocDisponibilite b) {
        
        if( calendriers.get( b.getIdCalendrier() ).getBlocs().remove( b.getId() ) != null )
            return true;
        
        return false;
        
        // return calendriers.get( b.getIdCalendrier() ).getBlocs().remove( b.getId() );
        
    }
    public Boolean modifierBloc(BlocDisponibilite b) {
        
        if( calendriers.get( b.getIdCalendrier() ).getBlocs().put( b.getId(), b ) != null )
            return true;
        
        return false;
    }
}
