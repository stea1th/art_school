var ajaxUrl = "kind";
var datatable;

$(function () {
    datatable = $('#kids').DataTable({
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
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='#' style=''/>";
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
        ]

    });
});

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='#'><i class='far fa-edit'></i></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'><i class='far fa-calendar-times'></i></a>";
    }
}

function deleteRow(id){
    $.ajax({
        url: ajaxUrl +"/"+ id,
        type: "DELETE"
    }).done(function(){
        datatable.ajax.reload();
    });
}

function updateTable() {
    $.get(ajaxUrl, function(newDataArray){
        datatable.clear();
        datatable.rows.add(newDataArray);
        datatable.draw();
    });
}









