var ajaxUnterricht = "unterricht";
var ajaxKind = "kind";
var ajaxZahlung = "zahlung";
var calendar = null;




$(function () {

    var dt = new Date($.now());
    var zt = dt.getHours()+":"+dt.getMinutes();


    calendar = $('#calendar').fullCalendar({
        header: {center: 'month,agendaWeek,list'},

        dayClick: function (date, jsEvent, view) {
            var myModal = $('#createUnterricht');

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
        eventClick: function(event){
            alert(event.id)
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
        eventDragStart: function( event, jsEvent, ui, view ) {
            window.eventScrolling = true;
        },
        eventDragStop: function( event, jsEvent, ui, view ) {
            window.eventScrolling = false;
        },
        eventRender: function (eventObj, el) {
            if(window.eventScrolling) return;
            el.popover({
                title: eventObj.title,
                content: eventObj.notiz,
                trigger: 'hover',
                placement: 'top',
                container: 'body'
            });
        },
        eventResize: function(event, delta, revertFunc) {
            $(".popover").remove();
        },
        eventSources: [{
            url: ajaxUnterricht
        }],
        timeFormat: 'HH:mm',
        timezone: 'local',
        eventLimit: true,
        views: {
            month: {
                titleFormat: 'YYYY MMMM ',
                eventLimit: 2
            }
        },

        editable: true,
        eventDrop: function(event, dayDelta, revertFunc) {

            $.post(ajaxUnterricht + "/update/ondrop/"+event.id, "date="+event.start.format())
                .done(function(){
                    calendar.fullCalendar('refetchEvents');
                    $(".popover").remove();
                });

            // if (!confirm("Are you sure about this change?")) {
            //     revertFunc();
            // }

        }



    });

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
});

function getKind() {
    var sel = $('#kind');
    sel.empty().append('<option disabled selected>Выберите ученика</option>');
    $.getJSON(ajaxKind + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            sel.append('<option value="' + val.id + '">' + val.name + '</option>')
        });
    });
}


function getZahlung() {
    var sel = $('#zahlung');
    sel.empty().append('<option disabled selected>Выберите оплату</option>');
    $.getJSON(ajaxZahlung + "/filter/aktiv", function (data) {
        $.each(data, function (key, val) {
            sel.append('<option value="' + val.id + '">' + val.name + '</option>')
        });
    });
}

function saveUnterricht() {

    $.post(ajaxUnterricht + '/save', $('#detailsForm').serialize())
        .done(function () {
        $('#createUnterricht').modal('hide');
        calendar.fullCalendar('refetchEvents');
    });

    // $.ajax({
    //     url: ajaxUnterricht + '/save',
    //     type: 'POST',
    //     contentType: 'application/json; charset=utf-8',
    //     dataType: 'json',
    //     data: $('#detailsForm').serialize()
    //
    // }).done(function () {
    //         $('#createUnterricht').modal('hide');
    //         calendar.fullCalendar('refetchEvents');
    //     });


}







