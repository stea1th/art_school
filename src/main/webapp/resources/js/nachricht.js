var messageId;
var answer;
var ajaxUrl = "nachricht";
$(function () {

});

function answerIt(id) {
    if (answer !== undefined) {
            hideMessageArea();
        }
    messageId = id;
    answer = true;
    var message = $('#add-message');
    message.scrollTo();
    addTextArea(id, message);
}

function addTextArea(id, message) {
    $.get("/nachricht/text", {id: id, answer: answer})
        .done(function (data) {
            message.html(data);
            message.find('#text-message').focus();
            saveMessage(id)
        });
}

function updateMessage(id) {
    messageId = id;
    if (answer !== undefined) {
        hideMessageArea();
    }
    var message = $('#add-message_' + id);
    answer = false;
    $('#user-message_' + id).hide();
    addTextArea(id, message);
}


function saveMessage(id) {
    $('.btn-ok').on('click', function () {
        var size = $('.page-size').val();
        $.post("/nachricht/save", {
            id: $(this).parent().find('#id').val(),
            themaId: $('#themaId').val(),
            size: size,
            text: $(this).parent().find('.text-message')[0].innerText,
            page: $('.page-input').attr('this'),
            parentId: id
        }).done(function (data) {
            location.href = "/nachricht?id="+ $('#themaId').val() + "&page=" + data
                +"&size=" + size;
            });
    });
}

function deleteMessage(id){
    $(this).on('click', function(){
        $.get("/nachricht/delete", {id: id})
            .done(function(){
                location.reload();
            });
    });

}

function hideMessageArea() {
    if (answer) {
        $(`#add-message`).empty();
        $('#left-card_' + messageId).scrollTo();
    } else {
        $(`#add-message_${messageId}`).empty();
        $('#user-message_' + messageId).show();
    }
}

$.fn.scrollTo = function () {
    $('html, body').animate({
        scrollTop: $(this).offset().top
    }, 1000);
};



