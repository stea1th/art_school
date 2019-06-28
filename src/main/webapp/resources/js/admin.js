var ajaxUrl = "api/admin";
var myModal = $('#createOrUpdateUser');
var datatable;

$(function () {

});

function createTable(data) {
    datatable = $('#admins').DataTable({
        colReorder: true,
        "language": {
            "url": data
        },

        "ajax": {
            "url": "api/admin",
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
            {"data": "roles",},
            {
                "data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " " + (row.isAdmin ? "disabled" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
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
                className: 'btn-primary',
                text: '<i class="fas fa-plus"></i>&nbsp;' + $('#hidden-param').attr('addTitle'),
                init: function(api, node, config){
                    $(node).removeClass('btn-secondary');
                },
                action: function (e, dt, node, config) {
                    $('.modal-title').html($('#hidden-param').attr('addTitle'));
                    getSelect("/api/admin/roles", $('#roles'), $('#i18n-commons').attr('chooseRole'));
                    showModal({id: myModal});
                }
            }
        ]
    });
}

