var messageId;
var answer;
$(function () {

});

function answerIt(id) {
    var message = $('#add-message');
    message.css('display', 'block');
    message.scrollTo();
    messageId = id;
    answer = true;
}

function updateMessage(id){
    var message = $('#add-message_'+id);
    // $('#message-submit').text("Изменить");
    message.css('display', 'block');
    messageId = id;
    answer = false;
}


function saveMessage() {

}

function hideMessageArea() {
    if(answer){
        $('#add-message').css('display', 'none');
        $('#left-card_'+ messageId).scrollTo();
    } else {
        $('#add-message_' + messageId).css('display', 'none');
    }
    $('.message-form')[0].reset();
}

$.fn.scrollTo = function () {
    $('html, body').animate({
            scrollTop: $(this).offset().top
        }, 1000);
};


