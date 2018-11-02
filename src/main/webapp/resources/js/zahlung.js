var ajaxUrl = "zahlung";
var datatable;

$(function () {
    datatable = $('#zahlungen').DataTable({

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
