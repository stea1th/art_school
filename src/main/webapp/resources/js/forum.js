let messageId;
let answer;
let set = new Set();

$(function () {
    checkIfBlocked();

    scrollFunction();

    clickableIconsForAdmin();

    chooseAllThemes();

    proofSet(set);

    editThemeTitle();

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
                showModal({
                    id: $('#isBlocked'),
                    init: function () {
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
                    }
                });
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
        $('#choose-all-themes').empty().removeClass('checked').append('<span style="color: #1474C3 !important;"><i class="far fa-square"></i></span>');
    }
    const del = $('#delete-themes-btn');
    const edit = $('.edit-theme-btn');
    if (set.size === 0) {
        del.attr('disabled', 'disabled');
    } else {
        del.removeAttr('disabled');
    }
    if (set.size === 1) {
        $('.thema-icon.checked').parent().parent().find('.edit-theme-btn').removeAttr('hidden');
    } else {
        edit.attr('hidden', 'true');
    }
}

function checkThemeIcon(icon) {
    let parent = $(icon).parent().parent();
    set.add($(icon).data('themaid'));
    $(icon).empty().addClass('checked').append('<span><i class="fas fa-times"></i></span>');
    parent.find('.edit-theme-btn').removeAttr('hidden');
    parent.css('background-color', '#dbfae2');
}

function uncheckThemeIcon(icon) {
    let active = $(icon).data('item-active');
    let parent = $(icon).parent().parent();
    set.delete($(icon).data('themaid'));
    $(icon).empty().removeClass('checked').append(active ? '<span style="color: green !important;">\n' +
        '                            <i class="far fa-thumbs-up"></i>\n' +
        '                        </span>' : '<span style="color: red !important;">\n' +
        '                            <i class="fas fa-lock"></i>\n' +
        '                        </span>');

    parent.find('.edit-theme-btn').attr('hidden', 'hidden');
    parent.css('background-color', '');
}

function deleteThemes() {
    let arr = Array.from(set);
    $.get("/forum/delete", {arr: arr})
        .done(function () {
            $('.edit-theme-btn').attr('hidden', 'true');
            $('.thema-icon.checked').each(function () {
                changeColor({
                    element: $(this).closest('tr')[0],
                    property: 'background-color',
                    from: '#dbfae2',
                    to: '#fa4547',
                    duration: "1300ms",
                    timingFunction: "ease-in"
                });
            });
            succesNoty('<i class="fas fa-trash"></i>', "Wird gelöscht!!!");
            setTimeout("location.reload();", 1300);
        });
}

function editThemeTitle() {
    $('.edit-theme-btn').on('click', function () {
        showModal({
            id: $('#edit-title'),
            init: function () {
                $('#edit-title .modal-body').html('<form><div id="edit-title-wrapper"><input type="text" class="form-control" id="edit-title-input" maxlength="40" required/></div></form>');
                const checked = $('.thema-icon.checked');
                const edited = $('#edited');
                $('#edit-title-input').val(checked.closest('tr').find('.thema-title-href').text());
                edited.attr('themaId', checked.data('themaid'));
                edited.attr('onClick', 'updateTheme()');
            }
        });
    });
}

function updateTheme() {
    let map = new Map();
    let id = $('#edited').attr('themaId');
    let text = $('#edit-title-input').val();
    map.set('#edit-title-wrapper', text);

    if (!isInputEmpty(map)) {
        $.post('/forum/edit', {id: id, text: text})
            .done(function () {
                $('.edit-theme-btn').attr('hidden', 'true');
                $('#edit-title').modal("hide");
                changeColor({
                    element: $('.thema-icon.checked').closest('tr')[0],
                    property: 'background-color',
                    from: '#dbfae2',
                    to: '#fae349',
                    duration: "1300ms",
                    timingFunction: "ease-in"
                });
                succesNoty('<i class="fas fa-cog"></i>', "Wird geändert!!!");
                setTimeout("location.reload();", 1300);
            });
    }
}

function changeColor(config) {
    transition.begin(config.element, {
        property: config.property,
        from: config.from,
        to: config.to,
        duration: config.duration,
        timingFunction: config.timingFunction
    });
}


