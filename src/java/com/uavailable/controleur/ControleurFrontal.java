/*
 *	Fichier:	ControleurFrontal.java
 *	Contenu:	Contrôleur qui redirige les requêtes vers les servlets adéquates
 *
 *	Auteur:		?
 *	Version:	1.0
 *
 *	Date de création:	?
 *	Dernière modification:	14 novembre 2013
 *	Raison mise à jour:	Ajout d'actions à traiter
 *
 *	À faire:    -
 *
*/

package com.uavailable.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DomyMb
 */
public class ControleurFrontal extends HttpServlet {

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
    
        String action = request.getParameter("action");
        RequestDispatcher r;
        
        if (action != null)
        {
            if ("signup".equals(action))
            {
                r = this.getServletContext().getRequestDispatcher("/signup"); 
                r.forward(request, response);     
                return;
            }        
            else if ("login".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/login"); 
                r.forward(request, response);     
                return;
            }
            else if ("logout".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/logout"); 
                r.forward(request, response);     
                return;
            }
            else if ("personalInfo".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/editInfos"); 
                r.forward(request, response);     
                return;
            }
            else if ("addList".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/addList"); 
                r.forward(request, response);     
                return;
            }
            else if ("deleteList".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/deleteList"); 
                r.forward(request, response);     
                return;
            }
            else if ("editList".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/editList"); 
                r.forward(request, response);     
                return;
            }
            else if ("addTask".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/addTask"); 
                r.forward(request, response);     
                return;
            }
            else if ("deleteTask".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/deleteTask"); 
                r.forward(request, response);     
                return;
            }
            else if ("editTask".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/editTask"); 
                r.forward(request, response);     
                return;
            }  
            else if ("searchContact".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/searchContact"); 
                r.forward(request, response);     
                return;
            }
            else if ("sendContactReq".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/sendContactReq"); 
                r.forward(request, response);     
                return;
            }
            else if ("acceptContactReq".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/acceptContactReq"); 
                r.forward(request, response);     
                return;
            }
            else if ("declineContactReq".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/declineContactReq"); 
                r.forward(request, response);     
                return;
            }
            else if ("deleteContact".equals(action))
            {   
                r = this.getServletContext().getRequestDispatcher("/deleteContact"); 
                r.forward(request, response);     
                return;
            }
        }
    
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
    
