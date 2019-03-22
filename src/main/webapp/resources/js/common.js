
var ajaxUrl;

$(function () {

    manageNavBar();

    createAnimationOnWelcome();

    pageNumberInput();

    selectSizeOnChange();

    pageInputField();

    saveOrUpdateUser();

    getLocalesForTables();

});

function getLocalesForTables(){
    $.get("/api/locale/tables").done(function (data) {
        if(typeof(createTable) !== 'undefined'){
            createTable(data);
        }
    });
}

function changeLanguage(lang){
    var locale = "locale=";
    var url;
    if(location.pathname.includes('/forum') || location.pathname.includes('/nachricht')){
        changeForumLanguage(lang);
    } else {
        if(location.href.includes("?" + locale)){
            url = location.href.split("?" + locale)[0];
        } else if(location.href.includes("&" + locale)){
            url = location.href.split("&" + locale)[0];
        } else {
            url = location.href;
        }
        location.href = url + (url.includes('?')? "&" : "?") + locale + lang;
    }

}

function saveOrUpdateUser() {
    $('#saveUser').on('click', function () {
        saveOrUpdate($('#user-detailsForm'));
    });
}

function pageInputField(){
    var pageInputDiv = $('.page-input-div');
    var n;
    pageInputDiv.on('click', function(){
        var input = $(this).find('input');
        // $(this).removeClass('disabled');
        n = input.val();
        input.val('');
        $(this).find('input').removeClass('disabled').focus();
    });

    pageInputDiv.on('focusout', function(){
        var input = $(this).find('input');
        if(input.val() !== n){
            input.val(n);
        }
        // $(this).addClass('disabled');
    })
}

function selectSizeOnChange(){
    $('.page-size').on('change', function(){
        $.get($(this).attr('link'), {
            id: $(this).attr('themaId'),
            size: $(this).val(),
            select: true
        }).done(function(data){
            $('.wrapper').empty().append(data);
            pageNumberInput();
            selectSizeOnChange();
            if(isFunctionDefined('saveMessage')){
                saveMessage();
            }
        });
    });
}

function isFunctionDefined(functionName) {
    if(eval("typeof(" + functionName + ") == typeof(Function)")) {
        return true;
    }
}

function pageNumberInput(){
    var input = $('.page-input');
    input.on('keypress', function(e){
        if(e.which === 13){
            var number = input.val();
            if(number>=1 && number < parseInt(input.attr('last')) + 2){
                location.href = input.attr('link') + "?id="+ input.attr('themaId') + "&page=" + (number-1)
                    + "&sort=" + input.attr('sort')
                    + "&size=" + input.attr('size');
            } else {
                input.val(input.attr('this'));
            }
        }
    });
}

function saveOrUpdate(form) {
    var successIcon = "<span><i class='far fa-check-circle '></i></span> &nbsp;";
    var failIcon = "<span><i class='far fa-times-circle'></i></span> &nbsp;";
    $.post(ajaxUrl + "/save", form.serialize())
        .done(function (data) {
            myModal.modal('toggle');
            $.each(data, function (k, v) {
                if (k === 'Save') {
                    succesNoty(successIcon, 'Пользователь "' + v + '"' + " удачно сохранен");
                } else {
                    succesNoty(successIcon, 'Пользователь "' + v + '"' + " удачно обновлен");
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
            console.log(data);
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
                    $('.modal-title').text('Обновить ползователя');

                }
                $('form').find('input[name=' + k + ']').val(v);
                showModal(myModal);
                $('#aktiv-checkbox').hide();
            });
            getSelect("/api/admin/roles", $('#roles'), "Выбери роль", data.roles);

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

function getSelect(url, sel, name, selected) {
    sel.empty().append('<option disabled selected>' + name + '</option>');
    $.getJSON(url, function (data) {
        $.each(data, function (key, val) {
            if(val.id === undefined){
                if(selected === val){
                    sel.append('<option selected value="' + key + '">' + val + '</option>');
                } else {
                    sel.append('<option value="' + key + '">' + val + '</option>');
                }
            } else {
                if(selected === val.name){
                    sel.append('<option selected value="' + val.id + '">' + val.name + '</option>');
                } else {
                    sel.append('<option value="' + val.id + '">' + val.name + '</option>');
                }

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