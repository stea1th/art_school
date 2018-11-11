var ajaxUnterricht = "unterricht";

$(function(){
    $('#test-btn').on('click', function(){
        $.get(ajaxUnterricht+"/test")
            .done(function(){
                alert("Test is successful!");
            });
    });


});