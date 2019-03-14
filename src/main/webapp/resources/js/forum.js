var ajaxUrl = "forum";
// var myModal = $('#createOrUpdateUser');
var datatable;


$(function () {

    // createThemeTable();

    // $('#saveKind').on('click', function(){
    //     $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
    //         .done(function(){
    //             myModal.modal('toggle');
    //             datatable.ajax.reload();
    //         });
    // });
});

// function test(id){
//     document.location.href = "/nachricht?id="+id;
// }
//
// function toggleForum(){
//     // alert($('#id'));
//     $('button').click(function(){
//        console.log($(this).val());
//     });
// }
//
// function createThemeTable() {
//     datatable = $('#forum').DataTable({
//         "language": {
//             "url": languageUrl
//         },
//         "order": [[6, "desc"], [5, "desc" ]],
//         "ajax": {
//             "url": ajaxUrl,
//             "dataSrc": ""
//         },
//         "createdRow": function( row, data, dataIndex ) {
//             if (data.pinned === true) {
//                 $(row).children().each(function(){
//                     $(this).css('background-color', '#eeded9');
//                     $(this).css('color', 'red');
//                 });
//             } else {
//                 $(row).children().each(function(){
//                     $(this).css('color', 'blue');
//                 });
//             }
//             $(row).children().first().attr('onclick','test(' + data.id + ')');
//         },
//         "columnDefs": [
//             {
//                 "targets": [0, 6],
//                 "visible": false,
//                 "searchable": false
//             }
//         ],
//         "columns": [
//             {"data": "id"},
//             {"data": "titel"},
//             {"data": "creator"},
//             {"data": "views"},
//             {"data": "replies"},
//             {"data": "last"},
//             {"data": "pinned"}
//
//             // {"data": "aktiv",
//             //     "render": function (data, type, row) {
//             //         if (type === "display") {
//             //             var checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
//             //             if(row.roles.indexOf('Администратор')!== -1){
//             //                 checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style='' disabled='disabled'/>";
//             //             }
//             //             return checkbox;
//             //         }
//             //         return data;
//             //     },
//             //     "className": "dt-body-center active-toggler"
//             // },
//             // {"data": "registriert"},
//             // {
//             //     "orderable": false,
//             //     "defaultContent": "",
//             //     "render": renderEditBtn
//             // },
//             // {
//             //     "orderable": false,
//             //     "defaultContent": "",
//             //     "render": renderDeleteBtn
//             // }
//         ],
//         responsive: true
//         // dom: 'Bfrtip'
//         // buttons: [
//         //     {
//         //         text: 'Добавить пользователя',
//         //         action: function ( e, dt, node, config ) {
//         //             getSelect(ajaxUrl + "/roles", $('#roles'), "Выбери роль");
//         //             showModal(myModal);
//         //         }
//         //     }
//         // ]
//     });
// }