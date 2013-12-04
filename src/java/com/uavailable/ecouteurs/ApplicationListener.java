/*
 *	Fichier:	ApplicationListener.java
 *	Contenu:	Classe ApplicationListener
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	4 décembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

package com.uavailable.ecouteurs;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Ouverture application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Fermeture application");
    }
    
}
