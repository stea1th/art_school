$( function() {
    $('#calendar').fullCalendar({
        header: { center: 'month,agendaWeek,list' }, // buttons for switching between views
        views: {
            month: {
                titleFormat: 'YYYY MMMM '
            }
        },
        dayClick: function (date, jsEvent, view) {
            // $(this).css('background-color', 'lightblue');
            // alert(date.format());
            $('#datum').val(date.format());
        },
        // themeSystem: 'jquery-ui',
        themeSystem: 'bootstrap4',
        height:650,
        bootstrapFontAwesome: {
            prev: 'fas fa-angle-left',
            next: 'fas fa-angle-right'
        },
        firstDay: 1,
        eventClick: function (event) {
            // if(event.title!=='CLICKED!'){
            //     event.title = "CLICKED!";
            // }else{
            //     event.title = "YAHOO!!!!";
            // }
            // event.css('color', 'red');
            // $('#calendar').fullCalendar('updateEvent', event);

        },
        events: myEvents

    });
    $( ".fc-day" ).on( "click", function() {
        $('#exampleModal').modal('toggle');
    });
    $('#timepicker').timepicker({
        showOn: 'focus',
        hourText: 'Часы',             // Define the locale text for "Hours"
        minuteText: 'Минуты'
    });
});