var messageId;

$(function () {

});

function answerIt(id) {
    var message = $('#add-message');
    message.css('display', 'block');
    message.scrollTo();
    messageId = id;
}


function saveMessage() {

}

function hideMessageArea() {
    $('#add-message').css('display', 'none');
    $('#message-form')[0].reset();
    $('.card-header :input[value="'+messageId+'"]').parent().parent().parent().scrollTo();
}

$.fn.scrollTo = function () {
    $('html, body').animate({
            scrollTop: $(this).offset().top
        }, 1000);
};


