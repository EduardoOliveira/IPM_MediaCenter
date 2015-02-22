'use strict';

angular.module('mediaCenter.movies.configs', [])
    .config(function ($stateProvider) {

        $stateProvider
            .state('movies', {
                url: '/movies',
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html'
                    },
                    'leftPane@movies': {
                        controller: 'MovieListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    },
                    "rightPane@movies": {
                        controller: 'MovieDetailsController',
                        templateUrl: '/assets/js/modules/core/templates/mediaDetails.html'
                    }
                }
            });
    });
