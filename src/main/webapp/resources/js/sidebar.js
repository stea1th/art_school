$(function () {

    manageSideBar();

    getUserImageForNavBar();

    initSideBar();

    hideSideBarByClickAndScroll();

    toggleSideBar();

    setSideBarCookieOnClassChanged();
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

function hideSideBarByClickAndScroll() {
    $('.card-body').on('click', function () {
        $('#wrapper').addClass('sidebar-toggle');

    });

    $(window).scroll(function () {
        console.log($('a[href="' + "/forum".replace("/", "") + '"]')[0].offsetTop);
        if ($('body')[0].scrollTop > 300) {
            $('#wrapper').addClass('sidebar-toggle');
        }
    });
}

// function setSideBarClosed(){
//     $('#wrapper').addClass('sidebar-toggle');
// }

function initSideBar() {
    new PerfectScrollbar('.list-scrollbar');
    let nanobar = new Nanobar();
    nanobar.go(100);
}

function toggleSideBar() {
    let status = getCookie("sidebar");
    const wrapper = $('#wrapper');
    if (status !== "") {
        if(status > 0){
            wrapper.removeClass('sidebar-toggle');
        } else {
            wrapper.addClass('sidebar-toggle');
        }
    } else {
        setCookie('sidebar', wrapper.hasClass('sidebar-toggle') ? 0 : 1, 365);
    }
}

function setSideBarCookieOnClassChanged(){
    const wrapper = $('#wrapper');
    wrapper.on('classChanged', function(){
        setCookie('sidebar', wrapper.hasClass('sidebar-toggle') ? 0 : 1, 365);
    });
}

(function( func ) {
    $.fn.addClass = function() { // replace the existing function on $.fn
        func.apply( this, arguments ); // invoke the original function
        this.trigger('classChanged'); // trigger the custom event
        return this; // retain jQuery chainability
    }
})($.fn.addClass); // pass the original function as an argument

(function( func ) {
    $.fn.removeClass = function() {
        func.apply( this, arguments );
        this.trigger('classChanged');
        return this;
    }
})($.fn.removeClass);



