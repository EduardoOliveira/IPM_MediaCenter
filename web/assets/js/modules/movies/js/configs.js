'use strict';

angular.module('mediaCenter.movies.configs', [])
    .config(function ($stateProvider) {

        $stateProvider
            .state('movies', {
                url: '/movies',
                views: {
                    'main-view': {
                        templateUrl: '/assets/js/modules/core/templates/splitPane.html',
                        controller: function () {
                            console.log(2);
                        }
                    },
                    'leftPane@movies': {
                        controller: 'MovieListController',
                        templateUrl: '/assets/js/modules/core/templates/listComponent.html'
                    },
                    'rigthPane@movies': {
                        controller: 'MovieDetailsController',
                        templateUrl:'/assets/js/modules/core/templates/mediaDetails.html'
                    }
                }
            });
    });
