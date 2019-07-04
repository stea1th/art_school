let messageId;
let answer;
let set = new Set();

$(function () {
    checkIfBlocked();

    scrollFunction();

    clickableIconsForAdmin();

    chooseAllThemes();

});

function topFunction() {
    $('head').scrollTo();
}

function scrollFunction() {
    $(window).scroll(function () {
        if ($('body')[0].scrollTop > 280) {
            $("#myBtn").css('display', 'block');
        } else {
            $("#myBtn").css('display', 'none');
        }
    });

}

function toggleAttach(id) {
    $.post("/forum/attach", {id: id}).done(function () {
        location.reload();
    });
}

function checkIfBlocked() {
    $.get("/api/kind/check")
        .done(function (data) {

            if (data !== "") {
                var hidden = $('#i18n');
                var string = [];
                string.push(
                    "<div>",
                    hidden.attr('attentionBlock'),
                    "</div><br><div>",
                    hidden.attr('reason'),
                    ":&nbsp;",
                    data.reason,
                    "</div><br><div>",
                    hidden.attr('blockedTill'),
                    ":&nbsp;",
                    data.date,
                    "</div><br><div>",
                    hidden.attr('blockedBy'),
                    ":&nbsp;",
                    data.blockedByName,
                    "</div>"
                );
                $('#isBlocked .modal-body').html(string);
                $('#isBlocked').modal("show");
            }
        });
    $('#accepted').on('click', function () {
        $.post("/api/kind/accepted")
            .done(function () {
                $('#isBlocked').modal("hide");
            });
    });
}

function changeToUnblocked(id) {
    $.post("/api/admin/unblock", {id: id})
        .done(function () {
            location.reload();
        });
}

function changeToBlocked(id) {
    $.get("/api/admin/" + id)
        .done(function (data) {
            $('#name').val(data.name);
            $('#createBlock').modal("show");
        });
    $('#saveBlock').on('click', function () {
        $.post("/api/admin/block/" + id, $('#block-detailsForm').serialize())
            .done(function () {
                location.reload();
            });
    });


}

function changeForumLanguage(lang) {
    var locale = "&locale=";
    var link = location.pathname.includes('/forum') ? location.href.replace('#', '') : location.href;
    link = location.pathname.includes('/forum') ? link.split("?")[0] : link;
    var url = link + (link.includes('?') ? "&" : "?") + "page=" + ($('.page-input').attr('this') - 1) + "&size=" + $('.page-size').val();
    location.href = (url.includes(locale) ? url.split(locale)[0] : url.includes('#') ? url.split('#')[0] : url) + locale + lang;
}

function toggleThema(id) {
    $.post("/forum/toggle", {id: id})
        .done(function (data) {
            location.href = "/forum?page=" + data;
        })
}

function countClicks(id) {
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
        let title = $('#thema-title-text').val();
        let text = $('#text-message')[0].innerText;
        let map = new Map();
        map.set('#thema-title-invisible', title);
        map.set('#thema-text-invisible', text);
        if (!isInputEmpty(map)) {
            $.post("/forum/save", {
                thema: title,
                message: text
            }).done(function (id) {
                location.href = "/nachricht?id=" + id;
            });
        }

    });
}

function saveMessage(id) {
    $('.btn-ok').on('click', function () {
        let size = $('.page-size').val();
        let map = new Map();
        let text = $(this).parent().find('.text-message')[0].innerText;
        map.set('#thema-text-invisible', text);
        if (!isInputEmpty(map)) {
            $.post("/nachricht/save", {
                id: $(this).parent().find('#id').val(),
                themaId: $('#themaId').val(),
                size: size,
                text: text,
                page: $('.page-input').attr('this'),
                parentId: id
            }).done(function (data) {
                let id = $('#themaId').val();
                location.reload();
                if (data.reload) {
                    location.href = "/nachricht?id=" + id + "&page=" + data.page
                        + "&size=" + size + "#" + data.id;
                }
            });
        }
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
        scrollTop: $(this).length === 0 ? 0 : $(this).offset().top
    }, 1000);
};

function clickableIconsForAdmin() {
    if ($('#check-theme-icon').attr('is-admin') === 'true') {
        const icons = $('.thema-icon');
        icons.css('cursor', 'pointer');
        icons.on('click', function () {
            if (!$(this).hasClass('checked')) {
                checkThemeIcon(this);
            } else {
                uncheckThemeIcon(this);
            }
            proofSet(set);
        });
    }
}

function chooseAllThemes() {
    if ($('#check-theme-icon').attr('is-admin') === 'true') {
        const icon = $('#choose-all-themes');
        icon.css('cursor', 'pointer');
        icon.on('click', function () {
            if (!$(this).hasClass('checked')) {
                $(this).empty().addClass('checked').append('<span style="color: #1474C3 !important;"><i class="fas fa-times"></i></span>');
                $('.thema-icon').each(function () {
                    checkThemeIcon(this);
                });
            } else {
                $(this).empty().removeClass('checked').append('<span style="color: #1474C3 !important;"><i class="far fa-circle"></i></span>');
                set.clear();
                $('.thema-icon').each(function () {
                    uncheckThemeIcon(this);
                });
            }
            proofSet(set);
        });

    }
}

function proofSet(set) {
    if (set.size !== $('.thema-icon').length) {
        $('#choose-all-themes').empty().removeClass('checked').append('<span style="color: #1474C3 !important;"><i class="far fa-circle"></i></span>');
    }

}

function checkThemeIcon(icon) {
    set.add($(icon).data('themaid'));
    $(icon).empty().addClass('checked').append('<span><i class="fas fa-times"></i></span>');
}

function uncheckThemeIcon(icon) {
    let active = $(icon).data('item-active');
    set.delete($(icon).data('themaid'));
    $(icon).empty().removeClass('checked').append(active ? '<span style="color: green !important;">\n' +
        '                            <i class="far fa-thumbs-up"></i>\n' +
        '                        </span>' : '<span style="color: red !important;">\n' +
        '                            <i class="fas fa-lock"></i>\n' +
        '                        </span>');
}


