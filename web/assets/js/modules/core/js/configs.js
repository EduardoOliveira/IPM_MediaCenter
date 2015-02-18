'use strict';

angular.module('mediaCenter.core.configs', [
    'mediaCenter.movies.controllers'
]).config(function ($stateProvider, $urlRouterProvider) {
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
                'main-view': {
                    controller: 'MovieListController',
                    templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                }
            }
        }).state('series', {}).state('music', {}).state('settings', {});
});
