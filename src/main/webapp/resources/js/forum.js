var ajaxUrl = "forum";
// var myModal = $('#createOrUpdateUser');
var datatable;

$(function () {

    createThemeTable();


    // $('#saveKind').on('click', function(){
    //     $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
    //         .done(function(){
    //             myModal.modal('toggle');
    //             datatable.ajax.reload();
    //         });
    // });
});

function createThemeTable() {
    datatable = $('#forum').DataTable({
        "language": {
            "url": languageUrl
        },
        "order": [[ 5, "desc" ]],
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },

        "columnDefs": [
            {
                "targets": [0],
                "visible": false,
                "searchable": false
            }
        ],
        "columns": [
            {"data": "id"},
            {"data": "titel",
                "orderable": false},
            {"data": "creator"},
            {"data": "views"},
            {"data": "replies"},
            {"data": "last"
            }
            // {"data": "aktiv",
            //     "render": function (data, type, row) {
            //         if (type === "display") {
            //             var checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
            //             if(row.roles.indexOf('Администратор')!== -1){
            //                 checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style='' disabled='disabled'/>";
            //             }
            //             return checkbox;
            //         }
            //         return data;
            //     },
            //     "className": "dt-body-center active-toggler"
            // },
            // {"data": "registriert"},
            // {
            //     "orderable": false,
            //     "defaultContent": "",
            //     "render": renderEditBtn
            // },
            // {
            //     "orderable": false,
            //     "defaultContent": "",
            //     "render": renderDeleteBtn
            // }
        ],
        responsive: true
        // dom: 'Bfrtip'
        // buttons: [
        //     {
        //         text: 'Добавить пользователя',
        //         action: function ( e, dt, node, config ) {
        //             getSelect(ajaxUrl + "/roles", $('#roles'), "Выбери роль");
        //             showModal(myModal);
        //         }
        //     }
        // ]
    });
}