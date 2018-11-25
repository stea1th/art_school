var lockedState = false;
var lockedSlider = false;
var lockedValues = [60, 80];

var slider1 = document.getElementById('slider1');
var slider2 = document.getElementById('slider2');

var lockButton = document.getElementById('lockbutton');
var slider1Value = document.getElementById('slider1-span');
var slider2Value = document.getElementById('slider2-span');

$(function () {




// When the button is clicked, the locked state is inverted.
    lockButton.addEventListener('click', function (e) {
        e.preventDefault();
        lockedState = !lockedState;
        this.textContent = lockedState ? 'Разблокировать' : 'Заблокировать';
    });

    noUiSlider.create(slider1, {
        start: 30,

        // Disable animation on value-setting,
        // so the sliders respond immediately.
        animate: false,
        range: {
            min: 15,
            max: 50
        },
        step: 1
    });

    noUiSlider.create(slider2, {
        start: 120,
        animate: false,
        range: {
            min: 30,
            max: 240
        },
        step: 15
    });

    slider1.noUiSlider.on('update', function (values, handle) {
        // console.log(handle);
        // console.log(values);
        var result = values[handle];
        $('#preis').val(result);
        slider1Value.innerHTML = result;
    });

    slider2.noUiSlider.on('update', function (values, handle) {
        var hour = 60;
        var result = values[handle];
        $('#dauer').val(result);
        if (result >= hour) {
            slider2Value.innerHTML = Math.floor(result / hour) + (result < hour * 2 ? " час " : " часа ") + (result - Math.floor(result / hour) * hour) + " минут";
        } else {
            slider2Value.innerHTML = Math.floor(result) + " минут";
        }
    });

    function setLockedValues() {
        lockedValues = [
            Number(slider1.noUiSlider.get()),
            Number(slider2.noUiSlider.get())
        ];
    }

    slider1.noUiSlider.on('change', setLockedValues);
    slider2.noUiSlider.on('change', setLockedValues);

    slider1.noUiSlider.on('slide', function (values, handle) {
        crossUpdate(values[handle], slider2);
    });

    slider2.noUiSlider.on('slide', function (values, handle) {
        crossUpdate(values[handle], slider1);
    });


    function crossUpdate(value, slider) {

        // If the sliders aren't interlocked, don't
        // cross-update.
        if (!lockedState) return;

        // Select whether to increase or decrease
        // the other slider value.
        var a = slider1 === slider ? 0 : 1;

        // Invert a
        var b = a ? 0 : 1;

        // Offset the slider value.
        value -= lockedValues[b] - lockedValues[a];

        // Set the value
        slider.noUiSlider.set(value);
    }



});

function setPreis(value){
        var result = value;
        $('#preis').val(result);
        slider1Value.innerHTML = result;
}

function setZeit(value){
    var hour = 60;
    var result = value;
    $('#dauer').val(result);
    if (result >= hour) {
        slider2Value.innerHTML = Math.floor(result / hour) + (result < hour * 2 ? " час " : " часа ") + (result - Math.floor(result / hour) * hour) + " минут";
    } else {
        slider2Value.innerHTML = Math.floor(result) + " минут";
    }
}
