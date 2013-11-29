/*
 *	Fichier:	ToDoList.java
 *	Contenu:	Classe ToDoList - NON PRÉSENTE DANS LA BD
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	14 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    À JOUR
 *
*/

package com.uavailable.entites;

import java.util.Date;
import java.util.HashMap;

public class ToDoList {
    
    private HashMap<Integer, Liste> listes;
    
    public ToDoList() { this(null); }
    public ToDoList( HashMap<Integer, Liste> l ) {
        this.listes = l;
    }
    
    // LISTES
    public HashMap<Integer, Liste> getListes() {
        return this.listes;
    }
    public void setListes(HashMap<Integer, Liste> l) {
        this.listes = l;
    }
    
    // Opérations sur les Listes
    public Boolean creerListe(Liste l) {
        if( listes.put(l.getId(), l) != null )
            return true;
        
        return false;
    }
    public Boolean supprimerListe(Integer id) {
        if( listes.remove( id ) != null )
            return true;
        
        return false;
    }
    public Boolean modifierListe(Liste l) {
        if( listes.containsKey( l.getId() )  ) {
            listes.put(l.getId(), l);
            return true;
        }
        
        return false;
    }
    
    // Opérations sur les Taches
    public Boolean creerTache(Tache t) {
            
        if( listes.get( t.getIdListe() ).getTaches().put( t.getId(), t ) != null )
            return true;
        
        return false;
        
    }
    public Boolean supprimerTache(Integer idL, Integer idT) {
        
        if( listes.get( idL ).getTaches().remove( idT ) != null )
            return true;
        
        return false;
        
    }
    public Boolean modifierTache(Tache t) {
        
        if( listes.get( t.getIdListe() ).getTaches().containsKey( t.getId() )  ) {
            listes.get( t.getIdListe() ).getTaches().put( t.getId(), t );
            return true;
        }
        
        return false;
    }
}
