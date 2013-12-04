/*
 *	Fichier:	SessionListener.java
 *	Contenu:	Classe SessionListener
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
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Ouverture session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Fermeture session");
    }
    
}
