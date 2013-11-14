/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "liste", catalog = "uavailable", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liste.findAll", query = "SELECT l FROM Liste l"),
    @NamedQuery(name = "Liste.findById", query = "SELECT l FROM Liste l WHERE l.id = :id"),
    @NamedQuery(name = "Liste.findByNom", query = "SELECT l FROM Liste l WHERE l.nom = :nom"),
    @NamedQuery(name = "Liste.findByDescription", query = "SELECT l FROM Liste l WHERE l.description = :description"),
    @NamedQuery(name = "Liste.findByCouleur", query = "SELECT l FROM Liste l WHERE l.couleur = :couleur"),
    @NamedQuery(name = "Liste.findByIdToDoList", query = "SELECT l FROM Liste l WHERE l.idToDoList = :idToDoList")})
public class Liste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Basic(optional = false)
    @Column(name = "couleur", nullable = false, length = 20)
    private String couleur;
    @Basic(optional = false)
    @Column(name = "idToDoList", nullable = false)
    private int idToDoList;

    public Liste() {
    }

    public Liste(Integer id) {
        this.id = id;
    }

    public Liste(Integer id, String nom, String description, String couleur, int idToDoList) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.couleur = couleur;
        this.idToDoList = idToDoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getIdToDoList() {
        return idToDoList;
    }

    public void setIdToDoList(int idToDoList) {
        this.idToDoList = idToDoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liste)) {
            return false;
        }
        Liste other = (Liste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites.Liste[ id=" + id + " ]";
    }
    
}
