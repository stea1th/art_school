var ajaxUrl;


function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='#'><i class='far fa-edit orange-icon'></i></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'><i class='far fa-calendar-times red-icon'></i></a>";
    }
}

function deleteRow(id){
    $.ajax({
        url: ajaxUrl +"/"+ id,
        type: 'DELETE'
    }).done(function(){
        datatable.ajax.reload();
    })
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