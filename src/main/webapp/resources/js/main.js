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
            $('#test').text(date.format());
        },
        themeSystem: 'bootstrap4',
        height:650,
        bootstrapFontAwesome: {
            prev: 'fas fa-angle-left',
            next: 'fas fa-angle-right'
        },
        firstDay: 1,
        eventClick: function (event) {
            if(event.title!=='CLICKED!'){
                event.title = "CLICKED!";
            }else{
                event.title = "YAHOO!!!!";
            }
            $('#calendar').fullCalendar('updateEvent', event);

        },
        events: myEvents

    });
    $( "#dialog" ).dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 500
        },
        hide: {
            effect: "explode",
            duration: 500
        }
    });
    $( ".fc-day" ).on( "click", function() {
        $( "#dialog" ).dialog( "open" );

    });

});