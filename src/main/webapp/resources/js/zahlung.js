var ajaxZahlung = "zahlung";
var datatable;

$(function () {
    datatable = $('#zahlungen').DataTable({

        "ajax": {
            "url": ajaxZahlung,
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
            {"data": "preis"},
            {"data": "dauer"},
            {"data": "aktiv",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return "<input type='checkbox' " + (data ? "checked" : "") + " onclick='#' style=''/>";
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
        url: ajaxZahlung +"/"+ id,
        type: "DELETE"
    }).done(function(){
        datatable.ajax.reload();
    });
}