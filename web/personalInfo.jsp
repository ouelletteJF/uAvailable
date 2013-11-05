<%-- 
    Document   : personalInfo
    Created on : 24-Oct-2013, 6:46:41 PM
    Author     : Steven
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
        <link href="./style/signup.css" rel="stylesheet">
        
        <!-- Javascript -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <fieldset>
                <legend>Manage Personal Information</legend>
                <form class="">
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputName" value="Steven">
                            <input type="text" class="form-control" id="inputName" value="Lacroix">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail" value="stevenlacroixv4s973@gmail.com" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhone" class="col-lg-2 control-label">Mobile Phone</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPhone" value="514-574-2346">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBDay" class="col-lg-2 control-label">Birthday</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="selectMonth">
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
                            <input type="text" class="form-control" id="inputDay" value="18">
                            <input type="text" class="form-control" id="inputYear" value="1992">
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
                            <button type="submit" class="btn btn-primary">Confirm changes</button> 
                        </div>
                    </div>
                </form>
            </fieldset>
        </div> <!-- /container -->
    </body>
</html>
