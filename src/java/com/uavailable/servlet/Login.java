/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uavailable.entites.Membre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher r;
        
        Membre  unMembre = null;
        String  u = request.getParameter("inputEmail"),
                p = request.getParameter("inputPassword"),
                mdp = null;

        // Si aucun courriel n'est saisi...
        if (u == null || u.trim().equalsIgnoreCase(""))     
        {
            request.setAttribute("message", "Courriel obligatoire.");
            r = this.getServletContext().getRequestDispatcher("login.jsp");
            r.forward(request, response);
            return;
        }

        // ?
        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        // Préparation de la récupération des données dans la BD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Query qFindByEmail = em.createNamedQuery("Membre.findByCourriel");
        qFindByEmail.setParameter("courriel", u);
        
        tx.begin();

        List<Membre> resultats = qFindByEmail.getResultList();
        System.out.println("THE LIST : " + resultats);
        
        // Si au moins un résultat est retourné...
        if (resultats.size() > 0) {
            unMembre = resultats.get(0);
            System.out.println("LE MEMBRE DUDE : " + unMembre);
            mdp = unMembre.getMotDePasse();
            
            // Si le mot de passe est incorrect...
            if ( !mdp.equals(p) )    
            {
                request.setAttribute("message", "Mot de passe incorrect.");
                r = this.getServletContext().getRequestDispatcher("/login.jsp");
            }
            
            // Si l'authentification réussit...
            else    
            { 
                tx.commit();
                
                HttpSession session = request.getSession(true);
                session.setAttribute("user", unMembre);
                
                r = this.getServletContext().getRequestDispatcher("/index.jsp");
            }
        }
        
        // Sinon, si l'utilisateur est inexistant...
        else {
            request.setAttribute("message", "Membre " + u + " inexistant.");
            r = this.getServletContext().getRequestDispatcher("/login.jsp");
        }
        
        em.close();
        emf.close();
        r.forward(request, response);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
