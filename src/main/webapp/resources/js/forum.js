var messageId;
var answer;

$(function () {

});

function changeToUnblocked(id){

}

function changeToBlocked(id){
    $.get("/api/admin/" + id)
        .done(function(data){
            $('#name').val(data.name);
            $('#createBlock').modal("show");
        });
    $('#saveBlock').on('click', function(){
        $.post("/api/admin/block/" + id, $('#block-detailsForm').serialize())
            .done(function(){
            location.reload();
        });
    });


}

function changeForumLanguage(lang){
    console.log(location.href);
    var locale = "&locale=";
    var link = location.pathname.includes('/forum')? location.href.split("?")[0] : location.href;
    var url = link + (link.includes('?')? "&" : "?") + "page=" + ($('.page-input').attr('this') - 1) + "&size=" + $('.page-size').val();
    location.href = (url.includes(locale)? url.split(locale)[0] : url.includes('#')? url.split('#')[0] : url) + locale + lang;
}

function toggleThema(id){
    $.post("/forum/toggle", {id : id})
        .done(function(data){
            location.href = "/forum?page=" + data;
        })
}

function countClicks(id){
    $.post("/forum/views", {id: id});
}

function answerIt(id, isThema) {
    if (answer !== undefined) {
        hideMessageArea();
    }
    messageId = id;
    answer = true;
    var message = $('#add-message');
    message.scrollTo();
    addTextArea(id, message, isThema);
}

function addTextArea(id, message, isThema) {
    $.get("/nachricht/text", {id: id, answer: answer})
        .done(function (data) {
            message.html(data);
            message.find('#text-message').focus();
            if (id === null && isThema) {
                $('#thema-title-invisible').css('display', 'block');
                message.find('#thema-title-text').focus();
                saveThema();
            } else {
                message.find('#text-message').focus();
                saveMessage(id);
            }

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

function saveThema() {
    $('.btn-ok').on('click', function () {
        $.post("/forum/save", {thema: $('#thema-title-text').val(),
            message: $('#text-message')[0].innerText})
            .done(function (id) {
                location.href = "/nachricht?id=" + id;
            });
    });
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
            var id = $('#themaId').val();
            location.reload();
            if (data.reload) {
                location.href = "/nachricht?id=" + id + "&page=" + data.page
                    + "&size=" + size + "#" + data.id;
            }
        });
    });
}

function deleteMessage(id) {
    $(this).on('click', function () {
        $.get("/nachricht/delete", {id: id})
            .done(function () {
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
    answer = '';
}

$.fn.scrollTo = function () {
    $('html, body').animate({
        scrollTop: $(this).length === 0? 0 : $(this).offset().top
    }, 1000);
};