/*
 *	Fichier:	ListeDeContacts.java
 *	Contenu:	Classe ListeDeContacts - NON PRÉSENTE DANS LA BD
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	14 novembre 2013
 *	Dernière modification:	1er décembre 2013
 *	Raison mise à jour:	Ajout des méthodes «ajouter» et «supprimer»
 *
 *	À faire:    -
 *
*/

package com.uavailable.entites;

import java.util.HashMap;

public class ListeDeContacts {
    
    private HashMap<String, Membre> contacts;
    
    // CONSTRUCTEURS
    public ListeDeContacts() { this(null); }
    public ListeDeContacts(HashMap<String, Membre> c) {
        this.contacts = c;
    }
    
    // CONTACTS
    public void setContacts(HashMap<String, Membre> c) {
        this.contacts = c;
    }
    public HashMap<String, Membre> getContacts() {
        return this.contacts;
    }
    
    
    public Boolean ajouterContact(Membre m) {
        if ( this.contacts.put(m.getCourriel(), m) != null )
            return true;
        
        return false;
    }
    
    public Boolean supprimerContact(String idM) {
        if ( this.contacts.remove(idM) != null )
            return true;
        
        return false;
    }
}
