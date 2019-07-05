$(function () {

    createAnimationOnWelcome();

    pageNumberInput();

    selectSizeOnChange();

    pageInputField();

    saveOrUpdateUser();

    getLocalesForTables();

    // initSelectPicker();

    initChosen();

    getThisUserProfile();

});

function getLocalesForTables() {
    $.get("/api/locale/tables").done(function (data) {
        if (typeof(createTable) !== 'undefined') {
            createTable(data);
        }
    });
}

function changeLanguage(lang) {
    let locale = "locale=";
    let url;
    const forumNames = ['/forum', '/nachricht'];
    if (forumNames.includes(location.pathname)) {
        changeForumLanguage(lang);
    } else {
        let link = location.href.replace('#', '');
        if (link.includes("?" + locale)) {
            url = link.split("?" + locale)[0];
        } else if (link.includes("&" + locale)) {
            url = link.split("&" + locale)[0];
        } else {
            url = link;
        }
        location.href = url + (url.includes('?') ? "&" : "?") + locale + lang;
    }
}

function saveOrUpdateUser() {
    $('#saveUser').on('click', function () {
        saveOrUpdate($('#user-detailsForm'));
    });
}

function pageInputField() {
    let pageInputDiv = $('.page-input-div');
    let n;
    pageInputDiv.on('click', function () {
        let input = $(this).find('input');
        n = input.val();
        input.val('');
        $(this).find('input').removeClass('disabled').focus();
    });

    pageInputDiv.on('focusout', function () {
        let input = $(this).find('input');
        if (input.val() !== n) {
            input.val(n);
        }
    });
}

function selectSizeOnChange() {
    $('.page-size').on('change', function () {
        $.get($(this).attr('link'), {
            id: $(this).attr('themaId'),
            size: $(this).val(),
            select: true
        }).done(function (data) {
            $('.wrapper').empty().append(data);
            pageNumberInput();
            selectSizeOnChange();
            if (isFunctionDefined('saveMessage')) {
                saveMessage();
            }
        });
    });
}

function isFunctionDefined(functionName) {
    if (eval("typeof(" + functionName + ") == typeof(Function)")) {
        return true;
    }
}

function pageNumberInput() {
    let input = $('.page-input');
    input.on('keypress', function (e) {
        if (e.which === 13) {
            let number = input.val();
            if (number >= 1 && number < parseInt(input.attr('last')) + 2) {
                location.href = input.attr('link') + "?id=" + input.attr('themaId') + "&page=" + (number - 1)
                    + "&sort=" + input.attr('sort')
                    + "&size=" + input.attr('size');
            } else {
                input.val(input.attr('this'));
            }
        }
    });
}

function saveOrUpdate(form) {
    const successIcon = "<span><i class='far fa-check-circle '></i></span> &nbsp;";
    const failIcon = "<span><i class='far fa-times-circle'></i></span> &nbsp;";
    let map = getMapFromFormWithRequiredElements(form);

    let email = form.find('#email');
    let isValid = true;
    if(email.length > 0){
        isValid = isInputValid({
                email: email.val(),
                emailInput: '#email-div'
            });
    }

    if (!isInputEmpty(map) && isValid) {
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
                getThisUserProfile();
                datatable.ajax.reload();
            })
            .fail(function (jqXHR, textStatus) {
                if (jqXHR.status === 422) {
                    failNoty(failIcon, 'Ошибка ' + jqXHR.status + ':\n Цена и Время не должны повторяться');
                }
            });
    }
}

function getMapFromFormWithRequiredElements(form){
    let map = new Map();
    Array.from(form[0].elements).forEach(function (el) {
        if ($(el).attr('required')) {
            let parent = $(el).parent();
            if(parent[0].id === ''){
                parent = parent.parent();
            }
            map.set('#' + parent[0].id, $(el).val());
        }
    });
    return map;
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
    });
}

function updateRow(id) {
    $.get(ajaxUrl + "/" + id)
        .done(function (data) {
            $.each(data, function (k, v) {
                if ($('#slider1').length) {
                    $('.modal-title').text($('#hidden-param').attr('updateTitle'));
                    if (k === 'preis') {
                        setPreis(v);
                    }
                    if (k === 'dauer') {
                        setZeit(v);
                    }
                } else {
                    $('.modal-title').html($('#hidden-param').attr('updateTitle'));

                }
                $('form').find('input[name=' + k + ']').val(v);
                showModal({id: myModal});
                $('#aktiv-checkbox').hide();
            });
            getSelect("/api/admin/roles", $('#roles'), $('#i18n-commons').attr('chooseRole'), data.roles);

        });
}

