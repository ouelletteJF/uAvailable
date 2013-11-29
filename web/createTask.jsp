<%-- 
    Fichier:	createTask.jsp
    Contenu:	Page qui affiche le panneau de création d'une tâche dans la To-Do List

    Auteur:	Jean-François Ouellette
    Version:	1.0

    Date de création:	25 novembre 2013
    Dernière modification:	-
    Raison mise à jour:	-

    À faire:    -
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.uavailable.entites.Membre"%>
<%@page import="com.uavailable.entites.Tache"%>
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
            Tache t = null;
            
            Boolean editMode = false;
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
            
            if ( request.getParameter("action").equals("edit") ) {
                Integer idL = Integer.parseInt( request.getParameter("list") ),
                        idT = Integer.parseInt( request.getParameter("task") );
                
                editMode = true;
                t = m.getToDoList().getListes().get(idL).getTaches().get(idT);
            }
                
        %>
        
        <div class="container">
            <fieldset>
                <legend> <% if (editMode) out.println("Edit Task"); else out.println("Create Task"); %> </legend>
                <form class=""  <% if (editMode) out.println("action='editTask.do'"); else out.println("action='addTask.do'"); %> method="post">
                    
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputName" placeholder="Name" <% if (editMode) out.println("value='" + t.getNom() + "'"); %>  >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescription" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputDescription" placeholder="Description..." <% if (editMode) out.println("value='" + t.getDescription() + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDueDate" class="col-lg-2 control-label">Due Date</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputDueDate" placeholder="dd/MM/yy hh:mi:ss" <% if (editMode) out.println("value='" + sdf.format( t.getDateButoire() ) + "'"); %>>
                        </div>
                    </div>
                        <div class="form-group">
                        <label for="inputCompleted" class="col-lg-2 control-label">Completed</label>
                        <div class="col-lg-10">
                            <input type="checkbox" class="form-control" name="inputCompleted" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPriority" class="col-lg-2 control-label">Priority</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputPriority" <% if (editMode) out.println("value='" + t.getPriorite() + "'"); %>>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAlert" class="col-lg-2 control-label">Alert</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputAlert" <% if (editMode) out.println("value='" + t.getRappel() + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputList" class="col-lg-2 control-label">List</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputList" <% if (editMode) out.println("value='" + String.valueOf(t.getIdListe()) + "'"); %> >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="hidden" name="action" <% if (editMode) out.println("value='editTask'"); else out.println("value='addTask'"); %> /><br />
                            
                            <% 
                            if (editMode) 
                                out.println("<input type='hidden' name='task' value='" + String.valueOf(t.getId()) + "' />"); 
                            %> 
                            
                            <button type="submit" class="btn btn-primary"> <% if (editMode) out.println("Edit Task"); else out.println("Create Task"); %> </button> 
                        </div>
                    </div>
		</form>
            </fieldset>
        </div><!-- /container -->
    </body>
</html>
