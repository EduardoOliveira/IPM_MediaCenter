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
            }).state('movies', {
                url: '/movies',
                views: {
                    'main-view':{
                        controller:'',
                        templateUrl:'/assets/js/modules/core/templates/splitPane.html'
                    }
                }
            }).state('series', {}).state('music', {}).state('settings', {});
    });
