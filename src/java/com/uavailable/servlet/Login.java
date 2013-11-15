/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.servlet;

import com.uavailable.entites.Membre;
import com.uavailable.util.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Steven
 */

    /*
    
    $dao = new CalendrierDAO();
    $calendriers = $dao->findByUser($_SESSION["connecte"]);
    
    $a = new Horraire($calendriers);
    
    put 
    
    
    1- Connection //
    2- Cree un objet Membre dans la session
        DAO get nom.. prenom.. ntel.. etc.
    3- L'objet Membre contient un attribut horaire
        ObjetMembre.set(Horaire horaire);
    4- L'attribut horaire est un objet d'Horaire
    5- L'objet Horaire contient une liste de Calendrier
        ObjetHoraire.set(DAO.finAllCalenderByUser(id));
    6- Chaque Calendrier de la liste contiens une liste de Bloc
    
    */
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String  u = request.getParameter("username");
        String  u = "bob";
                
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        //MembreDAO dao= new MembreDAO(Connexion.getInstance());
        //Membre membre = dao.find(u.trim());
        
        //connexion OK
        /*HttpSession session = request.getSession(true);
        session.setAttribute("Membre", u);
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/schedule.jsp");
        r.forward(request, response);*/
        
        
        
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
