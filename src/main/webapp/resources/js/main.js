
// $(function () {
    $('#calendar').fullCalendar({
        dayClick: function (date, jsEvent, view) {

            alert('Clicked on: ' + date.format());

            alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);

            alert('Current view: ' + view.name);

            // change the day's background color just for fun
            $(this).css('background-color', 'red');
        }
    });
// });

// var calendar = $('#calendar').fullCalendar('getCalendar');
//
// calendar.on('dayClick', function (date, jsEvent, view) {
//     console.log('clicked on' + date.format());
// });