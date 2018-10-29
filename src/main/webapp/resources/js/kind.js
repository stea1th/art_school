var ajaxUrl = "kind";

$( function() {
    $('#kids').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "columns": [
            {"data": "id"},
            {"data": "name"},
            {"data": "adresse"},
            {"data": "aktiv"},
            {"data": "registriert"}
        ]
    });
});





