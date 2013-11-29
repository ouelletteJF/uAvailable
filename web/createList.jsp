<%-- 
    Fichier:	createList.jsp
    Contenu:	Page qui affiche le panneau de création d'une liste dans la To-Do List

    Auteur:	Jean-François Ouellette
    Version:	1.0

    Date de création:	25 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

<%@page import="com.uavailable.entites.Liste"%>
<%@page import="com.uavailable.entites.Membre"%>
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
        <link href="./style/style.css" rel="stylesheet">
        
        <!-- Javascript -->
        <script src="./javascript/jquery-2.0.3.js"></script>
        <script src="./javascript/jquery.validate.js"></script>
        <script src="./javascript/signup.js" type="text/javascript"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        
        <%
            Membre m = (Membre) session.getAttribute("user");
            Liste l = null;
            
            Boolean editMode = false;
                        
            if ( request.getParameter("action").equals("edit") ) {
                Integer idL = Integer.parseInt( request.getParameter("list") );
                
                editMode = true;
                l = m.getToDoList().getListes().get(idL);
            }
                
        %>
        
        <div class="container">
            <fieldset>
                <legend> <% if (editMode) out.println("Edit List"); else out.println("Create List"); %> </legend>
                <form class=""  <% if (editMode) out.println("action='editList.do'"); else out.println("action='addList.do'"); %> method="post">
                    
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputName" placeholder="Name" <% if (editMode) out.println("value='" + l.getNom() + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescription" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputDescription" placeholder="Description..." <% if (editMode) out.println("value='" + l.getDescription() + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputColor" class="col-lg-2 control-label">Color</label>
                        <div class="col-lg-10">
                            <input type="color" class="form-control" name="inputColor" placeholder="Choose a color..." <% if (editMode) out.println("value='" + l.getCouleur() + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="hidden" name="action" <% if (editMode) out.println("value='editList'"); else out.println("value='addList'"); %> /><br />
                            
                            <% 
                            if (editMode) 
                                out.println("<input type='hidden' name='list' value='" + String.valueOf(l.getId()) + "' />"); 
                            %> 
                            
                            <button type="submit" class="btn btn-primary"> <% if (editMode) out.println("Edit List"); else out.println("Create List"); %> </button> 
                        </div>
                    </div>
		</form>
            </fieldset>
        </div><!-- /container -->
    </body>
</html>
