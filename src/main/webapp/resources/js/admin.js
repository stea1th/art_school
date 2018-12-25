var ajaxUrl = "admin";
// var myModal = $('#createUser');
var datatable;

$(function () {
    datatable = $('#admins').DataTable({
        "language": {
            "url": "http://cdn.datatables.net/plug-ins/1.10.19/i18n/Russian.json"
        },

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
            {"data": "name"},
            {"data": "email"},
            {"data": "passwort"},
            {"data": "roles"},
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
                    }
                    return data;
                },
                "className": "dt-body-center"
            },
            {"data": "registriert"},
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        responsive: true,
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'Добавить пользователя',
                action: function ( e, dt, node, config ) {
                    // showModal(myModal);
                }
            }
        ]
    });

    // $('#saveKind').on('click', function(){
    //     $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
    //         .done(function(){
    //             myModal.modal('toggle');
    //             datatable.ajax.reload();
    //         });
    // });
});