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
                    showModal(myModal);
                }
            }
        ]
    });
}

function saveOrUpdateZahlung() {
    $('#saveZahlung').on('click', function () {
        $.post(ajaxUrl + "/save", $('#zahlung-detailsForm').serialize())
            .done(function (data) {
                myModal.modal('toggle');
                $.each(data, function (k, v) {
                    if (k === 'Save') {
                        succesNoty('Объект "' + v + '"' + " удачно сохранен");
                    } else {
                        succesNoty('Объект "' + v + '"' + " удачно обновлен");
                    }
                });
                datatable.ajax.reload();
            })
            .fail(function (jqXHR, textStatus) {
                // var errorInfo = JSON.parse(jqXHR.responseText);
                // console.log(jqXHR);
                // console.log(textStatus);
                if (jqXHR.status === 422) {
                    failNoty('Ошибка ' + jqXHR.status + ':\n Цена и Время не должны повторяться');
                }
            });
    });
}









