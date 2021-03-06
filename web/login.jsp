<%-- 
    Fichier:	signin.jsp
    Contenu:	Page qui affiche le formulaire de connexion

    Auteur:	Steven Lacroix
    Version:	1.0

    Date de création:	24 octobre 2013
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
        <link href="./style/signin.css" rel="stylesheet">
        
        <!-- Javascript -->
        <script src="./javascript/jquery-2.0.3.js"></script>
        <script src="./javascript/jquery.validate.js"></script>
        <script src="./javascript/signin.js" type="text/javascript"></script>
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <form class="form-signin" id="signinForm" action="login.do" method="post">
                
                    <img class="logo" src="./images/logo.png">
                    <br></br>
                    <h4 class="form-signin-heading">Please sign in</h4>
                    
                    <%
                        if ( request.getAttribute("message") != null )
                            out.println("<p>" + request.getAttribute("message") + "</p>");
                    %>
                    
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Email address" autofocus name="inputEmail">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Password" name="inputPassword">
                    </div>
                    <label class="checkbox">
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                    <input type="hidden" name="action" value="login" />
                    <button class="btn btn-primary btn-block" type="submit">Sign in</button>
                
            </form>
        </div> <!-- /container -->
    </body>
</html>

