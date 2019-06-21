$(function () {

    manageSideBar();

    getUserImageForNavBar();

    initSideBar();

    // hide sidebar by clicking is temporary out of order
    // hideSideBarByClick();

    toggleSideBar();

    toggleSideBarByUser();

    setSideBarCookieOnClassChanged();

    hideSideBarByScroll();
});

function getUserImageForNavBar() {
    if (location.pathname !== '/login') {
        $.get("/api/profile/my-image")
            .done(function (data) {
                let image;
                if (data !== '') {
                    image = document.createElement('img');
                    image.style.cssText = 'width:60px;height:60px;border-radius:50%;background-color:white;';
                    image.src = "data:image/jpeg;base64," + data;
                } else {
                    image = '<i class="fas fa-user-circle fa-3x blackiconcolor"></i>';
                }
                $('#userdetails').empty().html(image);
            });
    }
}

function manageSideBar() {
    const pathNames = ["/kind", "/zahlung", "/admin"];
    let path = $('a[href="' + location.pathname.replace("/", "") + '"]');
    $('a').removeClass('link-current');
    path.addClass('link-current');
    if (location.pathname === "/nachricht") {
        $('a[href="' + "/forum".replace("/", "") + '"]').addClass('link-current');
    }
    if (pathNames.includes(location.pathname)) {
        let selectedUl = path.closest('ul');
        selectedUl.css('display', 'block');
        let linkArrow = selectedUl.parent()[0].firstChild;
        $(linkArrow).addClass('transition active rotate');
    }
}

// function hideSideBarByClick() {
//     $('.card-body').on('click', function () {
//         closeSideBar();
//     });
// }

function hideSideBarByScroll() {

    $(window).scroll(function () {
        if (!$('#wrapper').hasClass('closed')) {
            let height = $('a[href="' + "/forum".replace("/", "") + '"]')[0].offsetTop;
            if ($('body')[0].scrollTop > height) {
                closeSideBar();
            } else {
                openSideBar();
            }
        }
    });
}

function toggleSideBar() {
    let status = getCookie("sidebar");
    if (status !== "") {
        if (status > 0) {
            openSideBar();
        } else {
            closeSideBar();
        }
    } else {
        setCookie('sidebar', setSideBarValue(), 365);
    }
}

function setSideBarCookieOnClassChanged() {
    $('#wrapper').on('classChanged', function () {
        setCookie('sidebar', setSideBarValue(), 365);
    });
}

function toggleSideBarByUser() {
    $('#sidebar-toggle').on('click', function () {
        const wrapper = $('#wrapper');
        console.log(wrapper.hasClass('sidebar-toggle'));
        if (wrapper.hasClass('sidebar-toggle')) {
            wrapper.addClass('closed');
        } else {
            wrapper.removeClass('closed');
        }
    });
}

function openSideBar() {
    $('#wrapper').removeClass('sidebar-toggle');
}

function closeSideBar() {
    $('#wrapper').addClass('sidebar-toggle');
}

function setSideBarValue() {
    return $('#wrapper').hasClass('sidebar-toggle') ? 0 : 1;
}

(function (func) {
    $.fn.addClass = function () { // replace the existing function on $.fn
        func.apply(this, arguments); // invoke the original function
        this.trigger('classChanged'); // trigger the custom event
        return this; // retain jQuery chainability
    }
})($.fn.addClass); // pass the original function as an argument

(function (func) {
    $.fn.removeClass = function () {
        func.apply(this, arguments);
        this.trigger('classChanged');
        return this;
    }
})($.fn.removeClass);

function initSideBar() {
    if (window.location.pathname !== "/login") {
        new PerfectScrollbar('.list-scrollbar');
        let nanobar = new Nanobar();
        nanobar.go(100);
    }
}
