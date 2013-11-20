/*
 *	Fichier:	ListeDeContacts.java
 *	Contenu:	Classe ListeDeContacts - NON PRÉSENTE DANS LA BD
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
    
    /*
    public Boolean ajouterContact(Membre m) {
        this.contacts.put(, m)
    }
    
    public Boolean supprimerContact() {
        
    }*/
}
