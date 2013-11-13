/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.entites1;

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
 * @author DomyMb
 */
@Entity
@Table(name = "todolist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToDoList.findAll", query = "SELECT t FROM ToDoList t"),
    @NamedQuery(name = "ToDoList.findByNomToDoList", query = "SELECT t FROM ToDoList t WHERE t.nomToDoList = :nomToDoList"),
    @NamedQuery(name = "ToDoList.findByNomTache", query = "SELECT t FROM ToDoList t WHERE t.nomTache = :nomTache")})
public class ToDoList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomToDoList")
    private String nomToDoList;
    @Basic(optional = false)
    @Column(name = "nomTache")
    private String nomTache;

    public ToDoList() {
    }

    public ToDoList(String nomToDoList) {
        this.nomToDoList = nomToDoList;
    }

    public ToDoList(String nomToDoList, String nomTache) {
        this.nomToDoList = nomToDoList;
        this.nomTache = nomTache;
    }

    public String getNomToDoList() {
        return nomToDoList;
    }

    public void setNomToDoList(String nomToDoList) {
        this.nomToDoList = nomToDoList;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomToDoList != null ? nomToDoList.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToDoList)) {
            return false;
        }
        ToDoList other = (ToDoList) object;
        if ((this.nomToDoList == null && other.nomToDoList != null) || (this.nomToDoList != null && !this.nomToDoList.equals(other.nomToDoList))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uavailable.entites1.ToDoList[ nomToDoList=" + nomToDoList + " ]";
    }
    
}
