var ajaxUrl = "api/admin";
var myModal = $('#createKind');
var datatable;

$(function () {

});

function createTable(data) {
    datatable = $('#kids').DataTable({
        colReorder: true,
        "language": {
            "url": data
        },

        "ajax": {
            "url": "api/kind",
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
            {"data": "adresse"},
            {
                "data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='toggleThis(" + row.id + ")'/>";

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
                className: 'btn-primary',
                text: '<i class="fas fa-plus"></i>&nbsp;' + $('#hidden-param').attr('addTitle'),
                init: function(api, node, config){
                    $(node).removeClass('btn-secondary');
                },
                action: function (e, dt, node, config) {
                    $('.modal-title').html($('#hidden-param').attr('addTitle'));
                    getSelect("/api/admin/roles", $('#roles'), "Выбери роль");
                    showModal({id:myModal}
                    );
                }
            }
        ]
    });
}












