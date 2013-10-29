<%-- 
    Document   : signup
    Created on : 24-Oct-2013, 5:19:00 PM
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

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <fieldset>
                <legend>Sign up</legend>
                <form class="">
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputName" placeholder="First">
                            <input type="text" class="form-control" id="inputName" placeholder="Last">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputEmail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Confirm password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputEmail">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> I agree to the uAvailable Terms of Service and Privacy Policy
                                </label>
                            </div>
                        </div>
                    </div>
                    <!--<div class="form-group">
                        <label for="inputPhone" class="col-lg-2 control-label">Mobile Phone</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPhone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBDay" class="col-lg-2 control-label">Birthday</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="selectMonth">
                                <option selected hidden>Month</option>
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
                            <input type="text" class="form-control" id="inputDay" placeholder="Day">
                            <input type="text" class="form-control" id="inputYear" placeholder="Year">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="select" class="col-lg-2 control-label">Gender</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="selectGender">
                                  <option selected hidden>I am..</option>
                                  <option>Male</option>
                                  <option>Female</option>
                            </select>

                            <div class="checkbox">
                                <label>
                                  <input type="checkbox"> I agree to the uAvaiable Terms of Service and Privacy Policy
                                </label>
                            </div>
                        </div>
                    </div>-->
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-default">Cancel</button> 
                            <button type="submit" class="btn btn-primary">Sign up</button> 
                        </div>
                    </div>
                </div>
            </fieldset>
        </div>
            
         <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
    </body>
</html>