<%-- 
    Fichier:	personnalInfo.jsp
    Contenu:	Page qui affiche les informations personnelles du membre connecté

    Auteur:	Steven Lacroix
    Version:	1.0

    Date de création:	24 octobre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

<%@page import="javax.persistence.Query"%>
<%@page import="com.uavailable.entites.Membre"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.persistence.NoResultException"%>

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
        
        <!-- Javascript -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <% /*
            
            String nom = "", prenom = "", courriel = "", phone=""; //,eMail="input@Email";
            //if((eMail)!=null)
            if (session.getAttribute("connecte") != null)
            {
                //String eMail = request.getParameter("connecte");
                courriel=(String)session.getAttribute("connecte");
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
                EntityManager em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                Query qByEmail=em.createNamedQuery("Membre.findByCourriel");
                qByEmail.setParameter("courriel", courriel);

                tx.begin();

                try {
                    Membre  membre = (Membre) qByEmail.getSingleResult();
                    nom = membre.getNom();
                    prenom = membre.getPrenom();
                    phone = membre.getNumeroTelephone();
                } 
                catch (NoResultException exp) {
                    System.out.println("Membre inexistant");
                }

                tx.commit();
                em.close();
                emf.close();
            }
            
      */  %>
         
        <div class="container">
            <fieldset>
                <legend>Manage Personal Informations</legend>
                <form class=""  action="personalInfo.do">
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputName" name="inputFirst" value="<%= ((Membre)session.getAttribute("user")).getPrenom() %>">
                            <input type="text" class="form-control" id="inputName" name="inputLast" value="<%= ((Membre)session.getAttribute("user")).getNom() %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail"  value="<%= ((Membre)session.getAttribute("user")).getCourriel() %>" disabled>
                            <input type="hidden" name="courriel1" value="<%= ((Membre)session.getAttribute("user")).getCourriel() %>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhone" class="col-lg-2 control-label">Mobile Phone</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPhone" name="inputPhone" value="<%= ((Membre)session.getAttribute("user")).getNumeroTelephone() %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBDay" class="col-lg-2 control-label">Birthday</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="selectMonth" name="inputMonth">
                                <option selected hidden>February</option>
                                <option>January</option>
                                <option>February</option>
                                <option>March</option>
                                <option>April</option>
                                <option>May</option>
                                <option>June</option>
                                <option>July</option>
                                <option>August</option>
                                <option>September</option>
                                <option>October</option>
                                <option>November</option>
                                <option>December</option>
                            </select>
                            <input type="text" class="form-control" id="inputDay" name="inputDay" value="18">
                            <input type="text" class="form-control" id="inputYear" name="inputYear" value="1992">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="select" class="col-lg-2 control-label">Gender</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="selectGender">
                                  <option selected hidden>Male</option>
                                  <option>Male</option>
                                  <option>Female</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-default">Cancel</button> 
                            <input type="hidden" name="action" value="personalInfo" /><br />
                            <button type="submit" class="btn btn-primary">Confirm changes</button> 
                        </div>
                    </div>
                </form>
            </fieldset>
        </div> <!-- /container -->
    </body>
</html>
