<%-- 
    Fichier:	schedule.jsp
    Contenu:	Page qui l'horaire du membre (ou d'un contact?)

    Auteur:	Steven Lacroix
    Version:	1.0

    Date de création:	12 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<% 
         out.println("<p class=\"resultat\">"+session.getAttribute("Membre")+", vous êtes connectés. "+
                        "<a href=\"logout.do?action=logout\">déconnexion</a></p>");
%>
    </body>
</html>
