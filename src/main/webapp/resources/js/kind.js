var ajaxUrl = "kind";

$(function () {
    $('#kids').DataTable({
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
            {"data": "adresse"},
            {"data": "aktiv"},
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
        ]

    });
});

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='#'><i class='fa fa-pencil' aria-hidden='true'></i></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='#'><i class='fa fa-pencil' aria-hidden='true'></i></a>";
    }
}





