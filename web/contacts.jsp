<%-- 
    Fichier:	contacts.jsp
    Contenu:	Page qui liste tous les contacts

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
        <link rel="stylesheet" type="text/css" href="./style/jquery.mobile-1.2.0.min.css" />
        <link rel="stylesheet" type="text/css" href="./style/jquery.mobile.alphascroll.css" />
        
        <!-- Javascript -->
        <script type="text/javascript" src="./javascript/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile-1.2.0.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile.alphascroll.js"></script>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="../../assets/js/html5shiv.js"></script>
            <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
        <script>
            $( document ).ready( function() {

                    names = ["Hannah Gilbert","JaMarcus Davidson","Sofia Wesley","Mark Smith","Genesis Hailey","Amelia Webster","Leah Hodges","Jocelyn Higgins","Madelyn Galbraith","Gabrielle Wayne","Elizabeth Cook","Zoe Calhoun","Natalie Sheldon","Maya Geraldo","Isabelle Morrison","Maria Turner","Lauren Hoggarth","Madelyn Osborne","Vanessa Nash","Khloe Mercer","Rachel Garblinski","Steven Goldman","Hailey Carrington","Judith Brickman","Julia Oliver","Jasmine Abramson","Brooke Creighton","Sophie Wainwright","Gabriella Walkman","Archibald Carrington","Isabella Haig","Peter Carrington","Gabrielle Crofton","Makayla Chandter","Miles Turner","Isabelle Wainwright","Andrew WifKinson","Brenda Brown","Scotty Nash","Ariana Clapton","Peyton Fulton","Victoria Brown","Molly Daniels","Cynthia Monroe","Payton Thomson","Payton Wainwright","Kylie Webster","Harry Chiglitz","Lawrence Gilson","Olivia Cook","Henry Miller","Natalie Smith","Zoey Wainwright","Charlotte Gardner","Ira Wallace","Samantha Brickman","Hannah Galbraith","Kayla Davidson","Nevaeh Osborne","Gabrielle Chesterton","Katherine Hamphrey","Jerry Michaelson","Victoria Gibbs","Barry Goodman","Vincent Wilthorpe","Barney Mercer","Camilla Kapinksy","Jessica Cook","Kaitlyn Vaughan","Evelyn Nash","Trinity Neal","Melanie Oswald","Sophia Goldman","Kimberly Nathan","Ashley Carter","Elizabeth Abramson","Vinny Amarillo","Layla Gardner","Irma Nathan","Leah Galbraith","Katherine Miln","Caroline Miller","Ernie Carter","Winston Smith","Fyodor Dostoevsky","Neville James","Lucrecious Carter","Zebediah Jones"];
                    names.sort();

                    var namesListHTML = '';
                    $.each( names, function( i ) {
                            namesListHTML += '<li class="list-group-item" data-icon="false"><a href="aContact.jsp">' + names[i] + '</a></li>';
                    });
                    $( '#mylistview' ).append( namesListHTML );
                    $( '#mylistview' ).listview( 'refresh' ).alphascroll();

            });
        </script>
    </head>

    <body>
        <div class="container">
            <div id="alphascroll" data-role="page">
	<div data-role="header" data-position="fixed">
		<h1>Contacts</h1>
	</div>
	<div data-role="content">
		<ul id="mylistview" data-role="listview" data-autodividers="true"></ul>
	</div>
	<div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a href="#">Edit</a></li>
                    <li><a href="#">Add</a></li>
                    <li><a href="#">Groups</a></li>
                </ul>
            </div>
	</div>
        </div>

        </div> <!-- /container -->
    </body>
</html>