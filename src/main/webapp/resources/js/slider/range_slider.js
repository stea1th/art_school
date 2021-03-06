var lockedState = false;
var lockedSlider = false;
var lockedValues = [60, 80];
var i18n = $('#i18n-slider');

var slider1 = document.getElementById('slider1');
var slider2 = document.getElementById('slider2');

var lockButton = document.getElementById('lockbutton');
var slider1Value = document.getElementById('slider1-span');
var slider2Value = document.getElementById('slider2-span');
var x;

$(function () {

// When the button is clicked, the locked state is inverted.
    lockButton.addEventListener('click', function (e) {
        e.preventDefault();
        lockedState = !lockedState;
        this.textContent = lockedState ? i18n.attr('unlock') : i18n.attr('lock');
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
        var result = values[handle];
        $('#preis').val(result);
        slider1Value.innerHTML = result;
    });

    slider2.noUiSlider.on('update', function (values, handle) {
        var hour = 60;
        var result = values[handle];
        $('#dauer').val(result);
        if (result >= hour) {
            slider2Value.innerHTML = Math.floor(result / hour) +
                (result < hour * 2 ? " " + i18n.attr('hour') +
                    " " : " " + i18n.attr('hours') + " ") +
                (result - Math.floor(result / hour) * hour) + " " + i18n.attr('minutes');
        } else {
            slider2Value.innerHTML = Math.floor(result) + " " + i18n.attr('minutes');
        }
    });

    function setLockedValues() {
        console.log(slider1.noUiSlider.get());
        console.log(slider2.noUiSlider.get());
        console.log(slider1.noUiSlider.get() / slider2.noUiSlider.get());
        x = slider1.noUiSlider.get() / slider2.noUiSlider.get();

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

function setPreis(value) {
    var result = value;
    $('#preis').val(result);
    slider1Value.innerHTML = result;
    slider1.noUiSlider.set(result);
}

function setZeit(value) {
    var hour = 60;
    var result = value;
    $('#dauer').val(result);
    if (result >= hour) {
        slider2Value.innerHTML = Math.floor(result / hour) + (result < hour * 2 ? " " + i18n.attr('hour') + " " : " " + i18n.attr('hours') + " ") + (result - Math.floor(result / hour) * hour) + " " + i18n.attr('minutes');
    } else {
        slider2Value.innerHTML = Math.floor(result) + " " + i18n.attr('minutes');
    }
    slider2.noUiSlider.set(result);
}
