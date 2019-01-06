var ajaxUnterricht = "unterricht";
var ajaxKind = "kind";
var ajaxZahlung = "zahlung";
var calendar = null;
var myModal = $('#createUnterricht');
var kindBtn = null;
var zahlungBtn = null;

$(function () {
    var zt = getNow();
    createFullCalendar(zt);
    dateTimePicker(zt);
})
;

function getNow() {
    var dt = new Date($.now());
    return (dt.getHours() < 10 ? '0' : '') + dt.getHours() + ":" + (dt.getMinutes() < 10 ? '0' : '') + dt.getMinutes();
}

function createFullCalendar(zt) {
    calendar = $('#calendar').fullCalendar({
        header: {center: 'month, agendaWeek, list'},

        dayClick: function (date, jsEvent, view) {
            createUnterricht(date, zt);
        },
        themeSystem: 'bootstrap4',
        height: 650,
        bootstrapFontAwesome: {
            prev: 'fas fa-angle-left',
            next: 'fas fa-angle-right'
        },
        firstDay: 1,
        eventClick: function (event) {
            updateUnterricht(event, zt);
        },
        eventDragStart: function (event, jsEvent, ui, view) {
            window.eventScrolling = true;
        }
        ,
        eventDragStop: function (event, jsEvent, ui, view) {
            window.eventScrolling = false;
        }
        ,
        eventRender: function (eventObj, el) {
            if (window.eventScrolling) return;
            el.popover({
                title: eventObj.title,
                content: eventObj.notiz,
                trigger: 'hover',
                placement: 'top',
                container: 'body'
            });
        }
        ,
        eventResize: function (event, delta, revertFunc) {
            $(".popover").remove();
        }
        ,
        eventSources: [{
            url: ajaxUnterricht
        }],
        timeFormat:
            'HH:mm',
        timezone:
            'local',
        eventLimit:
            true,
        views:
            {
                month: {
                    titleFormat: 'YYYY MMMM ',
                    eventLimit:
                        2
                }
            },
        editable: true,
        eventDrop:
            function (event, dayDelta, revertFunc) {
                onDrop(event);
            }
    });
}

function onDrop(event) {
    $.post(ajaxUnterricht + "/update/ondrop/" + event.id, "date=" + event.start.format())
        .done(function () {
            calendar.fullCalendar('refetchEvents');
            $(".popover").remove();
        });
}

function dateTimePicker(zt) {
    $(function () {
        $('#zeit').timepicker({
            format: 'HH:MM',
            modal: false,
            header: false,
            footer: false,
            value: zt,
            mode: '24hr',
            uiLibrary: 'bootstrap4'
        });
    });
}

function createMenuButton(btn, aktiv) {
    if (aktiv) {
        btn.removeClass('btn-outline-primary');
        btn.text('Деактивировать ' + btn.data('name'));
        btn.addClass('btn-outline-info');
    } else {
        btn.removeClass('btn-outline-info');
        btn.text('Aктивировать ' + btn.data('name'));
        btn.addClass('btn-outline-primary');
    }
}

function deleteUnterricht() {
    $.post(ajaxUnterricht + "/delete/" + $('#delete-unt').data('id')).done(function () {
        myModal.modal('hide');
    });
}

function toggleThis(btn) {
    $.post(btn.data('url') + "/toggle/" + btn.data('id')).done(function (data) {
        toggleOnOff(data);
        createMenuButton(btn, btn.hasClass('btn-outline-primary'));
    });
}

function renderDeleteBtn(id) {
    var btn = $('<button type="button" class="btn btn-outline-danger temp" id="delete-unt" onclick="deleteUnterricht()">Удалить</button>');
    btn.data('id', id);
    return btn;
}

function renderMenuBtn(id, name, url, aktiv) {
    var btn = $('<button type="button" class="btn temp" style="width:100%;"></button>');
    btn.data('id', id);
    btn.data('name', name);
    btn.data('url', url);
    createMenuButton(btn, aktiv);
    return btn;
}

function getSelect(url, sel, name) {
    sel.empty().append('<option disabled selected>' + name + '</option>');
    $.getJSON(url + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            sel.append('<option value="' + val.id + '">' + val.name + '</option>')
        });
    });
    return sel;
}

function saveUnterricht() {

    $.post(ajaxUnterricht + '/save', $('#detailsForm').serialize())
        .done(function () {
            $('#createUnterricht').modal('hide');
            calendar.fullCalendar('refetchEvents');
        });
}

function updateUnterricht(event, zt) {
    var kindSelect = $('#kind');
    var zahlungSelect = $('#zahlung');
    $('#create').text('Изменить урок');
    kindSelect.hide();
    zahlungSelect.hide();
    $.get(ajaxUnterricht + "/get/" + event.id).done(function (data) {
        kindBtn = renderMenuBtn(data.kind, data.kindTo.name, ajaxKind, data.kindTo.aktiv);
        zahlungBtn = renderMenuBtn(data.zahlung, data.zahlungTo.name, ajaxZahlung, data.zahlungTo.aktiv);
        kindBtn.appendTo('#kind-div');
        zahlungBtn.appendTo('#zahlung-div');

        $('textarea').val(data.notiz);
        $('#id').val(data.id);
        $('#datum').val(data.datum);
        $('#bezahlt').prop('checked', data.bezahlt);
        $('#zeit').val(data.zeit);

        kindBtn.on('click', function () {
            toggleThis(kindBtn);

        });
        zahlungBtn.on('click', function () {
            toggleThis(zahlungBtn);
        });
    });

    $('.modal-footer').prepend(renderDeleteBtn(event.id));
    showModal(myModal);

    myModal.on('hidden.bs.modal', function () {
        $(this).find('form')[0].reset();
        calendar.fullCalendar('refetchEvents');
        kindSelect.show();
        zahlungSelect.show();
        $('#zeit').val(zt);
        $('.temp').remove();
    });
}

function createUnterricht(date, zt) {
    $('#create').text('Создать урок');
    $('#datum').val(date.format());
    getSelect(ajaxKind, $('#kind'), 'Выберите ученика');
    getSelect(ajaxZahlung, $('#zahlung'), 'Выберите оплату');
    $(this).on('click', function () {
        myModal.modal('show');
    });
    myModal.on('hidden.bs.modal', function () {
        $(this).find('form')[0].reset();
        $('#zeit').val(zt);
    });
}








