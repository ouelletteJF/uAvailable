$(document).ready(function(){
    $('form').validate({
        rules: {
            inputFirst: {
                minlength: 2,
                required: true
            },
            inputLast: {
                minlength: 2,
                required: true
            },
            inputEmail: {
                required: true,
                email: true
            },
            inputPassword: {
                required: true
            },
            inputPassword_again: {
                equalTo: "#inputPassword"
            },
            agreed:{
                required : true
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        }
    });
});