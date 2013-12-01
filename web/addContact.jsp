<%-- 
    Fichier:	addContacts.jsp
    Contenu:	Page qui affiche le panneau d'ajout de contacts

    Auteur:	Jean-François Ouellette
    Version:	1.0

    Date de création:	29 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link href="./style/signin.css" rel="stylesheet">
        
        <!-- Javascript -->
        <script src="./javascript/jquery-2.0.3.js"></script>
        <script src="./javascript/jquery.validate.js"></script>
        <script src="./javascript/signin.js" type="text/javascript"></script>
        <script src="./javascript/manageContacts.js"></script>
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            
                <h4 class="form-signin-heading">Add Contact</h4>

                <div>
                    <input type="text" class="form-control" placeholder="Name, phone or email address..." autofocus name="inputName" id="inputContactName" >
                    <button class="btn btn-primary btn-block" onClick="searchContact( $('#inputContactName').val() )">Search</button>
                </div>               
            
            <a href="#">Import contacts</a>
        </div> <!-- /container -->
        
        <div id="searchResults">
        </div>
    </body>
</html>
