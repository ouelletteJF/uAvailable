/*
 *	Fichier:	ContactRequest.java
 *	Contenu:	Classe ContactRequest - Représente une demande d'ajout aux contacts à un autre membre.
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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contactRequests", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactRequest.findAll", query = "SELECT cr FROM ContactRequest cr"),
    @NamedQuery(name = "ContactRequest.findById", query = "SELECT cr FROM ContactRequest cr WHERE cr.id = :id"),
    @NamedQuery(name = "ContactRequest.findByIdMembre", query = "SELECT cr FROM ContactRequest cr WHERE cr.idMembre = :idMembre"),
    @NamedQuery(name = "ContactRequest.findByIdContact", query = "SELECT cr FROM ContactRequest cr WHERE cr.idContact = :idContact")
})
public class ContactRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column(name="message")
    private String message;
    
    @Column(name="idMembre")
    private String idMembre;
            
    @Column(name="idContact")     
    private String idContact;   

    // Constructeurs
    public ContactRequest() { this(null, null, "", "", ""); }
    public ContactRequest(Integer id, Date date, String msg, String idM, String idC) {
        this.id = id;
        this.date = date;
        this.message = msg;
        this.idMembre = idM;
        this.idContact = idC;
    }
    
    // Id
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    
    // Date
    public void setDate(Date d) {
        this.date = d;
    }
    public Date getDate() {
        return date;
    }
    
    // Message
    public void setMessage(String m) {
        this.message = m;
    }
    public String getMessage() {
        return message;
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

    @Override
    public String toString() {
        return "com.uavailable.entites.ContactRequest[ id=" + id + " ]";
    }
    
}
