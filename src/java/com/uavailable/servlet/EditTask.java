/*
 *	Fichier:	EditTask.java
 *	Contenu:	Servlet qui assure la modification d'une tâche dans la To-Do List
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	25 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    Implémenter la mise à jour
                    Implémenter le transfert de la valeur de Completed
 *
*/
package com.uavailable.servlet;

import com.uavailable.entites.Membre;
import com.uavailable.entites.Tache;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditTask extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        HttpSession session = request.getSession(true);
        Membre m = (Membre) session.getAttribute("user");
        
        String  name = request.getParameter("inputName"),
                desc = request.getParameter("inputDescription"),
                priority = request.getParameter("inputPriority"),
                alert = request.getParameter("inputAlert");
        Integer idTask = Integer.parseInt(request.getParameter("task")),
                idList = Integer.parseInt(request.getParameter("inputList"));
        //Boolean isCompleted = request.getParameter("inputCompleted");
        Date d = null;
        try {
            d = sdf.parse( request.getParameter("inputDueDate") );
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Modification de la tâche au niveau local
        Tache t = new Tache(idTask, false /*isCompleted*/, d, desc, name, priority, alert, idList);
        m.getToDoList().modifierTache(t);
        
        // Mise à jour au niveau du serveur
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        
        try 
        {
            tr.begin();
            em.persist(t);
            tr.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }
        
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/toDoList.jsp");
        r.forward(request, response);
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
