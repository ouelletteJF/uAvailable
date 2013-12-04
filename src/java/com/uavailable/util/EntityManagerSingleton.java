/*
 *	Fichier:	EntityManagerSingleton.java
 *	Contenu:	Classe EntityManagerSingleton
 *
 *	Auteur:		Dominique Mbenza Ngoma
 *	Version:	1.0
 *
 *	Date de création:	4 décembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

package com.uavailable.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    
    private EntityManagerSingleton(){}

    private static class EMSingletonHolder{
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
        private static final EntityManager em = emf.createEntityManager();
    }

    public static EntityManager getInstance(){
        return EMSingletonHolder.em;
    }
}
