var ajaxUnterricht = "unterricht";
var ajaxKind = "kind";
var ajaxZahlung = "zahlung";


$(function () {

    $('#calendar').fullCalendar({
        header: {center: 'month,agendaWeek,list'}, // buttons for switching between views

        dayClick: function (date, jsEvent, view) {
            var myModal = $('#createUnterricht');

            $('#datum').val(date.format());
            getKind();
            getZahlung();
            $(this).on("click", function () {
                myModal.modal('toggle');
                myModal.on('hidden.bs.modal', function () {
                    $(this).find('form')[0].reset();
                })

            });
        },
        themeSystem: 'bootstrap4',
        height: 650,
        bootstrapFontAwesome: {
            prev: 'fas fa-angle-left',
            next: 'fas fa-angle-right'
        },
        firstDay: 1,
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
        eventRender: function (eventObj, $el) {
            $el.popover({
                title: eventObj.title,
                content: eventObj.notiz,
                trigger: 'hover',
                placement: 'top',
                container: 'body'
            });
        },
        eventSources: [{
            url: 'http://localhost:8080/unterricht'
        }],
        timeFormat: 'HH:mm',
        timezone: 'local',
        eventLimit: true,
        views: {
            month: {
                titleFormat: 'YYYY MMMM ',
                eventLimit: 2
            }
        }
    });

    $(function () {
        $('#timepicker').timepicker({
            format: 'HH:MM',
            modal: false,
            header: false,
            footer: false,
            value: '00:00',
            mode: '24hr',
            uiLibrary: 'bootstrap4'
            // locale: 'ru-ru'
        });
    });

    // $('#timepicker').datetimepicker({
    //     // showOn: 'focus',
    //     // hourText: 'Часы',             // Define the locale text for "Hours"
    //     // minuteText: 'Минуты'
    // });
});

function getKind() {
    var sel = document.getElementById('kind');
    var opt = null;
    $('#kind').empty().append('<option disabled selected>Выберите ученика</option>');
    $.getJSON(ajaxKind + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            opt = document.createElement('option');
            opt.value = val.id;
            opt.innerHTML = val.name;
            sel.appendChild(opt);
        });
    });
}

function getZahlung() {
    var sel1 = document.getElementById('zahlung');
    var opt1 = null;
    $('#zahlung').empty().append('<option disabled selected>Выберите оплату</option>');
    $.getJSON(ajaxZahlung + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            opt1 = document.createElement('option');
            opt1.value = val.id;
            opt1.innerHTML = val.name;
            sel1.appendChild(opt1);
        });
    });
}

function saveUnterricht() {
    $.post(ajaxUnterricht + '/save', $('#detailsForm').serialize())
        .done(function () {
        $('#createUnterricht').modal('hide');
        $('#calendar').fullCalendar('refetchEvents');
    });
}





