
$(function () {

});

function addImage(){
    var image = $('#image-input');
    image.click();
    image.on('change', function(){
        $('#text-input').val(image[0].files[0].name);
    });
}

function clearImageInput(){
    $('#text-input').val('');
    $('#image-input').val('');
}