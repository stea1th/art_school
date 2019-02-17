var messageId;
var answer;
var ajaxUrl = "nachricht";
$(function () {

    resizeTextArea();

    saveMessage();

});

function answerIt(id) {
    messageId = id;
    if (answer !== undefined) {
        hideMessageArea();
    }
    var message = $('#add-message');
    answer = true;
    message.css('display', 'block');
    addMessageToTextArea(id, message);
    message.scrollTo();


}

function addMessageToTextArea(id, message) {
    var text = $('#user-message_' + id)[0].textContent.trim();
    if (answer) {
        text = "[quote]" + text + "[/quote]";
    }
    message.find('#text-message').val(text + "\n");

}

function updateMessage(id) {
    messageId = id;
    if (answer !== undefined) {
        hideMessageArea();
    }
    var message = $('#add-message_' + id);
    message.id = id;
    answer = false;
    $('#user-message_' + id).hide();
    addMessageToTextArea(id, message);
    message.css('display', 'block');
    messageId = id;
}


function saveMessage() {
    $('.btn-ok').on('click', function () {
        var form = $(this).parent().find('form');
        $.post("/nachricht/save", form.serialize())
            .done(function () {
                location.reload();
            });
    });


}

function hideMessageArea() {
    if (answer) {
        $(`#add-message`).css('display', 'none');
        $('#left-card_' + messageId).scrollTo();
        $('#add-message').find('#text-message').val('');
    } else {
        $(`#add-message_${messageId}`).css('display', 'none');
        $('#add-message_' + messageId).find('#text-message').val('');
        $('#user-message_' + messageId).show();
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


