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

var ajaxUrl = "unterricht";


$(function () {

    $('#calendar').fullCalendar({
        header: {center: 'month,agendaWeek,list'}, // buttons for switching between views
        views: {
            month: {
                titleFormat: 'YYYY MMMM '
            }
        },
        dayClick: function (date, jsEvent, view) {
            // $(this).css('background-color', 'lightblue');
            // alert(date.format());

            $('#datum').val(date.format());
            getKind();
            $(this).on("click", function () {
                $('#createUnterricht').modal('toggle');
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
        timezone: 'local'
    });


    $('#timepicker').timepicker({
        showOn: 'focus',
        hourText: 'Часы',             // Define the locale text for "Hours"
        minuteText: 'Минуты'
    });

    // $('#kind').on('change', function () {
    //     $.getJSON('kind', function (data) {
    //         $.each(data, function (key, val) {
    //             // alert(key.toString()+" "+val.toString());
    //             // console.log(JSON.stringify(key)+" "+JSON.stringify(val));
    //             console.log(val.name);
    //         });
    //     });
    // });
});

// var myEvents = function() {
//     var obj = '';
//     $.ajax({
//         type: 'POST',
//         url: '/unterricht',
//         async:false,
//         contentType: "application/json",
//         success: function (result) {
//             obj = JSON.stringify(result);
//             // obj = result;
//             // $('#events').text(obj);
//              console.log(obj);
//         }
//     });
//     return obj;
// };

function getKind() {
    var sel = document.getElementById('kind');
    var opt = null;
    $.getJSON('kind', function (data) {
        $.each(data, function (key, val) {
            // alert(key.toString()+" "+val.toString());
            // console.log(JSON.stringify(key)+" "+JSON.stringify(val));
            // console.log(val.name);
            opt = document.createElement('option');
            opt.value = val.id;
            opt.innerHTML = val.name;
            sel.appendChild(opt);
        });
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + '/save',
        data: {
            datum: $('#datum').val(),
            kind: $('#kind').val(),
            zahlung: $('#zahlung').val(),
            timepicker: $('#timepicker').val(),
            notiz: $('#notiz').val(),
            bezahlt: $('#bezahlt:checked').val(),
            id: $('#id').val()
        }
    }).done(function () {
        $('#createUnterricht').modal('hide');
        $('#calendar').fullCalendar('refetchEvents');
        // alert("It's all saved");
    });
}





