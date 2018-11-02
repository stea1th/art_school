var ajaxUrl = "zahlung";
var datatable;

$(function () {
    datatable = $('#zahlungen').DataTable({
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
            {"data": "preis"},
            {"data": "dauer"},
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='toggleThis(" + row.id+ ")' />";
                    }
                    return data;
                },
                "className": "dt-body-center"
            },
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
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'Добавить способ оплаты',
                action: function ( e, dt, node, config ) {
                    alert( 'Button activated' );
                }
            }
        ]
    });
});
