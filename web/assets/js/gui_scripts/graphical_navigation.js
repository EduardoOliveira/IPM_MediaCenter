function GraphicalNavigation() {

    this.focus = function (params) {
        params.current.removeClass('focused');
        params.next.addClass('focused');
    };

}