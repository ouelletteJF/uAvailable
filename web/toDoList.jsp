<%-- 
    Fichier:	toDoList.jsp
    Contenu:	Page qui affiche la «To-Do List» du membre connecté.

    Auteur:	Jean-François Ouellette
    Version:	1.0

    Date de création:	25 novembre 2013
    Dernière modification:  -
    Raison mise à jour:     -

    À faire:    -
--%>

<%@page import="com.uavailable.entites.Membre"%>
<%@page import="com.uavailable.entites.Liste"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>uAvailable - To-Do List</title>
    </head>
    <body>
        <div>
            <h1> To-Do List </h1>
            
            <% /*
                Membre m = (Membre) session.getAttribute("user");
                HashMap<Integer, Liste> listes = m.getToDoList().getListes();
                String tempId = "";

                // Si le membre n'a pas d'autre liste que celle créée par défaut...
                if (listes.size() == 1) {  
         */ %>
                    <div id="msgNoList">
                        <h2>You don't have any list yet. Would you like to <a href="createList.jsp?action=create">create one?</a></h2>
                    </div>
                    
            <% /*
                } 
                
                // Affichage des tâches dans la liste par défaut
                if (listes[0].getTaches().size() == 0)
                    out.println("<h2>You've got no business to take care of!</h2>");
                else {
                    out.println("<table id='" + tempId + "'>");

                    for (int i = 0; i < listes[0].size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + listes[0].getTaches()[j].getNom() + "</td>");
                        out.println("<td>" + listes[0].getTaches()[j].getDateButoire() + "</td>");
                        out.println("<td> <a href='deleteTask.do?action=deleteTask&&id=" + listes[0].getTaches()[j].getId() + "'> <img src="./images/eraseSymbol.jpg" /> </a> </td>");
                        out.println("<td> <a href='createTask.jsp?action=edit&&task=" + listes[0].getTaches()[j] + "'> <img src="./images/editSymbol.jpg" /> </a> </td>");
                        out.println("</tr>");
                    }
                }
                
                // Affichage des listes et de leurs tâches
                out.println("</table>");
                
                else {
                    for (int i = 1; i < listes.size(); i++) { 
                        out.println("<h2>" + listes[i].getNom() + "</h2>");
       */   %>
                        <ul>
                            <li>
                                <a href="createTask.jsp?action=create&&list=1"> <img src="./images/addSymbol.jpg" /> </a>
                                <!-- listes[i].getId()  -->
                            </li>

                            <li>
                                <a href="deleteList.do?action=deleteList&&id=1"> <img src="./images/deleteSymbol.jpg" /> </a>
                                <!-- listes[i].getId()  -->
                            </li>

                            <li>
                                <a href="createList.jsp?action=edit&&list=1"> <img src="./images/editSymbol.jpg" /> </a>
                                <!-- listes[i].getId()  -->
                            </li>
                        </ul>
            <% /*
                        tempId = "liste" + i.valueOf();

                        if (listes[i].getTaches().size() == 0)
                            out.println("<h2>You've got nothing to take care of regarding " + listes[i].getNom() + ". What a luck!</h2>");
                        else {
                            out.println("<table id='" + tempId + "'>");

                            for (int j = 0; j < listes[i].getTaches().size(); j++) {
                                out.println("<tr>");
                                out.println("<td>" + listes[i].getTaches()[j].getNom() + "</td>");
                                out.println("<td>" + listes[i].getTaches()[j].getDateButoire() + "</td>");
                                out.println("<td> <a href='deleteTask.do?action=deleteTask&&id=" + listes[i].getTaches()[j].getId() + "'> <img src="./images/eraseSymbol.jpg" /> </a> </td>");
                                out.println("<td> <a href='createTask.jsp?action=edit&&task=" + listes[i].getTaches()[j] + "'> <img src="./images/editSymbol.jpg" /> </a> </td>");
                                out.println("</tr>");
                            }

                            out.println("</table>");
                        }
                         
                        out.println("<a href='createTask.jsp?action=create&&list=" + listes[i].getId() + "'>New task</a>");
                    }
                }
        */  %>
                <a href="createList.jsp?action=create">New list</a>
        </div>
    </body>
</html>
