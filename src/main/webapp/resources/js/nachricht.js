var messageId;
var answer;
var ajaxUrl = "nachricht";
$(function () {

    resizeTextArea();

    // saveMessage();

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
    // messageId = id;
    // if (answer !== undefined) {
    //     hideMessageArea();
    // }
    // var message = $('#add-message');
    // answer = true;
    // message.css('display', 'block');
    // addMessageToTextArea(id, message);
    // message.scrollTo();
    // saveMessage(id);
}

function addTextArea(id, message) {
    $.get("/nachricht/text", {id: id, answer: answer})
        .done(function (data) {
            message.html(data);
            message.find('#text-message').focus();
            saveMessage(id)
        });
}

/*function addMessageToTextArea(id, message) {
    var text = $('#user-message_' + id)[0].textContent.trim();
    if (answer) {
        text = "[quote]" + text + "[/quote]";
    }
    message.find('#text-message').val(text + "\n");
}*/

function updateMessage(id) {
    messageId = id;
    if (answer !== undefined) {
        hideMessageArea();
    }
    var message = $('#add-message_' + id);
    message.id = id;
    answer = false;
    $('#user-message_' + id).hide();
    addTextArea(id, message);
    message.css('display', 'block');
    messageId = id;
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
    }
}

$.fn.scrollTo = function () {
    $('html, body').animate({
        scrollTop: $(this).offset().top
    }, 1000);
};

function resizeTextArea() {

    //  changes mouse cursor when highlighting loawer right of box
    $(document).on('mousemove', 'textarea', function (e) {
        var a = $(this).offset().top + $(this).outerHeight() - 16,	//	top border of bottom-right-corner-box area
            b = $(this).offset().left + $(this).outerWidth() - 16;	//	left border of bottom-right-corner-box area
        $(this).css({
            cursor: e.pageY > a && e.pageX > b ? 'nw-resize' : ''
        });
    })
    //  the following simple make the textbox "Auto-Expand" as it is typed in
        .on('keyup', 'textarea', function (e) {
            //  the following will help the text expand as typing takes place
            while ($(this).outerHeight() < this.scrollHeight + parseFloat($(this).css("borderTopWidth")) + parseFloat($(this).css("borderBottomWidth"))) {
                $(this).height($(this).height() + 1);
            }
        });

}


