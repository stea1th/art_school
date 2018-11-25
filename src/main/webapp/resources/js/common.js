var ajaxUrl;


function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'><i class='far fa-edit orange-icon'></i></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'><i class='far fa-calendar-times red-icon'></i></a>";
    }
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + "/" + id,
        type: 'DELETE'
    }).done(function () {
        datatable.ajax.reload();
    })
}

function updateRow(id) {
    $.get(ajaxUrl + "/" + id)
        .done(function (data) {
            $.each(data, function (k, v) {
                if ($('#slider1').length) {
                    if (k === 'preis') {
                        setPreis(v);
                    }
                    if(k === 'dauer'){
                        setZeit(v);
                    }
                }
                $('form').find('input[name=' + k + ']').val(v);
                showModal(myModal);
                $('#aktiv-checkbox').hide();
            })
        })
}

function toggleThis(id) {
    $.post(ajaxUrl + "/toggle/" + id, {"id": id});
}

function showModal(modalName) {

    modalName.modal('show');
    $('#aktiv-checkbox').show();
    modalName.on('hidden.bs.modal', function () {
        $(this).find('form')[0].reset();
        $("#id").val("");
    });

}

function succesNoty(text){
    new Noty({
        type: 'success',
        text: "<span><i class='far fa-check-circle '></i></span> &nbsp;" + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight',
        // timeout: 1500
        // animation: {
        //     open : 'animated fadeInRight',
        //     close: 'animated fadeOutRight'
        // }
    }).show();
}

function failNoty(text){
    new Noty({
        type: 'error',
        text: "<span><i class='far fa-times-circle'></i></span> &nbsp;" + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight'
        // timeout: 1500
        // animation: {
        //     open : 'animated fadeInRight',
        //     close: 'animated fadeOutRight'
        // }
    }).show();
}