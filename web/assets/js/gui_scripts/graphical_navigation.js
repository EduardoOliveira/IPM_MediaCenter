function GraphicalNavigation() {

    this.focus = function (params) {
        params.current.removeClass('focused');
        params.next.addClass('focused');
    };

    this.open = function($element){
        $element.addClass("open");
    };

    this.close = function($element){
        $element.removeClass("open");
    };
}