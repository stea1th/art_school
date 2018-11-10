
var ajaxUrl;


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
    $.delete(ajaxUrl +"/"+ id).done(function() {
        datatable.ajax.reload();
    });
}

function toggleThis(id){
    $.post(ajaxUrl+"/toggle/"+id, {"id" : id});
}

function showModal(modalName){
    modalName.modal('show');
    modalName.on('hidden.bs.modal', function () {
        $(this).find('form')[0].reset();
    })
}