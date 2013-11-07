<%-- 
    Document   : index
    Created on : 2013-10-08, 10:49:00
    Author     : Usager
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
        <link href="./style/index.css" rel="stylesheet">
        <link href="./style/style.css" rel="stylesheet">
        
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
            <form class="form-menu" id="signinForm">
                
                    <img class="logo" src="./images/logo.png">
                    <br></br>
                    <ul class="list-group">
                        <a href=""><li class="list-group-item"><img class="icon" src="./images/schedule_icon.png">Schedule<img class="arrow_icon" src="./images/arrow_icon.png"></li></a>
                        <a href=""><li class="list-group-item"><img class="icon" src="./images/todolist_icon.png">To-Do list<img class="arrow_icon" src="./images/arrow_icon.png"></li></a>
                        <a href="contacts.jsp"><li class="list-group-item"><img class="icon" src="./images/contacts_icon.png">Contacts<img class="arrow_icon" src="./images/arrow_icon.png"></li></a>
                        <a href=""><li class="list-group-item"><img class="icon" src="./images/settings_icon.png">Settings<img class="arrow_icon" src="./images/arrow_icon.png"></li></a>
                    </ul>
                
            </form>
        </div> <!-- /container -->
    </body>
</html>
