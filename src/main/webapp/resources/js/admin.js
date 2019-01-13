var ajaxUrl = "admin";
// var myModal = $('#createUser');
var datatable;

$(function () {

    createAdminTable();
    hideToggleByAdmin();

    // $('#saveKind').on('click', function(){
    //     $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
    //         .done(function(){
    //             myModal.modal('toggle');
    //             datatable.ajax.reload();
    //         });
    // });
});

function hideToggleByAdmin() {
    // console.log($('tbody'));
}

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
            {"data": "roles"
                // "render": function(data, type, row){
                //     console.log(data + " "+"1");
                //     console.log(type + " "+"2");
                //     console.log(row + " "+"3");
                //     return data;
                // }
            },
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        var checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
                        if(row.roles.indexOf('Администратор')!== -1){
                            checkbox = "<input type='checkbox' " + (data? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style='' disabled='disabled'/>";
                        }
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
                    // showModal(myModal);
                }
            }
        ]
    });
}