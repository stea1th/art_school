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
                "searchable": false,
            }
        ],
        "columns": [
            {"data": "id"},
            {"data": "name"},
            {"data": "preis",
            "render": function(data,type,row){
                if(type==='display'){
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
        dom: 'Bfrtip',
        buttons: [
            {
                name: 'primary',
                text: 'Добавить способ оплаты',
                action: function (e, dt, node, config) {
                    var modalName = $('#createZahlung');
                    showModal(modalName);
                }
            }
        ]
    });

    $('#saveZahlung').on('click', function(){
        // console.log(document.getElementById('slider2'));
        // console.log($('#slider1').find('div[aria-valuetext]').attr('aria-valuenow'));
        // console.log($('#slider2').find('div[aria-valuetext]').attr('aria-valuenow'));
        // console.log($('#name').val());

        $.post(ajaxUrl+"/save", $('#zahlung-detailsForm').serialize())
            .done(function(){
                var myModal = $('#createZahlung');
                myModal.modal('toggle');
                location.reload();
            });
    });


});







