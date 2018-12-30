var ajaxUnterricht = "unterricht";
var ajaxKind = "kind";
var ajaxZahlung = "zahlung";
var calendar = null;
var myModal = $('#createUnterricht');
var kindBtn = null;
var zahlungBtn = null;

$(function () {

    var dt = new Date($.now());
    var zt = dt.getHours() + ":" + (dt.getMinutes() < 10 ? '0' : '') + dt.getMinutes();

    calendar = $('#calendar').fullCalendar({
        header: {center: 'month,agendaWeek,list'},

        dayClick: function (date, jsEvent, view) {

            $('#create').text('Создать урок');
            $('#datum').val(date.format());
            getKind();
            getZahlung();
            $(this).on("click", function () {
                myModal.modal('toggle');
                myModal.on('hidden.bs.modal', function () {
                    $(this).find('form')[0].reset();
                    $('#zeit').val(zt);
                });

            });
        },

        themeSystem: 'bootstrap4',
        height: 650,
        bootstrapFontAwesome: {
            prev: 'fas fa-angle-left',
            next: 'fas fa-angle-right'
        },
        firstDay: 1,
        eventClick: function (event) {
            var kindSelect = $('#kind');
            var zahlungSelect = $('#zahlung');
            $('#create').text('Изменить урок');
            kindSelect.hide();
            zahlungSelect.hide();
            $.get(ajaxUnterricht + "/get/" + event.id).done(function (data) {
                kindBtn = renderKindBtn(data.kind);
                zahlungBtn = renderZahlungBtn(data.zahlung);
                kindBtn.appendTo('#kind-div');
                zahlungBtn.appendTo('#zahlung-div');

                if (!data.kindTo.aktiv) {
                    kindBtn.text('Активировать ' + data.kindTo.name);
                } else {
                    kindBtn.text('Деактивировать ' + data.kindTo.name);
                }

                if (!data.zahlungTo.aktiv) {
                    zahlungBtn.text('Активировать ' + data.zahlungTo.name);
                } else {
                    zahlungBtn.text('Деактивировать ' + data.zahlungTo.name);
                }
                $('textarea').val(data.notiz);
                $('#id').val(data.id);
                $('#datum').val(data.datum);
                $('#bezahlt').prop('checked', data.bezahlt);
                $('#zeit').val(data.zeit);
            });
            showModal(myModal);

            myModal.on('hidden.bs.modal', function () {
                $(this).find('form')[0].reset();
                calendar.fullCalendar('refetchEvents');
                kindSelect.show();
                zahlungSelect.show();
                $('#zeit').val(zt);
                $('.temp').remove();
            });
        },
        eventDragStart:

            function (event, jsEvent, ui, view) {
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
            }
        ,

        editable: true,
        eventDrop:

            function (event, dayDelta, revertFunc) {

                $.post(ajaxUnterricht + "/update/ondrop/" + event.id, "date=" + event.start.format())
                    .done(function () {
                        calendar.fullCalendar('refetchEvents');
                        $(".popover").remove();
                    });
            }
    })
    ;

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
})
;

function toggleThisKind() {
    $.post(ajaxKind + "/toggle/" + kindBtn.data('id')).done(function(){
        myModal.modal('hide');
    });
    // location.reload();
}

function toggleThisZahlung() {
    $.post(ajaxZahlung + "/toggle/" + zahlungBtn.data('id')).done(function(){
        myModal.modal('hide');
    });
    // location.reload();
}

function renderKindBtn(id) {
    var btn = $('<button type="button" class="btn btn-outline-danger temp" style="width:100%;" onclick="toggleThisKind()"></button>');
    btn.data('id', id);
    return btn;
}

function renderZahlungBtn(id) {
    var btn = $('<button type="button" class="btn btn-outline-danger temp" style="width:100%;" onclick="toggleThisZahlung()"></button>');
    btn.data('id', id);
    return btn;
}

function getKind() {
    var sel = $('#kind');
    sel.empty().append('<option disabled selected>Выберите ученика</option>');
    $.getJSON(ajaxKind + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            sel.append('<option value="' + val.id + '">' + val.name + '</option>')
        });
    });
    return sel;
}


function getZahlung() {
    var sel = $('#zahlung');
    sel.empty().append('<option disabled selected>Выберите оплату</option>');
    $.getJSON(ajaxZahlung + "/filter/aktiv", function (data) {
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







