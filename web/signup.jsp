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
        <div class="container">
            <fieldset>
                <legend>Sign up</legend>
                <form class=""  action="signup.do" method="post">
                    
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputFirst" placeholder="First">
                            <input type="text" class="form-control" name="inputLast" placeholder="Last">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" name="inputEmail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" name="inputPassword" id="inputPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Confirm password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" name="inputPassword_again">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="agreed"> I agree to the uAvailable Terms of Service and Privacy Policy
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-default">Cancel</button> 
                            <input type="hidden" name="action" value="signup" /><br />
                            <button type="submit" class="btn btn-primary">Sign up</button> 
                        </div>
                    </div>
		</form>
            </fieldset>
        </div><!-- /container -->
    </body>
</html>