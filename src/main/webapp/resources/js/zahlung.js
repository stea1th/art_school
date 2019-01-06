var ajaxUrl = "zahlung";
var myModal = $('#createZahlung');
var datatable;

$(function () {
    createZahlungTable();
    saveOrUpdateZahlung();
});

function createZahlungTable() {
    datatable = $('#zahlungen').DataTable({
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
            {
                "data": "preis",
                "render": function (data, type, row) {
                    if (type === 'display') {
                        return "<span><i class='fas fa-euro-sign'></i></span> " + data;
                    }
                    return data;
                }
            },
            {"data": "dauer"},
            {
                "data": "aktiv",

                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='toggleThis(" + row.id + ")' />";
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
        responsive: true,
        // sPaginationType: "scrolling",
        // pagingType: "numbers",
        dom: 'Bfrtip',
        buttons: [
            {
                name: 'primary',
                text: 'Добавить способ оплаты',
                action: function (e, dt, node, config) {
                    $('.modal-title').text('Добавить способ оплаты');
                    showModal(myModal);
                }
            }
        ]
    });
}

function saveOrUpdateZahlung() {
    $('#saveZahlung').on('click', function () {
        saveOrUpdate($('#zahlung-detailsForm'), "Объект");
    });
}









