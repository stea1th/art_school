const fileTypes = [
    'image/jpeg',
    'image/pjpeg',
    'image/png'
];
let file;
const imageInput = $('#image-input');
let err;


$(function () {

    inputOnClick();

    saveProfile();
});

function getProfile(data){
    if(data !== null){
        $('#profile-image-form input').each(function(){
            $(this).val(data[$(this).attr('name')]);
        });
        if(data.encodedImage !== null){
            var image = document.createElement('img');
            image.style.cssText = 'width:300px;height:300px;text-align: center;';
            image.src = "data:image/jpeg;base64," + data.encodedImage;
            $('#preview').empty().append(image);
        }
    }
}

function saveProfile(){
    $('#saveProfile').on('click', function () {
        let formData = new FormData();
        const pass = $('#new-passwort');
        const email = $('#email');
        const adresse = $('#adresse');
        const repeat = $('#repeat-passwort');

        let map = new Map();
        map.set('#adresse-div', adresse.val());

        let isValid = isInputValid({
            pass: pass.val(),
            repeat: repeat.val(),
            repeatInput: '#repeat',
            email: email.val(),
            emailInput: '#email-div'
        });

        if(isValid && !isInputEmpty(map)){
            formData.append('name', $('#name').val());
            formData.append('adresse', adresse.val());
            formData.append('adminPasswort', pass.val());
            formData.append('email', email.val());
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
                pass.val('');
                repeat.val('');
                succesNoty('<i class="far fa-thumbs-up"></i>', $('#i18n').attr('saveProfile'));
            });
        } else {
            failNoty('<i class="far fa-times-circle"></i>', 'Something wrong!!');
        }
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
    $('#image-input').val('');
    $.get("/api/profile/my-image").done(function(data){
        if(data === ''){
            err = $('#i18n').attr('noPhoto');
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
    err = $('#i18n').attr('noPhoto');
    $('#preview').empty().append('<h3 style="display: inline-block;padding-top: 130px;">' + err + '</h3>');
    $('#image-input').val('');
    imageInput.attr('del', true);
}


