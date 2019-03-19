var ajaxUrl = "api/admin";
var myModal = $('#createKind');
var datatable;

$(function () {
    createKindtable();
});

function createKindtable() {
    datatable = $('#kids').DataTable({
        "language": {
            "url": languageUrl
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
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='toggleThis(" + row.id + ")' style=''/>";
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
                text: 'Добавить ученика',
                action: function (e, dt, node, config) {
                    $('.modal-title').text('Добавить ученика');
                    getSelect("/admin/roles", $('#roles'), "Выбери роль");
                    showModal(myModal);
                }
            }
        ]
    });
}












