<%-- 
    Fichier:	contacts.jsp
    Contenu:	Page qui liste tous les contacts

    Auteur:	Steven Lacroix
    Version:	1.0

    Date de création:	3 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    Icône de paramètres de partage pour chaque contact pour voir rapidement ce qui lui est partagé
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="com.uavailable.entites.Contact"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="com.uavailable.util.EntityManagerSingleton"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="com.uavailable.entites.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.png">

        <title>uAvailable?</title>

        <!-- Bootstrap core CSS -->
        <link href="./style/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./style/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="./style/jquery.mobile-1.2.0.min.css" />
        <link rel="stylesheet" type="text/css" href="./style/jquery.mobile.alphascroll.css" />
        
        <!-- Javascript -->
        <script type="text/javascript" src="./javascript/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile-1.2.0.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile.alphascroll.js"></script>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <div id="alphascroll" data-role="page">
	<div data-role="header" data-position="fixed">
		<h1>Contacts</h1>
	</div>
	<div data-role="content">
            <%
                Membre user = (Membre) session.getAttribute("user");

                Contact tempContact = null;
                Membre tempMembre = null;
                List<Membre> allContacts = new LinkedList();

                EntityManager em = EntityManagerSingleton.getInstance();

                // Récupère tous les contacts où l'id du membre apparait
                Query   qFindAllContact1 = em.createNamedQuery("Contact.findByIdMembre");
                qFindAllContact1.setParameter("idMembre", user.getCourriel());
                Query   qFindAllContact2 = em.createNamedQuery("Contact.findByIdContact");
                qFindAllContact2.setParameter("idContact", user.getCourriel());

                List<Contact> resultats = qFindAllContact1.getResultList();
                ListIterator<Contact> i = resultats.listIterator();

                while(i.hasNext())
                {
                    tempContact = i.next();
                    
                    tempMembre = new Membre();
                    tempMembre.setCourriel( tempContact.getContactId().getIdContact());
                    tempMembre.setNom( tempContact.getNomContact() );
                    tempMembre.setPrenom( tempContact.getPrenomContact() );
                    allContacts.add(tempMembre);
                }
                
                resultats = qFindAllContact2.getResultList();
                i = resultats.listIterator();

                while(i.hasNext())
                {
                    tempContact = i.next();
                    
                    tempMembre = new Membre();
                    tempMembre.setCourriel( tempContact.getContactId().getIdMembre());
                    tempMembre.setNom( tempContact.getNomMembre() );
                    tempMembre.setPrenom( tempContact.getPrenomMembre() );
                    allContacts.add(tempMembre);
                }
                
                ListIterator<Membre> j = allContacts.listIterator();
            %>
                <ul id="mylistview" data-role="listview" data-autodividers="true">
            <%
                while(j.hasNext())
                {
                    tempMembre = j.next();
                    
            %>
                    <li class="list-group-item" data-icon="false"><a href="aContact.jsp?id=<%= tempMembre.getCourriel() %>"><%= tempMembre.getPrenom() + " " + tempMembre.getNom() %></a></li>
            <%
                }
            %>
            
                </ul>
	</div>
	<div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a href="contactRequests.jsp">Requests (0)</a></li>
                    <li><a href="addContact.jsp">Add</a></li>
                    <li><a href="#">Groups</a></li>
                </ul>
            </div>
	</div>
        </div>

        </div> <!-- /container -->
    </body>
</html>