function toggleThis(id) {
    $.post(ajaxUrl + "/toggle/" + id, {"id": id})
        .done(function (data) {
            toggleOnOff(data);
        });
}

function toggleOnOff(data) {
    if (data) {
        succesNoty("<i class=\"far fa-eye \"></i>", " Включили");
    } else {
        failNoty("<i class=\"far fa-eye-slash \"></i>", " Выключили");
    }
}

function getSelect(url, sel, name, selected) {
    sel.empty().append('<option disabled selected>' + name + '</option>');
    $.getJSON(url, function (data) {
        $.each(data, function (key, val) {
            if (val.id === undefined) {
                if (selected === val) {
                    sel.append('<option selected value="' + key + '">' + val + '</option>');
                } else {
                    sel.append('<option value="' + key + '">' + val + '</option>');
                }
            } else {
                if (selected === val.name) {
                    sel.append('<option selected value="' + val.id + '">' + val.name + '</option>');
                } else {
                    sel.append('<option value="' + val.id + '">' + val.name + '</option>');
                }

            }
        });
        updateChosen();
    });

    return sel;
}

function showModal(config) {
    $('.error-field').remove();
    $('.warning').remove();

    if (config.id) {
        config.id.modal('show');
        $('#aktiv-checkbox').show();
        config.id.on('hidden.bs.modal', function () {
            $(this).find('form')[0].reset();
            $("#id").val("");
        });
    }
    if (config.init) {
        config.init();
    }
}

function succesNoty(icon, text) {
    new Noty({
        type: 'success',
        text: icon + '&nbsp;' + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight',
        timeout: 1300,
        animation: {
            open: 'animated bounceInLeft',
            close: 'animated bounceOutRight'
        }
    }).show();
}

function failNoty(icon, text) {
    new Noty({
        type: 'error',
        text: icon + '&nbsp;' + text,
        theme: 'bootstrap-v4',
        layout: 'bottomRight',
        timeout: 1300,
        animation: {
            open: 'animated bounceInLeft',
            close: 'animated bounceOutRight'
        }

    }).show();
}

function warnNoty(id) {
    let n = new Noty({
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

function setCookie(cname, cvalue, exdays) {
    let d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function initChosen() {
    $('.chosen-select').chosen({width: "100%"});
}

function updateChosen() {
    $('.chosen-select').trigger('chosen:updated');
}

function destroyChosen() {
    $('.chosen-select').chosen('destroy');
}

function isInputEmpty(map) {

    $('.warning').remove();
    let isTrue = false;
    map.forEach(function (k, v) {
        if (k === '' || k === null || k.charCodeAt(0) === 10) {
            appendWarning({
                id: v,
                class: 'warning',
                attr: 'warningEmptyField'
            });
            isTrue = true;
        }
    });
    return isTrue;
}

function isInputValid(config) {
    $('.error-field').remove();
    let isTrue = true;
    if (config.pass !== config.repeat) {
        appendWarning({
            id: config.repeatInput,
            class: "error-field",
            attr: 'invalidPassword'
        });
        isTrue = false;
    }

    if (!config.email.includes("@")) {
        appendWarning({
            id: config.emailInput,
            class: "error-field",
            attr: 'invalidEmail'
        });
        isTrue = false;
    }
    return isTrue;
}

function appendWarning(config) {
    $(config.id).append('<div style="color:red" class=' + config.class + '>' + $('#i18n-commons').attr(config.attr) + '</div>');
}

function getThisUserProfile(){
    $.get("/api/profile")
        .done(function(data){
           getUserInfoForSideBar(data);
           if(location.pathname === '/profile'){
               getProfile(data);
           }
        });
}

function getUserInfoForSideBar(data){
    $('#side-name').text(data.name);
    $('#side-status').text(data.roles);
    $('#side-registration').text(formatDate(data.registriert));
}

function formatDate(date){
    if(date !== undefined){
        let el = date.split(' ')[0].split('-');
        return el[2] + '.' + el[1] + '.' +el[0];
    }
}







