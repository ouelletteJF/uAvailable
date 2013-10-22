/*
 *	Fichier:	DAO.java
 *	Contenu:	Interface qui sert de base aux classes du DAO
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	13 octobre 2013
 *	Dernière modification:	13 octobre 2013
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

package com.uavailable.dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    protected Connection cnx;

    public DAO(Connection cnx) {
            super();
            this.cnx = cnx;
    }

    public Connection getCnx() {
            return cnx;
    }

    public void setCnx(Connection cnx) {
            this.cnx = cnx;
    }

    public abstract boolean create(T x);
    public abstract T find(int id);
    public abstract T find(String id);
    public abstract boolean update(T x);
    public abstract boolean delete(T x);
    public abstract List<T> findAll();
}
