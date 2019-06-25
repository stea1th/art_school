var ajaxUrl = "api/zahlung";
var myModal = $('#createZahlung');
var datatable;

$(function () {
    saveOrUpdateZahlung();
});

function createTable(data) {

    datatable = $('#zahlungen').DataTable({
        colReorder: true,
        "language": {
            "url": data
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
                text: $('#hidden-param').attr('addTitle'),
                action: function (e, dt, node, config) {
                    $('.modal-title').html($('#hidden-param').attr('addTitle'));
                    showModal({id: myModal});
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









