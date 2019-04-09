var fileTypes = [
    'image/jpeg',
    'image/pjpeg',
    'image/png'
];
var file;
var imageInput = $('#image-input');


$(function () {

    inputOnClick();

    getProfile();

    saveProfile();
});

function getProfile(){
    $.get("/api/profile")
        .done(function(data){
            $('#profile-image-form input').each(function(){
                $(this).val(data[$(this).attr('name')]);
            });
            if(data.encodedImage !== null){
                var image = document.createElement('img');
                image.style.cssText = 'width:300px;height:300px;text-align: center;';
                image.src = "data:image/jpeg;base64," + data.encodedImage;
                $('#preview').empty().append(image);
            }
        });
}

function saveProfile(){
    $('#saveProfile').on('click', function () {
        $('.error-field').hide();
        var formData = new FormData();
        var pass = $('#new-passwort').val();
        var email = $('#email').val();
        formData.append('name', $('#name').val());
        formData.append('adresse', $('#adresse').val());
        if(pass !== $('#repeat-passwort').val()){
            var err = $('#i18n').attr('invalidPassword');
            console.log(err);
            $('#repeat').append('<div style="color:red" class="error-field">' +err+ '</div>');
            failNoty('<i class="far fa-times-circle"></i>', err);
            return;
        } else {
            formData.append('adminPasswort', pass);
        }

        if(!email.includes("@")){
            var err = $('#i18n').attr('invalidEmail');
            $('#email-div').append('<div style="color:red" class="error-field">' +err+ '</div>');
            failNoty('<i class="far fa-times-circle"></i>', err);
            return;
        } else {
            if(email !== ''){
                formData.append('email', email);
            }
        }
        formData.append('removeImage', imageInput.attr('del') === 'true');

        file = imageInput[0].files[0];

        if(file !== undefined ){
            if(file.size < 5242880 && validFileType(file)){
                formData.append('file', file);
            }
        }
        $.ajax({
            url: "/api/profile/save",
            cache: false,
            contentType: false,
            processData: false,
            data: formData,
            type: 'POST'
        }).done(function(){
            getUserImageForNavBar();
            succesNoty('<i class="far fa-thumbs-up"></i>', $('#i18n').attr('saveProfile'));
        });
    });
}

function updateImage(){
    imageInput.click();
}

function inputOnClick(){
    imageInput.on('change', function(){
        file = imageInput[0].files[0];
        if(file.size < 5242880 && validFileType(file)){
            $('#text-input').val(file.name);
            var image = document.createElement('img');
            image.style.cssText = 'width:300px;height:300px;text-align: center;';
            image.src = window.URL.createObjectURL(file);
            $('#preview').empty().append(image);
        }
    });
}

function clearImageInput(){
    $('#text-input').val('');
    $('#image-input').val('');
    $.get("/api/profile/my-image").done(function(data){
        if(data === ''){
            var err = $('#i18n').attr('noPhoto');
            $('#preview').empty().append('<h3 style="display: inline-block;padding-top: 130px;">' + err + '</h3>');
        } else {
            var image = document.createElement('img');
            image.style.cssText = 'width:300px;height:300px;text-align: center;';
            image.src = "data:image/jpeg;base64," + data;
            $('#preview').empty().append(image);
        }
    });
}

function validFileType(file) {
    for(var i = 0; i < fileTypes.length; i++) {
        if(file.type === fileTypes[i]) {
            return true;
        }
    }
    return false;
}

function removeImage(){
    var err = $('#i18n').attr('noPhoto');
    $('#preview').empty().append('<h3 style="display: inline-block;padding-top: 130px;">' + err + '</h3>');
    imageInput.attr('del', true);
}


