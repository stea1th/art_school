// var myRequest = new XMLHttpRequest();
// var myEvent;
// myRequest.open('POST', '/unterricht');
// myRequest.onload = function(){
//      myEvent = myRequest.responseText;
//      console.log(myEvent);
// };
// myRequest.send();

// $(function () {
//     $.getJSON('/getAll', function (data) {
//         console.log(data);
//     });
// });


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
            $(this).on( "click", function() {
                $('#exampleModal').modal('toggle');
            });
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
        // events: [{"title":"Vlasov","start":"2018-10-22T20:32:10.352006","end":"2018-10-22T21:17:10.352006"},{"title":"Vlasov","start":"2018-10-11T00:00","end":"2018-10-11T00:45"},{"title":"Osipov","start":"2018-10-10T00:00","end":"2018-10-10T00:45"},{"title":"Osipov","start":"2018-10-07T09:00","end":"2018-10-07T10:30"},{"title":"Tupuliavichius","start":"2018-10-05T00:00","end":"2018-10-05T00:45"},{"title":"Vlasov","start":"2018-10-04T13:15","end":"2018-10-04T14:00"}]
        // eventSources:[
        //     {
        //         events: myEvent
        //     }
        // ]
        events: 'http://localhost:8080/unterricht'

    });


    $('#timepicker').timepicker({
        showOn: 'focus',
        hourText: 'Часы',             // Define the locale text for "Hours"
        minuteText: 'Минуты'
    });


});

var myEvents = function() {
    var obj = '';
    $.ajax({
        type: 'POST',
        url: '/unterricht',
        async:false,
        contentType: "application/json",
        success: function (result) {
            obj = JSON.stringify(result);
            // obj = result;
            // $('#events').text(obj);
             console.log(obj);
        }
    });
    return obj;
};
