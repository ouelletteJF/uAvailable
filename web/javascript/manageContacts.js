
/*
 *	Fichier:	manageContacts.js
 *	Contenu:	Fichier JavaScript qui contient les différentes fonction permettant la gestion des contacts
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	29 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    -
 *
*/

function searchContact(nameValue)
{     
    var jqxhr = $.ajax({ type: "POST", url: "http://localhost:8080/uAvailable/searchContact", data: {inputName:nameValue},
        success : function(data)
        {
            var reponse = eval("(" + data + ")");
            alert("aaa");
            var content = "<hr />";
            
            // Pour chaque case contenant une piece...
            if( reponse.length > 0 )
                for(var i = 0; i < reponse.length; i++ ) 
                    content += "<div><h3>" + reponse[i].prenom + " " + reponse[i].nom + "</h3> <p>" + reponse[i].courriel + " <br />" + reponse[i].tel +" </p> </div>"
             //   
            else
                content += "Aucun résultat trouvé.";
            
            $("#searchResults").html(content);
        }
    });
}