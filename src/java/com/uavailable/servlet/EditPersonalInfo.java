/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uavailable.servlet;

import com.uavailable.entites.Membre;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aaa
 */
public class EditPersonalInfo extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        
        String  prenom = request.getParameter("inputFirst"),
                nom = request.getParameter("inputLast"),
                courriel = request.getParameter("courriel1"),
                phone = request.getParameter("inputPhone"),
                mois= request.getParameter("inputMonth"),
                annee= request.getParameter("inputYear"),
                jour= request.getParameter("inputDay");
        
        System.out.println("Voici le prenom recupéré " + prenom);
        System.out.println("Voici le nom recupéré " + nom);
        System.out.println("Voici le phone recupéré " + phone);
        System.out.println("Voici le courreil recupéré" + courriel);
        System.out.println("Année" + annee);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
        EntityManager em = emf.createEntityManager();
        Query qByEmail = em.createNamedQuery("Membre.findByCourriel");
        System.out.println("Courriel après le findByCourriel " + courriel);
       
        qByEmail.setParameter("courriel",courriel);
        Membre membre = (Membre) qByEmail.getSingleResult();
        System.out.println("nom du Membre singleResult " + membre.getNom() + " prenom " + membre.getPrenom());
        membre.setNom(nom);
        membre.setPrenom(prenom);
        membre.setNumeroTelephone(phone);
      
        Date ddn = new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MMMM-YYYY") ;
    /*  cal.set(Calendar.MONTH,mois);
      
        cal.set(Calendar.DATE, parseInt(jour));
        cal.set(Calendar.YEAR, parseInt(annee));
        ddn = cal.getTime(); */
     
        try {
            cal.setTime(dateFormat.parse("" + jour + "-" + mois + "-" + annee + ""));
        } 
        catch (ParseException e) { //Handle exception here, most of the time you will just log it.
            e.printStackTrace();
        }

        ddn = cal.getTime();
    
 /*     try{
            ddn=dateFormat.parse(""+jour+"-"+mois+"-"+annee+"");
        }
        catch(Exception e) { 
            System.out.println("Le parse n'a pas reussi ");
        } */
        
        membre.setDateNaissance(ddn);
     
        EntityTransaction t = em.getTransaction();
        t.begin();
        
        em.merge(membre);
        t.commit();
        
        em.close();
        emf.close();
   
        session.setAttribute("user", courriel);
        
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/personalInfo.jsp");
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
