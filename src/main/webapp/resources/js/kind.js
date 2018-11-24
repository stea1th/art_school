var ajaxUrl = "kind";
var datatable;

$(function () {
    datatable = $('#kids').DataTable({
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
            {"data": "adresse"},
            {"data": "aktiv",
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
                action: function ( e, dt, node, config ) {
                    var modalName = $('#createKind');
                    showModal(modalName);
                }
            }
        ]


    });

    $('#saveKind').on('click', function(){
        // console.log($('#slider1').find('div[aria-valuetext]').attr('aria-valuenow'));
        // console.log($('#slider2').find('div[aria-valuetext]').attr('aria-valuenow'));
        $.post(ajaxUrl+"/save", $('#kind-detailsForm').serialize())
            .done(function(){
                var myModal = $('#createKind');
                myModal.modal('toggle');
                datatable.ajax.reload();
            });
    });
});












