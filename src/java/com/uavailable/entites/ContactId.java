/*
 *	Fichier:	ContactId.java
 *	Contenu:	Classe ContactId - Clé primaire de la classe Contact.
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	10 décembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/
package com.uavailable.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactId implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "idMembre")
    private String idMembre;
    
    @Basic(optional = false)
    @Column(name = "idContact")
    private String idContact;
    
    // Constructeurs
    public ContactId() { this("", ""); }
    public ContactId(String idM, String idC) { 
        this.idMembre = idM;
        this.idContact = idC;
    }
    
    // IdMembre
    public void setIdMembre(String id) {
        this.idMembre = id;
    }
    public String getIdMembre() {
        return idMembre;
    }
    
    // IdContact
    public void setIdContact(String id) {
        this.idContact = id;
    }
    public String getIdContact() {
        return idContact;
    }
}
