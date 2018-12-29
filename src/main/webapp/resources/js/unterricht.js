var ajaxUnterricht = "unterricht";
var ajaxKind = "kind";
var ajaxZahlung = "zahlung";
var calendar = null;
var myModal = $('#createUnterricht');
var kindSelect;
var zahlungSelect;
var btnKind;
var btnZahlung;
var zt;


$(function () {
    $.ajaxSetup({ cache: false });

    var dt = new Date($.now());
    zt = dt.getHours() + ":" + (dt.getMinutes() < 10 ? '0' : '') + dt.getMinutes();

    kindSelect = getKind();
    zahlungSelect = getZahlung();


    calendar = $('#calendar').fullCalendar({
        header: {center: 'month,agendaWeek,list'},

        dayClick: function (date, jsEvent, view) {

            $('#datum').val(date.format());
            // getKind();
            // getZahlung();
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
            updateUnterricht(event.id);
        },
        // eventClick: function (event) {
        //     // alert(event.id +" "+event.notiz);
        //     // $(this).popover({html:true,title:event.title,content:event.notiz,placement:'top',container:'body'}).popover('show');
        //     $(this).popover({
        //         html:true,
        //         animation: true,
        //         title:event.title,
        //         container: 'body',
        //         content: event.notiz,
        //         placement:'top'}).popover('show');
        //
        //     return false;


        // if(event.title!=='CLICKED!'){
        //     event.title = "CLICKED!";
        // }else{
        //     event.title = "YAHOO!!!!";
        // }
        // event.css('color', 'red');
        // $('#calendar').fullCalendar('updateEvent', event);
        // },
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
        views: {
            month: {
                titleFormat: 'YYYY MMMM ',
                eventLimit:
                    2
            }
        },
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

function updateUnterricht(id) {
    $.get(ajaxUnterricht + "/get/" + id).done(function (data) {
        // var kindId = data.kind;
        btnKind = renderKindBtn(data.kind);
        // console.log(btnKind.data('id'));
        btnZahlung = $('<button type="button" class="btn btn-outline-danger temp" onclick="toggleThisZahlung(id)">Сделать активным</button>');

        kindSelect.val(data.kind).change();
        if (kindSelect.val() == null) {
            kindSelect.hide();
            btnKind.appendTo('#kind-div');
        }
        zahlungSelect.val(data.zahlung).change();
        if (zahlungSelect.val() == null) {
            zahlungSelect.hide();
            btnZahlung.appendTo('#zahlung-div');
        }
        $('textarea').val(data.notiz);
        $('#id').val(data.id);
        $('#datum').val(data.datum);
        $('#bezahlt').prop('checked', data.bezahlt);
        $('#zeit').val(data.zeit);

        showModal(myModal);

        myModal.on('hidden.bs.modal', function () {
            $(this).find('form')[0].reset();
            kindSelect.show();
            zahlungSelect.show();
            $('#zeit').val(zt);
            $('.temp').remove();
        });
    });
}

function toggleThisKind() {
    var id = btnKind.data('id');
    $.when(toggleThisWithUrl(ajaxKind, id)).done(function () {
        doAfterToggle(id);
    });
}

function doAfterToggle(id) {
    kindSelect = getKind();
    kindSelect.val(id);
    btnKind.remove();
    calendar.fullCalendar('refetchEvents');
    kindSelect.show();
}

function renderKindBtn(id) {
    var btn = $('<button type="button" class="btn btn-outline-danger temp" onclick="toggleThisKind()">Сделать активным</button>');
    btn.data('id', id);
    return btn;
}

function getKind() {
    var sel = $('#kind');
    sel.empty().append('<option disabled selected>Выберите ученика</option>');
    $.getJSON(ajaxKind + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            console.log(val.id+" "+val.name);
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







