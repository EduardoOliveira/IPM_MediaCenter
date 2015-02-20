function GraphicalNavigation() {

    this.activate = function (params) {
        console.log(params);
        console.log('[data-navigation-group="' + params.group + '"][data-navigation-id!="' + params.id + '"]');
        console.log('[data-navigation-group="' + params.group + '"][data-navigation-id="' + params.id + '"]');
        $('[data-navigation-group="' + params.group + '"][data-navigation-id].focused').removeClass('focused');
        $('[data-navigation-group="' + params.group + '"][data-navigation-id="' + params.id + '"]').addClass('focused');
    };

}