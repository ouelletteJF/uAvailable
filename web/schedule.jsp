<%-- 
    Document   : schedule
    Created on : Nov 12, 2013, 3:39:55 PM
    Author     : Steven
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
