var ajaxUrl = "kind";

$( function() {
    $('#kids').DataTable({
        ajax: {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        columns: [
            {data: "id"},
            {data: "name"},
            {data: "adresse"},
            {data: "aktiv"},
            {data: "registriert"}
        ]
    });
});





