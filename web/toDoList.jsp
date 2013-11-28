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

<%@page import="com.uavailable.entites.ToDoList"%>
<%@page import="java.util.Date"%>
<%@page import="com.uavailable.entites.Tache"%>
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
            
            <% 
                Membre m = (Membre) session.getAttribute("user");
                //HashMap<Integer, Liste> tempListes = m.getToDoList().getListes();
                
                            // SIMULATION D'UNE TO-DO LIST D'UN MEMBRE - DÉBUT DU BLOC À SUPPRIMER
                            // Création de la To-Do List
                            ToDoList maToDoList = new ToDoList( new HashMap<Integer, Liste>() );

                            // Création de listes
                            maToDoList.creerListe(0, "Unclassified", "Liste par défaut", "Red", new HashMap<Integer, Tache>(), "jf@me.com");
                            maToDoList.creerListe(1, "Liste 1", "Un 2e essai de liste", "Blue", new HashMap<Integer, Tache>(), "jf@me.com");
                            maToDoList.creerListe(2, "Liste 2", "Un 3e essai de liste", "Green", new HashMap<Integer, Tache>(), "jf@me.com");
                            maToDoList.creerListe(3, "Liste 3", "Un 4e essai de liste", "Purple", new HashMap<Integer, Tache>(), "jf@me.com");

                            // Création de taches
                            maToDoList.creerTache( 50, false, new Date(), "Un 1er essai de tache", "Tache 0", "URGENT", "Aucun", 0 );
                            maToDoList.creerTache( 1, false, new Date(), "Un 2e essai de tache", "Tache 1", "Faible", "Aucun", 1 );
                            maToDoList.creerTache( 2, true, new Date(), "Un 3e essai de tache", "Tache 2", "Modérée", "Aucun", 1 );
                            maToDoList.creerTache( 3, false, new Date(), "Un 4e essai de tache", "Tache 3", "Faible", "Aucun", 1 );
                            maToDoList.creerTache( 4, true, new Date(), "Un 5e essai de tache", "Tache 4", "URGENT", "Aucun", 3 );

                            HashMap<Integer, Liste> tempListes = maToDoList.getListes();
                            
                            m.setToDoList(maToDoList);
                            session.setAttribute("user", m);
                            out.println( ((Liste)((Membre)session.getAttribute("user")).getToDoList().getListes().values().toArray()[0]).getNom() + " OK MAN???" );
                            // FIN DU BLOC DE CODE À SUPPRIMER
                
                // Récupération des listes sous forme de tableau
                Object l[] = tempListes.values().toArray();
                Liste listes[] = new Liste[l.length];
                
                for (int i = 0; i < l.length; i++)
                    listes[i] = (Liste) l[i];
                
                // Si le membre n'a pas d'autre liste que celle créée par défaut...
                if (listes.length <= 1) {  
          %>
                    <div id="msgNoList">
                        <h2>You don't have any list yet. Would you like to <a href="createList.jsp?action=create">create one?</a></h2>
                    </div>
                    
            <% 
                } 
                
                // Affichage des tâches dans la liste par défaut
                if (listes[0].getTaches().size() == 0)
                    out.println("<h2>You've got no business to take care of!</h2>");
                else {
                    out.println("<table id='liste0'>");

                    for (int i = 0; i < listes[0].getTaches().size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + ((Tache)listes[0].getTaches().values().toArray()[i]).getNom() + "</td>");
                        out.println("<td>" + ((Tache)listes[0].getTaches().values().toArray()[i]).getDateButoire() + "</td>");
                        out.println("<td> <a href='deleteTask.do?action=deleteTask&&idL=" + listes[0].getId() + "&&idT=" + ((Tache)listes[0].getTaches().values().toArray()[i]).getId() + "'> <img src='./images/eraseSymbol.jpg' /> </a> </td>");
                        out.println("<td> <a href='createTask.jsp?action=edit&&task=" + ((Tache)listes[0].getTaches().values().toArray()[i]) + "'> <img src='./images/editSymbol.jpg' /> </a> </td>");
                        out.println("</tr>");
                    }
                }
                
                // Affichage des listes et de leurs tâches
                out.println("</table>");
                
                if (listes.length > 1) {
                    String tempId = "";
                    for (int i = 1; i < listes.length; i++) { 
                        out.println("<h2>" + listes[i].getNom() + "</h2>");
          %>
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
            <% 
                        tempId = "liste" + String.valueOf(i);

                        if (listes[i].getTaches().size() == 0)
                            out.println("<h4>You've got nothing to take care of regarding " + listes[i].getNom() + ". What a luck!</h4>");
                        else {
                            out.println("<table id='" + tempId + "'>");

                            for (int j = 0; j < listes[i].getTaches().size(); j++) {
                                out.println("<tr>");
                                out.println("<td>" + ((Tache)listes[i].getTaches().values().toArray()[j]).getNom() + "</td>");
                                out.println("<td>" + ((Tache)listes[i].getTaches().values().toArray()[j]).getDateButoire() + "</td>");
                                out.println("<td> <a href='deleteTask.do?action=deleteTask&&idL=" + listes[i].getId() + "&&idT=" + ((Tache)listes[i].getTaches().values().toArray()[j]).getId() + "'> <img src='./images/eraseSymbol.jpg' /> </a> </td>");
                                out.println("<td> <a href='createTask.jsp?action=edit&&task=" + ((Tache)listes[i].getTaches().values().toArray()[j]) + "'> <img src='./images/editSymbol.jpg' /> </a> </td>");
                                out.println("</tr>");
                            }

                            out.println("</table>");
                        }
                         
                        out.println("<a href='createTask.jsp?action=create&&list=" + listes[i].getId() + "'>New task</a>");
                    }
                }
          %>
                <a href="createList.jsp?action=create">New list</a>
        </div>
    </body>
</html>




    


                
