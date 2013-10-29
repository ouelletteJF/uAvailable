/*function validateForm(){
    
    var email = document.getElementById('inputEmail');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    email.classname = "form-control has-error";
    email.focus;
    return false;
    
    if(email.value != ""){
			var re = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
			if(!re.test(frm.elements['numid'].value)) { 
				msg = msg + "\n\nLe Num Id doit être une adresse de courriel.";
			}
		}
    
    var x=document.forms["siginForm"]["email"].value;
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        alert("Not a valid e-mail address");
        return false;
    }
    
    var x=document.forms["myForm"]["fname"].value;
    if (x==null || x==""){
        alert("First name must be filled out");
        return false;
    }
    }
}*/



    $('#signinForm').validate({
        rules: {
            inputEmail: {
                required: true,
                email: true
            },
            inputPassword: {
                minlength: 2,
                required: true
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        }/*,
        success: function (element) {
            element.text('OK!').addClass('valid')
                .closest('.control-group').removeClass('error').addClass('success');
        }*/
    });
