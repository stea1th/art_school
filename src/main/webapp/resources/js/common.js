// var ajaxUrl = "unterricht";
// // var form = $('#detailsForm');
//
//
// function save(){
//     $.ajax({
//         type: "POST",
//         url: ajaxUrl+'/save',
//         data: {
//             datum: $('#datum').val(),
//             kind: $('#kind').val(),
//             zahlung: $('#zahlung').val(),
//             timepicker: $('#timepicker').val()
//         }
//     }).done(function () {
//         $('#exampleModal').modal('hide');
//         $('#calendar').fullCalendar('rerenderEvents');
//         alert("It's all saved");
//     });
// }
// function save() {
//     // console.log($("#detailsForm").serialize().toString());
//     console.log($('#datum').val()+"T"+$('#timepicker').val()+" "+$('#kind').val()+" "+$('#zahlung').val());
// }

// function showValues() {
//    var str = $("form").serialize();
//    $('#results').text(str);
// }
// $("form").on("submit", showValues);
