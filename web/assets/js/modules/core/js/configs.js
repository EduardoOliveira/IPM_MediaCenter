'use strict';

angular.module('mediaCenter.core.configs', [])
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state('home', {
                url: '/home',
                views: {
                    'main-view': {
                        controller: 'MainMenuController',
                        templateUrl: '/assets/js/modules/core/templates/mainMenu.html'
                    }
                }
            });
    });
