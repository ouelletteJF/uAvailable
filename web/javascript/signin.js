$(document).ready(function(){
    $('form').validate({
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
        }
    });
});