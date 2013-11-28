<%-- 
    Fichier:	aContact.jsp
    Contenu:	Page qui affiche la fiche d'un contact

    Auteur:	Steven Lacroix
    Version:	1.0

    Date de création:	3 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

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
        
        <!-- Javascript -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <div class="top_menu"><a href="contacts.jsp"><input type="button" class="btn btn-primary" value="Contacts"></a></div>
            <fieldset>
                <legend>Steven Lacroix</legend>
                <form class="">
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <label class="col-lg-2 control-label">Steven Lacroix</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <label class="col-lg-2 control-label">stevenlacroixv4s972@gmail.com</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhone" class="col-lg-2 control-label">Mobile Phone</label>
                        <div class="col-lg-10">
                            <label class="col-lg-2 control-label">514-574-2346</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBDay" class="col-lg-2 control-label">Birthday</label>
                        <div class="col-lg-10">
                            <label class="col-lg-2 control-label">February 18, 1992</label>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div> <!-- /container -->
    </body>
</html>
