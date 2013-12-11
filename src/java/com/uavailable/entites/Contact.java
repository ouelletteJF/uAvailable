/*
 *	Fichier:	Contact.java
 *	Contenu:	Classe Contact - Représente un enregistrement de la table contacts.
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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contacts", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findByIdMembre", query = "SELECT cr FROM Contact cr WHERE cr.id.idMembre = :idMembre ORDER BY cr.nomContact"),
    @NamedQuery(name = "Contact.findByIdContact", query = "SELECT cr FROM Contact cr WHERE cr.id.idContact = :idContact ORDER BY cr.nomMembre")
})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ContactId id;
    
    @Column(name="nomMembre")
    private String nomMembre;
    
    @Column(name="prenomMembre")
    private String prenomMembre;
    
    @Column(name="nomContact")
    private String nomContact;
    
    @Column(name="prenomContact")
    private String prenomContact;

    // Constructeurs
    public Contact() { }
    public Contact(ContactId contactId, String nomM, String prenomM, String nomC, String prenomC) {
        this.id = contactId;
        this.nomMembre = nomM;
        this.prenomMembre = prenomM;
        this.nomContact = nomC;
        this.prenomContact = prenomC;
    }
    public Contact(String idM, String idC, String nomM, String prenomM, String nomC, String prenomC) {
        this.id = new ContactId(idM, idC);
        this.nomMembre = nomM;
        this.prenomMembre = prenomM;
        this.nomContact = nomC;
        this.prenomContact = prenomC;
    }

    // ContactId
    public void setContactId(ContactId id) {
        this.id = id;
    }
    public ContactId getContactId() {
        return id;
    }

    // NomMembre
    public void setNomMembre(String n) {
        this.nomMembre = n;
    }
    public String getNomMembre() {
        return nomMembre;
    }
    
    // PrenomMembre
    public void setPrenomMembre(String p) {
        this.prenomMembre = p;
    }
    public String getPrenomMembre() {
        return prenomMembre;
    }
    
    // NomContact
    public void setNomContact(String n) {
        this.nomContact = n;
    }
    public String getNomContact() {
        return nomContact;
    }
    
    // PrenomContact
    public void setPrenomContact(String p) {
        this.prenomContact = p;
    }
    public String getPrenomContact() {
        return prenomContact;
    }
    
    @Override
    public String toString() {
        return "com.uavailable.entites.Contact[ id=" + id.getIdContact() + " ]";
    }
    
}
