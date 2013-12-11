<%-- 
    Document   : contactRequests
    Created on : 2013-11-30, 10:18:56
    Author     : aaa
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.uavailable.entites.Membre"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="com.uavailable.util.EntityManagerSingleton"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="com.uavailable.entites.ContactRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h2>Contact requests </h2>
            <%
                Membre user = (Membre) session.getAttribute("user");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                ContactRequest tempRequest = null;
                Membre inviter = null;
                
                EntityManager em = EntityManagerSingleton.getInstance();

                // Récupère les demandes d'ajout aux contacts concernant le membre connecté
                Query   qFindAllRequest = em.createNamedQuery("ContactRequest.findByIdContact");
                qFindAllRequest.setParameter("idContact", user.getCourriel());
                
                List<ContactRequest> resultats = qFindAllRequest.getResultList();
                ListIterator<ContactRequest> i = resultats.listIterator();
                
                while(i.hasNext())
                {
                    tempRequest = i.next();
                    
                    // Récupère le bénévole qui fait la demande
                    Query   qFindMembreById = em.createNamedQuery("Membre.findByCourriel");
                    qFindMembreById.setParameter( "courriel", tempRequest.getIdMembre() );

                    inviter = (Membre) qFindMembreById.getSingleResult();
            %>
            <table>
                <tr>
                    <%= inviter.getPrenom() + " " + inviter.getNom() %><br />
                    <%= sdf.format( tempRequest.getDate() ) %> <br /><br />
                    <%= tempRequest.getMessage() %>
                    
                    <form action="acceptRequest.do?action=acceptContactReq" method="post">
                        <input type="hidden" name="idM" value="<%= inviter.getCourriel() %>" />
                        <input type="hidden" name="idC" value="<%= user.getCourriel() %>" />
                        <input type="hidden" name="nomM" value="<%= inviter.getNom() %>" />
                        <input type="hidden" name="prenomM" value="<%= inviter.getPrenom() %>" />
                        <input type="hidden" name="nomC" value="<%= user.getNom() %>" />
                        <input type="hidden" name="prenomC" value="<%= user.getPrenom() %>" />
                        <input type="hidden" name="id" value="<%= tempRequest.getId() %>" />
                        <input type="submit" value="Confirm" />
                    </form>
                    
                    <form action="declineRequest.do?action=declineContactReq" method="post">
                        <input type="hidden" name="id" value="<%= tempRequest.getId() %>" />
                        <input type="submit" value="Decline" />
                    </form>
                    
                    <hr />
                </tr>
            </table>
            <%
                }
            %>
        </div>
    </body>
</html>
