var didScroll;
var lastScrollTop = 0;
var navbarHeight = $('header').outerHeight();

$(window).scroll(function(event){
    didScroll = true;
});


setInterval(function() {
    if(didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop();

    if(st > navbarHeight && st > lastScrollTop) {
        $('.navbar-header').removeClass('scrolled-up').addClass('scrolled-down');
    }
    else {
        // Scroll Up
        if(st + $(window).height() < $(document).height()) {
            $('.navbar-header').removeClass('scrolled-down').addClass('scrolled-up');
        }
    }
    lastScrollTop = st;
}
