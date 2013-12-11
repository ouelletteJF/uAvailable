/*
 *	Fichier:	SearchContact.java
 *	Contenu:	Servlet appelée par AJAX pour faire une recherche des membres ayant un courriel ou un nom X.
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	1er décembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/
package com.uavailable.servlet;

import com.uavailable.entites.Membre;
import com.uavailable.util.EntityManagerSingleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchContact extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultat = "[";
        HttpSession session = request.getSession(true);
        String name = request.getParameter("inputName");
        
        System.out.println(name);
        
        // Connexion à la BD
        EntityManager em = EntityManagerSingleton.getInstance();
        
        // Définition des requêtes
        Query qFindByEmail = em.createNamedQuery("Membre.findByCourriel");
        qFindByEmail.setParameter("courriel", name);
        
        Query qFindByLastName = em.createNamedQuery("Membre.findByNom");
        qFindByLastName.setParameter("nom", name);
        
        Query qFindByFirstName = em.createNamedQuery("Membre.findByPrenom");
        qFindByFirstName.setParameter("prenom", name);
        
        Query qFindByTel = em.createNamedQuery("Membre.findByTel");
        qFindByTel.setParameter("tel", name);
        
        
        List<Membre> rEmail = qFindByEmail.getResultList();
        List<Membre> rTel = qFindByTel.getResultList(); 
        List<Membre> rLastName = qFindByLastName.getResultList();
        List<Membre> rFirstName = qFindByFirstName.getResultList();
        List<Membre> rAll = rEmail; // Il ne peut pas y avoir de doublons au sein d'une même resultList

        // Pour chaque résultat retournés avec le courriel...
        if (rEmail.size() > 0)
            for(int i = 0; i < rEmail.size(); i++)
                resultat += "{ \"prenom\" : \"" + rEmail.get(i).getPrenom() + "\", \"nom\" : \"" + rEmail.get(i).getNom() + "\", \"courriel\" : \"" + rEmail.get(i).getCourriel() + "\", \"tel\" : \"" + rEmail.get(i).getNumeroTelephone() + "\" }, ";
        
        // Pour chaque résultat retournés avec le courriel...
        if (rTel.size() > 0)
            for(int i = 0; i < rTel.size(); i++)
                if ( !rAll.contains(rTel.get(i)) ) {
                    resultat += "{ \"prenom\" : \"" + rTel.get(i).getPrenom() + "\", \"nom\" : \"" + rTel.get(i).getNom() + "\", \"courriel\" : \"" + rTel.get(i).getCourriel() + "\", \"tel\" : \"" + rTel.get(i).getNumeroTelephone() + "\" }, ";
                    rAll.add( rTel.get(i) );
                }
        
        // Pour chaque résultat retournés avec le courriel...
        if (rLastName.size() > 0)
            for(int i = 0; i < rLastName.size(); i++)
                if ( !rAll.contains(rLastName.get(i)) ) {
                    resultat += "{ \"prenom\" : \"" + rLastName.get(i).getPrenom() + "\", \"nom\" : \"" + rLastName.get(i).getNom() + "\", \"courriel\" : \"" + rLastName.get(i).getCourriel() + "\", \"tel\" : \"" + rLastName.get(i).getNumeroTelephone() + "\" }, ";
                    rAll.add( rLastName.get(i) );
                }
        
        // Pour chaque résultat retournés avec le courriel...
        if (rFirstName.size() > 0)
            for(int i = 0; i < rFirstName.size(); i++)
                if ( !rAll.contains(rFirstName.get(i)) ) {
                    resultat += "{ \"prenom\" : \"" + rFirstName.get(i).getPrenom() + "\", \"nom\" : \"" + rFirstName.get(i).getNom() + "\", \"courriel\" : \"" + rFirstName.get(i).getCourriel() + "\", \"tel\" : \"" + rFirstName.get(i).getNumeroTelephone() + "\" }, ";
                    rAll.add( rFirstName.get(i) );
                }
        
        resultat += "]";
        System.out.println("4");
        response.getWriter().write(resultat);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
