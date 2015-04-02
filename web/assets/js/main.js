'use strict';

angular.module('mediaCenter',
    [
        'ngResource',
        'LocalStorageModule',
        'ui.router',
        'cfp.hotkeys',
        'ngWebsocket',
        'mediaCenter.core',
        'mediaCenter.session',
        'mediaCenter.movies'
    ]
);

