var ajaxUrl;
var languageUrl = "http://cdn.datatables.net/plug-ins/1.10.19/i18n/Russian.json";

$(function () {
    manageNavBar();

    createAnimationOnWelcome();
});

function saveOrUpdate(form, name) {
    var successIcon = "<span><i class='far fa-check-circle '></i></span> &nbsp;";
    var failIcon = "<span><i class='far fa-times-circle'></i></span> &nbsp;";
    $.post(ajaxUrl + "/save", form.serialize())
        .done(function (data) {
            myModal.modal('toggle');
            $.each(data, function (k, v) {
                if (k === 'Save') {
                    succesNoty(successIcon, name + ' "' + v + '"' + " удачно сохранен");
                } else {
                    succesNoty(successIcon, name + ' "' + v + '"' + " удачно обновлен");
                }
            });
            datatable.ajax.reload();
        })
        .fail(function (jqXHR, textStatus) {
            if (jqXHR.status === 422) {
                failNoty(failIcon, 'Ошибка ' + jqXHR.status + ':\n Цена и Время не должны повторяться');
            }
        });
}

function manageNavBar() {
    $('ul.navbar-nav li.active').removeClass('active');
    $('a[href="' + location.pathname.replace("/", "") + '"]').closest('li').addClass('active');
    if(location.pathname === "/nachricht"){
        $('a[href="'+"/forum".replace("/", "")+'"]').closest('li').addClass('active');
    }
}

function createAnimationOnWelcome() {
    if (window.location.pathname === "/login") {
        $('#polygonizr').polygonizr({
            restNodeMovements: 1,
            duration: 3,
            nodeMovementDistance: 100,
            numberOfNodes: 35,
            nodeDotSize: 2.5,
            // Sets the ease mode of the movement: linear, easeIn, easeOut, easeInOut, accelerateDecelerate.
            nodeEase: "easeInOut",
            canvasWidth: $('nav').width(),
            canvasHeight: $(this).height(),
            canvasPosition: "absolute",
            nodeRelations: 3,
            specifyPolygonMeshNetworkFormation: function (i) {
                return {
                    // Half a circle and randomized
                    x: this.canvasWidth - ((this.canvasWidth / 2) + (this.canvasHeight / 2) * Math.cos(i * (2 * Math.PI / this.numberOfNodes))) * Math.random(),
                    y: this.canvasHeight - (this.canvasHeight * (i / this.numberOfNodes))
                };
            },
            randomizePolygonMeshNetworkFormation: true
        });
    }
}


function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'><i class='far fa-edit orange-icon'></i></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='warnNoty(" + row.id + ");'><i class='far fa-calendar-times red-icon'></i></a>";
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
                    $('.modal-title').text('Обновить способ оплаты');
                    if (k === 'preis') {
                        setPreis(v);
                    }
                    if (k === 'dauer') {
                        setZeit(v);
                    }
                } else {
                    $('.modal-title').text('Обновить ученика');
                }
                $('form').find('input[name=' + k + ']').val(v);
                showModal(myModal);
                $('#aktiv-checkbox').hide();
            })
        })
}

function toggleThis(id) {
    $.post(ajaxUrl + "/toggle/" + id, {"id": id})
        .done(function(data){
            toggleOnOff(data);
        });
}

function toggleOnOff(data) {
    if(data){
        succesNoty("<i class=\"far fa-eye \"></i>", " Включили");
    } else {
        failNoty("<i class=\"far fa-eye-slash \"></i>", " Выключили");
    }
}

function getSelect(url, sel, name) {
    sel.empty().append('<option disabled selected>' + name + '</option>');
    $.getJSON(url, function (data) {
        $.each(data, function (key, val) {
            if(val.id === undefined){
                sel.append('<option value="' + key + '">' + val + '</option>')
            } else {
                sel.append('<option value="' + val.id + '">' + val.name + '</option>')
            }
        });
    });
    return sel;
}

function showModal(modalName) {

    modalName.modal('show');
    $('#aktiv-checkbox').show();
    modalName.on('hidden.bs.modal', function () {
        $(this).find('form')[0].reset();
        $("#id").val("");
    });

}

function succesNoty(icon, text) {
    new Noty({
        type: 'success',
        text: icon + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight',
        timeout: 1500,
        animation: {
            open: 'animated bounceInLeft',
            close: 'animated bounceOutRight'
        }
    }).show();
}

function failNoty(icon, text) {
    new Noty({
        type: 'error',
        text: icon + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight',
        timeout: 1500,
        animation: {
            open: 'animated bounceInLeft',
            close: 'animated bounceOutRight'
        }

    }).show();
}

function warnNoty(id) {
    var n = new Noty({
        type: 'warning',
        text: "<span><i class='fas fa-exclamation-circle fa-2x'></i></span> &nbsp;"
        + "Вы уверены, что готовы удалить данный объект?",
        theme: 'bootstrap-v4',
        layout: 'center',
        // timeout: 1500
        animation: {
            open: 'animated jackInTheBox',
            close: 'animated hinge'
        },
        buttons: [
            Noty.button('Да', 'btn btn-danger btn-sm', function () {
                deleteRow(id);
                n.close();
            }, {id: 'button1', 'data-status': 'ok'}),

            Noty.button('Нет', 'btn btn-success btn-sm', function () {
                n.close();
            })
        ]
    }).show();
}