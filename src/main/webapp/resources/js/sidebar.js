$(function(){

    manageSideBar();

    getUserImageForNavBar();

    initSideBar();

    hideSideBarByClickAndScroll();
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
    if (pathNames.includes(location.pathname)){
        let selectedUl = path.closest('ul');
        selectedUl.css('display', 'block');
        let linkArrow = selectedUl.parent()[0].firstChild;
        $(linkArrow).addClass('transition active rotate');
    }
}

function hideSideBarByClickAndScroll(){
    $('.card-body').on('click', function(){
        $('#wrapper').addClass('sidebar-toggle');

    });

    $(window).scroll(function(){
        console.log($('a[href="' + "/forum".replace("/", "") + '"]')[0].offsetTop);
        if ($('body')[0].scrollTop > 300 ) {
            $('#wrapper').addClass('sidebar-toggle');
        }
    });
}

// function setSideBarClosed(){
//     $('#wrapper').addClass('sidebar-toggle');
// }

function initSideBar(){
    new PerfectScrollbar('.list-scrollbar');
    let nanobar = new Nanobar();
    nanobar.go(100);
}