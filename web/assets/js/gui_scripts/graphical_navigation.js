function GraphicalNavigation() {

    this.focus = function (params) {
        $('[data-navigation-group="' + params.group + '"][data-navigation-id].focused').removeClass('focused');
        $('[data-navigation-group="' + params.group + '"][data-navigation-id="' + params.id + '"]').addClass('focused');
    };

}