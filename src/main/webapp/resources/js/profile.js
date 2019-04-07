var fileTypes = [
    'image/jpeg',
    'image/pjpeg',
    'image/png'
];
var file;
var imageInput = $('#image-input');


$(function () {

    inputOnClick();
});

function updateImage(){
    imageInput.click();
}

function inputOnClick(){
    imageInput.on('change', function(){
        file = imageInput[0].files[0];
        console.log(file);
        if(file.size < 5242880 && validFileType(file)){
            $('#text-input').val(file.name);
            var image = document.createElement('img');
            image.style.cssText = 'width:250px;height:250px;text-align: center;';
            image.src = window.URL.createObjectURL(file);
            $('#preview').empty().append(image);
        }

    });
}

function clearImageInput(){
    $('#text-input').val('');
    $('#image-input').val('');
    $('#preview').empty().append('<h3 style="display: inline-block;padding-top: 130px;">NO PHOTO</h3>');

}

function validFileType(file) {
    for(var i = 0; i < fileTypes.length; i++) {
        if(file.type === fileTypes[i]) {
            return true;
        }
    }
    return false;
}

