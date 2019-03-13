var ajaxUrl = "admin";
var myModal = $('#createOrUpdateUser');
var datatable;

$(function () {

    createAdminTable();


    // $('#saveKind').on('click', function(){
    //     $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
    //         .done(function(){
    //             myModal.modal('toggle');
    //             datatable.ajax.reload();
    //         });
    // });
});

function createAdminTable() {
    datatable = $('#admins').DataTable({
        "language": {
            "url": languageUrl
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
            {"data": "adminPasswort"},
            {"data": "roles"},
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        var checkbox = "<input type='checkbox' " + (data? "checked" : "") + " " + (row.roles.indexOf('Администратор')!== -1? "disabled" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
                        return checkbox;
                    }
                    return data;
                },
                "className": "dt-body-center active-toggler"
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
                    getSelect(ajaxUrl + "/roles", $('#roles'), "Выбери роль");
                    showModal(myModal);
                }
            }
        ]
    });
}

